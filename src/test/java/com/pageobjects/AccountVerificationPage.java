package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountVerificationPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnVerifyAccount = By.id("verifyAccountButton");
    protected By lblAccountStatus = By.id("accountStatus");
    protected By lblErrorMessage = By.id("errorMessage");
    protected By btnLogout = By.id("logoutButton");

    public AccountVerificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
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
        Assert.assertEquals(actualStatus, expectedStatus, "Account status does not match.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedURL = getAppUrl() + "/accountDetails";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the account details page.");
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        WebElement featureElement = driver.findElement(By.id("featureElement"));
        Assert.assertTrue(featureElement.isDisplayed(), "Account features are not accessible.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
        String expectedURL = getAppUrl() + "/logout";
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the logout page.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualMessage = getTextFromElement(lblErrorMessage);
        Assert.assertTrue(actualMessage.contains("verification failed"), "Error message is not displayed correctly.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        // Implement logic to verify no access to account details page
        String currentURL = getCurrentURL();
        Assert.assertFalse(currentURL.contains("/accountDetails"), "User has access to account details page.");
    }
}