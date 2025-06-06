package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

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
        Assert.assertTrue(isElementVisible(txtUserName), "Username field is not visible.");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible.");
    }

    public void verifyLoginUnsuccessful() {
        Assert.assertTrue(isElementVisible(errorMessage), "Error message is not displayed.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message is not displayed.");
    }

    public void verifyErrorMessageContent() {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "The username/password is incorrect.", "Error message content is incorrect.");
    }

    public void verifyErrorMessageIncorrectCredentials() {
        String message = getTextFromElement(errorMessage);
        Assert.assertEquals(message, "The username/password is incorrect.", "Error message does not state incorrect credentials.");
    }

    public void verifyUserRemainsOnLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, getAppUrl(), "User is not on the login page.");
    }

    public void verifyLoginPageElements() {
        Assert.assertTrue(isElementVisible(txtUserName), "Username field is not visible.");
        Assert.assertTrue(isElementVisible(txtPassword), "Password field is not visible.");
    }

    public void waitForProcessing() {
        waitForPageLoad();
    }

    public void verifyErrorMessageClarity() {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains("Please check your password and try again."), "Error message does not provide clear guidance.");
    }
}