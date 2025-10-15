package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.pageobjects.DirectSalesPage;
import com.framework.cucumber.TestHarness;

public class DirectSalesSteps {

    private DirectSalesPage directSalesPage = new DirectSalesPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the Direct Sales processing program {string} is configured")
    public void theDirectSalesProcessingProgramIsConfigured(String programName) {
        directSalesPage.configureDirectSalesProgram(programName);
    }

    @When("the user navigates to the Direct Sales processing program")
    public void theUserNavigatesToTheDirectSalesProcessingProgram() {
        directSalesPage.navigateToDirectSalesProgram();
    }

    @Then("the Direct Sales processing program is displayed successfully")
    public void theDirectSalesProcessingProgramIsDisplayedSuccessfully() {
        directSalesPage.verifyDirectSalesProgramDisplayed();
    }

    @Given("the ZOTC_CROSSREFTAB table contains mappings for billing document type {string} with {string}")
    public void theZOTCCROSSREFTABTableContainsMappings(String billingDocumentType, String signConvention) {
        directSalesPage.verifyCrossRefTableMappings(billingDocumentType, signConvention);
    }

    @When("the user creates a sales order using billing document type {string}")
    public void theUserCreatesASalesOrderUsingBillingDocumentType(String billingDocumentType) {
        directSalesPage.createSalesOrder(billingDocumentType);
    }

    @Then("the sales order is created successfully with the specified billing document type")
    public void theSalesOrderIsCreatedSuccessfully() {
        directSalesPage.verifySalesOrderCreated();
    }

    @Given("the user has created a sales order with billing document type S1")
    public void theUserHasCreatedASalesOrderWithBillingDocumentTypeS1() {
        directSalesPage.verifySalesOrderWithBillingTypeS1();
    }

    @When("the user processes the sales order")
    public void theUserProcessesTheSalesOrder() {
        directSalesPage.processSalesOrder();
    }

    @Then("the system processes the sales order and generates a billing document")
    public void theSystemProcessesTheSalesOrderAndGeneratesABillingDocument() {
        directSalesPage.verifyBillingDocumentGenerated();
    }

    @Given("the billing document is generated")
    public void theBillingDocumentIsGenerated() {
        directSalesPage.verifyBillingDocumentGenerated();
    }

    @When("the user verifies the displayed amount and quantity in the billing document")
    public void theUserVerifiesTheDisplayedAmountAndQuantity() {
        directSalesPage.verifyDisplayedAmountAndQuantity();
    }

    @Then("the system detects {string} and logs {string}")
    public void theSystemDetectsAndLogs(String misconfigurationStatus, String messageType) {
        directSalesPage.verifySystemLogs(misconfigurationStatus, messageType);
    }

    @Given("the system has logged errors or warnings for misconfigured sign conventions")
    public void theSystemHasLoggedErrorsOrWarnings() {
        directSalesPage.verifySystemLogsForMisconfiguration();
    }

    @When("the user checks the error logs")
    public void theUserChecksTheErrorLogs() {
        directSalesPage.checkErrorLogs();
    }

    @Then("the error logs contain detailed information about the misconfigured sign conventions for S1 invoices")
    public void theErrorLogsContainDetailedInformation() {
        directSalesPage.verifyErrorLogDetails();
    }

    @Given("the system has detected misconfigured sign conventions")
    public void theSystemHasDetectedMisconfiguredSignConventions() {
        directSalesPage.verifyMisconfiguredSignConventions();
    }

    @When("the user attempts to transmit the billing document data to downstream systems")
    public void theUserAttemptsToTransmitBillingDocumentData() {
        directSalesPage.attemptDataTransmission();
    }

    @Then("the system prevents data transmission due to the detected misconfiguration")
    public void theSystemPreventsDataTransmission() {
        directSalesPage.verifyDataTransmissionPrevention();
    }

    @Given("the system has prevented data transmission due to the detected misconfiguration")
    public void theSystemHasPreventedDataTransmission() {
        directSalesPage.verifyDataTransmissionPrevention();
    }

    @When("the user validates the transmitted data")
    public void theUserValidatesTheTransmittedData() {
        directSalesPage.validateTransmittedData();
    }

    @Then("no incorrect data is transmitted, ensuring data integrity")
    public void noIncorrectDataIsTransmitted() {
        directSalesPage.verifyDataIntegrity();
    }

    @Given("the ZOTC_SALES_ORDER program is configured")
    public void theZOTCSalesOrderProgramIsConfigured() {
        directSalesPage.verifyProgramConfiguration("ZOTC_SALES_ORDER");
    }

    @When("the user navigates to the Direct Sales processing program \\(ZOTC_SALES_ORDER\\)")
    public void theUserNavigatesToTheDirectSalesProcessingProgram() {
        directSalesPage.navigateToDirectSalesProgram("ZOTC_SALES_ORDER");
    }

    @Then("the Direct Sales processing program is displayed successfully")
    public void theDirectSalesProcessingProgramIsDisplayedSuccessfully() {
        directSalesPage.verifyProgramDisplayed("ZOTC_SALES_ORDER");
    }

