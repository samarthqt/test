package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.pageobjects.NotificationFailurePage;
import io.cucumber.java.en.Then;
import com.framework.cucumber.TestHarness;

public class NotificationFailureSteps extends NotificationFailurePage {

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        enterCredentials("validUsername", "validPassword");
    }

    @When("the user logs into the SAP S/4HANA system")
    public void theUserLogsIntoTheSAPSystem() {
        clickLoginButton();
    }

    @Then("the user successfully accesses the dashboard")
    public void theUserSuccessfullyAccessesTheDashboard() {
        verifyDashboardAccess();
    }

    @Given("the notification settings are configured in the system")
    public void theNotificationSettingsAreConfigured() {
        verifyNotificationSettings();
    }

    @When("the user navigates to the Job Monitoring module")
    public void theUserNavigatesToJobMonitoringModule() {
        navigateToJobMonitoring();
    }

    @Then("the Job Monitoring module is displayed with all scheduled jobs")
    public void theJobMonitoringModuleIsDisplayed() {
        verifyJobMonitoringDisplay();
    }

    @Given("the Job Monitoring module is displayed")
    public void theJobMonitoringModuleIsDisplayed() {
        verifyJobMonitoringDisplay();
    }

    @When("the user searches for the job using the job name {string}")
    public void theUserSearchesForTheJob(String jobName) {
        searchJobByName(jobName);
    }

    @Then("the job details are displayed, including its schedule and status")
    public void theJobDetailsAreDisplayed() {
        verifyJobDetails();
    }

    @Given("the job details are displayed")
    public void theJobDetailsAreDisplayed() {
        verifyJobDetails();
    }

    @When("the user manually triggers the job execution")
    public void theUserManuallyTriggersJobExecution() {
        triggerJobExecution();
    }

    @Then("the job execution starts successfully")
    public void theJobExecutionStartsSuccessfully() {
        verifyJobExecutionStart();
    }

    @Given("the email server is available")
    public void theEmailServerIsAvailable() {
        verifyEmailServerAvailability();
    }

    @When("the user introduces a simulated failure by making the email server unavailable")
    public void theUserSimulatesEmailServerFailure() {
        simulateEmailServerFailure();
    }

    @Then("email server unavailability occurs, simulating a notification failure scenario")
    public void emailServerUnavailabilityOccurs() {
        verifyEmailServerUnavailability();
    }

    @Given("the email server is unavailable during job execution")
    public void theEmailServerIsUnavailableDuringJobExecution() {
        verifyEmailServerUnavailability();
    }

    @When("the user monitors the job execution logs")
    public void theUserMonitorsJobExecutionLogs() {
        monitorJobExecutionLogs();
    }

    @Then("error messages related to notification failure are logged")
    public void errorMessagesAreLogged() {
        verifyErrorMessagesInLogs();
    }

    @When("the user verifies the system's notification attempts")
    public void theUserVerifiesNotificationAttempts() {
        verifyNotificationAttempts();
    }

    @Then("the system attempts to send notifications but encounters errors")
    public void theSystemAttemptsNotifications() {
        verifyNotificationErrors();
    }

    @Given("the system encounters notification errors")
    public void theSystemEncountersNotificationErrors() {
        verifyNotificationErrors();
    }

    @When("the user checks the system logs")
    public void theUserChecksSystemLogs() {
        checkSystemLogs();
    }

    @Then("detailed error messages about the notification failure are logged, indicating the cause of the failure")
    public void detailedErrorMessagesAreLogged() {
        verifyDetailedErrorMessages();
    }

    @Given("the email server is unavailable")
    public void theEmailServerIsUnavailable() {
        verifyEmailServerUnavailability();
    }

    @When("the user resolves the simulated email server failure")
    public void theUserResolvesEmailServerFailure() {
        resolveEmailServerFailure();
    }

    @Then("the email server availability is restored")
    public void theEmailServerAvailabilityIsRestored() {
        verifyEmailServerRestoration();
    }

    @Given("the email server availability is restored")
    public void theEmailServerAvailabilityIsRestored() {
        verifyEmailServerRestoration();
    }

    @When("the user attempts to re-send the notifications manually")
    public void theUserResendsNotifications() {
        resendNotifications();
    }

    @Then("the notifications are sent successfully")
    public void theNotificationsAreSentSuccessfully() {
        verifyNotificationSuccess();
    }

    @Given("the notifications are sent successfully")
    public void theNotificationsAreSentSuccessfully() {
        verifyNotificationSuccess();
    }

    @When("the user monitors the logs")
    public void theUserMonitorsLogs() {
        monitorLogs();
    }

    @Then("the logs show successful delivery of notifications")
    public void theLogsShowSuccessfulDelivery() {
        verifySuccessfulDeliveryLogs();
    }

    @Given("the user has completed their tasks")
    public void theUserHasCompletedTasks() {
        verifyTaskCompletion();
    }

    @When("the user logs out of the SAP S/4HANA system")
    public void theUserLogsOut() {
        clickLogoutButton();
    }

    @Then("the user successfully logs out")
    public void theUserSuccessfullyLogsOut() {
        verifyLogoutSuccess();
    }
}