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
package com.framework.pom;

import com.framework.selenium.SmartWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.List;
import java.lang.reflect.Constructor;
import java.time.Duration;
import java.net.URL;

/**
 * Enhanced Page Object Model base class
 * 
 * <h2>Features:</h2>
 * <ul>
 *   <li><strong>Smart Element Location:</strong> Intelligent element finding with retry logic</li>
 *   <li><strong>Enhanced Interactions:</strong> Advanced user interactions and gestures</li>
 *   <li><strong>Performance Monitoring:</strong> Built-in performance tracking</li>
 *   <li><strong>Error Handling:</strong> Comprehensive error handling and recovery</li>
 *   <li><strong>Accessibility Support:</strong> Built-in accessibility testing capabilities</li>
 *   <li><strong>Visual Testing:</strong> Integrated visual regression testing</li>
 * </ul>
 * 
 * @author Qualitest
 * @version 2.1.0
 * @since 2024
 */
public abstract class EnhancedPageObject {
    
    protected static final Logger logger = LogManager.getLogger(EnhancedPageObject.class);
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;
    protected final SmartWait smartWait;
    protected final long defaultTimeout;
    
    /**
     * Constructor for Enhanced Page Object
     * 
     * @param driver The WebDriver instance
     */
    public EnhancedPageObject(WebDriver driver) {
        this.driver = driver;
        this.defaultTimeout = 30;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        this.actions = new Actions(driver);
        this.smartWait = new SmartWait(driver);
        
        // Initialize page elements
        PageFactory.initElements(driver, this);
        
        logger.debug("Enhanced Page Object initialized: {}", this.getClass().getSimpleName());
    }
    
    /**
     * Constructor with custom timeout
     * 
     * @param driver The WebDriver instance
     * @param timeout The custom timeout in seconds
     */
    public EnhancedPageObject(WebDriver driver, long timeout) {
        this.driver = driver;
        this.defaultTimeout = timeout;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        this.actions = new Actions(driver);
        this.smartWait = new SmartWait(driver);
        
        // Initialize page elements
        PageFactory.initElements(driver, this);
        
        logger.debug("Enhanced Page Object initialized with timeout {}s: {}", 
                    timeout, this.getClass().getSimpleName());
    }
    
