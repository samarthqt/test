package com.framework.examples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import com.framework.selenium.SeleniumTestParameters;
import com.framework.selenium.Browser;
import com.framework.selenium.ExecutionMode;
import com.framework.selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Method;

/**
 * Simple working test to verify the framework is functional
 * 
 * @author Qualitest
 * @version 2.0.1
 */
public class WorkingFrameworkTest {
    
    private WebDriver driver;
    private SeleniumTestParameters testParameters;
    
    @BeforeMethod
    public void setUp() {
        // Initialize test parameters
        testParameters = new SeleniumTestParameters("WorkingFrameworkTest", "testBasicFunctionality");
        testParameters.setBrowser(Browser.CHROME);
        testParameters.setExecutionMode(ExecutionMode.LOCAL);
        
        // Create WebDriver
        driver = WebDriverFactory.getWebDriver(testParameters);
    }
    
    @Test(description = "Test basic framework functionality")
    public void testBasicFunctionality() {
        try {
            // Navigate to a simple test page
            driver.get("https://www.google.com");
            
            // Verify page title
            String pageTitle = driver.getTitle();
            Assert.assertNotNull(pageTitle, "Page title should not be null");
            Assert.assertTrue(pageTitle.contains("Google"), "Page title should contain 'Google'");
            
            // Test basic element interaction
            WebElement searchBox = driver.findElement(By.name("q"));
            Assert.assertNotNull(searchBox, "Search box should be found");
            
            // Test basic element interaction
            boolean isElementDisplayed = searchBox.isDisplayed();
            Assert.assertTrue(isElementDisplayed, "Search box should be displayed");
            
            System.out.println("✅ Framework test passed successfully!");
            
        } catch (Exception e) {
            System.err.println("❌ Framework test failed: " + e.getMessage());
            throw e;
        }
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error closing driver: " + e.getMessage());
            }
        }
    }
} 