package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By errorMessage = By.id("errorMessage");
    protected By accountLockMessage = By.id("accountLockMessage");
    protected By btnGoogleLogin = By.id("googleLoginButton");
    protected By btnFacebookLogin = By.id("facebookLoginButton");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchLoginPage() {
        navigateToUrl(getAppUrl() + "/login");
        maximizeWindow();
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

    public void verifyLoginFailure() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Login did not fail as expected.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void clickGoogleLoginButton() {
        waitUntilElementVisible(btnGoogleLogin, 3);
        clickElement(btnGoogleLogin);
    }

    public void verifyGoogleLoginFailure() {
        verifyLoginFailure();
    }

    public void clickFacebookLoginButton() {
        waitUntilElementVisible(btnFacebookLogin, 3);
        clickElement(btnFacebookLogin);
    }

    public void verifyFacebookLoginFailure() {
        verifyLoginFailure();
    }

    public void simulateFailedLoginAttempts() {
        for (int i = 0; i < 5; i++) {
            enterUserName("wronguser");
            enterPassword("wrongpassword");
            clickLoginButton();
        }
    }

    public void verifyAccountLockout() {
        waitUntilElementVisible(accountLockMessage, 3);
        Assert.assertTrue(isElementDisplayed(accountLockMessage), "Account is not locked.");
    }

    public void ensureAccountIsLocked() {
        if (!isAccountLocked()) {
            simulateFailedLoginAttempts();
        }
    }

    public void enterValidCredentials() {
        enterUserName("validuser");
        enterPassword("validpassword");
    }

    public void verifyLoginFailureDueToLockout() {
        verifyLoginFailure();
    }

    public void attemptLogin() {
        enterUserName("user");
        enterPassword("password");
        clickLoginButton();
    }

    public void verifyNoConsoleErrors() {
        // Implement logic to verify no console errors
    }

    public void simulateMultipleFailedLogins() {
        simulateFailedLoginAttempts();
    }

    public void verifyCaptchaPresentation() {
        // Implement logic to verify CAPTCHA presentation
    }

    public void launchLoginPageOnDifferentDevice() {
        // Implement logic to launch login page on a different device
    }

    public void enterIncorrectCredentials() {
        enterUserName("wronguser");
        enterPassword("wrongpassword");
    }

    public void verifySystemPerformance() {
        // Implement logic to verify system performance
    }

    public void verifyUserIsLoggedOut() {
        Assert.assertFalse(isUserLoggedIn(), "User is not logged out.");
    }

    private boolean isAccountLocked() {
        // Implement logic to check if account is locked
        return false;
    }

    private boolean isUserLoggedIn() {
        // Implement logic to check if user is logged in
        return false;
    }
}