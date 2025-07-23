package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RegistrationPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtFirstName = By.id("firstName");
    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By txtConfirmPassword = By.id("confirmPassword");
    protected By btnSubmit = By.id("submitButton");
    protected By errorMessage = By.id("errorMessage");
    protected By welcomeMessage = By.id("welcomeMessage");

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegistrationPage() {
        launchUrl(getAppUrl() + "/register");
        waitUntilElementVisible(txtFirstName, 5);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterFirstName(String firstName) {
        waitUntilElementVisible(txtFirstName, 3);
        enterText(txtFirstName, firstName);
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

    public void clickSubmitButton() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
    }

    public void verifyInvalidEmailErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyNoRegistrationOccurred() {
        boolean isRegistered = isElementPresent(welcomeMessage);
        Assert.assertFalse(isRegistered, "Registration should not have occurred.");
    }

    public void checkSystemLogsForRegistrationAttempt() {
        // Logic to check system logs for registration attempt
        // This would typically involve accessing log files or a logging service
    }

    public void verifySuccessfulRegistration() {
        waitUntilElementVisible(welcomeMessage, 3);
        String actualMessage = getTextFromElement(welcomeMessage);
        Assert.assertTrue(actualMessage.contains("Welcome"), "Registration was not successful.");
    }

    public void verifyEmailVerificationProcess() {
        // Logic to verify email verification process
        // This might involve checking for a verification email or a status update
    }

    public void checkDuplicateRegistrationPrevention() {
        // Logic to check duplicate registration prevention
        // This could involve attempting to register with the same email and checking for errors
    }

    public void verifyFieldValidations() {
        // Logic to verify field validations
        // This might involve entering invalid data and checking for validation messages
    }

    public void verifyRedirectionToWelcomePage() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("/welcome"), "User is not redirected to the welcome page.");
    }
}