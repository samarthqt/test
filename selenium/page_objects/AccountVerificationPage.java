package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountVerificationPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By txtUserName = By.id(username);
    protected By txtPassword = By.id(password);
    protected By btnVerifyAccount = By.id(verifyAccountButton);
    protected By lblAccountStatus = By.id(accountStatus);
    protected By lblErrorMessage = By.id(errorMessage);
    protected By btnLogout = By.id(logoutButton);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        driver.get(getAppUrl() + /account-verification);
        driver.manage().window().maximize();
    }

    public void enterUserName(String username) {
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtUserName));
        userNameField.clear();
        userNameField.sendKeys(username);
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
        WebElement accountStatusLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(lblAccountStatus));
        String actualStatus = accountStatusLabel.getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status does not match.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedURL = getAppUrl() + /account-details;
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, User is not redirected to the account details page.);
    }

    public void verifyErrorMessageDisplayed() {
        WebElement errorMessageLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMessage));
        String actualMessage = errorMessageLabel.getText();
        Assert.assertTrue(actualMessage.contains(verification failed), Error message is not displayed correctly.);
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Check if certain elements are visible or clickable
        // Assert.assertTrue(condition, Access to account features is not verified.);
    }

    public void logoutFromAccount() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
        logoutButton.click();
    }

    public void verifyNoAccessToAccountDetailsPage() {
        String expectedURL = getAppUrl() + /account-details;
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(expectedURL)));
        String currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals(currentURL, expectedURL, User should not have access to the account details page.);
    }
}