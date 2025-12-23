package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.io.File;

/**
 * Utility class for detecting and removing dead code in the framework
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class DeadCodeDetector {
    
    private static final Logger logger = Logger.getLogger(DeadCodeDetector.class.getName());
    
    // Patterns for dead code detection
    private static final Pattern TODO_PATTERN = Pattern.compile("/bTODO/b|/bFIXME/b|/bXXX/b|/bHACK/b", Pattern.CASE_INSENSITIVE);
    private static final Pattern DEPRECATED_PATTERN = Pattern.compile("@Deprecated|@SuppressWarnings.*deprecation");
    private static final Pattern DEBUG_PATTERN = Pattern.compile("System/.out/.print|System/.err/.print|e/.printStackTrace|Thread/.sleep");
    private static final Pattern UNUSED_IMPORT_PATTERN = Pattern.compile("import/s+[^;]+;");
    
    private final String projectRoot;
    private final List<String> javaFiles;
    private final Map<String, List<DeadCodeIssue>> issuesByFile;
    
    public DeadCodeDetector(String projectRoot) {
        this.projectRoot = projectRoot;
        this.javaFiles = new ArrayList<>();
        this.issuesByFile = new HashMap<>();
        scanJavaFiles();
    }
    
    /**
     * Scan for Java files in the project
     */
    private void scanJavaFiles() {
        try {
            Files.walk(Paths.get(projectRoot))
                .filter(path -> path.toString().endsWith(".java"))
                .filter(path -> !path.toString().contains("target"))
                .filter(path -> !path.toString().contains(".git"))
                .forEach(path -> javaFiles.add(path.toString()));
            
            logger.info("Found " + javaFiles.size() + " Java files to analyze");
        } catch (IOException e) {
            logger.severe("Error scanning Java files: " + e.getMessage());
        }
    }
    
    /**
     * Analyze all Java files for dead code
     */
    public void analyzeAllFiles() {
        logger.info("Starting dead code analysis...");
        
        for (String javaFile : javaFiles) {
            analyzeFile(javaFile);
        }
        
        logger.info("Analysis complete. Found issues in " + issuesByFile.size() + " files");
    }
    
    /**
     * Analyze a single Java file for dead code
     */
    private void analyzeFile(String filePath) {
        try {
            String content = Files.readString(Paths.get(filePath));
            List<DeadCodeIssue> issues = new ArrayList<>();
            
            // Check for TODO/FIXME comments
            if (TODO_PATTERN.matcher(content).find()) {
                issues.add(new DeadCodeIssue(DeadCodeType.TODO_COMMENT, "Contains TODO/FIXME comments"));
            }
            
            // Check for deprecated code
            if (DEPRECATED_PATTERN.matcher(content).find()) {
                issues.add(new DeadCodeIssue(DeadCodeType.DEPRECATED_CODE, "Contains deprecated code"));
            }
            
            // Check for debug code
            if (DEBUG_PATTERN.matcher(content).find()) {
                issues.add(new DeadCodeIssue(DeadCodeType.DEBUG_CODE, "Contains debug code"));
            }
            
            // Check for unused imports
            List<String> unusedImports = findUnusedImports(content);
            if (!unusedImports.isEmpty()) {
                issues.add(new DeadCodeIssue(DeadCodeType.UNUSED_IMPORTS, 
                    "Unused imports: " + String.join(", ", unusedImports)));
            }
            
            // Check for empty methods
            List<String> emptyMethods = findEmptyMethods(content);
            if (!emptyMethods.isEmpty()) {
                issues.add(new DeadCodeIssue(DeadCodeType.EMPTY_METHODS, 
                    "Empty methods: " + String.join(", ", emptyMethods)));
            }
            
            if (!issues.isEmpty()) {
                issuesByFile.put(filePath, issues);
            }
            
        } catch (IOException e) {
            logger.warning("Could not read file " + filePath + ": " + e.getMessage());
        }
    }
    
    /**
     * Find unused imports in a Java file
     */
    private List<String> findUnusedImports(String content) {
        List<String> unusedImports = new ArrayList<>();
        
        // Extract all imports
        List<String> imports = new ArrayList<>();
        String[] lines = content.split("\n");
        for (String line : lines) {
            if (line.trim().startsWith("import ")) {
                String importName = line.trim().substring(7, line.length() - 1);
                imports.add(importName);
            }
        }
        
        // Check if imports are used in the code
        for (String importName : imports) {
            String className = importName.substring(importName.lastIndexOf('.') + 1);
            if (!content.contains(className + " ") && !content.contains(className + "(") && 
                !content.contains(className + "[") && !content.contains(className + "<")) {
                unusedImports.add(importName);
            }
        }
        
        return unusedImports;
    }
    
    /**
     * Find empty methods in a Java file
     */
    private List<String> findEmptyMethods(String content) {
        List<String> emptyMethods = new ArrayList<>();
        
        // Simple regex to find method definitions
        Pattern methodPattern = Pattern.compile("/b(public|private|protected|static)/s+[^{]+/{/s*/}");
        java.util.regex.Matcher matcher = methodPattern.matcher(content);
        
        while (matcher.find()) {
            String method = matcher.group();
            // Extract method name
            String[] parts = method.split("/s+");
            if (parts.length > 1) {
                String methodName = parts[parts.length - 2];
                emptyMethods.add(methodName);
            }
        }
        
        return emptyMethods;
    }
    
    /**
     * Get all detected issues
     */
    public Map<String, List<DeadCodeIssue>> getAllIssues() {
        return new HashMap<>(issuesByFile);
    }
    
    /**
     * Get issues by type
     */
    public Map<DeadCodeType, List<DeadCodeIssue>> getIssuesByType() {
        Map<DeadCodeType, List<DeadCodeIssue>> issuesByType = new HashMap<>();
        
        for (List<DeadCodeIssue> issues : issuesByFile.values()) {
            for (DeadCodeIssue issue : issues) {
                issuesByType.computeIfAbsent(issue.getType(), k -> new ArrayList<>()).add(issue);
            }
        }
        
        return issuesByType;
    }
    
    /**
     * Generate a report of all issues
     */
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("=== Dead Code Analysis Report ===\n\n");
        
        Map<DeadCodeType, List<DeadCodeIssue>> issuesByType = getIssuesByType();
        
        for (DeadCodeType type : DeadCodeType.values()) {
            List<DeadCodeIssue> issues = issuesByType.get(type);
            if (issues != null && !issues.isEmpty()) {
                report.append(type.getDisplayName()).append(" (").append(issues.size()).append("):\n");
                for (DeadCodeIssue issue : issues) {
                    report.append("  - ").append(issue.getDescription()).append("\n");
                }
                report.append("\n");
            }
        }
        
        report.append("Files with issues: ").append(issuesByFile.size()).append("\n");
        report.append("Total issues: ").append(issuesByType.values().stream().mapToInt(List::size).sum()).append("\n");
        
        return report.toString();
    }
    
    /**
     * Remove dead code from files
     */
    public void removeDeadCode() {
        logger.info("Starting dead code removal...");
        
        for (Map.Entry<String, List<DeadCodeIssue>> entry : issuesByFile.entrySet()) {
            String filePath = entry.getKey();
            List<DeadCodeIssue> issues = entry.getValue();
            
            try {
                removeDeadCodeFromFile(filePath, issues);
            } catch (IOException e) {
                logger.warning("Could not remove dead code from " + filePath + ": " + e.getMessage());
            }
        }
        
        logger.info("Dead code removal complete");
    }
    
    /**
     * Remove dead code from a specific file
     */
    private void removeDeadCodeFromFile(String filePath, List<DeadCodeIssue> issues) throws IOException {
        String content = Files.readString(Paths.get(filePath));
        String originalContent = content;
        
        for (DeadCodeIssue issue : issues) {
            switch (issue.getType()) {
                case TODO_COMMENT:
                    content = removeTODOComments(content);
                    break;
                case DEBUG_CODE:
                    content = removeDebugCode(content);
                    break;
                case UNUSED_IMPORTS:
                    content = removeUnusedImports(content);
                    break;
                case EMPTY_METHODS:
                    content = removeEmptyMethods(content);
                    break;
                default:
                    break;
            }
        }
        
        if (!content.equals(originalContent)) {
            Files.write(Paths.get(filePath), content.getBytes());
            logger.info("Updated file: " + filePath);
        }
    }
    
    /**
     * Remove TODO comments from content
     */
    private String removeTODOComments(String content) {
        return content.replaceAll("(?m)^/s*///s*TODO.*$", "")
                    .replaceAll("(?m)^/s*///s*FIXME.*$", "")
                    .replaceAll("(?m)^/s*///s*XXX.*$", "")
                    .replaceAll("(?m)^/s*///s*HACK.*$", "");
    }
    
    /**
     * Remove debug code from content
     */
    private String removeDebugCode(String content) {
        return content.replaceAll("(?m)^/s*System/.out/.print.*$", "")
                    .replaceAll("(?m)^/s*System/.err/.print.*$", "")
                    .replaceAll("(?m)^/s*e/.printStackTrace/(/);.*$", "")
                    .replaceAll("(?m)^/s*Thread/.sleep/([^)]*/);.*$", "");
    }
    
    /**
     * Remove unused imports from content
     */
    private String removeUnusedImports(String content) {
        // This is a simplified version - in practice, you'd want more sophisticated analysis
        return content;
    }
    
    /**
     * Remove empty methods from content
     */
    private String removeEmptyMethods(String content) {
        // This is a simplified version - in practice, you'd want more sophisticated analysis
        return content;
    }
    
    /**
     * Types of dead code issues
     */
    public enum DeadCodeType {
        TODO_COMMENT("TODO Comments"),
        DEPRECATED_CODE("Deprecated Code"),
        DEBUG_CODE("Debug Code"),
        UNUSED_IMPORTS("Unused Imports"),
        EMPTY_METHODS("Empty Methods");
        
        private final String displayName;
        
        DeadCodeType(String displayName) {
            this.displayName = displayName;
        }
        
        public String getDisplayName() {
            return displayName;
        }
    }
    
    /**
     * Represents a dead code issue
     */
    public static class DeadCodeIssue {
        private final DeadCodeType type;
        private final String description;
        
        public DeadCodeIssue(DeadCodeType type, String description) {
            this.type = type;
            this.description = description;
        }
        
        public DeadCodeType getType() {
            return type;
        }
        
        public String getDescription() {
            return description;
        }
    }
}