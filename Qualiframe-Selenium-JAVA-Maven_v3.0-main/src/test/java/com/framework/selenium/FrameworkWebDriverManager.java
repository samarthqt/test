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

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import com.framework.components.FrameworkException;
import com.framework.components.Settings;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.time.Duration;
import java.net.URL;

/**
 * Enhanced WebDriver Manager with automatic driver management
 * 
 * <h2>Features:</h2>
 * <ul>
 *   <li><strong>Automatic Driver Management:</strong> Downloads and manages drivers automatically</li>
 *   <li><strong>Multi-Browser Support:</strong> Chrome, Firefox, Safari, Edge</li>
 *   <li><strong>Remote Execution:</strong> Selenium Grid and cloud platform support</li>
 *   <li><strong>Driver Caching:</strong> Efficient driver storage and reuse</li>
 *   <li><strong>Version Management:</strong> Automatic version detection and updates</li>
 * </ul>
 * 
 * @author Qualitest
 * @version 2.1.0
 * @since 2024
 */
public class FrameworkWebDriverManager {
    
    private static final Logger logger = Logger.getLogger(WebDriverManager.class.getName());
    private static final ConcurrentHashMap<String, WebDriver> driverCache = new ConcurrentHashMap<>();
    private static final Properties settings = Settings.getInstance();
    
    /**
     * Initialize WebDriver Manager with default settings
     */
    static {
        // Configure WebDriver Manager
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
        
        // Set cache timeout (24 hours) - commented out due to API changes
        // WebDriverManager.chromedriver().cacheTimeout(86400);
        // WebDriverManager.firefoxdriver().cacheTimeout(86400);
        // WebDriverManager.edgedriver().cacheTimeout(86400);
        
        logger.info("WebDriver Manager initialized successfully");
    }
    
    /**
     * Create WebDriver instance based on configuration
     * 
     * @param testConfiguration The test configuration ID
     * @return WebDriver instance
     * @throws FrameworkException if driver creation fails
     */
    public static WebDriver createDriver(String testConfiguration) throws FrameworkException {
        try {
            if (testConfiguration == null || testConfiguration.isEmpty()) {
                testConfiguration = settings.getProperty("TestConfigurationID");
                if (testConfiguration == null) {
                    testConfiguration = "LOCALChrome";
                }
            }
            
            // Check cache first
            String cacheKey = generateCacheKey(testConfiguration);
            if (driverCache.containsKey(cacheKey)) {
                WebDriver cachedDriver = driverCache.get(cacheKey);
                if (isDriverAlive(cachedDriver)) {
                    logger.info("Using cached WebDriver instance for: " + testConfiguration);
                    return cachedDriver;
                } else {
                    driverCache.remove(cacheKey);
                }
            }
            
            WebDriver driver = createNewDriver(testConfiguration);
            driverCache.put(cacheKey, driver);
            
            logger.info("Created new WebDriver instance for: " + testConfiguration);
            return driver;
            
        } catch (Exception e) {
            logger.severe("Failed to create WebDriver: " + e.getMessage());
            throw new FrameworkException("Failed to create WebDriver for configuration: " + testConfiguration + " - " + e.getMessage());
        }
    }
    
    /**
     * Create new WebDriver instance
     * 
     * @param testConfiguration The test configuration
     * @return WebDriver instance
     */
    private static WebDriver createNewDriver(String testConfiguration) {
        switch (testConfiguration.toUpperCase()) {
            case "LOCALCHROME":
                return createChromeDriver(false);
            case "LOCALCHROME_HEADLESS":
                return createChromeDriver(true);
            case "LOCALFIREFOX":
                return createFirefoxDriver(false);
            case "LOCALFIREFOX_HEADLESS":
                return createFirefoxDriver(true);
            case "LOCALEDGE":
                return createEdgeDriver(false);
            case "LOCALSAFARI":
                return createSafariDriver();
            case "SAUCELABSCHROME":
            case "SAUCELABSFIREFOX":
            case "SAUCELABSEDGE":
                return createSauceLabsDriver(testConfiguration);
            case "LAMBDATESTCHROME":
            case "LAMBDATESTFIREFOX":
            case "LAMBDATESTEDGE":
                return createLambdaTestDriver(testConfiguration);
            case "BROWSERSTACKCHROME":
            case "BROWSERSTACKFIREFOX":
            case "BROWSERSTACKEDGE":
                return createBrowserStackDriver(testConfiguration);
            default:
                logger.warning("Unknown configuration: " + testConfiguration + ". Using Chrome as default.");
                return createChromeDriver(false);
        }
    }
    
