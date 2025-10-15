package com.cucumber.steps;

import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.SAPWorkflowPage;
import com.framework.cucumber.TestHarness;

public class SAPWorkflowSteps {

    private SAPWorkflowPage sapWorkflowPage = new SAPWorkflowPage();

    @Given("the user has administrative credentials")
    public void theUserHasAdministrativeCredentials() {
        sapWorkflowPage.loginAsAdmin();
    }

    @When("the user logs into the SAP system")
    public void theUserLogsIntoTheSAPSystem() {
        sapWorkflowPage.loginToSAP();
    }

    @Then("the user should successfully access the system")
    public void theUserShouldSuccessfullyAccessTheSystem() {
        sapWorkflowPage.verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        sapWorkflowPage.verifyUserLoggedIn();
    }

    @When("the user navigates to the workflow management module")
    public void theUserNavigatesToTheWorkflowManagementModule() {
        sapWorkflowPage.navigateToWorkflowManagement();
    }

    @Then("the workflow management module should display active workflows")
    public void theWorkflowManagementModuleShouldDisplayActiveWorkflows() {
        sapWorkflowPage.verifyActiveWorkflowsDisplayed();
    }

    @Given("the user is in the workflow management module")
    public void theUserIsInTheWorkflowManagementModule() {
        sapWorkflowPage.verifyInWorkflowManagementModule();
    }

    @When("the user searches for Billing Correction Request ID {string}")
    public void theUserSearchesForBillingCorrectionRequestID(String requestId) {
        sapWorkflowPage.searchBillingCorrectionRequest(requestId);
    }

    @Then("the details of Billing Correction Request ID {string} should be displayed")
    public void theDetailsOfBillingCorrectionRequestIDShouldBeDisplayed(String requestId) {
        sapWorkflowPage.verifyBillingCorrectionRequestDetails(requestId);
    }

    @Given("all substitutes for the Reviewer role are available")
    public void allSubstitutesForTheReviewerRoleAreAvailable() {
        sapWorkflowPage.verifyReviewerSubstitutesAvailable();
    }

    @When("the user marks all substitutes for the Reviewer role as unavailable")
    public void theUserMarksAllSubstitutesForTheReviewerRoleAsUnavailable() {
        sapWorkflowPage.markReviewerSubstitutesUnavailable();
    }

    @Then("the system should update the status of all Reviewer substitutes to unavailable")
    public void theSystemShouldUpdateTheStatusOfAllReviewerSubstitutesToUnavailable() {
        sapWorkflowPage.verifyReviewerSubstitutesStatusUpdated();
    }

    @Given("all substitutes for the Approver role are available")
    public void allSubstitutesForTheApproverRoleAreAvailable() {
        sapWorkflowPage.verifyApproverSubstitutesAvailable();
    }

    @When("the user marks all substitutes for the Approver role as unavailable")
    public void theUserMarksAllSubstitutesForTheApproverRoleAsUnavailable() {
        sapWorkflowPage.markApproverSubstitutesUnavailable();
    }

    @Then("the system should update the status of all Approver substitutes to unavailable")
    public void theSystemShouldUpdateTheStatusOfAllApproverSubstitutesToUnavailable() {
        sapWorkflowPage.verifyApproverSubstitutesStatusUpdated();
    }

    @Given("all substitutes for Reviewer and Approver roles are marked as unavailable")
    public void allSubstitutesForReviewerAndApproverRolesAreMarkedAsUnavailable() {
        sapWorkflowPage.verifyAllSubstitutesUnavailable();
    }

    @When("the user verifies the system's response")
    public void theUserVerifiesTheSystemResponse() {
        sapWorkflowPage.verifySystemResponse();
    }

    @Then("the system should flag an error indicating no available substitutes for the roles")
    public void theSystemShouldFlagAnErrorIndicatingNoAvailableSubstitutesForTheRoles() {
        sapWorkflowPage.verifyErrorForNoAvailableSubstitutes();
    }

    @When("the user checks the workflow progression")
    public void theUserChecksTheWorkflowProgression() {
        sapWorkflowPage.checkWorkflowProgression();
    }

    @Then("the workflow should halt and not progress further")
    public void theWorkflowShouldHaltAndNotProgressFurther() {
        sapWorkflowPage.verifyWorkflowHalted();
    }

    @When("the user verifies notifications sent by the system")
    public void theUserVerifiesNotificationsSentByTheSystem() {
        sapWorkflowPage.verifySystemNotifications();
    }

