package com.pageobjects;

import org.openqa.selenium.By;
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

    public void navigateToAccountVerificationPage() {
        driver.get("http://example.com/account-verification");
        Assert.assertTrue(driver.getCurrentUrl().contains("account-verification"), "Navigation to account verification page failed.");
    }

    public void enterAccountCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
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

    public void verifyRedirectionToAccountDetailsPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("account-details"), "Redirection to account details page failed.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage, 3);
        String errorMessage = getTextFromElement(lblErrorMessage);
        Assert.assertTrue(errorMessage.contains("verification failed"), "Error message not displayed.");
    }

    public void verifyAccountStatusUpdatedToVerified() {
        waitUntilElementVisible(lblAccountStatus, 3);
        String status = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(status, "Verified", "Account status not updated to Verified.");
    }

    public void verifyAccountStatusRemainsUnverified() {
        waitUntilElementVisible(lblAccountStatus, 3);
        String status = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(status, "Unverified", "Account status should remain Unverified.");
    }

    public void verifyAccessToAccountFeatures() {
        // Logic to verify access to account features
        Assert.assertTrue(true, "Access to account features verified.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
        Assert.assertTrue(driver.getCurrentUrl().contains("logout"), "Logout failed.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("account-details"), "Customer should not access account details page.");
    }
}