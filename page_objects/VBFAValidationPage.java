package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class VBFAValidationPage extends WebReusableComponents {

    protected By btnCreateInvoice = By.id("createInvoice");
    protected By vbfaTable = By.id("vbfaTable");
    protected By errorMessage = By.id("errorMessage");
    protected By outboundData = By.id("outboundData");
    protected By btnTransmitData = By.id("transmitData");

    public void createS1Invoice() {
        waitUntilElementVisible(btnCreateInvoice, 3);
        clickElement(btnCreateInvoice);
    }

    public void retrieveVBFAValues() {
        waitUntilElementVisible(vbfaTable, 3);
        Assert.assertTrue(isElementPresent(vbfaTable), "VBFA table is not present.");
    }

    public void concatenateExtLinkID() {
        String vbelv = getDataFromTable(vbfaTable, "VBELV");
        String posnv = getDataFromTable(vbfaTable, "POSNV");
        Assert.assertNotNull(vbelv, "VBELV value is missing.");
        Assert.assertNotNull(posnv, "POSNV value is missing.");
        String extLinkID = vbelv + posnv;
        Assert.assertNotNull(extLinkID, "Ext Link ID formation failed.");
    }

    public void logErrorForMissingValue(String missingValue) {
        String error = getTextFromElement(errorMessage);
        Assert.assertTrue(error.contains(missingValue), "Error message does not mention missing value: " + missingValue);
    }

    public void preventExtLinkIDFormation(String missingValue) {
        String vbelv = getDataFromTable(vbfaTable, "VBELV");
        String posnv = getDataFromTable(vbfaTable, "POSNV");
        if (missingValue.equals("VBELV")) {
            Assert.assertNull(vbelv, "VBELV value should be null.");
        } else if (missingValue.equals("POSNV")) {
            Assert.assertNull(posnv, "POSNV value should be null.");
        }
    }

    public void verifyNoIncompleteExtLinkIDInOutboundData() {
        String outboundContent = getTextFromElement(outboundData);
        Assert.assertFalse(outboundContent.contains("Incomplete Ext Link ID"), "Outbound data contains incomplete Ext Link ID.");
    }

    public void transmitDataToModelN() {
        waitUntilElementVisible(btnTransmitData, 3);
        clickElement(btnTransmitData);
    }

    public void preventTransmissionDueToIncompleteExtLinkID() {
        String error = getTextFromElement(errorMessage);
        Assert.assertTrue(error.contains("Incomplete Ext Link ID"), "Transmission error message is missing.");
    }

    public void verifyNoErroneousDataTransmitted() {
        String outboundContent = getTextFromElement(outboundData);
        Assert.assertFalse(outboundContent.contains("Error"), "Erroneous data was transmitted.");
    }

    public void verifyClearAndActionableErrorMessages() {
        String error = getTextFromElement(errorMessage);
        Assert.assertTrue(error.contains("actionable"), "Error message is not clear or actionable.");
    }

    public void createInvoiceWithMissingVBELV() {
        waitUntilElementVisible(btnCreateInvoice, 3);
        clickElement(btnCreateInvoice);
        logErrorForMissingValue("VBELV");
    }

    public void notifyMissingVBELV() {
        String error = getTextFromElement(errorMessage);
        Assert.assertTrue(error.contains("VBELV"), "Missing VBELV notification is not displayed.");
    }

    public void attemptToSaveInvoiceWithMissingVBELV() {
        waitUntilElementVisible(btnCreateInvoice, 3);
        clickElement(btnCreateInvoice);
        logErrorForMissingValue("VBELV");
    }

    public void preventSavingInvoiceWithMissingVBELV() {
        String error = getTextFromElement(errorMessage);
        Assert.assertTrue(error.contains("VBELV"), "Invoice saving was not prevented.");
    }

    public void createInvoiceWithCompleteValues() {
        waitUntilElementVisible(btnCreateInvoice, 3);
        clickElement(btnCreateInvoice);
        Assert.assertTrue(isElementPresent(vbfaTable), "VBFA table is not present.");
    }

    public void repeatExtLinkIDFormationAndTransmission() {
        concatenateExtLinkID();
        transmitDataToModelN();
    }

    public void verifyCorrectExtLinkIDFormationAndTransmission() {
        String outboundContent = getTextFromElement(outboundData);
        Assert.assertTrue(outboundContent.contains("Ext Link ID"), "Correct Ext Link ID was not transmitted.");
    }
}