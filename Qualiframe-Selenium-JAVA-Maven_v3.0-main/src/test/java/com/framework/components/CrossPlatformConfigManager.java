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

import com.framework.utils.PlatformUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.Properties;
import java.io.IOException;
import java.io.File;
import java.net.URL;

/**
 * Cross-platform configuration manager for QualiFrameV2
 * Handles platform-specific configurations and path resolution
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class CrossPlatformConfigManager {
    
    private static final Logger logger = Logger.getLogger(CrossPlatformConfigManager.class.getName());
    private static CrossPlatformConfigManager instance;
    private Properties crossPlatformProperties;
    private Properties globalProperties;
    private Properties mobileProperties;
    private Properties apiProperties;
    
    private CrossPlatformConfigManager() {
        loadConfigurations();
    }
    
    /**
     * Get singleton instance
     */
    public static synchronized CrossPlatformConfigManager getInstance() {
        if (instance == null) {
            instance = new CrossPlatformConfigManager();
        }
        return instance;
    }
    
    /**
     * Load all configurations
     */
    private void loadConfigurations() {
        logger.info("Loading cross-platform configurations...");
        
        try {
            // Load cross-platform settings
            crossPlatformProperties = loadPropertiesFile("Cross-Platform Settings.properties");
            
            // Load existing properties
            globalProperties = Settings.getInstance();
            mobileProperties = Settings.getMobilePropertiesInstance();
            apiProperties = loadPropertiesFile("API Automation Endpoints.properties");
            
            // Resolve platform-specific paths
            resolvePlatformSpecificPaths();
            
            logger.info("Cross-platform configurations loaded successfully");
            logger.info("Current platform: " + PlatformUtils.getOperatingSystem());
            
        } catch (Exception e) {
            String errorMessage = e.getMessage() != null ? e.getMessage() : "Unknown error";
            logger.severe("Failed to load configurations: " + errorMessage);
            throw new FrameworkException("Configuration loading failed: " + errorMessage);
        }
    }
    
    /**
     * Load properties file from resources
     */
    private Properties loadPropertiesFile(String fileName) {
        Properties properties = new Properties();
        
        try {
            String resourcePath = "src/test/resources/properties/" + fileName;
            Path path = Paths.get(resourcePath);
            
            if (Files.exists(path)) {
                try (InputStream input = new FileInputStream(path.toFile())) {
                    properties.load(input);
                    logger.info("Loaded properties from: " + resourcePath);
                }
            } else {
                logger.warning("Properties file not found: " + resourcePath);
            }
            
        } catch (IOException e) {
            String errorMessage = e.getMessage() != null ? e.getMessage() : "Unknown error";
            logger.warning("Failed to load properties file " + fileName + ": " + errorMessage);
        }
        
        return properties;
    }
    
    /**
     * Resolve platform-specific paths
     */
    private void resolvePlatformSpecificPaths() {
        logger.info("Resolving platform-specific paths...");
        
        // Resolve download directory
        String downloadDir = getCrossPlatformPath("DownloadDirectory");
        crossPlatformProperties.setProperty("resolved.download.directory", downloadDir);
        
        // Resolve driver directory
        String driverDir = getCrossPlatformPath("DriverDirectory");
        crossPlatformProperties.setProperty("resolved.driver.directory", driverDir);
        
        // Resolve browser binary paths
        resolveBrowserPaths();
        
        // Resolve mobile app paths
        resolveMobileAppPaths();
        
        logger.info("Platform-specific paths resolved successfully");
    }
    
    /**
     * Get cross-platform path with variable substitution
     */
    private String getCrossPlatformPath(String propertyName) {
        String path = crossPlatformProperties.getProperty(propertyName);
        
        if (path != null) {
            // Replace system properties
            path = path.replace("${file.separator}", File.separator);
            path = path.replace("${path.separator}", File.pathSeparator);
            path = path.replace("${user.home}", System.getProperty("user.home"));
            path = path.replace("${user.name}", System.getProperty("user.name"));
            path = path.replace("${java.io.tmpdir}", System.getProperty("java.io.tmpdir"));
            path = path.replace("${os.name}", System.getProperty("os.name"));
            path = path.replace("${os.arch}", System.getProperty("os.arch"));
            path = path.replace("${java.version}", System.getProperty("java.version"));
            path = path.replace("${java.home}", System.getProperty("java.home"));
            path = path.replace("${user.dir}", System.getProperty("user.dir"));
        }
        
        return path;
    }
    
    /**
     * Resolve browser binary paths
     */
    private void resolveBrowserPaths() {
        String chromePath = null;
        String firefoxPath = null;
        String edgePath = null;
        
        if (PlatformUtils.isWindows()) {
            chromePath = crossPlatformProperties.getProperty("ChromeWindowsPath");
            firefoxPath = crossPlatformProperties.getProperty("FirefoxWindowsPath");
            edgePath = crossPlatformProperties.getProperty("EdgeWindowsPath");
        } else if (PlatformUtils.isMac()) {
            chromePath = crossPlatformProperties.getProperty("ChromeMacPath");
            firefoxPath = crossPlatformProperties.getProperty("FirefoxMacPath");
            edgePath = crossPlatformProperties.getProperty("EdgeMacPath");
        } else if (PlatformUtils.isLinux()) {
            chromePath = crossPlatformProperties.getProperty("ChromeLinuxPath");
            firefoxPath = crossPlatformProperties.getProperty("FirefoxLinuxPath");
            edgePath = crossPlatformProperties.getProperty("EdgeLinuxPath");
        }
        
        // Check if browsers exist and set resolved paths
        if (chromePath != null && new File(chromePath).exists()) {
            crossPlatformProperties.setProperty("resolved.chrome.path", chromePath);
        }
        
        if (firefoxPath != null && new File(firefoxPath).exists()) {
            crossPlatformProperties.setProperty("resolved.firefox.path", firefoxPath);
        }
        
        if (edgePath != null && new File(edgePath).exists()) {
            crossPlatformProperties.setProperty("resolved.edge.path", edgePath);
        }
    }
    
    /**
     * Resolve mobile app paths
     */
    private void resolveMobileAppPaths() {
        String androidAppPath = null;
        String iosAppPath = null;
        
        if (PlatformUtils.isWindows()) {
            androidAppPath = crossPlatformProperties.getProperty("AndroidAppPathWindows");
        } else if (PlatformUtils.isMac()) {
            androidAppPath = crossPlatformProperties.getProperty("AndroidAppPathMac");
            iosAppPath = crossPlatformProperties.getProperty("iOSAppPathMac");
        } else if (PlatformUtils.isLinux()) {
            androidAppPath = crossPlatformProperties.getProperty("AndroidAppPathLinux");
        }
        
        // Check if apps exist and set resolved paths
        if (androidAppPath != null && new File(androidAppPath).exists()) {
            crossPlatformProperties.setProperty("resolved.android.app.path", androidAppPath);
        }
        
        if (iosAppPath != null && new File(iosAppPath).exists()) {
            crossPlatformProperties.setProperty("resolved.ios.app.path", iosAppPath);
        }
    }
    
    /**
     * Get property value with platform-specific resolution
     */
    public String getProperty(String key) {
        // First check cross-platform properties
        String value = crossPlatformProperties.getProperty(key);
        
        if (value != null) {
            return getCrossPlatformPath(value);
        }
        
        // Fallback to global properties
        value = globalProperties.getProperty(key);
        
        if (value != null) {
            return getCrossPlatformPath(value);
        }
        
        // Fallback to mobile properties
        value = mobileProperties.getProperty(key);
        
        if (value != null) {
            return getCrossPlatformPath(value);
        }
        
        // Fallback to API properties
        value = apiProperties.getProperty(key);
        
        if (value != null) {
            return getCrossPlatformPath(value);
        }
        
        return null;
    }
    
    /**
     * Get property value with default
     */
    public String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        return value != null ? value : defaultValue;
    }
    
    /**
     * Get boolean property
     */
    public boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = getProperty(key);
        return value != null ? Boolean.parseBoolean(value) : defaultValue;
    }
    
    /**
     * Get integer property
     */
    public int getIntProperty(String key, int defaultValue) {
        String value = getProperty(key);
        try {
            return value != null ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            logger.warning("Invalid integer value for property " + key + ": " + value);
            return defaultValue;
        }
    }
    
    /**
     * Get resolved download directory
     */
    public String getDownloadDirectory() {
        return getProperty("resolved.download.directory", PlatformUtils.getDefaultDownloadDir());
    }
    
    /**
     * Get resolved driver directory
     */
    public String getDriverDirectory() {
        return getProperty("resolved.driver.directory", PlatformUtils.getDriverDir());
    }
    
    /**
     * Get resolved browser path
     */
    public String getBrowserPath(String browserName) {
        return getProperty("resolved." + browserName.toLowerCase() + ".path");
    }
    
    /**
     * Get resolved mobile app path
     */
    public String getMobileAppPath(String platform) {
        return getProperty("resolved." + platform.toLowerCase() + ".app.path");
    }
    
    /**
     * Check if browser is installed
     */
    public boolean isBrowserInstalled(String browserName) {
        String browserPath = getBrowserPath(browserName);
        return browserPath != null && new File(browserPath).exists();
    }
    
    /**
     * Check if mobile app exists
     */
    public boolean isMobileAppAvailable(String platform) {
        String appPath = getMobileAppPath(platform);
        return appPath != null && new File(appPath).exists();
    }
    
    /**
     * Get platform-specific Appium URL
     */
    public String getAppiumURL() {
        if (PlatformUtils.isWindows()) {
            return getProperty("AppiumURLWindows", "http://127.0.0.1:4723/wd/hub");
        } else if (PlatformUtils.isMac()) {
            return getProperty("AppiumURLMac", "http://127.0.0.1:4723/wd/hub");
        } else if (PlatformUtils.isLinux()) {
            return getProperty("AppiumURLLinux", "http://127.0.0.1:4723/wd/hub");
        }
        
        return getProperty("AppiumURL", "http://127.0.0.1:4723/wd/hub");
    }
    
    /**
     * Get platform information
     */
    public String getPlatformInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Cross-Platform Configuration Information:\n");
        info.append("  Operating System: ").append(PlatformUtils.getOperatingSystem()).append("\n");
        info.append("  Architecture: ").append(PlatformUtils.getArchitecture()).append("\n");
        info.append("  Download Directory: ").append(getDownloadDirectory()).append("\n");
        info.append("  Driver Directory: ").append(getDriverDirectory()).append("\n");
        info.append("  Appium URL: ").append(getAppiumURL()).append("\n");
        info.append("  Chrome Installed: ").append(isBrowserInstalled("chrome") ? "✅" : "❌").append("\n");
        info.append("  Firefox Installed: ").append(isBrowserInstalled("firefox") ? "✅" : "❌").append("\n");
        info.append("  Edge Installed: ").append(isBrowserInstalled("edge") ? "✅" : "❌").append("\n");
        info.append("  Android App Available: ").append(isMobileAppAvailable("android") ? "✅" : "❌").append("\n");
        info.append("  iOS App Available: ").append(isMobileAppAvailable("ios") ? "✅" : "❌").append("\n");
        
        return info.toString();
    }
    
    /**
     * Reload configurations
     */
    public void reloadConfigurations() {
        logger.info("Reloading configurations...");
        loadConfigurations();
    }
}