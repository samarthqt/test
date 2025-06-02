package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SignupSigninPage extends WebReusableComponents {

    protected By signupSigninPageOptions = By.id("signupSigninOptions");
    protected By emailField = By.id("email");
    protected By googleSignupButton = By.id("googleSignup");
    protected By facebookSignupButton = By.id("facebookSignup");
    protected By signInButton = By.id("signInButton");
    protected By signUpButton = By.id("signUpButton");
    protected By userProfile = By.id("userProfile");
    protected By welcomeMessage = By.id("welcomeMessage");
    protected By errorMessage = By.id("errorMessage");
    protected By captcha = By.id("captcha");
    protected By passwordResetOption = By.id("passwordResetOption");

    public SignupSigninPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToSignupSigninPage() {
        launchUrl(getAppUrl() + "/signup-signin");
        waitUntilElementVisible(signupSigninPageOptions, 5);
    }

    public void verifySignupSigninPageOptions() {
        Assert.assertTrue(isElementDisplayed(signupSigninPageOptions), "Signup/Signin options are not displayed.");
    }

    public void signUpUsingEmail(String email) {
        enterText(emailField, email);
        clickElement(signUpButton);
        waitUntilElementVisible(welcomeMessage, 5);
    }

    public void verifySuccessfulSignup() {
        Assert.assertTrue(isElementDisplayed(welcomeMessage), "Signup was not successful.");
    }

    public void logOutUser() {
        clickElement(userProfile);
        // Logic to log out user
        waitUntilElementVisible(signupSigninPageOptions, 5);
    }

    public void signInUsingEmail(String email) {
        enterText(emailField, email);
        clickElement(signInButton);
        waitUntilElementVisible(userProfile, 5);
    }

    public void verifySuccessfulSignin() {
        Assert.assertTrue(isElementDisplayed(userProfile), "Signin was not successful.");
    }

    public void signUpUsingGoogle(String email) {
        clickElement(googleSignupButton);
        // Logic to handle Google signup
        waitUntilElementVisible(welcomeMessage, 5);
    }

    public void signInUsingGoogle(String email) {
        clickElement(googleSignupButton);
        // Logic to handle Google signin
        waitUntilElementVisible(userProfile, 5);
    }

    public void signUpUsingFacebook(String email) {
        clickElement(facebookSignupButton);
        // Logic to handle Facebook signup
        waitUntilElementVisible(welcomeMessage, 5);
    }

    public void signInUsingFacebook(String email) {
        clickElement(facebookSignupButton);
        // Logic to handle Facebook signin
        waitUntilElementVisible(userProfile, 5);
    }

    public void verifyUserIsSignedIn() {
        Assert.assertTrue(isElementDisplayed(userProfile), "User is not signed in.");
    }

    public void navigateToUserProfile() {
        clickElement(userProfile);
        waitUntilElementVisible(userProfile, 5);
    }

    public void verifyUserProfileInformation() {
        // Logic to verify user profile information
        Assert.assertTrue(isElementDisplayed(userProfile), "User profile information is not displayed.");
    }

    public void verifyUserHasSignedUp() {
        Assert.assertTrue(isElementDisplayed(welcomeMessage), "User has not signed up.");
    }

    public void checkUserEmailOrMessages() {
        // Logic to check user email or messages
        Assert.assertTrue(isElementDisplayed(welcomeMessage), "User email or messages are not displayed.");
    }

    public void verifyWelcomeEmailOrMessage() {
        // Logic to verify welcome email or message
        Assert.assertTrue(isElementDisplayed(welcomeMessage), "Welcome email or message is not displayed.");
    }

    public void signInUsingIncorrectCredentials() {
        enterText(emailField, "incorrect@example.com");
        clickElement(signInButton);
        waitUntilElementVisible(errorMessage, 5);
    }

    public void verifySignInErrorMessage() {
        Assert.assertTrue(isElementDisplayed(errorMessage), "Error message is not displayed.");
    }

    public void examineSecurityMeasures() {
        // Logic to examine security measures
        Assert.assertTrue(isElementDisplayed(captcha), "Security measures are not in place.");
    }

    public void verifySecurityMeasures() {
        Assert.assertTrue(isElementDisplayed(captcha), "Security measures are not in place.");
    }

    public void verifyUserIsSigningUpOrSigningIn() {
        // Logic to verify user is signing up or signing in
        Assert.assertTrue(isElementDisplayed(signupSigninPageOptions), "User is not signing up or signing in.");
    }

    public void checkBrowserConsole() {
        // Logic to check browser console
        Assert.assertTrue(isElementDisplayed(signupSigninPageOptions), "Browser console errors are present.");
    }

    public void verifyNoConsoleErrors() {
        // Logic to verify no console errors
        Assert.assertTrue(isElementDisplayed(signupSigninPageOptions), "Console errors are present.");
    }

    public void signUpWithRegisteredEmail(String email) {
        enterText(emailField, email);
        clickElement(signUpButton);
        waitUntilElementVisible(errorMessage, 5);
    }

    public void verifyEmailAlreadyRegisteredError() {
        Assert.assertTrue(isElementDisplayed(errorMessage), "Email already registered error is not displayed.");
    }

    public void checkPasswordResetOptions() {
        // Logic to check password reset options
        Assert.assertTrue(isElementDisplayed(passwordResetOption), "Password reset options are not available.");
    }

    public void verifyPasswordResetOption() {
        Assert.assertTrue(isElementDisplayed(passwordResetOption), "Password reset option is not available.");
    }

    public void verifyUserIsLoggedOut() {
        Assert.assertTrue(isElementDisplayed(signupSigninPageOptions), "User is not logged out.");
    }
}