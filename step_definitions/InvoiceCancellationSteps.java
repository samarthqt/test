package com.cucumber.steps;

import com.pageobjects.InvoiceCancellationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class InvoiceCancellationSteps {

    private InvoiceCancellationPage invoiceCancellationPage = new InvoiceCancellationPage();

    @Given("the user navigates to the invoice cancellation screen {string}")
    public void theUserNavigatesToTheInvoiceCancellationScreen(String screenCode) {
        invoiceCancellationPage.navigateToCancellationScreen(screenCode);
    }

    @When("the user enters the invoice number {string}")
    public void theUserEntersTheInvoiceNumber(String invoiceNumber) {
        invoiceCancellationPage.enterInvoiceNumber(invoiceNumber);
    }

    @When("the user selects the cancellation document type {string}")
    public void theUserSelectsTheCancellationDocumentType(String documentType) {
        invoiceCancellationPage.selectCancellationDocumentType(documentType);
    }

    @When("the user attempts to execute the cancellation process")
    public void theUserAttemptsToExecuteTheCancellationProcess() {
        invoiceCancellationPage.executeCancellationProcess();
    }

    @Then("the system displays the message {string}")
    public void theSystemDisplaysTheMessage(String expectedMessage) {
        invoiceCancellationPage.verifySystemMessage(expectedMessage);
    }

    @Then("no cancellation billing document is created in the system")
    public void noCancellationBillingDocumentIsCreatedInTheSystem() {
        invoiceCancellationPage.verifyNoCancellationDocumentCreated();
    }

    @Then("the system logs capture the error details accurately")
    public void theSystemLogsCaptureTheErrorDetailsAccurately() {
        invoiceCancellationPage.verifyErrorLogs();
    }

    @Then("the system maintains data integrity by preventing invalid cancellations")
    public void theSystemMaintainsDataIntegrityByPreventingInvalidCancellations() {
        invoiceCancellationPage.verifyDataIntegrity();
    }

    @Given("the user navigates to the invoice search screen")
    public void theUserNavigatesToTheInvoiceSearchScreen() {
        invoiceCancellationPage.navigateToSearchScreen();
    }

    @When("the user searches for the invoice number {string}")
    public void theUserSearchesForTheInvoiceNumber(String invoiceNumber) {
        invoiceCancellationPage.searchInvoice(invoiceNumber);
    }

    @Then("the system confirms that the invoice does not exist")
    public void theSystemConfirmsThatTheInvoiceDoesNotExist() {
        invoiceCancellationPage.verifyInvoiceDoesNotExist();
    }

    @Then("the system allows the cancellation process")
    public void theSystemAllowsTheCancellationProcess() {
        invoiceCancellationPage.verifyCancellationProcessAllowed();
    }

    @Then("a cancellation billing document is created in the system")
    public void aCancellationBillingDocumentIsCreatedInTheSystem() {
        invoiceCancellationPage.verifyCancellationDocumentCreated();
    }

    @Given("the user attempts to cancel a non-existent invoice")
    public void theUserAttemptsToCancelANonExistentInvoice() {
        invoiceCancellationPage.attemptToCancelNonExistentInvoice();
    }

    @When("the system prevents the cancellation process")
    public void theSystemPreventsTheCancellationProcess() {
        invoiceCancellationPage.verifyCancellationProcessPrevented();
    }

    @Then("the error handling process aligns with business rules and prevents invalid operations")
    public void theErrorHandlingProcessAlignsWithBusinessRulesAndPreventsInvalidOperations() {
        invoiceCancellationPage.verifyErrorHandlingAlignmentWithBusinessRules();
    }

    @Then("the error handling scenario is documented in audit logs")
    public void theErrorHandlingScenarioIsDocumentedInAuditLogs() {
        invoiceCancellationPage.verifyAuditLogsDocumentation();
    }

    @Given("the user navigates to the VF11 cancellation screen")
    public void theUserNavigatesToTheVF11CancellationScreen() {
        invoiceCancellationPage.navigateToCancellationScreen();
    }

    @When("the user enters the invoice number {string} in the cancellation screen")
    public void theUserEntersTheInvoiceNumberInTheCancellationScreen(String invoiceNumber) {
        invoiceCancellationPage.enterInvoiceNumber(invoiceNumber);
    }

    @When("the user selects the cancellation document type {string}")
    public void theUserSelectsTheCancellationDocumentType(String cancellationDocumentType) {
        invoiceCancellationPage.selectCancellationDocumentType(cancellationDocumentType);
    }

    @When("the user executes the cancellation process")
    public void theUserExecutesTheCancellationProcess() {
        invoiceCancellationPage.executeCancellationProcess();
    }

    @Then("the system processes the cancellation and creates a cancellation billing document")
    public void theSystemProcessesTheCancellationAndCreatesACancellationBillingDocument() {
        invoiceCancellationPage.verifyCancellationBillingDocumentCreated();
    }

    @Then("the cancellation document references the original invoice number {string}")
    public void theCancellationDocumentReferencesTheOriginalInvoiceNumber(String invoiceNumber) {
        invoiceCancellationPage.verifyCancellationDocumentReferencesInvoice(invoiceNumber);
    }

    @Then("the original billing details are reversed accurately")
    public void theOriginalBillingDetailsAreReversedAccurately() {
        invoiceCancellationPage.verifyOriginalBillingDetailsReversed();
    }

    @Then("the cancellation document is linked to the original invoice in the document flow")
    public void theCancellationDocumentIsLinkedToTheOriginalInvoiceInTheDocumentFlow() {
        invoiceCancellationPage.verifyDocumentFlowLinkage();
    }

    @Then("the financial postings reflect the reversal of the original invoice")
    public void theFinancialPostingsReflectTheReversalOfTheOriginalInvoice() {
        invoiceCancellationPage.verifyFinancialPostingsReversal();
    }

    @Then("the system processes maximum line items efficiently without delays or errors")
    public void theSystemProcessesMaximumLineItemsEfficientlyWithoutDelaysOrErrors() {
        invoiceCancellationPage.verifyMaximumLineItemsProcessing();
    }

    @Then("the tax details are reversed accurately for all line items")
    public void theTaxDetailsAreReversedAccuratelyForAllLineItems() {
        invoiceCancellationPage.verifyTaxDetailsReversal();
    }

    @Then("the cancellation document is accessible in reporting and audit logs")
    public void theCancellationDocumentIsAccessibleInReportingAndAuditLogs() {
        invoiceCancellationPage.verifyCancellationDocumentAccessibility();
    }

    @Given("user logs in to the SAP system with valid credentials")
    public void userLogsInToTheSAPSystemWithValidCredentials() {
        invoiceCancellationPage.loginToSAPSystem("validUsername", "validPassword");
    }

    @When("user navigates to the VF11 transaction for invoice cancellation")
    public void userNavigatesToTheVF11TransactionForInvoiceCancellation() {
        invoiceCancellationPage.navigateToVF11Transaction();
    }

    @When("user enters the invoice number {string} in the cancellation screen")
    public void userEntersTheInvoiceNumberInTheCancellationScreen(String invoiceNumber) {
        invoiceCancellationPage.enterInvoiceNumber(invoiceNumber);
    }

    @When("user selects the cancellation document type {string}")
    public void userSelectsTheCancellationDocumentType(String cancellationDocumentType) {
        invoiceCancellationPage.selectCancellationDocumentType(cancellationDocumentType);
    }

    @When("user initiates the cancellation process")
    public void userInitiatesTheCancellationProcess() {
        invoiceCancellationPage.initiateCancellationProcess();
    }

    @Then("system displays an error message {string}")
    public void systemDisplaysAnErrorMessage(String errorMessage) {
        invoiceCancellationPage.verifyErrorMessage(errorMessage);
    }

    @Then("no cancellation billing document is created")
    public void noCancellationBillingDocumentIsCreated() {
        invoiceCancellationPage.verifyNoCancellationBillingDocumentCreated();
    }

    @Then("system logs contain detailed error messages about the non-existent invoice")
    public void systemLogsContainDetailedErrorMessagesAboutTheNonExistentInvoice() {
        invoiceCancellationPage.verifySystemLogsForErrorMessages();
    }

    @Then("user attempts to navigate to the document flow for the invoice")
    public void userAttemptsToNavigateToTheDocumentFlowForTheInvoice() {
        invoiceCancellationPage.navigateToDocumentFlow();
    }

    @Then("system displays an error message {string}")
    public void systemDisplaysAnErrorMessageForDocumentFlow(String documentFlowErrorMessage) {
        invoiceCancellationPage.verifyDocumentFlowErrorMessage(documentFlowErrorMessage);
    }

    @Then("financial postings remain unaffected")
    public void financialPostingsRemainUnaffected() {
        invoiceCancellationPage.verifyFinancialPostingsUnaffected();
    }

    @Given("user is logged into the SAP system")
    public void userIsLoggedIntoTheSAPSystem() {
        invoiceCancellationPage.verifyUserLoggedIn();
    }

    @When("user logs out of the SAP system")
    public void userLogsOutOfTheSAPSystem() {
        invoiceCancellationPage.logoutFromSAPSystem();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        invoiceCancellationPage.verifyLogoutSuccess();
    }
}
