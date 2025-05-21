package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MobileAppPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameFieldLocator = By.id(username);
    private final By passwordFieldLocator = By.id(password);
    private final By loginButtonLocator = By.id(login_button);
    private final By featuresLocator = By.id(features);
    private final By section1Locator = By.id(section1);
    private final By section2Locator = By.id(section2);
    private final By transitionLocator = By.id(transition);
    private final By syncButtonLocator = By.id(sync_button);
    private final By syncConfirmationLocator = By.id(sync_confirmation);
    private final By deviceInteractionLocator = By.id(device_interaction);
    private final By consistencyLocator = By.id(consistency);
    private final By errorButtonLocator = By.id(error_button);
    private final By errorMessageLocator = By.id(error_message);
    private final By logoutButtonLocator = By.id(logout_button);
    private final By loginScreenLocator = By.id(login_screen);

    public MobileAppPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLocator));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        Assert.assertTrue(areFeaturesAccessible(), Login failed - Features not accessible);
    }

    public boolean areFeaturesAccessible() {
        WebElement featuresElement = wait.until(ExpectedConditions.visibilityOfElementLocated(featuresLocator));
        return featuresElement.isDisplayed();
    }

    public void navigateSections() {
        WebElement section1 = driver.findElement(section1Locator);
        section1.click();
        WebElement section2 = driver.findElement(section2Locator);
        section2.click();
        Assert.assertTrue(areTransitionsSmooth(), Navigation failed - Transitions not smooth);
    }

    public boolean areTransitionsSmooth() {
        WebElement transitionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(transitionLocator));
        return transitionElement.isDisplayed();
    }

    public void performDataSyncActions() {
        WebElement syncButton = driver.findElement(syncButtonLocator);
        syncButton.click();
        Assert.assertTrue(isDataSyncSuccessful(), Data sync failed - Confirmation not displayed);
    }

    public boolean isDataSyncSuccessful() {
        WebElement syncConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(syncConfirmationLocator));
        return syncConfirmation.isDisplayed();
    }

    public void interactOnDevices() {
        WebElement deviceInteraction = driver.findElement(deviceInteractionLocator);
        deviceInteraction.click();
        Assert.assertTrue(isUserExperienceConsistent(), Device interaction failed - User experience not consistent);
    }

    public boolean isUserExperienceConsistent() {
        WebElement consistencyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(consistencyLocator));
        return consistencyElement.isDisplayed();
    }

    public void triggerError() {
        WebElement errorButton = driver.findElement(errorButtonLocator);
        errorButton.click();
        Assert.assertTrue(isErrorHandledCorrectly(), Error handling failed - Error message not displayed);
    }

    public boolean isErrorHandledCorrectly() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return errorMessage.isDisplayed();
    }

    public void logout() {
        WebElement logoutButton = driver.findElement(logoutButtonLocator);
        logoutButton.click();
        Assert.assertTrue(isLoggedOutSuccessfully(), Logout failed - Login screen not displayed);
    }

    public boolean isLoggedOutSuccessfully() {
        WebElement loginScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(loginScreenLocator));
        return loginScreen.isDisplayed();
    }
}