    /**
     * Create Chrome WebDriver
     * 
     * @param headless Whether to run in headless mode
     * @return Chrome WebDriver
     */
    private static WebDriver createChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-features=PasswordLeakDetection");
        options.addArguments("--disable-features=PasswordManagerOnboarding");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        
        // Password Manager and Breach Detection Settings
        // Disable Google Password Manager to prevent password breach popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("credentials_enable_autosignin", false);
        prefs.put("password_manager_enabled", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);
        
        if (headless) {
            options.addArguments("--headless=new");
        }
        
        // Add mobile emulation if specified
        String mobileEmulation = settings.getProperty("MobileEmulation");
        if (mobileEmulation != null && !mobileEmulation.isEmpty()) {
            options.addArguments("--user-agent=" + mobileEmulation);
        }
        
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        // Disable password leak detection using CDP
        disablePasswordLeakDetection(driver);
        
        return driver;
    }
    
    /**
     * Create Firefox WebDriver
     * 
     * @param headless Whether to run in headless mode
     * @return Firefox WebDriver
     */
    private static WebDriver createFirefoxDriver(boolean headless) {
        WebDriverManager.firefoxdriver().setup();
        
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        
        if (headless) {
            options.addArguments("--headless");
        }
        
        FirefoxDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        return driver;
    }
    
    /**
     * Create Edge WebDriver
     * 
     * @param headless Whether to run in headless mode
     * @return Edge WebDriver
     */
    private static WebDriver createEdgeDriver(boolean headless) {
        WebDriverManager.edgedriver().setup();
        
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        if (headless) {
            options.addArguments("--headless");
        }
        
        EdgeDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        return driver;
    }
    
    /**
     * Create Safari WebDriver
     * 
     * @return Safari WebDriver
     */
    private static WebDriver createSafariDriver() {
        SafariOptions options = new SafariOptions();
        SafariDriver driver = new SafariDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        return driver;
    }
    
    /**
     * Create SauceLabs WebDriver
     * 
     * @param testConfiguration The test configuration
     * @return Remote WebDriver for SauceLabs
     */
    private static WebDriver createSauceLabsDriver(String testConfiguration) {
        try {
            String username = settings.getProperty("SauceLabsUsername");
            String accessKey = settings.getProperty("SauceLabsAccessKey");
            if (username == null) username = "";
            if (accessKey == null) accessKey = "";
            String hubUrl = "https://" + username + ":" + accessKey + "@ondemand.saucelabs.com:443/wd/hub";
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("username", username);
            capabilities.setCapability("accessKey", accessKey);
            
            if (testConfiguration.contains("CHROME")) {
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("platformName", "Windows 10");
            } else if (testConfiguration.contains("FIREFOX")) {
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("platformName", "Windows 10");
            } else if (testConfiguration.contains("EDGE")) {
                capabilities.setCapability("browserName", "MicrosoftEdge");
                capabilities.setCapability("platformName", "Windows 10");
            }
            
            return new RemoteWebDriver(new URL(hubUrl), capabilities);
            
        } catch (Exception e) {
            logger.severe("Failed to create SauceLabs driver: " + e.getMessage());
            throw new RuntimeException("SauceLabs driver creation failed", e);
        }
    }
    
    /**
     * Create LambdaTest WebDriver
     * 
     * @param testConfiguration The test configuration
     * @return Remote WebDriver for LambdaTest
     */
    private static WebDriver createLambdaTestDriver(String testConfiguration) {
        try {
            String username = settings.getProperty("LambdaTestUsername");
            String accessKey = settings.getProperty("LambdaTestAccessKey");
            if (username == null) username = "";
            if (accessKey == null) accessKey = "";
            String hubUrl = "https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("user", username);
            capabilities.setCapability("accessKey", accessKey);
            
            if (testConfiguration.contains("CHROME")) {
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("platformName", "Windows 10");
            } else if (testConfiguration.contains("FIREFOX")) {
                capabilities.setCapability("browserName", "Firefox");
                capabilities.setCapability("platformName", "Windows 10");
            } else if (testConfiguration.contains("EDGE")) {
                capabilities.setCapability("browserName", "MicrosoftEdge");
                capabilities.setCapability("platformName", "Windows 10");
            }
            
            return new RemoteWebDriver(new URL(hubUrl), capabilities);
            
        } catch (Exception e) {
            logger.severe("Failed to create LambdaTest driver: " + e.getMessage());
            throw new RuntimeException("LambdaTest driver creation failed", e);
        }
    }
    
    /**
     * Create BrowserStack WebDriver
     * 
     * @param testConfiguration The test configuration
     * @return Remote WebDriver for BrowserStack
     */
    private static WebDriver createBrowserStackDriver(String testConfiguration) {
        try {
            String username = settings.getProperty("BrowserStackUsername");
            String accessKey = settings.getProperty("BrowserStackAccessKey");
            if (username == null) username = "";
            if (accessKey == null) accessKey = "";
            String hubUrl = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserstack.user", username);
            capabilities.setCapability("browserstack.key", accessKey);
            
            if (testConfiguration.contains("CHROME")) {
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("os", "Windows");
                capabilities.setCapability("os_version", "10");
            } else if (testConfiguration.contains("FIREFOX")) {
                capabilities.setCapability("browserName", "Firefox");
                capabilities.setCapability("os", "Windows");
                capabilities.setCapability("os_version", "10");
            } else if (testConfiguration.contains("EDGE")) {
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("os", "Windows");
                capabilities.setCapability("os_version", "10");
            }
            
            return new RemoteWebDriver(new URL(hubUrl), capabilities);
            
        } catch (Exception e) {
            logger.severe("Failed to create BrowserStack driver: " + e.getMessage());
            throw new RuntimeException("BrowserStack driver creation failed", e);
        }
    }
    
    /**
     * Generate cache key for driver
     * 
     * @param testConfiguration The test configuration
     * @return Cache key
     */
    private static String generateCacheKey(String testConfiguration) {
        return testConfiguration + "_" + Thread.currentThread().getId();
    }
    
    /**
     * Check if driver is still alive
     * 
     * @param driver The WebDriver instance
     * @return true if driver is alive, false otherwise
     */
    private static boolean isDriverAlive(WebDriver driver) {
        try {
            driver.getCurrentUrl();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Quit and remove driver from cache
     * 
     * @param driver The WebDriver instance
     */
    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            try {
                driver.quit();
                logger.info("WebDriver quit successfully");
            } catch (Exception e) {
                logger.warning("Error quitting WebDriver: " + e.getMessage());
            }
            
            // Remove from cache
            driverCache.entrySet().removeIf(entry -> entry.getValue() == driver);
        }
    }
    
    /**
     * Clear all cached drivers
     */
    public static void clearCache() {
        driverCache.values().forEach(FrameworkWebDriverManager::quitDriver);
        driverCache.clear();
        logger.info("WebDriver cache cleared");
    }
    
    /**
     * Disables password leak detection using Chrome DevTools Protocol (CDP)
     * 
     * @param driver The ChromeDriver instance
     */
    private static void disablePasswordLeakDetection(ChromeDriver driver) {
        // Password leak detection is disabled via Chrome preferences and arguments
        // set in createChromeDriver(). No additional CDP commands needed.
        // The Chrome preferences (credentials_enable_service, password_manager_enabled, etc.)
        // and Chrome arguments (--disable-features=PasswordLeakDetection) should prevent
        // the password breach popup from appearing.
        // If the popup still appears, it will be handled by WebDriverFactory.handlePasswordBreachPopup().
    }
    
    /**
     * Get driver information
     * 
     * @param driver The WebDriver instance
     * @return Driver information string
     */
    public static String getDriverInfo(WebDriver driver) {
        if (driver instanceof RemoteWebDriver) {
            return "Remote WebDriver: " + ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        } else {
            return "Local WebDriver: " + driver.getClass().getSimpleName();
        }
    }
}