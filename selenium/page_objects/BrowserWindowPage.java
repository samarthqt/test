package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.List;
import .util.Set;

public class BrowserWindowPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(window.open(););
        Assert.assertTrue(getWindowHandles().size() > 1, New browser window was not opened.);
    }

    public Set<String> getWindowHandles() {
        Set<String> handles = driver.getWindowHandles();
        Assert.assertNotNull(handles, Window handles are null.);
        return handles;
    }

    public void switchToNewWindow() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
                Assert.assertNotEquals(driver.getWindowHandle(), currentWindowHandle, Failed to switch to new window.);
                break;
            }
        }
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
        Assert.assertEquals(driver.getWindowHandle(), windowHandle, Failed to switch to specified window.);
    }

    public void openNewWindow() {
        ((JavascriptExecutor) driver).executeScript(window.open(););
        Assert.assertTrue(getWindowHandles().size() > 1, New window was not opened.);
    }

    public void waitUntilElementVisible(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertTrue(element.isDisplayed(), Element is not visible.);
    }

    public void clickElement(By by) {
        waitUntilElementVisible(by);
        WebElement element = driver.findElement(by);
        element.click();
        Assert.assertTrue(element.isEnabled(), Element was not clicked.);
    }

    public String getCurrentURL() {
        String url = driver.getCurrentUrl();
        Assert.assertNotNull(url, Current URL is null.);
        return url;
    }

    public void enterText(By by, String valueToEnter) {
        waitUntilElementVisible(by);
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(valueToEnter);
        Assert.assertEquals(element.getAttribute(value), valueToEnter, Text was not entered correctly.);
    }

    public String getTextFromElement(By by) {
        waitUntilElementVisible(by);
        WebElement element = driver.findElement(by);
        String text = element.getText();
        Assert.assertNotNull(text, Text from element is null.);
        return text;
    }

    public List<WebElement> getWebElementList(By by) {
        List<WebElement> elements = driver.findElements(by);
        Assert.assertFalse(elements.isEmpty(), Element list is empty.);
        return elements;
    }
}