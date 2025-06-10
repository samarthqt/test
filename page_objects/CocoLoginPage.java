package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CocoLoginPage extends WebReusableComponents {

    private final By txtUserName = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("loginButton");
    private final By btnLoginWithSSO = By.id("loginWithSSOButton");
    private final By orderConfirmationMessage = By.id("orderConfirmationMessage");

    public CocoLoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Verifies that the login screen is displayed by checking the current URL.
     */
    public void verifyLoginScreenDisplayed() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("cocoLogin"), "Login screen is not displayed.");
    }

    /**
     * Verifies the visibility of the 'Login with SSO' button.
     */
    public void verifySSOButtonVisibility() {
        waitUntilElementVisible(btnLoginWithSSO, 3);
        Assert.assertTrue(isElementVisible(btnLoginWithSSO), "'Login with SSO' button is not visible.");
    }

    /**
     * Enters the username into the username field.
     * @param username The username to be entered.
     */
    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    /**
     * Enters the password into the password field.
     * @param password The password to be entered.
     */
    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    /**
     * Verifies that the user is redirected to the homepage.
     * @param expectedURL The expected URL of the homepage.
     */
    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    /**
     * Verifies the order confirmation message.
     * @param expectedMessage The expected order confirmation message.
     */
    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }
}