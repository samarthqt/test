package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static com.framework.selenium.SeleniumTestParameters.getDriver;

public class LoginPage {

    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By dashboard = By.id("dashboard");

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
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
        boolean isDisplayed = getDriver().findElement(dashboard).isDisplayed();
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
        WebElement element = getDriver().findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        waitUntilElementVisible(loginButton);
        getDriver().findElement(loginButton).click();
    }

    /**
     * Waits until the specified element is visible.
     * @param locator the locator of the element
     */
    public void waitUntilElementVisible(By locator) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}