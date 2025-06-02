import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user is logged into their account with valid credentials", () => {
 OrderHistoryPage.login();
});

When("the user navigates to the 'Order History' section", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the order history page is displayed with a list of past orders", () => {
 OrderHistoryPage.verifyOrderHistoryPage();
});

When("a new order is placed through the platform", () => {
 OrderHistoryPage.placeNewOrder();
});

When("the user refreshes or revisits the 'Order History' page", () => {
 OrderHistoryPage.refreshOrderHistory();
});

Then("the newly placed order appears in the order history list", () => {
 OrderHistoryPage.verifyNewOrderInHistory();
});

Then("the details of the new order like ID, date, items, and total amount are accurately displayed", () => {
 OrderHistoryPage.verifyOrderDetails();
});

Given("the user is logged into their account", () => {
 OrderHistoryPage.login();
});

When("the user places multiple orders", () => {
 OrderHistoryPage.placeMultipleOrders();
});

Then("all new orders appear in the history immediately after placement", () => {
 OrderHistoryPage.verifyMultipleOrdersInHistory();
});

When("the user places orders during peak usage times", () => {
 OrderHistoryPage.placeOrdersDuringPeakTimes();
});

Then("the order history updates smoothly without delays", () => {
 OrderHistoryPage.verifySmoothUpdates();
});

When("the user accesses the order history using different web browsers", () => {
 OrderHistoryPage.accessHistoryAcrossBrowsers();
});

Then("real-time updates work consistently across all browsers", () => {
 OrderHistoryPage.verifyConsistencyAcrossBrowsers();
});

When("the user places a new order", () => {
 OrderHistoryPage.placeNewOrder();
});

Then("updates occur instantly and efficiently without performance degradation", () => {
 OrderHistoryPage.verifyInstantUpdates();
});

Given("the user is logged out", () => {
 OrderHistoryPage.logout();
});

When("the user attempts to view order history updates", () => {
 OrderHistoryPage.attemptViewUpdatesLoggedOut();
});

Then("the system prevents viewing order history updates", () => {
 OrderHistoryPage.verifyPreventionWhenLoggedOut();
});

When("the user places new orders", () => {
 OrderHistoryPage.placeNewOrders();
});

Then("the order history accurately reflects all newly placed orders", () => {
 OrderHistoryPage.verifyAccurateOrderHistory();
});

When("the user places a large number of orders", () => {
 OrderHistoryPage.placeLargeNumberOfOrders();
});

Then("the system handles large datasets effectively without performance degradation", () => {
 OrderHistoryPage.verifyHandlingLargeDatasets();
});

Then("no error messages are displayed, indicating smooth real-time updates", () => {
 OrderHistoryPage.verifyNoErrorMessages();
});

When("the user accesses the order history on different devices (desktop, mobile)", () => {
 OrderHistoryPage.accessHistoryOnDifferentDevices();
});

Then("real-time updates work seamlessly across different devices", () => {
 OrderHistoryPage.verifySeamlessUpdatesAcrossDevices();
});

When("the user places a new order with different internet connection speeds", () => {
 OrderHistoryPage.placeOrderWithVariousSpeeds();
});

Then("updates occur smoothly regardless of internet connection speed", () => {
 OrderHistoryPage.verifySmoothUpdatesWithVariousSpeeds();
});