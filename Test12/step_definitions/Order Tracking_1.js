import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("an order has been shipped", () => {
 OrderTrackingPage.verifyOrderShipped();
});

When("the user views the order details", () => {
 OrderTrackingPage.viewOrderDetails();
});

Then("the user should see a tracking number for the order", () => {
 OrderTrackingPage.verifyTrackingNumberVisible();
});

Given("an order is in transit", () => {
 OrderTrackingPage.verifyOrderInTransit();
});

When("the order status changes", () => {
 OrderTrackingPage.changeOrderStatus();
});

Then("the system should update the order status in real-time", () => {
 OrderTrackingPage.verifyRealTimeStatusUpdate();
});

Given("an order is eligible for cancellation", () => {
 OrderTrackingPage.verifyOrderEligibleForCancellation();
});

When("the user requests to cancel the order", () => {
 OrderTrackingPage.requestOrderCancellation();
});

Then("the order should be canceled according to merchant policy", () => {
 OrderTrackingPage.verifyOrderCancelled();
});

Given("an order is eligible for return", () => {
 OrderTrackingPage.verifyOrderEligibleForReturn();
});

When("the user requests to return the order", () => {
 OrderTrackingPage.requestOrderReturn();
});

Then("the order should be returned according to merchant policy", () => {
 OrderTrackingPage.verifyOrderReturned();
});

Given("an order status has changed", () => {
 OrderTrackingPage.verifyOrderStatusChanged();
});

When("the system updates the status", () => {
 OrderTrackingPage.updateOrderStatus();
});

Then("the user should receive a notification about the status update", () => {
 OrderTrackingPage.verifyNotificationReceived();
});

Given("there is an error in tracking the order", () => {
 OrderTrackingPage.verifyTrackingError();
});

When("the user attempts to track the order", () => {
 OrderTrackingPage.attemptOrderTracking();
});

Then("the system should notify the user about the tracking error", () => {
 OrderTrackingPage.verifyTrackingErrorNotification();
});