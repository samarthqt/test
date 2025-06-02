import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SubscriptionPage from "../pages/subscriptionPage";

Given("the user is logged in with User ID: {int}", (userID) => {
 cy.login(userID);
});

When("the user navigates to the subscription setup page", () => {
 SubscriptionPage.visit();
});

Then("the user is directed to the subscription setup page displaying available options", () => {
 SubscriptionPage.verifyPageOptions();
});

Given("the user is on the subscription setup page", () => {
 SubscriptionPage.verifyOnPage();
});

When("the user selects a product for subscription setup", () => {
 SubscriptionPage.selectProduct();
});

Then("product details are displayed including subscription options", () => {
 SubscriptionPage.verifyProductDetails();
});

Given("the user has selected a product for subscription setup", () => {
 SubscriptionPage.verifyProductSelected();
});

When("the user chooses a delivery frequency of weekly", () => {
 SubscriptionPage.selectDeliveryFrequency('weekly');
});

Then("the selected frequency is highlighted and ready for confirmation", () => {
 SubscriptionPage.verifyFrequencySelected('weekly');
});

Given("the user is on the subscription setup page", () => {
 SubscriptionPage.verifyOnPage();
});

When("the user enters invalid payment information such as expired Credit Card details", () => {
 SubscriptionPage.enterInvalidPaymentDetails();
});

Then("the system detects invalid payment information and displays an error message", () => {
 SubscriptionPage.verifyPaymentErrorMessage();
});

Given("the user has entered invalid payment information", () => {
 SubscriptionPage.verifyInvalidPaymentEntered();
});

When("the user attempts to confirm the subscription setup", () => {
 SubscriptionPage.confirmSubscriptionSetup();
});

Then("the subscription setup fails and an error message is displayed indicating payment issue", () => {
 SubscriptionPage.verifySetupFailureMessage();
});

Given("the subscription setup has failed due to payment issue", () => {
 SubscriptionPage.verifySetupFailureDueToPayment();
});

When("the user checks their email", () => {
 cy.checkEmail();
});

Then("an email is received indicating subscription setup failure due to payment issue", () => {
 cy.verifyEmailNotification();
});

Given("the subscription setup has failed", () => {
 SubscriptionPage.verifySetupFailure();
});

When("the user checks error message details in their account", () => {
 SubscriptionPage.checkErrorMessageDetails();
});

Then("error message details are correctly listed under user account", () => {
 SubscriptionPage.verifyErrorMessageDetails();
});

Given("the user has invalid payment information", () => {
 SubscriptionPage.verifyInvalidPaymentInfo();
});

When("the user attempts to update payment information", () => {
 SubscriptionPage.updatePaymentInformation();
});

Then("the user is able to update payment information successfully", () => {
 SubscriptionPage.verifyPaymentUpdateSuccess();
});

Given("the user has rectified payment information", () => {
 SubscriptionPage.verifyPaymentRectified();
});

When("the user attempts the subscription setup again", () => {
 SubscriptionPage.attemptSubscriptionSetupAgain();
});

Then("the subscription setup is processed successfully with updated payment information", () => {
 SubscriptionPage.verifySuccessfulSetupWithUpdatedPayment();
});

Given("the subscription setup is processed successfully", () => {
 SubscriptionPage.verifySuccessfulSetup();
});

When("the user checks for any subscription setup conflicts", () => {
 SubscriptionPage.checkForSetupConflicts();
});

Then("no conflicts are found; setup is clear", () => {
 SubscriptionPage.verifyNoSetupConflicts();
});

Given("the user wants to manage notifications for subscription setup issues", () => {
 SubscriptionPage.verifyNotificationManagement();
});

When("the user attempts to enable or disable notifications", () => {
 SubscriptionPage.manageNotifications();
});

Then("the user can enable/disable notifications successfully", () => {
 SubscriptionPage.verifyNotificationSettingsSuccess();
});

Given("the user is on the subscription setup page", () => {
 SubscriptionPage.verifyOnPage();
});

When("the user attempts subscription setup with another invalid payment method", () => {
 SubscriptionPage.enterAnotherInvalidPaymentMethod();
});

Then("an error message is displayed indicating payment method issue", () => {
 SubscriptionPage.verifyAnotherPaymentMethodErrorMessage();
});

Given("the user has attempted subscription setup multiple times with invalid payment methods", () => {
 SubscriptionPage.verifyMultipleInvalidPaymentAttempts();
});

When("the user checks system response", () => {
 SubscriptionPage.checkSystemResponse();
});

Then("the system continues to display error messages without processing setup", () => {
 SubscriptionPage.verifyRepeatedSetupFailure();
});

Given("the user has rectified payment information", () => {
 SubscriptionPage.verifyPaymentRectified();
});

When("the subscription renewal process is initiated", () => {
 SubscriptionPage.initiateRenewalProcess();
});

Then("the subscription renews automatically as per schedule with updated payment", () => {
 SubscriptionPage.verifyAutomaticRenewal();
});

Given("the subscription is due for renewal", () => {
 SubscriptionPage.verifyRenewalDue();
});

When("the user attempts to setup subscription with invalid payment during renewal", () => {
 SubscriptionPage.enterInvalidPaymentDuringRenewal();
});

Then("the subscription setup fails and an error message is displayed indicating payment issue", () => {
 SubscriptionPage.verifyRenewalSetupFailureMessage();
});