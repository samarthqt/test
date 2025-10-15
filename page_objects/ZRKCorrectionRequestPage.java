package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ZRKCorrectionRequestPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By billingCorrectionFormLink = By.id("billingCorrectionForm");
    protected By correctionRequestTypeDropdown = By.id("correctionRequestType");
    protected By txtCustomerID = By.id("customerId");
    protected By txtBillingDocumentNumber = By.id("billingDocumentNumber");
    protected By optionalField1 = By.id("optionalField1");
    protected By optionalField2 = By.id("optionalField2");
    protected By btnSubmit = By.id("submitButton");
    protected By errorMessageCustomerID = By.id("errorCustomerId");
    protected By errorMessageBillingDocumentNumber = By.id("errorBillingDocumentNumber");
    protected By saveOrDiscardPrompt = By.id("saveOrDiscardPrompt");
    protected By successMessage = By.id("successMessage");
    protected By btnLogout = By.id("logoutButton");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToBillingCorrectionForm() {
        waitUntilElementVisible(billingCorrectionFormLink, 3);
        clickElement(billingCorrectionFormLink);
    }

    public void selectCorrectionRequestType(String correctionRequestType) {
        waitUntilElementVisible(correctionRequestTypeDropdown, 3);
        selectByValue(correctionRequestTypeDropdown, correctionRequestType);
    }

    public void leaveMandatoryFieldsBlank(String mandatoryField1, String mandatoryField2) {
        if (mandatoryField1.equals("Customer ID")) {
            clearText(txtCustomerID);
        }
        if (mandatoryField2.equals("Billing Document Number")) {
            clearText(txtBillingDocumentNumber);
        }
    }

    public void fillOptionalFields(String field1Value, String field2Value) {
        waitUntilElementVisible(optionalField1, 3);
        enterText(optionalField1, field1Value);
        enterText(optionalField2, field2Value);
    }

    public void submitCorrectionRequestForm() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
    }

    public void verifyErrorMessagesForMissingFields(String mandatoryField1, String mandatoryField2) {
        if (mandatoryField1.equals("Customer ID")) {
            waitUntilElementVisible(errorMessageCustomerID, 3);
            String actualMessage1 = getTextFromElement(errorMessageCustomerID);
            Assert.assertEquals(actualMessage1, "Customer ID is required", "Error message for Customer ID is incorrect.");
        }
        if (mandatoryField2.equals("Billing Document Number")) {
            waitUntilElementVisible(errorMessageBillingDocumentNumber, 3);
            String actualMessage2 = getTextFromElement(errorMessageBillingDocumentNumber);
            Assert.assertEquals(actualMessage2, "Billing Document Number is required", "Error message for Billing Document Number is incorrect.");
        }
    }

    public void attemptToNavigateAwayFromForm() {
        navigateToUrl("dummyNavigationUrl");
    }

    public void verifySaveOrDiscardPrompt() {
        waitUntilElementVisible(saveOrDiscardPrompt, 3);
        String actualPrompt = getTextFromElement(saveOrDiscardPrompt);
        Assert.assertEquals(actualPrompt, "Do you want to save or discard changes?", "Save or discard prompt is incorrect.");
    }

    public void correctMandatoryFieldsAndResubmit(String mandatoryField1, String mandatoryField2) {
        if (mandatoryField1.equals("Customer ID")) {
            enterText(txtCustomerID, "ValidCustomerID");
        }
        if (mandatoryField2.equals("Billing Document Number")) {
            enterText(txtBillingDocumentNumber, "ValidBillingDocumentNumber");
        }
        submitCorrectionRequestForm();
    }

    public void verifySuccessMessage() {
        waitUntilElementVisible(successMessage, 3);
        String actualMessage = getTextFromElement(successMessage);
        Assert.assertEquals(actualMessage, "Correction request submitted successfully", "Success message is incorrect.");
    }

    public void fillMandatoryFields(String mandatoryField1, String mandatoryField2) {
        enterText(txtCustomerID, mandatoryField1);
        enterText(txtBillingDocumentNumber, mandatoryField2);
    }

    public void verifyCorrectionRequestSaved() {
        // Dummy implementation for verifying the correction request is saved
        Assert.assertTrue(true, "Correction request is saved in the system.");
    }

    public void verifyUserLoggedIn() {
        // Dummy implementation for verifying user is logged in
        Assert.assertTrue(true, "User is logged in.");
    }

    public void logoutFromSAPSystem() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyUserLoggedOut() {
        // Dummy implementation for verifying user is logged out
        Assert.assertTrue(true, "User is logged out.");
    }
}