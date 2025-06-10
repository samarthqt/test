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
    protected By homepageContent = By.id("homepageContent");

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

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    public void verifyLoginPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtUserName), "Login page is not displayed.");
    }

    public void verifyUrlAccessibility() {
        Assert.assertTrue(isUrlAccessible(getAppUrl()), "URL is not accessible.");
    }

    public void verifyUsernameEntered(String expectedUsername) {
        String actualUsername = getElementAttribute(txtUserName, "value");
        Assert.assertEquals(actualUsername, expectedUsername, "Username is not entered correctly.");
    }

    public void verifyPasswordEntered(String expectedPassword) {
        String actualPassword = getElementAttribute(txtPassword, "value");
        Assert.assertEquals(actualPassword, expectedPassword, "Password is not entered correctly.");
    }

    public void verifyUserSpecificContent() {
        Assert.assertTrue(isElementVisible(homepageContent), "User-specific content is not displayed on the homepage.");
    }

    public void verifyLoginFailure() {
        Assert.assertTrue(isElementVisible(errorMessage), "Login attempt did not fail.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }
}