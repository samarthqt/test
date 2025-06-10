import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("Stripe and PayPal are integrated into the system", () => {
 PaymentPage.verifyIntegration();
});

When("a user initiates a payment", () => {
 PaymentPage.initiatePayment();
});

Then("the system should process the transaction securely", () => {
 PaymentPage.verifySecureProcessing();
});

Given("a user is making a payment", () => {
 PaymentPage.startPayment();
});

When("the payment data is transmitted", () => {
 PaymentPage.transmitData();
});

Then("the system should encrypt the data to ensure security", () => {
 PaymentPage.verifyDataEncryption();
});

Given("a user chooses to pay with a credit/debit card", () => {
 PaymentPage.selectCardPayment();
});

When("the user enters card details", () => {
 PaymentPage.enterCardDetails();
});

Then("the system should process the payment successfully", () => {
 PaymentPage.verifyCardPaymentSuccess();
});

Given("a user chooses to pay with PayPal", () => {
 PaymentPage.selectPayPalPayment();
});

When("the user logs into their PayPal account", () => {
 PaymentPage.loginPayPal();
});

Then("the system should process the payment successfully", () => {
 PaymentPage.verifyPayPalPaymentSuccess();
});

Given("a payment is processed successfully", () => {
 PaymentPage.verifyPaymentSuccess();
});

When("the transaction is completed", () => {
 PaymentPage.completeTransaction();
});

Then("the system should generate a payment confirmation and receipt", () => {
 PaymentPage.generateConfirmationAndReceipt();
});

Given("a payment transaction fails", () => {
 PaymentPage.simulateFailedTransaction();
});

When("the system detects the failure", () => {
 PaymentPage.detectFailure();
});

Then("an error message should be displayed to the user", () => {
 PaymentPage.displayErrorMessage();
});

Given("a user is on the payment page", () => {
 PaymentPage.visitPaymentPage();
});

When("the payment options are displayed", () => {
 PaymentPage.displayPaymentOptions();
});

Then("the user should see multiple payment options clearly", () => {
 PaymentPage.verifyPaymentOptionsVisibility();
});

Given("a payment transaction is initiated", () => {
 PaymentPage.initiateTransaction();
});

When("the transaction is processed", () => {
 PaymentPage.processTransaction();
});

Then("the system should log the transaction details for auditing", () => {
 PaymentPage.logTransactionDetails();
});

Given("a payment is processed", () => {
 PaymentPage.verifyPaymentProcessed();
});

When("the transaction is completed", () => {
 PaymentPage.completeTransaction();
});

Then("the order management system should be updated accordingly", () => {
 PaymentPage.updateOrderManagementSystem();
});

Given("the payment gateway is integrated", () => {
 PaymentPage.verifyGatewayIntegration();
});

When("a payment is processed", () => {
 PaymentPage.processPayment();
});

Then("the system should comply with PCI DSS standards", () => {
 PaymentPage.verifyPCIDSSCompliance();
});