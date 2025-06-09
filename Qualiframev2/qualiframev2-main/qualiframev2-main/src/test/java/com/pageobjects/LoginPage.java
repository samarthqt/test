package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public void verifyLoginUnsuccessful() {
        boolean isErrorVisible = isElementVisible(errorMessage);
        Assert.assertTrue(isErrorVisible, "Login attempt should be unsuccessful.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyElementVisible(By element) {
        boolean isVisible = isElementVisible(element);
        Assert.assertTrue(isVisible, "Element should be visible.");
    }

    public String getErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        return getTextFromElement(errorMessage);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getTextFromElement(By element) {
        waitUntilElementVisible(element, 3);
        WebElement webElement = driver.findElement(element);
        return webElement.getText();
    }
}