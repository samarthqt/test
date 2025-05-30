package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

public class AccountVerificationPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnVerifyAccount = By.id("verifyAccountButton");
    protected By lblAccountStatus = By.id("accountStatus");
    protected By lblErrorMessage = By.id("errorMessage");
    protected By btnLogout = By.id("logoutButton");

    public AccountVerificationPage() {
        PageFactory.initElements(driver, this);
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

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus, 3);
        String actualStatus = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Account status does not match.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedURL = testHarness.getData("AccountData", "AccountDetailsPageURL");
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "Redirection to account details page failed.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualMessage = getTextFromElement(lblErrorMessage);
        String expectedMessage = testHarness.getData("AccountData", "ExpectedErrorMessage");
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyAccessToAccountFeatures() {
        // Example logic to verify access to account features
        boolean hasAccess = isElementVisible(By.id("accountFeature"));
        Assert.assertTrue(hasAccess, "Access to account features is not available.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        // Example logic to verify no access to account details page
        boolean hasAccess = isElementVisible(By.id("accountDetails"));
        Assert.assertFalse(hasAccess, "Access to account details page should not be available.");
    }
}