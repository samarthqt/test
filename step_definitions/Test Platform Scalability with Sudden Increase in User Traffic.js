import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoadTestingPage from "../pages/loadTestingPage";

Given("the environment is configured for load testing", () => {
 LoadTestingPage.configureEnvironment();
});

Given("there are {int} simulated users", (userCount) => {
 LoadTestingPage.setSimulatedUsers(userCount);
});

Given("there are {int} user accounts for simulation", (accountCount) => {
 LoadTestingPage.setUserAccounts(accountCount);
});

Given("a stable internet connection", () => {
 LoadTestingPage.checkInternetConnection();
});

When("traffic is increased by {int}%", (percentage) => {
 LoadTestingPage.increaseTraffic(percentage);
});

Then("the traffic increase is successfully simulated", () => {
 LoadTestingPage.verifyTrafficIncrease();
});

Given("the test duration is {int} hour", (duration) => {
 LoadTestingPage.setTestDuration(duration);
});

When("monitoring CPU, memory, and response time", () => {
 LoadTestingPage.monitorPerformanceMetrics();
});

Then("metrics are recorded accurately", () => {
 LoadTestingPage.verifyMetricsRecording();
});

Given("key actions include Login, Browse, Checkout", () => {
 LoadTestingPage.defineKeyActions();
});

When("system is under peak load", () => {
 LoadTestingPage.simulatePeakLoad();
});

Then("system remains stable and responsive", () => {
 LoadTestingPage.verifySystemStability();
});

When("monitoring system stability", () => {
 LoadTestingPage.monitorSystemStability();
});

Then("no crashes or downtime occur", () => {
 LoadTestingPage.verifyNoCrashes();
});

When("evaluating user experience", () => {
 LoadTestingPage.evaluateUserExperience();
});

Then("user experience is consistent and satisfactory", () => {
 LoadTestingPage.verifyUserExperience();
});

When("performing checkout process under high load", () => {
 LoadTestingPage.performCheckoutUnderLoad();
});

Then("checkout process completes successfully", () => {
 LoadTestingPage.verifyCheckoutCompletion();
});

When("analyzing server logs", () => {
 LoadTestingPage.analyzeServerLogs();
});

Then("logs show no critical errors or warnings", () => {
 LoadTestingPage.verifyServerLogs();
});

When("simulating traffic from different locations", () => {
 LoadTestingPage.simulateGeographicTraffic();
});

Then("system handles traffic efficiently", () => {
 LoadTestingPage.verifyTrafficHandling();
});

When("evaluating database performance", () => {
 LoadTestingPage.evaluateDatabasePerformance();
});

Then("database queries are executed without delay", () => {
 LoadTestingPage.verifyDatabaseQueries();
});

When("testing resource scaling", () => {
 LoadTestingPage.testResourceScaling();
});

Then("resources are scaled dynamically as needed", () => {
 LoadTestingPage.verifyResourceScaling();
});

When("verifying load balancing", () => {
 LoadTestingPage.verifyLoadBalancing();
});

Then("load is balanced across servers effectively", () => {
 LoadTestingPage.verifyLoadBalancingEffectiveness();
});

When("monitoring latency during peak traffic", () => {
 LoadTestingPage.monitorLatency();
});

Then("no significant latency issues are observed", () => {
 LoadTestingPage.verifyLatencyIssues();
});

When("testing recovery from overload", () => {
 LoadTestingPage.testRecoveryFromOverload();
});

Then("platform recovers seamlessly", () => {
 LoadTestingPage.verifyRecovery();
});

When("monitoring for high resource usage", () => {
 LoadTestingPage.monitorResourceUsage();
});

Then("alerts are triggered appropriately", () => {
 LoadTestingPage.verifyAlerts();
});