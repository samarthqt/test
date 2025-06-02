package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrafficSimulationPage;

public class TrafficSimulationSteps extends TrafficSimulationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("access to the traffic simulation tool")
    public void accessToTheTrafficSimulationTool() {
        openTrafficSimulationTool();
    }

    @When("I set the user count to {int}")
    public void setUserCount(int userCount) {
        setUserCount(userCount);
    }

    @When("configure server load to {int}%")
    public void configureServerLoad(int loadPercentage) {
        setServerLoad(loadPercentage);
    }

    @When("open the application on the test device")
    public void openApplicationOnTestDevice() {
        openApplication();
    }

    @When("attempt to load the homepage of the application")
    public void attemptToLoadHomepage() {
        loadHomepage();
    }

    @Then("measure the time taken for the application to load the homepage")
    public void measureLoadTime() {
        measureHomepageLoadTime();
    }

    @Then("verify if the application loads within {int} seconds")
    public void verifyLoadTime(int seconds) {
        verifyLoadTimeWithin(seconds);
    }

    @Then("observe any error messages or loading indicators displayed")
    public void observeErrorsOrIndicators() {
        observeErrorsOrIndicators();
    }

    @Then("check the application's responsiveness during loading")
    public void checkResponsivenessDuringLoading() {
        checkResponsiveness();
    }

    @Then("log the results of the traffic simulation and application load time")
    public void logResults() {
        logSimulationResults();
    }

    @Then("reset traffic conditions to normal")
    public void resetTrafficConditions() {
        resetTrafficConditions();
    }

    @Then("analyze the impact of each traffic condition on application load time")
    public void analyzeImpact() {
        analyzeTrafficImpact();
    }

    @Then("document any discrepancies or issues found during testing")
    public void documentDiscrepancies() {
        documentIssues();
    }

    @Then("provide recommendations for maintaining application load speed under peak traffic conditions")
    public void provideRecommendations() {
        provideLoadSpeedRecommendations();
    }

    @Then("ensure the application performs optimally under simulated peak traffic conditions")
    public void ensureOptimalPerformance() {
        ensureOptimalPerformance();
    }
}