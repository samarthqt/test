import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user is logged into their account", () => {
 PaymentPage.login();
});

When("the user selects a product or service to purchase", () => {
 PaymentPage.selectProduct();
});

When("proceeds to the checkout page", () => {
 PaymentPage.proceedToCheckout();
});

When("enters invalid payment details", () => {
 PaymentPage.enterInvalidPaymentDetails();
});

When("attempts to complete the transaction", () => {
 PaymentPage.attemptTransaction();
});

Then("the transaction fails due to invalid payment details", () => {
 PaymentPage.verifyTransactionFailure();
});

Then("the user receives a clear error message explaining the payment failure", () => {
 PaymentPage.verifyErrorMessage();
});

Given("the user receives a clear error message explaining the payment failure", () => {
 PaymentPage.verifyErrorMessage();
});

When("the user checks the system suggestions", () => {
 PaymentPage.checkSystemSuggestions();
});

Then("the system suggests checking payment details or using a different payment method", () => {
 PaymentPage.verifySuggestions();
});

Given("the transaction fails due to invalid payment details", () => {
 PaymentPage.verifyTransactionFailure();
});

Then("no confirmation message is received for the failed transaction", () => {
 PaymentPage.verifyNoConfirmationMessage();
});

When("the user attempts the transaction again with corrected payment details", () => {
 PaymentPage.enterValidPaymentDetails();
 PaymentPage.attemptTransaction();
});

Then("the transaction is successful with valid payment details", () => {
 PaymentPage.verifyTransactionSuccess();
});

Given("the transaction is successful with valid payment details", () => {
 PaymentPage.verifyTransactionSuccess();
});

Then("a confirmation message is received for the successful transaction", () => {
 PaymentPage.verifyConfirmationMessage();
});

When("the user checks the transaction history", () => {
 PaymentPage.checkTransactionHistory();
});

Then("the transaction history logs the failed attempt without confirmation", () => {
 PaymentPage.verifyFailedTransactionLog();
});

When("the user logs out from their account", () => {
 PaymentPage.logout();
});

When("logs back in", () => {
 PaymentPage.login();
});

Then("the account balance or credit remains unchanged after the failed transaction", () => {
 PaymentPage.verifyAccountBalanceUnchanged();
});

Then("system logs include details of the payment failure for auditing purposes", () => {
 PaymentPage.verifySystemLogs();
});

Given("the user attempts multiple consecutive transactions with invalid payment details", () => {
 PaymentPage.attemptMultipleInvalidTransactions();
});

Then("the system consistently handles payment failures and informs the user appropriately", () => {
 PaymentPage.verifyConsistentFailureHandling();
});