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

When("the user selects a product to purchase", () => {
 PurchasePage.selectProduct();
});

Then("the product should be added to the cart successfully", () => {
 PurchasePage.verifyProductAddedToCart();
});

Given("the product is added to the cart", () => {
 PurchasePage.verifyProductInCart();
});

When("the user proceeds to checkout and selects a payment method", () => {
 PurchasePage.proceedToCheckout();
});

Then("the checkout process should proceed without errors", () => {
 PurchasePage.verifyCheckoutProcess();
});

Given("the user has selected a payment method", () => {
 PurchasePage.verifyPaymentMethodSelected();
});

When("the user initiates the payment process", () => {
 PurchasePage.initiatePaymentProcess();
});

Then("the payment process should begin, showing a loading indicator", () => {
 PurchasePage.verifyPaymentLoadingIndicator();
});

Given("the payment process is initiated", () => {
 PurchasePage.verifyPaymentProcessInitiated();
});

When("a network interruption is simulated during payment processing", () => {
 PurchasePage.simulateNetworkInterruption();
});

Then("the system should detect the interruption and pause the payment process", () => {
 PurchasePage.verifyInterruptionDetected();
});

Given("the network connection is restored", () => {
 PurchasePage.verifyNetworkRestored();
});

When("the user attempts to resume payment", () => {
 PurchasePage.resumePayment();
});

Then("the system should resume payment processing without loss of data", () => {
 PurchasePage.verifyPaymentResumed();
});

When("the system attempts to retry payment", () => {
 PurchasePage.retryPayment();
});

Then("payment should be retried automatically, or user should be prompted to retry", () => {
 PurchasePage.verifyAutomaticRetryOrPrompt();
});

Given("a network interruption occurs during payment processing", () => {
 PurchasePage.simulateNetworkInterruption();
});

When("the user checks for error messages or notifications", () => {
 PurchasePage.checkErrorMessages();
});

Then("the user should receive clear error messages or notifications about the interruption", () => {
 PurchasePage.verifyErrorMessagesReceived();
});

Given("a network interruption occurs", () => {
 PurchasePage.simulateNetworkInterruption();
});

When("the user checks transaction logs", () => {
 PurchasePage.checkTransactionLogs();
});

Then("logs should accurately record the interruption and any retries or cancellations", () => {
 PurchasePage.verifyTransactionLogs();
});

When("the user verifies payment status", () => {
 PurchasePage.verifyPaymentStatus();
});

Then("payment status should be updated correctly, indicating success or failure", () => {
 PurchasePage.verifyPaymentStatusUpdated();
});

Given("multiple network interruptions occur", () => {
 PurchasePage.simulateMultipleInterruptions();
});

When("the system processes the transaction", () => {
 PurchasePage.processTransaction();
});

Then("the system should handle multiple interruptions gracefully, maintaining transaction integrity", () => {
 PurchasePage.verifyMultipleInterruptionsHandled();
});

When("the system saves the transaction state", () => {
 PurchasePage.saveTransactionState();
});

Then("transaction state should be saved, allowing for seamless resumption after connection is restored", () => {
 PurchasePage.verifyTransactionStateSaved();
});

When("the user looks for guidance in the UI", () => {
 PurchasePage.checkUIGuidance();
});

Then("UI should offer helpful guidance or options during network interruptions", () => {
 PurchasePage.verifyUIGuidance();
});

Given("a network interruption persists", () => {
 PurchasePage.simulateNetworkInterruption();
});

When("the user attempts to cancel the transaction", () => {
 PurchasePage.cancelTransaction();
});

Then("the user should be able to cancel the transaction if the network interruption persists", () => {
 PurchasePage.verifyTransactionCancellation();
});

When("the system is checked for security vulnerabilities", () => {
 PurchasePage.checkSecurityVulnerabilities();
});

Then("no security vulnerabilities should be exposed during interruptions", () => {
 PurchasePage.verifySecurityDuringInterruptions();
});