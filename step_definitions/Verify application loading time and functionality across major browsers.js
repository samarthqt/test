import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ApplicationPage from "../pages/applicationPage";

Given("I open {string} browser", (browser) => {
 ApplicationPage.openBrowser(browser);
});

When("I navigate to the application home page", () => {
 ApplicationPage.navigateToHomePage();
});

When("I start a timer as the page begins loading", () => {
 ApplicationPage.startLoadingTimer();
});

Then("the application should load within 3 seconds", () => {
 ApplicationPage.verifyLoadingTime(3000);
});

Given("the application has loaded", () => {
 ApplicationPage.verifyApplicationLoaded();
});

Then("all application features should be functional", () => {
 ApplicationPage.verifyAllFeaturesFunctional();
});

Then("there should be no errors in the browser console", () => {
 ApplicationPage.checkBrowserConsoleForErrors();
});

Then("the application layout and design should appear correctly", () => {
 ApplicationPage.verifyLayoutAndDesign();
});

Given("I have slightly reduced network conditions", () => {
 ApplicationPage.setReducedNetworkConditions();
});

Then("the application should still load within 3 seconds", () => {
 ApplicationPage.verifyLoadingTime(3000);
});

Given("I repeatedly access the application", () => {
 ApplicationPage.repeatedlyAccessApplication();
});

Then("the loading time should not be affected", () => {
 ApplicationPage.verifyConsistentLoadingTime();
});

Given("it is peak hours", () => {
 ApplicationPage.setPeakHours();
});

Then("there should be no performance degradation", () => {
 ApplicationPage.verifyNoPerformanceDegradation();
});

Given("the application has loaded on all browsers", () => {
 ApplicationPage.verifyLoadedOnAllBrowsers();
});

Then("loading times should be logged accurately", () => {
 ApplicationPage.verifyLoadingTimesLogged();
});

Given("the application has been updated", () => {
 ApplicationPage.verifyApplicationUpdated();
});

Then("loading times should remain consistent across updates", () => {
 ApplicationPage.verifyConsistentLoadingTimesAcrossUpdates();
});