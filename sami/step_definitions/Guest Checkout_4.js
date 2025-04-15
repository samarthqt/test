import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import GuestCheckoutPage from '../page-objects/GuestCheckoutPage';

const guestCheckoutPage = new GuestCheckoutPage();

Given('the user is on the e-commerce website', () => {
  cy.visit('/');
});

Given('the shopping cart contains items', () => {
  guestCheckoutPage.verifyItemsInCart();
});

Given('the user selects "Checkout as Guest"', () => {
  guestCheckoutPage.selectCheckoutAsGuest();
});

When('the user enters valid shipping information', () => {
  guestCheckoutPage.enterShippingInformation('valid');
});

When('the user enters invalid shipping information', () => {
  guestCheckoutPage.enterShippingInformation('invalid');
});

When('the user enters valid payment information', () => {
  guestCheckoutPage.enterPaymentInformation('valid');
});

When('the user enters invalid payment information', () => {
  guestCheckoutPage.enterPaymentInformation('invalid');
});

When('the user reviews the order summary', () => {
  guestCheckoutPage.reviewOrderSummary();
});

When('the user confirms the purchase', () => {
  guestCheckoutPage.confirmPurchase();
});

When('the user leaves required fields empty', () => {
  guestCheckoutPage.leaveFieldsEmpty();
});

When('the user decides to cancel the checkout process', () => {
  guestCheckoutPage.cancelCheckout();
});

When('the user enters a valid promotional code', () => {
  guestCheckoutPage.enterPromotionalCode('valid');
});

Then('the user should see a confirmation message', () => {
  guestCheckoutPage.verifyConfirmationMessage();
});

Then('the order should be placed successfully', () => {
  guestCheckoutPage.verifyOrderPlacement();
});

Then('the user should see an error message indicating invalid shipping information', () => {
  guestCheckoutPage.verifyShippingErrorMessage();
});

Then('the user should be prompted to correct the shipping information', () => {
  guestCheckoutPage.promptCorrectShippingInformation();
});

Then('the user should see an error message indicating invalid payment information', () => {
  guestCheckoutPage.verifyPaymentErrorMessage();
});

Then('the user should be prompted to correct the payment information', () => {
  guestCheckoutPage.promptCorrectPaymentInformation();
});

Then('the user should see an error message indicating missing information', () => {
  guestCheckoutPage.verifyMissingInfoErrorMessage();
});

Then('the user should be prompted to complete the required fields', () => {
  guestCheckoutPage.promptCompleteRequiredFields();
});

Then('the user should be redirected back to the shopping cart', () => {
  guestCheckoutPage.verifyRedirectToCart();
});

Then('the items should still be in the shopping cart', () => {
  guestCheckoutPage.verifyItemsInCart();
});

Then('the discount should be applied to the order total', () => {
  guestCheckoutPage.verifyDiscountApplied();
});