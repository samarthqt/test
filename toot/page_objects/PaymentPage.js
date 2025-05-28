import { expect } from 'chai';

class PaymentPage {

  static visitCheckoutPage() {
    cy.visit('/checkout');
  }

  static selectPaymentProvider(provider) {
    cy.get('#paymentProvider').select(provider);
  }

  static selectAnyPaymentProvider() {
    cy.get('#paymentProvider').select('anyProvider');
  }

  static verifySelectedProviderDisplayed() {
    cy.get('#currentPaymentMethod').should('contain', 'anyProvider');
  }

  static proceedToCheckout() {
    cy.get('#checkoutButton').click();
  }

  static enterPaymentDetails(validity) {
    const details = validity === 'valid' ? 'validDetails' : 'invalidDetails';
    cy.get('#paymentDetails').type(details);
  }

  static redirectToPayPalLogin() {
    cy.url().should('include', 'paypal.com');
  }

  static loginToPayPal(validity) {
    const credentials = validity === 'valid' ? 'validCredentials' : 'invalidCredentials';
    cy.get('#paypalLogin').type(credentials);
    cy.get('#paypalLoginButton').click();
  }

  static confirmPayPalPayment() {
    cy.get('#confirmPaymentButton').click();
  }

  static verifySuccessfulPayment() {
    cy.get('#paymentStatus').should('contain', 'Success');
  }

  static verifyDeclinedPayment() {
    cy.get('#paymentStatus').should('contain', 'Declined');
  }

  static verifyConfirmationReceived() {
    cy.get('#confirmationMessage').should('be.visible');
  }

  static verifyPaymentErrorMessage() {
    cy.get('#errorMessage').should('contain', 'Payment failed');
  }

  static verifyLoginFailure() {
    cy.get('#loginStatus').should('contain', 'Login failed');
  }

  static verifyLoginErrorMessage() {
    cy.get('#errorMessage').should('contain', 'Login error');
  }

  static assumePaymentProcessedSuccessfully() {
    // Assume payment is processed
  }

  static receiveConfirmation() {
    cy.get('#confirmation').should('be.visible');
  }

  static verifyConfirmationDetails() {
    cy.get('#confirmationDetails').should('contain', 'Transaction ID');
    cy.get('#confirmationDetails').should('contain', 'Amount');
    cy.get('#confirmationDetails').should('contain', 'Payment Method');
  }
}

export default PaymentPage;