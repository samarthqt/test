import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("a user account with access to the checkout page", () => {
 CheckoutPage.ensureUserHasAccess();
});

When("the user logs in to the user account", () => {
 CheckoutPage.login();
});

Then("the checkout page is displayed", () => {
 CheckoutPage.verifyCheckoutPageDisplayed();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyCheckoutPageDisplayed();
});

When("the user selects a payment method and enters payment details at the limit boundary", () => {
 CheckoutPage.selectPaymentMethod();
 CheckoutPage.enterPaymentDetailsAtLimitBoundary();
});

Then("the payment details are accepted and validated", () => {
 CheckoutPage.verifyPaymentDetailsAccepted();
});

Given("the payment details are validated", () => {
 CheckoutPage.verifyPaymentDetailsAccepted();
});

When("the user completes the transaction at the payment limit boundary", () => {
 CheckoutPage.completeTransactionAtLimitBoundary();
});

Then("the transaction is processed successfully with a confirmation message", () => {
 CheckoutPage.verifyTransactionProcessedSuccessfully();
});

Given("a completed transaction at the payment limit boundary", () => {
 CheckoutPage.verifyTransactionProcessedSuccessfully();
});

When("the transaction logs are checked", () => {
 CheckoutPage.checkTransactionLogs();
});

Then("the transaction logs accurately reflect the payment limit boundary", () => {
 CheckoutPage.verifyTransactionLogsReflectLimitBoundary();
});

Given("the user attempts a transaction slightly above the limit boundary", () => {
 CheckoutPage.attemptTransactionAboveLimitBoundary();
});

When("the transaction is processed", () => {
 CheckoutPage.processTransaction();
});

Then("the system displays an error message for exceeding the payment limit", () => {
 CheckoutPage.verifyErrorMessageExceedingLimit();
});

Given("the user attempts a transaction slightly below the limit boundary", () => {
 CheckoutPage.attemptTransactionBelowLimitBoundary();
});

When("the transaction is processed", () => {
 CheckoutPage.processTransaction();
});

Then("the transaction is processed successfully with a confirmation message", () => {
 CheckoutPage.verifyTransactionProcessedSuccessfully();
});

Given("a transaction at the payment limit boundary", () => {
 CheckoutPage.setupTransactionAtLimitBoundary();
});

When("network latency is simulated", () => {
 CheckoutPage.simulateNetworkLatency();
});

Then("the transaction process handles latency without data loss", () => {
 CheckoutPage.verifyLatencyHandling();
});

Given("a transaction at the payment limit boundary", () => {
 CheckoutPage.setupTransactionAtLimitBoundary();
});

When("the UI is checked during the transaction", () => {
 CheckoutPage.checkUIResponsiveness();
});

Then("the UI remains responsive and functional", () => {
 CheckoutPage.verifyUIResponsiveness();
});

Given("a transaction at the payment limit boundary is declined", () => {
 CheckoutPage.declineTransactionAtLimitBoundary();
});

When("the transaction is processed", () => {
 CheckoutPage.processTransaction();
});

Then("the system displays an error message for the declined transaction", () => {
 CheckoutPage.verifyErrorMessageForDeclinedTransaction();
});

Given("incorrect payment details at the limit boundary", () => {
 CheckoutPage.enterIncorrectPaymentDetails();
});

When("the transaction is attempted", () => {
 CheckoutPage.attemptTransaction();
});

Then("the system displays an error message for incorrect payment details", () => {
 CheckoutPage.verifyErrorMessageForIncorrectDetails();
});

Given("multiple items in the cart at the payment limit boundary", () => {
 CheckoutPage.addMultipleItemsToCart();
});

When("the transaction is processed", () => {
 CheckoutPage.processTransaction();
});

Then("the transaction is processed successfully with a confirmation message", () => {
 CheckoutPage.verifyTransactionProcessedSuccessfully();
});

Given("a completed transaction at the payment limit boundary", () => {
 CheckoutPage.verifyTransactionProcessedSuccessfully();
});

When("the transaction confirmation is checked", () => {
 CheckoutPage.checkTransactionConfirmation();
});

Then("the transaction confirmation accurately reflects the payment limit boundary", () => {
 CheckoutPage.verifyConfirmationReflectsLimitBoundary();
});

Given("a transaction at the payment limit boundary involving currency conversion", () => {
 CheckoutPage.setupTransactionWithCurrencyConversion();
});

When("the currency conversion is processed", () => {
 CheckoutPage.processCurrencyConversion();
});

Then("the currency conversion is handled accurately", () => {
 CheckoutPage.verifyCurrencyConversionAccuracy();
});

Given("a completed transaction at the payment limit boundary", () => {
 CheckoutPage.verifyTransactionProcessedSuccessfully();
});

When("a refund is requested", () => {
 CheckoutPage.requestRefund();
});

Then("refunds are processed correctly with confirmation", () => {
 CheckoutPage.verifyRefundProcessedCorrectly();
});

Given("a transaction at the payment limit boundary", () => {
 CheckoutPage.setupTransactionAtLimitBoundary();
});

When("transaction fees are calculated and displayed", () => {
 CheckoutPage.calculateAndDisplayTransactionFees();
});

Then("transaction fees are calculated and displayed correctly", () => {
 CheckoutPage.verifyTransactionFees();
});