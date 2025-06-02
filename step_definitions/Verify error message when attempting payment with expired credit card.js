import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user has an expired credit card linked to their account", () => {
 PaymentPage.verifyExpiredCardLinked();
});

When("the user attempts to initiate a payment using the expired credit card", () => {
 PaymentPage.initiatePaymentWithExpiredCard();
});

Then("the payment attempt fails due to the expired credit card", () => {
 PaymentPage.verifyPaymentFailure();
});

Then("the user receives an error message indicating the card is expired", () => {
 PaymentPage.verifyErrorMessage("card is expired");
});

Given("the user has received an error message indicating the card is expired", () => {
 PaymentPage.verifyErrorMessageReceived();
});

When("the user checks the error message", () => {
 PaymentPage.checkErrorMessage();
});

Then("the error message is clear, accurate, and helpful", () => {
 PaymentPage.verifyErrorMessageClarity();
});

Given("the user has attempted a payment with an expired credit card", () => {
 PaymentPage.verifyPaymentAttemptWithExpiredCard();
});

When("the transaction fails", () => {
 PaymentPage.verifyTransactionFailure();
});

Then("the failed transaction is logged in the system with error details", () => {
 PaymentPage.verifyTransactionLogging();
});

When("the user updates their payment method to a valid card", () => {
 PaymentPage.updatePaymentMethodToValidCard();
});

Then("the user can update their payment method successfully", () => {
 PaymentPage.verifyPaymentMethodUpdateSuccess();
});

Given("the user is updating their payment method", () => {
 PaymentPage.startPaymentMethodUpdate();
});

When("the user submits the update", () => {
 PaymentPage.submitPaymentMethodUpdate();
});

Then("the system response time is quick and efficient during updates", () => {
 PaymentPage.verifyQuickResponseTime();
});

When("the error message is displayed", () => {
 PaymentPage.displayErrorMessage();
});

Then("the error message is visible and consistent on various devices", () => {
 PaymentPage.verifyErrorMessageConsistency();
});

When("the error message is generated", () => {
 PaymentPage.generateErrorMessage();
});

Then("no duplicate error messages are displayed", () => {
 PaymentPage.verifyNoDuplicateErrorMessages();
});

Then("the user receives guidance on updating expired card information", () => {
 PaymentPage.verifyGuidanceOnExpiredCard();
});

Given("the user has updated their payment method to a valid card", () => {
 PaymentPage.verifyPaymentMethodUpdateToValid();
});

When("the user attempts a payment again", () => {
 PaymentPage.retryPayment();
});

Then("a retry option is available once the payment method is updated", () => {
 PaymentPage.verifyRetryOptionAvailable();
});

When("the user reads the error message", () => {
 PaymentPage.readErrorMessage();
});

Then("the error message is intuitive and easy for users to understand", () => {
 PaymentPage.verifyUserFriendlyErrorMessage();
});

Then("user data is protected during error handling processes", () => {
 PaymentPage.verifyUserDataProtection();
});

Then("no additional fees are incurred due to the expired card", () => {
 PaymentPage.verifyNoAdditionalFees();
});

Then("the error message complies with all applicable standards", () => {
 PaymentPage.verifyErrorMessageCompliance();
});

Then("the error message is accessible and inclusive for all users", () => {
 PaymentPage.verifyErrorMessageAccessibility();
});