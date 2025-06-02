import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("Stripe account setup is completed", () => {
 PaymentPage.verifyStripeSetup();
});

When("I navigate to the payment page", () => {
 PaymentPage.visit();
});

Then("the payment page is displayed correctly", () => {
 PaymentPage.verifyPageDisplayed();
});

Then("API keys are configured", () => {
 PaymentPage.verifyAPIKeysConfigured();
});

When("I select Stripe as the payment method", () => {
 PaymentPage.selectStripePaymentMethod();
});

Then("Stripe payment method is selected", () => {
 PaymentPage.verifyStripePaymentMethodSelected();
});

When("I enter valid credit card details", () => {
 PaymentPage.enterCreditCardDetails();
});

Then("credit card details are accepted", () => {
 PaymentPage.verifyCreditCardDetailsAccepted();
});

When("I enter valid billing address", () => {
 PaymentPage.enterBillingAddress();
});

Then("billing address is accepted", () => {
 PaymentPage.verifyBillingAddressAccepted();
});

When("I enter valid email address", () => {
 PaymentPage.enterEmailAddress();
});

Then("email address is accepted", () => {
 PaymentPage.verifyEmailAddressAccepted();
});

When("I enter product ID and amount to be charged", () => {
 PaymentPage.enterProductIdAndAmount();
});

Then("product ID and amount are accepted", () => {
 PaymentPage.verifyProductIdAndAmountAccepted();
});

When("I submit the payment", () => {
 PaymentPage.submitPayment();
});

Then("payment is processed successfully", () => {
 PaymentPage.verifyPaymentProcessed();
});

When("I verify transaction confirmation message", () => {
 PaymentPage.verifyTransactionConfirmationMessage();
});

Then("transaction confirmation message is displayed", () => {
 PaymentPage.verifyTransactionMessageDisplayed();
});

When("I check Stripe dashboard for transaction record", () => {
 PaymentPage.checkStripeDashboard();
});

Then("transaction record is present in Stripe dashboard", () => {
 PaymentPage.verifyTransactionRecordInDashboard();
});

When("I verify email notification for transaction", () => {
 PaymentPage.verifyEmailNotification();
});

Then("email notification is received", () => {
 PaymentPage.verifyEmailNotificationReceived();
});

When("I log out from the application", () => {
 PaymentPage.logout();
});

Then("user is logged out successfully", () => {
 PaymentPage.verifyLogoutSuccess();
});

When("I log back into the application", () => {
 PaymentPage.login();
});

Then("user is logged in successfully", () => {
 PaymentPage.verifyLoginSuccess();
});

When("I check order history for transaction", () => {
 PaymentPage.checkOrderHistory();
});

Then("transaction is present in order history", () => {
 PaymentPage.verifyTransactionInOrderHistory();
});

When("I verify customer support is available for transaction queries", () => {
 PaymentPage.verifyCustomerSupport();
});

Then("customer support is available", () => {
 PaymentPage.verifyCustomerSupportAvailable();
});

When("I ensure transaction details are logged for auditing", () => {
 PaymentPage.ensureTransactionDetailsLogged();
});

Then("transaction details are logged", () => {
 PaymentPage.verifyTransactionDetailsLogged();
});