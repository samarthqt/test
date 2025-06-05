package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class LoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By errorMessage = By.id("errorMessage");

    public LoginPage() {
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

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtUserName) && isElementVisible(txtPassword), "Login page is not displayed correctly.");
    }

    public void verifyLoginFieldsDisplayed() {
        Assert.assertTrue(isElementDisplayed(txtUserName), "Username field is not displayed");
        Assert.assertTrue(isElementDisplayed(txtPassword), "Password field is not displayed");
    }

    public void verifyProcessing() {
        // Logic to verify processing, e.g., loading indicator
        // Assuming a loading indicator element is present
        By loadingIndicator = By.id("loadingIndicator");
        waitUntilElementVisible(loadingIndicator, 3);
        Assert.assertTrue(isElementDisplayed(loadingIndicator), "Processing indicator is not displayed.");
    }

    public void verifyUserRemainsOnLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, getAppUrl(), "User is not on the login page.");
    }

    public void verifyLoginUnsuccessful() {
        Assert.assertTrue(isElementVisible(errorMessage), "Login was unexpectedly successful.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message is not displayed.");
    }

    public void verifyErrorMessageClarity() {
        String message = getTextFromElement(errorMessage);
        Assert.assertFalse(message.isEmpty(), "Error message is not clear or informative.");
    }

    public void verifyErrorMessageContent() {
        String message = getTextFromElement(errorMessage);
        Assert.assertEquals(message, "The username/password is incorrect.", "Error message content is incorrect.");
    }

    public void verifyErrorMessageGuidance() {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains("guidance"), "Error message does not provide guidance.");
    }
}