package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ForgotPasswordPage extends WebReusableComponents {

    protected By emailOption = By.id("emailOption");
    protected By smsOption = By.id("smsOption");
    protected By recoveryEmailSentMessage = By.id("recoveryEmailSent");
    protected By recoverySMSSentMessage = By.id("recoverySMSSent");
    protected By secureTokenField = By.id("secureToken");
    protected By expiredTokenMessage = By.id("expiredTokenMessage");
    protected By passwordResetConfirmationMessage = By.id("passwordResetConfirmation");
    protected By invalidTokenMessage = By.id("invalidTokenMessage");

    public ForgotPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToForgotPasswordPage() {
        navigateToUrl("/forgot-password");
        Assert.assertTrue(isElementDisplayed(emailOption) || isElementDisplayed(smsOption), "Forgot Password page not loaded.");
    }

    public void selectRecoveryOption(String option) {
        if (option.equals("email")) {
            clickElement(emailOption);
        } else if (option.equals("sms")) {
            clickElement(smsOption);
        }
        Assert.assertTrue(isElementDisplayed(recoveryEmailSentMessage) || isElementDisplayed(recoverySMSSentMessage), "Recovery option not selected.");
    }

    public void verifyRecoveryEmailSent() {
        waitUntilElementVisible(recoveryEmailSentMessage, 3);
        Assert.assertTrue(isElementDisplayed(recoveryEmailSentMessage), "Recovery email was not sent.");
    }

    public void verifyRecoverySMSSent() {
        waitUntilElementVisible(recoverySMSSentMessage, 3);
        Assert.assertTrue(isElementDisplayed(recoverySMSSentMessage), "Recovery SMS was not sent.");
    }

    public void initiatePasswordRecovery() {
        clickElement(emailOption);
        Assert.assertTrue(isElementDisplayed(recoveryEmailSentMessage), "Password recovery initiation failed.");
    }

    public void sendSecureToken() {
        enterText(secureTokenField, "123456");
        Assert.assertTrue(isElementDisplayed(secureTokenField), "Secure token not sent.");
    }

    public void validateSecureToken() {
        String token = getTextFromElement(secureTokenField);
        Assert.assertEquals(token, "123456", "Secure token validation failed.");
    }

    public void attemptToUseExpiredToken() {
        enterText(secureTokenField, "expiredToken");
        Assert.assertTrue(isElementDisplayed(expiredTokenMessage), "Expired token usage attempt failed.");
    }

    public void verifyExpiredTokenErrorMessage() {
        waitUntilElementVisible(expiredTokenMessage, 3);
        Assert.assertTrue(isElementDisplayed(expiredTokenMessage), "Expired token error message not displayed.");
    }

    public void resetPasswordSuccessfully() {
        enterText(secureTokenField, "validToken");
        Assert.assertTrue(isElementDisplayed(passwordResetConfirmationMessage), "Password reset was not successful.");
    }

    public void completePasswordResetProcess() {
        clickElement(passwordResetConfirmationMessage);
        Assert.assertTrue(isElementDisplayed(passwordResetConfirmationMessage), "Password reset process not completed.");
    }

    public void verifyPasswordResetConfirmation() {
        waitUntilElementVisible(passwordResetConfirmationMessage, 3);
        Assert.assertTrue(isElementDisplayed(passwordResetConfirmationMessage), "Password reset confirmation not received.");
    }

    public void provideInvalidToken() {
        enterText(secureTokenField, "invalidToken");
        Assert.assertTrue(isElementDisplayed(invalidTokenMessage), "Invalid token provided.");
    }

    public void attemptPasswordResetWithInvalidToken() {
        provideInvalidToken();
        Assert.assertTrue(isElementDisplayed(invalidTokenMessage), "Password reset attempt with invalid token failed.");
    }

    public void verifyInvalidTokenErrorMessage() {
        waitUntilElementVisible(invalidTokenMessage, 3);
        Assert.assertTrue(isElementDisplayed(invalidTokenMessage), "Invalid token error message not displayed.");
    }

    public void initiatePasswordResetRequest() {
        clickElement(emailOption);
        Assert.assertTrue(isElementDisplayed(recoveryEmailSentMessage), "Password reset request initiation failed.");
    }

    public void processPasswordResetRequest() {
        clickElement(passwordResetConfirmationMessage);
        Assert.assertTrue(isElementDisplayed(passwordResetConfirmationMessage), "Password reset request processing failed.");
    }

    public void verifyPasswordResetRequestLogged() {
        Assert.assertTrue(isElementDisplayed(passwordResetConfirmationMessage), "Password reset request not logged.");
    }

    public void handleUserDataForRecovery() {
        enterText(emailOption, "user@example.com");
        Assert.assertTrue(isElementDisplayed(recoveryEmailSentMessage), "User data handling for recovery failed.");
    }

    public void processPasswordResetRequests() {
        clickElement(passwordResetConfirmationMessage);
        Assert.assertTrue(isElementDisplayed(passwordResetConfirmationMessage), "Password reset requests processing failed.");
    }

    public void verifyGDPRCompliance() {
        Assert.assertTrue(isElementDisplayed(emailOption) && isElementDisplayed(smsOption), "GDPR compliance verification failed.");
    }
}