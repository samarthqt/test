import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";
import LoginPage from "../pages/loginPage";

Given("the user logs in to the application with valid credentials", () => {
 LoginPage.login();
});

Given("navigates to the checkout page", () => {
 CheckoutPage.visit();
});

When("the user enters payment details and confirms the payment", () => {
 CheckoutPage.enterPaymentDetails();
 CheckoutPage.confirmPayment();
});

Then("the payment is processed successfully", () => {
 CheckoutPage.verifyPaymentSuccess();
});

Then("a confirmation message is displayed immediately", () => {
 CheckoutPage.verifyConfirmationMessage();
});

Given("the payment is processed successfully", () => {
 CheckoutPage.verifyPaymentSuccess();
});

When("the user checks the email notification", () => {
 CheckoutPage.checkEmailNotification();
});

Then("the email notification is received with payment confirmation", () => {
 CheckoutPage.verifyEmailNotification();
});

When("the user verifies the transaction details in the order history", () => {
 CheckoutPage.verifyTransactionDetails();
});

Then("the transaction details are updated in the order history", () => {
 CheckoutPage.verifyOrderHistoryUpdate();
});

Given("the user is logged in", () => {
 LoginPage.verifyUserLoggedIn();
});

When("the user logs out from the application", () => {
 LoginPage.logout();
});

Then("the user is logged out successfully", () => {
 LoginPage.verifyLogoutSuccess();
});

When("the user repeats the payment process using a different payment method", () => {
 CheckoutPage.repeatPaymentDifferentMethod();
});

Then("a confirmation message is displayed successfully for the different payment method", () => {
 CheckoutPage.verifyConfirmationMessageDifferentMethod();
});

When("the user attempts payment with incorrect payment details", () => {
 CheckoutPage.attemptPaymentIncorrectDetails();
});

Then("the system displays an error message for invalid payment details", () => {
 CheckoutPage.verifyErrorMessageInvalidDetails();
});

When("the user attempts payment without entering payment details", () => {
 CheckoutPage.attemptPaymentWithoutDetails();
});

Then("the system displays an error message for missing payment details", () => {
 CheckoutPage.verifyErrorMessageMissingDetails();
});

When("the payment is declined", () => {
 CheckoutPage.processDeclinedPayment();
});

Then("the system displays an error message for declined payment", () => {
 CheckoutPage.verifyErrorMessageDeclinedPayment();
});

When("the payment gateway is unavailable", () => {
 CheckoutPage.simulateGatewayUnavailable();
});

Then("the system displays an error message for unavailable payment gateway", () => {
 CheckoutPage.verifyErrorMessageGatewayUnavailable();
});

When("the network connection is lost during payment", () => {
 CheckoutPage.simulateNetworkLoss();
});

Then("the system displays an error message for network connection issues", () => {
 CheckoutPage.verifyErrorMessageNetworkIssues();
});

When("the user attempts payment with expired payment method", () => {
 CheckoutPage.attemptPaymentExpiredMethod();
});

Then("the system displays an error message for expired payment method", () => {
 CheckoutPage.verifyErrorMessageExpiredMethod();
});

When("the payment is successful but the confirmation message is delayed", () => {
 CheckoutPage.processPaymentWithDelayedConfirmation();
});

Then("the system eventually displays the confirmation message after a delay", () => {
 CheckoutPage.verifyDelayedConfirmationMessage();
});