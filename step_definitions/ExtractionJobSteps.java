package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.ExtractionJobPage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class ExtractionJobSteps extends ExtractionJobPage {

    @Given("the user has appropriate credentials")
    public void theUserHasAppropriateCredentials() {
        verifyUserCredentials();
    }

    @When("the user logs in to the SAP S/4 HANA Cloud system")
    public void theUserLogsInToTheSAPCloudSystem() {
        loginToSAPCloud();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifySuccessfulLogin();
    }

    @Then("the user has access to the relevant modules")
    public void theUserHasAccessToRelevantModules() {
        verifyModuleAccess();
    }

    @Given("the user is logged in to the SAP S/4 HANA Cloud system")
    public void theUserIsLoggedInToTheSAPCloudSystem() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the daily extraction job schedule")
    public void theUserNavigatesToDailyExtractionJobSchedule() {
        navigateToExtractionJobSchedule();
    }

    @Then("the daily extraction job is found to be inactive")
    public void theDailyExtractionJobIsFoundToBeInactive() {
        verifyExtractionJobInactive();
    }

    @Given("the system supports data simulation")
    public void theSystemSupportsDataSimulation() {
        verifyDataSimulationSupport();
    }

    @When("the user generates simulated direct sales data near the system's maximum capacity")
    public void theUserGeneratesSimulatedDirectSalesData() {
        generateSimulatedSalesData();
    }

    @Then("simulated data is generated successfully")
    public void simulatedDataIsGeneratedSuccessfully() {
        verifySimulatedDataGeneration();
    }

    @Given("the daily extraction job is inactive")
    public void theDailyExtractionJobIsInactive() {
        verifyExtractionJobInactive();
    }

    @When("the user monitors the system logs")
    public void theUserMonitorsSystemLogs() {
        monitorSystemLogs();
    }

    @Then("the system logs confirm that no extraction job was triggered")
    public void systemLogsConfirmNoExtractionJobTriggered() {
        verifyNoExtractionJobTriggeredInLogs();
    }

    @When("the user attempts to trigger the daily extraction job")
    public void theUserAttemptsToTriggerDailyExtractionJob() {
        attemptToTriggerExtractionJob();
    }

    @Then("the system does not allow the extraction job to be triggered")
    public void systemDoesNotAllowExtractionJobToBeTriggered() {
        verifyTriggerRestriction();
    }

    @Then("the system displays the error message {string}")
    public void systemDisplaysErrorMessage(String errorMessage) {
        verifyErrorMessage(errorMessage);
    }

    @Given("the user attempts to trigger the inactive daily extraction job")
    public void theUserAttemptsToTriggerInactiveDailyExtractionJob() {
        attemptToTriggerInactiveJob();
    }

    @When("the error message is displayed")
    public void errorMessageIsDisplayed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the error message clearly indicates that the extraction job is inactive")
    public void errorMessageIndicatesInactiveJob() {
        verifyInactiveJobErrorMessage();
    }

    @Then("the system provides an option to activate the extraction job directly from the error message screen")
    public void systemProvidesOptionToActivateJob() {
        verifyActivationOptionFromErrorMessage();
    }

    @When("the user activates the extraction job from the error message screen")
    public void userActivatesExtractionJobFromErrorMessage() {
        activateExtractionJobFromErrorMessage();
    }

    @When("the user re-triggers the extraction process")
    public void userReTriggersExtractionProcess() {
        reTriggerExtractionProcess();
    }

    @Then("the extraction job is activated successfully")
    public void extractionJobActivatedSuccessfully() {
        verifyExtractionJobActivation();
    }

    @Then("the process can be re-triggered")
    public void processCanBeReTriggered() {
        verifyProcessReTrigger();
    }

    @When("the user interacts with the system")
    public void userInteractsWithSystem() {
        interactWithSystem();
    }

    @Then("the system handles the error gracefully without crashing or freezing")
    public void systemHandlesErrorGracefully() {
        verifyErrorHandlingMechanism();
    }

    @When("the user checks the data transmission to Model N")
    public void userChecksDataTransmissionToModelN() {
        checkDataTransmissionToModelN();
    }

    @Then("no data is transmitted to Model N during the inactive job status")
    public void noDataTransmittedToModelN() {
        verifyNoDataTransmissionToModelN();
    }

    @When("the user logs in to Model N")
    public void userLogsInToModelN() {
        loginToModelN();
    }

    @Then("Model N does not display any data processing activity")
    public void modelNDisplaysNoDataProcessingActivity() {
        verifyNoDataProcessingInModelN();
    }

    @Given("the test for the inactive daily extraction job is completed")
    public void testForInactiveJobCompleted() {
        completeTestForInactiveJob();
    }

    @When("the user documents the results")
    public void userDocumentsResults() {
        documentTestResults();
    }

    @Then("the test results highlight the system's behavior when the job is inactive")
    public void testResultsHighlightSystemBehavior() {
        verifyTestResultsHighlightBehavior();
    }
}