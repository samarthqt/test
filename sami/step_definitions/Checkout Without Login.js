const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const CheckoutPage = require('../../pageObjects/CheckoutPage');

Given('I am a guest user on the website', () => {
  cy.visit('/');
});

Given('I have added items to my shopping cart', () => {
  cy.addItemsToCart();
});

Given('my shopping cart is empty', () => {
  cy.emptyCart();
});

Given('I am a guest user on the checkout page', () => {
  cy.visit('/checkout');
});

Given('I have entered invalid shipping details', () => {
  CheckoutPage.enterShippingDetails('invalid');
});

Given('I have entered invalid payment information', () => {
  CheckoutPage.enterPaymentInformation('invalid');
});

Given('I have entered valid shipping and payment information', () => {
  CheckoutPage.enterShippingDetails('valid');
  CheckoutPage.enterPaymentInformation('valid');
});

When('I proceed to the checkout page', () => {
  cy.visit('/checkout');
});

When('I attempt to proceed with the checkout', () => {
  CheckoutPage.proceedToCheckout();
});

When('I review my order', () => {
  CheckoutPage.reviewOrder();
});

Then('I should be able to enter my shipping details', () => {
  CheckoutPage.verifyShippingDetailsEntry();
});

Then('I should be able to enter my payment information', () => {
  CheckoutPage.verifyPaymentInformationEntry();
});

Then('I should be able to review my order', () => {
  CheckoutPage.verifyOrderReview();
});

Then('I should be able to place the order without logging in', () => {
  CheckoutPage.verifyOrderPlacement();
});

Then('I should see a message indicating that my cart is empty', () => {
  CheckoutPage.verifyEmptyCartMessage();
});

Then('I should not be able to proceed with the checkout', () => {
  CheckoutPage.verifyCannotProceedWithCheckout();
});

Then('I should see an error message indicating invalid shipping details', () => {
  CheckoutPage.verifyInvalidShippingDetailsError();
});

Then('I should be prompted to correct the shipping details', () => {
  CheckoutPage.verifyCorrectShippingDetailsPrompt();
});

Then('I should see an error message indicating invalid payment information', () => {
  CheckoutPage.verifyInvalidPaymentInformationError();
});

Then('I should be prompted to correct the payment information', () => {
  CheckoutPage.verifyCorrectPaymentInformationPrompt();
});

Then('I should see a summary of my order details', () => {
  CheckoutPage.verifyOrderSummary();
});

Then('I should see the total cost including any taxes and shipping fees', () => {
  CheckoutPage.verifyTotalCost();
});

Then('I should see an option to edit my order before placing it', () => {
  CheckoutPage.verifyEditOrderOption();
});