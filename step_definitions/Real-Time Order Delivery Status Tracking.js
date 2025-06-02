import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import DashboardPage from "../pages/dashboardPage";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("the user has valid credentials", () => {
 // Assume user credentials are set in environment variables
 cy.login(Cypress.env('username'), Cypress.env('password'));
});

When("the user logs into the account", () => {
 cy.visit('/login');
 cy.get('#username').type(Cypress.env('username'));
 cy.get('#password').type(Cypress.env('password'));
 cy.get('#loginButton').click();
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is on the dashboard", () => {
 DashboardPage.visit();
});

When("the user navigates to the 'Order Tracking' section", () => {
 DashboardPage.navigateToOrderTracking();
});

Then("the 'Order Tracking' section is displayed with a list of orders eligible for tracking", () => {
 OrderTrackingPage.verifyOrderList();
});

Given("the user is in the 'Order Tracking' section", () => {
 OrderTrackingPage.visit();
});

When("the user selects an order to view its delivery status", () => {
 OrderTrackingPage.selectOrder();
});

Then("the delivery status is displayed, showing the current location and estimated delivery time", () => {
 OrderTrackingPage.verifyDeliveryStatus();
});

Then("the tracking number and carrier information are correctly displayed", () => {
 OrderTrackingPage.verifyTrackingNumberAndCarrierInfo();
});

Then("the current status of the order is updated in real-time", () => {
 OrderTrackingPage.verifyRealTimeUpdates();
});

Then("the estimated delivery time is accurate and updated as needed", () => {
 OrderTrackingPage.verifyEstimatedDeliveryTime();
});

Then("the user receives notifications for any changes in delivery status", () => {
 OrderTrackingPage.verifyNotifications();
});

When("the user accesses tracking history", () => {
 OrderTrackingPage.accessTrackingHistory();
});

Then("the tracking history shows past locations and statuses of the package", () => {
 OrderTrackingPage.verifyTrackingHistory();
});

When("the user attempts to contact the carrier", () => {
 OrderTrackingPage.contactCarrier();
});

Then("contact information for the carrier is available and accessible", () => {
 OrderTrackingPage.verifyCarrierContactInfo();
});

When("the user attempts to download tracking information as a PDF", () => {
 OrderTrackingPage.downloadTrackingInfoAsPDF();
});

Then("tracking information is successfully downloaded and contains accurate details", () => {
 OrderTrackingPage.verifyPDFDownload();
});

When("there is network latency or connectivity issues", () => {
 cy.simulateNetworkLatency();
});

Then("the system displays appropriate error messages or retries the connection", () => {
 OrderTrackingPage.verifyNetworkErrorHandling();
});

Given("the user is on the tracking page", () => {
 OrderTrackingPage.visit();
});

When("the user navigates back to the dashboard", () => {
 OrderTrackingPage.navigateToDashboard();
});

Then("the user is redirected to the dashboard without any issues", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is logged in", () => {
 cy.login(Cypress.env('username'), Cypress.env('password'));
});

When("the user logs out from the account", () => {
 DashboardPage.logout();
});

Then("the user is successfully logged out and redirected to the login page", () => {
 cy.url().should("include", "/login");
});