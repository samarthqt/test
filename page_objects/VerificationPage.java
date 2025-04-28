package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class VerificationPage extends WebReusableComponents {

    protected By txtPhoneNumber = By.id("phoneNumber");
    protected By btnSubmitPhoneNumber = By.id("submitPhoneNumber");
    protected By smsCodePrompt = By.id("smsCodePrompt");
    protected By errorMessage = By.id("errorMessage");
    protected By retryOptions = By.id("retryOptions");

    public void initiateLoginProcess() {
        // Code to initiate login process
    }

    public void verifyPhoneNumberPrompt() {
        waitUntilElementVisible(txtPhoneNumber, 3);
        Assert.assertTrue(isElementVisible(txtPhoneNumber), "Phone number prompt is not visible.");
    }

    public void enterPhoneNumber(String phoneNumber) {
        waitUntilElementVisible(txtPhoneNumber, 3);
        enterText(txtPhoneNumber, phoneNumber);
    }

    public void submitPhoneNumber() {
        waitUntilElementVisible(btnSubmitPhoneNumber, 3);
        clickElement(btnSubmitPhoneNumber);
    }

    public void verifySMSCodeAttempt() {
        waitUntilElementVisible(smsCodePrompt, 3);
        Assert.assertTrue(isElementVisible(smsCodePrompt), "SMS code attempt is not visible.");
    }

    public void verifyNoSMSCodeReceived() {
        // Code to verify no SMS code received
    }

    public void verifySMSCodeTimeout() {
        // Code to verify SMS code timeout
    }

    public void attemptLoginWithoutSMSCode() {
        // Code to attempt login without SMS code
    }

    public void verifySMSCodeRequiredError() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementVisible(errorMessage), "SMS code required error message is not visible.");
    }

    public void checkRetryOrSupportOptions() {
        // Code to check retry or support options
    }

    public void verifyRetryOrSupportOptions() {
        waitUntilElementVisible(retryOptions, 3);
        Assert.assertTrue(isElementVisible(retryOptions), "Retry or support options are not visible.");
    }
}