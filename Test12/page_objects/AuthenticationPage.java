package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AuthenticationPage extends WebReusableComponents {

    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By btnSignUp = By.id("signUpButton");
    protected By btnLogin = By.id("loginButton");
    protected By btnGoogleSignUp = By.id("googleSignUpButton");
    protected By btnFacebookSignUp = By.id("facebookSignUpButton");
    protected By btnGoogleLogin = By.id("googleLoginButton");
    protected By btnFacebookLogin = By.id("facebookLoginButton");
    protected By btnForgotPassword = By.id("forgotPasswordButton");
    protected By notificationMessage = By.id("notificationMessage");
    protected By errorMessage = By.id("errorMessage");
    protected By recoveryEmail = By.id("recoveryEmail");
    protected By btnRecoverySubmit = By.id("recoverySubmitButton");
    protected By currentPassword = By.id("currentPassword");
    protected By newPassword = By.id("newPassword");
    protected By btnChangePasswordSubmit = By.id("changePasswordSubmitButton");
    protected By twoFactorSetup = By.id("twoFactorSetup");

    public AuthenticationPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToSignUpPage() {
        launchUrl(getAppUrl() + "/signup");
        maximizeWindow();
    }

    public void navigateToLoginPage() {
        launchUrl(getAppUrl() + "/login");
        maximizeWindow();
    }

    public void navigateToSignInPage() {
        launchUrl(getAppUrl() + "/signin");
        maximizeWindow();
    }

    public void navigateToPasswordRecoveryPage() {
        launchUrl(getAppUrl() + "/password-recovery");
        maximizeWindow();
    }

    public void navigateToChangePasswordPage() {
        launchUrl(getAppUrl() + "/change-password");
        maximizeWindow();
    }

    public void navigateToAuthenticationPage() {
        launchUrl(getAppUrl() + "/authentication");
        maximizeWindow();
    }

    public void navigateToTwoFactorSetupPage() {
        launchUrl(getAppUrl() + "/two-factor-setup");
        maximizeWindow();
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void enterEmailAndPassword() {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, "test@example.com");
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, "password123");
    }

    public void enterInvalidEmailOrPassword() {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, "invalid@example.com");
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, "wrongpassword");
    }

    public void enterRecoveryEmail(String email) {
        waitUntilElementVisible(recoveryEmail, 3);
        enterText(recoveryEmail, email);
    }

    public void enterCurrentAndNewPassword(String currentPwd, String newPwd) {
        waitUntilElementVisible(currentPassword, 3);
        enterText(currentPassword, currentPwd);
        waitUntilElementVisible(newPassword, 3);
        enterText(newPassword, newPwd);
    }

    public void clickSignUpButton() {
        waitUntilElementVisible(btnSignUp, 3);
        clickElement(btnSignUp);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void clickGoogleSignUp() {
        waitUntilElementVisible(btnGoogleSignUp, 3);
        clickElement(btnGoogleSignUp);
    }

    public void clickFacebookSignUp() {
        waitUntilElementVisible(btnFacebookSignUp, 3);
        clickElement(btnFacebookSignUp);
    }

    public void clickGoogleLogin() {
        waitUntilElementVisible(btnGoogleLogin, 3);
        clickElement(btnGoogleLogin);
    }

    public void clickFacebookLogin() {
        waitUntilElementVisible(btnFacebookLogin, 3);
        clickElement(btnFacebookLogin);
    }

    public void clickForgotPassword() {
        waitUntilElementVisible(btnForgotPassword, 3);
        clickElement(btnForgotPassword);
    }

    public void submitSignUpForm() {
        waitUntilElementVisible(btnSignUp, 3);
        clickElement(btnSignUp);
    }

    public void submitSignInForm() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void submitPasswordRecoveryForm() {
        waitUntilElementVisible(btnRecoverySubmit, 3);
        clickElement(btnRecoverySubmit);
    }

    public void submitChangePasswordForm() {
        waitUntilElementVisible(btnChangePasswordSubmit, 3);
        clickElement(btnChangePasswordSubmit);
    }

    public void completeGoogleAuthentication() {
        // Logic to complete Google authentication
    }

    public void completeFacebookAuthentication() {
        // Logic to complete Facebook authentication
    }

    public void completeTwoFactorSetup() {
        // Logic to complete two-factor setup
    }

    public void enableTwoFactorAuthentication() {
        // Logic to enable two-factor authentication
    }

    public void verifySignUpSuccess() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Sign up successful.", "Sign up failed.");
    }

    public void verifySignUpNotification() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Welcome! You have signed up successfully.", "Sign up notification missing.");
    }

    public void verifyLoginSuccess() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Login successful.", "Login failed.");
    }

    public void verifyLoginNotification() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Welcome back! You have logged in successfully.", "Login notification missing.");
    }

    public void verifyAuthenticationError() {
        waitUntilElementVisible(errorMessage, 3);
        String message = getTextFromElement(errorMessage);
        Assert.assertEquals(message, "Invalid credentials.", "Error message not displayed.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        String message = getTextFromElement(errorMessage);
        Assert.assertEquals(message, "An error occurred.", "Error message not displayed.");
    }

    public void verifyConfirmationEmailSent() {
        // Logic to verify email sent
    }

    public void verifySuccessfulSignUpMessage() {
        waitUntilElementVisible(notificationMessage, 3);
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Sign-up successful.", "Sign-up message mismatch.");
    }

    public void verifyPasswordRecoveryInitiation() {
        // Logic to verify password recovery initiation
    }

    public void verifyPasswordRecoveryEmailSent() {
        // Logic to verify password recovery email sent
    }

    public void verifyUserLoggedIn() {
        // Logic to verify user is logged in
    }

    public void verifyPasswordChangedSuccessfully() {
        // Logic to verify password change success
    }

    public void verifyTwoFactorAuthentication() {
        // Logic to verify two-factor authentication
    }

    public void verifyTwoFactorEnabled() {
        // Logic to verify two-factor enabled
    }

    public void verifyAuthenticationLogging() {
        // Logic to verify authentication logging
    }

    public void verifyAuthenticationLogged() {
        // Logic to verify authentication logged
    }

    public void verifySecureHandling() {
        // Logic to verify secure handling of credentials
    }

    public void verifySecurityStandardsCompliance() {
        // Logic to verify security standards compliance
    }

    public void verifyGDPRCompliance() {
        // Logic to verify GDPR compliance
    }

    public void verifyIntuitiveUserInterface() {
        // Logic to verify intuitive user interface
    }

    public void attemptSignIn() {
        // Logic to attempt sign-in
    }

    public void enterGoogleCredentials() {
        // Logic to enter Google credentials
    }

    public void enterFacebookCredentials() {
        // Logic to enter Facebook credentials
    }

    public void chooseGoogleSignUp() {
        waitUntilElementVisible(btnGoogleSignUp, 3);
        clickElement(btnGoogleSignUp);
    }

    public void chooseFacebookSignUp() {
        waitUntilElementVisible(btnFacebookSignUp, 3);
        clickElement(btnFacebookSignUp);
    }
}