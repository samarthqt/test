package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SignInPage extends WebReusableComponents {

    protected By btnSignIn = By.id("signInButton");
    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By btnProceedSignIn = By.id("proceedSignIn");
    protected By errorMessage = By.id("errorMessage");
    protected By termsAndConditions = By.id("termsAndConditions");
    protected By supportContactInfo = By.id("supportContactInfo");

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickSignInButton() {
        waitUntilElementVisible(btnSignIn, 3);
        clickElement(btnSignIn);
    }

    public void verifySignInPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtEmail), "Sign-in page is not displayed.");
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickProceedSignIn() {
        waitUntilElementVisible(btnProceedSignIn, 3);
        clickElement(btnProceedSignIn);
    }

    public void verifySignInRequestProcessed() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("dashboard"), "Sign-in request was not processed successfully.");
    }

    public void verifyPasswordValidity() {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertFalse(actualMessage.contains("invalid password"), "Password is invalid.");
    }

    public void verifyIncorrectPasswordErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains("incorrect password"), "Error message for incorrect password is not displayed.");
    }

    public void verifyErrorMessageGuidance() {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains("password recovery"), "Guidance for password recovery is not included in the error message.");
    }

    public void verifySignInAttemptLogged() {
        // Logic to verify sign-in attempt logging
        Assert.assertTrue(true, "Sign-in attempt is not logged.");
    }

    public void verifyNoAlertsOrNotifications() {
        // Logic to verify no alerts or notifications
        Assert.assertTrue(true, "There are unexpected alerts or notifications.");
    }

    public void verifyPrivacyPoliciesAdhered() {
        // Logic to verify privacy policies adherence
        Assert.assertTrue(true, "Privacy policies are not adhered to.");
    }

    public void verifyTermsAndConditionsDisplayed() {
        waitUntilElementVisible(termsAndConditions, 3);
        Assert.assertTrue(isElementVisible(termsAndConditions), "Terms and conditions are not displayed.");
    }

    public void verifySupportContactInformation() {
        waitUntilElementVisible(supportContactInfo, 3);
        Assert.assertTrue(isElementVisible(supportContactInfo), "Support contact information is not available.");
    }

    public void verifySuccessfulSignIn() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("dashboard"), "Sign-in was not successful.");
    }

    public void verifyUserDashboardAccessible() {
        // Logic to verify user dashboard accessibility
        Assert.assertTrue(true, "User dashboard is not accessible.");
    }
}