import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderManagementPage from "../pages/orderManagementPage";

Given("the user is logged into the order management system", () => {
 OrderManagementPage.login();
});

When("the user navigates to the {string} section", (section) => {
 OrderManagementPage.navigateToSection(section);
});

Then("the user should see the delivery status and tracking number for each order", () => {
 OrderManagementPage.verifyDeliveryStatusAndTrackingNumbers();
});

Then("the user should see a list displaying past orders", () => {
 OrderManagementPage.verifyOrderHistoryList();
});

Given("the user is viewing an order eligible for cancellation", () => {
 OrderManagementPage.viewEligibleOrderForCancellation();
});

When("the user attempts to cancel the order", () => {
 OrderManagementPage.cancelOrder();
});

Then("the system should process the cancellation according to merchant policy", () => {
 OrderManagementPage.verifyCancellationProcess();
});

Then("send a notification confirming the cancellation", () => {
 OrderManagementPage.verifyCancellationNotification();
});

Given("the user is viewing an order eligible for return", () => {
 OrderManagementPage.viewEligibleOrderForReturn();
});

When("the user attempts to return the order", () => {
 OrderManagementPage.returnOrder();
});

Then("the system should process the return according to merchant policy", () => {
 OrderManagementPage.verifyReturnProcess();
});

Then("send a notification confirming the return", () => {
 OrderManagementPage.verifyReturnNotification();
});

Given("the user has placed an order", () => {
 OrderManagementPage.placeOrder();
});

When("there is an update to the order status", () => {
 OrderManagementPage.updateOrderStatus();
});

Then("the user should receive a notification with the update details", () => {
 OrderManagementPage.verifyOrderUpdateNotification();
});

When("the user attempts an invalid order operation", () => {
 OrderManagementPage.attemptInvalidOperation();
});

Then("the system should display an appropriate error message", () => {
 OrderManagementPage.verifyErrorMessage();
});

Given("the user is interacting with the order management system", () => {
 OrderManagementPage.interactWithSystem();
});

When("the user navigates through various sections", () => {
 OrderManagementPage.navigateThroughSections();
});

Then("the interface should be intuitive and user-friendly", () => {
 OrderManagementPage.verifyUserFriendlyInterface();
});

When("the user accesses personal and order information", () => {
 OrderManagementPage.accessPersonalOrderInfo();
});

Then("the system should comply with data privacy and security standards", () => {
 OrderManagementPage.verifyPrivacySecurityCompliance();
});

When("the user performs order-related actions", () => {
 OrderManagementPage.performOrderRelatedActions();
});

Then("the system should log these interactions for analytics purposes", () => {
 OrderManagementPage.verifyInteractionLogging();
});

Given("the user needs assistance with an order-related issue", () => {
 OrderManagementPage.needOrderAssistance();
});

When("the user accesses the support section", () => {
 OrderManagementPage.accessSupportSection();
});

Then("the user should be able to contact support for inquiries", () => {
 OrderManagementPage.verifySupportContact();
});

When("the user performs multiple order-related actions", () => {
 OrderManagementPage.performMultipleOrderActions();
});

Then("the system should be optimized for performance without delays", () => {
 OrderManagementPage.verifyPerformanceOptimization();
});