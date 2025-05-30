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
        waitUntilElementVisible(lblAccountStatus, 3);
        String actualStatus = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Account status verification failed.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualMessage = getTextFromElement(lblErrorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message verification failed.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedURL = "http://example.com/account-details";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "Redirection to account details page failed.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        String expectedURL = "http://example.com/no-access";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "Access to account details page should be restricted.");
    }

    public void verifyAccessToAccountFeatures() {
        boolean isFeatureAccessible = isElementPresent(By.id("accountFeature"));
        Assert.assertTrue(isFeatureAccessible, "Access to account features is restricted.");
    }

    public void performLogout() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
        String expectedURL = "http://example.com/login";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "Logout failed, user is not redirected to login page.");
    }
}