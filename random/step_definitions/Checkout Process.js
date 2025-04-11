const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const CheckoutPage = require('../../pages/CheckoutPage');

Given('the user has items in the shopping cart', () => {
  // Assume items are already added to the cart
});

When('the user clicks on the "Proceed to Checkout" button', () => {
  CheckoutPage.proceedToCheckout();
});

Then('the user should be directed to the checkout page', () => {
  CheckoutPage.verifyCheckoutPage();
});

Given('the user is on the checkout page', () => {
  CheckoutPage.visitCheckoutPage();
});

When('the user enters valid shipping information', () => {
  CheckoutPage.enterShippingInformation();
});

And('the user enters valid billing information', () => {
  CheckoutPage.enterBillingInformation();
});

Then('the entered shipping and billing information should be accepted', () => {
  CheckoutPage.verifyInformationAccepted();
});

When('the user selects the payment method', () => {
  CheckoutPage.selectPaymentMethod();
});

Then('the user should see multiple payment options including credit/debit cards and PayPal', () => {
  CheckoutPage.verifyPaymentOptions();
});

When('the user enters payment details', () => {
  CheckoutPage.enterPaymentDetails();
});

Then('the checkout process should be secure', () => {
  CheckoutPage.verifySecureCheckout();
});

And('unauthorized access should be prevented', () => {
  CheckoutPage.verifyUnauthorizedAccessPrevention();
});

Given('the user has completed the checkout process', () => {
  CheckoutPage.completeCheckoutProcess();
});

When('the transaction is successful', () => {
  CheckoutPage.verifyTransactionSuccess();
});

Then('the user should receive a notification confirming successful checkout', () => {
  CheckoutPage.verifySuccessNotification();
});

When('the user enters invalid shipping or billing information', () => {
  CheckoutPage.enterInvalidInformation();
});

Then('an error message should be displayed indicating the invalid input', () => {
  CheckoutPage.verifyErrorMessage();
});

Given('the user is proceeding with the checkout process', () => {
  CheckoutPage.proceedWithCheckoutProcess();
});

When('the user completes any operation during checkout', () => {
  CheckoutPage.completeOperation();
});

Then('the operation should be logged for tracking purposes', () => {
  CheckoutPage.verifyOperationLogging();
});