package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.ZPB1TemplatePage;
import com.framework.cucumber.TestHarness;

public class ZPB1TemplateSteps {

    private ZPB1TemplatePage zpb1TemplatePage = new ZPB1TemplatePage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        zpb1TemplatePage.verifyUserCredentials();
    }

    @When("the user logs into the SAP system")
    public void theUserLogsIntoTheSAPSystem() {
        zpb1TemplatePage.loginToSAPSystem();
    }

    @Then("the user is successfully logged in and redirected to the main dashboard")
    public void theUserIsSuccessfullyLoggedInAndRedirectedToTheMainDashboard() {
        zpb1TemplatePage.verifyUserRedirectedToDashboard();
    }

    @Then("the periodic billing document creation module is displayed")
    public void thePeriodicBillingDocumentCreationModuleIsDisplayed() {
        zpb1TemplatePage.verifyPeriodicBillingModuleDisplayed();
    }

    @Given("the user is on the periodic billing document creation module")
    public void theUserIsOnThePeriodicBillingDocumentCreationModule() {
        zpb1TemplatePage.navigateToPeriodicBillingModule();
    }

    @Given("the form template status is {string}")
    public void theFormTemplateStatusIs(String formTemplateStatus) {
        zpb1TemplatePage.verifyFormTemplateStatus(formTemplateStatus);
    }

    @When("the user selects document type {string} for creation")
    public void theUserSelectsDocumentTypeForCreation(String documentType) {
        zpb1TemplatePage.selectDocumentType(documentType);
    }

    @When("the user attempts to generate the periodic billing document")
    public void theUserAttemptsToGenerateThePeriodicBillingDocument() {
        zpb1TemplatePage.attemptToGenerateBillingDocument();
    }

    @Then("the system displays {string}")
    public void theSystemDisplays(String systemResponse) {
        zpb1TemplatePage.verifySystemResponse(systemResponse);
    }

    @Then("the system logs contain {string}")
    public void theSystemLogsContain(String logDetails) {
        zpb1TemplatePage.verifySystemLogs(logDetails);
    }

    @Then("no incomplete billing document is saved in the system")
    public void noIncompleteBillingDocumentIsSavedInTheSystem() {
        zpb1TemplatePage.verifyNoIncompleteBillingDocument();
    }

    @Given("the user observes system error messages")
    public void theUserObservesSystemErrorMessages() {
        zpb1TemplatePage.observeSystemErrorMessages();
    }

    @Then("the error messages include actionable suggestions for resolution")
    public void theErrorMessagesIncludeActionableSuggestionsForResolution() {
        zpb1TemplatePage.verifyErrorMessagesContainSuggestions();
    }

    @Given("the user has received error message details")
    public void theUserHasReceivedErrorMessageDetails() {
        zpb1TemplatePage.verifyErrorMessageDetailsReceived();
    }

    @When("the user attempts to correct the ZPB1 template configuration")
    public void theUserAttemptsToCorrectTheZPB1TemplateConfiguration() {
        zpb1TemplatePage.correctZPB1TemplateConfiguration();
    }

    @Then("the ZPB1 template configuration is corrected successfully")
    public void theZPB1TemplateConfigurationIsCorrectedSuccessfully() {
        zpb1TemplatePage.verifyTemplateConfigurationCorrected();
    }

    @When("the user reprocesses the billing document after correcting the template")
    public void theUserReprocessesTheBillingDocumentAfterCorrectingTheTemplate() {
        zpb1TemplatePage.reprocessBillingDocument();
    }

    @Then("the billing document is processed successfully using the corrected template")
    public void theBillingDocumentIsProcessedSuccessfullyUsingTheCorrectedTemplate() {
        zpb1TemplatePage.verifyBillingDocumentProcessedSuccessfully();
    }

    @Given("the user has generated a billing document with the corrected template")
    public void theUserHasGeneratedABillingDocumentWithTheCorrectedTemplate() {
        zpb1TemplatePage.verifyBillingDocumentGeneratedWithCorrectedTemplate();
    }

    @Then("the system complies with periodic billing standards ensuring no disruptions")
    public void theSystemCompliesWithPeriodicBillingStandardsEnsuringNoDisruptions() {
        zpb1TemplatePage.verifySystemComplianceWithBillingStandards();
    }

    @Given("the user has successfully processed the billing document")
    public void theUserHasSuccessfullyProcessedTheBillingDocument() {
        zpb1TemplatePage.verifyBillingDocumentProcessed();
    }

    @Then("the corrected ZPB1 form template is used without issues")
    public void theCorrectedZPB1FormTemplateIsUsedWithoutIssues() {
        zpb1TemplatePage.verifyCorrectedTemplateUsed();
    }

    @Given("the billing document type {string} is configured in the system")
    public void theBillingDocumentTypeIsConfiguredInTheSystem(String documentType) {
        zpb1TemplatePage.verifyBillingDocumentTypeConfigured(documentType);
    }

    @Then("the billing document type {string} is available for selection")
    public void theBillingDocumentTypeIsAvailableForSelection(String documentType) {
        zpb1TemplatePage.verifyBillingDocumentTypeAvailable(documentType);
    }

    @Given("the form template {string} is configured with maximum field lengths")
    public void theFormTemplateIsConfiguredWithMaximumFieldLengths(String template) {
        zpb1TemplatePage.verifyFormTemplateConfigured(template);
    }

    @Then("the form template {string} is available for use")
    public void theFormTemplateIsAvailableForUse(String template) {
        zpb1TemplatePage.verifyFormTemplateAvailable(template);
    }

    @Then("the document type {string} is selected without errors")
    public void theDocumentTypeIsSelectedWithoutErrors(String documentType) {
        zpb1TemplatePage.verifyDocumentTypeSelected(documentType);
    }

    @When("the user attempts to generate the periodic billing document using the {string} template")
    public void theUserAttemptsToGenerateThePeriodicBillingDocumentUsingTheTemplate(String template) {
        zpb1TemplatePage.generateBillingDocument(template);
    }

    @Then("the system generates the billing document using the {string} template without errors")
    public void theSystemGeneratesTheBillingDocumentUsingTheTemplateWithoutErrors(String template) {
        zpb1TemplatePage.verifyBillingDocumentGenerated(template);
    }

    @Given("the ZPB1 template contains maximum field lengths")
    public void theZPB1TemplateContainsMaximumFieldLengths() {
        zpb1TemplatePage.verifyTemplateFieldLengths();
    }

    @When("the system processes the ZPB1 template")
    public void theSystemProcessesTheZPB1Template() {
        zpb1TemplatePage.processTemplate();
    }

    @Then("the system handles the maximum field lengths without truncation or errors")
    public void theSystemHandlesTheMaximumFieldLengthsWithoutTruncationOrErrors() {
        zpb1TemplatePage.verifyFieldLengthHandling();
    }

    @When("the user checks the generated billing document")
    public void theUserChecksTheGeneratedBillingDocument() {
        zpb1TemplatePage.checkGeneratedBillingDocument();
    }

    @Then("the generated billing document contains accurate data without truncation")
    public void theGeneratedBillingDocumentContainsAccurateDataWithoutTruncation() {
        zpb1TemplatePage.verifyBillingDocumentDataAccuracy();
    }

    @When("the user observes the formatting of the ZPB1 template in the generated billing document")
    public void theUserObservesTheFormattingOfTheZPB1TemplateInTheGeneratedBillingDocument() {
        zpb1TemplatePage.observeTemplateFormatting();
    }

    @Then("the ZPB1 template is formatted correctly without misalignment")
    public void theZPB1TemplateIsFormattedCorrectlyWithoutMisalignment() {
        zpb1TemplatePage.verifyTemplateFormatting();
    }

    @When("the user reviews the system logs")
    public void theUserReviewsTheSystemLogs() {
        zpb1TemplatePage.reviewSystemLogs();
    }

    @Then("the system logs do not contain warnings or errors related to field lengths")
    public void theSystemLogsDoNotContainWarningsOrErrorsRelatedToFieldLengths() {
        zpb1TemplatePage.verifySystemLogs();
    }

    @When("the user attempts to print the generated billing document")
    public void theUserAttemptsToPrintTheGeneratedBillingDocument() {
        zpb1TemplatePage.printBillingDocument();
    }

    @Then("the billing document is printed successfully without formatting issues")
    public void theBillingDocumentIsPrintedSuccessfullyWithoutFormattingIssues() {
        zpb1TemplatePage.verifyBillingDocumentPrinting();
    }

    @When("the user validates the system's compliance with periodic billing standards")
    public void theUserValidatesTheSystemSComplianceWithPeriodicBillingStandards() {
        zpb1TemplatePage.validateSystemCompliance();
    }

    @Then("the system complies with periodic billing standards, ensuring no disruptions")
    public void theSystemCompliesWithPeriodicBillingStandardsEnsuringNoDisruptions() {
        zpb1TemplatePage.verifySystemCompliance();
    }

    @When("the user verifies the usage of the ZPB1 template in the billing document")
    public void theUserVerifiesTheUsageOfTheZPB1TemplateInTheBillingDocument() {
        zpb1TemplatePage.verifyTemplateUsage();
    }

    @Then("the ZPB1 template is used correctly without issues")
    public void theZPB1TemplateIsUsedCorrectlyWithoutIssues() {
        zpb1TemplatePage.verifyCorrectTemplateUsage();
    }

    @Given("the ZPB1 template includes edge cases for field lengths")
    public void theZPB1TemplateIncludesEdgeCasesForFieldLengths() {
        zpb1TemplatePage.verifyTemplateEdgeCases();
    }

    @Then("the system handles edge cases for field lengths without errors")
    public void theSystemHandlesEdgeCasesForFieldLengthsWithoutErrors() {
        zpb1TemplatePage.verifyEdgeCaseHandling();
    }
}
