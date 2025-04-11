import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import PaymentPage from '../pageObjects/PaymentPage';

const paymentPage = new PaymentPage();

Given('the system is configured for payment gateway integration', () => {
    paymentPage.configurePaymentGateway();
});

Given('the user selects {string} as the payment provider', (provider) => {
    paymentPage.selectPaymentProvider(provider);
});

When('the user proceeds to checkout', () => {
    paymentPage.proceedToCheckout();
});

When('the user enters valid payment details', () => {
    paymentPage.enterValidPaymentDetails();
});

When('the user enters invalid payment details', () => {
    paymentPage.enterInvalidPaymentDetails();
});

When('the user is redirected to the PayPal login page', () => {
    paymentPage.redirectToPayPalLogin();
});

When('the user logs in with valid PayPal credentials', () => {
    paymentPage.loginWithValidPayPalCredentials();
});

When('the user enters invalid PayPal credentials', () => {
    paymentPage.loginWithInvalidPayPalCredentials();
});

When('the user confirms the payment', () => {
    paymentPage.confirmPayment();
});

When('the user receives a confirmation', () => {
    paymentPage.receiveConfirmation();
});

Then('the payment should be processed successfully', () => {
    paymentPage.verifyPaymentSuccess();
});

Then('the payment should be declined', () => {
    paymentPage.verifyPaymentDecline();
});

Then('the user should receive a confirmation of the transaction', () => {
    paymentPage.verifyTransactionConfirmation();
});

Then('the user should receive an error message indicating the payment failure', () => {
    paymentPage.verifyPaymentFailureMessage();
});

Then('the user should not be able to log in', () => {
    paymentPage.verifyLoginFailure();
});

Then('the user should receive an error message indicating the login failure', () => {
    paymentPage.verifyLoginFailureMessage();
});

Given('the user is on the checkout page', () => {
    paymentPage.visitCheckoutPage();
});

When('the user selects a payment provider', () => {
    paymentPage.selectAnyPaymentProvider();
});

Then('the selected provider should be displayed as the current payment method', () => {
    paymentPage.verifySelectedProvider();
});

Then('the confirmation should include transaction ID, amount, and payment method', () => {
    paymentPage.verifyConfirmationDetails();
});