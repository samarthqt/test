package com.cucumber.steps;

import com.pageobjects.InvoiceListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class InvoiceListSteps {

    private InvoiceListPage invoiceListPage = new InvoiceListPage();

    @Given("the user has valid credentials with VF23 execution authorization")
    public void theUserHasValidCredentialsWithVF23ExecutionAuthorization() {
        invoiceListPage.loginToSAP("validUsername", "validPassword");
        invoiceListPage.verifyVF23Authorization();
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        invoiceListPage.loginToSAPSystem("validUsername", "validPassword");
    }

    @Then("the user is successfully logged in with access to the VF23 transaction")
    public void theUserIsSuccessfullyLoggedInWithAccessToVF23Transaction() {
        invoiceListPage.verifyVF23TransactionAccess();
    }

    @Given("the user is on the VF23 transaction screen")
    public void theUserIsOnTheVF23TransactionScreen() {
        invoiceListPage.verifyVF23Screen();
    }

    @When("the user inputs the invoice list document number {string}")
    public void theUserInputsTheInvoiceListDocumentNumber(String documentNumber) {
        invoiceListPage.inputInvoiceListDocumentNumber(documentNumber);
    }

    @Then("the invoice list document details are retrieved and displayed")
    public void theInvoiceListDocumentDetailsAreRetrievedAndDisplayed() {
        invoiceListPage.verifyInvoiceListDetailsDisplayed();
    }

    @Given("the user has retrieved the invoice list document details")
    public void theUserHasRetrievedTheInvoiceListDocumentDetails() {
        invoiceListPage.verifyInvoiceListDetailsRetrieved();
    }

    @When("the user executes the transaction to trigger the Invoice List output")
    public void theUserExecutesTheTransactionToTriggerInvoiceListOutput() {
        invoiceListPage.triggerInvoiceListOutput();
    }

    @Then("the system displays an error message {string}")
    public void theSystemDisplaysAnErrorMessage(String errorMessage) {
        invoiceListPage.verifyErrorMessageDisplayed(errorMessage);
    }

    @Then("the system prevents further processing of the Invoice List output")
    public void theSystemPreventsFurtherProcessingOfInvoiceListOutput() {
        invoiceListPage.verifyProcessingHalted();
    }

    @Then("no output is generated")
    public void noOutputIsGenerated() {
        invoiceListPage.verifyNoOutputGenerated();
    }

    @Given("the user has attempted to generate the Invoice List output")
    public void theUserHasAttemptedToGenerateInvoiceListOutput() {
        invoiceListPage.verifyInvoiceListOutputAttempted();
    }

    @When("the user checks the system log for error message details")
    public void theUserChecksTheSystemLogForErrorMessageDetails() {
        invoiceListPage.checkSystemLogForErrorDetails();
    }

    @Then("the error log contains detailed information about the missing configuration for Output Type ZPIL")
    public void theErrorLogContainsDetailedInformationAboutMissingConfiguration() {
        invoiceListPage.verifyErrorLogDetails("Output Type ZPIL is not configured");
    }

    @Given("the user has received the error message for missing Output Type ZPIL")
    public void theUserHasReceivedErrorMessageForMissingOutputTypeZPIL() {
        invoiceListPage.verifyErrorMessageReceived("Output Type ZPIL is not configured");
    }

    @When("the user attempts to re-trigger the output without modifying the configuration")
    public void theUserAttemptsToReTriggerOutputWithoutModifyingConfiguration() {
        invoiceListPage.reTriggerInvoiceListOutput();
    }

    @Then("the system displays the same error message")
    public void theSystemDisplaysSameErrorMessage() {
        invoiceListPage.verifyErrorMessageDisplayed("Output Type ZPIL is not configured");
    }

    @Then("the behavior is confirmed to be consistent")
    public void theBehaviorIsConfirmedToBeConsistent() {
        invoiceListPage.verifyConsistentBehavior();
    }

    @Given("the user needs to verify the configuration of Output Type ZPIL")
    public void theUserNeedsToVerifyConfigurationOfOutputTypeZPIL() {
        invoiceListPage.navigateToConfigurationScreen();
    }

    @When("the user navigates to the configuration screen for Output Type ZPIL")
    public void theUserNavigatesToConfigurationScreenForOutputTypeZPIL() {
        invoiceListPage.accessConfigurationScreen();
    }

    @Then("the configuration screen for Output Type ZPIL is accessible")
    public void theConfigurationScreenForOutputTypeZPILIsAccessible() {
        invoiceListPage.verifyConfigurationScreenAccessible();
    }

    @Given("the user is on the configuration screen for Output Type ZPIL")
    public void theUserIsOnConfigurationScreenForOutputTypeZPIL() {
        invoiceListPage.verifyConfigurationScreen();
    }

    @When("the user verifies the configuration")
    public void theUserVerifiesConfiguration() {
        invoiceListPage.verifyOutputTypeConfiguration();
    }

    @Then("Output Type ZPIL is confirmed to be missing from the configuration")
    public void outputTypeZPILIsConfirmedToBeMissingFromConfiguration() {
        invoiceListPage.verifyOutputTypeMissing();
    }

    @Given("the user has completed the test for missing Output Type ZPIL")
    public void theUserHasCompletedTestForMissingOutputTypeZPIL() {
        invoiceListPage.verifyTestCompletion();
    }

    @When("the user documents the test results and error message details")
    public void theUserDocumentsTestResultsAndErrorMessageDetails() {
        invoiceListPage.documentTestResults();
    }

    @Then("the test results and error message details are documented for further analysis")
    public void theTestResultsAndErrorMessageDetailsAreDocumented() {
        invoiceListPage.verifyDocumentationComplete();
    }

    @Given("the user has completed all necessary actions in the system")
    public void theUserHasCompletedAllNecessaryActionsInSystem() {
        invoiceListPage.verifyActionsCompletion();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfSAPSystem() {
        invoiceListPage.logoutFromSystem();
    }

    @Then("the user is successfully logged out of the system")
    public void theUserIsSuccessfullyLoggedOutOfSystem() {
        invoiceListPage.verifyLogoutSuccess();
    }

    @Given("the user has valid SAP credentials with VF23 execution authorization")
    public void theUserHasValidSAPCredentialsWithVF23ExecutionAuthorization() {
        invoiceListPage.validateSAPCredentials();
    }

    @Given("the High Output Type ZPIL is assigned")
    public void theHighOutputTypeZPILIsAssigned() {
        invoiceListPage.verifyOutputTypeAssignment();
    }

    @Then("the user is successfully logged into the SAP system")
    public void theUserIsSuccessfullyLoggedIntoTheSAPSystem() {
        invoiceListPage.verifyLoginSuccess();
    }

    @Given("the user is logged into the SAP system")
    public void theUserIsLoggedIntoTheSAPSystem() {
        invoiceListPage.ensureUserLoggedIn();
    }

    @Given("the SD_INVOICE_PRINT01 program and ZOTC_CON_INV_DT_FORM are configured and accessible")
    public void theSDInvoicePrintProgramAndFormAreConfiguredAndAccessible() {
        invoiceListPage.verifyProgramAndFormAccessibility();
    }

    @When("the user navigates to the VF23 transaction")
    public void theUserNavigatesToTheVF23Transaction() {
        invoiceListPage.navigateToVF23();
    }

    @Then("the VF23 transaction screen is displayed")
    public void theVF23TransactionScreenIsDisplayed() {
        invoiceListPage.verifyVF23ScreenDisplayed();
    }

    @When("the user enters the required parameters to select the invoice list document \"{string}\"")
    public void theUserEntersTheRequiredParametersToSelectTheInvoiceListDocument(String documentNumber) {
        invoiceListPage.enterInvoiceListParameters(documentNumber);
    }

    @Then("the invoice list document is selected successfully")
    public void theInvoiceListDocumentIsSelectedSuccessfully() {
        invoiceListPage.verifyInvoiceListSelection();
    }

    @Given("the user has selected an invoice list document with the maximum number of linked invoices")
    public void theUserHasSelectedAnInvoiceListDocumentWithTheMaximumNumberOfLinkedInvoices() {
        invoiceListPage.ensureInvoiceListDocumentSelected();
    }

    @Then("the Invoice List output is triggered successfully")
    public void theInvoiceListOutputIsTriggeredSuccessfully() {
        invoiceListPage.verifyOutputTriggered();
    }

    @Given("the Invoice List output is triggered successfully")
    public void theInvoiceListOutputIsTriggeredSuccessfullyGiven() {
        invoiceListPage.ensureOutputTriggered();
    }

    @When("the user validates the output type")
    public void theUserValidatesTheOutputType() {
        invoiceListPage.validateOutputType();
    }

    @Then("Output Type ZPIL is confirmed as triggered")
    public void outputTypeZPILIsConfirmedAsTriggered() {
        invoiceListPage.verifyOutputTypeZPIL();
    }

    @When("the user reviews the output")
    public void theUserReviewsTheOutput() {
        invoiceListPage.reviewOutput();
    }

    @Then("all linked invoices are included in the output")
    public void allLinkedInvoicesAreIncludedInTheOutput() {
        invoiceListPage.verifyAllLinkedInvoicesIncluded();
    }

    @When("the user checks for performance issues or delays")
    public void theUserChecksForPerformanceIssuesOrDelays() {
        invoiceListPage.checkPerformanceIssues();
    }

    @Then("the output is generated without performance issues or delays")
    public void theOutputIsGeneratedWithoutPerformanceIssuesOrDelays() {
        invoiceListPage.verifyNoPerformanceIssues();
    }

    @When("the user reviews the output format")
    public void theUserReviewsTheOutputFormat() {
        invoiceListPage.reviewOutputFormat();
    }

    @Then("the output format remains consistent and as expected")
    public void theOutputFormatRemainsConsistentAndAsExpected() {
        invoiceListPage.verifyOutputFormatConsistency();
    }

    @When("the user validates the data for all linked invoices")
    public void theUserValidatesTheDataForAllLinkedInvoices() {
        invoiceListPage.validateLinkedInvoiceData();
    }

    @Then("the data for all invoices in the output is accurate and complete")
    public void theDataForAllInvoicesInTheOutputIsAccurateAndComplete() {
        invoiceListPage.verifyInvoiceDataAccuracy();
    }

    @When("the user saves the output")
    public void theUserSavesTheOutput() {
        invoiceListPage.saveOutput();
    }

    @Then("the output is saved successfully")
    public void theOutputIsSavedSuccessfully() {
        invoiceListPage.verifyOutputSaved();
    }

    @Given("the Invoice List output is saved")
    public void theInvoiceListOutputIsSaved() {
        invoiceListPage.ensureOutputSaved();
    }

    @When("the user exports the output")
    public void theUserExportsTheOutput() {
        invoiceListPage.exportOutput();
    }

    @Then("the output is exported successfully")
    public void theOutputIsExportedSuccessfully() {
        invoiceListPage.verifyOutputExported();
    }

    @When("the user documents observations or anomalies")
    public void theUserDocumentsObservationsOrAnomalies() {
        invoiceListPage.documentObservations();
    }

    @Then("all observations and anomalies are documented successfully")
    public void allObservationsAndAnomaliesAreDocumentedSuccessfully() {
        invoiceListPage.verifyObservationsDocumented();
    }
}
