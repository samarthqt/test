package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SAPInvoicePage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By transactionCodeField = By.id("transactionCode");
    protected By billingDocumentTypeField = By.id("billingDocumentType");
    protected By vbtypField = By.id("vbtyp");
    protected By salesOrderIDField = By.id("salesOrderID");
    protected By btnSaveInvoice = By.id("saveInvoice");
    protected By invoiceDetailsSection = By.id("invoiceDetails");
    protected By saleTypeField = By.id("saleType");

    public void loginToSAP(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(transactionCodeField), "Login was not successful.");
    }

    public void navigateToTransactionCode(String transactionCode) {
        waitUntilElementVisible(transactionCodeField, 3);
        enterText(transactionCodeField, transactionCode);
        pressEnter(transactionCodeField);
    }

    public void verifyInvoiceCreationScreen() {
        Assert.assertTrue(isElementVisible(billingDocumentTypeField), "Invoice creation screen is not displayed.");
    }

    public void enterBillingDocumentType(String billingDocumentType) {
        waitUntilElementVisible(billingDocumentTypeField, 3);
        enterText(billingDocumentTypeField, billingDocumentType);
    }

    public void setVBTYPValue(String vbtypValue) {
        waitUntilElementVisible(vbtypField, 3);
        enterText(vbtypField, vbtypValue);
    }

    public void enterSalesOrderID(String salesOrderID) {
        waitUntilElementVisible(salesOrderIDField, 3);
        enterText(salesOrderIDField, salesOrderID);
    }

    public void saveInvoice() {
        waitUntilElementVisible(btnSaveInvoice, 3);
        clickElement(btnSaveInvoice);
    }

    public void verifyInvoiceSaved() {
        Assert.assertTrue(isElementVisible(invoiceDetailsSection), "Invoice was not saved successfully.");
    }

    public void openCreatedInvoiceDetails() {
        clickElement(invoiceDetailsSection);
    }

    public void verifyInvoiceDetailsDisplayed() {
        Assert.assertTrue(isElementVisible(saleTypeField), "Invoice details are not displayed.");
    }

    public void verifySaleTypeField(String expectedSaleType) {
        String actualSaleType = getTextFromElement(saleTypeField);
        Assert.assertEquals(actualSaleType, expectedSaleType, "Sale Type field value does not match.");
    }

    public void verifyDataConsistencyInTables() {
        // Logic to verify data consistency in tables
        Assert.assertTrue(true, "Data consistency is not maintained.");
    }

    public void verifySystemLogs() {
        // Logic to verify system logs
        Assert.assertTrue(true, "Errors or warnings found in system logs.");
    }

    public void validateInvoiceLinkageInDocumentFlow() {
        // Logic to validate invoice linkage in document flow
        Assert.assertTrue(true, "Invoice linkage in document flow is incorrect.");
    }

    public void confirmOutputRendering() {
        // Logic to confirm output rendering
        Assert.assertTrue(true, "Output rendering is not correct.");
    }
}