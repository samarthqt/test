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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Date;
import java.util.Properties;
import java.io.IOException;

/**
 * Version utility class for QualiFrameV2 semantic versioning
 * 
 * <p>This class provides utilities for version checking, compatibility validation,
 * and version information retrieval.</p>
 * 
 * @author Qualitest
 * @version 2.0.1
 * @since 2022
 */
public class QualiFrameVersion {
    
    private static final String VERSION = "2.0.1";
    private static final String BUILD_DATE = "2024-01-15";
    private static final String MINIMUM_JAVA_VERSION = "15";
    private static final String MINIMUM_SELENIUM_VERSION = "4.18.0";
    
    private QualiFrameVersion() {
        // Utility class - prevent instantiation
    }
    
    /**
     * Get the current framework version
     * 
     * @return The current version string
     * 
     * @example
     * <pre>{@code
     * String version = QualiFrameVersion.getVersion();
     * System.out.println("QualiFrameV2 Version: " + version);
     * }</pre>
     */
    public static String getVersion() {
        return VERSION;
    }
    
    /**
     * Get the build date
     * 
     * @return The build date string
     */
    public static String getBuildDate() {
        return BUILD_DATE;
    }
    
    /**
     * Get the minimum required Java version
     * 
     * @return The minimum Java version string
     */
    public static String getMinimumJavaVersion() {
        return MINIMUM_JAVA_VERSION;
    }
    
    /**
     * Get the minimum required Selenium version
     * 
     * @return The minimum Selenium version string
     */
    public static String getMinimumSeleniumVersion() {
        return MINIMUM_SELENIUM_VERSION;
    }
    
    /**
     * Check if the current version is compatible with a given version
     * 
     * @param requiredVersion The version to check compatibility against
     * @return true if compatible, false otherwise
     * 
     * @example
     * <pre>{@code
     * boolean compatible = QualiFrameVersion.isCompatible("2.0.0");
     * if (!compatible) {
     *     System.err.println("Incompatible version detected");
     * }
     * }</pre>
     */
    public static boolean isCompatible(String requiredVersion) {
        try {
            String[] current = VERSION.split("/.");
            String[] required = requiredVersion.split("/.");
            
            // Check major version compatibility
            int currentMajor = Integer.parseInt(current[0]);
            int requiredMajor = Integer.parseInt(required[0]);
            
            if (currentMajor != requiredMajor) {
                return false;
            }
            
            // Check minor version compatibility
            int currentMinor = Integer.parseInt(current[1]);
            int requiredMinor = Integer.parseInt(required[1]);
            
            return currentMinor >= requiredMinor;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Check if the current Java version meets the minimum requirement
     * 
     * @return true if Java version is sufficient, false otherwise
     * 
     * @example
     * <pre>{@code
     * if (!QualiFrameVersion.isJavaVersionCompatible()) {
     *     throw new RuntimeException("Java version too old");
     * }
     * }</pre>
     */
    public static boolean isJavaVersionCompatible() {
        try {
            String javaVersion = System.getProperty("java.version");
            String[] current = javaVersion.split("/.");
            String[] required = MINIMUM_JAVA_VERSION.split("/.");
            
            int currentMajor = Integer.parseInt(current[0]);
            int requiredMajor = Integer.parseInt(required[0]);
            
            return currentMajor >= requiredMajor;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get detailed version information
     * 
     * @return Version information as a formatted string
     * 
     * @example
     * <pre>{@code
     * String info = QualiFrameVersion.getVersionInfo();
     * System.out.println(info);
     * }</pre>
     */
    public static String getVersionInfo() {
        StringBuilder info = new StringBuilder();
        info.append("QualiFrameV2 Version Information:\n");
        info.append("Version: ").append(VERSION).append("\n");
        info.append("Build Date: ").append(BUILD_DATE).append("\n");
        info.append("Minimum Java Version: ").append(MINIMUM_JAVA_VERSION).append("\n");
        info.append("Minimum Selenium Version: ").append(MINIMUM_SELENIUM_VERSION).append("\n");
        info.append("Current Java Version: ").append(System.getProperty("java.version")).append("\n");
        info.append("Java Version Compatible: ").append(isJavaVersionCompatible()).append("\n");
        return info.toString();
    }
    
    /**
     * Compare two version strings
     * 
     * @param version1 First version to compare
     * @param version2 Second version to compare
     * @return -1 if version1 < version2, 0 if equal, 1 if version1 > version2
     * 
     * @example
     * <pre>{@code
     * int result = QualiFrameVersion.compareVersions("2.0.1", "2.0.0");
     * // Returns 1 (2.0.1 is greater than 2.0.0)
     * }</pre>
     */
    public static int compareVersions(String version1, String version2) {
        try {
            String[] v1 = version1.split("/.");
            String[] v2 = version2.split("/.");
            
            int maxLength = Math.max(v1.length, v2.length);
            
            for (int i = 0; i < maxLength; i++) {
                int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
                int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
                
                if (num1 < num2) return -1;
                if (num1 > num2) return 1;
            }
            
            return 0;
            
        } catch (Exception e) {
            return 0;
        }
    }
    
    /**
     * Check if a version is newer than the current version
     * 
     * @param version The version to check
     * @return true if the given version is newer, false otherwise
     */
    public static boolean isNewerVersion(String version) {
        return compareVersions(version, VERSION) > 0;
    }
    
    /**
     * Get version components
     * 
     * @return Array containing [major, minor, patch] version numbers
     */
    public static int[] getVersionComponents() {
        try {
            String[] parts = VERSION.split("/.");
            return new int[]{
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2])
            };
        } catch (Exception e) {
            return new int[]{0, 0, 0};
        }
    }
    
    /**
     * Check if this is a pre-release version
     * 
     * @return true if pre-release, false otherwise
     */
    public static boolean isPreRelease() {
        return VERSION.contains("-alpha") || 
               VERSION.contains("-beta") || 
               VERSION.contains("-rc");
    }
    
    /**
     * Get the version type (MAJOR, MINOR, PATCH)
     * 
     * @return The version type as a string
     */
    public static String getVersionType() {
        int[] components = getVersionComponents();
        
        if (components[1] == 0 && components[2] == 0) {
            return "MAJOR";
        } else if (components[2] == 0) {
            return "MINOR";
        } else {
            return "PATCH";
        }
    }
    
    /**
     * Validate version format
     * 
     * @param version The version string to validate
     * @return true if valid format, false otherwise
     */
    public static boolean isValidVersionFormat(String version) {
        if (version == null || version.trim().isEmpty()) {
            return false;
        }
        
        // Check for semantic versioning format: X.Y.Z[-PRERELEASE][+BUILD]
        return version.matches("^/d+/./d+/./d+(-[a-zA-Z0-9.-]+)?(/+[a-zA-Z0-9.-]+)?$");
    }
    
    /**
     * Get framework capabilities based on version
     * 
     * @return Array of available capabilities
     */
    public static String[] getAvailableCapabilities() {
        int[] components = getVersionComponents();
        
        if (components[0] >= 2) {
            return new String[]{
                "Modern WebDriver (Selenium 4.x)",
                "Docker Containerization",
                "Performance Optimization",
                "AI/ML Integration",
                "Enhanced Security",
                "Multi-browser Support",
                "Mobile Emulation",
                "Cloud Integration"
            };
        } else {
            return new String[]{
                "Basic WebDriver Support",
                "TestNG Integration",
                "Cucumber BDD",
                "Basic Reporting"
            };
        }
    }
} 