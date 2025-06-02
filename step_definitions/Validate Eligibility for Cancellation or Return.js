import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("the user is logged into the account with Order ID {string}", (orderId) => {
 OrderPage.login(orderId);
});

When("the user navigates to the order history section", () => {
 OrderPage.navigateToOrderHistory();
});

When("selects the order with Order ID {string}", (orderId) => {
 OrderPage.selectOrder(orderId);
});

When("locates the cancellation and return options on the order details page", () => {
 OrderPage.locateCancellationAndReturnOptions();
});

When("attempts to initiate a return for the order", () => {
 OrderPage.initiateReturn();
});

Then("the system checks the merchant's policy for eligibility", () => {
 OrderPage.checkEligibility();
});

Then("displays the eligibility status", () => {
 OrderPage.displayEligibilityStatus();
});

Then("allows return if the order is within the eligible period", () => {
 OrderPage.allowReturnIfEligible();
});

Then("denies return for ineligible orders", () => {
 OrderPage.denyReturnIfIneligible();
});

Then("prompts with the merchant's policy details when denying returns", () => {
 OrderPage.promptPolicyDetails();
});

Then("logs the eligibility check for audit purposes", () => {
 OrderPage.logEligibilityCheck();
});

Then("the user receives notifications for eligibility status", () => {
 OrderPage.notifyUserEligibilityStatus();
});

Then("the system updates the order status based on eligibility", () => {
 OrderPage.updateOrderStatus();
});

Then("the eligibility checks are consistent on all devices", () => {
 OrderPage.ensureConsistencyAcrossDevices();
});

Then("the system allows cancellation for eligible orders", () => {
 OrderPage.allowCancellationIfEligible();
});

Then("the options are updated according to policy changes", () => {
 OrderPage.updateOptionsBasedOnPolicyChanges();
});