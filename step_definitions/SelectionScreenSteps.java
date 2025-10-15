package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.SelectionScreenPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SelectionScreenSteps extends SelectionScreenPage {

    @Given("the user logs into SAP S/4HANA with valid credentials")
    public void theUserLogsIntoSAP() {
        loginToSAP();
    }

    @Given("the user navigates to the selection screen for the background job execution")
    public void theUserNavigatesToSelectionScreen() {
        navigateToSelectionScreen();
    }

    @When("the user provides the following mandatory parameters:")
    public void theUserProvidesMandatoryParameters(io.cucumber.datatable.DataTable dataTable) {
        provideMandatoryParameters(dataTable);
    }

    @Then("the system displays the appropriate message {string}")
    public void theSystemDisplaysAppropriateMessage(String expectedMessage) {
        verifySystemMessage(expectedMessage);
    }

    @Then("the system logs record the corresponding details with timestamps")
    public void theSystemLogsRecordDetails() {
        verifySystemLogs();
    }

    @When("the user provides all mandatory parameters")
    public void theUserProvidesAllMandatoryParameters() {
        provideAllMandatoryParameters();
    }

    @Then("the background job executes successfully")
    public void theBackgroundJobExecutesSuccessfully() {
        verifyJobExecutionSuccess();
    }

    @Then("the system logs indicate clean execution with no errors")
    public void theSystemLogsIndicateCleanExecution() {
        verifyCleanExecutionLogs();
    }

    @Then("the processed data is accurate and complete in S/4HANA")
    public void theProcessedDataIsAccurate() {
        verifyProcessedDataAccuracy();
    }

    @Given("the user attempts to execute the background job with missing mandatory parameters")
    public void theUserAttemptsWithMissingParameters() {
        attemptJobExecutionWithMissingParameters();
    }

    @Then("no changes are made to Customer or Site Master Data")
    public void noChangesMadeToMasterData() {
        verifyNoChangesToMasterData();
    }

    @Then("the system logs confirm no processing occurred during failed attempts")
    public void theSystemLogsConfirmNoProcessing() {
        verifyNoProcessingLogs();
    }

    @Given("the user provides all mandatory parameters after initial failed attempts")
    public void theUserProvidesParametersAfterFailedAttempts() {
        provideParametersAfterFailedAttempts();
    }

    @When("the user executes the background job")
    public void theUserExecutesTheBackgroundJob() {
        executeBackgroundJob();
    }

    @Then("the background job proceeds without errors")
    public void theBackgroundJobProceedsWithoutErrors() {
        verifyJobProceedsWithoutErrors();
    }

    @Then("the system logs indicate clean execution post-parameter correction")
    public void theSystemLogsIndicateCleanExecutionPostCorrection() {
        verifyCleanExecutionLogsPostCorrection();
    }
}