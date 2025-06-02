import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SubscriptionPage from "../pages/subscriptionPage";

Given("I have access to the subscription system", () => {
 SubscriptionPage.visit();
});

When("I log in to the system with an admin account", () => {
 SubscriptionPage.loginAsAdmin();
});

Then("the admin dashboard is displayed with options to manage subscriptions", () => {
 SubscriptionPage.verifyAdminDashboard();
});

Given("the admin dashboard is displayed", () => {
 SubscriptionPage.verifyAdminDashboard();
});

When("I navigate to the subscription management section", () => {
 SubscriptionPage.goToSubscriptionManagement();
});

Then("the subscription management interface is displayed", () => {
 SubscriptionPage.verifySubscriptionManagementInterface();
});

Given("the subscription management interface is displayed", () => {
 SubscriptionPage.verifySubscriptionManagementInterface();
});

When("I select a test user account for subscription testing", () => {
 SubscriptionPage.selectTestUserAccount();
});

Then("user account details are displayed", () => {
 SubscriptionPage.verifyUserAccountDetails();
});

Given("user account details are displayed", () => {
 SubscriptionPage.verifyUserAccountDetails();
});

When("I configure the subscription to the maximum allowable frequency", () => {
 SubscriptionPage.configureMaxFrequency();
});

Then("subscription frequency is set to daily", () => {
 SubscriptionPage.verifyFrequencySetToDaily();
});

Given("subscription frequency is set to daily", () => {
 SubscriptionPage.verifyFrequencySetToDaily();
});

When("I set the subscription volume to the maximum allowable limit", () => {
 SubscriptionPage.setMaxVolume();
});

Then("subscription volume is set to the maximum limit", () => {
 SubscriptionPage.verifyVolumeSetToMax();
});

Given("subscription volume is set to the maximum limit", () => {
 SubscriptionPage.verifyVolumeSetToMax();
});

When("I save the subscription configuration", () => {
 SubscriptionPage.saveConfiguration();
});

Then("subscription settings are saved successfully", () => {
 SubscriptionPage.verifySettingsSaved();
});

Given("subscription settings are saved successfully", () => {
 SubscriptionPage.verifySettingsSaved();
});

When("I monitor system performance metrics during peak subscription times", () => {
 SubscriptionPage.monitorPerformanceMetrics();
});

Then("system performance metrics remain within acceptable limits", () => {
 SubscriptionPage.verifyPerformanceMetricsWithinLimits();
});

Given("system performance metrics remain within acceptable limits", () => {
 SubscriptionPage.verifyPerformanceMetricsWithinLimits();
});

When("I simulate multiple users subscribing at the maximum frequency and volume", () => {
 SubscriptionPage.simulateMultipleUsers();
});

Then("system handles the load without degradation in performance", () => {
 SubscriptionPage.verifySystemHandlesLoad();
});

Given("system handles the load without degradation in performance", () => {
 SubscriptionPage.verifySystemHandlesLoad();
});

When("I check for any error logs or alerts generated during the test", () => {
 SubscriptionPage.checkErrorLogsOrAlerts();
});

Then("no critical errors or alerts are generated", () => {
 SubscriptionPage.verifyNoCriticalErrors();
});

Given("no critical errors or alerts are generated", () => {
 SubscriptionPage.verifyNoCriticalErrors();
});

When("I verify the accuracy of subscription data processed during the test", () => {
 SubscriptionPage.verifySubscriptionDataAccuracy();
});

Then("subscription data is accurate and consistent", () => {
 SubscriptionPage.verifyDataAccuracyAndConsistency();
});

Given("subscription data is accurate and consistent", () => {
 SubscriptionPage.verifyDataAccuracyAndConsistency();
});

When("I repeat the test with different subscription plans and user accounts", () => {
 SubscriptionPage.repeatTestWithDifferentPlans();
});

Then("system consistently handles maximum load across different scenarios", () => {
 SubscriptionPage.verifyConsistentHandlingAcrossScenarios();
});

Given("system consistently handles maximum load across different scenarios", () => {
 SubscriptionPage.verifyConsistentHandlingAcrossScenarios();
});

When("I analyze the system's response time and throughput during the test", () => {
 SubscriptionPage.analyzeResponseTimeAndThroughput();
});

Then("response time and throughput remain within acceptable limits", () => {
 SubscriptionPage.verifyResponseTimeAndThroughputLimits();
});

Given("response time and throughput remain within acceptable limits", () => {
 SubscriptionPage.verifyResponseTimeAndThroughputLimits();
});

When("I evaluate system's ability to recover from any potential overload conditions", () => {
 SubscriptionPage.evaluateRecoveryFromOverload();
});

Then("system recovers gracefully without data loss or corruption", () => {
 SubscriptionPage.verifyGracefulRecovery();
});

Given("system recovers gracefully without data loss or corruption", () => {
 SubscriptionPage.verifyGracefulRecovery();
});

When("I document any performance bottlenecks or issues observed", () => {
 SubscriptionPage.documentPerformanceIssues();
});

Then("a detailed report of performance observations and recommendations is generated", () => {
 SubscriptionPage.verifyPerformanceReportGenerated();
});

Given("a detailed report of performance observations and recommendations is generated", () => {
 SubscriptionPage.verifyPerformanceReportGenerated();
});

When("I conclude the test with a summary of findings and potential improvements", () => {
 SubscriptionPage.concludeTestWithSummary();
});

Then("a summary report is generated with actionable insights", () => {
 SubscriptionPage.verifySummaryReportGenerated();
});