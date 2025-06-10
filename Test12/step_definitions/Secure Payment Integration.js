import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user is on the payment page", () => {
 PaymentPage.visit();
});

When("the user selects {string} as the payment method", (method) => {
 PaymentPage.selectPaymentMethod(method);
});

Then("the payment method should be set to {string}", (method) => {
 PaymentPage.verifyPaymentMethod(method);
});

Given("the user has entered payment details", () => {
 PaymentPage.enterPaymentDetails();
});

When("the payment is processed", () => {
 PaymentPage.processPayment();
});

Then("sensitive payment data should be encrypted", () => {
 PaymentPage.verifyDataEncryption();
});

Given("the user attempts a payment", () => {
 PaymentPage.attemptPayment();
});

When("an error occurs during the payment process", () => {
 PaymentPage.simulatePaymentError();
});

Then("the application should display an appropriate error message", () => {
 PaymentPage.verifyErrorMessage();
});

Given("the user has completed a payment", () => {
 PaymentPage.completePayment();
});

When("the payment is successful", () => {
 PaymentPage.verifyPaymentSuccess();
});

Then("the user should receive a payment confirmation notification", () => {
 PaymentPage.verifyPaymentConfirmation();
});

Given("a payment transaction occurs", () => {
 PaymentPage.initiateTransaction();
});

When("the transaction is processed", () => {
 PaymentPage.processTransaction();
});

Then("the system should log the payment transaction for auditing", () => {
 PaymentPage.verifyTransactionLogging();
});

Given("the application processes payments", () => {
 PaymentPage.processPayments();
});

When("payment data is handled", () => {
 PaymentPage.handlePaymentData();
});

Then("the application must comply with PCI DSS standards", () => {
 PaymentPage.verifyPCIDSSCompliance();
});

Given("multiple payment transactions occur", () => {
 PaymentPage.multipleTransactions();
});

When("the transactions are processed", () => {
 PaymentPage.processMultipleTransactions();
});

Then("the system must ensure payment data consistency", () => {
 PaymentPage.verifyDataConsistency();
});

When("the user views the payment options", () => {
 PaymentPage.viewPaymentOptions();
});

Then("the application should offer a user-friendly payment interface", () => {
 PaymentPage.verifyUserFriendlyInterface();
});

Given("the user wants to cancel a payment", () => {
 PaymentPage.initiateCancellation();
});

When("the user initiates a refund or cancellation", () => {
 PaymentPage.initiateRefundOrCancellation();
});

Then("the system must support refunds and cancellations per merchant policy", () => {
 PaymentPage.verifyRefundsAndCancellations();
});