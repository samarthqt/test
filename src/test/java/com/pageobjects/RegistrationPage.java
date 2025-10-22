package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RegistrationPage extends WebReusableComponents {

    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By btnRegister = By.id("registerButton");
    protected By captchaVerification = By.id("captcha");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By errorMessage = By.id("errorMessage");
    protected By systemMessage = By.id("systemMessage");
    protected By weakPasswordField = By.id("weakPasswordField");
    protected By captchaCheckbox = By.id("captchaCheckbox");
    protected By captcha = By.id("captcha");

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegistrationPage() {
        launchUrl(getAppUrl() + "/register");
        waitUntilElementVisible(txtEmail, 5);
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void completeCaptchaVerification() {
        waitUntilElementVisible(captchaVerification, 3);
        // Logic to complete CAPTCHA
    }

    public void clickRegisterButton() {
        waitUntilElementVisible(btnRegister, 3);
        clickElement(btnRegister);
    }

    public void verifyRegistrationSuccess() {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Registration successful", "Registration confirmation message does not match.");
    }

    public void checkEmailInboxForConfirmationEmail() {
        // Logic to check email inbox
    }

    public void verifyConfirmationEmailReceived() {
        // Logic to verify email received
    }

    public void selectActivationLinkInEmail() {
        // Logic to select activation link
    }

    public void verifyAccountActivation() {
        // Logic to verify account activation
    }

    public void attemptLoginWithRegisteredCredentials() {
        // Logic to attempt login
    }

    public void verifySuccessfulLogin() {
        // Logic to verify successful login
    }

    public void verifyEmailAlreadyRegisteredError() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Email is already registered.", "Error message does not match.");
    }

    public void verifyRegistrationOutcome(String expectedOutcome) {
        if (expectedOutcome.contains("error message")) {
            waitUntilElementVisible(errorMessage, 3);
            String actualMessage = getTextFromElement(errorMessage);
            Assert.assertTrue(actualMessage.contains("invalid email format"), "Error message not displayed as expected.");
        } else if (expectedOutcome.contains("allow registration")) {
            // Assume successful registration leads to a confirmation page or message
            String currentURL = getCurrentURL();
            Assert.assertTrue(currentURL.contains("confirmation"), "Registration was not successful.");
        }
    }

    public void verifySystemMessage(String expectedMessage) {
        waitUntilElementVisible(systemMessage, 3);
        String actualMessage = getTextFromElement(systemMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "System message does not match.");
    }

    public void verifyCaptchaSuccess() {
        // Implement CAPTCHA success verification logic
        Assert.assertTrue(isElementVisible(captchaVerification), "CAPTCHA verification failed.");
    }

    public void attemptToRegister() {
        waitUntilElementVisible(btnRegister, 3);
        clickElement(btnRegister);
    }

    public void verifyWeakPasswordFieldHighlighted() {
        Assert.assertTrue(isElementVisible(weakPasswordField), "Weak password field is not highlighted.");
    }

    public void verifyRegistrationSuccessAndEmailSent() {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertTrue(actualMessage.contains("confirmation email"), "Registration confirmation email was not sent.");
    }
}
