package com.framework.wizard;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.io.FileOutputStream;

/**
 * Configuration Templates for QualiFrameV2 Framework
 * Provides pre-configured templates for common use cases
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class ConfigurationTemplates {
    
    private static final Logger logger = Logger.getLogger(ConfigurationTemplates.class.getName());
    private static ConfigurationTemplates instance;
    
    private Map<String, Properties> templates;
    
    private ConfigurationTemplates() {
        templates = new HashMap<>();
        initializeTemplates();
    }
    
    public static ConfigurationTemplates getInstance() {
        if (instance == null) {
            instance = new ConfigurationTemplates();
        }
        return instance;
    }
    
    /**
     * Initialize predefined templates
     */
    private void initializeTemplates() {
        // Basic Web Testing Template
        Properties basicWebTemplate = new Properties();
        basicWebTemplate.setProperty("ExecutionApproach", "MODULAR");
        basicWebTemplate.setProperty("TestData", "EXCEL");
        basicWebTemplate.setProperty("TestConfigurationID", "LOCALChrome");
        basicWebTemplate.setProperty("defaultEnvironment", "qa");
        basicWebTemplate.setProperty("TakeScreenshotFailedStep", "true");
        basicWebTemplate.setProperty("TakeScreenshotPassedStep", "false");
        basicWebTemplate.setProperty("Timeout", "30");
        basicWebTemplate.setProperty("ParallelExecution", "false");
        basicWebTemplate.setProperty("NumberOfThreads", "1");
        basicWebTemplate.setProperty("AIFeatures", "false");
        basicWebTemplate.setProperty("PerformanceFeatures", "false");
        basicWebTemplate.setProperty("SecurityFeatures", "false");
        basicWebTemplate.setProperty("Containerization", "false");
        templates.put("basic.web", basicWebTemplate);
        
        // Advanced Web Testing Template
        Properties advancedWebTemplate = new Properties();
        advancedWebTemplate.setProperty("ExecutionApproach", "CUCUMBER");
        advancedWebTemplate.setProperty("TestData", "EXCEL");
        advancedWebTemplate.setProperty("TestConfigurationID", "LOCALChrome_HEADLESS");
        advancedWebTemplate.setProperty("defaultEnvironment", "qa");
        advancedWebTemplate.setProperty("TakeScreenshotFailedStep", "true");
        advancedWebTemplate.setProperty("TakeScreenshotPassedStep", "true");
        advancedWebTemplate.setProperty("Timeout", "50");
        advancedWebTemplate.setProperty("ParallelExecution", "true");
        advancedWebTemplate.setProperty("NumberOfThreads", "4");
        advancedWebTemplate.setProperty("AIFeatures", "true");
        advancedWebTemplate.setProperty("PerformanceFeatures", "true");
        advancedWebTemplate.setProperty("SecurityFeatures", "true");
        advancedWebTemplate.setProperty("Containerization", "false");
        templates.put("advanced.web", advancedWebTemplate);
        
        // Cloud Testing Template
        Properties cloudTemplate = new Properties();
        cloudTemplate.setProperty("ExecutionApproach", "MODULAR");
        cloudTemplate.setProperty("TestData", "EXCEL");
        cloudTemplate.setProperty("TestConfigurationID", "REMOTEChrome");
        cloudTemplate.setProperty("defaultEnvironment", "qa");
        cloudTemplate.setProperty("TakeScreenshotFailedStep", "true");
        cloudTemplate.setProperty("TakeScreenshotPassedStep", "false");
        cloudTemplate.setProperty("Timeout", "60");
        cloudTemplate.setProperty("ParallelExecution", "true");
        cloudTemplate.setProperty("NumberOfThreads", "8");
        cloudTemplate.setProperty("AIFeatures", "false");
        cloudTemplate.setProperty("PerformanceFeatures", "true");
        cloudTemplate.setProperty("SecurityFeatures", "false");
        cloudTemplate.setProperty("Containerization", "false");
        templates.put("cloud", cloudTemplate);
        
        // Mobile Testing Template
        Properties mobileTemplate = new Properties();
        mobileTemplate.setProperty("ExecutionApproach", "MODULAR");
        mobileTemplate.setProperty("TestData", "EXCEL");
        mobileTemplate.setProperty("TestConfigurationID", "AppiumNativeAndroid");
        mobileTemplate.setProperty("defaultEnvironment", "qa");
        mobileTemplate.setProperty("TakeScreenshotFailedStep", "true");
        mobileTemplate.setProperty("TakeScreenshotPassedStep", "false");
        mobileTemplate.setProperty("Timeout", "45");
        mobileTemplate.setProperty("ParallelExecution", "false");
        mobileTemplate.setProperty("NumberOfThreads", "1");
        mobileTemplate.setProperty("AIFeatures", "false");
        mobileTemplate.setProperty("PerformanceFeatures", "false");
        mobileTemplate.setProperty("SecurityFeatures", "false");
        mobileTemplate.setProperty("Containerization", "false");
        templates.put("mobile", mobileTemplate);
        
        // API Testing Template
        Properties apiTemplate = new Properties();
        apiTemplate.setProperty("ExecutionApproach", "CUCUMBER");
        apiTemplate.setProperty("TestData", "JSON");
        apiTemplate.setProperty("TestConfigurationID", "API");
        apiTemplate.setProperty("defaultEnvironment", "qa");
        apiTemplate.setProperty("TakeScreenshotFailedStep", "false");
        apiTemplate.setProperty("TakeScreenshotPassedStep", "false");
        apiTemplate.setProperty("Timeout", "30");
        apiTemplate.setProperty("ParallelExecution", "true");
        apiTemplate.setProperty("NumberOfThreads", "6");
        apiTemplate.setProperty("AIFeatures", "true");
        apiTemplate.setProperty("PerformanceFeatures", "true");
        apiTemplate.setProperty("SecurityFeatures", "true");
        apiTemplate.setProperty("Containerization", "false");
        templates.put("api", apiTemplate);
        
        // Performance Testing Template
        Properties performanceTemplate = new Properties();
        performanceTemplate.setProperty("ExecutionApproach", "MODULAR");
        performanceTemplate.setProperty("TestData", "EXCEL");
        performanceTemplate.setProperty("TestConfigurationID", "LOCALChrome_HEADLESS");
        performanceTemplate.setProperty("defaultEnvironment", "qa");
        performanceTemplate.setProperty("TakeScreenshotFailedStep", "false");
        performanceTemplate.setProperty("TakeScreenshotPassedStep", "false");
        performanceTemplate.setProperty("Timeout", "120");
        performanceTemplate.setProperty("ParallelExecution", "true");
        performanceTemplate.setProperty("NumberOfThreads", "10");
        performanceTemplate.setProperty("AIFeatures", "true");
        performanceTemplate.setProperty("PerformanceFeatures", "true");
        performanceTemplate.setProperty("SecurityFeatures", "false");
        performanceTemplate.setProperty("Containerization", "true");
        templates.put("performance", performanceTemplate);
        
        // Enterprise Template
        Properties enterpriseTemplate = new Properties();
        enterpriseTemplate.setProperty("ExecutionApproach", "CUCUMBER");
        enterpriseTemplate.setProperty("TestData", "MSSQL");
        enterpriseTemplate.setProperty("TestConfigurationID", "REMOTEChrome");
        enterpriseTemplate.setProperty("defaultEnvironment", "qa");
        enterpriseTemplate.setProperty("TakeScreenshotFailedStep", "true");
        enterpriseTemplate.setProperty("TakeScreenshotPassedStep", "true");
        enterpriseTemplate.setProperty("Timeout", "60");
        enterpriseTemplate.setProperty("ParallelExecution", "true");
        enterpriseTemplate.setProperty("NumberOfThreads", "12");
        enterpriseTemplate.setProperty("AIFeatures", "true");
        enterpriseTemplate.setProperty("PerformanceFeatures", "true");
        enterpriseTemplate.setProperty("SecurityFeatures", "true");
        enterpriseTemplate.setProperty("Containerization", "true");
        templates.put("enterprise", enterpriseTemplate);
        
        logger.info("Configuration templates initialized with " + templates.size() + " templates");
    }
    
    /**
     * Get available template names
     * 
     * @return Array of template names
     */
    public String[] getAvailableTemplates() {
        return templates.keySet().toArray(new String[0]);
    }
    
    /**
     * Get template by name
     * 
     * @param templateName The template name
     * @return The template properties or null if not found
     */
    public Properties getTemplate(String templateName) {
        Properties template = templates.get(templateName);
        if (template == null) {
            logger.warning("Template not found: " + templateName);
            return null;
        }
        
        // Return a copy of the template
        Properties copy = new Properties();
        copy.putAll(template);
        return copy;
    }
    
    /**
     * Apply template to configuration manager
     * 
     * @param templateName The template name to apply
     * @param configManager The configuration manager to apply to
     * @throws ConfigurationException if template application fails
     */
    public void applyTemplate(String templateName, FrameworkConfigManager configManager) 
            throws FrameworkConfigManager.ConfigurationException {
        
        Properties template = getTemplate(templateName);
        if (template == null) {
            throw new FrameworkConfigManager.ConfigurationException("Template not found: " + templateName);
        }
        
        // Apply template properties
        for (String key : template.stringPropertyNames()) {
            configManager.setProperty(key, template.getProperty(key));
        }
        
        logger.info("Template applied successfully: " + templateName);
    }
    
    /**
     * Create custom template from current configuration
     * 
     * @param templateName The name for the new template
     * @param configManager The configuration manager to extract from
     * @return true if template created successfully, false otherwise
     */
    public boolean createCustomTemplate(String templateName, FrameworkConfigManager configManager) {
        try {
            Properties customTemplate = new Properties();
            
            // Extract current configuration
            String[] keys = {
                "ExecutionApproach", "TestData", "TestConfigurationID", "defaultEnvironment",
                "TakeScreenshotFailedStep", "TakeScreenshotPassedStep", "Timeout",
                "ParallelExecution", "NumberOfThreads", "AIFeatures", "PerformanceFeatures",
                "SecurityFeatures", "Containerization"
            };
            
            for (String key : keys) {
                String value = configManager.getProperty(key);
                if (value != null) {
                    customTemplate.setProperty(key, value);
                }
            }
            
            templates.put(templateName, customTemplate);
            logger.info("Custom template created: " + templateName);
            return true;
            
        } catch (Exception e) {
            logger.severe("Failed to create custom template: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Get template description
     * 
     * @param templateName The template name
     * @return Template description
     */
    public String getTemplateDescription(String templateName) {
        Map<String, String> descriptions = Map.of(
            "basic.web", "Basic web testing with Chrome, single-threaded execution",
            "advanced.web", "Advanced web testing with Cucumber, AI features, and parallel execution",
            "cloud", "Cloud-based testing with remote WebDriver and parallel execution",
            "mobile", "Mobile testing with Appium for Android applications",
            "api", "API testing with REST Assured and JSON test data",
            "performance", "Performance testing with headless Chrome and high concurrency",
            "enterprise", "Enterprise-grade testing with all features enabled"
        );
        
        return descriptions.getOrDefault(templateName, "No description available");
    }
    
    /**
     * Validate template
     * 
     * @param templateName The template name to validate
     * @return true if template is valid, false otherwise
     */
    public boolean validateTemplate(String templateName) {
        Properties template = getTemplate(templateName);
        if (template == null) {
            return false;
        }
        
        // Check required properties
        String[] required = {"ExecutionApproach", "TestConfigurationID", "defaultEnvironment"};
        for (String key : required) {
            if (template.getProperty(key) == null) {
                logger.warning("Template validation failed: missing required property " + key);
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Export template to file
     * 
     * @param templateName The template name to export
     * @param filePath The file path to export to
     * @return true if export successful, false otherwise
     */
    public boolean exportTemplate(String templateName, String filePath) {
        Properties template = getTemplate(templateName);
        if (template == null) {
            return false;
        }
        
        try (java.io.FileOutputStream output = new java.io.FileOutputStream(filePath)) {
            template.store(output, "QualiFrameV2 Template: " + templateName);
            logger.info("Template exported successfully: " + templateName + " to " + filePath);
            return true;
        } catch (Exception e) {
            logger.severe("Failed to export template: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Import template from file
     * 
     * @param templateName The name for the imported template
     * @param filePath The file path to import from
     * @return true if import successful, false otherwise
     */
    public boolean importTemplate(String templateName, String filePath) {
        try (java.io.FileInputStream input = new java.io.FileInputStream(filePath)) {
            Properties template = new Properties();
            template.load(input);
            
            // Validate imported template
            if (validateTemplate(template)) {
                templates.put(templateName, template);
                logger.info("Template imported successfully: " + templateName + " from " + filePath);
                return true;
            } else {
                logger.warning("Imported template validation failed: " + templateName);
                return false;
            }
        } catch (Exception e) {
            logger.severe("Failed to import template: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Validate template properties
     * 
     * @param template The template to validate
     * @return true if valid, false otherwise
     */
    private boolean validateTemplate(Properties template) {
        // Basic validation logic
        return template != null && !template.isEmpty();
    }
}