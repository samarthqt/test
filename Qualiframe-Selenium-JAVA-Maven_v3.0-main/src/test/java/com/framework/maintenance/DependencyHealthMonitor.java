package com.framework.maintenance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.File;

/**
 * Dependency Health Monitor for QualiFrameV2 Framework
 * Monitors and reports on framework dependency health
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class DependencyHealthMonitor {
    
    private static final Logger logger = Logger.getLogger(DependencyHealthMonitor.class.getName());
    private static DependencyHealthMonitor instance;
    
    private Map<String, DependencyInfo> dependencies;
    private List<HealthIssue> healthIssues;
    private boolean monitoring = false;
    
    private DependencyHealthMonitor() {
        dependencies = new HashMap<>();
        healthIssues = new ArrayList<>();
        initializeDependencies();
    }
    
    public static DependencyHealthMonitor getInstance() {
        if (instance == null) {
            instance = new DependencyHealthMonitor();
        }
        return instance;
    }
    
    /**
     * Initialize dependency information
     */
    private void initializeDependencies() {
        // Core dependencies
        addDependency("selenium", "org.seleniumhq.selenium", "4.18.1", "Web automation");
        addDependency("testng", "org.testng", "7.7.1", "Testing framework");
        addDependency("cucumber", "io.cucumber", "7.11.2", "BDD testing");
        addDependency("appium", "io.appium", "8.3.0", "Mobile testing");
        addDependency("rest-assured", "io.rest-assured", "5.3.0", "API testing");
        addDependency("webdrivermanager", "io.github.bonigarcia", "5.7.0", "Driver management");
        
        // Reporting dependencies
        addDependency("extent-reports", "tech.grasshopper", "1.12.0", "HTML reporting");
        addDependency("allure", "io.qameta.allure", "2.17.2", "Advanced reporting");
        
        // Utility dependencies
        addDependency("apache-poi", "org.apache.poi", "5.1.0", "Excel handling");
        addDependency("jackson", "com.fasterxml.jackson.core", "2.15.0-rc1", "JSON processing");
        addDependency("gson", "com.google.code.gson", "2.10.1", "JSON processing");
        
        // Cloud platform dependencies
        addDependency("sauce-labs", "com.saucelabs", "1.2.0", "Cloud testing");
        addDependency("lambda-test", "com.lambdatest", "1.0.0", "Cloud testing");
        addDependency("browserstack", "com.browserstack", "1.0.0", "Cloud testing");
        
        logger.info("Dependency health monitor initialized with " + dependencies.size() + " dependencies");
    }
    
    /**
     * Add a dependency to monitor
     * 
     * @param name Dependency name
     * @param groupId Maven group ID
     * @param expectedVersion Expected version
     * @param description Dependency description
     */
    private void addDependency(String name, String groupId, String expectedVersion, String description) {
        dependencies.put(name, new DependencyInfo(name, groupId, expectedVersion, description));
    }
    
    /**
     * Check all dependencies for health issues
     */
    public void checkDependencies() {
        logger.info("Starting dependency health check...");
        
        healthIssues.clear();
        
        checkSeleniumVersion();
        checkBrowserDrivers();
        checkCloudPlatforms();
        checkDatabaseConnections();
        checkReportingDependencies();
        
        logger.info("Dependency health check completed. Found " + healthIssues.size() + " issues.");
    }
    
    /**
     * Check Selenium version compatibility
     */
    private void checkSeleniumVersion() {
        try {
            Class<?> webDriverClass = Class.forName("org.openqa.selenium.WebDriver");
            Package pkg = webDriverClass.getPackage();
            String actualVersion = pkg.getImplementationVersion();
            
            if (actualVersion != null) {
                DependencyInfo selenium = dependencies.get("selenium");
                if (selenium != null) {
                    selenium.setActualVersion(actualVersion);
                    
                    if (!actualVersion.equals(selenium.getExpectedVersion())) {
                        addHealthIssue("Selenium Version Mismatch", 
                            "Expected: " + selenium.getExpectedVersion() + ", Found: " + actualVersion,
                            HealthIssue.Severity.WARNING);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            addHealthIssue("Selenium Not Found", "Selenium WebDriver class not found", HealthIssue.Severity.ERROR);
        }
    }
    
    /**
     * Check browser driver availability
     */
    private void checkBrowserDrivers() {
        String[] browsers = {"chrome", "firefox", "edge"};
        
        for (String browser : browsers) {
            String driverPath = System.getProperty(browser + ".driver.path");
            if (driverPath != null) {
                File driverFile = new File(driverPath);
                if (!driverFile.exists()) {
                    addHealthIssue("Browser Driver Missing", 
                        browser + " driver not found at: " + driverPath, HealthIssue.Severity.WARNING);
                }
            }
        }
    }
    
    /**
     * Check cloud platform configurations
     */
    private void checkCloudPlatforms() {
        // Check SauceLabs configuration
        String sauceUsername = System.getProperty("sauce.username");
        String sauceAccessKey = System.getProperty("sauce.accesskey");
        
        if (sauceUsername == null || sauceAccessKey == null) {
            addHealthIssue("SauceLabs Configuration", 
                "SauceLabs credentials not configured", HealthIssue.Severity.INFO);
        }
        
        // Check LambdaTest configuration
        String lambdaUsername = System.getProperty("lambda.username");
        String lambdaAccessKey = System.getProperty("lambda.accesskey");
        
        if (lambdaUsername == null || lambdaAccessKey == null) {
            addHealthIssue("LambdaTest Configuration", 
                "LambdaTest credentials not configured", HealthIssue.Severity.INFO);
        }
    }
    
    /**
     * Check database connections
     */
    private void checkDatabaseConnections() {
        try {
            // Check PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            logger.fine("PostgreSQL driver available");
        } catch (ClassNotFoundException e) {
            addHealthIssue("Database Driver", 
                "PostgreSQL driver not found", HealthIssue.Severity.WARNING);
        }
        
        try {
            // Check MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            logger.fine("MySQL driver available");
        } catch (ClassNotFoundException e) {
            addHealthIssue("Database Driver", 
                "MySQL driver not found", HealthIssue.Severity.INFO);
        }
    }
    
    /**
     * Check reporting dependencies
     */
    private void checkReportingDependencies() {
        try {
            // Check Extent Reports
            Class.forName("com.aventstack.extentreports.ExtentReports");
            logger.fine("Extent Reports available");
        } catch (ClassNotFoundException e) {
            addHealthIssue("Reporting", 
                "Extent Reports not found", HealthIssue.Severity.WARNING);
        }
        
        try {
            // Check Allure
            Class.forName("io.qameta.allure.Allure");
            logger.fine("Allure Reports available");
        } catch (ClassNotFoundException e) {
            addHealthIssue("Reporting", 
                "Allure Reports not found", HealthIssue.Severity.INFO);
        }
    }
    
    /**
     * Add a health issue
     * 
     * @param title Issue title
     * @param description Issue description
     * @param severity Issue severity
     */
    private void addHealthIssue(String title, String description, HealthIssue.Severity severity) {
        HealthIssue issue = new HealthIssue(title, description, severity, new Date());
        healthIssues.add(issue);
        logger.warning("Health issue detected: " + title + " - " + description);
    }
    
    /**
     * Get all health issues
     * 
     * @return List of health issues
     */
    public List<HealthIssue> getHealthIssues() {
        return new ArrayList<>(healthIssues);
    }
    
    /**
     * Get health issues by severity
     * 
     * @param severity Severity level to filter by
     * @return List of health issues with specified severity
     */
    public List<HealthIssue> getHealthIssuesBySeverity(HealthIssue.Severity severity) {
        return healthIssues.stream()
            .filter(issue -> issue.getSeverity() == severity)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    /**
     * Generate health report
     * 
     * @return Health report string
     */
    public String generateHealthReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== Dependency Health Report ===\n");
        report.append("Generated: ").append(new Date()).append("\n\n");
        
        // Summary
        report.append("Summary:\n");
        report.append("  Total Dependencies: ").append(dependencies.size()).append("\n");
        report.append("  Health Issues: ").append(healthIssues.size()).append("\n");
        
        int errorCount = getHealthIssuesBySeverity(HealthIssue.Severity.ERROR).size();
        int warningCount = getHealthIssuesBySeverity(HealthIssue.Severity.WARNING).size();
        int infoCount = getHealthIssuesBySeverity(HealthIssue.Severity.INFO).size();
        
        report.append("  Errors: ").append(errorCount).append("\n");
        report.append("  Warnings: ").append(warningCount).append("\n");
        report.append("  Info: ").append(infoCount).append("\n\n");
        
        // Dependencies status
        report.append("Dependencies Status:\n");
        for (DependencyInfo dep : dependencies.values()) {
            String status = dep.getActualVersion() != null ? "✓" : "✗";
            String version = dep.getActualVersion() != null ? dep.getActualVersion() : "Not found";
            report.append(String.format("  %s %-20s | %-15s | %s\n", 
                status, dep.getName(), version, dep.getDescription()));
        }
        
        // Health issues
        if (!healthIssues.isEmpty()) {
            report.append("\nHealth Issues:\n");
            for (HealthIssue issue : healthIssues) {
                report.append(String.format("  [%s] %s: %s\n", 
                    issue.getSeverity(), issue.getTitle(), issue.getDescription()));
            }
        }
        
        // Recommendations
        report.append("\nRecommendations:\n");
        if (errorCount > 0) {
            report.append("  • Address ERROR level issues immediately\n");
        }
        if (warningCount > 0) {
            report.append("  • Review WARNING level issues\n");
        }
        if (infoCount > 0) {
            report.append("  • Consider addressing INFO level issues for better functionality\n");
        }
        
        return report.toString();
    }
    
    /**
     * Export health report to file
     * 
     * @param filePath File path to export to
     * @throws IOException if export fails
     */
    public void exportHealthReport(String filePath) throws IOException {
        String report = generateHealthReport();
        
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        }
        
        logger.info("Health report exported to: " + filePath);
    }
    
    /**
     * Get dependency information
     * 
     * @param name Dependency name
     * @return Dependency information or null if not found
     */
    public DependencyInfo getDependencyInfo(String name) {
        return dependencies.get(name);
    }
    
    /**
     * Get all dependency information
     * 
     * @return Map of dependency names to dependency information
     */
    public Map<String, DependencyInfo> getAllDependencyInfo() {
        return new HashMap<>(dependencies);
    }
    
    /**
     * Check if framework is healthy
     * 
     * @return true if no errors, false otherwise
     */
    public boolean isFrameworkHealthy() {
        return getHealthIssuesBySeverity(HealthIssue.Severity.ERROR).isEmpty();
    }
    
    /**
     * Get health score (0-100)
     * 
     * @return Health score
     */
    public int getHealthScore() {
        if (healthIssues.isEmpty()) {
            return 100;
        }
        
        int totalIssues = healthIssues.size();
        int errorWeight = 3;
        int warningWeight = 2;
        int infoWeight = 1;
        
        int weightedScore = 0;
        for (HealthIssue issue : healthIssues) {
            switch (issue.getSeverity()) {
                case ERROR:
                    weightedScore += errorWeight;
                    break;
                case WARNING:
                    weightedScore += warningWeight;
                    break;
                case INFO:
                    weightedScore += infoWeight;
                    break;
            }
        }
        
        int maxScore = totalIssues * errorWeight;
        return Math.max(0, 100 - (weightedScore * 100 / maxScore));
    }
    
    /**
     * Dependency information class
     */
    public static class DependencyInfo {
        private String name;
        private String groupId;
        private String expectedVersion;
        private String actualVersion;
        private String description;
        
        public DependencyInfo(String name, String groupId, String expectedVersion, String description) {
            this.name = name;
            this.groupId = groupId;
            this.expectedVersion = expectedVersion;
            this.description = description;
        }
        
        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getGroupId() { return groupId; }
        public void setGroupId(String groupId) { this.groupId = groupId; }
        
        public String getExpectedVersion() { return expectedVersion; }
        public void setExpectedVersion(String expectedVersion) { this.expectedVersion = expectedVersion; }
        
        public String getActualVersion() { return actualVersion; }
        public void setActualVersion(String actualVersion) { this.actualVersion = actualVersion; }
        
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
    
    /**
     * Health issue class
     */
    public static class HealthIssue {
        private String title;
        private String description;
        private Severity severity;
        private Date timestamp;
        
        public enum Severity {
            ERROR, WARNING, INFO
        }
        
        public HealthIssue(String title, String description, Severity severity, Date timestamp) {
            this.title = title;
            this.description = description;
            this.severity = severity;
            this.timestamp = timestamp;
        }
        
        // Getters
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public Severity getSeverity() { return severity; }
        public Date getTimestamp() { return timestamp; }
    }
}