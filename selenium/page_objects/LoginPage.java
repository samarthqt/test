package com.pageobjects;

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

    // Locators for login elements
    private final By usernameField = By.id(username);
    private final By passwordField = By.id(password);
    private final By loginButton = By.id(loginButton);

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to set username
     * @param username the username to enter
     */
    public void setUsername(final String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.clear();
        usernameElement.sendKeys(username);
        Assert.assertEquals(usernameElement.getAttribute(value), username, Username input failed);
    }

    /**
     * Method to set password
     * @param password the password to enter
     */
    public void setPassword(final String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        Assert.assertEquals(passwordElement.getAttribute(value), password, Password input failed);
    }

    /**
     * Method to click login button
     */
    public void clickLoginButton() {
        WebElement loginBtnElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtnElement.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(homepage), Login button click failed);
    }

    /**
     * Method to log in with valid credentials
     * @param username the username to enter
     * @param password the password to enter
     */
    public void login(final String username, final String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }
}