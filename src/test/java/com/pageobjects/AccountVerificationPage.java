package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AccountVerificationPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnVerifyAccount = By.id("verifyAccount");
    protected By accountStatus = By.id("accountStatus");
    protected By accountDetailsPage = By.id("accountDetailsPage");
    protected By errorMessage = By.id("errorMessage");
    protected By accountFeatures = By.id("accountFeatures");
    protected By btnLogout = By.id("logout");

    public AccountVerificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount, 3);
        clickElement(btnVerifyAccount);
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(accountStatus, 3);
        String actualStatus = getTextFromElement(accountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Account status does not match.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementVisible(accountDetailsPage), "Redirection to account details page failed.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementVisible(errorMessage), "Error message not displayed.");
    }

    public void verifyAccessToAccountFeatures() {
        waitUntilElementVisible(accountFeatures, 3);
        Assert.assertTrue(isElementVisible(accountFeatures), "Access to account features failed.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementVisible(accountDetailsPage), "Access to account details page should not be possible.");
    }
}