package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By dashboard = By.id("dashboard");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
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
        clickLoginButton();
    }

    /**
     * Checks if the dashboard is displayed.
     * @return true if the dashboard is displayed, false otherwise
     */
    public boolean isDashboardDisplayed() {
        waitUntilElementVisible(dashboard);
        boolean isDisplayed = driver.findElement(dashboard).isDisplayed();
        Assert.assertTrue(isDisplayed, "Dashboard is not displayed.");
        return isDisplayed;
    }

    /**
     * Enters text into a specified field.
     * @param locator the locator of the field
     * @param text the text to enter
     */
    public void enterText(By locator, String text) {
        waitUntilElementVisible(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        waitUntilElementVisible(loginButton);
        driver.findElement(loginButton).click();
    }

    /**
     * Waits until the specified element is visible.
     * @param locator the locator of the element
     */
    public void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}