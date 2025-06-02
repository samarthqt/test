import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RefundPage from "../pages/refundPage";

Given("the user is logged into the application with valid credentials", () => {
 RefundPage.login();
});

When("the user navigates to the 'Order History' section", () => {
 RefundPage.navigateToOrderHistory();
});

Then("the order history is displayed with past transactions", () => {
 RefundPage.verifyOrderHistoryDisplayed();
});

When("the user selects a transaction eligible for refund", () => {
 RefundPage.selectEligibleTransaction();
});

Then("the transaction details are displayed", () => {
 RefundPage.verifyTransactionDetailsDisplayed();
});

When("the user clicks on the 'Request Refund' button", () => {
 RefundPage.clickRequestRefundButton();
});

Then("the refund request form is displayed", () => {
 RefundPage.verifyRefundFormDisplayed();
});

When("the user enters refund amount and reason for refund", () => {
 RefundPage.enterRefundDetails();
});

Then("the refund details are entered successfully", () => {
 RefundPage.verifyRefundDetailsEntered();
});

When("the user selects the payment gateway for processing the refund", () => {
 RefundPage.selectPaymentGateway();
});

Then("the payment gateway is selected", () => {
 RefundPage.verifyPaymentGatewaySelected();
});

When("the user submits the refund request", () => {
 RefundPage.submitRefundRequest();
});

Then("the refund request is submitted successfully", () => {
 RefundPage.verifyRefundRequestSubmitted();
});

When("the user verifies the refund status in the transaction history", () => {
 RefundPage.verifyRefundStatus();
});

Then("the refund status is updated in the transaction history", () => {
 RefundPage.verifyRefundStatusUpdated();
});

When("the user checks email notification for refund confirmation", () => {
 RefundPage.checkEmailNotification();
});

Then("an email notification is received with refund confirmation", () => {
 RefundPage.verifyEmailNotificationReceived();
});

When("the user verifies the refund amount is credited back to the original payment method", () => {
 RefundPage.verifyRefundAmountCredited();
});

Then("the refund amount is credited back to the original payment method", () => {
 RefundPage.verifyRefundAmountCreditedBack();
});

When("the user logs out from the application", () => {
 RefundPage.logout();
});

Then("the user is logged out successfully", () => {
 RefundPage.verifyLogoutSuccessful();
});

Given("the user has completed a refund process using one payment gateway", () => {
 RefundPage.completeRefundProcess();
});

When("the user repeats the process using a different payment gateway", () => {
 RefundPage.repeatRefundProcessWithDifferentGateway();
});

Then("the refund is processed successfully through the different gateway", () => {
 RefundPage.verifyRefundProcessedThroughDifferentGateway();
});

Given("the user is on the refund request form", () => {
 RefundPage.verifyOnRefundForm();
});

When("the user attempts to refund an amount greater than the original transaction", () => {
 RefundPage.attemptInvalidRefundAmount();
});

Then("the system displays an error message for invalid refund amount", () => {
 RefundPage.verifyInvalidRefundAmountError();
});

When("the user attempts refund without selecting a payment gateway", () => {
 RefundPage.attemptRefundWithoutGateway();
});

Then("the system displays an error message for missing payment gateway selection", () => {
 RefundPage.verifyMissingGatewayError();
});

When("the user attempts refund with an invalid transaction ID", () => {
 RefundPage.attemptRefundWithInvalidTransactionID();
});

Then("the system displays an error message for invalid transaction ID", () => {
 RefundPage.verifyInvalidTransactionIDError();
});