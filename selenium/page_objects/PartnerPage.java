package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .util.List;

public class PartnerPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By btnFindPartner = By.id(findPartnerButton);
    private final By txtURL = By.id(urlInput);
    private final By newWindowButton = By.id(newWindowButton);

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openNewBrowserWindow() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(newWindowButton));
        button.click();
        Assert.assertTrue(driver.getWindowHandles().size() > 1, New browser window did not open.);
    }

    public void enterURL(String url) {
        WebElement urlInput = wait.until(ExpectedConditions.visibilityOfElementLocated(txtURL));
        urlInput.clear();
        urlInput.sendKeys(url);
        Assert.assertEquals(urlInput.getAttribute(value), url, URL was not entered correctly.);
    }

    public void clickFindPartnerButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(btnFindPartner));
        button.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(partner), Did not navigate to partner page.);
    }

    public List<WebElement> getWebElementList(By by) {
        return driver.findElements(by);
    }

    public String getTextFromElement(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    public boolean elementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean elementVisible(By by, long seconds) {
        try {
            new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void switchToLatestWindow() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    public void switchToParentWindow() {
        String parentHandle = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(parentHandle);
    }

    public void waitUntilElementVisible(By by, long timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementClickable(By by, long timeOutInSeconds) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilElementEnabled(By by, long timeOutInSeconds) {
        WebElement element = new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by));
        Assert.assertTrue(element.isEnabled(), Element is not enabled.);
    }

    public void waitUntilElementDisabled(By by, long timeOutInSeconds) {
        WebElement element = new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertFalse(element.isEnabled(), Element is not disabled.);
    }

    public void mouseOver(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        // Assuming Actions class is used for mouse over
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(element).perform();
    }

    public Boolean objectExists(By by) {
        return !driver.findElements(by).isEmpty();
    }

    public Boolean isTextPresent(String textPattern) {
        return driver.findElement(By.cssSelector(BODY)).getText().contains(textPattern);
    }

    public Boolean isAlertPresent(long timeOutInSeconds) {
        try {
            new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}