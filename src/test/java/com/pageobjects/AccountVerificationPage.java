package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.*;

public class AccountVerificationPage extends WebReusableComponents {

    protected By accountVerificationPage = By.id("accountVerificationPage");
    protected By accountCredentialsInput = By.id("accountCredentials");
    protected By verifyAccountButton = By.id("verifyAccountButton");
    protected By accountDetailsPage = By.id("accountDetailsPage");
    protected By accountStatus = By.id("accountStatus");
    protected By errorMessage = By.id("errorMessage");
    protected By logoutButton = By.id("logoutButton");

    public AccountVerificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        waitUntilElementVisible(accountVerificationPage, 3);
        clickElement(accountVerificationPage);
    }

    public void enterAccountCredentials() {
        waitUntilElementVisible(accountCredentialsInput, 3);
        enterText(accountCredentialsInput, "validCredentials");
    }

    public void enterIncorrectAccountCredentials() {
        waitUntilElementVisible(accountCredentialsInput, 3);
        enterText(accountCredentialsInput, "invalidCredentials");
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(verifyAccountButton, 3);
        clickElement(verifyAccountButton);
    }

    public void verifyAccountSuccess() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementVisible(accountDetailsPage), "Account verification failed.");
    }

    public void verifyAccountFailure() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementVisible(errorMessage), "Error message not displayed.");
    }

    public void verifyErrorMessage() {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Verification failed.", "Error message mismatch.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementVisible(accountDetailsPage), "Redirection failed.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementVisible(accountDetailsPage), "Access granted unexpectedly.");
    }

    public void verifyAccountStatusUpdated() {
        String actualStatus = getTextFromElement(accountStatus);
        Assert.assertEquals(actualStatus, "Verified", "Account status not updated.");
    }

    public void verifyAccountStatusUnchanged() {
        String actualStatus = getTextFromElement(accountStatus);
        Assert.assertEquals(actualStatus, "Unverified", "Account status changed unexpectedly.");
    }

    public void verifyAccessToAccountFeatures() {
        Assert.assertTrue(isElementVisible(logoutButton), "Account features not accessible.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }
}