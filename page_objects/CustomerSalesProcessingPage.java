package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CustomerSalesProcessingPage extends WebReusableComponents {

    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By moduleLink = By.id("interfaceProcessingModule");
    protected By uploadButton = By.id("uploadButton");
    protected By fileInput = By.id("fileInput");
    protected By processingTriggerButton = By.id("triggerProcessing");
    protected By salesOrderConfirmation = By.id("salesOrderConfirmation");
    protected By systemLogs = By.id("systemLogs");
    protected By logoutButton = By.id("logoutButton");

    public void verifyUserCredentials(String username, String password) {
        Assert.assertNotNull(username, "Username is null");
        Assert.assertNotNull(password, "Password is null");
    }

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        waitUntilElementVisible(passwordField, 3);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(moduleLink), "Login was not successful");
    }

    public void verifyModuleAccess(String moduleName) {
        Assert.assertTrue(isElementVisible(moduleLink), "Module access not available: " + moduleName);
    }

    public void navigateToModule(String moduleName) {
        clickElement(moduleLink);
    }

    public void verifyModuleDisplayed(String moduleName) {
        Assert.assertTrue(isElementVisible(moduleLink), "Module not displayed: " + moduleName);
    }

    public void verifyInboundFile(String filePath) {
        Assert.assertNotNull(filePath, "Inbound file path is null");
    }

    public void uploadInboundFile(String filePath) {
        waitUntilElementVisible(fileInput, 3);
        enterText(fileInput, filePath);
        clickElement(uploadButton);
    }

    public void verifyFileUploadSuccess() {
        Assert.assertTrue(isElementVisible(uploadButton), "File upload was not successful");
    }

    public void verifyDefaultValuesApplied(String salesDocumentType, String salesArea) {
        Assert.assertEquals(getTextFromElement(By.id("salesDocumentType")), salesDocumentType, "Sales Document Type mismatch");
        Assert.assertEquals(getTextFromElement(By.id("salesArea")), salesArea, "Sales Area mismatch");
    }

    public void verifyMandatoryFields(String fieldName) {
        Assert.assertTrue(isElementVisible(By.id(fieldName)), "Mandatory field not visible: " + fieldName);
    }

    public void verifyMandatoryFieldsPopulated() {
        Assert.assertTrue(isElementVisible(By.id("mandatoryFields")), "Mandatory fields not populated");
    }

    public void triggerInboundProcessing() {
        clickElement(processingTriggerButton);
    }

    public void verifyProcessingTriggered() {
        Assert.assertTrue(isElementVisible(processingTriggerButton), "Processing not triggered");
    }

    public void checkMissingDefaultValues() {
        Assert.assertTrue(isElementVisible(By.id("missingDefaults")), "Missing default values not found");
    }

    public void verifyFieldMapping(String mappingSheet) {
        Assert.assertNotNull(mappingSheet, "Mapping sheet is null");
    }

    public void verifyFieldMappingSuccess() {
        Assert.assertTrue(isElementVisible(By.id("fieldMapping")), "Field mapping not successful");
    }

    public void checkMissingFields() {
        Assert.assertTrue(isElementVisible(By.id("missingFields")), "Missing fields not found");
    }

    public void verifyMissingFieldsLabel() {
        Assert.assertEquals(getTextFromElement(By.id("missingFieldsLabel")), "Not specified in source", "Missing fields label mismatch");
    }

    public void validateZORSalesOrderCreation() {
        Assert.assertTrue(isElementVisible(salesOrderConfirmation), "ZOR sales order not created");
    }

    public void verifyZORSalesOrderCreation() {
        Assert.assertTrue(isElementVisible(salesOrderConfirmation), "ZOR sales order creation not verified");
    }

    public void reviewSystemLogs() {
        Assert.assertTrue(isElementVisible(systemLogs), "System logs not found");
    }

    public void verifyNoErrorsInLogs() {
        Assert.assertTrue(getTextFromElement(systemLogs).contains("No errors"), "Errors found in logs");
    }

    public void documentFindings() {
        Assert.assertTrue(isElementVisible(By.id("findings")), "Findings not documented");
    }

    public void shareFindingsWithTeam() {
        Assert.assertTrue(isElementVisible(By.id("shareFindings")), "Findings not shared with team");
    }

    public void verifyDocumentationComplete() {
        Assert.assertTrue(isElementVisible(By.id("documentationComplete")), "Documentation not complete");
    }

    public void logoutFromSAPSystem() {
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementVisible(By.id("loginButton")), "Logout was not successful");
    }
}