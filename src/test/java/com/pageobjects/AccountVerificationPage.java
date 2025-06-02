package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

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
        String expectedURL = getAppUrl() + "/accountDetails";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "Redirection to account details page failed.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage, 3);
        String errorMessage = getTextFromElement(lblErrorMessage);
        Assert.assertTrue(errorMessage.contains("verification failed"), "Error message not displayed correctly.");
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Check if certain elements are visible or enabled
        boolean isFeatureAccessible = isElementVisible(By.id("featureElementId"));
        Assert.assertTrue(isFeatureAccessible, "Access to account features is not available.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        String expectedURL = getAppUrl() + "/accountDetails";
        String currentURL = getCurrentURL();
        Assert.assertNotEquals(currentURL, expectedURL, "Access to account details page should not be allowed.");
    }
}