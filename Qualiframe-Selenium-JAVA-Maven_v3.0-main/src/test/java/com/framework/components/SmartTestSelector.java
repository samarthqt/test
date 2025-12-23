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

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.io.IOException;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Smart Test Selector using AI/ML concepts for intelligent test selection and maintenance
 * 
 * @author Qualitest
 */
public class SmartTestSelector {
    
    private static final String TEST_HISTORY_FILE = "test_execution_history.json";
    private static final String TEST_PATTERNS_FILE = "test_patterns.json";
    private static final String FAILURE_PATTERNS_FILE = "failure_patterns.json";
    
    private static Map<String, TestExecutionRecord> testHistory = new ConcurrentHashMap<>();
    private static Map<String, TestPattern> testPatterns = new ConcurrentHashMap<>();
    private static Map<String, FailurePattern> failurePatterns = new ConcurrentHashMap<>();
    
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    /**
     * Test execution record for tracking test performance
     */
    public static class TestExecutionRecord {
        private String testName;
        private String testClass;
        private String tags;
        private long executionTime;
        private boolean passed;
        private String failureReason;
        private LocalDateTime executionDate;
        private String browser;
        private String environment;
        private Map<String, String> metadata;
        
        public TestExecutionRecord() {
            this.metadata = new HashMap<>();
            this.executionDate = LocalDateTime.now();
        }
        
        // Getters and setters
        public String getTestName() { return testName; }
        public void setTestName(String testName) { this.testName = testName; }
        
        public String getTestClass() { return testClass; }
        public void setTestClass(String testClass) { this.testClass = testClass; }
        
        public String getTags() { return tags; }
        public void setTags(String tags) { this.tags = tags; }
        
        public long getExecutionTime() { return executionTime; }
        public void setExecutionTime(long executionTime) { this.executionTime = executionTime; }
        
        public boolean isPassed() { return passed; }
        public void setPassed(boolean passed) { this.passed = passed; }
        
        public String getFailureReason() { return failureReason; }
        public void setFailureReason(String failureReason) { this.failureReason = failureReason; }
        
        public LocalDateTime getExecutionDate() { return executionDate; }
        public void setExecutionDate(LocalDateTime executionDate) { this.executionDate = executionDate; }
        
        public String getBrowser() { return browser; }
        public void setBrowser(String browser) { this.browser = browser; }
        
        public String getEnvironment() { return environment; }
        public void setEnvironment(String environment) { this.environment = environment; }
        
