package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class InvoiceProcessingPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By billingModuleLink = By.id("billingModule");
    protected By billingDocumentTypeDropdown = By.id("billingDocumentType");
    protected By externalParentDistrDebitMemoDateField = By.id("externalParentDistrDebitMemoDate");
    protected By btnProcessInvoice = By.id("processInvoice");
    protected By errorMessage = By.id("errorMessage");
    protected By btnSaveInvoice = By.id("saveInvoice");
    protected By systemLogs = By.id("systemLogs");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToBillingDocumentModule() {
        waitUntilElementVisible(billingModuleLink, 3);
        clickElement(billingModuleLink);
    }

    public void selectBillingDocumentType(String billingDocumentType) {
        waitUntilElementVisible(billingDocumentTypeDropdown, 3);
        selectByValue(billingDocumentTypeDropdown, billingDocumentType);
    }

    public void enterInvoiceDetails(String externalParentDistrDebitMemoDate) {
        waitUntilElementVisible(externalParentDistrDebitMemoDateField, 3);
        enterText(externalParentDistrDebitMemoDateField, externalParentDistrDebitMemoDate);
    }

    public void processInvoice() {
        waitUntilElementVisible(btnProcessInvoice, 3);
        clickElement(btnProcessInvoice);
    }

    public void verifyInvoiceProcessingPrevention() {
        Assert.assertTrue(isElementVisible(errorMessage), "Invoice processing was not prevented.");
    }

    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyErrorMessageGuidance() {
        Assert.assertTrue(getTextFromElement(errorMessage).contains("guidance"), "Error message does not provide guidance.");
    }

    public void attemptToSaveInvoice() {
        waitUntilElementVisible(btnSaveInvoice, 3);
        clickElement(btnSaveInvoice);
    }

    public void verifyInvoiceSavingPrevention() {
        Assert.assertTrue(isElementVisible(errorMessage), "Invoice saving was not prevented.");
    }

    public void verifySystemLogsForError() {
        Assert.assertTrue(getTextFromElement(systemLogs).contains("error"), "System logs do not include error entries.");
    }

    public void verifyNoInvalidInvoicesCreated() {
        Assert.assertFalse(isElementVisible(By.id("invalidInvoice")), "Invalid invoices were created.");
    }

    public void populateFieldAndReprocessInvoice(String validDate) {
        enterText(externalParentDistrDebitMemoDateField, validDate);
        processInvoice();
    }

    public void verifyInvoiceProcessedSuccessfully() {
        Assert.assertTrue(isElementVisible(By.id("successMessage")), "Invoice was not processed successfully.");
    }

    public void encounterErrorDueToMissingField() {
        Assert.assertTrue(isElementVisible(errorMessage), "Error due to missing field was not encountered.");
    }

    public void documentErrorMessageAndBehavior() {
        String errorDetails = getTextFromElement(errorMessage);
        logInfo("Documenting error: " + errorDetails);
    }
}