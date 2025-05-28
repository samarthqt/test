package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountVerificationPage extends WebReusableComponents {

    private WebDriver driver;

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnVerifyAccount = By.id("verifyAccountButton");
    protected By accountStatus = By.id("accountStatus");
    protected By accountDetailsPage = By.id("accountDetailsPage");
    protected By errorMessage = By.id("errorMessage");
    protected By btnLogout = By.id("logoutButton");

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(final String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(final String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount, 3);
        clickElement(btnVerifyAccount);
    }

    public void verifyAccountStatus(final String expectedStatus) {
        waitUntilElementVisible(accountStatus, 3);
        String actualStatus = getTextFromElement(accountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Account status does not match.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), "Customer is not redirected to account details page.");
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Assert.assertTrue(isElementDisplayed(someFeatureElement), "Feature is not accessible.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyErrorMessage(final String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementDisplayed(accountDetailsPage), "Customer should not have access to account details page.");
    }
}