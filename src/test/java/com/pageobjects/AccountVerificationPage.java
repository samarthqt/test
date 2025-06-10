package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AccountVerificationPage extends WebReusableComponents {

    protected By accountVerificationPage = By.id("accountVerificationPage");
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By verifyAccountButton = By.id("verifyAccountButton");
    protected By accountDetailsPage = By.id("accountDetailsPage");
    protected By accountStatus = By.id("accountStatus");
    protected By accountFeatures = By.id("accountFeatures");
    protected By logoutButton = By.id("logoutButton");
    protected By errorMessage = By.id("errorMessage");

    public AccountVerificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        waitUntilElementVisible(accountVerificationPage, 3);
        clickElement(accountVerificationPage);
    }

    public void enterAccountCredentials(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(verifyAccountButton, 3);
        clickElement(verifyAccountButton);
    }

    public void verifyAccountSuccess() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), "Account verification failed.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), "Redirection to account details page failed.");
    }

    public void verifyAccountStatusUpdatedToVerified() {
        waitUntilElementVisible(accountStatus, 3);
        String status = getTextFromElement(accountStatus);
        Assert.assertEquals(status, "Verified", "Account status is not updated to Verified.");
    }

    public void verifyAccessToAccountFeatures() {
        waitUntilElementVisible(accountFeatures, 3);
        Assert.assertTrue(isElementDisplayed(accountFeatures), "Access to account features failed.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyAccountFailure() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Account verification did not fail as expected.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        String message = getTextFromElement(errorMessage);
        Assert.assertEquals(message, "Account verification failed.", "Error message is not displayed correctly.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementDisplayed(accountDetailsPage), "Access to account details page should not be possible.");
    }

    public void verifyAccountStatusRemainsUnverified() {
        waitUntilElementVisible(accountStatus, 3);
        String status = getTextFromElement(accountStatus);
        Assert.assertEquals(status, "Unverified", "Account status should remain Unverified.");
    }
}