    @Then("the administrator should receive a notification about the unavailability of all substitutes")
    public void theAdministratorShouldReceiveANotificationAboutTheUnavailabilityOfAllSubstitutes() {
        sapWorkflowPage.verifyAdminNotification();
    }

    @When("the user checks the workflow logs")
    public void theUserChecksTheWorkflowLogs() {
        sapWorkflowPage.checkWorkflowLogs();
    }

    @Then("the logs should contain detailed information about the unavailability of all substitutes")
    public void theLogsShouldContainDetailedInformationAboutTheUnavailabilityOfAllSubstitutes() {
        sapWorkflowPage.verifyWorkflowLogsDetails();
    }

    @When("the user attempts to manually assign a new substitute for the Reviewer role")
    public void theUserAttemptsToManuallyAssignANewSubstituteForTheReviewerRole() {
        sapWorkflowPage.manuallyAssignReviewerSubstitute();
    }

    @Then("the system should allow manual assignment of a new substitute for the Reviewer role")
    public void theSystemShouldAllowManualAssignmentOfANewSubstituteForTheReviewerRole() {
        sapWorkflowPage.verifyManualAssignmentForReviewer();
    }

    @When("the user attempts to manually assign a new substitute for the Approver role")
    public void theUserAttemptsToManuallyAssignANewSubstituteForTheApproverRole() {
        sapWorkflowPage.manuallyAssignApproverSubstitute();
    }

    @Then("the system should allow manual assignment of a new substitute for the Approver role")
    public void theSystemShouldAllowManualAssignmentOfANewSubstituteForTheApproverRole() {
        sapWorkflowPage.verifyManualAssignmentForApprover();
    }

    @When("the user logs out of the system")
    public void theUserLogsOutOfTheSystem() {
        sapWorkflowPage.logoutFromSAP();
    }

    @Then("the user should successfully log out")
    public void theUserShouldSuccessfullyLogOut() {
        sapWorkflowPage.verifySuccessfulLogout();
    }

    @When("the user navigates to the periodic billing section")
    public void theUserNavigatesToThePeriodicBillingSection() {
        sapWorkflowPage.navigateToPeriodicBillingSection();
    }

    @Then("the periodic billing section is displayed")
    public void thePeriodicBillingSectionIsDisplayed() {
        sapWorkflowPage.verifyPeriodicBillingSectionDisplayed();
    }

    @When("the user selects a batch of 1000+ ZFR documents for processing")
    public void theUserSelectsABatchOfZFRDocumentsForProcessing() {
        sapWorkflowPage.selectBatchForProcessing();
    }

    @Then("the batch of ZFR documents is successfully selected")
    public void theBatchOfZFRDocumentsIsSuccessfullySelected() {
        sapWorkflowPage.verifyBatchSelection();
    }

    @When("the user attempts to trigger the periodic billing workflow without configuring the ZPB1 output type")
    public void theUserAttemptsToTriggerTheWorkflowWithoutConfiguringZPB1OutputType() {
        sapWorkflowPage.triggerWorkflowWithoutZPB1Configuration();
    }

    @Then("the system displays an error message indicating that the ZPB1 output type is not configured")
    public void theSystemDisplaysAnErrorMessageIndicatingMissingZPB1Configuration() {
        sapWorkflowPage.verifyErrorMessageDisplayed("ZPB1 output type is not configured");
    }

    @Then("the workflow does not proceed")
    public void theWorkflowDoesNotProceed() {
        sapWorkflowPage.verifyWorkflowNotProceeded();
    }

    @Then("no ZPB1 outputs are generated")
    public void noZPB1OutputsAreGenerated() {
        sapWorkflowPage.verifyNoOutputsGenerated();
    }

    @When("the user reconfigures the ZPB1 output type and retries the workflow")
    public void theUserReconfiguresZPB1OutputTypeAndRetriesWorkflow() {
        sapWorkflowPage.reconfigureZPB1OutputType();
        sapWorkflowPage.retryWorkflow();
    }

    @Then("the workflow proceeds successfully")
    public void theWorkflowProceedsSuccessfully() {
        sapWorkflowPage.verifyWorkflowProceeded();
    }

    @Then("ZPB1 outputs are generated")
    public void ZPB1OutputsAreGenerated() {
        sapWorkflowPage.verifyOutputsGenerated();
    }

    @When("the user monitors the system behavior")
    public void theUserMonitorsSystemBehavior() {
        sapWorkflowPage.monitorSystemBehavior();
    }

    @Then("the system remains stable and does not crash")
    public void theSystemRemainsStableAndDoesNotCrash() {
        sapWorkflowPage.verifySystemStability();
    }
}
