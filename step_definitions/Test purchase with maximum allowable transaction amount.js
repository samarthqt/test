import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PurchasePage from "../pages/purchasePage";

Given("the user is logged into the application", () => {
 PurchasePage.login();
});

When("the user navigates to the product purchase section", () => {
 PurchasePage.navigateToPurchaseSection();
});

Then("the user should be able to access the purchase section without errors", () => {
 PurchasePage.verifyAccessToPurchaseSection();
});

Given("the user is in the product purchase section", () => {
 PurchasePage.verifyInPurchaseSection();
});

When("the user selects products to reach the maximum allowable transaction amount", () => {
 PurchasePage.selectProductsToMaxAmount();
});

Then("the products should be added to the cart successfully", () => {
 PurchasePage.verifyProductsAddedToCart();
});

Given("the user has products in the cart", () => {
 PurchasePage.verifyProductsInCart();
});

When("the user proceeds to checkout and selects a payment method", () => {
 PurchasePage.proceedToCheckout();
});

Then("the checkout process should proceed without errors", () => {
 PurchasePage.verifyCheckoutProcess();
});

Given("the user is at the checkout page", () => {
 PurchasePage.verifyAtCheckoutPage();
});

When("the total transaction amount is displayed", () => {
 PurchasePage.displayTotalTransactionAmount();
});

Then("the total amount should equal the maximum allowable transaction amount", () => {
 PurchasePage.verifyTotalAmountEqualsMax();
});

Given("the user is ready to make a payment", () => {
 PurchasePage.readyToMakePayment();
});

When("the user initiates the payment process", () => {
 PurchasePage.initiatePaymentProcess();
});

Then("the payment process should begin, showing a loading indicator", () => {
 PurchasePage.verifyPaymentProcessBegins();
});

Given("the payment process has been initiated", () => {
 PurchasePage.verifyPaymentProcessInitiated();
});

When("the payment details are processed", () => {
 PurchasePage.processPaymentDetails();
});

Then("the payment details should be encrypted and processed securely", () => {
 PurchasePage.verifyPaymentDetailsSecure();
});

Given("the payment process is in progress", () => {
 PurchasePage.verifyPaymentInProgress();
});

When("the transaction is being processed", () => {
 PurchasePage.processTransaction();
});

Then("no error messages should be displayed related to transaction limits", () => {
 PurchasePage.verifyNoErrorMessages();
});

Given("the transaction has been processed", () => {
 PurchasePage.verifyTransactionProcessed();
});

When("the transaction logs are checked", () => {
 PurchasePage.checkTransactionLogs();
});

Then("logs should accurately reflect the transaction details and status", () => {
 PurchasePage.verifyTransactionLogs();
});

Given("the transaction is successful", () => {
 PurchasePage.verifyTransactionSuccess();
});

When("the payment is completed", () => {
 PurchasePage.completePayment();
});

Then("the user should receive an email/SMS confirmation of the successful transaction", () => {
 PurchasePage.verifyConfirmationReceived();
});

Given("the system supports multiple transactions", () => {
 PurchasePage.verifySystemSupportsMultipleTransactions();
});

When("multiple transactions are made at the maximum amount", () => {
 PurchasePage.makeMultipleTransactionsAtMax();
});

Then("the system should process multiple transactions at maximum amount without errors", () => {
 PurchasePage.verifyMultipleTransactionsProcessed();
});

Given("the user attempts a transaction exceeding the maximum amount", () => {
 PurchasePage.attemptTransactionExceedingMax();
});

When("the transaction is initiated", () => {
 PurchasePage.initiateTransaction();
});

Then("the system should display an error message if the transaction amount exceeds the maximum limit", () => {
 PurchasePage.verifyErrorMessageForExceedingMax();
});

Given("the transaction amount exceeds the limit", () => {
 PurchasePage.verifyTransactionAmountExceedsLimit();
});

When("the user adjusts the transaction amount", () => {
 PurchasePage.adjustTransactionAmount();
});

Then("the user should be able to adjust the transaction amount if it exceeds the limit", () => {
 PurchasePage.verifyTransactionAmountAdjusted();
});

Given("the system processes transactions", () => {
 PurchasePage.verifySystemProcessesTransactions();
});

When("the transaction limits are checked", () => {
 PurchasePage.checkTransactionLimits();
});

Then("the system should comply with all relevant financial regulations regarding transaction limits", () => {
 PurchasePage.verifyComplianceWithRegulations();
});

Given("the user is on the transaction page", () => {
 PurchasePage.verifyUserOnTransactionPage();
});

When("the transaction limits are displayed", () => {
 PurchasePage.displayTransactionLimits();
});

Then("the UI should clearly display information about transaction limits and options", () => {
 PurchasePage.verifyUIDisplaysTransactionLimits();
});

Given("a high-value transaction is processed", () => {
 PurchasePage.processHighValueTransaction();
});

When("the transaction is completed", () => {
 PurchasePage.completeTransaction();
});

Then("no security vulnerabilities should be exposed during high-value transactions", () => {
 PurchasePage.verifyNoSecurityVulnerabilities();
});