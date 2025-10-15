package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SystemLogsPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By salesOrderField = By.id("salesOrderNumber");
    protected By billingDocumentTypeField = By.id("billingDocumentType");
    protected By errorMessageField = By.id("errorMessage");
    protected By systemLogsField = By.id("systemLogs");

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifySuccessfulLogin(String expectedMessage) {
        String actualMessage = getTextFromElement(By.id("welcomeMessage"));
        Assert.assertEquals(actualMessage, expectedMessage, "Login was not successful.");
    }

    public void verifySalesOrderExists(String salesOrderNumber) {
        waitUntilElementVisible(salesOrderField, 3);
        Assert.assertTrue(isElementPresent(salesOrderField), "Sales order does not exist.");
    }

    public void verifyFieldPopulated(String fieldName, String expectedValue) {
        By fieldLocator = By.id(fieldName);
        waitUntilElementVisible(fieldLocator, 3);
        String actualValue = getTextFromElement(fieldLocator);
        Assert.assertEquals(actualValue, expectedValue, fieldName + " is not populated correctly.");
    }

    public void verifySalesOrderValidity() {
        Assert.assertTrue(isElementPresent(salesOrderField), "Sales order is not valid.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementPresent(By.id("dashboard")), "User is not logged in.");
    }

    public void navigateToBillingDocumentCreation() {
        clickElement(By.id("billingDocumentTransaction"));
    }

    public void verifyBillingDocumentScreenDisplayed() {
        Assert.assertTrue(isElementPresent(By.id("billingDocumentScreen")), "Billing document creation screen is not displayed.");
    }

    public void setBillingDocumentType(String billingDocumentType) {
        waitUntilElementVisible(billingDocumentTypeField, 3);
        enterText(billingDocumentTypeField, billingDocumentType);
    }

    public void verifyBillingDocumentTypeSet() {
        String actualType = getTextFromElement(billingDocumentTypeField);
        Assert.assertNotNull(actualType, "Billing document type is not set.");
    }

    public void enterSalesOrderNumber(String salesOrderNumber) {
        waitUntilElementVisible(salesOrderField, 3);
        enterText(salesOrderField, salesOrderNumber);
    }

    public void enterBillingDocumentType(String billingDocumentType) {
        waitUntilElementVisible(billingDocumentTypeField, 3);
        enterText(billingDocumentTypeField, billingDocumentType);
    }

    public void verifySalesOrderAndBillingDocumentAccepted() {
        Assert.assertTrue(isElementPresent(salesOrderField) && isElementPresent(billingDocumentTypeField), "Sales order or billing document type is not accepted.");
    }

    public void verifyPartialConfiguration() {
        Assert.assertTrue(isElementPresent(By.id("partialConfiguration")), "System is not partially configured.");
    }

    public void executeCopyControlRoutine() {
        clickElement(By.id("executeRoutine"));
    }

    public void verifyErrorMessageDisplayed(String expectedMessage) {
        String actualMessage = getTextFromElement(errorMessageField);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message is not displayed correctly.");
    }

    public void verifyNoBillingDocumentCreated() {
        Assert.assertFalse(isElementPresent(By.id("billingDocument")), "Billing document is created unexpectedly.");
    }

    public void verifyErrorEncountered() {
        Assert.assertTrue(isElementPresent(errorMessageField), "Error was not encountered.");
    }

    public void checkSystemLogs() {
        clickElement(By.id("viewLogs"));
    }

    public void verifyErrorDetailsInLogs() {
        String logs = getTextFromElement(systemLogsField);
        Assert.assertTrue(logs.contains("incomplete configuration"), "Error details are not present in logs.");
    }

    public void documentConfigurationIssues() {
        enterText(By.id("documentationField"), "Configuration issues documented.");
    }

    public void verifyIssuesRecorded() {
        Assert.assertTrue(isElementPresent(By.id("documentationField")), "Issues are not recorded.");
    }

    public void verifyIssuesDocumented() {
        Assert.assertTrue(isElementPresent(By.id("documentationField")), "Issues are not documented.");
    }

    public void notifyConfigurationTeam() {
        clickElement(By.id("notifyTeam"));
    }

    public void verifyTeamAlertedAndIssueEscalated() {
        Assert.assertTrue(isElementPresent(By.id("teamAlert")), "Team is not alerted.");
    }

    public void verifyConfigurationCorrected() {
        Assert.assertTrue(isElementPresent(By.id("correctedConfiguration")), "Configuration is not corrected.");
    }

    public void retestBillingDocumentCreation() {
        clickElement(By.id("retestBillingDocument"));
    }

    public void verifyBillingDocumentCreated() {
        Assert.assertTrue(isElementPresent(By.id("billingDocument")), "Billing document is not created.");
    }

    public void verifyFieldsCleared() {
        String kunagField = getTextFromElement(By.id("VBRK-KUNAG"));
        String regioField = getTextFromElement(By.id("VBRK-REGIO"));
        Assert.assertTrue(kunagField.isEmpty() && regioField.isEmpty(), "Fields are not cleared.");
    }

    public void verifyErrorLogsCleared() {
        String logs = getTextFromElement(systemLogsField);
        Assert.assertTrue(logs.isEmpty(), "Error logs are not cleared.");
    }

    public void verifySystemFunctionality() {
        Assert.assertTrue(isElementPresent(By.id("systemFunctional")), "System is not functioning as expected.");
    }

    public void updateTestDocumentation() {
        enterText(By.id("testDocumentationField"), "Resolved configuration issue documented.");
    }

    public void verifyIssueDocumented() {
        Assert.assertTrue(isElementPresent(By.id("testDocumentationField")), "Resolved configuration issue is not documented.");
    }

    public void performRegressionTesting() {
        clickElement(By.id("regressionTesting"));
    }

    public void verifyNoModulesAffected() {
        Assert.assertTrue(isElementPresent(By.id("modulesUnaffected")), "Other modules are affected.");
    }
}