import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingIntegrationPage from "../pages/trackingIntegrationPage";

Given("the tracking system is integrated with multiple carriers", () => {
 TrackingIntegrationPage.verifyIntegrationWithCarriers();
});

When("I select Carrier A from the carrier list", () => {
 TrackingIntegrationPage.selectCarrierA();
});

Then("Carrier A is selected", () => {
 TrackingIntegrationPage.verifyCarrierASelected();
});

Given("Carrier A API keys are configured", () => {
 TrackingIntegrationPage.configureCarrierAAPIKeys();
});

When("I enter a valid tracking number for Carrier A", () => {
 TrackingIntegrationPage.enterValidTrackingNumberForCarrierA();
});

Then("Tracking information is retrieved successfully", () => {
 TrackingIntegrationPage.verifyTrackingInformationRetrieved();
});

When("I select Carrier B from the carrier list", () => {
 TrackingIntegrationPage.selectCarrierB();
});

Then("Carrier B is selected", () => {
 TrackingIntegrationPage.verifyCarrierBSelected();
});

Given("Carrier B API keys are configured", () => {
 TrackingIntegrationPage.configureCarrierBAPIKeys();
});

When("I enter a valid tracking number for Carrier B", () => {
 TrackingIntegrationPage.enterValidTrackingNumberForCarrierB();
});

When("I select Carrier C from the carrier list", () => {
 TrackingIntegrationPage.selectCarrierC();
});

Then("Carrier C is selected", () => {
 TrackingIntegrationPage.verifyCarrierCSelected();
});

Given("Carrier C API keys are configured", () => {
 TrackingIntegrationPage.configureCarrierCAPIKeys();
});

When("I enter a valid tracking number for Carrier C", () => {
 TrackingIntegrationPage.enterValidTrackingNumberForCarrierC();
});

When("I enter an invalid tracking number for Carrier A", () => {
 TrackingIntegrationPage.enterInvalidTrackingNumberForCarrierA();
});

Then("System displays an error message for invalid tracking numbers", () => {
 TrackingIntegrationPage.verifyErrorMessageForInvalidTrackingNumbers();
});

When("I enter an invalid tracking number for Carrier B", () => {
 TrackingIntegrationPage.enterInvalidTrackingNumberForCarrierB();
});

When("I enter an invalid tracking number for Carrier C", () => {
 TrackingIntegrationPage.enterInvalidTrackingNumberForCarrierC();
});

When("Carrier A experiences a service outage", () => {
 TrackingIntegrationPage.simulateCarrierAServiceOutage();
});

Then("System displays a service outage message for Carrier A", () => {
 TrackingIntegrationPage.verifyServiceOutageMessageForCarrierA();
});

When("Carrier B experiences a service outage", () => {
 TrackingIntegrationPage.simulateCarrierBServiceOutage();
});

Then("System displays a service outage message for Carrier B", () => {
 TrackingIntegrationPage.verifyServiceOutageMessageForCarrierB();
});

When("Carrier C experiences a service outage", () => {
 TrackingIntegrationPage.simulateCarrierCServiceOutage();
});

Then("System displays a service outage message for Carrier C", () => {
 TrackingIntegrationPage.verifyServiceOutageMessageForCarrierC();
});

When("the system handles multiple carrier requests", () => {
 TrackingIntegrationPage.simulateHighLoad();
});

Then("System remains stable and responsive", () => {
 TrackingIntegrationPage.verifySystemStability();
});

When("tracking information is retrieved", () => {
 TrackingIntegrationPage.retrieveTrackingInformation();
});

Then("Carrier-specific tracking details are displayed", () => {
 TrackingIntegrationPage.verifyCarrierSpecificDetailsDisplayed();
});

When("a new carrier is integrated into the system", () => {
 TrackingIntegrationPage.integrateNewCarrier();
});

Then("System can integrate with new carriers successfully", () => {
 TrackingIntegrationPage.verifyNewCarrierIntegration();
});