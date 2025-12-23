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
package com.framework.components;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.time.Duration;

/**
 * Execution Time Tracker for performance monitoring and optimization
 * 
 * <p>This class provides comprehensive execution time tracking for test automation
 * with detailed analytics and performance insights.</p>
 * 
 * @author Qualitest
 * @version 2.0.1
 * @since 2022
 */
public class ExecutionTimeTracker {
    
    private static final Map<String, ExecutionRecord> executionRecords = new ConcurrentHashMap<>();
    private static final AtomicLong totalExecutionTime = new AtomicLong(0);
    private static final AtomicLong totalExecutions = new AtomicLong(0);
    private static final AtomicLong slowExecutions = new AtomicLong(0);
    private static final AtomicLong fastExecutions = new AtomicLong(0);
    
    // Performance thresholds (in milliseconds)
    private static final long SLOW_EXECUTION_THRESHOLD = 30000; // 30 seconds
    private static final long FAST_EXECUTION_THRESHOLD = 5000;  // 5 seconds
    
    /**
     * Execution record for tracking individual test performance
     */
    public static class ExecutionRecord {
        private final String testName;
        private final String testClass;
        private final Instant startTime;
        private final Instant endTime;
        private final long executionTime;
        private final String browser;
        private final String environment;
        private final boolean passed;
        private final String failureReason;
        private final Map<String, Object> metadata;
        
        public ExecutionRecord(String testName, String testClass, Instant startTime, 
                             Instant endTime, String browser, String environment, 
                             boolean passed, String failureReason) {
            this.testName = testName;
            this.testClass = testClass;
            this.startTime = startTime;
            this.endTime = endTime;
            this.executionTime = Duration.between(startTime, endTime).toMillis();
            this.browser = browser;
            this.environment = environment;
            this.passed = passed;
            this.failureReason = failureReason;
            this.metadata = new ConcurrentHashMap<>();
        }
        
        // Getters
        public String getTestName() { return testName; }
        public String getTestClass() { return testClass; }
        public Instant getStartTime() { return startTime; }
        public Instant getEndTime() { return endTime; }
        public long getExecutionTime() { return executionTime; }
        public String getBrowser() { return browser; }
        public String getEnvironment() { return environment; }
        public boolean isPassed() { return passed; }
        public String getFailureReason() { return failureReason; }
        public Map<String, Object> getMetadata() { return metadata; }
        
        /**
         * Add metadata to the execution record
         */
        public void addMetadata(String key, Object value) {
            metadata.put(key, value);
        }
        
        /**
         * Get execution time as Duration
         */
        public Duration getExecutionDuration() {
            return Duration.ofMillis(executionTime);
        }
        
        /**
         * Check if execution was slow
         */
        public boolean isSlowExecution() {
            return executionTime > SLOW_EXECUTION_THRESHOLD;
        }
        
        /**
         * Check if execution was fast
         */
        public boolean isFastExecution() {
            return executionTime < FAST_EXECUTION_THRESHOLD;
        }
        
        @Override
        public String toString() {
            return String.format("ExecutionRecord{testName='%s', executionTime=%dms, passed=%s}", 
                testName, executionTime, passed);
        }
    }
    
    /**
     * Start tracking execution time for a test
     * 
     * @param testName The name of the test
     * @param testClass The class containing the test
     * @param browser The browser used for execution
     * @param environment The environment (qa, prod, etc.)
     * @return The execution record key
     * 
     * @example
     * <pre>{@code
     * String key = ExecutionTimeTracker.startExecution("LoginTest", "LoginTestClass", "chrome", "qa");
     * // ... test execution ...
     * ExecutionTimeTracker.endExecution(key, true, null);
     * }</pre>
     */
    public static String startExecution(String testName, String testClass, String browser, String environment) {
        String key = generateExecutionKey(testName, testClass);
        ExecutionRecord record = new ExecutionRecord(testName, testClass, Instant.now(), 
            Instant.now(), browser, environment, false, null);
        executionRecords.put(key, record);
        return key;
    }
    
    /**
     * End tracking execution time for a test
     * 
     * @param key The execution key returned from startExecution
     * @param passed Whether the test passed
     * @param failureReason Reason for failure (if any)
     * @return The completed execution record
     */
    public static ExecutionRecord endExecution(String key, boolean passed, String failureReason) {
        ExecutionRecord record = executionRecords.get(key);
        if (record != null) {
            // Create new record with end time
            ExecutionRecord completedRecord = new ExecutionRecord(
                record.getTestName(), record.getTestClass(), record.getStartTime(),
                Instant.now(), record.getBrowser(), record.getEnvironment(),
                passed, failureReason
            );
            
            // Update statistics
            updateStatistics(completedRecord);
            
            // Replace the record
            executionRecords.put(key, completedRecord);
            return completedRecord;
        }
        return null;
    }
    
