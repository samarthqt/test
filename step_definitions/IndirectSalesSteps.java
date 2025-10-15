package com.cucumber.steps;

import com.pageobjects.IndirectSalesPage;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class IndirectSalesSteps {

    private IndirectSalesPage indirectSalesPage = new IndirectSalesPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user logs in to SAP S/4HANA with authorized credentials")
    public void theUserLogsInToSAP() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        indirectSalesPage.loginToSAP(username, password);
    }

    @Given("the user navigates to transaction ZOTC_INDSALES_MDLNE")
    public void theUserNavigatesToTransaction() {
        indirectSalesPage.navigateToTransaction("ZOTC_INDSALES_MDLNE");
    }

    @When("the user enters valid data including Indirect Sale Type {string}, Product Number {string}, Quantity {string}, Amount {string}, and Invoice Number {string}")
    public void theUserEntersValidData(String indirectSaleType, String productNumber, String quantity, String amount, String invoiceNumber) {
        indirectSalesPage.enterIndirectSaleData(indirectSaleType, productNumber, quantity, amount, invoiceNumber);
    }

    @When("the user saves the indirect sales billing document")
    public void theUserSavesTheBillingDocument() {
        indirectSalesPage.saveBillingDocument();
    }

    @When("the user triggers the outbound interface to send the billing document to Model N")
    public void theUserTriggersOutboundInterface() {
        indirectSalesPage.triggerOutboundInterface();
    }

    @Then("the outbound transmission logs indicate successful transmission of the indirect sales billing document")
    public void theOutboundTransmissionLogsIndicateSuccess() {
        indirectSalesPage.verifyTransmissionLogs("Transmission successful");
    }

    @Then("Model N receives the billing document with all required fields")
    public void modelNReceivesBillingDocument() {
        indirectSalesPage.verifyModelNReception();
    }

    @Then("the entries in ZOTC_CROSSREFTAB confirm that new document types are updated correctly")
    public void entriesInCrossRefTabAreUpdated() {
        indirectSalesPage.verifyCrossRefTabEntries();
    }

    @Then("the linkage between the billing document and Model N is validated successfully")
    public void linkageBetweenBillingDocumentAndModelNIsValidated() {
        indirectSalesPage.validateLinkageWithModelN();
    }

    @Then("no errors are logged in the error logs")
    public void noErrorsAreLogged() {
        indirectSalesPage.verifyErrorLogs();
    }

    @Then("the report of transmitted billing documents includes the tested document")
    public void reportIncludesTestedDocument() {
        indirectSalesPage.verifyReportIncludesDocument();
    }

    @Then("the financial calculations in Model N based on the transmitted data, including rebates and administrative fees, are accurate")
    public void financialCalculationsInModelNAreAccurate() {
        indirectSalesPage.verifyFinancialCalculations();
    }

    @Given("the user navigates to the Indirect Sales processing program {string}")
    public void theUserNavigatesToTheIndirectSalesProcessingProgram(String programName) {
        indirectSalesPage.navigateToIndirectSalesProgram(programName);
    }

    @Then("the Indirect Sales processing program {string} is displayed successfully")
    public void theIndirectSalesProcessingProgramIsDisplayedSuccessfully(String programName) {
        indirectSalesPage.verifyIndirectSalesProgramDisplayed(programName);
    }

    @Given("the ZOTC_CROSSREFTAB table contains mappings for billing document type {string} with {string} sign conventions")
    public void theZOTC_CROSSREFTABTableContainsMappings(String billingDocumentType, String signConventionStatus) {
        indirectSalesPage.verifyCrossRefTableMappings(billingDocumentType, signConventionStatus);
    }

    @When("the user processes an indirect sales transaction using billing document type {string}")
    public void theUserProcessesAnIndirectSalesTransactionUsingBillingDocumentType(String billingDocumentType) {
        indirectSalesPage.processIndirectSalesTransaction(billingDocumentType);
    }

    @Then("the system processes the indirect sales transaction and generates the required data")
    public void theSystemProcessesTheIndirectSalesTransactionAndGeneratesTheRequiredData() {
        indirectSalesPage.verifyTransactionProcessedSuccessfully();
    }

    @Then("the system detects the {string} sign conventions and logs an error or warning message")
    public void theSystemDetectsSignConventionsAndLogsAnErrorOrWarningMessage(String signConventionStatus) {
        indirectSalesPage.verifyErrorOrWarningMessageLogged(signConventionStatus);
    }

    @Given("the user processes an indirect sales transaction with billing document type {string} and {string} sign conventions")
    public void theUserProcessesAnIndirectSalesTransactionWithBillingDocumentTypeAndSignConventions(String billingDocumentType, String signConventionStatus) {
        indirectSalesPage.processIndirectSalesTransactionWithSignConventions(billingDocumentType, signConventionStatus);
    }

    @When("the user checks the error logs for details about the misconfiguration")
    public void theUserChecksTheErrorLogsForDetailsAboutTheMisconfiguration() {
        indirectSalesPage.checkErrorLogsForMisconfigurationDetails();
    }

    @Then("the error logs contain detailed information about the misconfigured sign conventions for {string} invoices")
    public void theErrorLogsContainDetailedInformationAboutTheMisconfiguredSignConventions(String billingDocumentType) {
        indirectSalesPage.verifyErrorLogsContainDetails(billingDocumentType);
    }

    @When("the user attempts to transmit the data to downstream systems")
    public void theUserAttemptsToTransmitTheDataToDownstreamSystems() {
        indirectSalesPage.attemptDataTransmissionToDownstreamSystems();
    }

    @Then("the system prevents data transmission due to the detected misconfiguration")
    public void theSystemPreventsDataTransmissionDueToTheDetectedMisconfiguration() {
        indirectSalesPage.verifyDataTransmissionPrevented();
    }

    @Then("no incorrect data is transmitted, ensuring data integrity")
    public void noIncorrectDataIsTransmittedEnsuringDataIntegrity() {
        indirectSalesPage.verifyDataIntegrityMaintained();
    }

    @When("the user reviews the system notifications or alerts generated for the misconfiguration")
    public void theUserReviewsTheSystemNotificationsOrAlertsGeneratedForTheMisconfiguration() {
        indirectSalesPage.reviewSystemNotificationsOrAlerts();
    }

    @Then("the system generates appropriate notifications or alerts to inform relevant stakeholders about the issue")
    public void theSystemGeneratesAppropriateNotificationsOrAlertsToInformRelevantStakeholdersAboutTheIssue() {
        indirectSalesPage.verifyNotificationsOrAlertsGenerated();
    }
}
