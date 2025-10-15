package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class WorkflowValidationPage extends WebReusableComponents {

    protected By sapLoginUsername = By.id("sapUsername");
    protected By sapLoginPassword = By.id("sapPassword");
    protected By sapLoginButton = By.id("loginButton");
    protected By billingCorrectionModuleLink = By.id("billingCorrectionModule");
    protected By documentTypeDropdown = By.id("documentType");
    protected By valueBucketDropdown = By.id("valueBucket");
    protected By submitRequestButton = By.id("submitRequest");
    protected By errorMessageElement = By.id("errorMessage");
    protected By workflowStatusElement = By.id("workflowStatus");
    protected By systemLogsElement = By.id("systemLogs");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(sapLoginUsername, 3);
        enterText(sapLoginUsername, username);
        enterText(sapLoginPassword, password);
        clickElement(sapLoginButton);
    }

    public void navigateToBillingCorrectionModule() {
        waitUntilElementVisible(billingCorrectionModuleLink, 3);
        clickElement(billingCorrectionModuleLink);
    }

    public void createBillingCorrectionRequest(String documentType, String valueBucketStatus) {
        waitUntilElementVisible(documentTypeDropdown, 3);
        selectByValue(documentTypeDropdown, documentType);
        selectByValue(valueBucketDropdown, valueBucketStatus);
    }

    public void submitRequestForWorkflowRouting(String documentType) {
        waitUntilElementVisible(submitRequestButton, 3);
        clickElement(submitRequestButton);
    }

    public void verifyRequestRejection(String documentType, String expectedErrorMessage) {
        waitUntilElementVisible(errorMessageElement, 3);
        String actualErrorMessage = getTextFromElement(errorMessageElement);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch for " + documentType);
    }

    public void verifyNoWorkflowTriggered(String documentType) {
        waitUntilElementVisible(workflowStatusElement, 3);
        String workflowStatus = getTextFromElement(workflowStatusElement);
        Assert.assertEquals(workflowStatus, "No Workflow Triggered", "Workflow triggered unexpectedly for " + documentType);
    }

    public void submitInvalidRequests(String documentType, String valueBucketStatus) {
        createBillingCorrectionRequest(documentType, valueBucketStatus);
        submitRequestForWorkflowRouting(documentType);
    }

    public void checkWorkflowStatus(String documentType) {
        verifyNoWorkflowTriggered(documentType);
    }

    public void reviewSystemLogs() {
        waitUntilElementVisible(systemLogsElement, 3);
        clickElement(systemLogsElement);
    }

    public void verifyErrorDetailsLogged(String documentType) {
        waitUntilElementVisible(systemLogsElement, 3);
        String logs = getTextFromElement(systemLogsElement);
        Assert.assertTrue(logs.contains(documentType), "Error details not logged for " + documentType);
    }

    public void correctValueBucketConfigurations(String documentType) {
        // Dummy implementation for correcting value bucket configurations
    }

    public void resubmitCorrectedRequest(String documentType) {
        submitRequestForWorkflowRouting(documentType);
    }

    public void verifyResubmissionAllowed(String documentType) {
        waitUntilElementVisible(workflowStatusElement, 3);
        String workflowStatus = getTextFromElement(workflowStatusElement);
        Assert.assertEquals(workflowStatus, "Workflow Triggered", "Resubmission not allowed for " + documentType);
    }

    public void verifyWorkflowTriggered(String documentType) {
        waitUntilElementVisible(workflowStatusElement, 3);
        String workflowStatus = getTextFromElement(workflowStatusElement);
        Assert.assertEquals(workflowStatus, "Workflow Triggered", "Workflow not triggered for " + documentType);
    }
}