package com.framework.wizard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.Properties;
import java.util.Set;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Centralized Configuration Manager for QualiFrameV2 Framework
 * Provides a single point of access for all framework configuration
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class FrameworkConfigManager {
    
    private static final Logger logger = Logger.getLogger(FrameworkConfigManager.class.getName());
    private static FrameworkConfigManager instance;
    
    private Properties globalConfig;
    private Properties browserConfig;
    private Properties cloudConfig;
    private Properties advancedConfig;
    
    private String currentProfile = "default";
    private boolean configurationLoaded = false;
    
    private FrameworkConfigManager() {
        globalConfig = new Properties();
        browserConfig = new Properties();
        cloudConfig = new Properties();
        advancedConfig = new Properties();
    }
    
    public static FrameworkConfigManager getInstance() {
        if (instance == null) {
            instance = new FrameworkConfigManager();
        }
        return instance;
    }
    
    /**
     * Initialize configuration with a specific profile
     * 
     * @param profile The configuration profile to load
     * @throws ConfigurationException if configuration loading fails
     */
    public void initializeConfiguration(String profile) throws ConfigurationException {
        try {
            currentProfile = profile;
            loadProfile(profile);
            validateConfiguration();
            applyConfiguration();
            configurationLoaded = true;
            
            logger.info("Configuration initialized successfully with profile: " + profile);
            
        } catch (Exception e) {
            throw new ConfigurationException("Failed to initialize configuration: " + e.getMessage(), e);
        }
    }
    
    /**
     * Load configuration profile
     * 
     * @param profile The profile name to load
     */
    private void loadProfile(String profile) {
        // Load global settings
        loadPropertiesFile("src/test/resources/properties/Global Settings.properties", globalConfig);
        
        // Load profile-specific configuration
        String profileFile = "src/test/resources/properties/" + profile + ".properties";
        if (fileExists(profileFile)) {
            loadPropertiesFile(profileFile, globalConfig);
        }
        
        // Load browser configuration
        loadPropertiesFile("src/test/resources/properties/browser-config.properties", browserConfig);
        
        // Load cloud platform configuration
        loadPropertiesFile("src/test/resources/properties/cloud-config.properties", cloudConfig);
        
        // Load advanced features configuration
        loadPropertiesFile("src/test/resources/properties/advanced-config.properties", advancedConfig);
    }
    
    /**
     * Load properties from file
     * 
     * @param filePath The path to the properties file
     * @param target The target Properties object to load into
     */
    private void loadPropertiesFile(String filePath, Properties target) {
        try (InputStream input = new FileInputStream(filePath)) {
            target.load(input);
            logger.info("Loaded properties from: " + filePath);
        } catch (IOException e) {
            logger.warning("Could not load properties from: " + filePath + " - " + e.getMessage());
        }
    }
    
    /**
     * Check if file exists
     * 
     * @param filePath The file path to check
     * @return true if file exists, false otherwise
     */
    private boolean fileExists(String filePath) {
        return new java.io.File(filePath).exists();
    }
    
    /**
     * Validate configuration
     * 
     * @throws ConfigurationException if validation fails
     */
    private void validateConfiguration() throws ConfigurationException {
        // Validate required properties
        validateRequiredProperty("ExecutionApproach");
        validateRequiredProperty("TestConfigurationID");
        validateRequiredProperty("defaultEnvironment");
        
        // Validate property values
        validateExecutionApproach();
        validateTestConfiguration();
        validateEnvironment();
        
        logger.info("Configuration validation completed successfully");
    }
    
    /**
     * Validate required property exists
     * 
     * @param propertyName The property name to validate
     * @throws ConfigurationException if property is missing
     */
    private void validateRequiredProperty(String propertyName) throws ConfigurationException {
        String value = globalConfig.getProperty(propertyName);
        if (value == null || value.trim().isEmpty()) {
            throw new ConfigurationException("Required property missing: " + propertyName);
        }
    }
    
    /**
     * Validate execution approach
     * 
     * @throws ConfigurationException if execution approach is invalid
     */
    private void validateExecutionApproach() throws ConfigurationException {
        String approach = globalConfig.getProperty("ExecutionApproach");
        if (!approach.matches("MODULAR|CUCUMBER|KEYWORD")) {
            throw new ConfigurationException("Invalid ExecutionApproach: " + approach + 
                ". Must be MODULAR, CUCUMBER, or KEYWORD");
        }
    }
    
    /**
     * Validate test configuration
     * 
     * @throws ConfigurationException if test configuration is invalid
     */
    private void validateTestConfiguration() throws ConfigurationException {
        String config = globalConfig.getProperty("TestConfigurationID");
        if (config == null || config.trim().isEmpty()) {
            throw new ConfigurationException("TestConfigurationID is required");
        }
    }
    
    /**
     * Validate environment
     * 
     * @throws ConfigurationException if environment is invalid
     */
    private void validateEnvironment() throws ConfigurationException {
        String env = globalConfig.getProperty("defaultEnvironment");
        if (!env.matches("qa|staging|prod|dev")) {
            throw new ConfigurationException("Invalid environment: " + env + 
                ". Must be qa, staging, prod, or dev");
        }
    }
    
    /**
     * Apply configuration to system properties
     */
    private void applyConfiguration() {
        // Apply global configuration
        for (String key : globalConfig.stringPropertyNames()) {
            System.setProperty("qualiframe." + key, globalConfig.getProperty(key));
        }
        
        // Apply browser configuration
        for (String key : browserConfig.stringPropertyNames()) {
            System.setProperty("qualiframe.browser." + key, browserConfig.getProperty(key));
        }
        
        // Apply cloud configuration
        for (String key : cloudConfig.stringPropertyNames()) {
            System.setProperty("qualiframe.cloud." + key, cloudConfig.getProperty(key));
        }
        
        // Apply advanced configuration
        for (String key : advancedConfig.stringPropertyNames()) {
            System.setProperty("qualiframe.advanced." + key, advancedConfig.getProperty(key));
        }
        
        logger.info("Configuration applied to system properties");
    }
    
    /**
     * Get property value
     * 
     * @param key The property key
     * @return The property value
     */
    public String getProperty(String key) {
        if (!configurationLoaded) {
            logger.warning("Configuration not loaded. Loading default configuration.");
            try {
                initializeConfiguration("default");
            } catch (ConfigurationException e) {
                logger.severe("Failed to load default configuration: " + e.getMessage());
                return null;
            }
        }
        
        // Try global config first
        String value = globalConfig.getProperty(key);
        if (value != null) {
            return value;
        }
        
        // Try browser config
        value = browserConfig.getProperty(key);
        if (value != null) {
            return value;
        }
        
        // Try cloud config
        value = cloudConfig.getProperty(key);
        if (value != null) {
            return value;
        }
        
        // Try advanced config
        value = advancedConfig.getProperty(key);
        if (value != null) {
            return value;
        }
        
        // Try system properties
        return System.getProperty("qualiframe." + key);
    }
    
    /**
     * Get property value with default
     * 
     * @param key The property key
     * @param defaultValue The default value if property not found
     * @return The property value or default value
     */
    public String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        return value != null ? value : defaultValue;
    }
    
    /**
     * Get boolean property
     * 
     * @param key The property key
     * @param defaultValue The default value if property not found
     * @return The boolean property value
     */
    public boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = getProperty(key);
        if (value == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(value);
    }
    
    /**
     * Get integer property
     * 
     * @param key The property key
     * @param defaultValue The default value if property not found
     * @return The integer property value
     */
    public int getIntProperty(String key, int defaultValue) {
        String value = getProperty(key);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.warning("Invalid integer value for property " + key + ": " + value);
            return defaultValue;
        }
    }
    
    /**
     * Set property value
     * 
     * @param key The property key
     * @param value The property value
     */
    public void setProperty(String key, String value) {
        globalConfig.setProperty(key, value);
        System.setProperty("qualiframe." + key, value);
        logger.info("Property set: " + key + " = " + value);
    }
    
    /**
     * Save configuration to file
     * 
     * @param filePath The file path to save to
     * @throws ConfigurationException if saving fails
     */
    public void saveConfiguration(String filePath) throws ConfigurationException {
        try (FileOutputStream output = new FileOutputStream(filePath)) {
            globalConfig.store(output, "QualiFrameV2 Configuration - Profile: " + currentProfile);
            logger.info("Configuration saved to: " + filePath);
        } catch (IOException e) {
            throw new ConfigurationException("Failed to save configuration: " + e.getMessage(), e);
        }
    }
    
    /**
     * Get current profile
     * 
     * @return The current configuration profile
     */
    public String getCurrentProfile() {
        return currentProfile;
    }
    
    /**
     * Check if configuration is loaded
     * 
     * @return true if configuration is loaded, false otherwise
     */
    public boolean isConfigurationLoaded() {
        return configurationLoaded;
    }
    
    /**
     * Get configuration summary
     * 
     * @return Configuration summary string
     */
    public String getConfigurationSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== QualiFrameV2 Configuration Summary ===\n");
        summary.append("Profile: ").append(currentProfile).append("\n");
        summary.append("Loaded: ").append(configurationLoaded).append("\n\n");
        
        summary.append("Global Configuration:\n");
        for (String key : globalConfig.stringPropertyNames()) {
            summary.append("  ").append(key).append(" = ").append(globalConfig.getProperty(key)).append("\n");
        }
        
        summary.append("\nBrowser Configuration:\n");
        for (String key : browserConfig.stringPropertyNames()) {
            summary.append("  ").append(key).append(" = ").append(browserConfig.getProperty(key)).append("\n");
        }
        
        return summary.toString();
    }
    
    /**
     * Configuration Exception class
     */
    public static class ConfigurationException extends Exception {
        public ConfigurationException(String message) {
            super(message);
        }
        
        public ConfigurationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}