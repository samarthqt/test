import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SubscriptionPage from "../pages/subscriptionPage";

Given("the user is on the product subscription page", () => {
 SubscriptionPage.visitSubscriptionPage();
});

When("the user selects a product for subscription", () => {
 SubscriptionPage.selectProductForSubscription();
});

When("the user chooses the subscription frequency", () => {
 SubscriptionPage.chooseSubscriptionFrequency();
});

When("the user provides payment details", () => {
 SubscriptionPage.enterPaymentDetails();
});

Then("the system should confirm the subscription", () => {
 SubscriptionPage.verifySubscriptionConfirmation();
});

Then("the user should receive a confirmation email", () => {
 SubscriptionPage.verifyConfirmationEmail();
});

Given("the user has an active product subscription", () => {
 SubscriptionPage.verifyActiveSubscription();
});

When("the user navigates to the subscription management page", () => {
 SubscriptionPage.visitSubscriptionManagementPage();
});

When("the user selects to modify the subscription", () => {
 SubscriptionPage.selectModifySubscription();
});

When("the user changes the subscription frequency or product quantity", () => {
 SubscriptionPage.changeSubscriptionDetails();
});

Then("the system should update the subscription details", () => {
 SubscriptionPage.verifySubscriptionUpdate();
});

Then("the user should receive an update confirmation email", () => {
 SubscriptionPage.verifyUpdateConfirmationEmail();
});

When("the user selects to cancel the subscription", () => {
 SubscriptionPage.selectCancelSubscription();
});

Then("the system should confirm the cancellation", () => {
 SubscriptionPage.verifyCancellationConfirmation();
});

Then("the user should receive a cancellation confirmation email", () => {
 SubscriptionPage.verifyCancellationEmail();
});

Then("the user should see the subscription details including product, frequency, and next delivery date", () => {
 SubscriptionPage.verifySubscriptionDetails();
});

When("the payment details are invalid", () => {
 SubscriptionPage.enterInvalidPaymentDetails();
});

Then("the system should display an error message", () => {
 SubscriptionPage.verifyErrorMessage();
});

Then("the subscription should not be processed", () => {
 SubscriptionPage.verifySubscriptionNotProcessed();
});