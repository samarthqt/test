import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("the user logs in to the account with User ID {string}", (userID) => {
 OrderPage.login(userID);
});

When("the user navigates to the {string} section", (section) => {
 OrderPage.navigateToSection(section);
});

Then("the order history page is displayed with a list of past orders", () => {
 OrderPage.verifyOrderHistoryPage();
});

And("the user selects the order with Order ID {string}", (orderID) => {
 OrderPage.selectOrder(orderID);
});

Then("the order details page is displayed for Order ID {string}", (orderID) => {
 OrderPage.verifyOrderDetailsPage(orderID);
});

And("the cancellation period is {int} days", (days) => {
 OrderPage.verifyCancellationPeriod(days);
});

When("the user attempts to cancel the order", () => {
 OrderPage.attemptCancelOrder();
});

Then("the system displays a message indicating that the cancellation period has expired and the order cannot be canceled", () => {
 OrderPage.verifyCancellationExpiredMessage();
});

And("the cancellation button is disabled and cannot be clicked", () => {
 OrderPage.verifyCancellationButtonDisabled();
});

When("the user checks for any alternative actions suggested by the system", () => {
 OrderPage.checkAlternativeActions();
});

Then("the system suggests contacting customer support for further assistance", () => {
 OrderPage.verifyCustomerSupportSuggestion();
});

When("the user navigates to the customer support section", () => {
 OrderPage.navigateToCustomerSupport();
});

Then("customer support contact information is displayed", () => {
 OrderPage.verifyCustomerSupportInfo();
});

When("the user attempts to contact customer support via provided options", () => {
 OrderPage.contactCustomerSupport();
});

Then("customer support is contacted successfully", () => {
 OrderPage.verifyCustomerSupportContacted();
});

When("the user verifies any email notification received regarding the cancellation attempt", () => {
 OrderPage.verifyEmailNotification();
});

Then("an email notification is received stating the cancellation attempt and its status", () => {
 OrderPage.verifyEmailNotificationReceived();
});

When("the user checks the order status after the cancellation attempt", () => {
 OrderPage.checkOrderStatus();
});

Then("the order status remains unchanged as 'Processing' or 'Completed'", () => {
 OrderPage.verifyOrderStatusUnchanged();
});

When("the user reviews any system logs related to the cancellation attempt", () => {
 OrderPage.reviewSystemLogs();
});

Then("system logs indicate the cancellation attempt and its rejection due to expired period", () => {
 OrderPage.verifySystemLogs();
});

When("the user verifies the account does not show any unauthorized changes", () => {
 OrderPage.verifyAccountSecurity();
});

Then("user account details remain unchanged and secure", () => {
 OrderPage.verifyAccountUnchanged();
});

When("the user checks if any refund process is initiated mistakenly", () => {
 OrderPage.checkRefundProcess();
});

Then("no refund process is initiated as the cancellation was not successful", () => {
 OrderPage.verifyNoRefundInitiated();
});

When("the user selects another order within the valid cancellation period", () => {
 OrderPage.selectOrderWithinValidPeriod();
});

Then("the system allows cancellation and updates the order status accordingly", () => {
 OrderPage.verifyCancellationAllowed();
});

When("the user attempts to cancel an order", () => {
 OrderPage.attemptCancelOrder();
});

Then("the system responds promptly to the cancellation attempt with appropriate feedback", () => {
 OrderPage.verifyPromptResponse();
});