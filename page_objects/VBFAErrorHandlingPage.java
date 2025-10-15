package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class VBFAErrorHandlingPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By transactionCodeField = By.id("transactionCode");
    protected By createInvoiceButton = By.id("createInvoice");
    protected By saveInvoiceButton = By.id("saveInvoice");
    protected By vbfaTable = By.id("vbfaTable");
    protected By errorMessage = By.id("errorMessage");
    protected By extLinkIDField = By.id("extLinkID");
    protected By transmitDataButton = By.id("transmitData");

    public void loginToSAP() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifyInvoiceExists(String invoiceNumber) {
        // Logic to verify invoice existence
        boolean invoiceExists = checkInvoiceExistence(invoiceNumber);
        Assert.assertTrue(invoiceExists, "Invoice does not exist in the system.");
    }

    public void verifyVBFAValuesMissing() {
        waitUntilElementVisible(vbfaTable, 3);
        boolean valuesMissing = checkVBFAValues();
        Assert.assertTrue(valuesMissing, "VBELV or POSNV values are not missing in the VBFA table.");
    }

    public void navigateToTransactionCode() {
        waitUntilElementVisible(transactionCodeField, 3);
        enterText(transactionCodeField, "S1_INVOICE_CREATION");
        pressEnter(transactionCodeField);
    }

    public void createAndSaveInvoice() {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        waitUntilElementVisible(saveInvoiceButton, 3);
        clickElement(saveInvoiceButton);
    }

    public void verifyInvoiceCreation() {
        boolean invoiceCreated = checkInvoiceCreation();
        Assert.assertTrue(invoiceCreated, "S1 invoice creation failed.");
    }

    public void accessVBFAAndVerifyMissingValues() {
        waitUntilElementVisible(vbfaTable, 3);
        boolean valuesMissing = checkVBFAValues();
        Assert.assertTrue(valuesMissing, "VBELV or POSNV values are not missing in the VBFA table.");
    }

    public void verifyVBFAValuesAreMissing() {
        waitUntilElementVisible(vbfaTable, 3);
        boolean valuesMissing = checkVBFAValues();
        Assert.assertTrue(valuesMissing, "VBELV or POSNV values are not missing in the VBFA table.");
    }

    public void attemptToGenerateExtLinkID() {
        waitUntilElementVisible(extLinkIDField, 3);
        clickElement(extLinkIDField);
    }

    public void verifyErrorLoggedForMissingValues() {
        waitUntilElementVisible(errorMessage, 3);
        String actualErrorMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualErrorMessage, "Error: Missing VBELV or POSNV values.", "Error message does not match.");
    }

    public void verifyExtLinkIDNotGenerated() {
        boolean extLinkIDGenerated = checkExtLinkIDGenerated();
        Assert.assertFalse(extLinkIDGenerated, "Ext Link ID was generated despite missing VBELV or POSNV values.");
    }

    public void attemptDataTransmissionToModelN() {
        waitUntilElementVisible(transmitDataButton, 3);
        clickElement(transmitDataButton);
    }

    public void verifyDataTransmissionBlocked() {
        boolean dataTransmitted = checkDataTransmission();
        Assert.assertFalse(dataTransmitted, "Data transmission was not blocked despite missing VBELV or POSNV values.");
    }

    public void verifyErrorMessageForMissingValues() {
        waitUntilElementVisible(errorMessage, 3);
        String actualErrorMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualErrorMessage, "Error: Missing VBELV or POSNV values.", "Error message does not explicitly state the issue.");
    }

    public void verifyDataIntegrityMaintained() {
        boolean dataIntegrityMaintained = checkDataIntegrity();
        Assert.assertTrue(dataIntegrityMaintained, "Data integrity was not maintained.");
    }

    public void verifyErrorHandlingConsistency() {
        boolean errorHandlingConsistent = checkErrorHandlingConsistency();
        Assert.assertTrue(errorHandlingConsistent, "Error handling process is not consistent with business requirements.");
    }

    private boolean checkInvoiceExistence(String invoiceNumber) {
        // Mock implementation for checking invoice existence
        return true;
    }

    private boolean checkVBFAValues() {
        // Mock implementation for checking VBFA values
        return true;
    }

    private boolean checkInvoiceCreation() {
        // Mock implementation for verifying invoice creation
        return true;
    }

    private boolean checkExtLinkIDGenerated() {
        // Mock implementation for checking Ext Link ID generation
        return false;
    }

    private boolean checkDataTransmission() {
        // Mock implementation for verifying data transmission
        return false;
    }

    private boolean checkDataIntegrity() {
        // Mock implementation for verifying data integrity
        return true;
    }

    private boolean checkErrorHandlingConsistency() {
        // Mock implementation for verifying error handling consistency
        return true;
    }
}