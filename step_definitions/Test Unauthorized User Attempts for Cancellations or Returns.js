import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("the user logs into the account with User ID {string}", (userID) => {
 OrderPage.login(userID);
});

Given("navigates to the order history section", () => {
 OrderPage.navigateToOrderHistory();
});

Given("selects the order with Order ID {string}", (orderID) => {
 OrderPage.selectOrder(orderID);
});

Given("the order details page is displayed with status {string}", (status) => {
 OrderPage.verifyOrderStatus(status);
});

Given("cancellation and return options are visible on the page", () => {
 OrderPage.verifyCancellationAndReturnOptions();
});

When("the user attempts to initiate a cancellation for the order", () => {
 OrderPage.initiateCancellation();
});

Then("the system restricts unauthorized users from proceeding", () => {
 OrderPage.verifyUnauthorizedRestriction();
});

Then("an error message is displayed for unauthorized attempts", () => {
 OrderPage.verifyErrorMessage();
});

Then("unauthorized access attempts are logged", () => {
 OrderPage.verifyAccessLog();
});

Then("the user receives notifications for unauthorized attempts", () => {
 OrderPage.verifyUnauthorizedNotifications();
});

Then("the order status remains unchanged after unauthorized attempts", () => {
 OrderPage.verifyOrderStatusUnchanged();
});

Then("restrictions are consistent on all devices", () => {
 OrderPage.verifyDeviceConsistency();
});

Then("an authentication prompt is displayed for unauthorized users", () => {
 OrderPage.verifyAuthenticationPrompt();
});

When("the user attempts to initiate a return for the order", () => {
 OrderPage.initiateReturn();
});