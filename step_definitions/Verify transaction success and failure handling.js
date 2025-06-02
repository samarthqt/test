import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TransactionPage from "../pages/transactionPage";

Given("the user has valid test user credentials", () => {
  TransactionPage.visitLoginPage();
});

When("the user logs into the system", () => {
  TransactionPage.login();
});

Then("the user should be able to login successfully", () => {
  TransactionPage.verifyLoginSuccess();
});

Given("the user is logged in with a valid test user account", () => {
  TransactionPage.ensureUserIsLoggedIn();
});

And("the user has valid payment methods", () => {
  TransactionPage.checkValidPaymentMethods();
});

When("the user initiates a transaction with a valid amount", () => {
  TransactionPage.initiateTransactionWithValidAmount();
});

Then("the transaction should succeed without errors", () => {
  TransactionPage.verifyTransactionSuccess();
});

Given("a transaction is successfully completed", () => {
  TransactionPage.completeTransaction();
});

When("the user receives a confirmation message", () => {
  TransactionPage.receiveConfirmationMessage();
});

Then("the message should indicate success", () => {
  TransactionPage.verifySuccessMessage();
});

When("the user initiates a transaction with an invalid amount", () => {
  TransactionPage.initiateTransactionWithInvalidAmount();
});

Then("the transaction should fail with a clear error message", () => {
  TransactionPage.verifyTransactionFailure();
});

Given("a transaction has failed", () => {
  TransactionPage.failTransaction();
});

When("the user receives an error message", () => {
  TransactionPage.receiveErrorMessage();
});

Then("the message should be informative", () => {
  TransactionPage.verifyInformativeErrorMessage();
});

Given("a transaction is initiated", () => {
  TransactionPage.initiateTransaction();
});

When("the transaction is completed or failed", () => {
  TransactionPage.completeOrFailTransaction();
});

Then("the transaction details should be logged for both success and failure", () => {
  TransactionPage.verifyTransactionLogging();
});

Given("a transaction is in progress", () => {
  TransactionPage.transactionInProgress();
});

When("there is a network failure", () => {
  TransactionPage.simulateNetworkFailure();
});

Then("the system should handle the network failure gracefully", () => {
  TransactionPage.verifyNetworkFailureHandling();
});

When("the system processes the failure", () => {
  TransactionPage.processTransactionFailure();
});

Then("the transaction should be rolled back without affecting system state", () => {
  TransactionPage.verifyTransactionRollback();
});

Given("the user has an expired payment method", () => {
  TransactionPage.checkExpiredPaymentMethod();
});

When("a duplicate transaction is attempted", () => {
  TransactionPage.attemptDuplicateTransaction();
});

Then("the system should prevent or warn about duplicate transactions", () => {
  TransactionPage.verifyDuplicateTransactionWarning();
});

When("the user is notified", () => {
  TransactionPage.notifyUser();
});

Then("the user should be informed of the transaction failure", () => {
  TransactionPage.verifyFailureNotification();
});

Given("multiple transactions are initiated simultaneously", () => {
  TransactionPage.initiateMultipleTransactions();
});

When("the system processes these transactions", () => {
  TransactionPage.processSimultaneousTransactions();
});

Then("the system should handle multiple transactions without errors", () => {
  TransactionPage.verifySimultaneousTransactionsHandling();
});

When("the system recovers", () => {
  TransactionPage.recoverSystem();
});

Then("the system should allow subsequent transactions", () => {
  TransactionPage.verifySubsequentTransactions();
});

Given("a high transaction load is present", () => {
  TransactionPage.simulateHighTransactionLoad();
});

When("the system processes transactions", () => {
  TransactionPage.processTransactions();
});

Then("the system should maintain performance under load", () => {
  TransactionPage.verifyPerformanceUnderLoad();
});

When("the transaction is processed", () => {
  TransactionPage.processTransaction();
});

Then("the transaction should complete within predefined time limits", () => {
  TransactionPage.verifyTransactionTimeframe();
});