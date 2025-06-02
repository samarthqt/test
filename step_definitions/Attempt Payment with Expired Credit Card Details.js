import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("I am on the payment page", () => {
 PaymentPage.visit();
});

When("I select Stripe as the payment method", () => {
 PaymentPage.selectStripe();
});

When("I enter expired credit card details", () => {
 PaymentPage.enterExpiredCardDetails();
});

Then("I should see an error message for expired credit card", () => {
 PaymentPage.verifyExpiredCardError();
});

When("I enter a valid billing address", () => {
 PaymentPage.enterBillingAddress();
});

Then("the billing address should be accepted", () => {
 PaymentPage.verifyBillingAddressAccepted();
});

When("I enter a valid email address", () => {
 PaymentPage.enterEmailAddress();
});

Then("the email address should be accepted", () => {
 PaymentPage.verifyEmailAddressAccepted();
});

When("I enter a product ID and the amount to be charged", () => {
 PaymentPage.enterProductIdAndAmount();
});

Then("the product ID and amount should be accepted", () => {
 PaymentPage.verifyProductIdAndAmountAccepted();
});

When("I attempt to submit the payment", () => {
 PaymentPage.submitPayment();
});

Then("the payment submission should fail with an error message", () => {
 PaymentPage.verifyPaymentFailure();
});

Then("the error message details should be clear and informative", () => {
 PaymentPage.verifyErrorMessageDetails();
});

When("I check the Stripe dashboard for a failed transaction record", () => {
 PaymentPage.checkStripeDashboard();
});

Then("the failed transaction record should not be present in the Stripe dashboard", () => {
 PaymentPage.verifyNoFailedTransactionInStripe();
});

When("I verify no email notification is received for the failed transaction", () => {
 PaymentPage.verifyNoEmailNotification();
});

Then("no email notification should be received", () => {
 PaymentPage.verifyNoEmailNotificationReceived();
});

When("I log out from the application", () => {
 PaymentPage.logout();
});

Then("I should be logged out successfully", () => {
 PaymentPage.verifyLogoutSuccess();
});

When("I log back into the application", () => {
 PaymentPage.login();
});

Then("I should be logged in successfully", () => {
 PaymentPage.verifyLoginSuccess();
});

When("I check order history for the failed transaction", () => {
 PaymentPage.checkOrderHistory();
});

Then("the failed transaction should not be present in order history", () => {
 PaymentPage.verifyNoFailedTransactionInOrderHistory();
});

When("I verify customer support is available for transaction queries", () => {
 PaymentPage.verifyCustomerSupportAvailability();
});

Then("customer support should be available", () => {
 PaymentPage.verifyCustomerSupportIsAvailable();
});

When("I ensure failed transaction details are logged for auditing", () => {
 PaymentPage.ensureFailedTransactionLogged();
});

Then("the failed transaction details should be logged", () => {
 PaymentPage.verifyFailedTransactionDetailsLogged();
});