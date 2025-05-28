package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountVerificationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By txtUsername = By.id(username);
    protected By txtPassword = By.id(password);
    protected By btnVerifyAccount = By.id(verifyAccount);
    protected By accountStatus = By.id(accountStatus);
    protected By errorMessage = By.id(errorMessage);
    protected By accountDetailsPage = By.id(accountDetailsPage);
    protected By accountFeatures = By.id(accountFeatures);
    protected By btnLogout = By.id(logout);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickVerifyAccountButton() {
        WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(btnVerifyAccount));
        verifyButton.click();
    }

    public void verifyAccountStatus(String expectedStatus) {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountStatus));
        String actualStatus = statusElement.getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status verification failed.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        WebElement detailsPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountDetailsPage));
        Assert.assertTrue(detailsPageElement.isDisplayed(), Redirection to account details page failed.);
    }

    public void verifyErrorMessageDisplayed() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        Assert.assertTrue(errorElement.isDisplayed(), Error message not displayed.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        boolean isVisible = driver.findElements(accountDetailsPage).size() > 0;
        Assert.assertFalse(isVisible, Access to account details page should not be possible.);
    }

    public void verifyAccessToAccountFeatures() {
        WebElement featuresElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountFeatures));
        Assert.assertTrue(featuresElement.isDisplayed(), Access to account features failed.);
    }

    public void logoutFromAccount() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
        logoutButton.click();
    }
}