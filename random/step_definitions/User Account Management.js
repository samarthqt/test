const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const UserAccountPage = require('../../pageObjects/UserAccountPage');

Given('a registered user is logged into their account', () => {
  cy.login();
});

When('the user navigates to the order history page', () => {
  UserAccountPage.navigateToOrderHistory();
});

Then('the user should see a list of all their past orders', () => {
  UserAccountPage.verifyOrderList();
});

Then('the order details should include products, prices, and purchase dates', () => {
  UserAccountPage.verifyOrderDetails();
});

Given('a registered user has placed an order', () => {
  cy.placeOrder();
});

When('the user views the order status', () => {
  UserAccountPage.viewOrderStatus();
});

Then('the status should be updated in real-time', () => {
  UserAccountPage.verifyRealTimeStatus();
});

Then('notifications should inform the user of any changes in order status', () => {
  UserAccountPage.verifyOrderStatusNotifications();
});

When('the user adds an item to their wishlist', () => {
  UserAccountPage.addItemToWishlist();
});

Then('the item should be added to the wishlist', () => {
  UserAccountPage.verifyItemAddedToWishlist();
});

Then('the change should be saved immediately', () => {
  UserAccountPage.verifyWishlistChangeSaved();
});

Given('a registered user has items in their wishlist', () => {
  cy.verifyWishlistItems();
});

When('the user removes an item from their wishlist', () => {
  UserAccountPage.removeItemFromWishlist();
});

Then('the item should be removed from the wishlist', () => {
  UserAccountPage.verifyItemRemovedFromWishlist();
});

Then('an appropriate error message should be displayed', () => {
  UserAccountPage.verifyErrorMessage();
});

When('the user performs an invalid operation', () => {
  UserAccountPage.performInvalidOperation();
});

When('the user views their order history or modifies their wishlist', () => {
  UserAccountPage.logUserInteractions();
});

Then('the interactions should be logged for audit and tracking purposes', () => {
  UserAccountPage.verifyInteractionsLogged();
});