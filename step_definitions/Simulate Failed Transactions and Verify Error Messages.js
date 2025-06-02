import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ShoppingCartPage from "../pages/shoppingCartPage";
import CheckoutPage from "../pages/checkoutPage";
import PaymentPage from "../pages/paymentPage";

Given("the user is logged into the application", () => {
 cy.login();
});

When("the user navigates to the shopping cart", () => {
 ShoppingCartPage.visit();
});

Then("the shopping cart is displayed with all added items", () => {
 ShoppingCartPage.verifyItemsDisplayed();
});

Given("the user has items in the shopping cart", () => {
 ShoppingCartPage.verifyItemsExist();
});

When("the user proceeds to the checkout page", () => {
 CheckoutPage.visit();
});

Then("the checkout page is displayed with the order summary", () => {
 CheckoutPage.verifyOrderSummary();
});

Given("the checkout page is displayed with the order summary", () => {
 CheckoutPage.verifyOrderSummary();
});

When("the user selects 'Credit Card' as the payment option", () => {
 PaymentPage.selectCreditCardOption();
});

Then("the credit card payment form is displayed", () => {
 PaymentPage.verifyCreditCardFormDisplayed();
});

Given("the credit card payment form is displayed", () => {
 PaymentPage.verifyCreditCardFormDisplayed();
});

When("the user enters an invalid credit card number", () => {
 PaymentPage.enterInvalidCardNumber();
});

Then("the system displays an error message for the invalid card number", () => {
 PaymentPage.verifyInvalidCardNumberError();
});

When("the user enters an expired credit card", () => {
 PaymentPage.enterExpiredCard();
});

Then("the system displays an error message for the expired card", () => {
 PaymentPage.verifyExpiredCardError();
});

When("the user enters an incorrect CVV", () => {
 PaymentPage.enterIncorrectCVV();
});

Then("the system displays an error message for the incorrect CVV", () => {
 PaymentPage.verifyIncorrectCVVError();
});

When("the user attempts to place the order with insufficient funds", () => {
 PaymentPage.attemptOrderWithInsufficientFunds();
});

Then("the system displays an error message for insufficient funds", () => {
 PaymentPage.verifyInsufficientFundsError();
});

Given("the user attempts a transaction", () => {
 PaymentPage.attemptTransaction();
});

When("the transaction is declined", () => {
 PaymentPage.declineTransaction();
});

Then("the system displays a clear error message for the declined transaction", () => {
 PaymentPage.verifyDeclinedTransactionError();
});

When("there are network issues during payment processing", () => {
 PaymentPage.simulateNetworkIssues();
});

Then("the system displays a clear error message for network issues", () => {
 PaymentPage.verifyNetworkIssuesError();
});

When("the transaction times out", () => {
 PaymentPage.simulateTransactionTimeout();
});

Then("the system displays a clear error message for the transaction timeout", () => {
 PaymentPage.verifyTransactionTimeoutError();
});

Given("there are failed transactions", () => {
 PaymentPage.simulateFailedTransactions();
});

When("the user inspects the error logs", () => {
 PaymentPage.inspectErrorLogs();
});

Then("all failed transactions are recorded in the error logs", () => {
 PaymentPage.verifyErrorLogs();
});

Given("a transaction has failed", () => {
 PaymentPage.simulateFailedTransaction();
});

When("the user views the error message", () => {
 PaymentPage.viewErrorMessage();
});

Then("the user is provided with guidance on how to proceed after a failed transaction", () => {
 PaymentPage.verifyGuidanceAfterFailedTransaction();
});

When("the user attempts to retry the transaction", () => {
 PaymentPage.retryTransaction();
});

Then("the system allows the user to retry the transaction after a failure", () => {
 PaymentPage.verifyRetryTransactionAllowed();
});

Given("multiple consecutive transactions have failed", () => {
 PaymentPage.simulateMultipleFailedTransactions();
});

When("the user views the error messages", () => {
 PaymentPage.viewMultipleErrorMessages();
});

Then("the system handles multiple consecutive failed transactions gracefully with appropriate error messages", () => {
 PaymentPage.verifyHandlingOfMultipleFailedTransactions();
});

Given("there are failed transaction scenarios", () => {
 PaymentPage.simulateFailedTransactionScenarios();
});

When("the user proceeds through the checkout process", () => {
 CheckoutPage.proceedThroughCheckout();
});

Then("the checkout process remains stable and responsive even during failed transaction scenarios", () => {
 CheckoutPage.verifyCheckoutStabilityDuringFailures();
});