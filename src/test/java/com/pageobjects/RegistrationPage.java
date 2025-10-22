package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RegistrationPage extends WebReusableComponents {

    protected By txtFirstName = By.id("firstName");
    protected By txtLastName = By.id("lastName");
    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By txtConfirmPassword = By.id("confirmPassword");
    protected By btnRegister = By.id("registerButton");
    protected By confirmationMessage = By.id("confirmationMessage");

    public void navigateToRegistrationPage() {
        launchUrl(getAppUrl() + "/register");
        waitUntilElementVisible(txtFirstName, 5);
    }

    public void enterFirstName(String firstName) {
        waitUntilElementVisible(txtFirstName, 3);
        enterText(txtFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        waitUntilElementVisible(txtLastName, 3);
        enterText(txtLastName, lastName);
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        waitUntilElementVisible(txtConfirmPassword, 3);
        enterText(txtConfirmPassword, confirmPassword);
    }

    public void clickRegisterButton() {
        waitUntilElementVisible(btnRegister, 3);
        clickElement(btnRegister);
    }

    public void verifyRegistrationSuccess(String expectedMessage) {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Registration confirmation message does not match.");
    }

    public void completeCaptchaVerification() {
        // Implement CAPTCHA verification logic
    }

    public void checkEmailInboxForConfirmationEmail() {
        // Implement email inbox checking logic
    }

    public void verifyConfirmationEmailReceived() {
        // Implement confirmation email verification logic
    }

    public void selectActivationLinkInEmail() {
        // Implement activation link selection logic
    }

    public void verifyAccountActivation() {
        // Implement account activation verification logic
    }

    public void attemptLoginWithRegisteredCredentials() {
        // Implement login attempt logic
    }

    public void verifySuccessfulLogin() {
        // Implement successful login verification logic
    }

    public void navigateToHomepage() {
        // Implement navigation to homepage logic
    }

    public void verifyRegistrationPageDisplayed() {
        // Implement registration page display verification logic
    }

    public void verifyDuplicateRegistrationError() {
        // Implement duplicate registration error verification logic
    }

    public void verifyWeakPasswordError() {
        // Implement weak password error verification logic
    }

    public void doNotAcceptTermsAndConditions() {
        // Implement logic for not accepting terms and conditions
    }

    public void verifyTermsAndConditionsError() {
        // Implement terms and conditions error verification logic
    }

    public void navigateToLoginPage() {
        // Implement navigation to login page logic
    }

    public void verifyActivationPrompt() {
        // Implement activation prompt verification logic
    }

    public void verifyInvalidEmailFormatError() {
        // Implement invalid email format error verification logic
    }
}