    /**
     * Get execution statistics
     * 
     * @return Execution statistics as a formatted string
     * 
     * @example
     * <pre>{@code
     * String stats = ExecutionTimeTracker.getExecutionStatistics();
     * System.out.println(stats);
     * }</pre>
     */
    public static String getExecutionStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append("Execution Time Statistics:\n");
        stats.append("Total Executions: ").append(totalExecutions.get()).append("\n");
        stats.append("Total Execution Time: ").append(formatDuration(Duration.ofMillis(totalExecutionTime.get()))).append("\n");
        stats.append("Average Execution Time: ").append(formatDuration(Duration.ofMillis(getAverageExecutionTime()))).append("\n");
        stats.append("Fast Executions (<5s): ").append(fastExecutions.get()).append("\n");
        stats.append("Slow Executions (>30s): ").append(slowExecutions.get()).append("\n");
        stats.append("Success Rate: ").append(String.format("%.2f%%", getSuccessRate())).append("\n");
        return stats.toString();
    }
    
    /**
     * Get average execution time in milliseconds
     * 
     * @return Average execution time
     */
    public static long getAverageExecutionTime() {
        long total = totalExecutions.get();
        return total > 0 ? totalExecutionTime.get() / total : 0;
    }
    
    /**
     * Get success rate as percentage
     * 
     * @return Success rate percentage
     */
    public static double getSuccessRate() {
        long total = totalExecutions.get();
        if (total == 0) return 0.0;
        
        long successful = executionRecords.values().stream()
            .filter(ExecutionRecord::isPassed)
            .count();
        
        return (double) successful / total * 100;
    }
    
    /**
     * Get slowest executions
     * 
     * @param limit Number of slowest executions to return
     * @return List of slowest execution records
     */
    public static List<ExecutionRecord> getSlowestExecutions(int limit) {
        List<ExecutionRecord> records = new ArrayList<>(executionRecords.values());
        records.sort((r1, r2) -> Long.compare(r2.getExecutionTime(), r1.getExecutionTime()));
        return records.subList(0, Math.min(limit, records.size()));
    }
    
    /**
     * Get fastest executions
     * 
     * @param limit Number of fastest executions to return
     * @return List of fastest execution records
     */
    public static List<ExecutionRecord> getFastestExecutions(int limit) {
        List<ExecutionRecord> records = new ArrayList<>(executionRecords.values());
        records.sort((r1, r2) -> Long.compare(r1.getExecutionTime(), r2.getExecutionTime()));
        return records.subList(0, Math.min(limit, records.size()));
    }
    
    /**
     * Get executions by browser
     * 
     * @param browser The browser to filter by
     * @return List of executions for the specified browser
     */
    public static List<ExecutionRecord> getExecutionsByBrowser(String browser) {
        return executionRecords.values().stream()
            .filter(record -> browser.equals(record.getBrowser()))
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    /**
     * Get executions by environment
     * 
     * @param environment The environment to filter by
     * @return List of executions for the specified environment
     */
    public static List<ExecutionRecord> getExecutionsByEnvironment(String environment) {
        return executionRecords.values().stream()
            .filter(record -> environment.equals(record.getEnvironment()))
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    /**
     * Get failed executions
     * 
     * @return List of failed execution records
     */
    public static List<ExecutionRecord> getFailedExecutions() {
        return executionRecords.values().stream()
            .filter(record -> !record.isPassed())
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    /**
     * Get performance recommendations based on execution data
     * 
     * @return List of performance recommendations
     */
    public static List<String> getPerformanceRecommendations() {
        List<String> recommendations = new ArrayList<>();
        
        double avgTime = getAverageExecutionTime();
        double successRate = getSuccessRate();
        long slowCount = slowExecutions.get();
        long totalCount = totalExecutions.get();
        
        if (avgTime > 15000) {
            recommendations.add("Consider optimizing test execution time - average is " + formatDuration(Duration.ofMillis((long) avgTime)));
        }
        
        if (successRate < 90.0) {
            recommendations.add("Focus on improving test stability - success rate is " + String.format("%.1f%%", successRate));
        }
        
        if (slowCount > totalCount * 0.1) {
            recommendations.add("High number of slow executions detected - consider parallel execution or test optimization");
        }
        
        if (recommendations.isEmpty()) {
            recommendations.add("Performance looks good! No specific recommendations at this time.");
        }
        
        return recommendations;
    }
    
    /**
     * Clear all execution records
     */
    public static void clearRecords() {
        executionRecords.clear();
        totalExecutionTime.set(0);
        totalExecutions.set(0);
        slowExecutions.set(0);
        fastExecutions.set(0);
    }
    
    /**
     * Get all execution records
     * 
     * @return Map of all execution records
     */
    public static Map<String, ExecutionRecord> getAllRecords() {
        return Collections.unmodifiableMap(executionRecords);
    }
    
    /**
     * Generate execution key
     */
    private static String generateExecutionKey(String testName, String testClass) {
        return testClass + "." + testName + "_" + System.currentTimeMillis();
    }
    
    /**
     * Update execution statistics
     */
    private static void updateStatistics(ExecutionRecord record) {
        totalExecutionTime.addAndGet(record.getExecutionTime());
        totalExecutions.incrementAndGet();
        
        if (record.isSlowExecution()) {
            slowExecutions.incrementAndGet();
        }
        
        if (record.isFastExecution()) {
            fastExecutions.incrementAndGet();
        }
    }
    
    /**
     * Format duration for display
     */
    private static String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long minutes = seconds / 60;
        seconds = seconds % 60;
        long millis = duration.toMillis() % 1000;
        
        if (minutes > 0) {
            return String.format("%dm %ds %dms", minutes, seconds, millis);
        } else if (seconds > 0) {
            return String.format("%ds %dms", seconds, millis);
        } else {
            return String.format("%dms", millis);
        }
    }
} 