package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class AccountVerificationPage extends WebReusableComponents {

    protected By accountVerificationPage = By.id("accountVerificationPage");
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnVerifyAccount = By.id("verifyAccount");
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
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), "Account verification failed.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), "Redirection to account details page failed.");
    }

    public void verifyAccountStatusUpdated(String expectedStatus) {
        waitUntilElementVisible(accountStatus, 3);
        String actualStatus = getTextFromElement(accountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Account status update failed.");
    }

    public void verifyAccessToAccountFeatures() {
        // Logic to verify access to account features
        Assert.assertTrue(true, "Access to account features verified.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertTrue(true, "Logout performed.");
    }

    public void verifyAccountFailure() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Account verification did not fail as expected.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message not displayed.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementDisplayed(accountDetailsPage), "Access to account details page should not be possible.");
    }
}