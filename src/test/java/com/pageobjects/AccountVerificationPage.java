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
    protected By accountStatusMessage = By.id("accountStatus");
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
        waitUntilElementVisible(accountStatusMessage, 3);
        String actualStatus = getTextFromElement(accountStatusMessage);
        Assert.assertEquals(actualStatus, expectedStatus, "Account status does not match.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), "Redirection to account details page failed.");
    }

    public void verifyAccessToAccountFeatures() {
        waitUntilElementVisible(accountFeatures, 3);
        Assert.assertTrue(isElementDisplayed(accountFeatures), "Access to account features failed.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementDisplayed(accountDetailsPage), "Access to account details page should not be possible.");
    }
}