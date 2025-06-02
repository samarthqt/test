import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserAccountPage from "../pages/userAccountPage";

Given("a user account with valid credentials", () => {
 UserAccountPage.login();
});

Given("an order with ID 12345 is placed and ready for shipping", () => {
 UserAccountPage.verifyOrderReadyForShipping(12345);
});

When("the user logs into the system", () => {
 UserAccountPage.login();
});

Then("the user successfully logs into the system", () => {
 UserAccountPage.verifyLoginSuccess();
});

When("the user navigates to the 'Order History' section", () => {
 UserAccountPage.navigateToOrderHistory();
});

Then("the Order History page displays all past orders", () => {
 UserAccountPage.verifyOrderHistoryDisplay();
});

When("the user selects the order with ID 12345", () => {
 UserAccountPage.selectOrder(12345);
});

Then("the order details for ID 12345 are displayed", () => {
 UserAccountPage.verifyOrderDetailsDisplay(12345);
});

And("the shipping status is 'Ready for dispatch'", () => {
 UserAccountPage.verifyShippingStatus("Ready for dispatch");
});

When("the user clicks on 'Cancel Order' button", () => {
 UserAccountPage.clickCancelOrder();
});

Then("a cancellation confirmation dialog appears", () => {
 UserAccountPage.verifyCancellationDialog();
});

When("the user confirms cancellation by clicking 'Yes'", () => {
 UserAccountPage.confirmCancellation();
});

Then("the order status changes to 'Cancelled'", () => {
 UserAccountPage.verifyOrderStatus("Cancelled");
});

Then("a notification email for cancellation is received", () => {
 UserAccountPage.verifyCancellationEmail();
});

When("the user checks refund initiation status", () => {
 UserAccountPage.checkRefundInitiationStatus();
});

Then("the refund process is initiated for the cancelled order", () => {
 UserAccountPage.verifyRefundInitiation();
});

When("the user navigates to the 'Refund Status' section", () => {
 UserAccountPage.navigateToRefundStatus();
});

Then("the refund status is displayed as 'Processing'", () => {
 UserAccountPage.verifyRefundStatus("Processing");
});

When("the user logs out from the user account", () => {
 UserAccountPage.logout();
});

Then("the user successfully logs out from the system", () => {
 UserAccountPage.verifyLogoutSuccess();
});

When("the user attempts to track the cancelled order", () => {
 UserAccountPage.trackCancelledOrder();
});

Then("the system displays 'Order Cancelled, no tracking available'", () => {
 UserAccountPage.verifyNoTrackingAvailable();
});

When("the user checks the order status in the database", () => {
 UserAccountPage.checkOrderStatusInDatabase(12345);
});

Then("the database reflects order status as 'Cancelled'", () => {
 UserAccountPage.verifyDatabaseOrderStatus("Cancelled");
});

When("the user verifies system logs for cancellation request", () => {
 UserAccountPage.verifySystemLogsForCancellation();
});

Then("logs contain entry for cancellation request and status update", () => {
 UserAccountPage.verifyLogEntries();
});

When("the system performance is checked under cancellation load", () => {
 UserAccountPage.checkSystemPerformanceUnderLoad();
});

Then("the system performance remains optimal with no delays", () => {
 UserAccountPage.verifyOptimalPerformance();
});

When("the user reviews the user interface for cancellation process", () => {
 UserAccountPage.reviewCancellationUI();
});

Then("the UI is user-friendly and intuitive for cancellation requests", () => {
 UserAccountPage.verifyUserFriendlyUI();
});

When("customer support availability for cancellation queries is ensured", () => {
 UserAccountPage.ensureCustomerSupportAvailability();
});

Then("customer support is available and responsive to queries", () => {
 UserAccountPage.verifyCustomerSupportResponse();
});