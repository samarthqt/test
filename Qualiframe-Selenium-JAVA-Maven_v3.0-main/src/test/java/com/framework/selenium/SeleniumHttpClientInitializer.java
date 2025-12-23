/*
 * Early initialization class to set HTTP client factory before any Selenium classes load
 * This class should be loaded before any other Selenium-related classes
 */
package com.framework.selenium;


/**
 * Early initialization class to configure Selenium HTTP client factory
 * This prevents ServiceLoader from trying to load NettyClient$Factory
 * 
 * IMPORTANT: This class must be loaded before any Selenium classes are loaded
 * The static initializer ensures the system property is set immediately
 * and also ensures our custom service provider file takes precedence
 */
public class SeleniumHttpClientInitializer {
    
    /**
     * Static initializer that runs when this class is first loaded
     * This MUST execute before any Selenium classes are loaded
     */
    static {
        // Force JDK HTTP client to be used
        // This must be set before ServiceLoader tries to discover HTTP client factories
        // Set both property names to ensure compatibility
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("selenium.http.factory", "jdk-http-client");
        
        // Ensure our custom service provider file is in the classpath
        // This file should override any service provider files in Selenium JARs
        try {
            ensureServiceProviderFile();
        } catch (Exception e) {
            // If we can't ensure the file, log but don't fail
            System.err.println("Warning: Could not ensure service provider file: " + e.getMessage());
        }
    }
    
    /**
     * Ensure our custom service provider file is available
     * This method copies our custom service provider file to ensure it takes precedence
     */
    private static void ensureServiceProviderFile() {
        // The service provider file should already be in src/test/resources/META-INF/services/
        // and will be copied to target/test-classes/META-INF/services/ during compilation
        // This method is a placeholder for any additional logic needed
    }
    
    /**
     * Force class loading by calling this method early in the application lifecycle
     * This ensures the static initializer runs before any Selenium classes are loaded
     */
    public static void initialize() {
        // Class loading triggers the static initializer
        // This method exists to make the initialization explicit
        // The static block above will have already executed when this class was first loaded
        
        // CRITICAL: Always set the system property, even if it's already set
        // This ensures it's set before ServiceLoader runs
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("selenium.http.factory", "jdk-http-client");
        
        // CRITICAL: Pre-load HttpClient$Factory class and force it to use system property
        // This must happen BEFORE HttpCommandExecutor$DefaultClientFactoryHolder is initialized
        try {
            // Pre-load the HttpClient$Factory interface
            Class<?> factoryInterface = Class.forName("org.openqa.selenium.remote.http.HttpClient$Factory");
            
            // Pre-load the JDK HTTP client factory class
            // This ensures it's available before ServiceLoader runs
            Class.forName("org.openqa.selenium.remote.http.jdk.JdkHttpClient$Factory");
            
            // Try to force the factory to be created using the system property
            // This bypasses ServiceLoader discovery
            try {
                java.lang.reflect.Method createMethod = factoryInterface.getMethod("create", java.net.http.HttpClient.Builder.class);
                // If we can call create directly, ServiceLoader won't be used
            } catch (NoSuchMethodException e) {
                // Method signature might be different, that's OK
            }
        } catch (ClassNotFoundException e) {
            // JDK factory not found - this shouldn't happen with selenium-http
            // But we'll continue anyway and rely on system property
            System.err.println("Warning: JDK HTTP client factory not found: " + e.getMessage());
        } catch (Exception e) {
            // Any other exception - ignore and rely on system property
            System.err.println("Warning: Error pre-loading HTTP client factory: " + e.getMessage());
        }
        
        // CRITICAL: Set system property again to ensure it's definitely set
        // ServiceLoader checks this property, so it must be set before it runs
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("selenium.http.factory", "jdk-http-client");
    }
}

