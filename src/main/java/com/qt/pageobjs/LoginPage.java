package com.qt.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoginPage extends WebReusableComponents {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("loginButton");
    private final By dashboard = By.id("dashboard");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Logs in using the provided username and password.
     * @param username the username to enter
     * @param password the password to enter
     */
    public void login(String username, String password) {
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    /**
     * Checks if the dashboard is displayed.
     * @return true if the dashboard is visible, false otherwise
     */
    public boolean isDashboardDisplayed() {
        return isElementVisible(dashboard);
    }

    /**
     * Enters text into a specified field.
     * @param locator the locator of the field
     * @param text the text to enter
     */
    public void enterText(By locator, String text) {
        WebElement element = waitUntilElementVisible(locator, 3);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks on a specified element.
     * @param locator the locator of the element to click
     */
    public void clickElement(By locator) {
        WebElement element = waitUntilElementVisible(locator, 3);
        element.click();
    }

    /**
     * Waits until an element is visible.
     * @param locator the locator of the element
     * @param timeout the timeout in seconds
     * @return the visible WebElement
     */
    public WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Checks if an element is visible.
     * @param locator the locator of the element
     * @return true if the element is visible, false otherwise
     */
    public boolean isElementVisible(By locator) {
        try {
            WebElement element = waitUntilElementVisible(locator, 3);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}