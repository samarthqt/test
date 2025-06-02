import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PerformancePage from "../pages/performancePage";

Given("access to the application under test", () => {
 PerformancePage.accessApplication();
});

When("I access the user simulation tool", () => {
 PerformancePage.accessUserSimulationTool();
});

When("I set the concurrent user count to {int}", (userCount) => {
 PerformancePage.setConcurrentUserCount(userCount);
});

Then("the concurrent user count is set to {int}", (userCount) => {
 PerformancePage.verifyUserCount(userCount);
});

And("monitor server CPU usage during the test", () => {
 PerformancePage.monitorServerCPUUsage();
});

Then("server CPU usage is monitored", () => {
 PerformancePage.verifyCPUUsageMonitoring();
});

And("server CPU usage is {int}%", (cpuUsage) => {
 PerformancePage.verifyCPUUsage(cpuUsage);
});

When("I open the application on the test device", () => {
 PerformancePage.openApplicationOnDevice();
});

Then("the application is opened", () => {
 PerformancePage.verifyApplicationOpened();
});

When("I attempt to perform various operations such as login, navigation, and data retrieval", () => {
 PerformancePage.performOperations();
});

Then("operations are attempted", () => {
 PerformancePage.verifyOperationsAttempted();
});

And("measure the response time for each operation", () => {
 PerformancePage.measureResponseTime();
});

Then("response time is measured", () => {
 PerformancePage.verifyResponseTimeMeasured();
});

And("verify if performance metrics exceed acceptable limits", () => {
 PerformancePage.verifyPerformanceMetrics();
});

Then("performance metrics exceed acceptable limits", () => {
 PerformancePage.verifyMetricsExceedLimits();
});

And("observe any error messages or performance issues", () => {
 PerformancePage.observeErrorsOrIssues();
});

Then("error messages or performance issues are observed", () => {
 PerformancePage.verifyErrorsOrIssuesObserved();
});

And("check the application's responsiveness during the test", () => {
 PerformancePage.checkResponsiveness();
});

Then("application is unresponsive during the test", () => {
 PerformancePage.verifyUnresponsiveness();
});

And("log the results of the user simulation and application performance", () => {
 PerformancePage.logResults();
});

Then("results are logged", () => {
 PerformancePage.verifyResultsLogged();
});

When("I reset user simulation conditions to normal", () => {
 PerformancePage.resetUserSimulation();
});

Then("user simulation conditions are reset", () => {
 PerformancePage.verifySimulationReset();
});

And("repeat the test with different user counts", () => {
 PerformancePage.repeatTestWithDifferentUserCounts();
});

Then("test is repeated with different user counts", () => {
 PerformancePage.verifyTestRepeated();
});

And("analyze the impact of each user count on application performance", () => {
 PerformancePage.analyzeImpact();
});

Then("impact analysis is completed", () => {
 PerformancePage.verifyImpactAnalysis();
});

And("document any discrepancies or issues found during testing", () => {
 PerformancePage.documentDiscrepancies();
});

Then("discrepancies or issues are documented", () => {
 PerformancePage.verifyDiscrepanciesDocumented();
});

And("provide recommendations for improving application performance under high user load", () => {
 PerformancePage.provideRecommendations();
});

Then("recommendations are provided", () => {
 PerformancePage.verifyRecommendationsProvided();
});

And("ensure the application performs optimally despite exceeding acceptable limits", () => {
 PerformancePage.ensureOptimalPerformance();
});

Then("application performance is suboptimal", () => {
 PerformancePage.verifySuboptimalPerformance();
});