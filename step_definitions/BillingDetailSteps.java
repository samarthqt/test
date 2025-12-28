package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.pageobjects.BillingDetailPage;
import com.framework.cucumber.TestHarness;

public class BillingDetailSteps {

    private BillingDetailPage billingDetailPage = new BillingDetailPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has logged into the SAP S/4HANA system with valid credentials")
    public void theUserHasLoggedIntoTheSAPSystemWithValidCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        billingDetailPage.loginToSAP(username, password);
    }

    @Given("the user is logged into the SAP S/4HANA system with valid credentials")
    public void theUserIsLoggedIntoTheSAPSystemWithValidCredentials() {
        billingDetailPage.loginToSAPSystem(testHarness.getData("LoginData", "Username"), testHarness.getData("LoginData", "Password"));
    }

    @When("the user navigates to the transaction for creating a Credit Memo Request of type {string}")
    public void theUserNavigatesToTransactionForCreatingCreditMemoRequest(String creditMemoRequestType) {
        billingDetailPage.navigateToTransaction("VA01");
        billingDetailPage.selectCreditMemoRequestType(creditMemoRequestType);
    }

    @When("the user navigates to the transaction for creating a Credit Memo Request of type {credit_memo_type}")
    public void theUserNavigatesToTransactionForCreatingCreditMemoRequest(String creditMemoType) {
        billingDetailPage.navigateToCreditMemoTransaction(creditMemoType);
    }

    @When("the user enters the Billing document number {string} as a reference")
    public void theUserEntersBillingDocumentNumberAsReference(String billingDocumentNumber) {
        billingDetailPage.enterBillingDocumentReference(billingDocumentNumber);
    }

    @When("the user enters the Billing document number {billing_document_number} as a reference")
    public void theUserEntersBillingDocumentNumberAsReference(String billingDocumentNumber) {
        billingDetailPage.enterBillingDocumentReference(billingDocumentNumber);
    }

    @Then("the system accepts the Billing document number and auto-populates the data")
    public void theSystemAcceptsBillingDocumentNumberAndAutoPopulatesData() {
        billingDetailPage.verifyAutoPopulatedData();
    }

    @When("the user saves the Credit Memo Request")
    public void theUserSavesTheCreditMemoRequest() {
        billingDetailPage.saveCreditMemoRequest();
    }

    @When("the user saves the Credit Memo Request")
    public void theUserSavesCreditMemoRequest() {
        billingDetailPage.saveCreditMemoRequest();
    }

    @Then("the system generates the Credit Memo Request with a unique document number")
    public void theSystemGeneratesCreditMemoRequestWithUniqueDocumentNumber() {
        billingDetailPage.verifyGeneratedCreditMemoRequest();
    }

    @Given("the user navigates to the 'display billing detail' report")
    public void theUserNavigatesToDisplayBillingDetailReport() {
        billingDetailPage.navigateToBillingDetailReport();
    }

    @When("the user navigates to the 'display billing detail' report")
    public void theUserNavigatesToDisplayBillingDetailReport() {
        billingDetailPage.navigateToBillingDetailReport();
    }

    @When("the user searches for the Credit Memo Request using the Billing document reference {billing_document_reference}")
    public void theUserSearchesForCreditMemoRequestUsingBillingDocumentReference(String billingDocumentReference) {
        billingDetailPage.searchCreditMemoRequest(billingDocumentReference);
    }

    @When("the user searches for the Credit Memo Request created using the Billing document reference")
    public void theUserSearchesForCreditMemoRequestUsingBillingDocumentReference() {
        billingDetailPage.searchCreditMemoRequest();
    }

    @Then("the search results display the Credit Memo Request")
    public void theSearchResultsDisplayCreditMemoRequest() {
        billingDetailPage.verifySearchResultsDisplayCreditMemoRequest();
    }

    @Then("the system displays the Credit Memo Request in the search results")
    public void theSystemDisplaysCreditMemoRequestInSearchResults() {
        billingDetailPage.verifyCreditMemoRequestDisplayed();
    }

    @Then("the referenced sales orders {referenced_sales_orders} are displayed in the report")
    public void theReferencedSalesOrdersAreDisplayedInReport(String referencedSalesOrders) {
        billingDetailPage.verifyReferencedSalesOrdersInReport(referencedSalesOrders);
    }

    @Then("the referenced sales orders are {string} in the report")
    public void theReferencedSalesOrdersAreInTheReport(String referencedSalesOrders) {
        billingDetailPage.verifyReferencedSalesOrders(referencedSalesOrders);
    }

    @Given("the user reviews the referenced sales orders displayed in the report")
    public void theUserReviewsReferencedSalesOrdersDisplayedInReport() {
        billingDetailPage.reviewReferencedSalesOrdersInReport();
    }

    @When("discrepancies or missing referenced sales orders are identified")
    public void discrepanciesOrMissingReferencedSalesOrdersAreIdentified() {
        billingDetailPage.identifyDiscrepanciesInReferencedSalesOrders();
    }

    @Then("the system highlights the discrepancies or missing referenced sales orders")
    public void theSystemHighlightsDiscrepanciesOrMissingReferencedSalesOrders() {
        billingDetailPage.verifyDiscrepanciesHighlighted();
    }

    @Then("the user analyzes the system logs for errors related to missing or incorrect reference data")
    public void theUserAnalyzesSystemLogsForErrors() {
        billingDetailPage.analyzeSystemLogsForErrors();
    }

    @Then("the system logs contain detailed error messages indicating the discrepancies")
    public void theSystemLogsContainDetailedErrorMessages() {
        billingDetailPage.verifyDetailedErrorMessagesInLogs();
    }

    @Then("the system logs contain {string}")
    public void theSystemLogsContain(String systemLogMessage) {
        billingDetailPage.verifySystemLogs(systemLogMessage);
    }

    @Then("the error messages displayed in the report are clear and indicate the nature of the discrepancies")
    public void theErrorMessagesDisplayedInReportAreClear() {
        billingDetailPage.verifyErrorMessagesInReport();
    }

    @Then("the error messages displayed in the report are {string}")
    public void theErrorMessagesDisplayedInTheReportAre(String errorMessage) {
        billingDetailPage.verifyErrorMessages(errorMessage);
    }

    @Then("the system flags the missing or incorrect data for correction")
    public void theSystemFlagsMissingOrIncorrectDataForCorrection() {
        billingDetailPage.verifySystemFlagsIncorrectData();
    }

    @Then("the system {string}")
    public void theSystemProcessingBehavior(String processingBehavior) {
        billingDetailPage.verifyProcessingBehavior(processingBehavior);
    }

    @Given("the user has completed the test case execution")
    public void theUserHasCompletedTestCaseExecution() {
        billingDetailPage.completeTestCaseExecution();
    }

    @When("the user documents the results of the test case execution")
    public void theUserDocumentsResultsOfTestCaseExecution() {
        billingDetailPage.documentTestCaseResults();
    }

    @Then("the test case results are documented successfully")
    public void theTestCaseResultsAreDocumentedSuccessfully() {
        billingDetailPage.verifyTestCaseResultsDocumented();
    }

    @Then("the user documents the results of the test case execution")
    public void theUserDocumentsResultsOfTestCaseExecution() {
        billingDetailPage.documentTestCaseResults();
    }

    @Then("the user reports the error to the development team for analysis and resolution")
    public void theUserReportsErrorToDevelopmentTeam() {
        billingDetailPage.reportErrorToDevelopmentTeam();
    }
}
