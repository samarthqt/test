import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user navigates to the payment page", () => {
 PaymentPage.visit();
});

Then("the payment page is displayed correctly", () => {
 PaymentPage.verifyPageDisplay();
});

When("the user selects Stripe as the payment method", () => {
 PaymentPage.selectStripe();
});

Then("Stripe payment method is selected", () => {
 PaymentPage.verifyStripeSelected();
});

When("the user enters valid credit card details", () => {
 PaymentPage.enterCreditCardDetails();
});

Then("the credit card details are accepted", () => {
 PaymentPage.verifyCreditCardAccepted();
});

When("the user enters a valid billing address", () => {
 PaymentPage.enterBillingAddress();
});

Then("the billing address is accepted", () => {
 PaymentPage.verifyBillingAddressAccepted();
});

When("the user enters a valid email address", () => {
 PaymentPage.enterEmailAddress();
});

Then("the email address is accepted", () => {
 PaymentPage.verifyEmailAccepted();
});

When("the user enters the product ID and maximum amount to be charged", () => {
 PaymentPage.enterProductIDAndAmount();
});

Then("the product ID and maximum amount are accepted", () => {
 PaymentPage.verifyProductIDAndAmountAccepted();
});

When("the user submits the payment", () => {
 PaymentPage.submitPayment();
});

Then("the payment is processed successfully", () => {
 PaymentPage.verifyPaymentProcessed();
});

Then("the transaction confirmation message is displayed", () => {
 PaymentPage.verifyTransactionConfirmation();
});

Then("the transaction record is present in the Stripe dashboard", () => {
 PaymentPage.verifyTransactionInStripeDashboard();
});

Then("the email notification for the transaction is received", () => {
 PaymentPage.verifyEmailNotificationReceived();
});

When("the user logs out from the application", () => {
 PaymentPage.logout();
});

Then("the user is logged out successfully", () => {
 PaymentPage.verifyLogoutSuccess();
});

When("the user logs back into the application", () => {
 PaymentPage.login();
});

Then("the user is logged in successfully", () => {
 PaymentPage.verifyLoginSuccess();
});

Then("the transaction is present in the order history", () => {
 PaymentPage.verifyTransactionInOrderHistory();
});

Then("customer support is available for transaction queries", () => {
 PaymentPage.verifyCustomerSupportAvailability();
});

Then("transaction details are logged for auditing", () => {
 PaymentPage.verifyTransactionDetailsLogged();
});