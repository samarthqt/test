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

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message is not displayed.");
    }

    public void verifyErrorMessageContent(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message content is incorrect.");
    }

    public void verifyErrorMessageIncorrectCredentials() {
        String messageContent = getTextFromElement(errorMessage);
        Assert.assertEquals(messageContent, "The username/password is incorrect.", "Error message does not state incorrect credentials.");
    }

    public void verifyLoginUnsuccessful() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message not displayed.");
    }

    public String getErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        return getTextFromElement(errorMessage);
    }

    public void verifyElementVisible(By element) {
        Assert.assertTrue(isElementVisible(element), "Element is not visible: " + element.toString());
    }
}