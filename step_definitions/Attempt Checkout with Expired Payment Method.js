import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("a user account with items in cart", () => {
 // Assume user is logged in and items are in cart
});

When("the user navigates to the checkout page", () => {
 CheckoutPage.visitCheckoutPage();
});

Then("the checkout page is displayed", () => {
 CheckoutPage.verifyCheckoutPageDisplayed();
});

Given("expired payment method details", () => {
 // Assume expired payment details are available
});

When("the user enters expired payment details including card number, expiry date, and CVV", () => {
 CheckoutPage.enterExpiredPaymentDetails();
});

Then("payment details are entered", () => {
 CheckoutPage.verifyPaymentDetailsEntered();
});

Given("payment method is Credit Card", () => {
 // Assume payment method is set to Credit Card
});

When("the user attempts to submit the payment information", () => {
 CheckoutPage.submitPaymentInformation();
});

Then("the system prevents submission due to expired payment method", () => {
 CheckoutPage.verifySubmissionPrevented();
});

Given("card number is 4111 1111 1111 1111", () => {
 // Assume card number is set
});

When("the system displays an error message", () => {
 CheckoutPage.verifyErrorMessageDisplayed();
});

Then("the error message indicates payment method is expired", () => {
 CheckoutPage.verifyErrorMessageForExpiredMethod();
});

Given("expiry date is 01/21", () => {
 // Assume expiry date is set
});

When("checking for prompts to update payment information", () => {
 CheckoutPage.checkForUpdatePrompts();
});

Then("the user is prompted to update payment information", () => {
 CheckoutPage.verifyUpdatePromptDisplayed();
});

Given("CVV is 456", () => {
 // Assume CVV is set
});

When("the user attempts checkout with updated payment method", () => {
 CheckoutPage.attemptCheckoutWithUpdatedMethod();
});

Then("checkout proceeds with valid payment method", () => {
 CheckoutPage.verifyCheckoutProceeds();
});

When("verifying transaction history for failed attempt with expired method", () => {
 CheckoutPage.verifyTransactionHistoryForFailedAttempt();
});

Then("the failed transaction is logged with reason for failure", () => {
 CheckoutPage.verifyFailedTransactionLogged();
});

When("ensuring system does not process transaction with expired method", () => {
 CheckoutPage.ensureTransactionNotProcessed();
});

Then("the transaction is not processed", () => {
 CheckoutPage.verifyTransactionNotProcessed();
});

When("testing system response with different expired payment methods", () => {
 CheckoutPage.testResponseWithDifferentExpiredMethods();
});

Then("all expired methods are rejected with appropriate error messages", () => {
 CheckoutPage.verifyAllExpiredMethodsRejected();
});

When("simulating network interruption during payment submission", () => {
 CheckoutPage.simulateNetworkInterruption();
});

Then("the system alerts user and does not process transaction", () => {
 CheckoutPage.verifyNetworkInterruptionAlert();
});

When("checking system logs for error handling and alerts", () => {
 CheckoutPage.checkSystemLogs();
});

Then("logs capture error and user actions accurately", () => {
 CheckoutPage.verifyLogsCaptureErrors();
});

When("verifying user receives notification for failed transaction", () => {
 CheckoutPage.verifyUserNotificationForFailedTransaction();
});

Then("notification is sent with details of failure", () => {
 CheckoutPage.verifyNotificationDetails();
});

When("testing system response to incorrect CVV with expired method", () => {
 CheckoutPage.testResponseToIncorrectCVV();
});

Then("the system alerts user to both expired method and incorrect CVV", () => {
 CheckoutPage.verifyAlertsForExpiredAndIncorrectCVV();
});

When("attempting checkout with expired method from mobile device", () => {
 CheckoutPage.attemptCheckoutFromMobile();
});

Then("same error messages and prompts are displayed on mobile", () => {
 CheckoutPage.verifyMobileErrorMessages();
});

When("ensuring user can update payment details easily from error prompt", () => {
 CheckoutPage.ensureEasyUpdateFromErrorPrompt();
});

Then("the user is able to update payment details successfully", () => {
 CheckoutPage.verifySuccessfulPaymentUpdate();
});