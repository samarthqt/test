/*
 *  © [2024] Qualitest. All rights reserved.
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.time.Duration;

/**
 * Performance monitor for tracking WebDriver operations
 * 
 * <h2>Features:</h2>
 * <ul>
 *   <li><strong>Operation Timing:</strong> Track execution time for each operation</li>
 *   <li><strong>Error Tracking:</strong> Monitor error rates and types</li>
 *   <li><strong>Performance Statistics:</strong> Calculate averages, min, max values</li>
 *   <li><strong>Real-time Monitoring:</strong> Live performance metrics</li>
 * </ul>
 * 
 * @author Qualitest
 * @version 2.1.0
 * @since 2024
 */
public class PerformanceMonitor {
    
    private final Map<String, OperationStats> operationStats = new ConcurrentHashMap<>();
    private final AtomicLong totalOperations = new AtomicLong(0);
    private final AtomicLong totalErrors = new AtomicLong(0);
    private final Instant startTime = Instant.now();
    
    /**
     * Statistics for a specific operation
     */
    public static class OperationStats {
        private final AtomicLong count = new AtomicLong(0);
        private final AtomicLong totalTime = new AtomicLong(0);
        private final AtomicLong minTime = new AtomicLong(Long.MAX_VALUE);
        private final AtomicLong maxTime = new AtomicLong(0);
        private final AtomicInteger errorCount = new AtomicInteger(0);
        private volatile long lastExecutionTime = 0;
        
        public void recordExecution(long durationMs) {
            count.incrementAndGet();
            totalTime.addAndGet(durationMs);
            lastExecutionTime = durationMs;
            
            // Update min time
            long currentMin = minTime.get();
            while (durationMs < currentMin && !minTime.compareAndSet(currentMin, durationMs)) {
                currentMin = minTime.get();
            }
            
            // Update max time
            long currentMax = maxTime.get();
            while (durationMs > currentMax && !maxTime.compareAndSet(currentMax, durationMs)) {
                currentMax = maxTime.get();
            }
        }
        
        public void recordError() {
            errorCount.incrementAndGet();
        }
        
        public long getCount() {
            return count.get();
        }
        
        public long getTotalTime() {
            return totalTime.get();
        }
        
        public long getMinTime() {
            return minTime.get() == Long.MAX_VALUE ? 0 : minTime.get();
        }
        
        public long getMaxTime() {
            return maxTime.get();
        }
        
        public int getErrorCount() {
            return errorCount.get();
        }
        
        public long getLastExecutionTime() {
            return lastExecutionTime;
        }
        
        public double getAverageTime() {
            long count = this.count.get();
            return count > 0 ? (double) totalTime.get() / count : 0.0;
        }
        
        public double getErrorRate() {
            long count = this.count.get();
            return count > 0 ? (double) errorCount.get() / count : 0.0;
        }
    }
    
    /**
     * Overall performance statistics
     */
    public static class PerformanceStats {
        private final Map<String, OperationStats> operationStats;
        private final long totalOperations;
        private final long totalErrors;
        private final Duration uptime;
        private final double overallErrorRate;
        private final double operationsPerSecond;
        
        public PerformanceStats(Map<String, OperationStats> operationStats, 
                             long totalOperations, long totalErrors, Duration uptime) {
            this.operationStats = new ConcurrentHashMap<>(operationStats);
            this.totalOperations = totalOperations;
            this.totalErrors = totalErrors;
            this.uptime = uptime;
            this.overallErrorRate = totalOperations > 0 ? (double) totalErrors / totalOperations : 0.0;
            this.operationsPerSecond = uptime.getSeconds() > 0 ? 
                (double) totalOperations / uptime.getSeconds() : 0.0;
        }
        
        public Map<String, OperationStats> getOperationStats() {
            return operationStats;
        }
        
        public long getTotalOperations() {
            return totalOperations;
        }
        
        public long getTotalErrors() {
            return totalErrors;
        }
        
        public Duration getUptime() {
            return uptime;
        }
        
        public double getOverallErrorRate() {
            return overallErrorRate;
        }
        
        public double getOperationsPerSecond() {
            return operationsPerSecond;
        }
        
