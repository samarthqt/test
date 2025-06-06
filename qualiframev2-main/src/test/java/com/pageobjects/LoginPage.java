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

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getTextFromElement(By element) {
        waitUntilElementVisible(element, 3);
        return driver.findElement(element).getText();
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message is not displayed.");
    }

    public void verifyErrorMessageContent(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message content is incorrect.");
    }

    public void verifyElementVisible(By element) {
        Assert.assertTrue(isElementVisible(element), "Element is not visible.");
    }

    public void verifyUserRemainsOnLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, getAppUrl(), "User is not on the login page.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyLoginUnsuccessful() {
        Assert.assertTrue(isElementVisible(errorMessage), "Login attempt was not unsuccessful.");
    }
}