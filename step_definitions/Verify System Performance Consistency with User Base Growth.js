import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PerformancePage from "../pages/performancePage";

Given("the initial user base is {int}", (initialUserBase) => {
 PerformancePage.setInitialUserBase(initialUserBase);
});

Given("expected user base growth to {int}", (expectedGrowth) => {
 PerformancePage.setExpectedUserBaseGrowth(expectedGrowth);
});

Given("peak traffic simulation is enabled", () => {
 PerformancePage.enablePeakTrafficSimulation();
});

When("I simulate user base growth to {int} users", (userBase) => {
 PerformancePage.simulateUserBaseGrowth(userBase);
});

When("I monitor system performance metrics during growth", () => {
 PerformancePage.monitorPerformanceMetrics();
});

When("I verify system response to peak traffic conditions", () => {
 PerformancePage.verifySystemResponseToPeakTraffic();
});

When("I check system logs for performance anomalies", () => {
 PerformancePage.checkSystemLogsForAnomalies();
});

When("I test system response to unexpected user base spikes", () => {
 PerformancePage.testResponseToUserBaseSpikes();
});

When("I verify auto-scaling triggers during user base growth", () => {
 PerformancePage.verifyAutoScalingTriggers();
});

When("I monitor resource allocation and utilization metrics", () => {
 PerformancePage.monitorResourceAllocation();
});

When("I simulate failure in scaling policies", () => {
 PerformancePage.simulateScalingFailure();
});

When("I verify notification alerts for system performance issues", () => {
 PerformancePage.verifyNotificationAlerts();
});

When("I test manual intervention processes for performance management", () => {
 PerformancePage.testManualInterventionProcesses();
});

When("I check system performance metrics post user base growth resolution", () => {
 PerformancePage.checkPostGrowthPerformanceMetrics();
});

When("I simulate network latency and observe system response", () => {
 PerformancePage.simulateNetworkLatency();
});

When("I log out from the performance monitoring tools", () => {
 PerformancePage.logout();
});

Then("the system performance remains consistent with {int} users", (userBase) => {
 PerformancePage.verifyPerformanceConsistency(userBase);
});

Then("performance metrics indicate stable system operation", () => {
 PerformancePage.verifyStableOperation();
});

Then("the system handles peak traffic effectively, maintaining performance", () => {
 PerformancePage.verifyPeakTrafficHandling();
});

Then("no performance anomalies are detected in system logs", () => {
 PerformancePage.verifyNoAnomaliesInLogs();
});

Then("the system handles unexpected spikes effectively, maintaining performance", () => {
 PerformancePage.verifySpikeHandling();
});

Then("auto-scaling triggers activate successfully, accommodating user growth", () => {
 PerformancePage.verifyAutoScalingSuccess();
});

Then("resource allocation and utilization metrics remain optimal", () => {
 PerformancePage.verifyOptimalResourceMetrics();
});

Then("failure is logged, and fallback mechanisms are activated", () => {
 PerformancePage.verifyFallbackMechanisms();
});

Then("notification alerts are sent to administrators, detailing performance issues", () => {
 PerformancePage.verifyNotificationSent();
});

Then("manual intervention processes are executed successfully, resolving performance issues", () => {
 PerformancePage.verifyManualInterventionSuccess();
});

Then("system performance metrics return to normal, indicating successful resolution", () => {
 PerformancePage.verifyPerformanceResolution();
});

Then("system response is logged, showing impact of network latency on performance", () => {
 PerformancePage.verifyNetworkLatencyImpact();
});

Then("the user is logged out successfully", () => {
 PerformancePage.verifyLogoutSuccess();
});