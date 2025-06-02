package com.cucumber.steps;

import com.page_objects.NetworkSimulationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NetworkSimulationSteps extends NetworkSimulationPage {

    @Given("access to the network simulation tool")
    public void accessToNetworkSimulationTool() {
        openNetworkSimulationTool();
    }

    @When("I set the network speed to {string}")
    public void setNetworkSpeed(String networkSpeed) {
        configureNetworkSpeed(networkSpeed);
    }

    @When("I configure network latency to {string}")
    public void configureNetworkLatency(String networkLatency) {
        setNetworkLatency(networkLatency);
    }

    @When("I set packet loss to {string}")
    public void setPacketLoss(String packetLoss) {
        configurePacketLoss(packetLoss);
    }

    @When("I open the application on the test device")
    public void openApplicationOnTestDevice() {
        launchApplication();
    }

    @When("I attempt to load the homepage of the application")
    public void attemptToLoadHomepage() {
        loadHomepage();
    }

    @Then("I measure the time taken for the application to load the homepage")
    public void measureLoadTime() {
        recordLoadTime();
    }

    @Then("I verify if the application does not load within 3 seconds")
    public void verifyLoadTime() {
        assertLoadTimeWithinLimit(3);
    }

    @Then("I observe any error messages or loading indicators displayed")
    public void observeErrorMessages() {
        checkForErrorMessages();
    }

    @Then("I check the application's responsiveness during loading")
    public void checkApplicationResponsiveness() {
        evaluateResponsiveness();
    }

    @Then("I log the results of the network simulation and application load time")
    public void logResults() {
        logSimulationResults();
    }

    @Then("I reset network conditions to normal")
    public void resetNetworkConditions() {
        resetNetworkSettings();
    }

    @Then("I analyze the impact of each network condition on application load time")
    public void analyzeImpact() {
        analyzeNetworkImpact();
    }

    @Then("I document any discrepancies or issues found during testing")
    public void documentDiscrepancies() {
        documentIssues();
    }

    @Then("I provide recommendations for improving application load time under poor network conditions")
    public void provideRecommendations() {
        suggestImprovements();
    }
}