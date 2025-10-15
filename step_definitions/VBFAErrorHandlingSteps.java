package com.cucumber.steps;

import com.pageobjects.VBFAErrorHandlingPage;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class VBFAErrorHandlingSteps extends VBFAErrorHandlingPage {

    @Given("the user logs into the SAP S/4 HANA system with valid credentials")
    public void theUserLogsIntoTheSAPSystemWithValidCredentials() {
        loginToSAP();
    }

    @Given("an S1 invoice with number {string} exists in the system")
    public void anS1InvoiceWithNumberExistsInTheSystem(String invoiceNumber) {
        verifyInvoiceExists(invoiceNumber);
    }

    @Given("VBELV and POSNV values are missing in the VBFA table for the invoice")
    public void vbelvAndPosnvValuesAreMissingInTheVBFAForTheInvoice() {
        verifyVBFAValuesMissing();
    }

    @When("the user navigates to the transaction code for creating invoices")
    public void theUserNavigatesToTheTransactionCodeForCreatingInvoices() {
        navigateToTransactionCode();
    }

    @When("the user creates an S1 invoice with the required details and saves it")
    public void theUserCreatesAnS1InvoiceWithTheRequiredDetailsAndSavesIt() {
        createAndSaveInvoice();
    }

    @Then("the S1 invoice is successfully created")
    public void theS1InvoiceIsSuccessfullyCreated() {
        verifyInvoiceCreation();
    }

    @Then("the user accesses the VBFA table to verify the absence of VBELV and POSNV values for the created invoice")
    public void theUserAccessesTheVBFATableToVerifyTheAbsenceOfVBELVAndPOSNVValuesForTheCreatedInvoice() {
        accessVBFAAndVerifyMissingValues();
    }

    @Then("VBFA table shows missing VBELV and POSNV values for the S1 invoice")
    public void vbelvTableShowsMissingVBELVAndPOSNVValuesForTheS1Invoice() {
        verifyVBFAValuesAreMissing();
    }

    @When("the user attempts to generate the Ext Link ID for the S1 invoice")
    public void theUserAttemptsToGenerateTheExtLinkIDForTheS1Invoice() {
        attemptToGenerateExtLinkID();
    }

    @Then("the system logs an error indicating missing VBELV or POSNV values")
    public void theSystemLogsAnErrorIndicatingMissingVBELVOrPOSNVValues() {
        verifyErrorLoggedForMissingValues();
    }

    @Then("the Ext Link ID is not generated")
    public void theExtLinkIDIsNotGenerated() {
        verifyExtLinkIDNotGenerated();
    }

    @When("the user attempts to transmit the invoice data to Model N")
    public void theUserAttemptsToTransmitTheInvoiceDataToModelN() {
        attemptDataTransmissionToModelN();
    }

    @Then("data transmission to Model N is blocked due to missing values")
    public void dataTransmissionToModelNIsBlockedDueToMissingValues() {
        verifyDataTransmissionBlocked();
    }

    @Then("the error message explicitly states the issue with missing VBELV or POSNV values")
    public void theErrorMessageExplicitlyStatesTheIssueWithMissingVBELVOrPOSNVValues() {
        verifyErrorMessageForMissingValues();
    }

    @Then("the system maintains data integrity and does not partially transmit any data")
    public void theSystemMaintainsDataIntegrityAndDoesNotPartiallyTransmitAnyData() {
        verifyDataIntegrityMaintained();
    }

    @Then("the error handling process is consistent with business requirements")
    public void theErrorHandlingProcessIsConsistentWithBusinessRequirements() {
        verifyErrorHandlingConsistency();
    }
}