    @Given("the ZOTC_CROSSREFTAB table contains mappings for S1 billing document type with incorrect sign conventions")
    public void theZOTCCrossRefTabTableContainsMappingsForS1BillingDocumentTypeWithIncorrectSignConventions() {
        directSalesPage.verifyCrossRefTableMappings("S1");
    }

    @When("the user creates a sales order using billing document type {string} with the minimum required data")
    public void theUserCreatesASalesOrderUsingBillingDocumentTypeWithTheMinimumRequiredData(String billingDocumentType) {
        directSalesPage.createSalesOrder(billingDocumentType);
    }

    @Then("the sales order is created successfully with the specified billing document type and minimum data")
    public void theSalesOrderIsCreatedSuccessfullyWithTheSpecifiedBillingDocumentTypeAndMinimumData() {
        directSalesPage.verifySalesOrderCreation("S1");
    }

    @When("the user verifies the displayed amount and quantity in the generated billing document")
    public void theUserVerifiesTheDisplayedAmountAndQuantityInTheGeneratedBillingDocument() {
        directSalesPage.verifyBillingDocumentDetails();
    }

    @Then("the system detects the misconfigured sign conventions and logs an error or warning message")
    public void theSystemDetectsTheMisconfiguredSignConventionsAndLogsAnErrorOrWarningMessage() {
        directSalesPage.verifyErrorLogsForSignConventions();
    }

    @Given("the system has logged an error or warning message for misconfigured sign conventions")
    public void theSystemHasLoggedAnErrorOrWarningMessageForMisconfiguredSignConventions() {
        directSalesPage.verifyErrorLogsExist();
    }

    @When("the user checks the error logs for details about the misconfiguration")
    public void theUserChecksTheErrorLogsForDetailsAboutTheMisconfiguration() {
        directSalesPage.checkErrorLogDetails();
    }

    @Then("the error logs contain detailed information about the misconfigured sign conventions for S1 invoices")
    public void theErrorLogsContainDetailedInformationAboutTheMisconfiguredSignConventionsForS1Invoices() {
        directSalesPage.verifyErrorLogDetails("S1");
    }

    @When("the user attempts to process the sales order to generate a billing document")
    public void theUserAttemptsToProcessTheSalesOrderToGenerateABillingDocument() {
        directSalesPage.processSalesOrder();
    }

    @Then("the system {string} for the billing document type")
    public void theSystemForTheBillingDocumentType(String systemBehavior) {
        directSalesPage.verifySystemBehavior(systemBehavior);
    }

    @Then("the system displays {string} if applicable")
    public void theSystemDisplaysIfApplicable(String errorMessage) {
        directSalesPage.verifyErrorMessage(errorMessage);
    }

    @Then("the system logs contain {string} if applicable")
    public void theSystemLogsContainIfApplicable(String logDetails) {
        directSalesPage.verifyLogDetails(logDetails);
    }

    @Then("no billing document is created if the type is unsupported")
    public void noBillingDocumentIsCreatedIfTheTypeIsUnsupported() {
        directSalesPage.verifyNoBillingDocumentCreated();
    }

    @Then("the system maintains data integrity by not allowing unsupported document types into the workflow")
    public void theSystemMaintainsDataIntegrityByNotAllowingUnsupportedDocumentTypesIntoTheWorkflow() {
        directSalesPage.verifyDataIntegrity();
    }

    @Then("downstream systems like Model N remain unaffected by the processing outcome")
    public void downstreamSystemsLikeModelNRemainUnaffectedByTheProcessingOutcome() {
        directSalesPage.verifyDownstreamSystemsUnaffected();
    }

    @Then("the system rejects the unsupported billing document type")
    public void theSystemRejectsTheUnsupportedBillingDocumentType() {
        directSalesPage.verifyUnsupportedDocumentTypeRejection();
    }

    @Then("the system displays a clear error message indicating the billing document type is not supported")
    public void theSystemDisplaysAClearErrorMessageIndicatingTheBillingDocumentTypeIsNotSupported() {
        directSalesPage.verifyClearErrorMessage();
    }

    @Then("the system logs contain detailed error entries related to the unsupported document type")
    public void theSystemLogsContainDetailedErrorEntriesRelatedToTheUnsupportedDocumentType() {
        directSalesPage.verifyDetailedErrorLogs();
    }

    @Then("no billing document is created for the unsupported type")
    public void noBillingDocumentIsCreatedForTheUnsupportedType() {
        directSalesPage.verifyNoBillingDocumentForUnsupportedType();
    }

    @Then("the rejection process is consistent across different unsupported billing document types")
    public void theRejectionProcessIsConsistentAcrossDifferentUnsupportedBillingDocumentTypes() {
        directSalesPage.verifyRejectionProcessConsistency();
    }

    @Then("the system displays an error message with sufficient details for troubleshooting")
    public void theSystemDisplaysAnErrorMessageWithSufficientDetailsForTroubleshooting() {
        directSalesPage.verifyErrorMessageDetails();
    }

    @Then("the system handles the unsupported billing document type gracefully without crashes")
    public void theSystemHandlesTheUnsupportedBillingDocumentTypeGracefullyWithoutCrashes() {
        directSalesPage.verifyGracefulHandling();
    }
}
