import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CloudInfraPage from "../pages/cloudInfraPage";

Given("the application is running on cloud infrastructure", () => {
  CloudInfraPage.verifyAppRunningOnCloud();
});

When("there is a traffic spike", () => {
  CloudInfraPage.simulateTrafficSpike();
});

Then("the application should automatically adjust resources to accommodate the increased load", () => {
  CloudInfraPage.verifyAutoResourceAdjustment();
});

Given("the application is deployed on cloud infrastructure", () => {
  CloudInfraPage.verifyAppDeployedOnCloud();
});

When("there is a need to scale horizontally", () => {
  CloudInfraPage.requestHorizontalScaling();
});

Then("the cloud infrastructure should support horizontal scaling without issues", () => {
  CloudInfraPage.verifyHorizontalScalingSupport();
});

When("the application is operational", () => {
  CloudInfraPage.verifyAppOperational();
});

Then("performance metrics must be monitored continuously", () => {
  CloudInfraPage.verifyContinuousPerformanceMonitoring();
});

When("up to 10,000 users access the application concurrently", () => {
  CloudInfraPage.simulateConcurrentUsers(10000);
});

Then("the system should handle the load without degradation", () => {
  CloudInfraPage.verifyLoadHandling();
});

When("auto-scaling is triggered", () => {
  CloudInfraPage.triggerAutoScaling();
});

Then("the process should be seamless and transparent to users", () => {
  CloudInfraPage.verifySeamlessAutoScaling();
});

When("scaling events occur", () => {
  CloudInfraPage.triggerScalingEvent();
});

Then("downtime should be minimal", () => {
  CloudInfraPage.verifyMinimalDowntime();
});

When("a scaling failure occurs", () => {
  CloudInfraPage.simulateScalingFailure();
});

Then("alerts must be generated to notify the issue", () => {
  CloudInfraPage.verifyAlertsForScalingFailure();
});

When("resources are allocated", () => {
  CloudInfraPage.allocateResources();
});

Then("the allocation should optimize cost efficiency", () => {
  CloudInfraPage.verifyCostEfficiency();
});

When("scaling tests are scheduled", () => {
  CloudInfraPage.scheduleScalingTests();
});

Then("scaling tests must be conducted regularly", () => {
  CloudInfraPage.verifyRegularScalingTests();
});

When("integrating with cloud service provider APIs", () => {
  CloudInfraPage.integrateWithCloudAPIs();
});

Then("the integration must be robust", () => {
  CloudInfraPage.verifyRobustIntegration();
});