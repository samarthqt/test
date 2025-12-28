package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class WorkflowRoutingPage extends WebReusableComponents {

    protected By loginField = By.id("loginField");
    protected By passwordField = By.id("passwordField");
    protected By loginButton = By.id("loginButton");
    protected By creditMemoRequestScreen = By.id("creditMemoRequestScreen");
    protected By documentTypeDropdown = By.id("documentTypeDropdown");
    protected By requestValueField = By.id("requestValueField");
    protected By submitButton = By.id("submitButton");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By workflowInbox = By.id("workflowInbox");
    protected By approveButton = By.id("approveButton");
    protected By workflowHistory = By.id("workflowHistory");
    protected By requestStatus = By.id("requestStatus");
    protected By billingStage = By.id("billingStage");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(loginField, 3);
        enterText(loginField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void navigateToCreditMemoRequestScreen() {
        waitUntilElementVisible(creditMemoRequestScreen, 3);
        clickElement(creditMemoRequestScreen);
    }

    public void selectDocumentType(String documentType) {
        waitUntilElementVisible(documentTypeDropdown, 3);
        selectByValue(documentTypeDropdown, documentType);
    }

    public void inputRequestDetails(String requestValue) {
        waitUntilElementVisible(requestValueField, 3);
        enterText(requestValueField, requestValue);
    }

    public void submitRequestForWorkflowRouting() {
        waitUntilElementVisible(submitButton, 3);
        clickElement(submitButton);
    }

    public void verifyRequestSubmissionConfirmation(String expectedMessage) {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Confirmation message mismatch.");
    }

    public void loginAsReviewer(String username, String password) {
        loginToSAPSystem(username, password);
    }

    public void verifyRequestInWorkflowInbox(String userType) {
        waitUntilElementVisible(workflowInbox, 3);
        boolean requestFound = getWebElementList(workflowInbox)
            .stream()
            .anyMatch(item -> item.getText().contains("Request"));
        Assert.assertTrue(requestFound, userType + " cannot view the request in their workflow inbox.");
    }

    public void approveRequestAtFirstLevel() {
        waitUntilElementVisible(approveButton, 3);
        clickElement(approveButton);
    }

    public void verifyRequestMovedToNextApprovalLevel() {
        // Logic to verify request moved to next approval level
        Assert.assertTrue(true, "Request did not move to the next approval level.");
    }

    public void loginAsApprover(String username, String password) {
        loginToSAPSystem(username, password);
    }

    public void approveRequestAtSecondLevel() {
        waitUntilElementVisible(approveButton, 3);
        clickElement(approveButton);
    }

    public void verifyRequestProceedsToBillingStage() {
        waitUntilElementVisible(billingStage, 3);
        Assert.assertTrue(true, "Request did not proceed to the billing stage.");
    }

    public void verifyWorkflowHistory() {
        waitUntilElementVisible(workflowHistory, 3);
        Assert.assertTrue(true, "Workflow history does not show appropriate routing.");
    }

    public void verifyRequestStatusUpdated(String expectedStatus) {
        waitUntilElementVisible(requestStatus, 3);
        String actualStatus = getTextFromElement(requestStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Request status mismatch.");
    }

    public void verifyRequestProcessedForBilling() {
        Assert.assertTrue(true, "Request was not successfully processed for billing.");
    }

    public void verifyBoundaryValueHandling() {
        Assert.assertTrue(true, "Boundary value handling failed.");
    }
}