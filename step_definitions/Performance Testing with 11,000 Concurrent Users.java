package com.cucumber.steps;

import com.page_objects.PerformanceTestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PerformanceTestSteps extends PerformanceTestPage {

    @Given("access to the application under test")
    public void accessToTheApplicationUnderTest() {
        launchApplication();
    }

    @When("I access the user simulation tool")
    public void iAccessTheUserSimulationTool() {
        openUserSimulationTool();
    }

    @When("I set the concurrent user count to {int}")
    public void iSetTheConcurrentUserCountTo(int userCount) {
        setConcurrentUserCount(userCount);
    }

    @Then("the concurrent user count is set to {int}")
    public void theConcurrentUserCountIsSetTo(int userCount) {
        verifyConcurrentUserCount(userCount);
    }

    @When("I open the application on the test device")
    public void iOpenTheApplicationOnTheTestDevice() {
        openApplicationOnTestDevice();
    }

    @When("I attempt to perform various operations such as login, navigation, and data retrieval")
    public void iAttemptToPerformVariousOperations() {
        performOperations();
    }

    @Then("operations are attempted")
    public void operationsAreAttempted() {
        verifyOperationsAttempted();
    }

    @Then("measure the response time for each operation")
    public void measureTheResponseTimeForEachOperation() {
        measureResponseTime();
    }

    @Then("verify if performance metrics exceed acceptable limits")
    public void verifyIfPerformanceMetricsExceedAcceptableLimits() {
        checkPerformanceMetrics();
    }

    @Then("observe any error messages or performance issues")
    public void observeAnyErrorMessagesOrPerformanceIssues() {
        observeErrorsOrIssues();
    }

    @Then("check the application's responsiveness during the test")
    public void checkTheApplicationsResponsivenessDuringTheTest() {
        checkApplicationResponsiveness();
    }

    @Then("log the results of the user simulation and application performance")
    public void logTheResultsOfTheUserSimulationAndApplicationPerformance() {
        logResults();
    }

    @When("I reset user simulation conditions to normal")
    public void iResetUserSimulationConditionsToNormal() {
        resetSimulationConditions();
    }

    @Then("repeat the test with different user counts")
    public void repeatTheTestWithDifferentUserCounts() {
        repeatTestWithDifferentUserCounts();
    }

    @Then("analyze the impact of each user count on application performance")
    public void analyzeTheImpactOfEachUserCountOnApplicationPerformance() {
        analyzeImpact();
    }

    @Then("document any discrepancies or issues found during testing")
    public void documentAnyDiscrepanciesOrIssuesFoundDuringTesting() {
        documentDiscrepancies();
    }

    @Then("provide recommendations for improving application performance under high user load")
    public void provideRecommendationsForImprovingApplicationPerformance() {
        provideRecommendations();
    }

    @Then("ensure the application performs optimally despite exceeding acceptable limits")
    public void ensureTheApplicationPerformsOptimally() {
        ensureOptimalPerformance();
    }
}