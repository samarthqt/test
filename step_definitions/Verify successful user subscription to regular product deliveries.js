import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SubscriptionPage from "../pages/subscriptionPage";

Given("the user is logged in with User ID {string}", (userId) => {
 SubscriptionPage.login(userId);
});

When("the user navigates to the product subscription page", () => {
 SubscriptionPage.visitSubscriptionPage();
});

Then("the user is directed to the subscription page displaying available products", () => {
 SubscriptionPage.verifySubscriptionPage();
});

Given("the user is on the subscription page", () => {
 SubscriptionPage.verifySubscriptionPage();
});

When("the user selects a product with Product ID {string}", (productId) => {
 SubscriptionPage.selectProduct(productId);
});

Then("product details are displayed including subscription options", () => {
 SubscriptionPage.verifyProductDetails();
});

Given("the user has selected a product for subscription", () => {
 SubscriptionPage.verifyProductSelection();
});

When("the user chooses the subscription frequency {string}", (frequency) => {
 SubscriptionPage.chooseFrequency(frequency);
});

Then("the selected frequency is highlighted and ready for confirmation", () => {
 SubscriptionPage.verifyFrequencySelection();
});

Given("the user has chosen the subscription frequency", () => {
 SubscriptionPage.verifyFrequencySelection();
});

When("the user enters payment information using Credit Card", () => {
 SubscriptionPage.enterPaymentInfo();
});

Then("the payment information is verified and accepted", () => {
 SubscriptionPage.verifyPaymentInfo();
});

Given("the payment information is accepted", () => {
 SubscriptionPage.verifyPaymentInfo();
});

When("the user confirms the subscription setup", () => {
 SubscriptionPage.confirmSubscriptionSetup();
});

Then("a confirmation message is displayed indicating successful subscription", () => {
 SubscriptionPage.verifySubscriptionConfirmation();
});

Given("the subscription setup is confirmed", () => {
 SubscriptionPage.verifySubscriptionConfirmation();
});

When("the user checks their email", () => {
 SubscriptionPage.checkEmail();
});

Then("an email is received confirming subscription details", () => {
 SubscriptionPage.verifyEmailConfirmation();
});

Given("the user has received email confirmation", () => {
 SubscriptionPage.verifyEmailConfirmation();
});

When("the user checks their account", () => {
 SubscriptionPage.checkAccountDetails();
});

Then("subscription details are correctly listed under the user account", () => {
 SubscriptionPage.verifyAccountSubscriptionDetails();
});

Given("the user has an active subscription", () => {
 SubscriptionPage.verifyActiveSubscription();
});

When("the user attempts to change the subscription frequency", () => {
 SubscriptionPage.changeSubscriptionFrequency();
});

Then("the user is able to change subscription frequency successfully", () => {
 SubscriptionPage.verifyFrequencyChange();
});

Given("the user has an active subscription", () => {
 SubscriptionPage.verifyActiveSubscription();
});

When("the user attempts to cancel the subscription", () => {
 SubscriptionPage.cancelSubscription();
});

Then("the subscription is canceled and a confirmation message is displayed", () => {
 SubscriptionPage.verifyCancellationConfirmation();
});

Given("the subscription is canceled within the allowed period", () => {
 SubscriptionPage.verifyCancellationWithinPeriod();
});

When("the user requests a refund", () => {
 SubscriptionPage.requestRefund();
});

Then("the refund is processed as per policy", () => {
 SubscriptionPage.verifyRefundProcess();
});

Given("the user has an active subscription", () => {
 SubscriptionPage.verifyActiveSubscription();
});

When("the system checks the delivery schedule", () => {
 SubscriptionPage.checkDeliverySchedule();
});

Then("no conflicts are found; schedule is clear", () => {
 SubscriptionPage.verifyScheduleClear();
});

Given("the user has an active subscription", () => {
 SubscriptionPage.verifyActiveSubscription();
});

When("the user attempts to enable/disable notifications", () => {
 SubscriptionPage.modifyNotificationSettings();
});

Then("the user can enable/disable notifications successfully", () => {
 SubscriptionPage.verifyNotificationSettings();
});

Given("the user is on the subscription payment page", () => {
 SubscriptionPage.verifyPaymentPage();
});

When("the user enters an invalid payment method", () => {
 SubscriptionPage.enterInvalidPaymentMethod();
});

Then("an error message is displayed indicating payment method issue", () => {
 SubscriptionPage.verifyPaymentErrorMessage();
});

Given("the user has changed the subscription frequency", () => {
 SubscriptionPage.verifyFrequencyChange();
});

When("the system updates the frequency", () => {
 SubscriptionPage.updateFrequency();
});

Then("the system updates frequency without errors", () => {
 SubscriptionPage.verifyFrequencyUpdate();
});

Given("the user has an active subscription", () => {
 SubscriptionPage.verifyActiveSubscription();
});

When("the subscription renewal period arrives", () => {
 SubscriptionPage.handleRenewalPeriod();
});

Then("the subscription renews automatically as per schedule", () => {
 SubscriptionPage.verifyAutomaticRenewal();
});