import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user is logged into their account with multiple past orders", () => {
 // Assume user is already logged in
});

When("the user navigates to the 'Order History' section", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the Order History page is displayed", () => {
 OrderHistoryPage.verifyOrderHistoryPageDisplayed();
});

Given("the user is on the Order History page", () => {
 OrderHistoryPage.verifyOrderHistoryPageDisplayed();
});

Then("all past orders are accurately listed", () => {
 OrderHistoryPage.verifyAllPastOrdersListed();
});

Given("the user selects a random order from the Order History", () => {
 OrderHistoryPage.selectRandomOrder();
});

Then("the displayed order date matches the date in the order confirmation email", () => {
 OrderHistoryPage.verifyOrderDateMatchesEmail();
});

Then("the order status is consistent with the status in the order confirmation email", () => {
 OrderHistoryPage.verifyOrderStatusMatchesEmail();
});

Then("the payment details match those in the order confirmation email", () => {
 OrderHistoryPage.verifyPaymentDetailsMatchEmail();
});

Then("the product details are consistent with those in the order confirmation email", () => {
 OrderHistoryPage.verifyProductDetailsMatchEmail();
});

Then("the total cost matches the amount in the order confirmation email", () => {
 OrderHistoryPage.verifyTotalCostMatchesEmail();
});

Then("no discrepancies are found; data is accurate and consistent", () => {
 OrderHistoryPage.verifyNoDiscrepanciesInData();
});

Given("the user applies filters in the Order History section", () => {
 OrderHistoryPage.applyFilters();
});

Then("the filtered data remains accurate and consistent", () => {
 OrderHistoryPage.verifyFilteredDataConsistency();
});

Then("all orders are present; no orders are missing", () => {
 OrderHistoryPage.verifyNoMissingOrders();
});

When("the user attempts to manipulate data through the browser console", () => {
 OrderHistoryPage.attemptDataManipulation();
});

Then("data manipulation is not possible; data integrity is maintained", () => {
 OrderHistoryPage.verifyDataIntegrity();
});

Given("the system has been updated", () => {
 // Assume system update has occurred
});

When("the user accesses the Order History section", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("data remains accurate and consistent post-update", () => {
 OrderHistoryPage.verifyPostUpdateDataConsistency();
});

Given("the user logs out of their account", () => {
 OrderHistoryPage.logout();
});

When("the user attempts to view the Order History", () => {
 OrderHistoryPage.attemptToViewOrderHistory();
});

Then("the user is redirected to the login page", () => {
 OrderHistoryPage.verifyRedirectToLoginPage();
});

Given("the user accesses the Order History section on different devices", () => {
 OrderHistoryPage.accessOrderHistoryOnDifferentDevices();
});

Then("data is accurate and consistent across all devices", () => {
 OrderHistoryPage.verifyDataConsistencyAcrossDevices();
});