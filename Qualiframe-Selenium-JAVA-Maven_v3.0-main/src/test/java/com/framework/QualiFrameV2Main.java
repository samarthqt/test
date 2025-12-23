package com.framework;

import com.framework.wizard.ConfigurationTemplates;
import com.framework.learning.FeatureAccessManager;
import com.framework.features.FeatureToggle;
import com.framework.resources.ResourceManager;
import com.framework.maintenance.DependencyHealthMonitor;
import com.framework.maintenance.DependencyManager;

import java.util.logging.Logger;
import java.util.Set;

/**
 * Main Entry Point for QualiFrameV2 Framework
 * Provides a simple command-line interface to all framework features
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class QualiFrameV2Main {
    
    private static final Logger logger = Logger.getLogger(QualiFrameV2Main.class.getName());
    
    public static void main(String[] args) {
        System.out.println("🚀 QualiFrameV2 Framework v2.0.1");
        System.out.println("=================================");
        System.out.println();
        
        if (args.length == 0) {
            showUsage();
            return;
        }
        
        try {
            switch (args[0].toLowerCase()) {
                case "init":
                case "initialize":
                    initializeFramework();
                    break;
                case "status":
                    showFrameworkStatus();
                    break;
                case "health":
                    checkHealth();
                    break;
                case "updates":
                    checkUpdates();
                    break;
                case "optimize":
                    optimizeFramework();
                    break;
                case "templates":
                    showTemplates();
                    break;
                case "features":
                    showFeatures();
                    break;
                case "help":
                case "--help":
                case "-h":
                    showUsage();
                    break;
                default:
                    System.out.println("❌ Unknown command: " + args[0]);
                    showUsage();
                    break;
            }
        } catch (Exception e) {
            System.err.println("❌ Error executing command: " + e.getMessage());
        }
    }
    
    private static void showUsage() {
        System.out.println("Usage: java -cp target/test-classes com.framework.QualiFrameV2Main <command>");
        System.out.println();
        System.out.println("Available Commands:");
        System.out.println("  init/initialize  - Initialize the framework");
        System.out.println("  status          - Show framework status");
        System.out.println("  health          - Check framework health");
        System.out.println("  updates         - Check for dependency updates");
        System.out.println("  optimize        - Run framework optimization");
        System.out.println("  templates       - Show available configuration templates");
        System.out.println("  features        - Show available features");
        System.out.println("  help            - Show this help message");
        System.out.println();
        System.out.println("Examples:");
        System.out.println("  java -cp target/test-classes com.framework.QualiFrameV2Main init");
        System.out.println("  java -cp target/test-classes com.framework.QualiFrameV2Main status");
        System.out.println("  java -cp target/test-classes com.framework.QualiFrameV2Main health");
    }
    
    private static void initializeFramework() {
        System.out.println("🔧 Initializing QualiFrameV2 Framework...");
        
        try {
            // Initialize all components
            ConfigurationTemplates templates = ConfigurationTemplates.getInstance();
            FeatureAccessManager featureAccess = FeatureAccessManager.getInstance();
            FeatureToggle featureToggle = FeatureToggle.getInstance();
            ResourceManager resourceManager = ResourceManager.getInstance();
            DependencyHealthMonitor healthMonitor = DependencyHealthMonitor.getInstance();
            DependencyManager dependencyManager = DependencyManager.getInstance();
            
            System.out.println("✅ Framework components initialized successfully");
            System.out.println("📊 Available configuration templates: " + templates.getAvailableTemplates().length);
            System.out.println("🎯 Available features: " + featureToggle.getAllFeatureInfo().size());
            
            // Check system resources
            if (resourceManager.hasMinimumResources()) {
                System.out.println("✅ System meets minimum resource requirements");
            } else {
                System.out.println("⚠️  System does not meet minimum resource requirements");
            }
            
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize framework: " + e.getMessage());
        }
    }
    
    private static void showFrameworkStatus() {
        System.out.println("📊 QualiFrameV2 Framework Status");
        System.out.println("=================================");
        
        try {
            ResourceManager resourceManager = ResourceManager.getInstance();
            ResourceManager.ResourceStats stats = resourceManager.getCurrentStats();
            
            System.out.println("Memory Usage: " + String.format("%.1f", stats.getMemoryUsagePercent()) + "%");
            System.out.println("Thread Count: " + stats.getThreadCount());
            System.out.println("Available Processors: " + stats.getAvailableProcessors());
            System.out.println("Resource Monitoring: " + (resourceManager.isMonitoring() ? "Active" : "Inactive"));
            
            FeatureToggle featureToggle = FeatureToggle.getInstance();
            String[] enabledFeatures = featureToggle.getEnabledFeatures();
            System.out.println("Enabled Features: " + enabledFeatures.length);
            
            System.out.println("✅ Framework status retrieved successfully");
            
        } catch (Exception e) {
            System.err.println("❌ Failed to get framework status: " + e.getMessage());
        }
    }
    
    private static void checkHealth() {
        System.out.println("🏥 Checking Framework Health...");
        
        try {
            DependencyHealthMonitor healthMonitor = DependencyHealthMonitor.getInstance();
            healthMonitor.checkDependencies();
            
            boolean isHealthy = healthMonitor.isFrameworkHealthy();
            int healthScore = healthMonitor.getHealthScore();
            
            System.out.println("Overall Health: " + (isHealthy ? "✅ Healthy" : "❌ Issues Detected"));
            System.out.println("Health Score: " + healthScore + "/100");
            
            if (!isHealthy) {
                System.out.println("⚠️  Health issues found. Check the health report for details.");
            }
            
            System.out.println("✅ Health check completed");
            
        } catch (Exception e) {
            System.err.println("❌ Failed to check health: " + e.getMessage());
        }
    }
    
    private static void checkUpdates() {
        System.out.println("🔄 Checking for Updates...");
        
        try {
            DependencyManager dependencyManager = DependencyManager.getInstance();
            dependencyManager.checkForUpdates();
            
            var updates = dependencyManager.getAvailableUpdates();
            System.out.println("Available Updates: " + updates.size());
            
            if (!updates.isEmpty()) {
                System.out.println("📋 Update Summary:");
                for (var update : updates.values()) {
                    System.out.println("  • " + update.getArtifactId() + ": " + 
                                     update.getCurrentVersion() + " → " + update.getLatestVersion() + 
                                     " (" + update.getUpdateType() + ")");
                }
            } else {
                System.out.println("✅ All dependencies are up to date");
            }
            
        } catch (Exception e) {
            System.err.println("❌ Failed to check updates: " + e.getMessage());
        }
    }
    
    private static void optimizeFramework() {
        System.out.println("⚡ Running Framework Optimization...");
        
        try {
            ResourceManager resourceManager = ResourceManager.getInstance();
            resourceManager.optimizeForResources();
            
            System.out.println("✅ Framework optimization completed");
            
            // Show optimization results
            ResourceManager.ResourceStats stats = resourceManager.getCurrentStats();
            System.out.println("📊 Optimization Results:");
            System.out.println("  Memory Usage: " + String.format("%.1f", stats.getMemoryUsagePercent()) + "%");
            System.out.println("  Thread Count: " + stats.getThreadCount());
            System.out.println("  Available Processors: " + stats.getAvailableProcessors());
            
        } catch (Exception e) {
            System.err.println("❌ Failed to optimize framework: " + e.getMessage());
        }
    }
    
    private static void showTemplates() {
        System.out.println("📋 Available Configuration Templates");
        System.out.println("===================================");
        
        try {
            ConfigurationTemplates templates = ConfigurationTemplates.getInstance();
            String[] availableTemplates = templates.getAvailableTemplates();
            
            for (String template : availableTemplates) {
                String description = templates.getTemplateDescription(template);
                System.out.println("• " + template + ": " + description);
            }
            
            System.out.println("✅ Templates retrieved successfully");
            
        } catch (Exception e) {
            System.err.println("❌ Failed to retrieve templates: " + e.getMessage());
        }
    }
    
    private static void showFeatures() {
        System.out.println("🎯 Available Framework Features");
        System.out.println("===============================");
        
        try {
            FeatureToggle featureToggle = FeatureToggle.getInstance();
            var allFeatures = featureToggle.getAllFeatureInfo();
            
            for (var entry : allFeatures.entrySet()) {
                String featureName = entry.getKey();
                var featureInfo = entry.getValue();
                boolean enabled = featureToggle.isFeatureEnabled(featureName);
                String status = enabled ? "✅ Enabled" : "❌ Disabled";
                
                System.out.println("• " + featureName + " (" + featureInfo.getPriority() + "): " + status);
                System.out.println("  " + featureInfo.getDescription());
            }
            
            System.out.println("✅ Features retrieved successfully");
            
        } catch (Exception e) {
            System.err.println("❌ Failed to retrieve features: " + e.getMessage());
        }
    }
}