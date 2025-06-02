import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoadTestingPage from "../pages/loadTestingPage";

Given("the load testing tool is available", () => {
 LoadTestingPage.checkToolAvailability();
});

When("I configure the load testing tool for peak load simulation", () => {
 LoadTestingPage.configureForPeakLoad();
});

Then("the load testing tool is ready for peak load simulation", () => {
 LoadTestingPage.verifyToolReady();
});

Given("the load testing tool is configured for peak load simulation", () => {
 LoadTestingPage.verifyConfiguration();
});

When("I start the simulation with peak load traffic", () => {
 LoadTestingPage.startSimulation();
});

Then("peak load traffic is simulated as per the configuration", () => {
 LoadTestingPage.verifySimulation();
});

And("baseline performance metrics are established", () => {
 LoadTestingPage.establishBaselineMetrics();
});

Given("peak load traffic is being simulated", () => {
 LoadTestingPage.verifyPeakLoadSimulation();
});

When("I monitor the application performance metrics", () => {
 LoadTestingPage.monitorPerformanceMetrics();
});

Then("the application performance metrics are displayed and recorded", () => {
 LoadTestingPage.verifyMetricsDisplayed();
});

Given("the application performance metrics are being monitored", () => {
 LoadTestingPage.verifyMetricsMonitoring();
});

When("I verify the application's scalability", () => {
 LoadTestingPage.verifyScalability();
});

Then("the application scales up to accommodate peak load without performance degradation", () => {
 LoadTestingPage.verifyScalabilitySuccess();
});

Given("the application is handling peak load", () => {
 LoadTestingPage.verifyHandlingPeakLoad();
});

When("I check the application response time", () => {
 LoadTestingPage.checkResponseTime();
});

Then("the application response time remains within acceptable limits", () => {
 LoadTestingPage.verifyResponseTimeLimits();
});

Given("performance metrics are being recorded", () => {
 LoadTestingPage.verifyMetricsRecording();
});

When("I document the performance metrics", () => {
 LoadTestingPage.documentMetrics();
});

Then("the performance metrics are documented for analysis", () => {
 LoadTestingPage.verifyMetricsDocumentation();
});

When("I check for critical errors or alerts", () => {
 LoadTestingPage.checkForErrors();
});

Then("no critical errors or alerts are generated during peak load", () => {
 LoadTestingPage.verifyNoErrors();
});

When("I assess the user experience", () => {
 LoadTestingPage.assessUserExperience();
});

Then("the user experience remains positive with no noticeable lag or issues", () => {
 LoadTestingPage.verifyUserExperience();
});

Given("peak load conditions have been simulated", () => {
 LoadTestingPage.verifyPeakLoadConditions();
});

When("I reduce the load gradually", () => {
 LoadTestingPage.reduceLoadGradually();
});

Then("the load is reduced gradually as per the configuration", () => {
 LoadTestingPage.verifyLoadReduction();
});

Given("the load is being reduced", () => {
 LoadTestingPage.verifyLoadReductionInProgress();
});

When("I observe the application's behavior", () => {
 LoadTestingPage.observeApplicationBehavior();
});

Then("the application scales down appropriately as the load decreases", () => {
 LoadTestingPage.verifyScalingDown();
});

Given("the load has been reduced", () => {
 LoadTestingPage.verifyLoadReductionComplete();
});

When("I verify the application's performance metrics", () => {
 LoadTestingPage.verifyPerformanceMetrics();
});

Then("the application performance returns to baseline levels after load normalization", () => {
 LoadTestingPage.verifyBaselinePerformance();
});

Given("performance metrics have been recorded", () => {
 LoadTestingPage.verifyMetricsRecorded();
});

When("I analyze the performance metrics", () => {
 LoadTestingPage.analyzeMetrics();
});

Then("no significant anomalies are detected", () => {
 LoadTestingPage.verifyNoAnomalies();
});

Given("peak load conditions are being simulated", () => {
 LoadTestingPage.verifyPeakLoadSimulationActive();
});

When("I test the application functionality", () => {
 LoadTestingPage.testFunctionality();
});

Then("the application functions correctly and efficiently under peak load conditions", () => {
 LoadTestingPage.verifyFunctionalityUnderLoad();
});

When("I verify the scalability mechanisms", () => {
 LoadTestingPage.verifyScalabilityMechanisms();
});

Then("the scalability mechanisms are effective in handling peak load conditions", () => {
 LoadTestingPage.verifyMechanismsEffectiveness();
});

Given("the scalability tests have been completed", () => {
 LoadTestingPage.verifyTestsCompletion();
});

When("I prepare the final report", () => {
 LoadTestingPage.prepareFinalReport();
});

Then("the final report is prepared and submitted for review", () => {
 LoadTestingPage.verifyReportSubmission();
});