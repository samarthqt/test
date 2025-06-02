import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrafficSimulationPage from "../pages/trafficSimulationPage";

Given("access to the traffic simulation tool", () => {
 TrafficSimulationPage.accessTool();
});

When("I set the user count to {int}", (userCount) => {
 TrafficSimulationPage.setUserCount(userCount);
});

When("configure server load to 80%", () => {
 TrafficSimulationPage.configureServerLoad(80);
});

When("open the application on the test device", () => {
 TrafficSimulationPage.openApplication();
});

When("attempt to load the homepage of the application", () => {
 TrafficSimulationPage.loadHomepage();
});

Then("measure the time taken for the application to load the homepage", () => {
 TrafficSimulationPage.measureLoadTime();
});

Then("verify if the application loads within 3 seconds", () => {
 TrafficSimulationPage.verifyLoadTime(3);
});

Then("observe any error messages or loading indicators displayed", () => {
 TrafficSimulationPage.observeErrorsOrIndicators();
});

Then("check the application's responsiveness during loading", () => {
 TrafficSimulationPage.checkResponsiveness();
});

Then("log the results of the traffic simulation and application load time", () => {
 TrafficSimulationPage.logResults();
});

Then("reset traffic conditions to normal", () => {
 TrafficSimulationPage.resetTrafficConditions();
});

Then("analyze the impact of each traffic condition on application load time", () => {
 TrafficSimulationPage.analyzeImpact();
});

Then("document any discrepancies or issues found during testing", () => {
 TrafficSimulationPage.documentDiscrepancies();
});

Then("provide recommendations for maintaining application load speed under peak traffic conditions", () => {
 TrafficSimulationPage.provideRecommendations();
});

Then("ensure the application performs optimally under simulated peak traffic conditions", () => {
 TrafficSimulationPage.ensureOptimalPerformance();
});