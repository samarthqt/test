import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SubscriptionPage from "../pages/subscriptionPage";

Given("a user is logged into their account", () => {
 SubscriptionPage.ensureUserIsLoggedIn();
});

When("the user navigates to the subscription services section", () => {
 SubscriptionPage.goToSubscriptionServices();
});

When("the user selects a product to subscribe to", () => {
 SubscriptionPage.selectProductToSubscribe();
});

When("the user chooses a delivery frequency option", () => {
 SubscriptionPage.chooseDeliveryFrequency();
});

Then("the user should be subscribed to the regular product deliveries", () => {
 SubscriptionPage.verifySubscriptionSuccess();
});

Given("a user is subscribed to regular product deliveries", () => {
 SubscriptionPage.ensureUserIsSubscribed();
});

When("a delivery date is approaching", () => {
 SubscriptionPage.simulateDeliveryDateApproaching();
});

Then("the user should receive a notification for the upcoming delivery", () => {
 SubscriptionPage.verifyNotificationReceived();
});

When("the user navigates to the subscription management section", () => {
 SubscriptionPage.goToSubscriptionManagement();
});

Then("the user should be able to view and manage their subscriptions", () => {
 SubscriptionPage.verifySubscriptionManagementAccess();
});

When("the user selects a subscription to cancel", () => {
 SubscriptionPage.selectSubscriptionToCancel();
});

Then("the subscription should be successfully canceled", () => {
 SubscriptionPage.verifyCancellationSuccess();
});

When("the user selects a subscription to modify", () => {
 SubscriptionPage.selectSubscriptionToModify();
});

When("the user changes the delivery frequency or product", () => {
 SubscriptionPage.modifySubscriptionDetails();
});

Then("the subscription should be successfully updated with the new details", () => {
 SubscriptionPage.verifyUpdateSuccess();
});