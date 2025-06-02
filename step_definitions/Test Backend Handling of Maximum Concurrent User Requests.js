import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoadTestPage from "../pages/loadTestPage";

Given("the application is deployed and accessible", () => {
 LoadTestPage.visitApplication();
});

When("I configure the load testing tool with the maximum number of concurrent requests", () => {
 LoadTestPage.configureMaxConcurrentRequests();
});

Then("the load testing tool is configured successfully", () => {
 LoadTestPage.verifyConfigurationSuccess();
});

Given("the load testing tool is configured with parameters", () => {
 LoadTestPage.verifyToolConfigured();
});

When("I start the load test", () => {
 LoadTestPage.startLoadTest();
});

Then("the load test starts and sends concurrent requests to the application", () => {
 LoadTestPage.verifyLoadTestStarted();
});

Given("the load test is running", () => {
 LoadTestPage.verifyLoadTestRunning();
});

When("I monitor the application's response time", () => {
 LoadTestPage.monitorResponseTime();
});

Then("the application's response time remains within acceptable limits", () => {
 LoadTestPage.verifyResponseTimeLimits();
});

When("I check for errors or timeouts", () => {
 LoadTestPage.checkForErrorsOrTimeouts();
});

Then("no errors or timeouts occur during the load test", () => {
 LoadTestPage.verifyNoErrorsOrTimeouts();
});

When("the application is under peak load", () => {
 LoadTestPage.simulatePeakLoad();
});

Then("the application handles the peak load successfully without crashing", () => {
 LoadTestPage.verifyPeakLoadHandling();
});

When("I check the server's CPU and memory usage", () => {
 LoadTestPage.checkServerResources();
});

Then("CPU and memory usage remain within acceptable limits", () => {
 LoadTestPage.verifyResourceLimits();
});

When("I verify the load balancing mechanism", () => {
 LoadTestPage.verifyLoadBalancing();
});

Then("load is distributed evenly across servers", () => {
 LoadTestPage.verifyLoadDistribution();
});

When("I simulate a sudden spike in concurrent requests", () => {
 LoadTestPage.simulateSuddenSpike();
});

Then("the application handles the sudden spike without degradation in performance", () => {
 LoadTestPage.verifySpikeHandling();
});

When("I check data integrity", () => {
 LoadTestPage.checkDataIntegrity();
});

Then("data integrity is maintained with no loss or corruption", () => {
 LoadTestPage.verifyDataIntegrity();
});

When("I verify the logging mechanism", () => {
 LoadTestPage.verifyLoggingMechanism();
});

Then("logs are generated accurately without any loss or delay", () => {
 LoadTestPage.verifyLogAccuracy();
});

When("I test scalability", () => {
 LoadTestPage.testScalability();
});

Then("the application scales effectively to handle the maximum load", () => {
 LoadTestPage.verifyScalability();
});

When("I simulate a gradual increase in concurrent requests", () => {
 LoadTestPage.simulateGradualIncrease();
});

Then("the application handles the gradual increase smoothly without performance issues", () => {
 LoadTestPage.verifyGradualIncreaseHandling();
});

Given("the load test has completed", () => {
 LoadTestPage.verifyLoadTestCompleted();
});

When("I verify recovery", () => {
 LoadTestPage.verifyRecovery();
});

Then("the application recovers quickly and resumes normal operations", () => {
 LoadTestPage.verifyRecoverySuccess();
});

When("I check for bottlenecks or performance issues", () => {
 LoadTestPage.checkForBottlenecks();
});

Then("no significant bottlenecks or performance issues are identified", () => {
 LoadTestPage.verifyNoBottlenecks();
});

When("I analyze the test results", () => {
 LoadTestPage.analyzeTestResults();
});

Then("a detailed performance report is generated highlighting the application's ability to handle maximum concurrent user requests", () => {
 LoadTestPage.generatePerformanceReport();
});