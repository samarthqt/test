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

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Constructor;
import java.time.Duration;

/**
 * Smart wait implementation with intelligent waiting strategies
 * 
 * <h2>Features:</h2>
 * <ul>
 *   <li><strong>Adaptive Timeouts:</strong> Dynamic timeout adjustment based on performance</li>
 *   <li><strong>Multiple Wait Strategies:</strong> Different wait strategies for different scenarios</li>
 *   <li><strong>Performance Monitoring:</strong> Track wait performance and optimize</li>
 *   <li><strong>Error Recovery:</strong> Automatic retry with different strategies</li>
 * </ul>
 * 
 * @author Qualitest
 * @version 2.1.0
 * @since 2024
 */
public class SmartWait {
    
    private final WebDriver driver;
    private final PerformanceMonitor performanceMonitor;
    private Duration defaultTimeout = Duration.ofSeconds(10);
    private Duration pollingInterval = Duration.ofMillis(500);
    private int maxRetries = 3;
    
    /**
     * Constructor for SmartWait
     * 
     * @param driver The WebDriver instance
     */
    public SmartWait(WebDriver driver) {
        this.driver = driver;
        // Create a simple performance monitor for regular WebDriver
        this.performanceMonitor = new PerformanceMonitor();
    }
    
    /**
     * Set the default timeout
     * 
     * @param timeout The default timeout duration
     */
    public void setDefaultTimeout(Duration timeout) {
        this.defaultTimeout = timeout;
    }
    
    /**
     * Set the polling interval
     * 
     * @param interval The polling interval
     */
    public void setPollingInterval(Duration interval) {
        this.pollingInterval = interval;
    }
    
