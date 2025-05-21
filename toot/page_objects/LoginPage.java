package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailField = By.id(email);
    private final By passwordField = By.id(password);
    private final By loginButton = By.id(login_button);
    private final By rememberMeCheckbox = By.id(remember_me);
    private final By forgotPasswordLink = By.linkText(Forgot Password?);
    private final By dashboard = By.id(dashboard);
    private final By invalidLoginMessage = By.id(invalid_login_message);
    private final By emailAndPasswordRequiredMessage = By.id(email_password_required_message);
    private final By emailRequiredMessage = By.id(email_required_message);
    private final By passwordRequiredMessage = By.id(password_required_message);
    private final By passwordVisibilityToggle = By.id(password_visibility_toggle);
    private final By passwordResetPage = By.id(password_reset_page);
    private final By socialMediaOptions = By.id(social_media_options);
    private final By userProfile = By.id(user_profile);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLoginPage() {
        driver.get(http://example.com/login);
        Assert.assertTrue(isOnLoginPage(), Navigation to login page failed.);
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.clear();
        emailElement.sendKeys(email);
        Assert.assertEquals(emailElement.getAttribute(value), email, Email entry failed.);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        Assert.assertEquals(passwordElement.getAttribute(value), password, Password entry failed.);
    }

    public void clickLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
        Assert.assertTrue(isDashboardDisplayed(), Login failed - Dashboard not displayed.);
    }

    public void selectRememberMe() {
        WebElement rememberMe = wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
        if (!rememberMe.isSelected()) {
            rememberMe.click();
        }
        Assert.assertTrue(rememberMe.isSelected(), Remember Me selection failed.);
    }

    public void clickForgotPassword() {
        WebElement forgotPassword = wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPassword.click();
        Assert.assertTrue(isPasswordResetPageDisplayed(), Navigation to password reset page failed.);
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard)).isDisplayed();
    }

    public boolean isInvalidLoginMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginMessage)).isDisplayed();
    }

    public boolean isEmailAndPasswordRequiredMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailAndPasswordRequiredMessage)).isDisplayed();
    }

    public boolean isEmailRequiredMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailRequiredMessage)).isDisplayed();
    }

    public boolean isPasswordRequiredMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequiredMessage)).isDisplayed();
    }

    public void togglePasswordVisibility() {
        WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(passwordVisibilityToggle));
        toggle.click();
        Assert.assertTrue(isPasswordVisible(), Password visibility toggle failed.);
    }

    public boolean isPasswordVisible() {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        return passwordElement.getAttribute(type).equals(text);
    }

    public void logout() {
        // Implement logout functionality
        // Assuming a logout button is present
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(logout_button)));
        logoutButton.click();
        Assert.assertTrue(isOnLoginPage(), Logout failed - Not redirected to login page.);
    }

    public boolean isEmailRemembered() {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        return !emailElement.getAttribute(value).isEmpty();
    }

    public boolean isPasswordResetPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordResetPage)).isDisplayed();
    }

    public void selectSocialMediaLoginOption(String platform) {
        WebElement loginOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(platform.toLowerCase() + _login)));
        loginOption.click();
        Assert.assertTrue(isUserLoggedIn(), Social media login failed.);
    }

    public boolean isOnHomePage() {
        return wait.until(ExpectedConditions.urlContains(/home));
    }

    public boolean isUserLoggedIn() {
        WebElement userProfileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userProfile));
        return userProfileElement.isDisplayed();
    }

    public boolean isOnLoginPage() {
        return wait.until(ExpectedConditions.urlContains(/login));
    }

    public void checkSocialMediaOptions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(socialMediaOptions));
        Assert.assertTrue(areSocialMediaOptionsAvailable(), Social media options are not available.);
    }

    public boolean areSocialMediaOptionsAvailable() {
        WebElement options = driver.findElement(socialMediaOptions);
        return options.isDisplayed();
    }
}