import { Given, When, Then, And } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("a user has successfully made a payment", () => {
 PaymentPage.makePayment();
});

When("the payment is processed", () => {
 PaymentPage.processPayment();
});

Then("the user should receive a payment confirmation message immediately", () => {
 PaymentPage.verifyConfirmationMessage();
});

Then("a receipt should be generated", () => {
 PaymentPage.verifyReceiptGenerated();
});

And("the receipt should be sent to the user's email", () => {
 PaymentPage.verifyEmailReceipt();
});

And("the receipt should be sent as an SMS to the user's phone", () => {
 PaymentPage.verifySmsReceipt();
});

When("a receipt is generated", () => {
 PaymentPage.generateReceipt();
});

Then("the receipt should include the transaction amount", () => {
 PaymentPage.verifyTransactionAmount();
});

And("the receipt should include the payment method", () => {
 PaymentPage.verifyPaymentMethod();
});

And("the receipt should include the transaction date", () => {
 PaymentPage.verifyTransactionDate();
});

Given("a receipt has been generated", () => {
 PaymentPage.receiptGenerated();
});

When("the user navigates to their account history", () => {
 PaymentPage.navigateToAccountHistory();
});

Then("the user should be able to view the receipt", () => {
 PaymentPage.verifyReceiptInHistory();
});

When("the payment confirmation is sent", () => {
 PaymentPage.sendPaymentConfirmation();
});

Then("the system should log the payment confirmation for audit purposes", () => {
 PaymentPage.logPaymentConfirmation();
});