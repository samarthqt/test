package com.cucumber.steps;

import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.pageobjects.JobMonitoringPage;
import com.framework.cucumber.TestHarness;

public class JobMonitoringSteps {

    private JobMonitoringPage jobMonitoringPage = new JobMonitoringPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        jobMonitoringPage.navigateToLoginPage();
        jobMonitoringPage.enterCredentials("validUsername", "validPassword");
        jobMonitoringPage.clickLoginButton();
    }

    @When("the user logs in to the SAP S/4HANA system")
    public void theUserLogsInToTheSAPSystem() {
        jobMonitoringPage.verifyDashboardAccess();
    }

    @Then("the user successfully accesses the dashboard")
    public void theUserSuccessfullyAccessesTheDashboard() {
        jobMonitoringPage.verifyDashboardAccess();
    }

    @Given("the user is logged in to the SAP S/4HANA system")
    public void theUserIsLoggedInToTheSAPSystem() {
        jobMonitoringPage.verifyDashboardAccess();
    }

    @When("the user navigates to the Job Monitoring module")
    public void theUserNavigatesToTheJobMonitoringModule() {
        jobMonitoringPage.navigateToJobMonitoringModule();
    }

    @Then("the Job Monitoring module is displayed with all scheduled jobs")
    public void theJobMonitoringModuleIsDisplayedWithAllScheduledJobs() {
        jobMonitoringPage.verifyJobMonitoringModule();
    }

    @Given("the user is in the Job Monitoring module")
    public void theUserIsInTheJobMonitoringModule() {
        jobMonitoringPage.verifyJobMonitoringModule();
    }

    @When("the user searches for the job using the job name {string}")
    public void theUserSearchesForTheJobUsingTheJobName(String jobName) {
        jobMonitoringPage.searchJobByName(jobName);
    }

    @Then("the job details are displayed, including its schedule and status")
    public void theJobDetailsAreDisplayedIncludingItsScheduleAndStatus() {
        jobMonitoringPage.verifyJobDetails();
    }

    @Given("the daily extraction job is displayed in the Job Monitoring module")
    public void theDailyExtractionJobIsDisplayedInTheJobMonitoringModule() {
        jobMonitoringPage.verifyJobDetails();
    }

    @When("the user triggers the job execution")
    public void theUserTriggersTheJobExecution() {
        jobMonitoringPage.triggerJobExecution();
    }

    @Then("the job execution starts successfully")
    public void theJobExecutionStartsSuccessfully() {
        jobMonitoringPage.verifyJobExecutionStart();
    }

    @Given("the daily extraction job execution has started")
    public void theDailyExtractionJobExecutionHasStarted() {
        jobMonitoringPage.verifyJobExecutionStart();
    }

    @When("the user monitors the job execution logs")
    public void theUserMonitorsTheJobExecutionLogs() {
        jobMonitoringPage.monitorJobExecutionLogs();
    }

    @Then("the performance metrics are logged, showing processing time and resource utilization")
    public void thePerformanceMetricsAreLoggedShowingProcessingTimeAndResourceUtilization() {
        jobMonitoringPage.verifyPerformanceMetrics();
    }

    @Given("the daily extraction job execution logs are available")
    public void theDailyExtractionJobExecutionLogsAreAvailable() {
        jobMonitoringPage.verifyPerformanceMetrics();
    }

    @When("the user verifies the system processes {string} without errors")
    public void theUserVerifiesTheSystemProcessesCapacityWithoutErrors(String capacity) {
        jobMonitoringPage.verifyJobProcessingCapacity(capacity);
    }

    @Then("the record is processed successfully")
    public void theRecordIsProcessedSuccessfully() {
        jobMonitoringPage.verifyRecordProcessing();
    }

    @Then("the resource utilization remains minimal")
    public void theResourceUtilizationRemainsMinimal() {
        jobMonitoringPage.verifyResourceUtilization();
    }

    @Given("the daily extraction job execution is completed")
    public void theDailyExtractionJobExecutionIsCompleted() {
        jobMonitoringPage.verifyJobCompletion();
    }

    @When("the user validates the system's response time and throughput")
    public void theUserValidatesTheSystemsResponseTimeAndThroughput() {
        jobMonitoringPage.validateResponseTimeAndThroughput();
    }

    @Then("the response time and throughput meet expected thresholds")
    public void theResponseTimeAndThroughputMeetExpectedThresholds() {
        jobMonitoringPage.verifyResponseTimeAndThroughput();
    }

    @Given("the performance metrics and resource utilization findings are available")
    public void thePerformanceMetricsAndResourceUtilizationFindingsAreAvailable() {
        jobMonitoringPage.verifyPerformanceMetrics();
    }

    @When("the user documents the findings")
    public void theUserDocumentsTheFindings() {
        jobMonitoringPage.documentPerformanceMetrics();
    }

    @Then("the documentation is completed, highlighting system performance at minimum capacity")
    public void theDocumentationIsCompletedHighlightingSystemPerformanceAtMinimumCapacity() {
        jobMonitoringPage.verifyDocumentationCompletion();
    }

    @Given("the performance metrics for the daily extraction job are documented")
    public void thePerformanceMetricsForTheDailyExtractionJobAreDocumented() {
        jobMonitoringPage.verifyDocumentationCompletion();
    }

    @When("the user compares the metrics against baseline values")
    public void theUserComparesTheMetricsAgainstBaselineValues() {
        jobMonitoringPage.compareMetricsWithBaseline();
    }

    @Then("the performance metrics align with baseline values, indicating efficient handling")
    public void thePerformanceMetricsAlignWithBaselineValuesIndicatingEfficientHandling() {
        jobMonitoringPage.verifyMetricsAlignment();
    }

    @Given("the daily extraction job is executing at minimum capacity")
    public void theDailyExtractionJobIsExecutingAtMinimumCapacity() {
        jobMonitoringPage.verifyJobExecutionStart();
    }

    @When("the user validates the system's ability to handle concurrent jobs")
    public void theUserValidatesTheSystemsAbilityToHandleConcurrentJobs() {
        jobMonitoringPage.validateConcurrentJobExecution();
    }

    @Then("the concurrent jobs execute successfully without impacting the daily extraction job")
    public void theConcurrentJobsExecuteSuccessfullyWithoutImpactingTheDailyExtractionJob() {
        jobMonitoringPage.verifyConcurrentJobExecution();
    }

    @Given("the user has completed all tasks in the SAP S/4HANA system")
    public void theUserHasCompletedAllTasksInTheSAPSystem() {
        jobMonitoringPage.verifyAllTasksCompletion();
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        jobMonitoringPage.clickLogoutButton();
    }

    @Then("the user successfully logs out")
    public void theUserSuccessfullyLogsOut() {
        jobMonitoringPage.verifyLogoutSuccess();
    }
}
