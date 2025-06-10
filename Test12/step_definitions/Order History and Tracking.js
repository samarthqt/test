import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountPage from "../pages/accountPage";

Given("a user is logged into their account", () => {
 AccountPage.login();
});

When("the user navigates to the account dashboard", () => {
 AccountPage.goToDashboard();
});

Then("the user should be able to view their order history", () => {
 AccountPage.verifyOrderHistoryVisible();
});

Given("a user is viewing their order history", () => {
 AccountPage.viewOrderHistory();
});

When("the user selects an order", () => {
 AccountPage.selectOrder();
});

Then("the order details should include order number, date, items, and status", () => {
 AccountPage.verifyOrderDetails();
});

When("the user selects an order with a delivery status", () => {
 AccountPage.selectOrderWithDeliveryStatus();
});

Then("the user should be able to track order delivery with real-time updates", () => {
 AccountPage.trackOrderDelivery();
});

Given("a user has placed an order", () => {
 AccountPage.placeOrder();
});

When("the order status changes", () => {
 AccountPage.changeOrderStatus();
});

Then("the system should provide a notification to the user", () => {
 AccountPage.verifyNotification();
});

When("the user navigates to the wishlist section", () => {
 AccountPage.goToWishlist();
});

Then("the user should be able to manage their wishlist", () => {
 AccountPage.manageWishlist();
});

Given("a user is trying to access order history or wishlist", () => {
 AccountPage.accessOrderHistoryOrWishlist();
});

When("there is a data retrieval issue", () => {
 AccountPage.simulateDataRetrievalIssue();
});

Then("an error message must be displayed to the user", () => {
 AccountPage.verifyErrorMessage();
});

Given("a user is interacting with the order history or wishlist", () => {
 AccountPage.interactWithOrderHistoryOrWishlist();
});

When("an action is performed", () => {
 AccountPage.performAction();
});

Then("the interaction should be logged for auditing purposes", () => {
 AccountPage.verifyInteractionLogging();
});

Given("a user is accessing their order history or wishlist", () => {
 AccountPage.accessOrderHistoryOrWishlist();
});

When("sensitive information is processed", () => {
 AccountPage.processSensitiveInformation();
});

Then("the system must ensure data encryption for that information", () => {
 AccountPage.verifyDataEncryption();
});