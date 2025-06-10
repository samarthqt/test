import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentGatewayPage from "../pages/paymentGatewayPage";

Given("the application is configured with Stripe API keys", () => {
 PaymentGatewayPage.configureStripe();
});

When("the application attempts to connect to Stripe", () => {
 PaymentGatewayPage.connectToStripe();
});

Then("the connection to Stripe should be successful", () => {
 PaymentGatewayPage.verifyStripeConnection();
});

Given("the application is configured with PayPal API credentials", () => {
 PaymentGatewayPage.configurePayPal();
});

When("the application attempts to connect to PayPal", () => {
 PaymentGatewayPage.connectToPayPal();
});

Then("the connection to PayPal should be successful", () => {
 PaymentGatewayPage.verifyPayPalConnection();
});

Given("the application is configured with credit/debit card processor API keys", () => {
 PaymentGatewayPage.configureCardProcessor();
});

When("the application attempts to connect to the credit/debit card processor", () => {
 PaymentGatewayPage.connectToCardProcessor();
});

Then("the connection to the credit/debit card processor should be successful", () => {
 PaymentGatewayPage.verifyCardProcessorConnection();
});

Given("the user has selected Stripe as the payment method", () => {
 PaymentGatewayPage.selectStripePayment();
});

When("the user completes the payment process", () => {
 PaymentGatewayPage.completePaymentProcess();
});

Then("the transaction should be completed without errors", () => {
 PaymentGatewayPage.verifyTransactionCompletion();
});

Given("the user has selected PayPal as the payment method", () => {
 PaymentGatewayPage.selectPayPalPayment();
});

When("the user completes the payment process", () => {
 PaymentGatewayPage.completePaymentProcess();
});

Then("the transaction should be completed without errors", () => {
 PaymentGatewayPage.verifyTransactionCompletion();
});

Given("the user has selected credit/debit card as the payment method", () => {
 PaymentGatewayPage.selectCardPayment();
});

When("the user completes the payment process", () => {
 PaymentGatewayPage.completePaymentProcess();
});

Then("the transaction should be completed without errors", () => {
 PaymentGatewayPage.verifyTransactionCompletion();
});

Given("the user is proceeding with a payment", () => {
 PaymentGatewayPage.proceedWithPayment();
});

When("the transaction is being processed", () => {
 PaymentGatewayPage.processTransaction();
});

Then("sensitive data should be encrypted", () => {
 PaymentGatewayPage.verifyDataEncryption();
});

Given("the transaction fails during processing", () => {
 PaymentGatewayPage.simulateTransactionFailure();
});

When("the failure is detected", () => {
 PaymentGatewayPage.detectFailure();
});

Then("the system should handle the failure gracefully", () => {
 PaymentGatewayPage.handleFailureGracefully();
});

Then("the user should be notified of the transaction failure", () => {
 PaymentGatewayPage.notifyUserOfFailure();
});

Given("the application is processing a payment", () => {
 PaymentGatewayPage.processPayment();
});

When("the transaction is initiated", () => {
 PaymentGatewayPage.initiateTransaction();
});

Then("the integration should comply with PCI DSS standards", () => {
 PaymentGatewayPage.verifyComplianceWithPCIDSS();
});