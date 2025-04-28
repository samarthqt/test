package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SmsCodeReceptionPage extends WebReusableComponents {

    protected By txtPhoneNumber = By.id("phoneNumber");
    protected By btnSubmitPhoneNumber = By.id("submitPhoneNumber");
    protected By txtSmsCode = By.id("smsCode");

    public void navigateToLoginPage() {
        launchUrl(getAppUrl() + "/login");
        waitUntilElementVisible(txtPhoneNumber, 5);
    }

    public void verifyPhoneNumberPrompt() {
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

    public void verifySmsCodeSent() {
        // Implement logic to verify SMS code sent
    }

    public void verifySmsCodeReceived(String smsCode) {
        // Implement logic to verify SMS code received
    }

    public void enterSmsCode(String smsCode) {
        waitUntilElementVisible(txtSmsCode, 3);
        enterText(txtSmsCode, smsCode);
    }

    public void verifySmsCodeValidation() {
        // Implement logic to verify SMS code validation
    }

    public void verifySmsCodeFormat(String expectedFormat) {
        // Implement logic to verify SMS code format
    }

    public void verifySmsCodeAccepted() {
        // Implement logic to verify SMS code acceptance
    }
}