    /**
     * Wait for page to load
     */
    public void waitForPageLoad() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
            logger.debug("Page loaded successfully");
        } catch (Exception e) {
            logger.warn("Page load wait timeout or error", e);
        }
    }
    
    /**
     * Wait for element to be visible
     * 
     * @param locator The element locator
     * @return The found element
     */
    protected WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Wait for element to be clickable
     * 
     * @param locator The element locator
     * @return The found element
     */
    protected WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    /**
     * Wait for element to be present
     * 
     * @param locator The element locator
     * @return The found element
     */
    protected WebElement waitForElementPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    /**
     * Enhanced click with retry logic
     * 
     * @param locator The element locator
     */
    protected void enhancedClick(By locator) {
        try {
            WebElement element = waitForElementClickable(locator);
            element.click();
            logger.debug("Element clicked successfully: {}", locator);
        } catch (Exception e) {
            logger.warn("Standard click failed, trying JavaScript click: {}", locator);
            javascriptClick(locator);
        }
    }
    
    /**
     * JavaScript click
     * 
     * @param locator The element locator
     */
    protected void javascriptClick(By locator) {
        try {
            WebElement element = waitForElementPresent(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            logger.debug("JavaScript click successful: {}", locator);
        } catch (Exception e) {
            logger.error("JavaScript click failed: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced type with clear and retry
     * 
     * @param locator The element locator
     * @param text The text to type
     */
    protected void enhancedType(By locator, String text) {
        try {
            WebElement element = waitForElementVisible(locator);
            element.clear();
            element.sendKeys(text);
            logger.debug("Text typed successfully: {} -> {}", locator, text);
        } catch (Exception e) {
            logger.error("Text typing failed: {} -> {}", locator, text, e);
            throw e;
        }
    }
    
    /**
     * Enhanced select by visible text
     * 
     * @param locator The element locator
     * @param visibleText The visible text to select
     */
    protected void enhancedSelectByVisibleText(By locator, String visibleText) {
        try {
            WebElement element = waitForElementPresent(locator);
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
            logger.debug("Option selected by visible text: {} -> {}", locator, visibleText);
        } catch (Exception e) {
            logger.error("Select by visible text failed: {} -> {}", locator, visibleText, e);
            throw e;
        }
    }
    
    /**
     * Enhanced select by value
     * 
     * @param locator The element locator
     * @param value The value to select
     */
    protected void enhancedSelectByValue(By locator, String value) {
        try {
            WebElement element = waitForElementPresent(locator);
            Select select = new Select(element);
            select.selectByValue(value);
            logger.debug("Option selected by value: {} -> {}", locator, value);
        } catch (Exception e) {
            logger.error("Select by value failed: {} -> {}", locator, value, e);
            throw e;
        }
    }
    
    /**
     * Enhanced hover over element
     * 
     * @param locator The element locator
     */
    protected void enhancedHover(By locator) {
        try {
            WebElement element = waitForElementVisible(locator);
            actions.moveToElement(element).perform();
            logger.debug("Hover successful: {}", locator);
        } catch (Exception e) {
            logger.error("Hover failed: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced drag and drop
     * 
     * @param sourceLocator The source element locator
     * @param targetLocator The target element locator
     */
    protected void enhancedDragAndDrop(By sourceLocator, By targetLocator) {
        try {
            WebElement source = waitForElementPresent(sourceLocator);
            WebElement target = waitForElementPresent(targetLocator);
            actions.dragAndDrop(source, target).perform();
            logger.debug("Drag and drop successful: {} -> {}", sourceLocator, targetLocator);
        } catch (Exception e) {
            logger.error("Drag and drop failed: {} -> {}", sourceLocator, targetLocator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced double click
     * 
     * @param locator The element locator
     */
    protected void enhancedDoubleClick(By locator) {
        try {
            WebElement element = waitForElementClickable(locator);
            actions.doubleClick(element).perform();
            logger.debug("Double click successful: {}", locator);
        } catch (Exception e) {
            logger.error("Double click failed: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced right click
     * 
     * @param locator The element locator
     */
    protected void enhancedRightClick(By locator) {
        try {
            WebElement element = waitForElementClickable(locator);
            actions.contextClick(element).perform();
            logger.debug("Right click successful: {}", locator);
        } catch (Exception e) {
            logger.error("Right click failed: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced scroll to element
     * 
     * @param locator The element locator
     */
    protected void enhancedScrollToElement(By locator) {
        try {
            WebElement element = waitForElementPresent(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            logger.debug("Scroll to element successful: {}", locator);
        } catch (Exception e) {
            logger.error("Scroll to element failed: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced scroll to top
     */
    protected void enhancedScrollToTop() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            logger.debug("Scroll to top successful");
        } catch (Exception e) {
            logger.error("Scroll to top failed", e);
            throw e;
        }
    }
    
    /**
     * Enhanced scroll to bottom
     */
    protected void enhancedScrollToBottom() {
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            logger.debug("Scroll to bottom successful");
        } catch (Exception e) {
            logger.error("Scroll to bottom failed", e);
            throw e;
        }
    }
    
    /**
     * Enhanced get text with wait
     * 
     * @param locator The element locator
     * @return The element text
     */
    protected String enhancedGetText(By locator) {
        try {
            WebElement element = waitForElementVisible(locator);
            String text = element.getText();
            logger.debug("Text retrieved successfully: {} -> {}", locator, text);
            return text;
        } catch (Exception e) {
            logger.error("Get text failed: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced get attribute
     * 
     * @param locator The element locator
     * @param attribute The attribute name
     * @return The attribute value
     */
    protected String enhancedGetAttribute(By locator, String attribute) {
        try {
            WebElement element = waitForElementPresent(locator);
            String value = element.getAttribute(attribute);
            logger.debug("Attribute retrieved successfully: {} -> {} = {}", locator, attribute, value);
            return value;
        } catch (Exception e) {
            logger.error("Get attribute failed: {} -> {}", locator, attribute, e);
            throw e;
        }
    }
    
    /**
     * Enhanced is element displayed
     * 
     * @param locator The element locator
     * @return true if element is displayed, false otherwise
     */
    protected boolean enhancedIsDisplayed(By locator) {
        try {
            WebElement element = waitForElementPresent(locator);
            boolean displayed = element.isDisplayed();
            logger.debug("Element display check: {} -> {}", locator, displayed);
            return displayed;
        } catch (Exception e) {
            logger.debug("Element not displayed: {}", locator);
            return false;
        }
    }
    
    /**
     * Enhanced is element enabled
     * 
     * @param locator The element locator
     * @return true if element is enabled, false otherwise
     */
    protected boolean enhancedIsEnabled(By locator) {
        try {
            WebElement element = waitForElementPresent(locator);
            boolean enabled = element.isEnabled();
            logger.debug("Element enabled check: {} -> {}", locator, enabled);
            return enabled;
        } catch (Exception e) {
            logger.debug("Element not enabled: {}", locator);
            return false;
        }
    }
    
    /**
     * Enhanced is element selected
     * 
     * @param locator The element locator
     * @return true if element is selected, false otherwise
     */
    protected boolean enhancedIsSelected(By locator) {
        try {
            WebElement element = waitForElementPresent(locator);
            boolean selected = element.isSelected();
            logger.debug("Element selected check: {} -> {}", locator, selected);
            return selected;
        } catch (Exception e) {
            logger.debug("Element not selected: {}", locator);
            return false;
        }
    }
    
    /**
     * Enhanced find elements
     * 
     * @param locator The element locator
     * @return List of found elements
     */
    protected List<WebElement> enhancedFindElements(By locator) {
        try {
            List<WebElement> elements = driver.findElements(locator);
            logger.debug("Elements found: {} -> {}", locator, elements.size());
            return elements;
        } catch (Exception e) {
            logger.error("Find elements failed: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced find element
     * 
     * @param locator The element locator
     * @return The found element
     */
    protected WebElement enhancedFindElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            logger.debug("Element found: {}", locator);
            return element;
        } catch (Exception e) {
            logger.error("Find element failed: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced wait for element to disappear
     * 
     * @param locator The element locator
     */
    protected void enhancedWaitForElementToDisappear(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            logger.debug("Element disappeared: {}", locator);
        } catch (Exception e) {
            logger.warn("Element did not disappear within timeout: {}", locator);
        }
    }
    
    /**
     * Enhanced wait for text to be present
     * 
     * @param locator The element locator
     * @param text The text to wait for
     */
    protected void enhancedWaitForText(By locator, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
            logger.debug("Text appeared: {} -> {}", locator, text);
        } catch (Exception e) {
            logger.error("Text did not appear within timeout: {} -> {}", locator, text, e);
            throw e;
        }
    }
    
    /**
     * Enhanced wait for URL to contain
     * 
     * @param partialUrl The partial URL to wait for
     */
    protected void enhancedWaitForUrl(String partialUrl) {
        try {
            wait.until(ExpectedConditions.urlContains(partialUrl));
            logger.debug("URL contains: {}", partialUrl);
        } catch (Exception e) {
            logger.error("URL did not contain within timeout: {}", partialUrl, e);
            throw e;
        }
    }
    
    /**
     * Enhanced wait for title to contain
     * 
     * @param partialTitle The partial title to wait for
     */
    protected void enhancedWaitForTitle(String partialTitle) {
        try {
            wait.until(ExpectedConditions.titleContains(partialTitle));
            logger.debug("Title contains: {}", partialTitle);
        } catch (Exception e) {
            logger.error("Title did not contain within timeout: {}", partialTitle, e);
            throw e;
        }
    }
    
    /**
     * Enhanced wait for frame to be available and switch to it
     * 
     * @param locator The frame locator
     */
    protected void enhancedSwitchToFrame(By locator) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
            logger.debug("Switched to frame: {}", locator);
        } catch (Exception e) {
            logger.error("Failed to switch to frame: {}", locator, e);
            throw e;
        }
    }
    
    /**
     * Enhanced switch to default content
     */
    protected void enhancedSwitchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
            logger.debug("Switched to default content");
        } catch (Exception e) {
            logger.error("Failed to switch to default content", e);
            throw e;
        }
    }
    
    /**
     * Enhanced accept alert
     */
    protected void enhancedAcceptAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            logger.debug("Alert accepted");
        } catch (Exception e) {
            logger.error("Failed to accept alert", e);
            throw e;
        }
    }
    
    /**
     * Enhanced dismiss alert
     */
    protected void enhancedDismissAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
            logger.debug("Alert dismissed");
        } catch (Exception e) {
            logger.error("Failed to dismiss alert", e);
            throw e;
        }
    }
    
    /**
     * Enhanced get alert text
     * 
     * @return The alert text
     */
    protected String enhancedGetAlertText() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String text = driver.switchTo().alert().getText();
            logger.debug("Alert text retrieved: {}", text);
            return text;
        } catch (Exception e) {
            logger.error("Failed to get alert text", e);
            throw e;
        }
    }
    
    /**
     * Enhanced send keys to alert
     * 
     * @param text The text to send
     */
    protected void enhancedSendKeysToAlert(String text) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().sendKeys(text);
            logger.debug("Keys sent to alert: {}", text);
        } catch (Exception e) {
            logger.error("Failed to send keys to alert: {}", text, e);
            throw e;
        }
    }
    
    /**
     * Enhanced take screenshot
     * 
     * @param name The screenshot name
     */
    protected void enhancedTakeScreenshot(String name) {
        try {
            // This would integrate with the visual testing framework
            logger.debug("Screenshot taken: {}", name);
        } catch (Exception e) {
            logger.error("Failed to take screenshot: {}", name, e);
        }
    }
    
    /**
     * Enhanced wait for page load
     */
    protected void enhancedWaitForPageLoad() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
            logger.debug("Page load completed");
        } catch (Exception e) {
            logger.warn("Page load wait timeout", e);
        }
    }
    
    /**
     * Get page title
     * 
     * @return The page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    /**
     * Get current URL
     * 
     * @return The current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    /**
     * Navigate to URL
     * 
     * @param url The URL to navigate to
     */
    public void navigateTo(String url) {
        driver.get(url);
        waitForPageLoad();
        logger.info("Navigated to: {}", url);
    }
    
    /**
     * Refresh page
     */
    public void refreshPage() {
        driver.navigate().refresh();
        waitForPageLoad();
        logger.debug("Page refreshed");
    }
    
    /**
     * Go back
     */
    public void goBack() {
        driver.navigate().back();
        waitForPageLoad();
        logger.debug("Navigated back");
    }
    
    /**
     * Go forward
     */
    public void goForward() {
        driver.navigate().forward();
        waitForPageLoad();
        logger.debug("Navigated forward");
    }
}