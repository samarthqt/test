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
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Cross-platform WebDriver factory that works on Windows, macOS, and Linux
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class CrossPlatformWebDriverFactory {
    
    private static final Logger logger = Logger.getLogger(CrossPlatformWebDriverFactory.class.getName());
    private static Properties properties = Settings.getInstance();
    
    private CrossPlatformWebDriverFactory() {
        // Prevent external instantiation
    }
    
    /**
     * Get a cross-platform WebDriver based on the execution mode
     * 
     * @param executionMode The execution mode
     * @return WebDriver instance
     */
    @SuppressWarnings("rawtypes")
    public static RemoteWebDriver getCrossPlatformDriver(ExecutionMode executionMode) {
        logger.info("Creating cross-platform driver for mode: " + executionMode);
        
        switch (executionMode) {
            case WINDOWS:
                return getWindowsDriver();
            case MAC:
                return getMacDriver();
            case LINUX:
                return getLinuxDriver();
            case CROSS_PLATFORM:
                return getCrossPlatformDriver();
            default:
                throw new FrameworkException("Unhandled ExecutionMode: " + executionMode);
        }
    }
    
    /**
     * Get Windows-specific driver
     */
    private static RemoteWebDriver getWindowsDriver() {
        if (!PlatformUtils.isWindows()) {
            logger.warning("Windows driver requested on non-Windows platform");
            throw new FrameworkException("Windows driver can only be used on Windows platform");
        }
        
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", properties.getProperty("WindowsAppPath"));
            capabilities.setCapability("platformName", properties.getProperty("WindowsPlatformName"));
            capabilities.setCapability("deviceName", properties.getProperty("WindowsDeviceName"));
            
            String url = properties.getProperty("WindowsMachineURL") + ":" + properties.getProperty("WindowsMachinePort");
            WindowsDriver driver = new WindowsDriver(new URL(url), capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            
            return driver;
        } catch (MalformedURLException e) {
            throw new FrameworkException("Invalid Windows driver URL: " + e.getMessage());
        } catch (Exception e) {
            throw new FrameworkException("Failed to create Windows driver: " + e.getMessage());
        }
    }
    
    /**
     * Get macOS-specific driver
     */
    private static RemoteWebDriver getMacDriver() {
        if (!PlatformUtils.isMac()) {
            logger.warning("Mac driver requested on non-Mac platform");
            throw new FrameworkException("Mac driver can only be used on macOS platform");
        }
        
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", properties.getProperty("MacAppPath"));
            capabilities.setCapability("platformName", properties.getProperty("MacPlatformName"));
            capabilities.setCapability("deviceName", properties.getProperty("MacDeviceName"));
            
            String url = properties.getProperty("MacMachineURL") + ":" + properties.getProperty("MacMachinePort");
            RemoteWebDriver driver = new RemoteWebDriver(new URL(url), capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            
            return driver;
        } catch (MalformedURLException e) {
            throw new FrameworkException("Invalid Mac driver URL: " + e.getMessage());
        } catch (Exception e) {
            throw new FrameworkException("Failed to create Mac driver: " + e.getMessage());
        }
    }
    
    /**
     * Get Linux-specific driver
     */
    private static RemoteWebDriver getLinuxDriver() {
        if (!PlatformUtils.isLinux()) {
            logger.warning("Linux driver requested on non-Linux platform");
            throw new FrameworkException("Linux driver can only be used on Linux platform");
        }
        
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", properties.getProperty("LinuxAppPath"));
            capabilities.setCapability("platformName", properties.getProperty("LinuxPlatformName"));
            capabilities.setCapability("deviceName", properties.getProperty("LinuxDeviceName"));
            
            String url = properties.getProperty("LinuxMachineURL") + ":" + properties.getProperty("LinuxMachinePort");
            RemoteWebDriver driver = new RemoteWebDriver(new URL(url), capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            
            return driver;
        } catch (MalformedURLException e) {
            throw new FrameworkException("Invalid Linux driver URL: " + e.getMessage());
        } catch (Exception e) {
            throw new FrameworkException("Failed to create Linux driver: " + e.getMessage());
        }
    }
    
    /**
     * Get cross-platform driver that automatically detects the platform
     */
    private static RemoteWebDriver getCrossPlatformDriver() {
        logger.info("Auto-detecting platform for cross-platform driver");
        
        if (PlatformUtils.isWindows()) {
            return getWindowsDriver();
        } else if (PlatformUtils.isMac()) {
            return getMacDriver();
        } else if (PlatformUtils.isLinux()) {
            return getLinuxDriver();
        } else {
            throw new FrameworkException("Unsupported platform: " + PlatformUtils.getOperatingSystem());
        }
    }
    
    /**
     * Check if the current platform supports the requested execution mode
     */
    public static boolean isPlatformSupported(ExecutionMode executionMode) {
        switch (executionMode) {
            case WINDOWS:
                return PlatformUtils.isWindows();
            case MAC:
                return PlatformUtils.isMac();
            case LINUX:
                return PlatformUtils.isLinux();
            case CROSS_PLATFORM:
                return true; // Always supported
            default:
                return false;
        }
    }
    
    /**
     * Get the recommended execution mode for the current platform
     */
    public static ExecutionMode getRecommendedExecutionMode() {
        if (PlatformUtils.isWindows()) {
            return ExecutionMode.WINDOWS;
        } else if (PlatformUtils.isMac()) {
            return ExecutionMode.MAC;
        } else if (PlatformUtils.isLinux()) {
            return ExecutionMode.LINUX;
        } else {
            return ExecutionMode.CROSS_PLATFORM;
        }
    }
    
    /**
     * Get platform information for debugging
     */
    public static String getPlatformInfo() {
        return PlatformUtils.getPlatformInfo();
    }
    
    /**
     * Execution modes for different platforms
     */
    public enum ExecutionMode {
        WINDOWS, MAC, LINUX, CROSS_PLATFORM
    }
}