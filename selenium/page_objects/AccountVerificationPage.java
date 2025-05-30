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
    protected By lblVerificationSuccess = By.id("verificationSuccess");
    protected By lblVerificationFailure = By.id("verificationFailure");
    protected By lblAccountStatus = By.id("accountStatus");
    protected By btnLogout = By.id("logout");

    public AccountVerificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToVerificationPage() {
        driver.get("http://example.com/account-verification");
    }

    public void enterAccountCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount, 3);
        clickElement(btnVerifyAccount);
    }

    public void verifyAccountSuccess() {
        waitUntilElementVisible(lblVerificationSuccess, 3);
        Assert.assertTrue(isElementDisplayed(lblVerificationSuccess), "Account verification was not successful.");
    }

    public void verifyAccountFailure() {
        waitUntilElementVisible(lblVerificationFailure, 3);
        Assert.assertTrue(isElementDisplayed(lblVerificationFailure), "Account verification did not fail as expected.");
    }

    public void verifyRedirectionToAccountDetails() {
        String expectedUrl = "http://example.com/account-details";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Redirection to account details page failed.");
    }

    public void verifyErrorMessageDisplayed() {
        Assert.assertTrue(isElementDisplayed(lblVerificationFailure), "Error message for failed verification is not displayed.");
    }

    public void verifyAccountStatusUpdated(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus, 3);
        String actualStatus = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Account status update failed.");
    }

    public void verifyAccessToAccountFeatures() {
        // Logic to verify access to account features
        // Example: Check if certain elements are accessible
        WebElement featureElement = driver.findElement(By.id("featureElement"));
        Assert.assertTrue(featureElement.isDisplayed(), "Access to account features is restricted.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyNoAccessToAccountDetails() {
        String expectedUrl = "http://example.com/account-verification";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Customer should not have access to account details page.");
    }
}