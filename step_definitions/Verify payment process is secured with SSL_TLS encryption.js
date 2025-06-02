import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("User has items in the cart", () => {
  CheckoutPage.verifyItemsInCart();
});

Given("User is logged in", () => {
  CheckoutPage.verifyUserLoggedIn();
});

When("User navigates to the checkout page", () => {
  CheckoutPage.navigateToCheckout();
});

Then("User should be directed to the checkout page with SSL/TLS encryption enabled", () => {
  CheckoutPage.verifySSLEncryption();
});

When("User selects {string} as the payment method", (method) => {
  CheckoutPage.selectPaymentMethod(method);
});

Then("{string} option should be selected", (method) => {
  CheckoutPage.verifyPaymentMethodSelected(method);
});

When("User enters credit card details", () => {
  CheckoutPage.enterCreditCardDetails();
});

Then("Credit card details should be entered securely", () => {
  CheckoutPage.verifyCreditCardDetailsSecurity();
});

When("User proceeds to payment", () => {
  CheckoutPage.proceedToPayment();
});

Then("Payment process should initiate securely with {string}", (method) => {
  CheckoutPage.verifyPaymentProcessSecurity(method);
});

And("Payment should be confirmed securely and receipt should be generated", () => {
  CheckoutPage.verifyPaymentConfirmationAndReceipt();
});

Given("User has logged out and logged back in securely", () => {
  CheckoutPage.secureLogoutAndLogin();
});

When("User navigates to the checkout page again", () => {
  CheckoutPage.navigateToCheckoutAgain();
});

Given("User switches browser and repeats the test", () => {
  CheckoutPage.switchBrowserAndRepeatTest();
});

Then("SSL/TLS encryption should work across different browsers", () => {
  CheckoutPage.verifySSLEncryptionAcrossBrowsers();
});

Given("User has completed a transaction", () => {
  CheckoutPage.completeTransaction();
});

When("User checks for discrepancies in transaction details", () => {
  CheckoutPage.checkTransactionDiscrepancies();
});

Then("Transaction details should be accurate and consistent", () => {
  CheckoutPage.verifyTransactionDetailsAccuracy();
});

Given("User attempts to checkout using guest account", () => {
  CheckoutPage.guestCheckout();
});

Then("Guest account should complete checkout securely", () => {
  CheckoutPage.verifyGuestCheckoutSecurity();
});

Given("User is processing payment securely", () => {
  CheckoutPage.processPaymentSecurely();
});

Then("No console errors should appear during the test execution", () => {
  CheckoutPage.verifyNoConsoleErrors();
});