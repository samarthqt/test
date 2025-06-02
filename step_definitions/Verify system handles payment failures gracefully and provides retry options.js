import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("a user with User ID {string} attempts a payment transaction of {int} using a Credit Card", (userId, amount) => {
 PaymentPage.initiatePayment(userId, amount);
});

When("the payment fails due to insufficient funds", () => {
 PaymentPage.simulateInsufficientFunds();
});

Then("the user receives a clear error message indicating payment failure", () => {
 PaymentPage.verifyErrorMessage();
});

Given("the user encounters a payment failure due to insufficient funds", () => {
 PaymentPage.simulateInsufficientFunds();
});

When("the error page is displayed", () => {
 PaymentPage.verifyErrorPageDisplayed();
});

Then("a retry option is available for the user to attempt the payment again", () => {
 PaymentPage.verifyRetryOptionAvailable();
});

Given("a payment failure with Error Code {string} (Insufficient Funds) using a Credit Card", (errorCode) => {
 PaymentPage.simulatePaymentFailure(errorCode);
});

When("the user selects the retry option", () => {
 PaymentPage.selectRetryOption();
});

Then("the user can retry the payment with the same method", () => {
 PaymentPage.verifyRetryWithSameMethod();
});

Given("a failed payment transaction attempt", () => {
 PaymentPage.simulateFailedTransaction();
});

Then("the failed transaction is logged in the system with error details", () => {
 PaymentPage.verifyTransactionLogged();
});

Given("a user encounters a payment failure", () => {
 PaymentPage.simulatePaymentFailure();
});

When("the user chooses to retry the payment", () => {
 PaymentPage.selectRetryOption();
});

Then("the user can select a different payment method and retry the transaction", () => {
 PaymentPage.verifyChangePaymentMethod();
});

Given("a user retries a payment transaction", () => {
 PaymentPage.retryPayment();
});

Then("the system response time is quick and efficient during the retry", () => {
 PaymentPage.verifyQuickResponseTime();
});

Given("a user encounters a payment failure", () => {
 PaymentPage.simulatePaymentFailure();
});

When("the user accesses the retry option on various devices", () => {
 PaymentPage.accessRetryOptionOnDevices();
});

Then("the retry option is functional and accessible on all devices", () => {
 PaymentPage.verifyRetryOptionOnDevices();
});

Given("a user retries payment transactions multiple times", () => {
 PaymentPage.retryMultipleTimes();
});

Then("no duplicate transaction entries are created during retries", () => {
 PaymentPage.verifyNoDuplicateEntries();
});

Given("a user encounters repeated payment failures", () => {
 PaymentPage.simulateRepeatedFailures();
});

Then("the retry option is persistent until a successful transaction is completed", () => {
 PaymentPage.verifyPersistentRetryOption();
});

Given("a user retries a payment transaction", () => {
 PaymentPage.retryPayment();
});

Then("no additional fees are incurred during payment retries", () => {
 PaymentPage.verifyNoAdditionalFees();
});

Given("a user encounters a payment failure", () => {
 PaymentPage.simulatePaymentFailure();
});

Then("the user receives guidance on resolving payment issues from the system", () => {
 PaymentPage.verifyGuidanceProvided();
});

Given("a user encounters a payment failure", () => {
 PaymentPage.simulatePaymentFailure();
});

When("the user accesses the retry option", () => {
 PaymentPage.accessRetryOption();
});

Then("the retry option is intuitive and easy for users to navigate", () => {
 PaymentPage.verifyUserFriendlyRetryOption();
});

Given("a user retries a payment transaction", () => {
 PaymentPage.retryPayment();
});

Then("the retry attempts are secure and user data is protected", () => {
 PaymentPage.verifySecureRetryAttempts();
});

Given("a payment transaction fails due to a network error", () => {
 PaymentPage.simulateNetworkError();
});

Then("the retry option is available for network-related payment failures", () => {
 PaymentPage.verifyRetryOptionForNetworkErrors();
});