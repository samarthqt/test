import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user has a registered account", () => {
 // Implement login or account registration logic here
});

Given("the user is logged in", () => {
 // Implement login logic here
});

When("the user navigates to the payment method update page", () => {
 PaymentPage.visitPaymentMethodUpdatePage();
});

Then("the user is directed to the payment method update page displaying current payment options", () => {
 PaymentPage.verifyCurrentPaymentOptions();
});

Given("the user is on the payment method update page", () => {
 PaymentPage.visitPaymentMethodUpdatePage();
});

When("the user selects a payment method to update", () => {
 PaymentPage.selectPaymentMethodToUpdate();
});

Then("current payment details are displayed for editing", () => {
 PaymentPage.verifyPaymentDetailsForEditing();
});

Given("the user has selected a payment method to update", () => {
 PaymentPage.selectPaymentMethodToUpdate();
});

When("the user enters new payment information", () => {
 PaymentPage.enterNewPaymentInformation();
});

Then("new payment information is verified and accepted", () => {
 PaymentPage.verifyAndAcceptNewPaymentInformation();
});

Given("the user has entered new payment information", () => {
 PaymentPage.enterNewPaymentInformation();
});

When("the user confirms the payment method update", () => {
 PaymentPage.confirmPaymentMethodUpdate();
});

Then("a confirmation message is displayed indicating successful update", () => {
 PaymentPage.verifySuccessfulUpdateMessage();
});

Given("the payment method update is successful", () => {
 PaymentPage.verifySuccessfulUpdateMessage();
});

When("the user checks their email", () => {
 PaymentPage.checkEmailForConfirmation();
});

Then("an email is received confirming payment method update", () => {
 PaymentPage.verifyEmailConfirmation();
});

Given("the payment method update is confirmed", () => {
 PaymentPage.verifySuccessfulUpdateMessage();
});

When("the user checks their account", () => {
 PaymentPage.checkUserAccount();
});

Then("the updated payment method is correctly listed under user account", () => {
 PaymentPage.verifyUpdatedPaymentMethodInAccount();
});

Given("the payment method is updated", () => {
 PaymentPage.verifyUpdatedPaymentMethodInAccount();
});

When("the user attempts to use the updated payment method for subscription", () => {
 PaymentPage.useUpdatedPaymentMethodForSubscription();
});

Then("subscription payment is processed successfully using the updated method", () => {
 PaymentPage.verifySubscriptionPaymentSuccess();
});

When("the user attempts to revert the payment method update", () => {
 PaymentPage.revertPaymentMethodUpdate();
});

Then("the user is able to revert payment method successfully", () => {
 PaymentPage.verifySuccessfulReversion();
});

Given("the payment method update is reverted within the allowed period", () => {
 PaymentPage.revertPaymentMethodUpdate();
});

When("the refund process is initiated", () => {
 PaymentPage.initiateRefundProcess();
});

Then("refund is processed as per policy", () => {
 PaymentPage.verifyRefundProcess();
});

When("the user checks for subscription payment conflicts", () => {
 PaymentPage.checkForSubscriptionPaymentConflicts();
});

Then("no conflicts are found; payment schedule is clear", () => {
 PaymentPage.verifyNoPaymentConflicts();
});

Given("the user wants to manage notifications for payment updates", () => {
 PaymentPage.navigateToNotificationSettings();
});

When("the user enables or disables notifications", () => {
 PaymentPage.toggleNotifications();
});

Then("user can enable/disable notifications successfully", () => {
 PaymentPage.verifyNotificationToggleSuccess();
});

Given("the user attempts to update payment method", () => {
 PaymentPage.attemptPaymentMethodUpdate();
});

When("the user enters invalid payment method information", () => {
 PaymentPage.enterInvalidPaymentInformation();
});

Then("an error message is displayed indicating payment method issue", () => {
 PaymentPage.verifyErrorMessageForInvalidPayment();
});

Given("the user updates the payment method", () => {
 PaymentPage.updatePaymentMethod();
});

When("the system processes the payment method change", () => {
 PaymentPage.processPaymentMethodChange();
});

Then("system updates payment method without errors", () => {
 PaymentPage.verifySystemUpdateWithoutErrors();
});

When("the payment renewal process occurs", () => {
 PaymentPage.initiatePaymentRenewalProcess();
});

Then("payment renews automatically as per schedule using updated method", () => {
 PaymentPage.verifyAutomaticPaymentRenewal();
});

Given("the subscription renewal is due", () => {
 PaymentPage.verifySubscriptionRenewalDue();
});

When("the user updates the payment method during subscription renewal", () => {
 PaymentPage.updatePaymentMethodDuringRenewal();
});

Then("payment method update is processed without affecting renewal", () => {
 PaymentPage.verifyUpdateDuringRenewal();
});