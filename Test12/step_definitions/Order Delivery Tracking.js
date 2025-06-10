import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("a user is authenticated on the web platform", () => {
 OrderTrackingPage.authenticateWebUser();
});

Given("a user is authenticated on the mobile app", () => {
 OrderTrackingPage.authenticateMobileUser();
});

Given("a user is on the order tracking page", () => {
 OrderTrackingPage.visitTrackingPage();
});

Given("a user is viewing the tracking information", () => {
 OrderTrackingPage.viewTrackingInformation();
});

Given("a user has an order being tracked", () => {
 OrderTrackingPage.hasOrderBeingTracked();
});

Given("an unauthenticated user tries to access order tracking", () => {
 OrderTrackingPage.unauthenticatedAccessAttempt();
});

Given("a user encounters an issue with tracking", () => {
 OrderTrackingPage.encountersTrackingIssue();
});

Given("a user accesses the order tracking feature", () => {
 OrderTrackingPage.accessTrackingFeature();
});

Given("the system is integrated with shipping carriers", () => {
 OrderTrackingPage.integrationWithCarriers();
});

When("the user navigates to the order tracking feature", () => {
 OrderTrackingPage.navigateToTrackingFeature();
});

When("the tracking information is displayed", () => {
 OrderTrackingPage.displayTrackingInformation();
});

When("the order status is updated by the carrier", () => {
 OrderTrackingPage.updateOrderStatus();
});

When("the status of the order changes", () => {
 OrderTrackingPage.orderStatusChanges();
});

When("the user attempts to view tracking information", () => {
 OrderTrackingPage.attemptViewTrackingInfo();
});

When("an error occurs", () => {
 OrderTrackingPage.errorOccurs();
});

When("the user views or updates tracking information", () => {
 OrderTrackingPage.viewOrUpdateTrackingInfo();
});

When("tracking information is fetched", () => {
 OrderTrackingPage.fetchTrackingInfo();
});

Then("the user should be able to view the delivery status of their order", () => {
 OrderTrackingPage.verifyDeliveryStatus();
});

Then("it should include current status, estimated delivery time, and carrier details", () => {
 OrderTrackingPage.verifyTrackingDetails();
});

Then("the system should update the tracking information in real-time", () => {
 OrderTrackingPage.verifyRealTimeUpdates();
});

Then("the user should receive a notification about the status change", () => {
 OrderTrackingPage.verifyNotificationReceived();
});

Then("the system should deny access and prompt for authentication", () => {
 OrderTrackingPage.verifyAccessDenied();
});

Then("the system should display a user-friendly error message", () => {
 OrderTrackingPage.verifyErrorMessage();
});

Then("the system must log the access and updates for auditing purposes", () => {
 OrderTrackingPage.verifyLogging();
});

Then("the integration should be seamless and reliable", () => {
 OrderTrackingPage.verifyIntegrationSeamless();
});