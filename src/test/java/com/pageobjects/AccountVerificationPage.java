package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountVerificationPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnVerifyAccount = By.id("verifyAccount");
    protected By lblAccountStatus = By.id("accountStatus");
    protected By lblErrorMessage = By.id("errorMessage");
    protected By btnLogout = By.id("logout");

    public AccountVerificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToVerificationPage() {
        driver.get("https://example.com/account-verification");
    }

    public void enterAccountCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount, 3);
        clickElement(btnVerifyAccount);
    }

    public void verifyAccountSuccess() {
        waitUntilElementVisible(lblAccountStatus, 3);
        String status = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(status, "Verified", "Account verification failed.");
    }

    public void verifyAccountFailure() {
        waitUntilElementVisible(lblErrorMessage, 3);
        String errorMessage = getTextFromElement(lblErrorMessage);
        Assert.assertTrue(errorMessage.contains("verification failed"), "Error message not displayed.");
    }

    public void verifyRedirectionToAccountDetails() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("account-details"), "Redirection to account details page failed.");
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus, 3);
        String status = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(status, expectedStatus, "Account status mismatch.");
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Check if certain elements are visible or accessible
        WebElement featureElement = driver.findElement(By.id("featureElement"));
        Assert.assertTrue(featureElement.isDisplayed(), "Access to account features is restricted.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage, 3);
        String errorMessage = getTextFromElement(lblErrorMessage);
        Assert.assertTrue(errorMessage.contains("verification failed"), "Error message not displayed.");
    }

    public void verifyNoAccessToAccountDetails() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("account-details"), "Access to account details page should not be allowed.");
    }
}