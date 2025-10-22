package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

public class LoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By dashboardContent = By.id("dashboardContent");
    protected By errorMessage = By.id("errorMessage");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        launchUrl(getAppUrl() + "/login");
        waitUntilElementVisible(txtUserName, 5);
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

    public void verifyDashboardRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the dashboard.");
    }

    public void verifyUserSpecificContent() {
        waitUntilElementVisible(dashboardContent, 3);
        String content = getTextFromElement(dashboardContent);
        Assert.assertTrue(content.contains("Welcome validUser"), "User-specific content is not displayed.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    public void verifySimultaneousLoginErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Simultaneous login error message is not displayed correctly.");
    }
}
