import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("a user with items in the cart", () => {
  // Assume items are already in the cart, navigate to cart page
  CheckoutPage.visitCart();
});

When("the user navigates to the checkout page", () => {
  CheckoutPage.goToCheckout();
});

Then("the checkout page is displayed with SSL encryption", () => {
  CheckoutPage.verifySSLEncryption();
});

Given("the checkout page is displayed with SSL encryption", () => {
  CheckoutPage.verifySSLEncryption();
});

When("the user checks the SSL certificate", () => {
  CheckoutPage.checkSSLCertificate();
});

Then("the SSL certificate is valid and active", () => {
  CheckoutPage.verifySSLCertificateValidity();
});

Given("the user is on the checkout page", () => {
  CheckoutPage.goToCheckout();
});

When("the user enters payment details including card number {string}, expiry date {string}, and CVV {string}", (cardNumber, expiryDate, cvv) => {
  CheckoutPage.enterPaymentDetails(cardNumber, expiryDate, cvv);
});

Then("the payment details are entered securely", () => {
  CheckoutPage.verifySecurePaymentEntry();
});

Given("the payment details are entered securely", () => {
  CheckoutPage.verifySecurePaymentEntry();
});

When("the user submits the payment information", () => {
  CheckoutPage.submitPayment();
});

Then("the payment information is submitted securely", () => {
  CheckoutPage.verifySecurePaymentSubmission();
});

Given("the payment information is submitted securely", () => {
  CheckoutPage.verifySecurePaymentSubmission();
});

When("the transaction is processed", () => {
  CheckoutPage.processTransaction();
});

Then("data is encrypted during the transaction", () => {
  CheckoutPage.verifyDataEncryption();
});

Given("the transaction is processed", () => {
  CheckoutPage.processTransaction();
});

When("checking for security alerts or notifications", () => {
  CheckoutPage.checkSecurityAlerts();
});

Then("no security alerts or notifications are triggered", () => {
  CheckoutPage.verifyNoSecurityAlerts();
});

When("the user checks the transaction status", () => {
  CheckoutPage.checkTransactionStatus();
});

Then("the transaction is processed successfully and confirmation is received", () => {
  CheckoutPage.verifyTransactionSuccess();
});

Given("the transaction is processed successfully", () => {
  CheckoutPage.verifyTransactionSuccess();
});

When("the user views their transaction history", () => {
  CheckoutPage.viewTransactionHistory();
});

Then("the transaction details are correctly recorded in the history", () => {
  CheckoutPage.verifyTransactionHistory();
});

When("the payment gateway logs the transaction", () => {
  CheckoutPage.logTransactionInGateway();
});

Then("the transaction is logged securely in the payment gateway", () => {
  CheckoutPage.verifySecureLogging();
});

When("checking for data leaks or breaches", () => {
  CheckoutPage.checkDataLeaks();
});

Then("no data leaks or breaches are detected", () => {
  CheckoutPage.verifyNoDataLeaks();
});

When("verifying the encryption protocol used", () => {
  CheckoutPage.verifyEncryptionProtocol();
});

Then("the encryption protocol is up to date and secure", () => {
  CheckoutPage.verifyEncryptionProtocolSecurity();
});

When("the user enters payment details using {string}", (paymentMethod) => {
  CheckoutPage.enterPaymentMethod(paymentMethod);
});

Then("all payment methods are processed securely", () => {
  CheckoutPage.verifyAllPaymentMethodsSecure();
});

Given("the transaction is in progress", () => {
  CheckoutPage.startTransaction();
});

When("a network interruption occurs", () => {
  CheckoutPage.simulateNetworkInterruption();
});

Then("the transaction resumes securely after interruption", () => {
  CheckoutPage.verifyTransactionResumption();
});

Given("a user with incorrect payment details", () => {
  CheckoutPage.enterIncorrectPaymentDetails();
});

Then("the system alerts the user and does not process the transaction", () => {
  CheckoutPage.verifySystemAlertForIncorrectDetails();
});

When("the transaction is completed", () => {
  CheckoutPage.completeTransaction();
});

Then("a confirmation email is sent securely with transaction details", () => {
  CheckoutPage.verifyConfirmationEmail();
});