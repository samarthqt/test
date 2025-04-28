package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RegistrationPage extends WebReusableComponents {

    protected By txtFirstName = By.id("firstName");
    protected By txtLastName = By.id("lastName");
    protected By btnRegister = By.id("registerButton");
    protected By errorMessage = By.id("errorMessage");
    protected By profileFirstName = By.id("profileFirstName");
    protected By profileLastName = By.id("profileLastName");

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

    public void clickRegisterButton() {
        waitUntilElementVisible(btnRegister, 3);
        clickElement(btnRegister);
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyRegistrationSuccess(String expectedMessage) {
        // Implementation for verifying registration success
    }

    public void verifyProfileNames(String expectedFirstName, String expectedLastName) {
        waitUntilElementVisible(profileFirstName, 3);
        String actualFirstName = getTextFromElement(profileFirstName);
        Assert.assertEquals(actualFirstName, expectedFirstName, "First name does not match.");

        waitUntilElementVisible(profileLastName, 3);
        String actualLastName = getTextFromElement(profileLastName);
        Assert.assertEquals(actualLastName, expectedLastName, "Last name does not match.");
    }

    public void navigateToProfileUpdatePage() {
        // Implementation for navigating to profile update page
    }

    public void enterNameInProfileUpdate(String name) {
        // Implementation for entering name in profile update
    }

    public void submitProfileUpdate() {
        // Implementation for submitting profile update
    }

    public void verifyProfileUpdateSuccess(String expectedMessage) {
        // Implementation for verifying profile update success
    }

    public void accessSystemLogs() {
        // Implementation for accessing system logs
    }

    public void checkSystemLogsForNameErrors() {
        // Implementation for checking system logs for name errors
    }

    public void verifyNoErrorsInLogs() {
        // Implementation for verifying no errors in logs
    }
}