        public Map<String, String> getMetadata() { return metadata; }
        public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }
    }
    
    /**
     * Test pattern for identifying test behavior patterns
     */
    public static class TestPattern {
        private String testName;
        private double successRate;
        private double averageExecutionTime;
        private int totalExecutions;
        private int failureCount;
        private List<String> commonFailureReasons;
        private Map<String, Double> browserSuccessRates;
        private Map<String, Double> environmentSuccessRates;
        
        public TestPattern() {
            this.commonFailureReasons = new ArrayList<>();
            this.browserSuccessRates = new HashMap<>();
            this.environmentSuccessRates = new HashMap<>();
        }
        
        // Getters and setters
        public String getTestName() { return testName; }
        public void setTestName(String testName) { this.testName = testName; }
        
        public double getSuccessRate() { return successRate; }
        public void setSuccessRate(double successRate) { this.successRate = successRate; }
        
        public double getAverageExecutionTime() { return averageExecutionTime; }
        public void setAverageExecutionTime(double averageExecutionTime) { this.averageExecutionTime = averageExecutionTime; }
        
        public int getTotalExecutions() { return totalExecutions; }
        public void setTotalExecutions(int totalExecutions) { this.totalExecutions = totalExecutions; }
        
        public int getFailureCount() { return failureCount; }
        public void setFailureCount(int failureCount) { this.failureCount = failureCount; }
        
        public List<String> getCommonFailureReasons() { return commonFailureReasons; }
        public void setCommonFailureReasons(List<String> commonFailureReasons) { this.commonFailureReasons = commonFailureReasons; }
        
        public Map<String, Double> getBrowserSuccessRates() { return browserSuccessRates; }
        public void setBrowserSuccessRates(Map<String, Double> browserSuccessRates) { this.browserSuccessRates = browserSuccessRates; }
        
        public Map<String, Double> getEnvironmentSuccessRates() { return environmentSuccessRates; }
        public void setEnvironmentSuccessRates(Map<String, Double> environmentSuccessRates) { this.environmentSuccessRates = environmentSuccessRates; }
    }
    
    /**
     * Failure pattern for identifying common failure patterns
     */
    public static class FailurePattern {
        private String patternId;
        private String failureType;
        private String failureDescription;
        private int occurrenceCount;
        private double impactScore;
        private List<String> affectedTests;
        private Map<String, Integer> browserOccurrences;
        private Map<String, Integer> environmentOccurrences;
        
        public FailurePattern() {
            this.affectedTests = new ArrayList<>();
            this.browserOccurrences = new HashMap<>();
            this.environmentOccurrences = new HashMap<>();
        }
        
        // Getters and setters
        public String getPatternId() { return patternId; }
        public void setPatternId(String patternId) { this.patternId = patternId; }
        
        public String getFailureType() { return failureType; }
        public void setFailureType(String failureType) { this.failureType = failureType; }
        
        public String getFailureDescription() { return failureDescription; }
        public void setFailureDescription(String failureDescription) { this.failureDescription = failureDescription; }
        
        public int getOccurrenceCount() { return occurrenceCount; }
        public void setOccurrenceCount(int occurrenceCount) { this.occurrenceCount = occurrenceCount; }
        
        public double getImpactScore() { return impactScore; }
        public void setImpactScore(double impactScore) { this.impactScore = impactScore; }
        
        public List<String> getAffectedTests() { return affectedTests; }
        public void setAffectedTests(List<String> affectedTests) { this.affectedTests = affectedTests; }
        
        public Map<String, Integer> getBrowserOccurrences() { return browserOccurrences; }
        public void setBrowserOccurrences(Map<String, Integer> browserOccurrences) { this.browserOccurrences = browserOccurrences; }
        
        public Map<String, Integer> getEnvironmentOccurrences() { return environmentOccurrences; }
        public void setEnvironmentOccurrences(Map<String, Integer> environmentOccurrences) { this.environmentOccurrences = environmentOccurrences; }
    }
    
    /**
     * Initialize the Smart Test Selector
     */
    public static void initialize() {
        loadTestHistory();
        loadTestPatterns();
        loadFailurePatterns();
        updatePatterns();
    }
    
    /**
     * Record test execution for analysis
     */
    public static void recordTestExecution(TestExecutionRecord record) {
        String key = record.getTestName() + "_" + record.getExecutionDate().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        testHistory.put(key, record);
        
        // Update patterns
        updateTestPattern(record);
        updateFailurePattern(record);
        
        // Save to file periodically
        if (testHistory.size() % 10 == 0) {
            saveTestHistory();
        }
    }
    
    /**
     * Get recommended tests based on current context
     */
    public static List<String> getRecommendedTests(String browser, String environment, int maxTests) {
        List<String> recommendations = new ArrayList<>();
        
        // Calculate test scores based on patterns
        Map<String, Double> testScores = calculateTestScores(browser, environment);
        
        // Sort by score and return top recommendations
        testScores.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(maxTests)
            .forEach(entry -> recommendations.add(entry.getKey()));
        
        return recommendations;
    }
    
    /**
     * Get tests that need attention (high failure rate, long execution time)
     */
    public static List<String> getTestsNeedingAttention() {
        List<String> attentionTests = new ArrayList<>();
        
        for (TestPattern pattern : testPatterns.values()) {
            if (pattern.getSuccessRate() < 0.8 || pattern.getAverageExecutionTime() > 30000) {
                attentionTests.add(pattern.getTestName());
            }
        }
        
        return attentionTests;
    }
    
    /**
     * Get failure patterns for analysis
     */
    public static List<FailurePattern> getFailurePatterns() {
        return new ArrayList<>(failurePatterns.values());
    }
    
    /**
     * Calculate test scores based on patterns
     */
    private static Map<String, Double> calculateTestScores(String browser, String environment) {
        Map<String, Double> scores = new HashMap<>();
        
        for (TestPattern pattern : testPatterns.values()) {
            double score = 0.0;
            
            // Base score from success rate
            score += pattern.getSuccessRate() * 0.4;
            
            // Browser-specific score
            Double browserRate = pattern.getBrowserSuccessRates().get(browser);
            if (browserRate != null) {
                score += browserRate * 0.3;
            }
            
            // Environment-specific score
            Double envRate = pattern.getEnvironmentSuccessRates().get(environment);
            if (envRate != null) {
                score += envRate * 0.3;
            }
            
            scores.put(pattern.getTestName(), score);
        }
        
        return scores;
    }
    
    /**
     * Update test patterns based on new execution record
     */
    private static void updateTestPattern(TestExecutionRecord record) {
        TestPattern pattern = testPatterns.get(record.getTestName());
        if (pattern == null) {
            pattern = new TestPattern();
            pattern.setTestName(record.getTestName());
            testPatterns.put(record.getTestName(), pattern);
        }
        
        // Update statistics
        pattern.setTotalExecutions(pattern.getTotalExecutions() + 1);
        if (!record.isPassed()) {
            pattern.setFailureCount(pattern.getFailureCount() + 1);
        }
        
        // Update success rate
        pattern.setSuccessRate((double) (pattern.getTotalExecutions() - pattern.getFailureCount()) / pattern.getTotalExecutions());
        
        // Update average execution time
        double newAvg = (pattern.getAverageExecutionTime() * (pattern.getTotalExecutions() - 1) + record.getExecutionTime()) / pattern.getTotalExecutions();
        pattern.setAverageExecutionTime(newAvg);
        
        // Update browser-specific rates
        updateBrowserSuccessRate(pattern, record);
        
        // Update environment-specific rates
        updateEnvironmentSuccessRate(pattern, record);
    }
    
    /**
     * Update failure patterns
     */
    private static void updateFailurePattern(TestExecutionRecord record) {
        if (record.isPassed()) {
            return;
        }
        
        String failureKey = record.getFailureReason();
        if (failureKey == null || failureKey.isEmpty()) {
            failureKey = "Unknown";
        }
        
        FailurePattern pattern = failurePatterns.get(failureKey);
        if (pattern == null) {
            pattern = new FailurePattern();
            pattern.setPatternId(failureKey);
            pattern.setFailureDescription(record.getFailureReason());
            failurePatterns.put(failureKey, pattern);
        }
        
        pattern.setOccurrenceCount(pattern.getOccurrenceCount() + 1);
        
        if (!pattern.getAffectedTests().contains(record.getTestName())) {
            pattern.getAffectedTests().add(record.getTestName());
        }
        
        // Update browser occurrences
        pattern.getBrowserOccurrences().merge(record.getBrowser(), 1, Integer::sum);
        
        // Update environment occurrences
        pattern.getEnvironmentOccurrences().merge(record.getEnvironment(), 1, Integer::sum);
        
        // Calculate impact score
        pattern.setImpactScore(calculateImpactScore(pattern));
    }
    
    /**
     * Calculate impact score for failure pattern
     */
    private static double calculateImpactScore(FailurePattern pattern) {
        double score = pattern.getOccurrenceCount() * 0.4;
        score += pattern.getAffectedTests().size() * 0.3;
        score += pattern.getBrowserOccurrences().size() * 0.2;
        score += pattern.getEnvironmentOccurrences().size() * 0.1;
        return score;
    }
    
    /**
     * Update browser success rate
     */
    private static void updateBrowserSuccessRate(TestPattern pattern, TestExecutionRecord record) {
        Map<String, Integer> browserExecutions = new HashMap<>();
        Map<String, Integer> browserFailures = new HashMap<>();
        
        // Count executions and failures for this browser
        for (TestExecutionRecord histRecord : testHistory.values()) {
            if (histRecord.getTestName().equals(pattern.getTestName()) && histRecord.getBrowser().equals(record.getBrowser())) {
                browserExecutions.merge(histRecord.getBrowser(), 1, Integer::sum);
                if (!histRecord.isPassed()) {
                    browserFailures.merge(histRecord.getBrowser(), 1, Integer::sum);
                }
            }
        }
        
        int totalExecutions = browserExecutions.getOrDefault(record.getBrowser(), 0);
        int totalFailures = browserFailures.getOrDefault(record.getBrowser(), 0);
        
        if (totalExecutions > 0) {
            double successRate = (double) (totalExecutions - totalFailures) / totalExecutions;
            pattern.getBrowserSuccessRates().put(record.getBrowser(), successRate);
        }
    }
    
    /**
     * Update environment success rate
     */
    private static void updateEnvironmentSuccessRate(TestPattern pattern, TestExecutionRecord record) {
        Map<String, Integer> envExecutions = new HashMap<>();
        Map<String, Integer> envFailures = new HashMap<>();
        
        // Count executions and failures for this environment
        for (TestExecutionRecord histRecord : testHistory.values()) {
            if (histRecord.getTestName().equals(pattern.getTestName()) && histRecord.getEnvironment().equals(record.getEnvironment())) {
                envExecutions.merge(histRecord.getEnvironment(), 1, Integer::sum);
                if (!histRecord.isPassed()) {
                    envFailures.merge(histRecord.getEnvironment(), 1, Integer::sum);
                }
            }
        }
        
        int totalExecutions = envExecutions.getOrDefault(record.getEnvironment(), 0);
        int totalFailures = envFailures.getOrDefault(record.getEnvironment(), 0);
        
        if (totalExecutions > 0) {
            double successRate = (double) (totalExecutions - totalFailures) / totalExecutions;
            pattern.getEnvironmentSuccessRates().put(record.getEnvironment(), successRate);
        }
    }
    
    /**
     * Update all patterns from history
     */
    private static void updatePatterns() {
        testPatterns.clear();
        failurePatterns.clear();
        
        for (TestExecutionRecord record : testHistory.values()) {
            updateTestPattern(record);
            updateFailurePattern(record);
        }
    }
    
    /**
     * Load test history from file
     */
    private static void loadTestHistory() {
        try {
            File file = new File(TEST_HISTORY_FILE);
            if (file.exists()) {
                try (FileReader reader = new FileReader(file)) {
                    Map<String, TestExecutionRecord> loaded = gson.fromJson(reader, 
                        new TypeToken<Map<String, TestExecutionRecord>>(){}.getType());
                    if (loaded != null) {
                        testHistory.putAll(loaded);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading test history: " + e.getMessage());
        }
    }
    
    /**
     * Save test history to file
     */
    private static void saveTestHistory() {
        try (FileWriter writer = new FileWriter(TEST_HISTORY_FILE)) {
            gson.toJson(testHistory, writer);
        } catch (IOException e) {
            System.err.println("Error saving test history: " + e.getMessage());
        }
    }
    
    /**
     * Load test patterns from file
     */
    private static void loadTestPatterns() {
        try {
            File file = new File(TEST_PATTERNS_FILE);
            if (file.exists()) {
                try (FileReader reader = new FileReader(file)) {
                    Map<String, TestPattern> loaded = gson.fromJson(reader, 
                        new TypeToken<Map<String, TestPattern>>(){}.getType());
                    if (loaded != null) {
                        testPatterns.putAll(loaded);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading test patterns: " + e.getMessage());
        }
    }
    
    /**
     * Load failure patterns from file
     */
    private static void loadFailurePatterns() {
        try {
            File file = new File(FAILURE_PATTERNS_FILE);
            if (file.exists()) {
                try (FileReader reader = new FileReader(file)) {
                    Map<String, FailurePattern> loaded = gson.fromJson(reader, 
                        new TypeToken<Map<String, FailurePattern>>(){}.getType());
                    if (loaded != null) {
                        failurePatterns.putAll(loaded);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading failure patterns: " + e.getMessage());
        }
    }
} 