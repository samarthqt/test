package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SessionPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameFieldLocator = By.id(username);
    private final By passwordFieldLocator = By.id(password);
    private final By loginButtonLocator = By.id(login_button);
    private final By dashboardLocator = By.id(dashboard);
    private final By loginPageLocator = By.id(login_page);
    private final By warningNotificationLocator = By.id(warning_notification);
    private final By someElementLocator = By.id(some_element);
    private final By sessionSettingsLocator = By.id(session_settings);
    private final By sessionTimeoutLocator = By.id(session_timeout);

    public SessionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        driver.get(http://example.com/login);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLocator));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        Assert.assertTrue(isDashboardDisplayed(), Login failed - Dashboard not displayed);
    }

    public boolean isDashboardDisplayed() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLocator));
        return dashboardElement.isDisplayed();
    }

    public boolean isLoginPageDisplayed() {
        WebElement loginPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageLocator));
        return loginPageElement.isDisplayed();
    }

    public boolean isWarningNotificationDisplayed() {
        WebElement warningElement = wait.until(ExpectedConditions.visibilityOfElementLocated(warningNotificationLocator));
        return warningElement.isDisplayed();
    }

    public void performActivity() {
        WebElement someElement = wait.until(ExpectedConditions.visibilityOfElementLocated(someElementLocator));
        someElement.click();
        Assert.assertTrue(isWarningNotificationDisplayed(), Activity failed - Warning notification not displayed);
    }

    public void accessSessionSettings() {
        WebElement sessionSettingsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sessionSettingsLocator));
        sessionSettingsElement.click();
        Assert.assertTrue(driver.findElement(sessionTimeoutLocator).isDisplayed(), Session settings access failed);
    }

    public void adjustSessionTimeout() {
        WebElement sessionTimeoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sessionTimeoutLocator));
        sessionTimeoutElement.click();
        // Assume there's a method to adjust timeout, e.g., selecting a dropdown value
        WebElement timeoutOption = driver.findElement(By.id(timeout_option));
        timeoutOption.click();
        Assert.assertTrue(timeoutOption.isSelected(), Session timeout adjustment failed);
    }
}