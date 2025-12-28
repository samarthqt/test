package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.SAPJobMonitoringPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class SAPJobMonitoringSteps extends SAPJobMonitoringPage {

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        validateCredentials();
    }

    @When("the user logs in to the SAP S/4HANA system")
    public void theUserLogsInToTheSAPSystem() {
        loginToSAPSystem();
    }

    @Then("the user is successfully logged in and accesses the dashboard")
    public void theUserAccessesTheDashboard() {
        verifyDashboardAccess();
    }

    @Given("the user is logged in to the SAP S/4HANA system")
    public void theUserIsLoggedInToTheSAPSystem() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the Job Monitoring module")
    public void theUserNavigatesToJobMonitoringModule() {
        navigateToJobMonitoringModule();
    }

    @Then("the Job Monitoring module is displayed with all scheduled jobs")
    public void theJobMonitoringModuleIsDisplayed() {
        verifyJobMonitoringModule();
    }

    @Given("the Job Monitoring module is displayed")
    public void theJobMonitoringModuleIsDisplayed() {
        verifyJobMonitoringModule();
    }

    @When("the user searches for the job using the job name \"Daily_Extraction_Job\"")
    public void theUserSearchesForTheJob() {
        searchJobByName("Daily_Extraction_Job");
    }

    @Then("the job details are displayed, including its schedule and status")
    public void theJobDetailsAreDisplayed() {
        verifyJobDetails();
    }

    @Given("the daily extraction job details are displayed")
    public void theDailyExtractionJobDetailsAreDisplayed() {
        verifyJobDetails();
    }

    @When("the user manually triggers the job execution")
    public void theUserManuallyTriggersTheJobExecution() {
        triggerJobExecution();
    }

    @Then("the job execution starts successfully")
    public void theJobExecutionStartsSuccessfully() {
        verifyJobExecutionStart();
    }

    @Given("the job execution has started")
    public void theJobExecutionHasStarted() {
        verifyJobExecutionStart();
    }

    @When("the user introduces a simulated failure by disconnecting the network")
    public void theUserIntroducesSimulatedFailure() {
        simulateNetworkDisconnection();
    }

    @Then("the network disconnection occurs, simulating a failure scenario")
    public void theNetworkDisconnectionOccurs() {
        verifyNetworkDisconnection();
    }

    @Given("a simulated failure has been introduced")
    public void aSimulatedFailureHasBeenIntroduced() {
        verifyNetworkDisconnection();
    }

    @When("the user monitors the job execution logs")
    public void theUserMonitorsTheJobExecutionLogs() {
        monitorJobLogs();
    }

    @Then("error messages related to the network failure are logged")
    public void errorMessagesAreLogged() {
        verifyErrorLogs();
    }

    @Given("error messages are logged for the simulated failure")
    public void errorMessagesAreLoggedForSimulatedFailure() {
        verifyErrorLogs();
    }

    @When("the system detects the failure")
    public void theSystemDetectsTheFailure() {
        detectFailure();
    }

    @Then("notifications or alerts are sent to the responsible team")
    public void notificationsAreSent() {
        verifyNotificationsSent();
    }

    @Given("the job execution has failed due to the simulated failure")
    public void theJobExecutionHasFailed() {
        verifyJobFailure();
    }

    @When("the user checks the job status")
    public void theUserChecksTheJobStatus() {
        checkJobStatus();
    }

    @Then("the job status is updated to \"Failed\"")
    public void theJobStatusIsUpdatedToFailed() {
        verifyJobStatus("Failed");
    }

    @Given("the job status is \"Failed\"")
    public void theJobStatusIsFailed() {
        verifyJobStatus("Failed");
    }

    @When("the user resolves the simulated failure by reconnecting the network")
    public void theUserResolvesTheSimulatedFailure() {
        resolveNetworkDisconnection();
    }

    @Then("the network connectivity is restored")
    public void theNetworkConnectivityIsRestored() {
        verifyNetworkRestoration();
    }

    @Given("the network connectivity is restored")
    public void theNetworkConnectivityIsRestored() {
        verifyNetworkRestoration();
    }

    @When("the user attempts to re-run the job manually")
    public void theUserAttemptsToReRunTheJob() {
        triggerJobExecution();
    }

    @Then("the job execution starts successfully")
    public void theJobExecutionStartsSuccessfully() {
        verifyJobExecutionStart();
    }

    @Given("the job execution has been re-run")
    public void theJobExecutionHasBeenReRun() {
        verifyJobExecutionStart();
    }

    @When("the user monitors the logs")
    public void theUserMonitorsTheLogs() {
        monitorJobLogs();
    }

    @Then("the logs show successful execution of the job")
    public void theLogsShowSuccessfulExecution() {
        verifySuccessfulExecutionLogs();
    }

    @Given("the job execution is successful")
    public void theJobExecutionIsSuccessful() {
        verifyJobExecutionSuccess();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOutOfTheSAPSystem() {
        logoutFromSAPSystem();
    }

    @Then("the user successfully logs out")
    public void theUserSuccessfullyLogsOut() {
        verifyLogout();
    }
}