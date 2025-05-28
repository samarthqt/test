import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SubscriptionPage from "../pages/subscriptionPage";

Given("the user is logged into the application", () => {
 SubscriptionPage.login();
});

Given("the user is on the product subscription page", () => {
 SubscriptionPage.visitSubscriptionPage();
});

Given("the user selects a product to subscribe", () => {
 SubscriptionPage.selectProduct();
});

When("the user chooses a subscription plan", () => {
 SubscriptionPage.chooseSubscriptionPlan();
});

When("the user enters payment details", () => {
 SubscriptionPage.enterPaymentDetails();
});

When("the user confirms the subscription", () => {
 SubscriptionPage.confirmSubscription();
});

Then("the system should display a subscription confirmation message", () => {
 SubscriptionPage.verifySubscriptionConfirmation();
});

Then("the user should receive a confirmation email", () => {
 SubscriptionPage.verifyConfirmationEmail();
});

Given("the user has an active product subscription", () => {
 SubscriptionPage.verifyActiveSubscription();
});

When("the user navigates to the subscription management page", () => {
 SubscriptionPage.navigateToManagementPage();
});

When("the user selects the subscription to modify", () => {
 SubscriptionPage.selectSubscriptionToModify();
});

When("the user changes the subscription plan", () => {
 SubscriptionPage.changeSubscriptionPlan();
});

When("the user confirms the changes", () => {
 SubscriptionPage.confirmChanges();
});

Then("the system should display a subscription modification confirmation message", () => {
 SubscriptionPage.verifyModificationConfirmation();
});

Then("the user should receive an email with the updated subscription details", () => {
 SubscriptionPage.verifyUpdatedEmail();
});

When("the user selects the subscription to cancel", () => {
 SubscriptionPage.selectSubscriptionToCancel();
});

When("the user confirms the cancellation", () => {
 SubscriptionPage.confirmCancellation();
});

Then("the system should display a subscription cancellation confirmation message", () => {
 SubscriptionPage.verifyCancellationConfirmation();
});

Then("the user should receive a cancellation confirmation email", () => {
 SubscriptionPage.verifyCancellationEmail();
});

Then("the system should display the subscription details including product, plan, and next delivery date", () => {
 SubscriptionPage.verifySubscriptionDetails();
});

When("the user attempts to confirm the subscription without entering payment details", () => {
 SubscriptionPage.attemptSubscriptionWithoutPayment();
});

Then("the system should display an error message indicating that payment details are required", () => {
 SubscriptionPage.verifyPaymentErrorMessage();
});