package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.OutputTypePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class OutputTypeSteps extends OutputTypePage {

    @Given("user has valid credentials")
    public void userHasValidCredentials() {
        enterCredentials("validUsername", "validPassword");
    }

    @When("user logs in to the SAP S/4HANA system")
    public void userLogsInToTheSAPSystem() {
        clickLoginButton();
    }

    @Then("user is successfully logged in and navigates to the SAP home screen")
    public void userIsSuccessfullyLoggedIn() {
        verifyHomeScreenNavigation("SAP Home Screen");
    }

    @Given("cancellation billing document number {string} exists")
    public void cancellationBillingDocumentExists(String documentNumber) {
        verifyDocumentExistence(documentNumber);
    }

    @When("user navigates to transaction VF03")
    public void userNavigatesToTransactionVF03() {
        navigateToTransactionVF03();
    }

    @Then("cancellation billing document details are displayed with Output Type {string}")
    public void cancellationBillingDocumentDetailsDisplayed(String outputType) {
        verifyDocumentDetails(outputType);
    }

    @Given("Output Type {string} is configured incorrectly in the system")
    public void outputTypeConfiguredIncorrectly(String outputType) {
        verifyIncorrectConfiguration(outputType);
    }

    @When("user executes the output rendering process using Output Type {string}")
    public void userExecutesOutputRenderingProcess(String outputType) {
        executeRenderingProcess(outputType);
    }

    @Then("system attempts to execute the rendering process using print program {string}")
    public void systemAttemptsRenderingProcess(String printProgram) {
        verifyPrintProgramExecution(printProgram);
    }

    @Given("user attempts rendering process with Output Type {Output Type}")
    public void userAttemptsRenderingProcess(String outputType) {
        attemptRenderingProcess(outputType);
    }

    @When("system detects incorrect configuration")
    public void systemDetectsIncorrectConfiguration() {
        detectIncorrectConfiguration();
    }

    @Then("system displays error messages indicating {Error Message}")
    public void systemDisplaysErrorMessages(String errorMessage) {
        verifyErrorMessage(errorMessage);
    }

    @Then("system logs contain detailed information about {Log Details}")
    public void systemLogsContainDetailedInformation(String logDetails) {
        verifyLogDetails(logDetails);
    }

    @Then("rendering process is halted and no output is generated")
    public void renderingProcessHalted() {
        verifyRenderingProcessHalted();
    }

    @Then("user is notified about the error via system prompts")
    public void userNotifiedAboutError() {
        verifyErrorNotification();
    }

    @Then("system provides guidance for correcting the Output Type configuration")
    public void systemProvidesGuidance() {
        verifyGuidanceProvided();
    }

    @Given("system logs contain detailed error information")
    public void systemLogsContainErrorInformation() {
        verifyErrorLogsExist();
    }

    @When("user saves error logs")
    public void userSavesErrorLogs() {
        saveErrorLogs();
    }

    @Then("error logs are saved successfully")
    public void errorLogsSavedSuccessfully() {
        verifyErrorLogsSaved();
    }

    @Given("rendering process is halted due to the error")
    public void renderingProcessHaltedDueToError() {
        verifyRenderingProcessHalted();
    }

    @When("user checks for invalid outputs")
    public void userChecksForInvalidOutputs() {
        checkInvalidOutputs();
    }

    @Then("no invalid outputs are generated")
    public void noInvalidOutputsGenerated() {
        verifyNoInvalidOutputs();
    }

    @Given("system provides guidance for correcting the Output Type configuration")
    public void systemProvidesGuidanceForCorrection() {
        verifyGuidanceProvided();
    }

    @When("user attempts to reconfigure Output Type")
    public void userAttemptsReconfiguration() {
        reconfigureOutputType();
    }

    @Then("system allows reconfiguration of Output Type")
    public void systemAllowsReconfiguration() {
        verifyReconfigurationAllowed();
    }

    @Given("Output Type configuration is corrected")
    public void outputTypeConfigurationCorrected() {
        verifyConfigurationCorrected();
    }

    @When("user reattempts the rendering process")
    public void userReattemptsRenderingProcess() {
        reattemptRenderingProcess();
    }

    @Then("rendering process is successfully executed")
    public void renderingProcessSuccessfullyExecuted() {
        verifyRenderingProcessSuccess();
    }
}