import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("I am logged into my user account", () => {
 cy.login();
});

Given("I navigate to the checkout page", () => {
 CheckoutPage.visit();
});

When("I select Credit Card as the payment method", () => {
 CheckoutPage.selectPaymentMethod('Credit Card');
});

When("I enter expired Credit Card details", () => {
 CheckoutPage.enterCardDetails('expired');
});

Then("the system displays an error message for expired Credit Card", () => {
 CheckoutPage.verifyErrorMessage('expired Credit Card');
});

When("I enter an incorrect CVV number", () => {
 CheckoutPage.enterCVV('incorrect');
});

Then("the system displays an error message for incorrect CVV", () => {
 CheckoutPage.verifyErrorMessage('incorrect CVV');
});

When("I attempt a transaction with invalid PayPal account details", () => {
 CheckoutPage.enterPayPalDetails('invalid');
});

Then("the system displays an error message for invalid PayPal account", () => {
 CheckoutPage.verifyErrorMessage('invalid PayPal account');
});

When("I proceed with empty payment details", () => {
 CheckoutPage.proceedWithEmptyDetails();
});

Then("the system prompts me to enter payment details", () => {
 CheckoutPage.verifyPromptMessage('enter payment details');
});

When("I select an unsupported payment method", () => {
 CheckoutPage.selectPaymentMethod('unsupported');
});

Then("the system displays an error message for unsupported payment method", () => {
 CheckoutPage.verifyErrorMessage('unsupported payment method');
});

When("there is a network interruption during payment processing", () => {
 CheckoutPage.simulateNetworkInterruption();
});

Then("the system handles the interruption gracefully with an error message", () => {
 CheckoutPage.verifyErrorMessage('network interruption');
});

When("I select an incorrect currency for the transaction", () => {
 CheckoutPage.selectCurrency('incorrect');
});

Then("the system displays an error message for incorrect currency", () => {
 CheckoutPage.verifyErrorMessage('incorrect currency');
});

When("I attempt a transaction with an amount exceeding the limit", () => {
 CheckoutPage.enterTransactionAmount('exceeding limit');
});

Then("the system displays an error message for exceeding transaction limit", () => {
 CheckoutPage.verifyErrorMessage('exceeding transaction limit');
});

When("I enter an invalid billing address", () => {
 CheckoutPage.enterBillingAddress('invalid');
});

Then("the system displays an error message for invalid billing address", () => {
 CheckoutPage.verifyErrorMessage('invalid billing address');
});

When("I enter an invalid shipping address", () => {
 CheckoutPage.enterShippingAddress('invalid');
});

Then("the system displays an error message for invalid shipping address", () => {
 CheckoutPage.verifyErrorMessage('invalid shipping address');
});

When("I attempt a transaction with an expired promotional code", () => {
 CheckoutPage.enterPromotionalCode('expired');
});

Then("the system displays an error message for expired promotional code", () => {
 CheckoutPage.verifyErrorMessage('expired promotional code');
});

When("I attempt duplicate payment transactions", () => {
 CheckoutPage.attemptDuplicatePayments();
});

Then("the system displays an error message for duplicate payment attempts", () => {
 CheckoutPage.verifyErrorMessage('duplicate payment attempts');
});

When("I proceed with incomplete payment details", () => {
 CheckoutPage.proceedWithIncompleteDetails();
});

Then("the system prompts me to complete payment details", () => {
 CheckoutPage.verifyPromptMessage('complete payment details');
});