package com.cucumber.steps;

import com.pageobjects.VBFAValidationPage;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class VBFAValidationSteps extends VBFAValidationPage {

    @Given("the user creates an S1 invoice in the system linked to a direct program")
    public void theUserCreatesAnS1InvoiceInTheSystemLinkedToADirectProgram() {
        createS1Invoice();
    }

    @When("the user attempts to retrieve VBELV and POSNV values from the VBFA table for the created invoice")
    public void theUserAttemptsToRetrieveVBELVAndPOSNVValuesFromTheVBFATableForTheCreatedInvoice() {
        retrieveVBFAValues();
    }

    @When("the user attempts to concatenate VBELV and POSNV values to form the Ext Link ID")
    public void theUserAttemptsToConcatenateVBELVAndPOSNVValuesToFormTheExtLinkID() {
        concatenateExtLinkID();
    }

    @Then("the system logs an error for the missing {string} value")
    public void theSystemLogsAnErrorForTheMissingValue(String missingValue) {
        logErrorForMissingValue(missingValue);
    }

    @Then("the system prevents Ext Link ID formation due to the missing {string} value")
    public void theSystemPreventsExtLinkIDFormationDueToTheMissingValue(String missingValue) {
        preventExtLinkIDFormation(missingValue);
    }

    @Then("the outbound data to Model N does not include an incomplete Ext Link ID")
    public void theOutboundDataToModelNDoesNotIncludeAnIncompleteExtLinkID() {
        verifyNoIncompleteExtLinkIDInOutboundData();
    }

    @When("the user attempts to transmit the data to Model N")
    public void theUserAttemptsToTransmitTheDataToModelN() {
        transmitDataToModelN();
    }

    @Then("the system prevents transmission due to incomplete Ext Link ID")
    public void theSystemPreventsTransmissionDueToIncompleteExtLinkID() {
        preventTransmissionDueToIncompleteExtLinkID();
    }

    @Then("no erroneous data is transmitted to Model N")
    public void noErroneousDataIsTransmittedToModelN() {
        verifyNoErroneousDataTransmitted();
    }

    @Then("the error messages are clear and actionable for the user")
    public void theErrorMessagesAreClearAndActionableForTheUser() {
        verifyClearAndActionableErrorMessages();
    }

    @Given("the user creates an S1 invoice in the system with VBELV value missing")
    public void theUserCreatesAnS1InvoiceInTheSystemWithVBELVValueMissing() {
        createInvoiceWithMissingVBELV();
    }

    @Then("the system notifies the user about the missing VBELV value")
    public void theSystemNotifiesTheUserAboutTheMissingVBELVValue() {
        notifyMissingVBELV();
    }

    @Given("the user attempts to save an invoice with VBELV value missing")
    public void theUserAttemptsToSaveAnInvoiceWithVBELVValueMissing() {
        attemptToSaveInvoiceWithMissingVBELV();
    }

    @Then("the system prevents saving the invoice with the missing VBELV value")
    public void theSystemPreventsSavingTheInvoiceWithTheMissingVBELVValue() {
        preventSavingInvoiceWithMissingVBELV();
    }

    @Given("the user creates a new S1 invoice with complete VBELV and POSNV values")
    public void theUserCreatesANewS1InvoiceWithCompleteVBELVAndPOSNVValues() {
        createInvoiceWithCompleteValues();
    }

    @When("the user repeats the process of forming and transmitting the Ext Link ID")
    public void theUserRepeatsTheProcessOfFormingAndTransmittingTheExtLinkID() {
        repeatExtLinkIDFormationAndTransmission();
    }

    @Then("the Ext Link ID is formed and transmitted correctly for the new invoice")
    public void theExtLinkIDIsFormedAndTransmittedCorrectlyForTheNewInvoice() {
        verifyCorrectExtLinkIDFormationAndTransmission();
    }
}