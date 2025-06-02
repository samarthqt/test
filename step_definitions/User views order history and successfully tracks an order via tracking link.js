import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";
import TrackingPage from "../pages/trackingPage";

Given("the user is logged into their account", () => {
 // Assume user is already logged in
});

Given("the user has previously placed an order", () => {
 // Assume user has a previous order
});

When("the user navigates to the order history page", () => {
 OrderHistoryPage.visit();
});

Then("the order history page is displayed", () => {
 OrderHistoryPage.verifyPageIsDisplayed();
});

Given("the user is on the order history page", () => {
 OrderHistoryPage.verifyPageIsDisplayed();
});

When("the user locates the order with Order ID {string} in the order history list", (orderId) => {
 OrderHistoryPage.locateOrder(orderId);
});

Then("the order is located in the list", () => {
 OrderHistoryPage.verifyOrderLocated();
});

Then("the tracking link {string} is available", (trackingLink) => {
 OrderHistoryPage.verifyTrackingLink(trackingLink);
});

Given("the user has located the order in the order history list", () => {
 OrderHistoryPage.verifyOrderLocated();
});

When("the user clicks on the tracking link associated with the order", () => {
 OrderHistoryPage.clickTrackingLink();
});

Then("the tracking link opens in a new window/tab", () => {
 TrackingPage.verifyNewTabOpened();
});

Then("the tracking information is displayed correctly", () => {
 TrackingPage.verifyTrackingInfoDisplayed();
});

Given("the tracking information is displayed", () => {
 TrackingPage.verifyTrackingInfoDisplayed();
});

Then("the current status of the order is displayed", () => {
 TrackingPage.verifyOrderStatus();
});

Then("the estimated delivery date is displayed", () => {
 TrackingPage.verifyEstimatedDeliveryDate();
});

Then("the carrier information is displayed correctly", () => {
 TrackingPage.verifyCarrierInformation();
});

Then("any updates in the tracking information are displayed", () => {
 TrackingPage.verifyTrackingUpdates();
});

Given("the user is viewing the tracking information", () => {
 TrackingPage.verifyTrackingInfoDisplayed();
});

When("the user returns to the order history page", () => {
 TrackingPage.returnToOrderHistory();
});

Then("the order history page is displayed", () => {
 OrderHistoryPage.verifyPageIsDisplayed();
});

Then("the order details such as product name, quantity, price, and total cost are displayed correctly", () => {
 OrderHistoryPage.verifyOrderDetails();
});

Then("the order status in the order history matches the tracking status", () => {
 OrderHistoryPage.verifyOrderStatusMatchesTracking();
});

When("the user attempts to track another order using a different tracking link", () => {
 OrderHistoryPage.clickDifferentTrackingLink();
});

Then("the tracking link opens and displays information correctly", () => {
 TrackingPage.verifyTrackingInfoDisplayed();
});

Given("the user has tracked orders using tracking links", () => {
 // Assume user has tracked orders
});

When("the system logs are checked", () => {
 // Check system logs
});

Then("the system logs show order tracking activity", () => {
 // Verify system logs
});

When("the system is checked for security alerts", () => {
 // Check for security alerts
});

Then("no security alerts are triggered", () => {
 // Verify no security alerts
});

Given("the user is on a mobile device", () => {
 // Assume user is on mobile
});

When("the user accesses the tracking link", () => {
 OrderHistoryPage.clickTrackingLink();
});

Then("the tracking link is accessible and functional on mobile devices", () => {
 TrackingPage.verifyMobileAccessibility();
});