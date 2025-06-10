import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("the user is logged into their account", () => {
 // Implement login logic here
});

When("the user navigates to the order tracking page", () => {
 OrderTrackingPage.visit();
});

Then("the order tracking page is displayed", () => {
 OrderTrackingPage.verifyPageDisplayed();
});

Given("the user is on the order tracking page", () => {
 OrderTrackingPage.visit();
});

When("the order details are loaded", () => {
 OrderTrackingPage.loadOrderDetails();
});

Then("the order status is displayed accurately", () => {
 OrderTrackingPage.verifyOrderStatus();
});

When("the user clicks on the tracking number", () => {
 OrderTrackingPage.clickTrackingNumber();
});

Then("the user is redirected to the shipping provider's site", () => {
 OrderTrackingPage.verifyRedirectToShippingProvider();
});

When("there is a change in the order status", () => {
 OrderTrackingPage.simulateOrderStatusChange();
});

Then("the updated order status is displayed in real-time", () => {
 OrderTrackingPage.verifyRealTimeStatusUpdate();
});

Given("the user has an active order", () => {
 // Ensure the user has an active order
});

Then("the user receives a notification about the status change", () => {
 OrderTrackingPage.verifyStatusChangeNotification();
});

Given("the user is accessing the order tracking page", () => {
 OrderTrackingPage.visit();
});

When("the page is loading", () => {
 OrderTrackingPage.verifyPageLoading();
});

Then("the page loads within 3 seconds", () => {
 OrderTrackingPage.verifyPageLoadTime();
});

Then("the page is responsive", () => {
 OrderTrackingPage.verifyPageResponsiveness();
});

When("an unauthorized user attempts to access tracking details", () => {
 OrderTrackingPage.simulateUnauthorizedAccess();
});

Then("the tracking details are not visible to the unauthorized user", () => {
 OrderTrackingPage.verifyUnauthorizedAccessRestriction();
});