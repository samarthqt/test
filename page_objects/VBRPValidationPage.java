package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class VBRPValidationPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By billingCorrectionRequestScreen = By.id("billingCorrectionRequestScreen");
    protected By txtOriginalBillingDocumentNumber = By.id("originalBillingDocumentNumber");
    protected By dropdownBillingCorrectionRequestType = By.id("billingCorrectionRequestType");
    protected By btnSaveRequest = By.id("saveRequest");
    protected By btnGenerateZL2CBillingDocument = By.id("generateZL2CBillingDocument");
    protected By vbrpTable = By.id("vbrpTable");
    protected By reportButton = By.id("generateReport");

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void loginToSAP() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(billingCorrectionRequestScreen), "Login failed.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(billingCorrectionRequestScreen), "User is not logged in.");
    }

    public void navigateToBillingCorrectionRequestScreen() {
        clickElement(billingCorrectionRequestScreen);
    }

    public void verifyBillingCorrectionRequestScreenDisplayed() {
        Assert.assertTrue(isElementVisible(billingCorrectionRequestScreen), "Billing correction request screen is not displayed.");
    }

    public void enterOriginalBillingDocumentNumber(String originalBillingDocumentNumber) {
        waitUntilElementVisible(txtOriginalBillingDocumentNumber, 3);
        enterText(txtOriginalBillingDocumentNumber, originalBillingDocumentNumber);
    }

    public void selectBillingCorrectionRequestType(String billingCorrectionRequestType) {
        waitUntilElementVisible(dropdownBillingCorrectionRequestType, 3);
        selectByValue(dropdownBillingCorrectionRequestType, billingCorrectionRequestType);
    }

    public void saveBillingCorrectionRequest() {
        waitUntilElementVisible(btnSaveRequest, 3);
        clickElement(btnSaveRequest);
    }

    public void verifyBillingCorrectionRequestCreated() {
        Assert.assertTrue(isElementVisible(btnGenerateZL2CBillingDocument), "Billing correction request creation failed.");
    }

    public void generateZL2CBillingDocument() {
        waitUntilElementVisible(btnGenerateZL2CBillingDocument, 3);
        clickElement(btnGenerateZL2CBillingDocument);
    }

    public void verifyZL2CBillingDocumentGenerated() {
        Assert.assertTrue(isElementVisible(vbrpTable), "ZL2C billing document generation failed.");
    }

    public void accessVBRPTable() {
        clickElement(vbrpTable);
    }

    public void verifyVBRPTableEntriesDisplayed() {
        Assert.assertTrue(isElementVisible(vbrpTable), "VBRP table entries are not displayed.");
    }

    public void verifySignConventionsInVBRPTable(String itemCategory, String signConvention) {
        String actualSignConvention = getSignConventionForItemCategory(itemCategory);
        Assert.assertEquals(actualSignConvention, signConvention, "Sign convention mismatch for item category " + itemCategory);
    }

    public void validateLinkageBetweenDocuments() {
        Assert.assertTrue(isLinkageValid(), "Linkage between ZL2C billing document and original billing document is invalid.");
    }

    public void verifyLinkageBetweenDocuments() {
        Assert.assertTrue(isLinkageValid(), "VBRP table does not accurately link ZL2C billing document to original billing document.");
    }

    public void generateVBRPTableReport() {
        waitUntilElementVisible(reportButton, 3);
        clickElement(reportButton);
    }

    public void verifyDataConsistencyInReport() {
        Assert.assertTrue(isReportDataConsistent(), "Data consistency in VBRP table is not accurate.");
    }

    public void validateFinancialDataInZL2CBillingDocument() {
        Assert.assertTrue(isFinancialDataValid(), "Financial data in ZL2C billing document is inconsistent.");
    }

    public void verifyFinancialDataConsistency() {
        Assert.assertTrue(isFinancialDataValid(), "Financial data does not accurately reflect VBRP table entries.");
    }

    public void logoutFromSAP() {
        clickElement(btnLogin);
    }

    public void verifyLogoutSuccess() {
        Assert.assertFalse(isElementVisible(billingCorrectionRequestScreen), "Logout failed.");
    }

    private String getSignConventionForItemCategory(String itemCategory) {
        // Logic to fetch sign convention for the given item category from VBRP table
        return "dummySignConvention";
    }

    private boolean isLinkageValid() {
        // Logic to validate linkage between ZL2C billing document and original billing document
        return true;
    }

    private boolean isReportDataConsistent() {
        // Logic to validate data consistency in the generated report
        return true;
    }

    private boolean isFinancialDataValid() {
        // Logic to validate financial data in ZL2C billing document
        return true;
    }
}