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
    protected By errorMessage = By.id("errorMessage");

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

    public void verifyErrorMessage(String expectedErrorMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualErrorMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match.");
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }
}