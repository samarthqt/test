package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.ZL2CDocumentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ZL2CDocumentSteps extends ZL2CDocumentPage {

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        verifyUserCredentials();
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        loginToSAPSystem();
    }

    @Then("the user is successfully logged in and has access to the Finance module")
    public void theUserHasAccessToFinanceModule() {
        verifyFinanceModuleAccess();
    }

    @Given("the user navigates to the transaction for creating billing correction requests")
    public void theUserNavigatesToTransaction() {
        navigateToBillingCorrectionTransaction();
    }

    @When("the user enters the billing correction request type as {string}")
    public void theUserEntersBillingCorrectionRequestType(String requestType) {
        enterBillingCorrectionRequestType(requestType);
    }

    @When("the user links the billing correction request to an existing billing document with {int} line items")
    public void theUserLinksBillingCorrectionRequest(int lineItems) {
        linkBillingCorrectionRequest(lineItems);
    }

    @When("the user saves the billing correction request")
    public void theUserSavesBillingCorrectionRequest() {
        saveBillingCorrectionRequest();
    }

    @When("the user generates the corresponding {string} billing document")
    public void theUserGeneratesBillingDocument(String documentType) {
        generateBillingDocument(documentType);
    }

    @Then("the {string} billing document is generated successfully")
    public void theBillingDocumentIsGeneratedSuccessfully(String documentType) {
        verifyBillingDocumentGeneration(documentType);
    }

    @Then("the system response time during the document generation process is within acceptable limits")
    public void theSystemResponseTimeIsAcceptable() {
        verifySystemResponseTime();
    }

    @Then("all line items in the {string} document are correctly processed and linked to the original document")
    public void allLineItemsAreCorrectlyProcessed(String documentType) {
        verifyLineItemProcessing(documentType);
    }

    @Given("the user has generated a ZL2C document")
    public void theUserHasGeneratedZL2CDocument() {
        verifyZL2CDocumentGeneration();
    }

    @When("the user validates the document flow")
    public void theUserValidatesDocumentFlow() {
        validateDocumentFlow();
    }

    @Then("the document flow shows correct linkage between all related documents")
    public void theDocumentFlowShowsCorrectLinkage() {
        verifyDocumentFlowLinkage();
    }

    @Given("the user has completed the ZL2C document generation process")
    public void theUserHasCompletedZL2CGeneration() {
        verifyZL2CGenerationCompletion();
    }

    @When("the user checks the system logs")
    public void theUserChecksSystemLogs() {
        checkSystemLogs();
    }

    @Then("no errors or warnings are logged during the process")
    public void noErrorsOrWarningsInLogs() {
        verifyNoErrorsInLogs();
    }

    @When("the user verifies the financial postings for the ZL2C document")
    public void theUserVerifiesFinancialPostings() {
        verifyFinancialPostings();
    }

    @Then("the financial postings are accurate and reflect the corrections made")
    public void theFinancialPostingsAreAccurate() {
        verifyAccurateFinancialPostings();
    }

    @When("the user reviews the system performance metrics such as CPU usage and memory consumption")
    public void theUserReviewsSystemPerformanceMetrics() {
        reviewSystemPerformanceMetrics();
    }

    @Then("the system performance metrics are within acceptable thresholds")
    public void theSystemPerformanceMetricsAreAcceptable() {
        verifySystemPerformanceMetrics();
    }
}