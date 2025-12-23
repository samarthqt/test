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
package com.framework.working;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.lang.reflect.Method;
import java.time.Duration;

/**
 * Working Framework Example - Demonstrates core functionality
 * 
 * This class shows the basic working components of QualiFrameV2
 * that have been tested and verified to work correctly.
 * 
 * @author Qualitest
 * @version 2.0.1
 * @since 2024
 */
public class WorkingFrameworkExample {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeMethod
    public void setUp() {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Setup explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        System.out.println("✅ WebDriver setup completed successfully");
    }
    
    @Test(description = "Test basic WebDriver functionality")
    public void testBasicWebDriverFunctionality() {
        System.out.println("🚀 Starting basic WebDriver test");
        
        try {
            // Navigate to a test page
            driver.get("https://www.google.com");
            System.out.println("✅ Successfully navigated to Google");
            
            // Find and interact with elements
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.sendKeys("QualiFrameV2 automation framework");
            System.out.println("✅ Successfully entered text in search box");
            
            // Submit the search
            searchBox.submit();
            System.out.println("✅ Successfully submitted search");
            
            // Wait for results
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
            System.out.println("✅ Search results loaded successfully");
            
            System.out.println("🎉 Basic WebDriver test completed successfully!");
            
        } catch (Exception e) {
            System.err.println("❌ Test failed: " + e.getMessage());
            throw e;
        }
    }
    
    @Test(description = "Test element interactions")
    public void testElementInteractions() {
        System.out.println("🚀 Starting element interactions test");
        
        try {
            // Navigate to a simple test page
            driver.get("https://the-internet.herokuapp.com/");
            System.out.println("✅ Successfully navigated to test page");
            
            // Find and click a link
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("A/B Testing")));
            link.click();
            System.out.println("✅ Successfully clicked on A/B Testing link");
            
            // Verify page loaded
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
            System.out.println("✅ A/B Testing page loaded successfully");
            
            // Navigate back
            driver.navigate().back();
            System.out.println("✅ Successfully navigated back");
            
            System.out.println("🎉 Element interactions test completed successfully!");
            
        } catch (Exception e) {
            System.err.println("❌ Test failed: " + e.getMessage());
            throw e;
        }
    }
    
    @Test(description = "Test form interactions")
    public void testFormInteractions() {
        System.out.println("🚀 Starting form interactions test");
        
        try {
            // Navigate to form page
            driver.get("https://the-internet.herokuapp.com/login");
            System.out.println("✅ Successfully navigated to login page");
            
            // Fill in username
            WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
            usernameField.sendKeys("tomsmith");
            System.out.println("✅ Successfully entered username");
            
            // Fill in password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("SuperSecretPassword!");
            System.out.println("✅ Successfully entered password");
            
            // Submit form
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();
            System.out.println("✅ Successfully clicked login button");
            
            // Verify login success
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flash")));
            System.out.println("✅ Login form submitted successfully");
            
            System.out.println("🎉 Form interactions test completed successfully!");
            
        } catch (Exception e) {
            System.err.println("❌ Test failed: " + e.getMessage());
            throw e;
        }
    }
    
    @Test(description = "Test wait strategies")
    public void testWaitStrategies() {
        System.out.println("🚀 Starting wait strategies test");
        
        try {
            // Navigate to dynamic loading page
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
            System.out.println("✅ Successfully navigated to dynamic loading page");
            
            // Click start button
            WebElement startButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#start button")));
            startButton.click();
            System.out.println("✅ Successfully clicked start button");
            
            // Wait for loading to complete
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
            System.out.println("✅ Loading completed");
            
            // Verify result
            WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
            String resultText = result.getText();
            System.out.println("✅ Result text: " + resultText);
            
            System.out.println("🎉 Wait strategies test completed successfully!");
            
        } catch (Exception e) {
            System.err.println("❌ Test failed: " + e.getMessage());
            throw e;
        }
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✅ WebDriver closed successfully");
        }
    }
}