import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user views payment options", () => {
 CheckoutPage.viewPaymentOptions();
});

Then("the payment options should include credit/debit cards, PayPal, and other online payment methods", () => {
 CheckoutPage.verifyPaymentOptions();
});

When("the user selects a preferred payment method", () => {
 CheckoutPage.selectPreferredPaymentMethod();
});

Then("the system should allow easy selection of the payment method", () => {
 CheckoutPage.verifyEasySelection();
});

Given("the user selects a payment method", () => {
 CheckoutPage.selectPaymentMethod();
});

When("the transaction is processed", () => {
 CheckoutPage.processTransaction();
});

Then("the system should ensure secure transactions for all payment methods", () => {
 CheckoutPage.verifySecureTransactions();
});

Then("the payment processing should comply with industry standards", () => {
 CheckoutPage.verifyCompliance();
});

Given("the user completes a payment transaction", () => {
 CheckoutPage.completeTransaction();
});

When("the payment is successful", () => {
 CheckoutPage.verifyPaymentSuccess();
});

Then("the user should receive a confirmation of the successful payment", () => {
 CheckoutPage.verifyConfirmation();
});

Given("a payment transaction occurs", () => {
 CheckoutPage.transactionOccurs();
});

Then("the system should log the payment transaction for auditing purposes", () => {
 CheckoutPage.logTransaction();
});

Given("the user attempts a payment", () => {
 CheckoutPage.attemptPayment();
});

When("an error occurs during the payment process", () => {
 CheckoutPage.errorOccurs();
});

Then("the system should provide user-friendly error messages", () => {
 CheckoutPage.verifyErrorMessages();
});