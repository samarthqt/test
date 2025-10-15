package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SAPWorkflowPage extends WebReusableComponents {

    // Common Locators
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By workflowModule = By.id("workflowModule");
    protected By searchBox = By.id("searchBox");
    protected By searchResult = By.id("searchResult");
    protected By reviewerSubstitutes = By.cssSelector(".reviewer-substitute");
    protected By approverSubstitutes = By.cssSelector(".approver-substitute");
    protected By workflowStatus = By.id("workflowStatus");
    protected By notificationMessage = By.id("notificationMessage");
    protected By workflowLogs = By.id("workflowLogs");
    protected By btnLogout = By.id("logoutButton");
    protected By periodicBillingSection = By.id("periodicBillingSection");
    protected By batchSelection = By.id("batchSelection");
    protected By errorMessage = By.id("errorMessage");
    protected By systemLogs = By.id("systemLogs");
    protected By auditLogs = By.id("auditLogs");
    protected By emailRoutingProcess = By.id("emailRoutingProcess");

    // Methods from Input Classes
    public void loginAsAdmin() {
        enterText(txtUsername, "admin");
        enterText(txtPassword, "admin123");
    }

    public void loginToSAP() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifySuccessfulLogin() {
        Assert.assertTrue(isElementDisplayed(workflowModule), "Login failed. Workflow module not visible.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementDisplayed(workflowModule), "User is not logged in.");
    }

    public void navigateToWorkflowManagement() {
        waitUntilElementVisible(workflowModule, 3);
        clickElement(workflowModule);
    }

    public void verifyActiveWorkflowsDisplayed() {
        Assert.assertTrue(isElementDisplayed(workflowStatus), "Active workflows are not displayed.");
    }

    public void verifyInWorkflowManagementModule() {
        Assert.assertTrue(isElementDisplayed(workflowModule), "User is not in the workflow management module.");
    }

    public void searchBillingCorrectionRequest(String requestId) {
        waitUntilElementVisible(searchBox, 3);
        enterText(searchBox, requestId);
        pressEnter(searchBox);
    }

    public void verifyBillingCorrectionRequestDetails(String requestId) {
        waitUntilElementVisible(searchResult, 3);
        Assert.assertTrue(getTextFromElement(searchResult).contains(requestId), "Billing Correction Request details not displayed.");
    }

    public void verifyReviewerSubstitutesAvailable() {
        Assert.assertTrue(isElementDisplayed(reviewerSubstitutes), "Reviewer substitutes are not available.");
    }

    public void markReviewerSubstitutesUnavailable() {
        getWebElementList(reviewerSubstitutes).forEach(substitute -> clickElement(substitute));
    }

    public void verifyReviewerSubstitutesStatusUpdated() {
        Assert.assertTrue(getWebElementList(reviewerSubstitutes).stream().allMatch(sub -> !sub.isDisplayed()), "Reviewer substitutes status not updated.");
    }

    public void verifyApproverSubstitutesAvailable() {
        Assert.assertTrue(isElementDisplayed(approverSubstitutes), "Approver substitutes are not available.");
    }

    public void markApproverSubstitutesUnavailable() {
        getWebElementList(approverSubstitutes).forEach(substitute -> clickElement(substitute));
    }

    public void verifyApproverSubstitutesStatusUpdated() {
        Assert.assertTrue(getWebElementList(approverSubstitutes).stream().allMatch(sub -> !sub.isDisplayed()), "Approver substitutes status not updated.");
    }

    public void verifyAllSubstitutesUnavailable() {
        verifyReviewerSubstitutesStatusUpdated();
        verifyApproverSubstitutesStatusUpdated();
    }

    public void verifySystemResponse() {
        Assert.assertTrue(isElementDisplayed(notificationMessage), "System response not displayed.");
    }

    public void verifyErrorForNoAvailableSubstitutes() {
        Assert.assertEquals(getTextFromElement(notificationMessage), "No available substitutes for the roles.", "Error message not displayed correctly.");
    }

    public void checkWorkflowProgression() {
        // Simulate checking workflow progression
    }

    public void verifyWorkflowHalted() {
        Assert.assertTrue(getTextFromElement(workflowStatus).contains("Halted"), "Workflow did not halt as expected.");
    }

    public void verifySystemNotifications() {
        Assert.assertTrue(isElementDisplayed(notificationMessage), "System notifications not displayed.");
    }

    public void verifyAdminNotification() {
        Assert.assertEquals(getTextFromElement(notificationMessage), "All substitutes are unavailable.", "Admin notification not received.");
    }

    public void checkWorkflowLogs() {
        waitUntilElementVisible(workflowLogs, 3);
    }

    public void verifyWorkflowLogsDetails() {
        Assert.assertTrue(getTextFromElement(workflowLogs).contains("unavailability of all substitutes"), "Workflow logs do not contain error details.");
    }

    public void verifyReviewerSubstitutesUnavailable() {
        Assert.assertTrue(getWebElementList(reviewerSubstitutes).stream().allMatch(sub -> !sub.isDisplayed()), "Reviewer substitutes are still available.");
    }

    public void manuallyAssignReviewerSubstitute() {
        // Simulate manual assignment of a new substitute for Reviewer role
    }

    public void verifyManualAssignmentForReviewer() {
        Assert.assertTrue(isElementDisplayed(reviewerSubstitutes), "Manual assignment for Reviewer role failed.");
    }

    public void verifyApproverSubstitutesUnavailable() {
        Assert.assertTrue(getWebElementList(approverSubstitutes).stream().allMatch(sub -> !sub.isDisplayed()), "Approver substitutes are still available.");
    }

    public void manuallyAssignApproverSubstitute() {
        // Simulate manual assignment of a new substitute for Approver role
    }

    public void verifyManualAssignmentForApprover() {
        Assert.assertTrue(isElementDisplayed(approverSubstitutes), "Manual assignment for Approver role failed.");
    }

    public void logoutFromSAP() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifySuccessfulLogout() {
        Assert.assertFalse(isElementDisplayed(workflowModule), "Logout failed. User is still logged in.");
    }

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(periodicBillingSection), "Login failed or periodic billing section not accessible.");
    }

    public void navigateToPeriodicBillingSection() {
        waitUntilElementVisible(periodicBillingSection, 3);
        clickElement(periodicBillingSection);
    }

    public void verifyPeriodicBillingSectionDisplayed() {
        Assert.assertTrue(isElementVisible(periodicBillingSection), "Periodic billing section is not displayed.");
    }

    public void verifyBatchAvailability() {
        Assert.assertTrue(isElementVisible(batchSelection), "Batch of ZFR documents is not available.");
    }

    public void selectBatchForProcessing() {
        waitUntilElementVisible(batchSelection, 3);
        clickElement(batchSelection);
    }

    public void verifyBatchSelection() {
        Assert.assertTrue(isElementVisible(batchSelection), "Batch of ZFR documents is not successfully selected.");
    }

    public void triggerWorkflowWithoutZPB1Configuration() {
        clickElement(batchSelection);
    }

    public void verifyErrorMessageDisplayed(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyWorkflowNotProceeded() {
        Assert.assertFalse(isElementVisible(periodicBillingSection), "Workflow proceeded unexpectedly.");
    }

    public void verifyNoOutputsGenerated() {
        Assert.assertFalse(isElementVisible(By.id("ZPB1Output")), "ZPB1 outputs were generated unexpectedly.");
    }

    public void checkSystemLogsForErrorDetails() {
        waitUntilElementVisible(systemLogs, 3);
        clickElement(systemLogs);
    }

    public void verifyErrorDetailsInLogs(String expectedDetails) {
        String actualDetails = getTextFromElement(systemLogs);
        Assert.assertTrue(actualDetails.contains(expectedDetails), "Error details not found in system logs.");
    }

    public void reconfigureZPB1OutputType() {
        // Logic to reconfigure ZPB1 output type
    }

    public void retryWorkflow() {
        // Logic to retry workflow
    }

    public void verifyWorkflowProceeded() {
        Assert.assertTrue(isElementVisible(By.id("workflowSuccess")), "Workflow did not proceed successfully.");
    }

    public void verifyOutputsGenerated() {
        Assert.assertTrue(isElementVisible(By.id("ZPB1Output")), "ZPB1 outputs were not generated.");
    }

    public void reviewSystemOutput() {
        // Logic to review system output
    }

    public void monitorSystemBehavior() {
        // Logic to monitor system behavior
    }

    public void verifySystemStability() {
        Assert.assertTrue(isElementVisible(By.id("systemStable")), "System is not stable.");
    }

    public void reviewErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        getTextFromElement(errorMessage);
    }

    public void verifyErrorMessageClarity(String expectedInstructions) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertTrue(actualMessage.contains(expectedInstructions), "Error message does not provide clear instructions.");
    }

    public void checkAuditLogs() {
        waitUntilElementVisible(auditLogs, 3);
        clickElement(auditLogs);
    }

    public void verifyNoUnauthorizedChangesInLogs() {
        String auditLogDetails = getTextFromElement(auditLogs);
        Assert.assertFalse(auditLogDetails.contains("unauthorized"), "Unauthorized changes found in audit logs.");
    }

    public void reviewEmailRoutingProcess() {
        waitUntilElementVisible(emailRoutingProcess, 3);
        getTextFromElement(emailRoutingProcess);
    }

    public void verifyEmailRoutingNotTriggered() {
        Assert.assertFalse(isElementVisible(emailRoutingProcess), "Email routing process was triggered unexpectedly.");
    }
}
