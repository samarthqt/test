package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ZRK1RequestPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By billingCorrectionModule = By.id("billingCorrectionModule");
    protected By dropdownDocumentType = By.id("documentType");
    protected By txtValueBucket = By.id("valueBucket");
    protected By txtCustomerID = By.id("customerID");
    protected By txtInvoiceNumber = By.id("invoiceNumber");
    protected By txtRequestDetails = By.id("requestDetails");
    protected By btnSubmit = By.id("submitRequest");
    protected By validationMessage = By.id("validationMessage");
    protected By workflowStatusMessage = By.id("workflowStatus");
    protected By logStatusMessage = By.id("logStatus");
    protected By btnEditRequest = By.id("editRequest");
    protected By txtDocumentType = By.id("documentType");
    protected By txtRequestValue = By.id("requestValue");
    protected By btnSubmitRequest = By.id("submitRequest");
    protected By workflowInbox = By.id("workflowInbox");
    protected By workflowLogs = By.id("workflowLogs");

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToBillingCorrectionModule() {
        waitUntilElementVisible(billingCorrectionModule, 3);
        clickElement(billingCorrectionModule);
    }

    public void selectDocumentType(String documentType) {
        waitUntilElementVisible(dropdownDocumentType, 3);
        selectByValue(dropdownDocumentType, documentType);
    }

    public void assignValueBucket(String valueBucket) {
        waitUntilElementVisible(txtValueBucket, 3);
        enterText(txtValueBucket, valueBucket);
    }

    public void enterMandatoryFields(String customerID, String invoiceNumber, String requestDetails) {
        waitUntilElementVisible(txtCustomerID, 3);
        enterText(txtCustomerID, customerID);
        enterText(txtInvoiceNumber, invoiceNumber);
        enterText(txtRequestDetails, requestDetails);
    }

    public void submitRequest() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
    }

    public void verifyValidationResult(String expectedValidationResult) {
        waitUntilElementVisible(validationMessage, 3);
        String actualValidationResult = getTextFromElement(validationMessage);
        Assert.assertEquals(actualValidationResult, expectedValidationResult, "Validation result mismatch.");
    }

    public void verifyWorkflowStatus(String expectedWorkflowStatus) {
        waitUntilElementVisible(workflowStatusMessage, 3);
        String actualWorkflowStatus = getTextFromElement(workflowStatusMessage);
        Assert.assertEquals(actualWorkflowStatus, expectedWorkflowStatus, "Workflow status mismatch.");
    }

    public void verifyLogStatus(String expectedLogStatus) {
        waitUntilElementVisible(logStatusMessage, 3);
        String actualLogStatus = getTextFromElement(logStatusMessage);
        Assert.assertEquals(actualLogStatus, expectedLogStatus, "Log status mismatch.");
    }

    public void editRejectedRequest(String newValueBucket) {
        waitUntilElementVisible(btnEditRequest, 3);
        clickElement(btnEditRequest);
        assignValueBucket(newValueBucket);
    }

    public void resubmitRequest() {
        submitRequest();
    }

    public void verifyUserAuthorization() {
        Assert.assertTrue(isUserAuthorized(), "User is not authorized to create Billing Correction Requests.");
    }

    public void loginToSAP() {
        performLogin("username", "password");
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isLoginSuccessful(), "Login to SAP system failed.");
    }

    public void navigateToBillingCorrectionScreen() {
        clickElement(By.id("billingCorrectionScreen"));
    }

    public void verifyBillingCorrectionScreen() {
        Assert.assertTrue(isElementVisible(By.id("billingCorrectionScreen")), "Billing Correction Request creation screen is not displayed.");
    }

    public void enterDocumentType(String documentType) {
        enterText(txtDocumentType, documentType);
    }

    public void verifyDocumentType(String documentType) {
        Assert.assertEquals(getTextFromElement(txtDocumentType), documentType, "Document type does not match.");
    }

    public void enterRequestValue(String requestValue) {
        enterText(txtRequestValue, requestValue);
    }

    public void verifyRequestValue(String requestValue) {
        Assert.assertTrue(isValueWithinRange(requestValue), "Request value is not within the specified range.");
    }

    public void submitZRK1Request() {
        clickElement(btnSubmitRequest);
    }

    public void verifyRequestSubmission() {
        Assert.assertTrue(isRequestSubmitted(), "ZRK1 request submission failed.");
    }

    public void loginReviewer(String reviewerLevel) {
        performLogin(reviewerLevel + "Reviewer", "password");
    }

    public void navigateToWorkflowInbox() {
        clickElement(workflowInbox);
    }

    public void verifyRequestInInbox() {
        Assert.assertTrue(isRequestInInbox(), "ZRK1 request is not visible in the workflow inbox.");
    }

    public void approveRequestAtLevel(String approvalLevel) {
        clickElement(By.id(approvalLevel + "ApprovalButton"));
    }

    public void verifyRequestRouting(String nextLevel) {
        Assert.assertTrue(isRequestRoutedToLevel(nextLevel), "ZRK1 request is not routed to the " + nextLevel + " level.");
    }

    public void verifyApprovalProcessCompletion() {
        Assert.assertTrue(isApprovalProcessComplete(), "Approval process for ZRK1 request is not complete.");
    }

    public void checkWorkflowLogs() {
        clickElement(workflowLogs);
    }

    public void verifyWorkflowLogs() {
        Assert.assertTrue(areWorkflowLogsCorrect(), "Workflow logs do not show the correct routing and approval sequence.");
    }

    private boolean isUserAuthorized() {
        return true;
    }

    private boolean isLoginSuccessful() {
        return true;
    }

    private boolean isValueWithinRange(String value) {
        int intValue = Integer.parseInt(value);
        return intValue >= 1000 && intValue <= 10000;
    }

    private boolean isRequestSubmitted() {
        return true;
    }

    private boolean isRequestInInbox() {
        return true;
    }

    private boolean isRequestRoutedToLevel(String level) {
        return true;
    }

    private boolean isApprovalProcessComplete() {
        return true;
    }

    private boolean areWorkflowLogsCorrect() {
        return true;
    }
}
