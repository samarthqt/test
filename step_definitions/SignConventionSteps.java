package com.cucumber.steps;

import com.pageobjects.SignConventionPage;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SignConventionSteps extends SignConventionPage {

    @Given("the user navigates to the Direct Sales processing program {string}")
    public void theUserNavigatesToTheDirectSalesProcessingProgram(String programName) {
        navigateToProgram(programName);
    }

    @Then("the Direct Sales processing program {string} is displayed successfully")
    public void theDirectSalesProcessingProgramIsDisplayedSuccessfully(String programName) {
        verifyProgramDisplayed(programName);
    }

    @Given("the user creates a sales order with billing document type {string}")
    public void theUserCreatesASalesOrderWithBillingDocumentType(String billingDocumentType) {
        createSalesOrder(billingDocumentType);
    }

    @Then("the sales order is created successfully with the specified billing document type")
    public void theSalesOrderIsCreatedSuccessfullyWithTheSpecifiedBillingDocumentType() {
        verifySalesOrderCreated();
    }

    @When("the user processes the sales order")
    public void theUserProcessesTheSalesOrder() {
        processSalesOrder();
    }

    @Then("the system detects the misconfigured sign conventions and logs an error, preventing further processing")
    public void theSystemDetectsTheMisconfiguredSignConventionsAndLogsAnErrorPreventingFurtherProcessing() {
        verifyErrorLoggedAndProcessingPrevented();
    }

    @Given("the user navigates to the Indirect Sales processing program {string}")
    public void theUserNavigatesToTheIndirectSalesProcessingProgram(String programName) {
        navigateToProgram(programName);
    }

    @Then("the Indirect Sales processing program {string} is displayed successfully")
    public void theIndirectSalesProcessingProgramIsDisplayedSuccessfully(String programName) {
        verifyProgramDisplayed(programName);
    }

    @Given("the user processes an indirect sales transaction with billing document type {string}")
    public void theUserProcessesAnIndirectSalesTransactionWithBillingDocumentType(String billingDocumentType) {
        processIndirectSalesTransaction(billingDocumentType);
    }

    @Given("the user checks the error logs for details about the misconfiguration")
    public void theUserChecksTheErrorLogsForDetailsAboutTheMisconfiguration() {
        checkErrorLogs();
    }

    @Then("the error logs contain detailed information about the misconfigured sign conventions for S1 invoices")
    public void theErrorLogsContainDetailedInformationAboutTheMisconfiguredSignConventionsForS1Invoices() {
        verifyErrorLogDetails();
    }

    @Given("the user attempts to transmit the data to downstream systems")
    public void theUserAttemptsToTransmitTheDataToDownstreamSystems() {
        attemptDataTransmission();
    }

    @Then("the system prevents data transmission due to the detected misconfiguration")
    public void theSystemPreventsDataTransmissionDueToTheDetectedMisconfiguration() {
        verifyDataTransmissionPrevented();
    }
}