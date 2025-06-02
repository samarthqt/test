import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("a user account with previous orders", () => {
 // Code to ensure user has previous orders
});

When("the user logs in using valid credentials", () => {
 OrderHistoryPage.login();
});

Then("the user is successfully logged in", () => {
 OrderHistoryPage.verifyLoginSuccess();
});

Given("user ID: {string}", (userId) => {
 OrderHistoryPage.setUserId(userId);
});

When("the user navigates to the 'Order History' section", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the order history page is displayed", () => {
 OrderHistoryPage.verifyOrderHistoryPage();
});

Given("order date: {string}", (orderDate) => {
 OrderHistoryPage.setOrderDate(orderDate);
});

When("the current date is {string}", (currentDate) => {
 OrderHistoryPage.setCurrentDate(currentDate);
});

Then("orders from {string} are visible", (orderDate) => {
 OrderHistoryPage.verifyOrdersVisible(orderDate);
});

When("the user checks the details of an order from {string}", (orderDate) => {
 OrderHistoryPage.checkOrderDetails(orderDate);
});

Then("order details are correctly displayed", () => {
 OrderHistoryPage.verifyOrderDetails();
});

When("the user attempts to search for an order older than one year", () => {
 OrderHistoryPage.searchOlderOrders();
});

Then("no orders older than one year are displayed", () => {
 OrderHistoryPage.verifyNoOlderOrders();
});

When("the user verifies the filtering options for date range", () => {
 OrderHistoryPage.verifyDateRangeFilter();
});

Then("date range filter is available and functional", () => {
 OrderHistoryPage.verifyFilterFunctionality();
});

When("the user selects a date range from {string} to {string}", (startDate, endDate) => {
 OrderHistoryPage.selectDateRange(startDate, endDate);
});

Then("orders within the selected date range are displayed", () => {
 OrderHistoryPage.verifyOrdersInRange();
});

When("the user checks for any missing orders within the one-year range", () => {
 OrderHistoryPage.checkMissingOrders();
});

Then("all orders within the one-year range are present", () => {
 OrderHistoryPage.verifyAllOrdersPresent();
});

When("the user validates the accuracy of the order details displayed", () => {
 OrderHistoryPage.validateOrderDetailsAccuracy();
});

Then("order details are accurate and complete", () => {
 OrderHistoryPage.verifyDetailsAccuracy();
});

When("the user attempts to export the order history for the past year", () => {
 OrderHistoryPage.exportOrderHistory();
});

Then("order history is successfully exported", () => {
 OrderHistoryPage.verifyExportSuccess();
});

When("the user checks the format of the exported order history file", () => {
 OrderHistoryPage.checkExportedFileFormat();
});

Then("exported file is in correct format and readable", () => {
 OrderHistoryPage.verifyFileFormat();
});

When("the user tries to delete an order from the history", () => {
 OrderHistoryPage.tryDeleteOrder();
});

Then("the user is unable to delete orders from history", () => {
 OrderHistoryPage.verifyOrderDeletionRestriction();
});

When("the user verifies the security measures for accessing order history", () => {
 OrderHistoryPage.verifySecurityMeasures();
});

Then("order history access is secure and requires authentication", () => {
 OrderHistoryPage.verifyAccessSecurity();
});

When("the user checks if the order history page is responsive and loads quickly", () => {
 OrderHistoryPage.checkPageResponsiveness();
});

Then("order history page loads efficiently without delays", () => {
 OrderHistoryPage.verifyPageLoadEfficiency();
});

When("the user ensures that the order history is consistent across different devices", () => {
 OrderHistoryPage.ensureConsistencyAcrossDevices();
});

Then("order history displays consistent information on all devices", () => {
 OrderHistoryPage.verifyConsistencyOnDevices();
});