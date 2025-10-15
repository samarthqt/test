package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.WorkflowRoutingPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class WorkflowRoutingSteps extends WorkflowRoutingPage {

    @Given("the user is logged into the SAP system with authorization to create Billing Correction Requests")
    public void theUserIsLoggedIntoTheSAPSystemWithAuthorizationToCreateBillingCorrectionRequests() {
        loginToSAPSystem("authorizedUser", "password123");
    }

    @Given("the user navigates to the Credit Memo Request creation screen and selects document type {string}")
    public void theUserNavigatesToTheCreditMemoRequestCreationScreenAndSelectsDocumentType(String documentType) {
        navigateToCreditMemoRequestScreen();
        selectDocumentType(documentType);
    }

    @When("the user inputs the request details with a value of {string}")
    public void theUserInputsTheRequestDetailsWithAValueOf(String requestValue) {
        inputRequestDetails(requestValue);
    }

    @When("the user submits the request for workflow routing")
    public void theUserSubmitsTheRequestForWorkflowRouting() {
        submitRequestForWorkflowRouting();
    }

    @Then("the request is successfully submitted, and a confirmation message is displayed")
    public void theRequestIsSuccessfullySubmittedAndAConfirmationMessageIsDisplayed() {
        verifyRequestSubmissionConfirmation("Request successfully submitted.");
    }

    @When("the designated Reviewer for the first approval level logs in")
    public void theDesignatedReviewerForTheFirstApprovalLevelLogsIn() {
        loginAsReviewer("reviewerUser", "password123");
    }

    @Then("the Reviewer is able to view the request in their workflow inbox")
    public void theReviewerIsAbleToViewTheRequestInTheirWorkflowInbox() {
        verifyRequestInWorkflowInbox("Reviewer");
    }

    @When("the Reviewer approves the request at the first approval level")
    public void theReviewerApprovesTheRequestAtTheFirstApprovalLevel() {
        approveRequestAtFirstLevel();
    }

    @Then("the request moves to the next approval level")
    public void theRequestMovesToTheNextApprovalLevel() {
        verifyRequestMovedToNextApprovalLevel();
    }

    @When("the designated Approver for the second approval level logs in")
    public void theDesignatedApproverForTheSecondApprovalLevelLogsIn() {
        loginAsApprover("approverUser", "password123");
    }

    @Then("the Approver is able to view the request in their workflow inbox")
    public void theApproverIsAbleToViewTheRequestInTheirWorkflowInbox() {
        verifyRequestInWorkflowInbox("Approver");
    }

    @When("the Approver approves the request at the second approval level")
    public void theApproverApprovesTheRequestAtTheSecondApprovalLevel() {
        approveRequestAtSecondLevel();
    }

    @Then("the request is fully approved and proceeds to the billing stage")
    public void theRequestIsFullyApprovedAndProceedsToTheBillingStage() {
        verifyRequestProceedsToBillingStage();
    }

    @Then("the workflow history shows the request was routed to the appropriate approval levels")
    public void theWorkflowHistoryShowsTheRequestWasRoutedToTheAppropriateApprovalLevels() {
        verifyWorkflowHistory();
    }

    @Then("the request status is updated as \"Approved\" at each approval level")
    public void theRequestStatusIsUpdatedAsApprovedAtEachApprovalLevel() {
        verifyRequestStatusUpdated("Approved");
    }

    @Then("the request is successfully processed for billing")
    public void theRequestIsSuccessfullyProcessedForBilling() {
        verifyRequestProcessedForBilling();
    }

    @Then("the system consistently handles the boundary value across different scenarios")
    public void theSystemConsistentlyHandlesTheBoundaryValueAcrossDifferentScenarios() {
        verifyBoundaryValueHandling();
    }
}