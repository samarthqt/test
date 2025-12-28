package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.ReviewerManagementPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ReviewerManagementSteps extends ReviewerManagementPage {

    @Given("the administrator is logged into the SAP system")
    public void theAdministratorIsLoggedIntoTheSAPSystem() {
        loginToSAPSystem("admin", "password123");
    }

    @When("the administrator marks a designated Reviewer as unavailable for a specific period")
    public void theAdministratorMarksAReviewerAsUnavailable() {
        markReviewerUnavailable("Reviewer1", "2023-10-01", "2023-10-15");
    }

    @Then("the Reviewer is successfully marked as unavailable in the system")
    public void theReviewerIsSuccessfullyMarkedAsUnavailable() {
        verifyReviewerUnavailable("Reviewer1");
    }

    @Given("the user is logged into the system and accesses the Billing Correction Request creation screen")
    public void theUserAccessesBillingCorrectionRequestScreen() {
        loginToSystem("user", "password123");
        navigateToBillingCorrectionRequestScreen();
    }

    @When("the user creates and submits a ZRK document for workflow routing")
    public void theUserCreatesAndSubmitsAZRKDocument() {
        createAndSubmitZRKDocument("ZRK123");
    }

    @Then("the system flags an error or warning indicating the absence of a configured substitute")
    public void theSystemFlagsAnErrorForNoSubstitute() {
        verifyErrorForNoSubstitute("ZRK123");
    }

    @Then("the workflow does not progress, leaving the request in a pending state")
    public void theWorkflowRemainsPending() {
        verifyWorkflowPendingState("ZRK123");
    }

    @Given("the user has submitted a ZRK document for workflow routing")
    public void theUserHasSubmittedAZRKDocument() {
        createAndSubmitZRKDocument("ZRK123");
    }

    @When("the system identifies an unavailable Reviewer")
    public void theSystemIdentifiesAnUnavailableReviewer() {
        identifyUnavailableReviewer("Reviewer1");
    }

    @Then("the system displays an error or warning message clearly indicating the absence of a substitute")
    public void theSystemDisplaysErrorForUnavailableReviewer() {
        verifyErrorForUnavailableReviewer("Reviewer1");
    }

    @Then("the workflow remains in a pending state")
    public void theWorkflowRemainsInPendingState() {
        verifyWorkflowPendingState("ZRK123");
    }

    @When("the administrator reassigns the Reviewer or configures a substitute")
    public void theAdministratorReassignsReviewer() {
        reassignReviewerOrConfigureSubstitute("Reviewer1", "Reviewer2");
    }

    @Then("the workflow progresses for the ZRK document")
    public void theWorkflowProgressesForZRKDocument() {
        verifyWorkflowProgress("ZRK123");
    }

    @Given("the ZRK document encountered an error due to an unavailable Reviewer")
    public void theZRKDocumentEncounteredAnError() {
        verifyErrorForUnavailableReviewer("Reviewer1");
    }

    @When("the system logs are reviewed")
    public void theSystemLogsAreReviewed() {
        reviewSystemLogs("ZRK123");
    }

    @Then("the logs show the error or warning message and the subsequent resolution")
    public void theLogsShowErrorAndResolution() {
        verifyLogsForErrorAndResolution("ZRK123");
    }

    @Given("there are multiple workflow requests in the system")
    public void thereAreMultipleWorkflowRequests() {
        verifyMultipleWorkflowRequestsExist();
    }

    @When("one Reviewer is unavailable")
    public void oneReviewerIsUnavailable() {
        markReviewerUnavailable("Reviewer1", "2023-10-01", "2023-10-15");
    }

    @Then("other workflow requests are not impacted by the unavailable Reviewer")
    public void otherWorkflowRequestsAreNotImpacted() {
        verifyOtherWorkflowRequestsUnaffected("Reviewer1");
    }

    @Given("the system flagged an error due to an unavailable Reviewer")
    public void theSystemFlaggedAnError() {
        verifyErrorForUnavailableReviewer("Reviewer1");
    }

    @When("findings are documented")
    public void findingsAreDocumented() {
        documentFindings("Error due to unavailable Reviewer");
    }

    @Then("the issue is reported to the workflow configuration team for corrective measures")
    public void theIssueIsReported() {
        reportIssueToWorkflowTeam("Error due to unavailable Reviewer");
    }
}