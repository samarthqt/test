import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("user is logged in and on the checkout page", () => {
 CheckoutPage.visit();
 CheckoutPage.ensureLoggedIn();
});

When("user selects Credit Card as the payment method", () => {
 CheckoutPage.selectPaymentMethod('Credit Card');
});

When("user enters valid Credit Card details", () => {
 CheckoutPage.enterCreditCardDetails();
});

Then("Credit Card details are accepted and validated", () => {
 CheckoutPage.validateCreditCardDetails();
});

Then("transaction is processed successfully with confirmation message", () => {
 CheckoutPage.verifyTransactionSuccess();
});

When("user selects PayPal as the payment method", () => {
 CheckoutPage.selectPaymentMethod('PayPal');
});

When("user enters valid PayPal account details", () => {
 CheckoutPage.enterPayPalDetails();
});

Then("PayPal account details are accepted and validated", () => {
 CheckoutPage.validatePayPalDetails();
});

Given("user is logged in and on the checkout page on a mobile device", () => {
 CheckoutPage.visitMobile();
 CheckoutPage.ensureLoggedIn();
});

Then("payment method selection is accessible and functional on mobile", () => {
 CheckoutPage.verifyMobilePaymentMethodSelection();
});

When("user attempts to select an unsupported payment method", () => {
 CheckoutPage.attemptUnsupportedPaymentMethod();
});

Then("unsupported payment method is not selectable", () => {
 CheckoutPage.verifyUnsupportedMethodNotSelectable();
});

Then("error message is displayed", () => {
 CheckoutPage.verifyErrorMessageDisplayed();
});

Given("user is logged in and on the checkout page in a browser", () => {
 CheckoutPage.visitBrowser();
 CheckoutPage.ensureLoggedIn();
});

Then("payment method selection is consistent across browsers", () => {
 CheckoutPage.verifyConsistencyAcrossBrowsers();
});

Given("user is logged in and on the checkout page with a slow internet connection", () => {
 CheckoutPage.visitWithSlowConnection();
 CheckoutPage.ensureLoggedIn();
});

Then("payment method selection remains functional under slow connection", () => {
 CheckoutPage.verifyFunctionalityUnderSlowConnection();
});

Then("UI remains responsive during payment method selection", () => {
 CheckoutPage.verifyUIResponsiveness();
});

Given("user is logged in and on the checkout page with multiple items in the cart", () => {
 CheckoutPage.visitWithMultipleItems();
 CheckoutPage.ensureLoggedIn();
});

Then("payment method selection is functional with multiple items", () => {
 CheckoutPage.verifyFunctionalityWithMultipleItems();
});

When("user enters maximum transaction amount", () => {
 CheckoutPage.enterMaximumTransactionAmount();
});

Then("payment method selection accommodates maximum transaction amount", () => {
 CheckoutPage.verifyMaximumTransactionAmount();
});

When("user completes a transaction with a selected payment method", () => {
 CheckoutPage.completeTransaction();
});

Then("transaction confirmation reflects selected payment method", () => {
 CheckoutPage.verifyTransactionConfirmation();
});

When("user selects a payment method and attempts a transaction", () => {
 CheckoutPage.selectPaymentMethodAndAttemptTransaction();
});

When("the payment method is declined", () => {
 CheckoutPage.simulatePaymentDecline();
});

Then("error message is displayed for declined payment method", () => {
 CheckoutPage.verifyDeclinedPaymentErrorMessage();
});