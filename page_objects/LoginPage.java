package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;
import org.testng.Assert;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField = By.id(username);
    private final By passwordField = By.id(password);
    private final By loginButton = By.id(login_button);
    private final By dashboardElement = By.id(dashboard);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLoginPage() {
        driver.get(http://example.com/login);
    }

    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        Assert.assertTrue(isDashboardDisplayed(), Login failed - Dashboard not found);
    }

    public boolean isDashboardDisplayed() {
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardElement));
        return dashboard.isDisplayed();
    }
}