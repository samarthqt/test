/*
 *  © [2022] Qualitest. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.framework.selenium;

import java.time.Duration;
import java.time.Instant;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.components.Settings;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

/**
 * Performance optimization utilities for enhanced test execution
 * 
 * @author Qualitest
 */
public class PerformanceOptimizer {
    
    private static final AtomicInteger activeThreads = new AtomicInteger(0);
    private static final AtomicLong totalExecutionTime = new AtomicLong(0);
    private static final AtomicInteger completedTests = new AtomicInteger(0);
    private static final AtomicInteger failedTests = new AtomicInteger(0);
    
    private static ExecutorService executorService;
    private static final int DEFAULT_THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    
    /**
     * Initialize the performance optimizer with custom thread pool size
     */
    public static void initialize(int threadPoolSize) {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        
        int poolSize = threadPoolSize > 0 ? threadPoolSize : DEFAULT_THREAD_POOL_SIZE;
        executorService = Executors.newFixedThreadPool(poolSize);
        
        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executorService.shutdownNow();
                }
            }
        }));
    }
    
    /**
     * Initialize with default thread pool size
     */
    public static void initialize() {
        initialize(DEFAULT_THREAD_POOL_SIZE);
    }
    
    /**
     * Execute a test task asynchronously with performance monitoring
     */
    public static CompletableFuture<Void> executeAsync(Runnable testTask, String testName) {
        if (executorService == null) {
            initialize();
        }
        
        return CompletableFuture.runAsync(() -> {
            Instant startTime = Instant.now();
            activeThreads.incrementAndGet();
            
            try {
                testTask.run();
                completedTests.incrementAndGet();
            } catch (Exception e) {
                failedTests.incrementAndGet();
                throw e;
            } finally {
                long executionTime = Duration.between(startTime, Instant.now()).toMillis();
                totalExecutionTime.addAndGet(executionTime);
                activeThreads.decrementAndGet();
                
                // Log performance metrics
                logPerformanceMetrics(testName, executionTime);
            }
        }, executorService);
    }
    
    /**
     * Optimize WebDriver wait times based on application performance
     */
    public static WebDriverWait createOptimizedWait(WebDriver driver) {
        Properties properties = Settings.getInstance();
        int timeout = Integer.parseInt(properties.getProperty("Timeout", "30"));
        
        // Dynamic timeout adjustment based on performance
        int optimizedTimeout = calculateOptimizedTimeout(timeout);
        
        return new WebDriverWait(driver, Duration.ofSeconds(optimizedTimeout));
    }
    
    /**
     * Calculate optimized timeout based on historical performance
     */
    private static int calculateOptimizedTimeout(int baseTimeout) {
        if (completedTests.get() == 0) {
            return baseTimeout;
        }
        
        long avgExecutionTime = totalExecutionTime.get() / completedTests.get();
        long avgExecutionTimeSeconds = avgExecutionTime / 1000;
        
        // Adjust timeout based on average execution time
        if (avgExecutionTimeSeconds < baseTimeout * 0.5) {
            return Math.max(10, baseTimeout - 10); // Reduce timeout if performance is good
        } else if (avgExecutionTimeSeconds > baseTimeout * 0.8) {
            return baseTimeout + 10; // Increase timeout if performance is slow
        }
        
        return baseTimeout;
    }
    
    /**
     * Get current performance statistics
     */
    public static PerformanceStats getPerformanceStats() {
        return new PerformanceStats(
            activeThreads.get(),
            completedTests.get(),
            failedTests.get(),
            totalExecutionTime.get(),
            executorService != null ? ((ThreadPoolExecutor) executorService).getPoolSize() : 0,
            executorService != null ? ((ThreadPoolExecutor) executorService).getQueue().size() : 0
        );
    }
    
    /**
     * Log performance metrics
     */
    private static void logPerformanceMetrics(String testName, long executionTime) {
        // Log to framework's logging system
        System.out.printf("[PERFORMANCE] Test: %s, Execution Time: %dms, Active Threads: %d%n", 
            testName, executionTime, activeThreads.get());
    }
    
    /**
     * Shutdown the performance optimizer
     */
    public static void shutdown() {
        if (executorService != null) {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        }
    }
    
    /**
     * Performance statistics container
     */
    public static class PerformanceStats {
        private final int activeThreads;
        private final int completedTests;
        private final int failedTests;
        private final long totalExecutionTime;
        private final int poolSize;
        private final int queueSize;
        
        public PerformanceStats(int activeThreads, int completedTests, int failedTests, 
                             long totalExecutionTime, int poolSize, int queueSize) {
            this.activeThreads = activeThreads;
            this.completedTests = completedTests;
            this.failedTests = failedTests;
            this.totalExecutionTime = totalExecutionTime;
            this.poolSize = poolSize;
            this.queueSize = queueSize;
        }
        
        public int getActiveThreads() { return activeThreads; }
        public int getCompletedTests() { return completedTests; }
        public int getFailedTests() { return failedTests; }
        public long getTotalExecutionTime() { return totalExecutionTime; }
        public int getPoolSize() { return poolSize; }
        public int getQueueSize() { return queueSize; }
        
        public double getAverageExecutionTime() {
            return completedTests > 0 ? (double) totalExecutionTime / completedTests : 0;
        }
        
        public double getSuccessRate() {
            int totalTests = completedTests + failedTests;
            return totalTests > 0 ? (double) completedTests / totalTests * 100 : 0;
        }
        
        @Override
        public String toString() {
            return String.format(
                "PerformanceStats{activeThreads=%d, completedTests=%d, failedTests=%d, " +
                "avgExecutionTime=%.2fms, successRate=%.2f%%, poolSize=%d, queueSize=%d}",
                activeThreads, completedTests, failedTests, getAverageExecutionTime(), 
                getSuccessRate(), poolSize, queueSize
            );
        }
    }
} 