import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TransactionPage from "../pages/transactionPage";

Given("I am logged into the user account", () => {
 TransactionPage.login();
});

When("I select a product or service to purchase", () => {
 TransactionPage.selectProduct();
});

When("I proceed to the checkout page", () => {
 TransactionPage.proceedToCheckout();
});

When("I enter valid payment details", () => {
 TransactionPage.enterValidPaymentDetails();
});

When("I complete the transaction", () => {
 TransactionPage.completeTransaction();
});

Then("I should receive a confirmation message for the successful transaction", () => {
 TransactionPage.verifyConfirmationMessage();
});

When("I perform a transaction with invalid payment details", () => {
 TransactionPage.enterInvalidPaymentDetails();
 TransactionPage.completeTransaction();
});

Then("the transaction should fail", () => {
 TransactionPage.verifyTransactionFailure();
});

Then("I should not receive a confirmation message for the failed transaction", () => {
 TransactionPage.verifyNoConfirmationMessage();
});

When("I select different products or services to purchase", () => {
 TransactionPage.selectMultipleProducts();
});

When("I complete each transaction", () => {
 TransactionPage.completeEachTransaction();
});

Then("I should receive confirmation messages only for successful transactions", () => {
 TransactionPage.verifyMultipleConfirmationMessages();
});

When("I attempt a purchase with insufficient funds", () => {
 TransactionPage.enterInsufficientFunds();
 TransactionPage.completeTransaction();
});

Then("the confirmation message should contain the transaction ID, amount, and product/service details", () => {
 TransactionPage.verifyConfirmationDetails();
});

Then("the timestamp on the confirmation message should match the time of successful transaction completion", () => {
 TransactionPage.verifyConfirmationTimestamp();
});

When("I check the transaction history", () => {
 TransactionPage.checkTransactionHistory();
});

Then("the transaction history should reflect only successful transactions with received confirmations", () => {
 TransactionPage.verifyTransactionHistory();
});

When("I perform a failed transaction", () => {
 TransactionPage.performFailedTransaction();
});

Then("the failed transaction should be logged", () => {
 TransactionPage.verifyFailedTransactionLogged();
});

Then("no confirmation should be sent to the user", () => {
 TransactionPage.verifyNoConfirmationForFailed();
});