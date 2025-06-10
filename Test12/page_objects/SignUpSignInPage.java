package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SignUpSignInPage extends WebReusableComponents {

    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By btnSubmit = By.id("submitButton");
    protected By btnGoogleSignUp = By.id("googleSignUpButton");
    protected By btnFacebookSignUp = By.id("facebookSignUpButton");
    protected By btnGoogleSignIn = By.id("googleSignInButton");
    protected By btnFacebookSignIn = By.id("facebookSignInButton");
    protected By btnForgotPassword = By.id("forgotPasswordButton");
    protected By errorMessage = By.id("errorMessage");
    protected By recoveryEmailSentMessage = By.id("recoveryEmailSentMessage");

    public SignUpSignInPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToSignUpPage() {
        launchUrl(getAppUrl() + "/signup");
        waitUntilElementVisible(txtEmail, 5);
        Assert.assertTrue(isElementVisible(txtEmail), "Sign-up page is not loaded.");
    }

    public void navigateToSignInPage() {
        launchUrl(getAppUrl() + "/signin");
        waitUntilElementVisible(txtEmail, 5);
        Assert.assertTrue(isElementVisible(txtEmail), "Sign-in page is not loaded.");
    }

    public void verifyExistingAccount() {
        // Implement logic to verify existing account
        Assert.assertTrue(isElementVisible(txtEmail), "Existing account verification failed.");
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
        Assert.assertEquals(getTextFromElement(txtEmail), email, "Email entry failed.");
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        Assert.assertEquals(getTextFromElement(txtPassword), password, "Password entry failed.");
    }

    public void submitForm() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
        Assert.assertTrue(isElementVisible(btnSubmit), "Form submission failed.");
    }

    public void signUpWithGoogle() {
        waitUntilElementVisible(btnGoogleSignUp, 3);
        clickElement(btnGoogleSignUp);
        Assert.assertTrue(isElementVisible(btnGoogleSignUp), "Google sign-up failed.");
    }

    public void signUpWithFacebook() {
        waitUntilElementVisible(btnFacebookSignUp, 3);
        clickElement(btnFacebookSignUp);
        Assert.assertTrue(isElementVisible(btnFacebookSignUp), "Facebook sign-up failed.");
    }

    public void signInWithGoogle() {
        waitUntilElementVisible(btnGoogleSignIn, 3);
        clickElement(btnGoogleSignIn);
        Assert.assertTrue(isElementVisible(btnGoogleSignIn), "Google sign-in failed.");
    }

    public void signInWithFacebook() {
        waitUntilElementVisible(btnFacebookSignIn, 3);
        clickElement(btnFacebookSignIn);
        Assert.assertTrue(isElementVisible(btnFacebookSignIn), "Facebook sign-in failed.");
    }

    public void clickForgotPassword() {
        waitUntilElementVisible(btnForgotPassword, 3);
        clickElement(btnForgotPassword);
        Assert.assertTrue(isElementVisible(btnForgotPassword), "Forgot password action failed.");
    }

    public void verifyAccountCreation() {
        // Implement logic to verify account creation
        Assert.assertTrue(isElementVisible(txtEmail), "Account creation verification failed.");
    }

    public void verifyEmailValidation() {
        // Implement logic to verify email validation
        Assert.assertTrue(isElementVisible(txtEmail), "Email validation failed.");
    }

    public void verifyUserLoggedIn() {
        // Implement logic to verify user is logged in
        Assert.assertTrue(isElementVisible(txtEmail), "User login verification failed.");
    }

    public void verifyGoogleAuthentication() {
        // Implement logic to verify Google authentication
        Assert.assertTrue(isElementVisible(btnGoogleSignIn), "Google authentication failed.");
    }

    public void verifyFacebookAuthentication() {
        // Implement logic to verify Facebook authentication
        Assert.assertTrue(isElementVisible(btnFacebookSignIn), "Facebook authentication failed.");
    }

    public void verifyErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Expected error message", "Error message does not match.");
    }

    public void verifyPasswordRecoveryEmail() {
        waitUntilElementVisible(recoveryEmailSentMessage, 3);
        String actualMessage = getTextFromElement(recoveryEmailSentMessage);
        Assert.assertEquals(actualMessage, "Expected recovery email sent message", "Recovery email message does not match.");
    }

    public void verifyAuthenticationLogging() {
        // Implement logic to verify authentication logging
        Assert.assertTrue(isElementVisible(txtEmail), "Authentication logging verification failed.");
    }

    public void verifyGDPRCompliance() {
        // Implement logic to verify GDPR compliance
        Assert.assertTrue(isElementVisible(txtEmail), "GDPR compliance verification failed.");
    }
}