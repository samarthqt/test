package com.framework.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.io.File;

/**
 * Cross-platform utility class for detecting and handling different operating systems
 * 
 * @author QualiFrameV2 Team
 * @version 2.0.1
 */
public class PlatformUtils {
    
    private static final Logger logger = Logger.getLogger(PlatformUtils.class.getName());
    
    public enum OperatingSystem {
        WINDOWS, MAC, LINUX, UNKNOWN
    }
    
    public enum Architecture {
        X86_64, ARM64, X86, UNKNOWN
    }
    
    private static OperatingSystem detectedOS = null;
    private static Architecture detectedArch = null;
    
    /**
     * Get the current operating system
     */
    public static OperatingSystem getOperatingSystem() {
        if (detectedOS == null) {
            String osName = System.getProperty("os.name").toLowerCase();
            
            if (osName.contains("win")) {
                detectedOS = OperatingSystem.WINDOWS;
            } else if (osName.contains("mac")) {
                detectedOS = OperatingSystem.MAC;
            } else if (osName.contains("nux") || osName.contains("nix")) {
                detectedOS = OperatingSystem.LINUX;
            } else {
                detectedOS = OperatingSystem.UNKNOWN;
            }
            
            logger.info("Detected operating system: " + detectedOS);
        }
        return detectedOS;
    }
    
    /**
     * Get the current system architecture
     */
    public static Architecture getArchitecture() {
        if (detectedArch == null) {
            String arch = System.getProperty("os.arch").toLowerCase();
            
            if (arch.contains("x86_64") || arch.contains("amd64")) {
                detectedArch = Architecture.X86_64;
            } else if (arch.contains("aarch64") || arch.contains("arm64")) {
                detectedArch = Architecture.ARM64;
            } else if (arch.contains("x86")) {
                detectedArch = Architecture.X86;
            } else {
                detectedArch = Architecture.UNKNOWN;
            }
            
            logger.info("Detected architecture: " + detectedArch);
        }
        return detectedArch;
    }
    
    /**
     * Check if running on Windows
     */
    public static boolean isWindows() {
        return getOperatingSystem() == OperatingSystem.WINDOWS;
    }
    
    /**
     * Check if running on macOS
     */
    public static boolean isMac() {
        return getOperatingSystem() == OperatingSystem.MAC;
    }
    
    /**
     * Check if running on Linux
     */
    public static boolean isLinux() {
        return getOperatingSystem() == OperatingSystem.LINUX;
    }
    
    /**
     * Check if running on ARM64 architecture
     */
    public static boolean isARM64() {
        return getArchitecture() == Architecture.ARM64;
    }
    
    /**
     * Get the appropriate file separator for the current platform
     */
    public static String getFileSeparator() {
        return File.separator;
    }
    
    /**
     * Get the appropriate path separator for the current platform
     */
    public static String getPathSeparator() {
        return File.pathSeparator;
    }
    
    /**
     * Get the user's home directory
     */
    public static String getUserHome() {
        return System.getProperty("user.home");
    }
    
    /**
     * Get the temporary directory for the current platform
     */
    public static String getTempDir() {
        return System.getProperty("java.io.tmpdir");
    }
    
    /**
     * Get the appropriate download directory for the current platform
     */
    public static String getDefaultDownloadDir() {
        switch (getOperatingSystem()) {
            case WINDOWS:
                return getUserHome() + File.separator + "Downloads";
            case MAC:
                return getUserHome() + File.separator + "Downloads";
            case LINUX:
                return getUserHome() + File.separator + "Downloads";
            default:
                return getTempDir();
        }
    }
    
    /**
     * Get the appropriate driver directory for the current platform
     */
    public static String getDriverDir() {
        switch (getOperatingSystem()) {
            case WINDOWS:
                return getTempDir() + File.separator + "webdrivers";
            case MAC:
                return getTempDir() + File.separator + "webdrivers";
            case LINUX:
                return getTempDir() + File.separator + "webdrivers";
            default:
                return getTempDir();
        }
    }
    
    /**
     * Get the appropriate executable extension for the current platform
     */
    public static String getExecutableExtension() {
        return isWindows() ? ".exe" : "";
    }
    
    /**
     * Get the appropriate command for the current platform
     */
    public static String getCommand(String baseCommand) {
        if (isWindows()) {
            return baseCommand + ".exe";
        }
        return baseCommand;
    }
    
    /**
     * Create a cross-platform path
     */
    public static Path createPath(String... parts) {
        return Paths.get(parts[0], parts).subpath(1, parts.length);
    }
    
    /**
     * Get the appropriate Chrome binary path for the current platform
     */
    public static String getChromeBinaryPath() {
        switch (getOperatingSystem()) {
            case WINDOWS:
                return "/tmp/Program Files/Google/Chrome/Application/chrome.exe";
            case MAC:
                return "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
            case LINUX:
                return "/usr/bin/google-chrome";
            default:
                return null;
        }
    }
    
    /**
     * Get the appropriate Firefox binary path for the current platform
     */
    public static String getFirefoxBinaryPath() {
        switch (getOperatingSystem()) {
            case WINDOWS:
                return "/tmp/Program Files/Mozilla Firefox/firefox.exe";
            case MAC:
                return "/Applications/Firefox.app/Contents/MacOS/firefox";
            case LINUX:
                return "/usr/bin/firefox";
        }
        
        return null;
    }
    
    /**
     * Get the appropriate Edge binary path for the current platform
     */
    public static String getEdgeBinaryPath() {
        switch (getOperatingSystem()) {
            case WINDOWS:
                return "/tmp/Program Files (x86)/Microsoft/Edge/Application/msedge.exe";
            case MAC:
                return "/Applications/Microsoft Edge.app/Contents/MacOS/Microsoft Edge";
            case LINUX:
                return "/usr/bin/microsoft-edge";
            default:
                return null;
        }
    }
    
    /**
     * Check if a browser is installed on the current platform
     */
    public static boolean isBrowserInstalled(String browserName) {
        String binaryPath = null;
        
        switch (browserName.toLowerCase()) {
            case "chrome":
                binaryPath = getChromeBinaryPath();
                break;
            case "firefox":
                binaryPath = getFirefoxBinaryPath();
                break;
            case "edge":
                binaryPath = getEdgeBinaryPath();
                break;
        }
        
        if (binaryPath != null) {
            File binary = new File(binaryPath);
            return binary.exists() && binary.canExecute();
        }
        
        return false;
    }
    
    /**
     * Get platform-specific system information
     */
    public static String getPlatformInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Operating System: ").append(getOperatingSystem()).append("\n");
        info.append("Architecture: ").append(getArchitecture()).append("\n");
        info.append("Java Version: ").append(System.getProperty("java.version")).append("\n");
        info.append("Java Home: ").append(System.getProperty("java.home")).append("\n");
        info.append("User Home: ").append(getUserHome()).append("\n");
        info.append("Temp Directory: ").append(getTempDir()).append("\n");
        info.append("File Separator: ").append(getFileSeparator()).append("\n");
        info.append("Path Separator: ").append(getPathSeparator()).append("\n");
        
        return info.toString();
    }
}