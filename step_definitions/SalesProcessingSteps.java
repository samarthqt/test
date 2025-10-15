package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.SalesProcessingPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SalesProcessingSteps extends SalesProcessingPage {

    @Given("the user is on the application home page")
    public void theUserIsOnTheApplicationHomePage() {
        navigateToHomePage();
    }

    @When("the user navigates to the Direct Sales processing program {string}")
    public void theUserNavigatesToTheDirectSalesProcessingProgram(String programName) {
        navigateToDirectSalesProgram(programName);
    }

    @Then("the Direct Sales processing program is displayed successfully")
    public void theDirectSalesProcessingProgramIsDisplayedSuccessfully() {
        verifyDirectSalesProgramDisplayed();
    }

    @Given("the user is on the Direct Sales processing program")
    public void theUserIsOnTheDirectSalesProcessingProgram() {
        verifyDirectSalesProgramDisplayed();
    }

    @When("the user creates a sales order with billing document type {string}")
    public void theUserCreatesASalesOrderWithBillingDocumentType(String billingDocumentType) {
        createSalesOrder(billingDocumentType);
    }

    @Then("the sales order is created successfully with the specified billing document type")
    public void theSalesOrderIsCreatedSuccessfullyWithTheSpecifiedBillingDocumentType() {
        verifySalesOrderCreated();
    }

    @Given("the user has created a sales order with billing document type S1")
    public void theUserHasCreatedASalesOrderWithBillingDocumentTypeS1() {
        createSalesOrder("S1");
        verifySalesOrderCreated();
    }

    @When("the user processes the sales order")
    public void theUserProcessesTheSalesOrder() {
        processSalesOrder();
    }

    @Then("the system logs an error indicating missing ZOTC_CROSSREFTAB entries for S1 invoices")
    public void theSystemLogsAnErrorIndicatingMissingZOTC_CROSSREFTABEntriesForS1Invoices() {
        verifyErrorLoggedForMissingEntries();
    }

    @Then("the system prevents further processing")
    public void theSystemPreventsFurtherProcessing() {
        verifyProcessingPrevented();
    }

    @When("the user navigates to the Indirect Sales processing program {string}")
    public void theUserNavigatesToTheIndirectSalesProcessingProgram(String programName) {
        navigateToIndirectSalesProgram(programName);
    }

    @Then("the Indirect Sales processing program is displayed successfully")
    public void theIndirectSalesProcessingProgramIsDisplayedSuccessfully() {
        verifyIndirectSalesProgramDisplayed();
    }

    @When("the user processes an indirect sales transaction with billing document type {string}")
    public void theUserProcessesAnIndirectSalesTransactionWithBillingDocumentType(String billingDocumentType) {
        processIndirectSalesTransaction(billingDocumentType);
    }

    @Given("the user has attempted to process a sales order or an indirect sales transaction with billing document type S1")
    public void theUserHasAttemptedToProcessASalesOrderOrAnIndirectSalesTransactionWithBillingDocumentTypeS1() {
        attemptToProcessTransaction("S1");
    }

    @When("the user checks the error logs")
    public void theUserChecksTheErrorLogs() {
        checkErrorLogs();
    }

    @Then("the error logs contain detailed information about the missing ZOTC_CROSSREFTAB entries for S1 invoices")
    public void theErrorLogsContainDetailedInformationAboutTheMissingZOTC_CROSSREFTABEntriesForS1Invoices() {
        verifyErrorLogDetails();
    }

    @When("the user attempts to transmit the data to downstream systems")
    public void theUserAttemptsToTransmitTheDataToDownstreamSystems() {
        attemptDataTransmission();
    }

    @Then("the system prevents data transmission due to the missing ZOTC_CROSSREFTAB entries")
    public void theSystemPreventsDataTransmissionDueToTheMissingZOTC_CROSSREFTABEntries() {
        verifyDataTransmissionPrevented();
    }
}