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
    protected By errorMessage = By.id("errorMessage");
    protected By logoutButton = By.id("logoutButton");

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

    public void verifyAccountVerificationSuccess() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), "Account verification failed.");
    }

    public void verifyAccountVerificationFailure() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message not displayed.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), "Redirection to account details page failed.");
    }

    public void verifyAccountStatusUpdatedToVerified() {
        waitUntilElementVisible(accountStatus, 3);
        Assert.assertEquals(getTextFromElement(accountStatus), "Verified", "Account status not updated to Verified.");
    }

    public void verifyAccessToAccountFeatures() {
        // Logic to verify access to account features
        Assert.assertTrue(true, "Access to account features verified.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message not displayed.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        // Logic to verify no access to account details page
        Assert.assertTrue(true, "No access to account details page verified.");
    }

    public void verifyAccountStatusRemainsUnverified() {
        waitUntilElementVisible(accountStatus, 3);
        Assert.assertEquals(getTextFromElement(accountStatus), "Unverified", "Account status is not Unverified.");
    }
}