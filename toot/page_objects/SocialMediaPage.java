
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SocialMediaPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String platform;

    private final By emailField = By.id(email);
    private final By passwordField = By.id(password);
    private final By loginButton = By.id(login_button);
    private final By authorizeButton = By.id(authorize_button);
    private final By denyButton = By.id(deny_button);
    private final By errorMessage = By.id(error_message);

    public SocialMediaPage(final WebDriver driver, final WebDriverWait wait, final String platform) {
        this.driver = driver;
        this.wait = wait;
        this.platform = platform;
        PageFactory.initElements(driver, this);
    }

    public boolean isOnSocialMediaLoginPage() {
        boolean isOnPage = wait.until(ExpectedConditions.urlContains(platform.toLowerCase() + /login));
        Assert.assertTrue(isOnPage, Not on the expected social media login page.);
        return isOnPage;
    }

    public void enterValidCredentials() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        WebElement password = driver.findElement(passwordField);
        email.sendKeys(valid_user@example.com);
        password.sendKeys(valid_password);
        driver.findElement(loginButton).click();
    }

    public void enterInvalidCredentials() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        WebElement password = driver.findElement(passwordField);
        email.sendKeys(invalid_user@example.com);
        password.sendKeys(invalid_password);
        driver.findElement(loginButton).click();
    }

    public void authorizeApplication() {
        WebElement authorize = wait.until(ExpectedConditions.visibilityOfElementLocated(authorizeButton));
        authorize.click();
    }

    public void denyApplicationAuthorization() {
        WebElement deny = wait.until(ExpectedConditions.visibilityOfElementLocated(denyButton));
        deny.click();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        boolean isDisplayed = error.isDisplayed();
        Assert.assertTrue(isDisplayed, Error message is not displayed.);
        return isDisplayed;
    }
}
