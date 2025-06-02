import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NetworkSimulationPage from "../pages/networkSimulationPage";

Given("access to the network simulation tool", () => {
  NetworkSimulationPage.accessTool();
});

When("I set the network speed to {string}", (networkSpeed) => {
  NetworkSimulationPage.setNetworkSpeed(networkSpeed);
});

When("I configure network latency to {string}", (networkLatency) => {
  NetworkSimulationPage.setNetworkLatency(networkLatency);
});

When("I set packet loss to {string}", (packetLoss) => {
  NetworkSimulationPage.setPacketLoss(packetLoss);
});

When("I open the application on the test device", () => {
  NetworkSimulationPage.openApplication();
});

When("I attempt to load the homepage of the application", () => {
  NetworkSimulationPage.loadHomepage();
});

Then("I measure the time taken for the application to load the homepage", () => {
  NetworkSimulationPage.measureLoadTime();
});

Then("I verify if the application does not load within 3 seconds", () => {
  NetworkSimulationPage.verifyLoadTime(3);
});

Then("I observe any error messages or loading indicators displayed", () => {
  NetworkSimulationPage.observeErrorsOrIndicators();
});

Then("I check the application's responsiveness during loading", () => {
  NetworkSimulationPage.checkResponsiveness();
});

Then("I log the results of the network simulation and application load time", () => {
  NetworkSimulationPage.logResults();
});

Then("I reset network conditions to normal", () => {
  NetworkSimulationPage.resetNetworkConditions();
});

Then("I analyze the impact of each network condition on application load time", () => {
  NetworkSimulationPage.analyzeImpact();
});

Then("I document any discrepancies or issues found during testing", () => {
  NetworkSimulationPage.documentDiscrepancies();
});

Then("I provide recommendations for improving application load time under poor network conditions", () => {
  NetworkSimulationPage.provideRecommendations();
});