package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.InvoiceProcessingPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class InvoiceProcessingSteps extends InvoiceProcessingPage {

    @Given("the user logs into the SAP S/4 HANA Cloud system with valid credentials")
    public void userLogsIntoSAPSystem() {
        loginToSAPSystem("validUsername", "validPassword");
    }

    @Given("the user navigates to the billing document creation module")
    public void userNavigatesToBillingModule() {
        navigateToBillingDocumentModule();
    }

    @When("the user selects billing document type {BillingDocumentType} for indirect sales cancellations")
    public void userSelectsBillingDocumentType(String billingDocumentType) {
        selectBillingDocumentType(billingDocumentType);
    }

    @When("the user enters invoice details with ExternalParentDistrDebitMemoDate field as {ExternalParentDistrDebitMemoDate}")
    public void userEntersInvoiceDetails(String externalParentDistrDebitMemoDate) {
        enterInvoiceDetails(externalParentDistrDebitMemoDate);
    }

    @When("the user attempts to process the invoice")
    public void userAttemptsToProcessInvoice() {
        processInvoice();
    }

    @Then("the system prevents the processing of the invoice")
    public void systemPreventsInvoiceProcessing() {
        verifyInvoiceProcessingPrevention();
    }

    @Then("the system displays an error message {ErrorMessage}")
    public void systemDisplaysErrorMessage(String errorMessage) {
        verifyErrorMessage(errorMessage);
    }

    @Then("the error message accurately describes the issue and provides guidance for resolution")
    public void errorMessageProvidesGuidance() {
        verifyErrorMessageGuidance();
    }

    @When("the user attempts to save the invoice without processing")
    public void userAttemptsToSaveInvoice() {
        attemptToSaveInvoice();
    }

    @Then("the system prevents saving the invoice due to the missing field")
    public void systemPreventsInvoiceSaving() {
        verifyInvoiceSavingPrevention();
    }

    @Then("the system logs include entries describing the error and action taken")
    public void systemLogsIncludeErrorEntries() {
        verifySystemLogsForError();
    }

    @Then("no invalid invoices are created in the system")
    public void noInvalidInvoicesCreated() {
        verifyNoInvalidInvoicesCreated();
    }

    @When("the user populates the ExternalParentDistrDebitMemoDate field and reprocesses the invoice")
    public void userPopulatesFieldAndReprocessesInvoice() {
        populateFieldAndReprocessInvoice("validDate");
    }

    @Then("the invoice is processed successfully")
    public void invoiceProcessedSuccessfully() {
        verifyInvoiceProcessedSuccessfully();
    }

    @When("the user encounters an error due to missing ExternalParentDistrDebitMemoDate field")
    public void userEncountersErrorDueToMissingField() {
        encounterErrorDueToMissingField();
    }

    @Then("the user documents the error message and system behavior for reporting purposes")
    public void userDocumentsErrorMessageAndBehavior() {
        documentErrorMessageAndBehavior();
    }
}