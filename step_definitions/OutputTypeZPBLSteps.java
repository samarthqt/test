package com.cucumber.steps;

import com.pageobjects.OutputTypeZPBLPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class OutputTypeZPBLSteps {

    private OutputTypeZPBLPage outputTypeZPBLPage = new OutputTypeZPBLPage();

    @Given("the user logs into the SAP system with authorized credentials")
    public void theUserLogsIntoTheSAPSystemWithAuthorizedCredentials() {
        outputTypeZPBLPage.loginToSAPSystem("authorizedUser", "password123");
    }

    @When("the user navigates to transaction VF03")
    public void theUserNavigatesToTransactionVF03() {
        outputTypeZPBLPage.navigateToTransactionVF03();
    }

    @When("the user enters the cancellation billing document number {string} and executes")
    public void theUserEntersTheCancellationBillingDocumentNumberAndExecutes(String documentNumber) {
        outputTypeZPBLPage.enterCancellationBillingDocumentNumber(documentNumber);
        outputTypeZPBLPage.executeTransaction();
    }

    @Then("the cancellation billing document details are displayed")
    public void theCancellationBillingDocumentDetailsAreDisplayed() {
        outputTypeZPBLPage.verifyCancellationBillingDocumentDetails();
    }

    @When("the user selects the output rendering option from the menu")
    public void theUserSelectsTheOutputRenderingOptionFromTheMenu() {
        outputTypeZPBLPage.selectOutputRenderingOption();
    }

    @When("the user chooses Output Type {string} for rendering")
    public void theUserChoosesOutputTypeForRendering(String outputType) {
        outputTypeZPBLPage.chooseOutputType(outputType);
    }

    @Then("the system displays an error message {string} if Output Type {string} is not configured")
    public void theSystemDisplaysAnErrorMessageIfOutputTypeIsNotConfigured(String errorMessage, String outputType) {
        outputTypeZPBLPage.verifyErrorMessage(errorMessage, outputType);
    }

    @Then("the output rendering process does not proceed")
    public void theOutputRenderingProcessDoesNotProceed() {
        outputTypeZPBLPage.verifyRenderingProcessNotProceeded();
    }

    @Then("the system logs contain error messages related to Output Type {string}")
    public void theSystemLogsContainErrorMessagesRelatedToOutputType(String outputType) {
        outputTypeZPBLPage.verifyErrorLogs(outputType);
    }

    @Then("no output documents are created in the system")
    public void noOutputDocumentsAreCreatedInTheSystem() {
        outputTypeZPBLPage.verifyNoOutputDocumentsCreated();
    }

    @When("the user reconfigures Output Type ZPBL")
    public void theUserReconfiguresOutputTypeZPBL() {
        outputTypeZPBLPage.reconfigureOutputTypeZPBL();
    }

    @Then("the system accepts the configuration and allows rendering")
    public void theSystemAcceptsTheConfigurationAndAllowsRendering() {
        outputTypeZPBLPage.verifyRenderingAllowed();
    }

    @When("the user documents the error message and resolution steps for Output Type ZPBL configuration")
    public void theUserDocumentsTheErrorMessageAndResolutionStepsForOutputTypeZPBLConfiguration() {
        outputTypeZPBLPage.documentErrorMessageAndResolutionSteps();
    }

    @Then("the error message and resolution steps are documented successfully")
    public void theErrorMessageAndResolutionStepsAreDocumentedSuccessfully() {
        outputTypeZPBLPage.verifyDocumentationSuccess();
    }

    @When("the user logs out from the SAP system")
    public void theUserLogsOutFromTheSAPSystem() {
        outputTypeZPBLPage.logoutFromSAPSystem();
    }

    @Then("the user logs out successfully")
    public void theUserLogsOutSuccessfully() {
        outputTypeZPBLPage.verifyLogoutSuccess();
    }

    @When("the user chooses Output Type ZPBL for rendering")
    public void theUserChoosesOutputTypeZPBLForRendering() {
        outputTypeZPBLPage.chooseOutputTypeZPBL();
    }

    @Then("the system attempts to process the output rendering")
    public void theSystemAttemptsToProcessTheOutputRendering() {
        outputTypeZPBLPage.verifyOutputRenderingProcess();
    }

    @Then("the system adapts correctly to the updated configuration and processes rendering")
    public void theSystemAdaptsCorrectlyToTheUpdatedConfigurationAndProcessesRendering() {
        outputTypeZPBLPage.verifySystemAdaptationToConfiguration();
    }

    @Then("the output document is generated successfully with updated details")
    public void theOutputDocumentIsGeneratedSuccessfullyWithUpdatedDetails() {
        outputTypeZPBLPage.verifyOutputDocumentGeneration();
    }

    @Then("the system logs confirm successful rendering of Output Type ZPBL")
    public void theSystemLogsConfirmSuccessfulRenderingOfOutputTypeZPBL() {
        outputTypeZPBLPage.verifySystemLogsForRendering();
    }

    @When("the user reverts Output Type ZPBL configuration")
    public void theUserRevertsOutputTypeZPBLConfiguration() {
        outputTypeZPBLPage.revertOutputTypeZPBLConfiguration();
    }

    @When("the user repeats the rendering process for the same cancellation billing document {string}")
    public void theUserRepeatsTheRenderingProcessForTheSameCancellationBillingDocument(String documentNumber) {
        outputTypeZPBLPage.enterCancellationBillingDocumentNumber(documentNumber);
        outputTypeZPBLPage.executeTransaction();
        outputTypeZPBLPage.selectOutputRenderingOption();
        outputTypeZPBLPage.chooseOutputTypeZPBL();
    }

    @Then("the system adapts correctly to the reverted configuration")
    public void theSystemAdaptsCorrectlyToTheRevertedConfiguration() {
        outputTypeZPBLPage.verifySystemAdaptationToRevertedConfiguration();
    }

    @When("the user documents the configuration changes and rendering process for audit purposes")
    public void theUserDocumentsTheConfigurationChangesAndRenderingProcessForAuditPurposes() {
        outputTypeZPBLPage.documentConfigurationChangesAndRenderingProcess();
    }

    @Then("the configuration changes and rendering process are documented successfully")
    public void theConfigurationChangesAndRenderingProcessAreDocumentedSuccessfully() {
        outputTypeZPBLPage.verifyDocumentationSuccess();
    }
}
