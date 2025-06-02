import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountDashboardPage from "../pages/accountDashboardPage";

Given("the user is logged into their account", () => {
 AccountDashboardPage.login();
});

Given("an order has been placed", () => {
 AccountDashboardPage.placeOrder();
});

When("the user navigates to the 'Orders' section in the account dashboard", () => {
 AccountDashboardPage.navigateToOrdersSection();
});

Then("the 'Orders' section is displayed", () => {
 AccountDashboardPage.verifyOrdersSectionDisplayed();
});

When("the user selects the most recent order from the list", () => {
 AccountDashboardPage.selectMostRecentOrder();
});

Then("the order details are displayed", () => {
 AccountDashboardPage.verifyOrderDetailsDisplayed();
});

Then("the order status matches the current status in the system", () => {
 AccountDashboardPage.verifyOrderStatus();
});

Then("the tracking number is displayed correctly", () => {
 AccountDashboardPage.verifyTrackingNumberDisplayed();
});

When("the user clicks on the tracking number to view shipping details", () => {
 AccountDashboardPage.clickTrackingNumber();
});

Then("the shipping details are displayed with tracking information", () => {
 AccountDashboardPage.verifyShippingDetailsDisplayed();
});

Then("the estimated delivery date is displayed correctly", () => {
 AccountDashboardPage.verifyEstimatedDeliveryDate();
});

Then("any updates or changes in delivery status are displayed", () => {
 AccountDashboardPage.verifyDeliveryStatusUpdates();
});

When("the user ensures the tracking link redirects to the carrier's website", () => {
 AccountDashboardPage.verifyTrackingLinkRedirection();
});

Then("the tracking link redirects correctly to the carrier's website", () => {
 AccountDashboardPage.verifyTrackingLinkRedirection();
});

Then("the order summary matches the transaction details", () => {
 AccountDashboardPage.verifyOrderSummary();
});

Then("all relevant notifications are displayed in the dashboard", () => {
 AccountDashboardPage.verifyNotificationsDisplayed();
});

When("the user logs out and logs back in", () => {
 AccountDashboardPage.logoutAndLogin();
});

Then("the order status and tracking details persist after logging back in", () => {
 AccountDashboardPage.verifyOrderStatusPersistence();
});

Then("the order can be filtered by its current status", () => {
 AccountDashboardPage.filterOrderByStatus();
});

Then("the order can be archived successfully", () => {
 AccountDashboardPage.archiveOrder();
});

Then("archived orders remain accessible in the user dashboard", () => {
 AccountDashboardPage.verifyArchivedOrdersAccessible();
});