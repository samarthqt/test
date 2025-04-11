import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../page-objects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('the user is on the checkout page', () => {
  checkoutPage.visitCheckoutPage();
});

Given('the user has items in the cart', () => {
  checkoutPage.verifyItemsInCart();
});

When('the user chooses to ship to multiple addresses', () => {
  checkoutPage.selectMultipleShippingAddresses();
});

Then('the user should see an option to select different addresses for each item', () => {
  checkoutPage.verifyMultipleAddressOption();
});

When('the user adds a new shipping address', () => {
  checkoutPage.addNewShippingAddress();
});

Then('the new address should be available for selection in the address list', () => {
  checkoutPage.verifyNewAddressInList();
});

Given('the user has multiple addresses available', () => {
  checkoutPage.verifyMultipleAddressesAvailable();
});

When('the user assigns different addresses to each item in the order', () => {
  checkoutPage.assignAddressesToItems();
});

Then('each item should display the assigned address in the order summary', () => {
  checkoutPage.verifyAssignedAddressesInSummary();
});

Given('the user has assigned different addresses to items', () => {
  checkoutPage.verifyAssignedAddresses();
});

When('the user reviews the order summary', () => {
  checkoutPage.reviewOrderSummary();
});

Then('the order summary should display each item with its respective shipping address', () => {
  checkoutPage.verifyOrderSummaryAddresses();
});

Given('the user has reviewed the order summary', () => {
  checkoutPage.verifyOrderSummaryReviewed();
});

When('the user confirms the order', () => {
  checkoutPage.confirmOrder();
});

Then('the order should be processed with items being shipped to their respective addresses', () => {
  checkoutPage.verifyOrderProcessed();
});

Then('the user should receive a confirmation email with details of each shipment', () => {
  checkoutPage.verifyConfirmationEmail();
});