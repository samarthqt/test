package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.WorkflowValidationPage;
import com.framework.cucumber.TestHarness;

public class WorkflowValidationSteps extends WorkflowValidationPage {

    @Given("the user is logged into the SAP system with authorized credentials")
    public void theUserIsLoggedIntoTheSAPSystemWithAuthorizedCredentials() {
        loginToSAPSystem("authorizedUser", "password123");
    }

    @When("the user navigates to the Billing Correction Request creation module")
    public void theUserNavigatesToTheBillingCorrectionRequestCreationModule() {
        navigateToBillingCorrectionModule();
    }

    @When("the user creates a {string} request with a {string} value bucket")
    public void theUserCreatesARequestWithAValueBucket(String documentType, String valueBucketStatus) {
        createBillingCorrectionRequest(documentType, valueBucketStatus);
    }

    @When("the user submits the {string} request for workflow routing")
    public void theUserSubmitsTheRequestForWorkflowRouting(String documentType) {
        submitRequestForWorkflowRouting(documentType);
    }

    @Then("the system rejects the {string} request and displays an error message {string}")
    public void theSystemRejectsTheRequestAndDisplaysAnErrorMessage(String documentType, String errorMessage) {
        verifyRequestRejection(documentType, errorMessage);
    }

    @Then("no workflow is triggered for the {string} request")
    public void noWorkflowIsTriggeredForTheRequest(String documentType) {
        verifyNoWorkflowTriggered(documentType);
    }

    @Given("the user has submitted ZRK and ZRK1 requests with invalid or missing value buckets")
    public void theUserHasSubmittedZRKAndZRK1RequestsWithInvalidOrMissingValueBuckets() {
        submitInvalidRequests("ZRK", "missing");
        submitInvalidRequests("ZRK1", "invalid");
    }

    @When("the user checks the workflow status for both requests")
    public void theUserChecksTheWorkflowStatusForBothRequests() {
        checkWorkflowStatus("ZRK");
        checkWorkflowStatus("ZRK1");
    }

    @Then("no workflows are triggered for either request")
    public void noWorkflowsAreTriggeredForEitherRequest() {
        verifyNoWorkflowTriggered("ZRK");
        verifyNoWorkflowTriggered("ZRK1");
    }

    @When("the user reviews the system logs")
    public void theUserReviewsTheSystemLogs() {
        reviewSystemLogs();
    }

    @Then("error details for both requests are logged in the system")
    public void errorDetailsForBothRequestsAreLoggedInTheSystem() {
        verifyErrorDetailsLogged("ZRK");
        verifyErrorDetailsLogged("ZRK1");
    }

    @Given("the user has corrected the value bucket configurations for {string} requests")
    public void theUserHasCorrectedTheValueBucketConfigurationsForRequests(String documentType) {
        correctValueBucketConfigurations(documentType);
    }

    @When("the user resubmits the corrected {string} request")
    public void theUserResubmitsTheCorrectedRequest(String documentType) {
        resubmitCorrectedRequest(documentType);
    }

    @Then("the system allows resubmission of the corrected {string} request")
    public void theSystemAllowsResubmissionOfTheCorrectedRequest(String documentType) {
        verifyResubmissionAllowed(documentType);
    }

    @Then("workflows are triggered as per the configured rules for the corrected {string} request")
    public void workflowsAreTriggeredAsPerTheConfiguredRulesForTheCorrectedRequest(String documentType) {
        verifyWorkflowTriggered(documentType);
    }
}