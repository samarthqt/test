package com.cucumber.steps;

import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.CancellationBillingPage;
import com.framework.cucumber.TestHarness;

public class CancellationBillingSteps {

    private CancellationBillingPage cancellationBillingPage = new CancellationBillingPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        cancellationBillingPage.enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP system")
    public void theUserLogsIntoTheSAPSystem() {
        cancellationBillingPage.loginToSAP();
    }

    @Then("the user is successfully logged in and navigates to the SAP home screen")
    public void theUserIsSuccessfullyLoggedIn() {
        cancellationBillingPage.verifyHomeScreen();
    }

    @Given("the user navigates to the VF11 cancellation screen")
    public void theUserNavigatesToTheVF11CancellationScreen() {
        cancellationBillingPage.navigateToCancellationScreen();
    }

    @When("the user enters the original invoice number {string}")
    public void theUserEntersTheOriginalInvoiceNumber(String invoiceNumber) {
        cancellationBillingPage.enterInvoiceNumber(invoiceNumber);
    }

    @Then("the original invoice details are retrieved and displayed accurately")
    public void theOriginalInvoiceDetailsAreRetrievedAndDisplayedAccurately() {
        cancellationBillingPage.verifyInvoiceDetailsDisplayed();
    }

    @When("the user selects the cancellation document type {string}")
    public void theUserSelectsTheCancellationDocumentType(String cancellationDocumentType) {
        cancellationBillingPage.selectCancellationDocumentType(cancellationDocumentType);
    }

    @Then("the cancellation document type is selected successfully")
    public void theCancellationDocumentTypeIsSelectedSuccessfully() {
        cancellationBillingPage.verifyCancellationDocumentTypeSelected();
    }

    @When("the user executes the cancellation process")
    public void theUserExecutesTheCancellationProcess() {
        cancellationBillingPage.executeCancellationProcess();
    }

    @Then("the system processes the cancellation and creates a cancellation billing document")
    public void theSystemProcessesTheCancellationAndCreatesACancellationBillingDocument() {
        cancellationBillingPage.verifyCancellationBillingDocumentCreated();
    }

    @Then("the cancellation billing document references the original invoice number correctly")
    public void theCancellationBillingDocumentReferencesTheOriginalInvoiceNumberCorrectly() {
        cancellationBillingPage.verifyCancellationDocumentReferencesOriginalInvoice();
    }

    @Then("the original billing details \\(pricing, quantities, taxes, and line items\\) are reversed accurately")
    public void theOriginalBillingDetailsAreReversedAccurately() {
        cancellationBillingPage.verifyBillingDetailsReversed();
    }

    @Then("the cancellation document is linked to the original invoice in the document flow")
    public void theCancellationDocumentIsLinkedToTheOriginalInvoiceInTheDocumentFlow() {
        cancellationBillingPage.verifyDocumentFlowLinkage();
    }

    @Then("the financial postings reflect the reversal of the original invoice accurately")
    public void theFinancialPostingsReflectTheReversalOfTheOriginalInvoiceAccurately() {
        cancellationBillingPage.verifyFinancialPostingsReversal();
    }

    @Then("the cancellation document type matches the configured type {string}")
    public void theCancellationDocumentTypeMatchesTheConfiguredType(String configuredCancellationDocumentType) {
        cancellationBillingPage.verifyCancellationDocumentTypeMatchesConfigured(configuredCancellationDocumentType);
    }

    @Then("the tax reversal details are accurate in the cancellation document")
    public void theTaxReversalDetailsAreAccurateInTheCancellationDocument() {
        cancellationBillingPage.verifyTaxReversalDetails();
    }

    @Then("the cancellation document is accessible in reporting and audit logs")
    public void theCancellationDocumentIsAccessibleInReportingAndAuditLogs() {
        cancellationBillingPage.verifyCancellationDocumentAccessibility();
    }

    @Given("the user is logged into the SAP system with valid credentials")
    public void theUserIsLoggedIntoTheSAPSystemWithValidCredentials() {
        cancellationBillingPage.loginToSAP("validUsername", "validPassword");
    }

    @Given("the user navigates to the VF11 transaction for invoice cancellation")
    public void theUserNavigatesToTheVF11TransactionForInvoiceCancellation() {
        cancellationBillingPage.navigateToTransaction("VF11");
    }

    @Given("the cancellation document type {string} is configured in the system")
    public void theCancellationDocumentTypeIsConfiguredInTheSystem(String cancellationDocumentType) {
        cancellationBillingPage.verifyCancellationDocumentTypeConfigured(cancellationDocumentType);
    }

    @When("the user enters the original invoice number {string} in the cancellation screen")
    public void theUserEntersTheOriginalInvoiceNumberInTheCancellationScreen(String originalInvoiceNumber) {
        cancellationBillingPage.enterInvoiceNumber(originalInvoiceNumber);
    }

    @When("the user selects the cancellation document type as {string}")
    public void theUserSelectsTheCancellationDocumentTypeAs(String cancellationDocumentType) {
        cancellationBillingPage.selectCancellationDocumentType(cancellationDocumentType);
    }

    @When("the user initiates the cancellation process")
    public void theUserInitiatesTheCancellationProcess() {
        cancellationBillingPage.initiateCancellationProcess();
    }

    @Then("a cancellation billing document is created with document type {string}")
    public void aCancellationBillingDocumentIsCreatedWithDocumentType(String cancellationDocumentType) {
        cancellationBillingPage.verifyCancellationBillingDocumentCreated(cancellationDocumentType);
    }

    @Then("the cancellation document references the original invoice number {string}")
    public void theCancellationDocumentReferencesTheOriginalInvoiceNumber(String originalInvoiceNumber) {
        cancellationBillingPage.verifyCancellationDocumentReferencesInvoice(originalInvoiceNumber);
    }

    @Then("all line items in the original invoice are reversed accurately")
    public void allLineItemsInTheOriginalInvoiceAreReversedAccurately() {
        cancellationBillingPage.verifyLineItemsReversedAccurately();
    }

    @Then("the document flow shows proper linkage between the original invoice and the cancellation document")
    public void theDocumentFlowShowsProperLinkageBetweenTheOriginalInvoiceAndTheCancellationDocument() {
        cancellationBillingPage.verifyDocumentFlowLinkage();
    }

    @Then("the system updates the status of the original invoice to \"Cancelled\"")
    public void theSystemUpdatesTheStatusOfTheOriginalInvoiceToCancelled() {
        cancellationBillingPage.verifyInvoiceStatusUpdated("Cancelled");
    }

    @Then("the financial postings for the cancellation document are accurate")
    public void theFinancialPostingsForTheCancellationDocumentAreAccurate() {
        cancellationBillingPage.verifyFinancialPostingsAccuracy();
    }

    @Then("the user logs out of the SAP system successfully")
    public void theUserLogsOutOfTheSAPSystemSuccessfully() {
        cancellationBillingPage.logoutFromSAP();
    }
}
