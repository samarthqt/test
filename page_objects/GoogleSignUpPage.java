package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class GoogleSignUpPage extends WebReusableComponents {

    protected By btnSignUp = By.id("signUpButton");
    protected By googleSignUpOption = By.id("googleSignUpOption");
    protected By googleEmailField = By.id("googleEmail");
    protected By googlePasswordField = By.id("googlePassword");
    protected By btnNext = By.id("nextButton");
    protected By permissionsPage = By.id("permissionsPage");
    protected By btnGrantPermissions = By.id("grantPermissionsButton");
    protected By signUpConfirmationMessage = By.id("signUpConfirmationMessage");
    protected By dashboardPage = By.id("dashboardPage");
    protected By profileInformation = By.id("profileInformation");
    protected By btnLogout = By.id("logoutButton");
    protected By errorMessages = By.id("errorMessages");
    protected By emailConfirmation = By.id("emailConfirmation");
    protected By privacyPolicies = By.id("privacyPolicies");
    protected By termsAndConditions = By.id("termsAndConditions");

    public GoogleSignUpPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyInternetAccess() {
        Assert.assertTrue(isInternetAccessible(), "Internet access is not available.");
    }

    public void verifyUrlAccessibility(String url) {
        Assert.assertTrue(isUrlAccessible(url), "Application URL is not accessible.");
    }

    public void verifyGoogleIntegrationEnabled() {
        Assert.assertTrue(isGoogleIntegrationEnabled(), "Google sign-up integration is not enabled.");
    }

    public void navigateToApplicationUrl() {
        navigateToUrl(getAppUrl());
    }

    public void verifyHomepageDisplayed() {
        Assert.assertTrue(isElementVisible(dashboardPage), "Application homepage is not displayed.");
    }

    public void clickSignUpButton() {
        waitUntilElementVisible(btnSignUp, 3);
        clickElement(btnSignUp);
    }

    public void verifySignUpOptionsDisplayed() {
        Assert.assertTrue(isElementVisible(googleSignUpOption), "Sign-up options are not displayed.");
    }

    public void selectGoogleSignUpOption() {
        waitUntilElementVisible(googleSignUpOption, 3);
        clickElement(googleSignUpOption);
    }

    public void verifyGoogleLoginPageDisplayed() {
        Assert.assertTrue(isElementVisible(googleEmailField), "Google login page is not displayed.");
    }

    public void enterGoogleCredentials(String email, String password) {
        waitUntilElementVisible(googleEmailField, 3);
        enterText(googleEmailField, email);
        waitUntilElementVisible(googlePasswordField, 3);
        enterText(googlePasswordField, password);
    }

    public void verifyCredentialsAccepted() {
        Assert.assertTrue(isCredentialsAccepted(), "Google credentials are not accepted.");
    }

    public void clickNextButton() {
        waitUntilElementVisible(btnNext, 3);
        clickElement(btnNext);
    }

    public void verifyPermissionsPageDisplayed() {
        Assert.assertTrue(isElementVisible(permissionsPage), "Google account permissions page is not displayed.");
    }

    public void grantPermissions() {
        waitUntilElementVisible(btnGrantPermissions, 3);
        clickElement(btnGrantPermissions);
    }

    public void verifyPermissionsGranted() {
        Assert.assertTrue(isPermissionsGranted(), "Permissions are not granted.");
    }

    public void confirmSignUpProcess() {
        confirmSignUp();
    }

    public void verifySignUpConfirmationMessage() {
        Assert.assertTrue(isElementVisible(signUpConfirmationMessage), "Sign-up confirmation message is not displayed.");
    }

    public void verifyRedirectionToDashboard() {
        Assert.assertTrue(isElementVisible(dashboardPage), "User is not redirected to the application dashboard.");
    }

    public void verifyDashboardDisplayed() {
        Assert.assertTrue(isElementVisible(dashboardPage), "User dashboard is not displayed.");
    }

    public void verifyProfileInformation() {
        Assert.assertTrue(isProfileInformationCorrect(), "Profile information does not match Google account details.");
    }

    public void verifyProfileMatchesGoogleDetails() {
        Assert.assertTrue(isProfileInformationCorrect(), "Profile information does not match Google account details.");
    }

    public void logoutFromApplication() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isLogoutSuccessful(), "User is not logged out successfully.");
    }

    public void loginUsingGoogleAccount() {
        loginWithGoogle();
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isLoginSuccessful(), "User is not logged in successfully using Google.");
    }

    public void checkForErrorsOrAlerts() {
        Assert.assertFalse(isElementVisible(errorMessages), "Errors or alerts are displayed during the sign-up process.");
    }

    public void verifyNoErrorsOrAlerts() {
        Assert.assertFalse(isElementVisible(errorMessages), "Errors or alerts are displayed during the sign-up process.");
    }

    public void verifyEmailConfirmationReceived() {
        Assert.assertTrue(isElementVisible(emailConfirmation), "Email confirmation is not received.");
    }

    public void verifyEmailConfirmation() {
        Assert.assertTrue(isElementVisible(emailConfirmation), "Email confirmation is not received.");
    }

    public void confirmPrivacyPoliciesAdherence() {
        Assert.assertTrue(isPrivacyPoliciesAdheredTo(), "Privacy policies are not adhered to.");
    }

    public void verifyPrivacyPoliciesAdherence() {
        Assert.assertTrue(isPrivacyPoliciesAdheredTo(), "Privacy policies are not adhered to.");
    }

    public void ensureTermsAndConditionsAccepted() {
        Assert.assertTrue(isTermsAndConditionsAccepted(), "Terms and conditions are not accepted.");
    }

    public void verifyTermsAndConditionsAccepted() {
        Assert.assertTrue(isTermsAndConditionsAccepted(), "Terms and conditions are not accepted.");
    }
}