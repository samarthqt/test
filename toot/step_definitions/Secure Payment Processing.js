import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visitCheckoutPage();
});

When("the user enters valid payment details", () => {
 CheckoutPage.enterValidPaymentDetails();
});

When("the user enters invalid payment details", () => {
 CheckoutPage.enterInvalidPaymentDetails();
});

When("the user submits the payment", () => {
 CheckoutPage.submitPayment();
});

When("the user is on the payment page", () => {
 CheckoutPage.visitPaymentPage();
});

When("the user decides to cancel the payment", () => {
 CheckoutPage.cancelPayment();
});

When("a payment is processed", () => {
 CheckoutPage.processPayment();
});

Then("the payment should be processed successfully", () => {
 CheckoutPage.verifyPaymentSuccess();
});

Then("the transaction should be encrypted", () => {
 CheckoutPage.verifyTransactionEncryption();
});

Then("the payment should not be processed", () => {
 CheckoutPage.verifyPaymentFailure();
});

Then("an error message should be displayed indicating invalid payment details", () => {
 CheckoutPage.verifyInvalidPaymentErrorMessage();
});

Then("the payment data should be encrypted", () => {
 CheckoutPage.verifyPaymentDataEncryption();
});

Then("encryption should be verified through security logs", () => {
 CheckoutPage.verifyEncryptionInSecurityLogs();
});

Then("the connection should be secure", () => {
 CheckoutPage.verifySecureConnection();
});

Then("the URL should start with \"https\"", () => {
 CheckoutPage.verifyHttpsUrl();
});

Given("the payment gateway is experiencing delays", () => {
 CheckoutPage.simulatePaymentGatewayDelay();
});

Then("the user should be informed of a payment processing delay", () => {
 CheckoutPage.verifyPaymentProcessingDelayMessage();
});

Then("the payment should eventually be processed securely", () => {
 CheckoutPage.verifyEventualSecurePaymentProcessing();
});

Then("the user should be returned to the checkout page without any charges", () => {
 CheckoutPage.verifyReturnToCheckoutWithoutCharges();
});

Then("the transaction should be logged", () => {
 CheckoutPage.verifyTransactionLogging();
});

Then("monitored for any security breaches", () => {
 CheckoutPage.verifyMonitoringForSecurityBreaches();
});