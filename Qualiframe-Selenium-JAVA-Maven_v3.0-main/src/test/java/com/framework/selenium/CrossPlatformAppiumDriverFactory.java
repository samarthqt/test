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
package com.framework.selenium;

import com.framework.utils.PlatformUtils;
import com.framework.components.FrameworkException;
import com.framework.components.Settings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
// MobileCapabilityType removed in Appium Java Client 9.x - using string literals instead
import org.openqa.selenium.remote.DesiredCapabilities;
import com.framework.selenium.MobileExecutionPlatform;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.Properties;
import java.util.Set;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Cross-platform Appium driver factory for Android and iOS automation
 * Works on Windows, macOS, and Linux platforms
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class CrossPlatformAppiumDriverFactory {
    
    private static final Logger logger = Logger.getLogger(CrossPlatformAppiumDriverFactory.class.getName());
    private static Properties mobileProperties = Settings.getMobilePropertiesInstance();
    
    private CrossPlatformAppiumDriverFactory() {
        // Prevent external instantiation
    }
    
    /**
     * Get a cross-platform Appium driver for the specified platform
     * 
     * @param executionPlatform The mobile execution platform (Android/iOS)
     * @param deviceName The device name or UDID
     * @param version The mobile OS version
     * @param installApp Whether to install the app
     * @param appiumURL The Appium server URL
     * @return AppiumDriver instance
     */
    @SuppressWarnings("rawtypes")
    public static AppiumDriver getCrossPlatformAppiumDriver(MobileExecutionPlatform executionPlatform, 
                                                           String deviceName, String version, 
                                                           Boolean installApp, String appiumURL) {
        
        logger.info("Creating cross-platform Appium driver for: " + executionPlatform);
        logger.info("Device: " + deviceName + ", Version: " + version);
        logger.info("Appium URL: " + appiumURL);
        
        try {
            switch (executionPlatform) {
                case Android:
                    return createAndroidDriver(deviceName, version, installApp, appiumURL);
                case iOS:
                    return createIOSDriver(deviceName, version, installApp, appiumURL);
                case WEB_ANDROID:
                    return createWebAndroidDriver(deviceName, version, appiumURL);
                case WEB_IOS:
                    return createWebIOSDriver(deviceName, version, appiumURL);
                default:
                    throw new FrameworkException("Unsupported mobile execution platform: " + executionPlatform);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage() != null ? e.getMessage() : "Unknown error";
            logger.severe("Failed to create Appium driver: " + errorMessage);
            throw new FrameworkException("Appium driver creation failed: " + errorMessage);
        }
    }
    
    /**
     * Create Android driver with cross-platform app path resolution
     */
    @SuppressWarnings("rawtypes")
    private static AppiumDriver createAndroidDriver(String deviceName, String version, 
                                                   Boolean installApp, String appiumURL) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Set basic Android capabilities
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("automationName", "UiAutomator2");
        
        // Set app installation if required
        if (installApp && Boolean.parseBoolean(mobileProperties.getProperty("InstallApplicationInDevice"))) {
            String appPath = getCrossPlatformAppPath("Android");
            if (appPath != null && new File(appPath).exists()) {
                capabilities.setCapability("app", appPath);
            } else {
                logger.warning("Android app not found at: " + appPath);
            }
        }
        
        // Set app package and activity
        capabilities.setCapability("appPackage", mobileProperties.getProperty("Application_Package_Name"));
        capabilities.setCapability("appActivity", mobileProperties.getProperty("Application_MainActivity_Name"));
        
        // Set reset preferences
        if (!Boolean.parseBoolean(mobileProperties.getProperty("ResetApp"))) {
            capabilities.setCapability("noReset", "true");
        }
        
        // Set additional Android capabilities
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        
        try {
            return new AndroidDriver(new URL(appiumURL), capabilities);
        } catch (MalformedURLException e) {
            throw new FrameworkException("Invalid Appium URL: " + appiumURL);
        }
    }
    
    /**
     * Create iOS driver with cross-platform app path resolution
     */
    @SuppressWarnings("rawtypes")
    private static AppiumDriver createIOSDriver(String deviceName, String version, 
                                               Boolean installApp, String appiumURL) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Set basic iOS capabilities
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("automationName", "XCUITest");
        
        // Set app installation if required
        if (installApp && Boolean.parseBoolean(mobileProperties.getProperty("InstallApplicationInDevice"))) {
            String appPath = getCrossPlatformAppPath("iOS");
            if (appPath != null && new File(appPath).exists()) {
                capabilities.setCapability("app", appPath);
            } else {
                logger.warning("iOS app not found at: " + appPath);
            }
        }
        
        // Set iOS-specific capabilities
        capabilities.setCapability("udid", mobileProperties.getProperty("im_udid_1"));
        capabilities.setCapability("updatedWDABundleId", mobileProperties.getProperty("ios_bundleid"));
        capabilities.setCapability("noReset", mobileProperties.getProperty("ios_appreset"));
        capabilities.setCapability("useNewWDA", mobileProperties.getProperty("false"));
        
        // Set additional iOS capabilities
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("autoDismissAlerts", "true");
        capabilities.setCapability("wdaStartupRetries", "4");
        capabilities.setCapability("iosInstallPause", "8000");
        
        try {
            return new IOSDriver(new URL(appiumURL), capabilities);
        } catch (MalformedURLException e) {
            throw new FrameworkException("Invalid Appium URL: " + appiumURL);
        }
    }
    
    /**
     * Create Web Android driver for mobile web testing
     */
    @SuppressWarnings("rawtypes")
    private static AppiumDriver createWebAndroidDriver(String deviceName, String version, String appiumURL) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("automationName", "UiAutomator2");
        
        // Set Chrome-specific capabilities
        capabilities.setCapability("chromedriverExecutable", getChromeDriverPath());
        capabilities.setCapability("chromeOptions", getChromeOptions());
        
        try {
            return new AndroidDriver(new URL(appiumURL), capabilities);
        } catch (MalformedURLException e) {
            throw new FrameworkException("Invalid Appium URL: " + appiumURL);
        }
    }
    
    /**
     * Create Web iOS driver for mobile web testing
     */
    @SuppressWarnings("rawtypes")
    private static AppiumDriver createWebIOSDriver(String deviceName, String version, String appiumURL) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", deviceName);
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("browserName", "Safari");
        
        // Set Safari-specific capabilities
        capabilities.setCapability("safariInitialUrl", "https://www.google.com");
        capabilities.setCapability("safariAllowPopups", "true");
        capabilities.setCapability("safariIgnoreFraudWarning", "true");
        
        try {
            return new IOSDriver(new URL(appiumURL), capabilities);
        } catch (MalformedURLException e) {
            throw new FrameworkException("Invalid Appium URL: " + appiumURL);
        }
    }
    
    /**
     * Get cross-platform app path based on the current operating system
     */
    private static String getCrossPlatformAppPath(String platform) {
        String appPath = null;
        
        if ("Android".equals(platform)) {
            if (PlatformUtils.isWindows()) {
                appPath = mobileProperties.getProperty("AndroidAppPathWindows");
            } else if (PlatformUtils.isMac()) {
                appPath = mobileProperties.getProperty("AndroidAppPathMac");
            } else if (PlatformUtils.isLinux()) {
                appPath = mobileProperties.getProperty("AndroidAppPathLinux");
            }
        } else if ("iOS".equals(platform)) {
            if (PlatformUtils.isMac()) {
                appPath = mobileProperties.getProperty("iOSAppPathMac");
            } else {
                logger.warning("iOS testing is only supported on macOS");
                return null;
            }
        }
        
        // Fallback to generic path if platform-specific path is not found
        if (appPath == null || !new File(appPath).exists()) {
            if ("Android".equals(platform)) {
                appPath = mobileProperties.getProperty("AndroidApplicationPath");
            } else if ("iOS".equals(platform)) {
                appPath = mobileProperties.getProperty("ios_apppath");
            }
        }
        
        return appPath;
    }
    
    /**
     * Get Chrome driver path for the current platform
     */
    private static String getChromeDriverPath() {
        String driverDir = PlatformUtils.getDriverDir();
        String executableName = "chromedriver" + PlatformUtils.getExecutableExtension();
        return driverDir + PlatformUtils.getFileSeparator() + executableName;
    }
    
    /**
     * Get Chrome options for mobile web testing
     */
    private static String getChromeOptions() {
        return "--disable-web-security,--disable-features=VizDisplayCompositor,--disable-extensions,--disable-plugins,--disable-images,--disable-javascript";
    }
    
    /**
     * Check if the current platform supports the requested mobile platform
     */
    public static boolean isMobilePlatformSupported(MobileExecutionPlatform executionPlatform) {
        switch (executionPlatform) {
            case Android:
            case WEB_ANDROID:
                return true; // Android testing supported on all platforms
            case iOS:
            case WEB_IOS:
                return PlatformUtils.isMac(); // iOS testing only supported on macOS
            default:
                return false;
        }
    }
    
    /**
     * Get the recommended mobile execution platform for the current OS
     */
    public static MobileExecutionPlatform getRecommendedMobilePlatform() {
        if (PlatformUtils.isMac()) {
            return MobileExecutionPlatform.iOS; // macOS can test both iOS and Android
        } else {
            return MobileExecutionPlatform.Android; // Windows/Linux can only test Android
        }
    }
    
    /**
     * Get platform information for mobile testing
     */
    public static String getMobilePlatformInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Mobile Platform Support:\n");
        info.append("  Android: ").append(isMobilePlatformSupported(MobileExecutionPlatform.Android) ? "✅" : "❌").append("\n");
        info.append("  iOS: ").append(isMobilePlatformSupported(MobileExecutionPlatform.iOS) ? "✅" : "❌").append("\n");
        info.append("  Web Android: ").append(isMobilePlatformSupported(MobileExecutionPlatform.WEB_ANDROID) ? "✅" : "❌").append("\n");
        info.append("  Web iOS: ").append(isMobilePlatformSupported(MobileExecutionPlatform.WEB_IOS) ? "✅" : "❌").append("\n");
        info.append("  Recommended Platform: ").append(getRecommendedMobilePlatform()).append("\n");
        info.append("  Current OS: ").append(PlatformUtils.getOperatingSystem()).append("\n");
        
        return info.toString();
    }
}