package com.cucumber.steps;

import com.pageobjects.SDInvoicePrintPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SDInvoicePrintSteps {

    private SDInvoicePrintPage sdInvoicePrintPage = new SDInvoicePrintPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        sdInvoicePrintPage.verifyUserCredentials();
    }

    @When("the user logs into the SAP S/4HANA Cloud system")
    public void theUserLogsIntoTheSAPSystem() {
        sdInvoicePrintPage.loginToSAPSystem();
    }

    @Then("the user is successfully logged into the system")
    public void theUserIsSuccessfullyLoggedIn() {
        sdInvoicePrintPage.verifySuccessfulLogin();
    }

    @Given("the user is logged into the SAP S/4HANA Cloud system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        sdInvoicePrintPage.verifyUserLoggedIn();
    }

    @When("the user navigates to the periodic billing section")
    public void theUserNavigatesToPeriodicBillingSection() {
        sdInvoicePrintPage.navigateToPeriodicBillingSection();
    }

    @Then("the periodic billing section is displayed")
    public void thePeriodicBillingSectionIsDisplayed() {
        sdInvoicePrintPage.verifyPeriodicBillingSectionDisplayed();
    }

    @Given("the ZPB1 form template is configured in the system")
    public void theZPB1FormTemplateIsConfigured() {
        sdInvoicePrintPage.verifyZPB1FormTemplateConfigured();
    }

    @Given("test data with large volumes and complex scenarios is prepared")
    public void testDataIsPrepared() {
        sdInvoicePrintPage.prepareTestData();
    }

    @When("the user creates multiple periodic billing documents of type {string} with large data volumes and complex scenarios")
    public void theUserCreatesPeriodicBillingDocuments(String billingType) {
        sdInvoicePrintPage.createPeriodicBillingDocuments(billingType);
    }

    @Then("the periodic billing documents are created successfully")
    public void thePeriodicBillingDocumentsAreCreatedSuccessfully() {
        sdInvoicePrintPage.verifyBillingDocumentsCreated();
    }

    @Given("periodic billing documents of type 'ZPB' with large data volumes are created")
    public void periodicBillingDocumentsAreCreated() {
        sdInvoicePrintPage.verifyBillingDocumentsExist();
    }

    @When("the user triggers the output process for the billing documents")
    public void theUserTriggersTheOutputProcess() {
        sdInvoicePrintPage.triggerOutputProcess();
    }

    @Then("the output process is triggered without errors")
    public void theOutputProcessIsTriggeredWithoutErrors() {
        sdInvoicePrintPage.verifyOutputProcessTriggered();
    }

    @When("the user monitors the performance of the SD_INVOICE_PRINT01 program during the output process")
    public void theUserMonitorsProgramPerformance() {
        sdInvoicePrintPage.monitorProgramPerformance();
    }

    @Then("the program performs efficiently without any degradation")
    public void theProgramPerformsEfficiently() {
        sdInvoicePrintPage.verifyProgramPerformance();
    }

    @When("the user verifies the stability of the SD_INVOICE_PRINT01 program during the output process")
    public void theUserVerifiesProgramStability() {
        sdInvoicePrintPage.verifyProgramStability();
    }

    @Then("the program remains stable throughout the process")
    public void theProgramRemainsStable() {
        sdInvoicePrintPage.verifyProgramStability();
    }

    @When("the user checks the printed outputs for formatting issues caused by edge case scenarios")
    public void theUserChecksPrintedOutputs() {
        sdInvoicePrintPage.checkPrintedOutputsForFormattingIssues();
    }

    @Then("the printed outputs are correctly formatted without errors")
    public void thePrintedOutputsAreCorrectlyFormatted() {
        sdInvoicePrintPage.verifyPrintedOutputsFormatted();
    }

    @When("the user validates the accuracy of the printed outputs")
    public void theUserValidatesPrintedOutputs() {
        sdInvoicePrintPage.validatePrintedOutputsAccuracy();
    }

    @Then("the printed outputs are accurate and match the data in the billing documents")
    public void thePrintedOutputsAreAccurate() {
        sdInvoicePrintPage.verifyPrintedOutputsAccuracy();
    }

    @When("the user inspects the system logs for any errors or warnings during the output process")
    public void theUserInspectsSystemLogs() {
        sdInvoicePrintPage.inspectSystemLogs();
    }

    @Then("the system logs do not contain any critical errors or warnings")
    public void theSystemLogsAreClean() {
        sdInvoicePrintPage.verifySystemLogs();
    }

    @When("the user verifies the linkage between the billing documents and the printed outputs")
    public void theUserVerifiesLinkage() {
        sdInvoicePrintPage.verifyBillingDocumentLinkage();
    }

    @Then("the linkage is accurate and consistent")
    public void theLinkageIsAccurate() {
        sdInvoicePrintPage.verifyLinkageAccuracy();
    }

    @When("the user monitors the program's processing time")
    public void theUserMonitorsProcessingTime() {
        sdInvoicePrintPage.monitorProcessingTime();
    }

    @Then("the processing time is within acceptable limits")
    public void theProcessingTimeIsAcceptable() {
        sdInvoicePrintPage.verifyProcessingTime();
    }

    @When("the user monitors the system's stability")
    public void theUserMonitorsSystemStability() {
        sdInvoicePrintPage.monitorSystemStability();
    }

    @Then("the system remains operational without crashes or freezes")
    public void theSystemRemainsOperational() {
        sdInvoicePrintPage.verifySystemStability();
    }
}
