import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SubscriptionPage from "../pages/subscriptionPage";

Given("the user is logged in with User ID: {int}", (userId) => {
 SubscriptionPage.login(userId);
});

When("the user navigates to the subscription customization page", () => {
 SubscriptionPage.navigateToCustomizationPage();
});

Then("the user should be directed to the customization page displaying available options", () => {
 SubscriptionPage.verifyCustomizationPage();
});

Given("the user is on the subscription customization page", () => {
 SubscriptionPage.verifyCustomizationPage();
});

When("the user selects a product with Product ID: {int} for customization", (productId) => {
 SubscriptionPage.selectProduct(productId);
});

Then("the product details should be displayed including customization options", () => {
 SubscriptionPage.verifyProductDetails();
});

Given("the user is customizing a product", () => {
 SubscriptionPage.verifyProductDetails();
});

When("the user chooses a delivery frequency of {string}", (frequency) => {
 SubscriptionPage.chooseDeliveryFrequency(frequency);
});

Then("the selected frequency should be highlighted and ready for confirmation", () => {
 SubscriptionPage.verifySelectedFrequency();
});

Given("the user has chosen a delivery frequency", () => {
 SubscriptionPage.verifySelectedFrequency();
});

When("the user enters payment information using PayPal", () => {
 SubscriptionPage.enterPaymentInformation("PayPal");
});

Then("the payment information should be verified and accepted", () => {
 SubscriptionPage.verifyPaymentInformation();
});

Given("the payment information is accepted", () => {
 SubscriptionPage.verifyPaymentInformation();
});

When("the user confirms the customization setup", () => {
 SubscriptionPage.confirmCustomizationSetup();
});

Then("a confirmation message should be displayed indicating successful customization", () => {
 SubscriptionPage.verifyConfirmationMessage();
});

Given("the customization setup is confirmed", () => {
 SubscriptionPage.verifyConfirmationMessage();
});

When("the user checks their email", () => {
 SubscriptionPage.checkEmailForConfirmation();
});

Then("an email confirming customization details should be received", () => {
 SubscriptionPage.verifyEmailConfirmation();
});

Given("the user has received email confirmation", () => {
 SubscriptionPage.verifyEmailConfirmation();
});

When("the user checks their account", () => {
 SubscriptionPage.checkAccountForCustomizationDetails();
});

Then("customization details should be correctly listed under the user account", () => {
 SubscriptionPage.verifyAccountCustomizationDetails();
});

Given("the user has an active customization", () => {
 SubscriptionPage.verifyActiveCustomization();
});

When("the user attempts to modify the delivery frequency", () => {
 SubscriptionPage.modifyDeliveryFrequency();
});

Then("the user should be able to change delivery frequency successfully", () => {
 SubscriptionPage.verifyFrequencyChangeSuccess();
});

Given("the user has an active customization", () => {
 SubscriptionPage.verifyActiveCustomization();
});

When("the user attempts to cancel the customization", () => {
 SubscriptionPage.cancelCustomization();
});

Then("the customization should be canceled and a confirmation message displayed", () => {
 SubscriptionPage.verifyCancellationConfirmation();
});

Given("the customization is canceled within the allowed period", () => {
 SubscriptionPage.verifyCancellationConfirmation();
});

When("the user checks the refund process", () => {
 SubscriptionPage.checkRefundProcess();
});

Then("the refund should be processed as per policy", () => {
 SubscriptionPage.verifyRefundProcess();
});

Given("the user has an active customization", () => {
 SubscriptionPage.verifyActiveCustomization();
});

When("the user checks the delivery schedule", () => {
 SubscriptionPage.checkDeliverySchedule();
});

Then("no conflicts should be found; schedule is clear", () => {
 SubscriptionPage.verifyScheduleConflicts();
});

Given("the user has an active customization", () => {
 SubscriptionPage.verifyActiveCustomization();
});

When("the user attempts to enable/disable notifications", () => {
 SubscriptionPage.changeNotificationSettings();
});

Then("the user should be able to successfully change notification settings", () => {
 SubscriptionPage.verifyNotificationSettingsChange();
});

Given("the user is customizing a product", () => {
 SubscriptionPage.verifyProductDetails();
});

When("the user enters invalid payment information", () => {
 SubscriptionPage.enterInvalidPaymentInformation();
});

Then("an error message should be displayed indicating payment method issue", () => {
 SubscriptionPage.verifyPaymentErrorMessage();
});

Given("the user has an active customization", () => {
 SubscriptionPage.verifyActiveCustomization();
});

When("the user changes the customization frequency", () => {
 SubscriptionPage.changeCustomizationFrequency();
});

Then("the system should update frequency without errors", () => {
 SubscriptionPage.verifyFrequencyUpdate();
});

Given("the user has an active customization", () => {
 SubscriptionPage.verifyActiveCustomization();
});

When("the renewal period is reached", () => {
 SubscriptionPage.checkRenewalPeriod();
});

Then("the customization should renew automatically as per schedule", () => {
 SubscriptionPage.verifyAutomaticRenewal();
});