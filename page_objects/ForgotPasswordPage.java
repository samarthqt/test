package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ForgotPasswordPage extends WebReusableComponents {

    protected By lnkForgotPassword = By.id("forgotPasswordLink");
    protected By txtEmail = By.id("email");
    protected By btnSubmit = By.id("submitButton");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By recoveryEmail = By.id("recoveryEmail");
    protected By recoveryLink = By.id("recoveryLink");

    public ForgotPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        launchUrl(getAppUrl() + "/login");
        waitUntilElementVisible(lnkForgotPassword, 5);
    }

    public void clickForgotPasswordLink() {
        waitUntilElementVisible(lnkForgotPassword, 3);
        clickElement(lnkForgotPassword);
    }

    public void verifyForgotPasswordPageDisplayed() {
        Assert.assertTrue(isElementVisible(txtEmail), "Forgot Password page is not displayed.");
    }

    public void enterRegisteredEmailAddress(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
    }

    public void verifyEmailAddressAccepted() {
        Assert.assertTrue(isElementVisible(btnSubmit), "Email address is not accepted.");
    }

    public void submitPasswordRecoveryRequest() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
    }

    public void verifyPasswordRecoveryConfirmationMessage() {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Password recovery request submitted successfully.", "Confirmation message does not match.");
    }

    public void checkEmailInboxForRecoveryEmail() {
        // Simulate checking email inbox
        waitUntilElementVisible(recoveryEmail, 5);
    }

    public void verifyRecoveryEmailReceived() {
        Assert.assertTrue(isElementVisible(recoveryEmail), "Recovery email is not received.");
    }

    public void openRecoveryEmail() {
        waitUntilElementVisible(recoveryEmail, 3);
        clickElement(recoveryEmail);
    }

    public void verifySecureRecoveryLinkInEmail() {
        Assert.assertTrue(isElementVisible(recoveryLink), "Secure recovery link is not present in the email.");
    }

    public void useRecoveryLink() {
        waitUntilElementVisible(recoveryLink, 3);
        clickElement(recoveryLink);
    }

    public void verifyPasswordResetPage() {
        Assert.assertTrue(isElementVisible(By.id("passwordResetPage")), "Password reset page is not displayed.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(By.id("logoutButton")), "User is not logged in.");
    }

    public void logoutActiveSessions() {
        waitUntilElementVisible(By.id("logoutButton"), 3);
        clickElement(By.id("logoutButton"));
    }

    public void verifyUserLoggedOut() {
        Assert.assertTrue(isElementVisible(By.id("loginButton")), "User is not logged out successfully.");
    }
}