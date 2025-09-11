package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ClaimSearchPage extends WebReusableComponents {

    @FindBy(id = "tinField")
    private WebElement tinField;

    @FindBy(id = "tinValidationMessage")
    private WebElement tinValidationMessage;

    @FindBy(id = "submitSearch")
    private WebElement submitSearchButton;

    @FindBy(xpath = "//label[@for='tinField']")
    private WebElement tinFieldLabel;

    @FindBy(id = "patientFirstName")
    private WebElement patientFirstNameField;

    @FindBy(id = "patientLastName")
    private WebElement patientLastNameField;

    @FindBy(id = "patientDOB")
    private WebElement patientDOBField;

    @FindBy(id = "dateOfService")
    private WebElement dateOfServiceField;

    @FindBy(id = "totalBilledCharges")
    private WebElement totalBilledChargesField;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(id = "systemMessage")
    private WebElement systemMessage;

    @FindBy(id = "submitClaimSearch")
    private WebElement submitClaimSearchButton;

    @FindBy(xpath = "//label[@for='patientDOB']")
    private WebElement patientDOBFieldLabel;

    @FindBy(xpath = "//label[@for='dateOfService']")
    private WebElement dateOfServiceFieldLabel;

    @FindBy(xpath = "//label[@for='totalBilledCharges']")
    private WebElement totalBilledChargesFieldLabel;

    public ClaimSearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToClaimSearchPage() {
        launchUrl("https://dummyurl.com/claimsearch");
        maximizeWindow();
    }

    public void enterTIN(String tin) {
        waitUntilElementVisible(tinField, 3);
        tinField.clear();
        tinField.sendKeys(tin);
    }

    public void attemptToEnterInvalidTIN(String invalidCharacters) {
        waitUntilElementVisible(tinField, 3);
        tinField.clear();
        tinField.sendKeys(invalidCharacters);
    }

    public void verifyTINFieldLabel() {
        waitUntilElementVisible(tinFieldLabel, 3);
        String actualLabel = tinFieldLabel.getText();
        Assert.assertEquals(actualLabel, "TIN", "TIN field label is incorrect.");
    }

    public void leaveTINFieldBlankAndSubmit() {
        waitUntilElementVisible(tinField, 3);
        tinField.clear();
        waitUntilElementVisible(submitSearchButton, 3);
        submitSearchButton.click();
    }

    public void verifyValidationMessage(String expectedMessage) {
        waitUntilElementVisible(tinValidationMessage, 3);
        String actualMessage = tinValidationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message mismatch.");
    }

    public void enterPatientFirstName(String inputValue) {
        waitUntilElementVisible(patientFirstNameField, 3);
        patientFirstNameField.clear();
        patientFirstNameField.sendKeys(inputValue);
    }

    public void leavePatientFirstNameFieldBlank() {
        waitUntilElementVisible(patientFirstNameField, 3);
        patientFirstNameField.clear();
    }

    public void verifyPatientFirstNameFieldPresence() {
        Assert.assertTrue(isElementDisplayed(patientFirstNameField), "Patient First Name field is not displayed.");
    }

    public void verifyInputAccepted() {
        String enteredValue = patientFirstNameField.getAttribute("value");
        Assert.assertFalse(enteredValue.isEmpty(), "Input value was not accepted.");
    }

    public void enterPatientLastName(String value) {
        waitUntilElementVisible(patientLastNameField, 3);
        patientLastNameField.clear();
        patientLastNameField.sendKeys(value);
    }

    public void leavePatientLastNameFieldBlank() {
        waitUntilElementVisible(patientLastNameField, 3);
        patientLastNameField.clear();
    }

    public void verifyPatientLastNameFieldLabel(String expectedLabel) {
        waitUntilElementVisible(patientLastNameField, 3);
        String actualLabel = patientLastNameField.getAttribute("placeholder");
        Assert.assertEquals(actualLabel, expectedLabel, "Patient Last Name field label mismatch.");
    }

    public void enterPatientDOB(String dob) {
        waitUntilElementVisible(patientDOBField, 3);
        patientDOBField.clear();
        patientDOBField.sendKeys(dob);
    }

    public void leavePatientDOBFieldBlank() {
        waitUntilElementVisible(patientDOBField, 3);
        patientDOBField.clear();
    }

    public void validatePatientDOBFormat(String dob) {
        enterPatientDOB(dob);
        String enteredValue = patientDOBField.getAttribute("value");
        Assert.assertTrue(enteredValue.matches("\\d{2}/\\d{2}/\\d{4}"), "DOB format is invalid.");
    }

    public void validatePatientDOBNotInFuture(String dob) {
        enterPatientDOB(dob);
        // Assuming a method to validate the date logic
        Assert.assertTrue(isDateNotInFuture(dob), "DOB is in the future.");
    }

    public void verifyDateOfServiceFieldLabel(String expectedLabel) {
        waitUntilElementVisible(dateOfServiceFieldLabel, 3);
        String actualLabel = dateOfServiceFieldLabel.getText();
        Assert.assertEquals(actualLabel, expectedLabel, "Date of Service field label mismatch.");
    }

    public void enterDateOfService(String date) {
        waitUntilElementVisible(dateOfServiceField, 3);
        dateOfServiceField.clear();
        dateOfServiceField.sendKeys(date);
    }

    public void verifyTotalBilledChargesFieldLabel(String expectedLabel) {
        waitUntilElementVisible(totalBilledChargesFieldLabel, 3);
        String actualLabel = totalBilledChargesFieldLabel.getText();
        Assert.assertEquals(actualLabel, expectedLabel, "Total Billed Charges field label mismatch.");
    }

    public void enterTotalBilledCharges(String charges) {
        waitUntilElementVisible(totalBilledChargesField, 3);
        totalBilledChargesField.clear();
        totalBilledChargesField.sendKeys(charges);
    }

    public void leaveTotalBilledChargesFieldBlank() {
        waitUntilElementVisible(totalBilledChargesField, 3);
        totalBilledChargesField.clear();
    }

    public void submitClaimSearch() {
        waitUntilElementVisible(submitClaimSearchButton, 3);
        submitClaimSearchButton.click();
    }

    public void verifyRequiredFieldErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Required field error message mismatch.");
    }

    public void verifyValidationErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation error message mismatch.");
    }

    public void verifyBlankFieldErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Blank field error message mismatch.");
    }

    public void verifyUserFriendlyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "User-friendly error message mismatch.");
    }

    public void verifySystemMessage(String expectedMessage) {
        waitUntilElementVisible(systemMessage, 3);
        String actualMessage = systemMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "System message mismatch.");
    }

    public void attemptToEnterInvalidPatientLastName(String invalidValue) {
        enterPatientLastName(invalidValue);
        String enteredValue = patientLastNameField.getAttribute("value");
        Assert.assertNotEquals(enteredValue, invalidValue, "Invalid value was accepted.");
    }

    public void verifyInputPrevention() {
        String enteredValue = patientFirstNameField.getAttribute("value");
        Assert.assertTrue(enteredValue.isEmpty(), "Invalid input was not prevented.");
    }

    public void verifyErrorMessageForInvalidDOB(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message for invalid DOB mismatch.");
    }

    public void verifyNoErrorMessageForBlankDOB() {
        leavePatientDOBFieldBlank();
        Assert.assertFalse(isElementDisplayed(errorMessage), "Error message displayed for blank DOB.");
    }
}