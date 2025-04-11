import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../page_objects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('a user has items in their shopping cart', () => {
  checkoutPage.addItemToCart();
});

Given('a user has an empty shopping cart', () => {
  checkoutPage.emptyCart();
});

Given('a user has items eligible for a special promotion in their shopping cart', () => {
  checkoutPage.addPromotionalItemsToCart();
});

When('the user opts to checkout as a guest', () => {
  checkoutPage.checkoutAsGuest();
});

When('the user attempts to checkout as a guest', () => {
  checkoutPage.attemptGuestCheckout();
});

When('the user provides valid shipping and payment information', () => {
  checkoutPage.enterValidShippingInfo();
  checkoutPage.enterValidPaymentInfo();
});

When('the user provides incomplete shipping information', () => {
  checkoutPage.enterIncompleteShippingInfo();
});

When('the user provides invalid payment information', () => {
  checkoutPage.enterInvalidPaymentInfo();
});

When('the user completes the purchase', () => {
  checkoutPage.completePurchase();
});

Then('the purchase should be completed successfully', () => {
  checkoutPage.verifyPurchaseSuccess();
});

Then('the user should receive a confirmation message', () => {
  checkoutPage.verifyConfirmationMessage();
});

Then('the purchase should not be completed', () => {
  checkoutPage.verifyPurchaseFailure();
});

Then('the user should be prompted to provide the missing shipping information', () => {
  checkoutPage.verifyMissingShippingInfoPrompt();
});

Then('the user should be notified of the payment error', () => {
  checkoutPage.verifyPaymentErrorNotification();
});

Then('the user should not be able to proceed with the checkout', () => {
  checkoutPage.verifyCannotProceed();
});

Then('the user should be prompted to add items to the cart', () => {
  checkoutPage.verifyAddItemsPrompt();
});

Then('the special promotion should be applied to the purchase', () => {
  checkoutPage.verifySpecialPromotionApplied();
});

Then('the user should be offered an option to create an account for future convenience', () => {
  checkoutPage.verifyAccountCreationOption();
});

Then('the user can choose to create an account or continue as a guest', () => {
  checkoutPage.verifyAccountCreationChoice();
});