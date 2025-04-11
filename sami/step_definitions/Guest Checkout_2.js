import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../pageObjects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('the user has added items to the shopping cart', () => {
    checkoutPage.addItemToCart();
});

When('the user proceeds to checkout', () => {
    checkoutPage.proceedToCheckout();
});

Then('the user should see an option to checkout as a guest', () => {
    checkoutPage.verifyGuestCheckoutOption();
});

Given('the user has chosen to checkout as a guest', () => {
    checkoutPage.chooseGuestCheckout();
});

When('the user enters the required shipping and payment information', () => {
    checkoutPage.enterShippingInformation();
    checkoutPage.enterPaymentInformation();
});

When('the user confirms the order', () => {
    checkoutPage.confirmOrder();
});

Then('the order should be placed successfully', () => {
    checkoutPage.verifyOrderSuccess();
});

Then('the user should receive an order confirmation', () => {
    checkoutPage.verifyOrderConfirmation();
});

Given('the user is on the guest checkout page', () => {
    checkoutPage.navigateToGuestCheckoutPage();
});

When('the user tries to proceed without entering required information', () => {
    checkoutPage.proceedWithoutRequiredInfo();
});

Then('the user should be prompted to enter the missing information', () => {
    checkoutPage.verifyMissingInfoPrompt();
});

When('the user enters invalid payment information', () => {
    checkoutPage.enterInvalidPaymentInfo();
});

Then('the user should see an error message indicating the issue', () => {
    checkoutPage.verifyPaymentErrorMessage();
});

Then('the user should be able to correct the information and try again', () => {
    checkoutPage.correctPaymentInfoAndRetry();
});

When('the user decides to log in', () => {
    checkoutPage.chooseToLogin();
});

Then('the user should be redirected to the login page', () => {
    checkoutPage.verifyRedirectToLoginPage();
});

Then('after logging in, the user should be redirected back to the checkout page', () => {
    checkoutPage.verifyRedirectBackToCheckout();
});