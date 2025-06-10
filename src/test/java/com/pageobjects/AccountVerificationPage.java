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
    protected By btnVerifyAccount = By.id("verifyAccountButton");
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
        Assert.assertTrue(isElementDisplayed(accountVerificationPage), "Navigation to account verification page failed.");
    }

    public void enterAccountCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        Assert.assertTrue(isElementDisplayed(txtUsername) && isElementDisplayed(txtPassword), "Entering account credentials failed.");
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount, 3);
        clickElement(btnVerifyAccount);
        Assert.assertTrue(isElementDisplayed(btnVerifyAccount), "Clicking verify account button failed.");
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
        Assert.assertEquals(getTextFromElement(accountStatus), "Verified", "Account status not updated to Verified.");
    }

    public void verifyAccessToAccountFeatures() {
        waitUntilElementVisible(accountFeatures, 3);
        Assert.assertTrue(isElementDisplayed(accountFeatures), "Access to account features failed.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertFalse(isElementDisplayed(accountDetailsPage), "Logout failed.");
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

    public void verifyAccountStatusRemainsUnverified() {
        waitUntilElementVisible(accountStatus, 3);
        Assert.assertEquals(getTextFromElement(accountStatus), "Unverified", "Account status should remain Unverified.");
    }
}