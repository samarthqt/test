import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CarrierIntegrationPage from "../pages/carrierIntegrationPage";

Given("the admin is logged in using valid credentials", () => {
  // Assume login functionality is handled elsewhere
  cy.loginAsAdmin();
});

When("the admin is redirected to the dashboard", () => {
  cy.url().should("include", "/dashboard");
});

When("the admin accesses the 'Carrier Integration' settings", () => {
  CarrierIntegrationPage.accessCarrierIntegrationSettings();
});

Then("the system displays the available carrier integration settings", () => {
  CarrierIntegrationPage.verifyCarrierIntegrationSettingsDisplayed();
});

Given("the admin is on the 'Carrier Integration' settings page", () => {
  CarrierIntegrationPage.visit();
});

When("the admin checks the list of integrated carriers", () => {
  CarrierIntegrationPage.checkIntegratedCarriersList();
});

Then("FedEx and UPS are listed as integrated carriers", () => {
  CarrierIntegrationPage.verifyFedExAndUPSListed();
});

Given("an order with Order ID 67890 has been shipped using FedEx", () => {
  CarrierIntegrationPage.findOrderById("67890");
});

When("the admin selects the order and views its tracking details", () => {
  CarrierIntegrationPage.viewOrderTrackingDetails();
});

Then("the tracking details for FedEx are displayed correctly", () => {
  CarrierIntegrationPage.verifyFedExTrackingDetails();
});

Then("the tracking number is FED12345", () => {
  CarrierIntegrationPage.verifyTrackingNumber("FED12345");
});

Given("an order with Order ID 67890 has been shipped using UPS", () => {
  CarrierIntegrationPage.findOrderById("67890");
});

Then("the tracking details for UPS are displayed correctly", () => {
  CarrierIntegrationPage.verifyUPSTrackingDetails();
});

Then("the tracking number is UPS67890", () => {
  CarrierIntegrationPage.verifyTrackingNumber("UPS67890");
});

Given("the system is integrated with FedEx", () => {
  CarrierIntegrationPage.verifyFedExIntegration();
});

When("the system fetches real-time tracking updates", () => {
  CarrierIntegrationPage.fetchRealTimeTrackingUpdates();
});

Then("the updates from FedEx are fetched and displayed accurately", () => {
  CarrierIntegrationPage.verifyFedExUpdatesDisplayed();
});

Given("the system is integrated with UPS", () => {
  CarrierIntegrationPage.verifyUPSIntegration();
});

Then("the updates from UPS are fetched and displayed accurately", () => {
  CarrierIntegrationPage.verifyUPSUpdatesDisplayed();
});

When("a tracking update failure occurs from the FedEx API", () => {
  CarrierIntegrationPage.simulateFedExApiFailure();
});

Then("the system handles the failure gracefully", () => {
  CarrierIntegrationPage.verifyFailureHandling();
});

And("retries fetching updates", () => {
  CarrierIntegrationPage.verifyRetryMechanism();
});

When("a tracking update failure occurs from the UPS API", () => {
  CarrierIntegrationPage.simulateUPSApiFailure();
});

When("an invalid tracking number is entered", () => {
  CarrierIntegrationPage.enterInvalidTrackingNumber();
});

Then("the system displays a user-friendly error message for invalid FedEx tracking numbers", () => {
  CarrierIntegrationPage.verifyFedExInvalidTrackingErrorMessage();
});

Then("the system displays a user-friendly error message for invalid UPS tracking numbers", () => {
  CarrierIntegrationPage.verifyUPSInvalidTrackingErrorMessage();
});

Given("the system is integrated with both FedEx and UPS", () => {
  CarrierIntegrationPage.verifyBothCarriersIntegration();
});

When("tracking information is fetched from both carriers simultaneously", () => {
  CarrierIntegrationPage.fetchSimultaneousTrackingUpdates();
});

Then("the system efficiently handles requests without performance degradation", () => {
  CarrierIntegrationPage.verifyPerformance();
});

When("API requests and responses occur", () => {
  CarrierIntegrationPage.simulateApiRequestsAndResponses();
});

Then("they are logged accurately for auditing purposes", () => {
  CarrierIntegrationPage.verifyApiLogging();
});

Given("an order is shipped with a carrier", () => {
  CarrierIntegrationPage.findOrderWithCarrier();
});

When("the admin switches the carrier for the order", () => {
  CarrierIntegrationPage.switchOrderCarrier();
});

Then("the system successfully updates the tracking information", () => {
  CarrierIntegrationPage.verifyTrackingInfoUpdated();
});

Given("tracking information is fetched from a carrier", () => {
  CarrierIntegrationPage.fetchTrackingInfo();
});

When("the information is displayed to users", () => {
  CarrierIntegrationPage.displayTrackingInfoToUsers();
});

Then("it is accurate and matches the carrier data", () => {
  CarrierIntegrationPage.verifyTrackingInfoAccuracy();
});