        @Override
        public String toString() {
            return String.format("PerformanceStats{totalOperations=%d, totalErrors=%d, " +
                               "uptime=%s, errorRate=%.2f%%, opsPerSecond=%.2f}",
                               totalOperations, totalErrors, uptime, 
                               overallErrorRate * 100, operationsPerSecond);
        }
    }
    
    /**
     * Start monitoring an operation
     * 
     * @param operationName The name of the operation
     * @return OperationContext for tracking the operation
     */
    public OperationContext startOperation(String operationName) {
        return new OperationContext(operationName, Instant.now());
    }
    
    /**
     * End monitoring an operation
     * 
     * @param operationName The name of the operation
     */
    public void endOperation(String operationName) {
        OperationStats stats = operationStats.computeIfAbsent(operationName, k -> new OperationStats());
        long duration = Duration.between(Instant.now().minusNanos(1), Instant.now()).toMillis();
        stats.recordExecution(duration);
        totalOperations.incrementAndGet();
    }
    
    /**
     * Record an error for an operation
     * 
     * @param operationName The name of the operation
     * @param error The error that occurred
     */
    public void recordError(String operationName, Exception error) {
        OperationStats stats = operationStats.computeIfAbsent(operationName, k -> new OperationStats());
        stats.recordError();
        totalErrors.incrementAndGet();
    }
    
    /**
     * Get performance statistics
     * 
     * @return PerformanceStats containing all performance metrics
     */
    public PerformanceStats getStats() {
        Duration uptime = Duration.between(startTime, Instant.now());
        return new PerformanceStats(operationStats, totalOperations.get(), totalErrors.get(), uptime);
    }
    
    /**
     * Get statistics for a specific operation
     * 
     * @param operationName The name of the operation
     * @return OperationStats for the operation, or null if not found
     */
    public OperationStats getOperationStats(String operationName) {
        return operationStats.get(operationName);
    }
    
    /**
     * Reset all performance statistics
     */
    public void reset() {
        operationStats.clear();
        totalOperations.set(0);
        totalErrors.set(0);
    }
    
    /**
     * Get a summary of performance metrics
     * 
     * @return String summary of performance metrics
     */
    public String getSummary() {
        PerformanceStats stats = getStats();
        StringBuilder summary = new StringBuilder();
        summary.append("Performance Summary:\n");
        summary.append(String.format("Total Operations: %d\n", stats.getTotalOperations()));
        summary.append(String.format("Total Errors: %d\n", stats.getTotalErrors()));
        summary.append(String.format("Error Rate: %.2f%%\n", stats.getOverallErrorRate() * 100));
        summary.append(String.format("Operations/Second: %.2f\n", stats.getOperationsPerSecond()));
        summary.append(String.format("Uptime: %s\n", stats.getUptime()));
        
        summary.append("\nOperation Details:\n");
        for (Map.Entry<String, OperationStats> entry : stats.getOperationStats().entrySet()) {
            OperationStats opStats = entry.getValue();
            summary.append(String.format("  %s: count=%d, avg=%.2fms, min=%dms, max=%dms, errors=%d\n",
                    entry.getKey(), opStats.getCount(), opStats.getAverageTime(),
                    opStats.getMinTime(), opStats.getMaxTime(), opStats.getErrorCount()));
        }
        
        return summary.toString();
    }
    
    /**
     * Context for tracking individual operations
     */
    public static class OperationContext {
        private final String operationName;
        private final Instant startTime;
        
        public OperationContext(String operationName, Instant startTime) {
            this.operationName = operationName;
            this.startTime = startTime;
        }
        
        /**
         * End the operation and record the timing
         * 
         * @param monitor The performance monitor to record with
         */
        public void end(PerformanceMonitor monitor) {
            long duration = Duration.between(startTime, Instant.now()).toMillis();
            OperationStats stats = monitor.operationStats.computeIfAbsent(operationName, k -> new OperationStats());
            stats.recordExecution(duration);
            monitor.totalOperations.incrementAndGet();
        }
        
        /**
         * Record an error for this operation
         * 
         * @param monitor The performance monitor to record with
         * @param error The error that occurred
         */
        public void recordError(PerformanceMonitor monitor, Exception error) {
            OperationStats stats = monitor.operationStats.computeIfAbsent(operationName, k -> new OperationStats());
            stats.recordError();
            monitor.totalErrors.incrementAndGet();
        }
    }
}