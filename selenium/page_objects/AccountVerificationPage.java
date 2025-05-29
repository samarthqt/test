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
    protected By accountDetailsPage = By.id("accountDetails");
    protected By accountStatus = By.id("accountStatus");
    protected By accountFeatures = By.id("accountFeatures");
    protected By btnLogout = By.id("logout");
    protected By errorMessage = By.id("errorMessage");

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

    public void verifyAccountSuccess() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementVisible(accountDetailsPage), "Account verification failed.");
    }

    public void verifyRedirectionToAccountDetails() {
        String expectedUrl = getExpectedAccountDetailsUrl();
        Assert.assertEquals(getCurrentUrl(), expectedUrl, "Redirection to account details page failed.");
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(accountStatus, 3);
        String actualStatus = getTextFromElement(accountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Account status update failed.");
    }

    public void verifyAccessToAccountFeatures() {
        waitUntilElementVisible(accountFeatures, 3);
        Assert.assertTrue(isElementVisible(accountFeatures), "Access to account features failed.");
    }

    public void performLogout() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyAccountFailure() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementVisible(errorMessage), "Account verification did not fail as expected.");
    }

    public void verifyErrorMessageDisplayed() {
        String expectedMessage = getExpectedErrorMessage();
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyNoAccessToAccountDetails() {
        Assert.assertFalse(isElementVisible(accountDetailsPage), "Access to account details page should not be possible.");
    }
}