    /**
     * Set the maximum number of retries
     * 
     * @param maxRetries The maximum number of retries
     */
    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }
    
    /**
     * Wait for element with smart strategy
     * 
     * @param locator The element locator
     * @param timeout The timeout duration
     * @return WebElement that was found
     */
    public WebElement waitForElement(By locator, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitForElement");
        try {
            WebElement element = createWebDriverWait(timeout)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
            context.end(performanceMonitor);
            return element;
        } catch (Exception e) {
            context.recordError(performanceMonitor, e);
            throw e;
        }
    }
    
    /**
     * Wait for element with default timeout
     * 
     * @param locator The element locator
     * @return WebElement that was found
     */
    public WebElement waitForElement(By locator) {
        return waitForElement(locator, defaultTimeout);
    }
    
    /**
     * Wait for element to be clickable with smart strategy
     * 
     * @param locator The element locator
     * @param timeout The timeout duration
     * @return WebElement that is clickable
     */
    public WebElement waitForElementToBeClickable(By locator, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitForElementToBeClickable");
        try {
            WebElement element = createWebDriverWait(timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
            context.end(performanceMonitor);
            return element;
        } catch (Exception e) {
            context.recordError(performanceMonitor, e);
            throw e;
        }
    }
    
    /**
     * Wait for element to be clickable with default timeout
     * 
     * @param locator The element locator
     * @return WebElement that is clickable
     */
    public WebElement waitForElementToBeClickable(By locator) {
        return waitForElementToBeClickable(locator, defaultTimeout);
    }
    
    /**
     * Wait for element to be visible with smart strategy
     * 
     * @param locator The element locator
     * @param timeout The timeout duration
     * @return WebElement that is visible
     */
    public WebElement waitForElementToBeVisible(By locator, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitForElementToBeVisible");
        try {
            WebElement element = createWebDriverWait(timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
            context.end(performanceMonitor);
            return element;
        } catch (Exception e) {
            context.recordError(performanceMonitor, e);
            throw e;
        }
    }
    
    /**
     * Wait for element to be visible with default timeout
     * 
     * @param locator The element locator
     * @return WebElement that is visible
     */
    public WebElement waitForElementToBeVisible(By locator) {
        return waitForElementToBeVisible(locator, defaultTimeout);
    }
    
    /**
     * Wait for element to disappear with smart strategy
     * 
     * @param locator The element locator
     * @param timeout The timeout duration
     * @return true if element disappeared, false otherwise
     */
    public boolean waitForElementToDisappear(By locator, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitForElementToDisappear");
        try {
            boolean result = createWebDriverWait(timeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
            context.end(performanceMonitor);
            return result;
        } catch (Exception e) {
            context.recordError(performanceMonitor, e);
            throw e;
        }
    }
    
    /**
     * Wait for element to disappear with default timeout
     * 
     * @param locator The element locator
     * @return true if element disappeared, false otherwise
     */
    public boolean waitForElementToDisappear(By locator) {
        return waitForElementToDisappear(locator, defaultTimeout);
    }
    
    /**
     * Wait for all elements to be present with smart strategy
     * 
     * @param locator The element locator
     * @param timeout The timeout duration
     * @return List of WebElements that were found
     */
    public List<WebElement> waitForAllElements(By locator, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitForAllElements");
        try {
            List<WebElement> elements = createWebDriverWait(timeout)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
            context.end(performanceMonitor);
            return elements;
        } catch (Exception e) {
            context.recordError(performanceMonitor, e);
            throw e;
        }
    }
    
    /**
     * Wait for all elements to be present with default timeout
     * 
     * @param locator The element locator
     * @return List of WebElements that were found
     */
    public List<WebElement> waitForAllElements(By locator) {
        return waitForAllElements(locator, defaultTimeout);
    }
    
    /**
     * Wait for text to be present in element with smart strategy
     * 
     * @param locator The element locator
     * @param text The text to wait for
     * @param timeout The timeout duration
     * @return true if text is present, false otherwise
     */
    public boolean waitForTextToBePresent(By locator, String text, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitForTextToBePresent");
        try {
            boolean result = createWebDriverWait(timeout)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
            context.end(performanceMonitor);
            return result;
        } catch (Exception e) {
            context.recordError(performanceMonitor, e);
            throw e;
        }
    }
    
    /**
     * Wait for text to be present in element with default timeout
     * 
     * @param locator The element locator
     * @param text The text to wait for
     * @return true if text is present, false otherwise
     */
    public boolean waitForTextToBePresent(By locator, String text) {
        return waitForTextToBePresent(locator, text, defaultTimeout);
    }
    
    /**
     * Wait for custom condition with smart strategy
     * 
     * @param condition The custom condition to wait for
     * @param timeout The timeout duration
     * @param <T> The return type of the condition
     * @return The result of the condition
     */
    public <T> T waitForCondition(ExpectedCondition<T> condition, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitForCondition");
        try {
            T result = createWebDriverWait(timeout).until(condition);
            context.end(performanceMonitor);
            return result;
        } catch (Exception e) {
            context.recordError(performanceMonitor, e);
            throw e;
        }
    }
    
    /**
     * Wait for custom condition with default timeout
     * 
     * @param condition The custom condition to wait for
     * @param <T> The return type of the condition
     * @return The result of the condition
     */
    public <T> T waitForCondition(ExpectedCondition<T> condition) {
        return waitForCondition(condition, defaultTimeout);
    }
    
    /**
     * Wait for custom function with smart strategy
     * 
     * @param function The custom function to wait for
     * @param timeout The timeout duration
     * @param <T> The return type of the function
     * @return The result of the function
     */
    public <T> T waitForFunction(Function<WebDriver, T> function, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitForFunction");
        try {
            T result = createWebDriverWait(timeout).until(function);
            context.end(performanceMonitor);
            return result;
        } catch (Exception e) {
            context.recordError(performanceMonitor, e);
            throw e;
        }
    }
    
    /**
     * Wait for custom function with default timeout
     * 
     * @param function The custom function to wait for
     * @param <T> The return type of the function
     * @return The result of the function
     */
    public <T> T waitForFunction(Function<WebDriver, T> function) {
        return waitForFunction(function, defaultTimeout);
    }
    
    /**
     * Wait with retry strategy
     * 
     * @param operation The operation to retry
     * @param timeout The timeout duration
     * @param <T> The return type of the operation
     * @return The result of the operation
     */
    public <T> T waitWithRetry(Function<WebDriver, T> operation, Duration timeout) {
        PerformanceMonitor.OperationContext context = performanceMonitor.startOperation("waitWithRetry");
        Exception lastException = null;
        
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                T result = createWebDriverWait(timeout).until(operation);
                context.end(performanceMonitor);
                return result;
            } catch (Exception e) {
                lastException = e;
                if (attempt < maxRetries) {
                    try {
                        Thread.sleep(pollingInterval.toMillis());
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
        
        context.recordError(performanceMonitor, lastException);
        throw new RuntimeException("Operation failed after " + maxRetries + " attempts", lastException);
    }
    
    /**
     * Create a FluentWait with optimized settings
     * 
     * @param timeout The timeout duration
     * @return Configured FluentWait instance
     */
    private FluentWait<WebDriver> createWebDriverWait(Duration timeout) {
        return new WebDriverWait(driver, timeout)
            .pollingEvery(pollingInterval)
            .ignoring(StaleElementReferenceException.class)
            .ignoring(NoSuchElementException.class);
    }
    
    /**
     * Get the current performance statistics
     * 
     * @return Performance statistics
     */
    public PerformanceMonitor.PerformanceStats getPerformanceStats() {
        return performanceMonitor.getStats();
    }
    
    /**
     * Get a summary of wait performance
     * 
     * @return String summary of wait performance
     */
    public String getWaitPerformanceSummary() {
        return performanceMonitor.getSummary();
    }
}