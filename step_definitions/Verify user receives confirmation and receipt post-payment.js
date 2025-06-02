import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user has completed a purchase transaction with User ID {string}", (userId) => {
 PaymentPage.completeTransaction(userId);
});

When("the user navigates to the payment confirmation page", () => {
 PaymentPage.navigateToConfirmationPage();
});

Then("the user is redirected to the payment confirmation page", () => {
 cy.url().should("include", "/payment-confirmation");
});

Given("the user is on the payment confirmation page", () => {
 PaymentPage.verifyOnConfirmationPage();
});

Then("a confirmation message is displayed with transaction details", () => {
 PaymentPage.verifyConfirmationMessage();
});

Then("the payment method used is {string}", (paymentMethod) => {
 PaymentPage.verifyPaymentMethod(paymentMethod);
});

Given("the user has completed a payment transaction of {string}", (amount) => {
 PaymentPage.completeTransaction(amount);
});

When("the transaction is successful", () => {
 PaymentPage.verifyTransactionSuccess();
});

Then("an email receipt is sent to the user's registered email address", () => {
 PaymentPage.verifyEmailReceiptSent();
});

Given("the user receives an email receipt", () => {
 PaymentPage.receiveEmailReceipt();
});

Then("the email receipt includes transaction amount, payment method, and date", () => {
 PaymentPage.verifyEmailReceiptDetails();
});

Then("the email is sent to {string}", (email) => {
 PaymentPage.verifyEmailSentTo(email);
});

Given("the user has a completed transaction", () => {
 PaymentPage.verifyCompletedTransaction();
});

Then("the receipt is available in the user's account under transaction history", () => {
 PaymentPage.verifyReceiptInAccountHistory();
});

Then("the confirmation message is clear and correctly formatted", () => {
 PaymentPage.verifyConfirmationMessageFormat();
});

Given("a transaction has been completed", () => {
 PaymentPage.verifyTransactionCompletion();
});

Then("the transaction details are accurately logged in the system", () => {
 PaymentPage.verifyTransactionLogs();
});

Then("the receipt can be downloaded as a PDF from the email", () => {
 PaymentPage.verifyReceiptDownloadable();
});

Given("the user accesses the receipt from the account page", () => {
 PaymentPage.accessReceiptFromAccountPage();
});

Then("a print option is available for the receipt on the account page", () => {
 PaymentPage.verifyPrintOptionAvailable();
});

Given("the user accesses the receipt", () => {
 PaymentPage.accessReceipt();
});

Then("the receipt details match the transaction details in the system", () => {
 PaymentPage.verifyReceiptDetailsMatch();
});

Then("receipt generation is instantaneous and does not affect transaction speed", () => {
 PaymentPage.verifyReceiptGenerationSpeed();
});

Given("the user has access to the receipt", () => {
 PaymentPage.verifyReceiptAccess();
});

Then("the receipt is accessible and viewable on various devices", () => {
 PaymentPage.verifyReceiptAccessibility();
});

Then("the receipt is stored securely with proper access controls", () => {
 PaymentPage.verifyReceiptSecurity();
});

Then("no duplicate receipts are generated for the same transaction", () => {
 PaymentPage.verifyNoDuplicateReceipts();
});

Then("the receipt complies with legal and regulatory standards", () => {
 PaymentPage.verifyReceiptCompliance();
});