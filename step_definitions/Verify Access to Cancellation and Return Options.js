import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("a user account with completed orders", () => {
 cy.fixture('user').then(user => {
 OrderPage.login(user.username, user.password);
 });
});

When("the user logs into the account with the provided credentials", () => {
 OrderPage.verifyLogin();
});

Then("the user is successfully logged into the account", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is logged in", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the order history section of the account", () => {
 OrderPage.navigateToOrderHistory();
});

Then("the order history section is displayed with a list of orders", () => {
 OrderPage.verifyOrderHistoryDisplayed();
});

Given("the order history section is displayed", () => {
 OrderPage.verifyOrderHistoryDisplayed();
});

When("the user selects the order with Order ID 54321 from the list", () => {
 OrderPage.selectOrderById('54321');
});

Then("the order details page for Order ID 54321 is displayed", () => {
 OrderPage.verifyOrderDetailsDisplayed('54321');
});

Given("the order details page for Order ID 54321 is displayed", () => {
 OrderPage.verifyOrderDetailsDisplayed('54321');
});

When("the user locates the cancellation and return options on the order details page", () => {
 OrderPage.locateCancellationAndReturnOptions();
});

Then("the cancellation and return options are visible on the page", () => {
 OrderPage.verifyOptionsVisible();
});

Given("the cancellation option is visible", () => {
 OrderPage.verifyCancellationOptionVisible();
});

When("the user clicks on the cancellation option to initiate the cancellation process", () => {
 OrderPage.initiateCancellation();
});

Then("the cancellation process is initiated successfully", () => {
 OrderPage.verifyCancellationInitiated();
});

Given("the cancellation process is initiated", () => {
 OrderPage.verifyCancellationInitiated();
});

When("the system prompts for confirmation of the cancellation", () => {
 OrderPage.verifyCancellationPrompt();
});

Then("the confirmation prompt is displayed for the cancellation", () => {
 OrderPage.verifyCancellationPromptDisplayed();
});

Given("the confirmation prompt is displayed", () => {
 OrderPage.verifyCancellationPromptDisplayed();
});

When("the user confirms the cancellation", () => {
 OrderPage.confirmCancellation();
});

Then("the order status is updated to 'Cancelled'", () => {
 OrderPage.verifyOrderStatusUpdated('Cancelled');
});

Given("the return option is visible", () => {
 OrderPage.verifyReturnOptionVisible();
});

When("the user accesses the return option and initiates the return process", () => {
 OrderPage.initiateReturn();
});

Then("the return process is initiated successfully", () => {
 OrderPage.verifyReturnInitiated();
});

Given("the return process is initiated", () => {
 OrderPage.verifyReturnInitiated();
});

When("the system prompts for confirmation of the return", () => {
 OrderPage.verifyReturnPrompt();
});

Then("the confirmation prompt is displayed for the return", () => {
 OrderPage.verifyReturnPromptDisplayed();
});

Given("the confirmation prompt is displayed", () => {
 OrderPage.verifyReturnPromptDisplayed();
});

When("the user confirms the return", () => {
 OrderPage.confirmReturn();
});

Then("the order status is updated to 'Return Initiated'", () => {
 OrderPage.verifyOrderStatusUpdated('Return Initiated');
});

Given("the order details page is displayed", () => {
 OrderPage.verifyOrderDetailsDisplayed();
});

When("the order is not eligible for cancellation or return", () => {
 OrderPage.checkEligibilityForOptions();
});

Then("the cancellation and return options are disabled", () => {
 OrderPage.verifyOptionsDisabled();
});

Given("the user initiates cancellation or return", () => {
 OrderPage.initiateCancellationOrReturn();
});

When("the actions are completed", () => {
 OrderPage.verifyActionsCompleted();
});

Then("email notifications are sent for both cancellation and return actions", () => {
 OrderPage.verifyEmailNotificationsSent();
});

Given("the user has completed cancellation or return actions", () => {
 OrderPage.verifyActionsCompleted();
});

When("the user checks their account", () => {
 OrderPage.checkAccountForHistory();
});

Then("the cancellation and return history is accessible in the account", () => {
 OrderPage.verifyHistoryAccessible();
});

Given("the user has completed cancellation or return actions", () => {
 OrderPage.verifyActionsCompleted();
});

When("the user accesses the account", () => {
 OrderPage.accessAccount();
});

Then("the user can download the cancellation and return receipts", () => {
 OrderPage.downloadReceipts();
});

Given("the user has completed orders", () => {
 OrderPage.verifyCompletedOrders();
});

When("the user accesses the order details page on different devices", () => {
 OrderPage.accessOrderDetailsOnDevices();
});

Then("the cancellation and return options are accessible on all supported devices", () => {
 OrderPage.verifyOptionsAccessibilityAcrossDevices();
});