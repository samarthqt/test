import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("an authenticated user is viewing the order details page", () => {
 OrderPage.visitOrderDetails();
});

When("the user sees the cancellation and return options", () => {
 OrderPage.verifyCancellationAndReturnOptions();
});

Then("the user should be able to cancel or request a return for their order", () => {
 OrderPage.cancelOrReturnOrder();
});

Given("an authenticated user requests a return for an order", () => {
 OrderPage.requestReturn();
});

When("the system checks the merchant's return policy", () => {
 OrderPage.checkReturnPolicy();
});

Then("the system should validate the return request", () => {
 OrderPage.validateReturnRequest();
});

Given("an authenticated user cancels or requests a return for an order", () => {
 OrderPage.cancelOrReturnOrder();
});

When("the cancellation or return is processed successfully", () => {
 OrderPage.processCancellationOrReturn();
});

Then("the user should receive a confirmation notification", () => {
 OrderPage.verifyConfirmationNotification();
});

Given("an authenticated user attempts to cancel or return an order", () => {
 OrderPage.attemptCancelOrReturn();
});

When("an error occurs during the process", () => {
 OrderPage.simulateError();
});

Then("the system should handle the error gracefully and inform the user of the issue", () => {
 OrderPage.handleErrorGracefully();
});

Given("a user is not authenticated", () => {
 OrderPage.visitWithoutAuthentication();
});

When("the user attempts to cancel or return an order", () => {
 OrderPage.attemptCancelOrReturn();
});

Then("the system should restrict the action and inform the user to authenticate", () => {
 OrderPage.restrictUnauthenticatedActions();
});

Given("an authenticated user cancels or requests a return for an order", () => {
 OrderPage.cancelOrReturnOrder();
});

When("the action is completed", () => {
 OrderPage.completeAction();
});

Then("the system should log the cancellation or return action for auditing purposes", () => {
 OrderPage.logActionForAudit();
});

Given("an authenticated user requests a return for an order", () => {
 OrderPage.requestReturn();
});

When("the system integrates with merchant systems to check policies", () => {
 OrderPage.integrateWithMerchantSystems();
});

Then("the integration should be reliable and accurate", () => {
 OrderPage.verifyIntegrationReliability();
});

Given("an authenticated user requests a return for an order", () => {
 OrderPage.requestReturn();
});

When("there are fees associated with the return", () => {
 OrderPage.checkReturnFees();
});

Then("the user should be informed of any fees before proceeding with the return request", () => {
 OrderPage.informUserOfFees();
});