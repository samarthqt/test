class CheckoutPage {
  static proceedToCheckout() {
    cy.get('.checkout-button').click();
  }

  static verifyCheckoutPage() {
    cy.url().should('include', '/checkout');
  }

  static visitCheckoutPage() {
    cy.visit('/checkout');
  }

  static enterShippingInformation() {
    cy.get('#shipping-address').type('123 Test St');
    cy.get('#shipping-city').type('Testville');
    cy.get('#shipping-zip').type('12345');
  }

  static enterBillingInformation() {
    cy.get('#billing-address').type('456 Test Ave');
    cy.get('#billing-city').type('Testopolis');
    cy.get('#billing-zip').type('67890');
  }

  static verifyInformationAccepted() {
    cy.get('.info-accepted').should('be.visible');
  }

  static selectPaymentMethod() {
    cy.get('.payment-method').select('Credit Card');
  }

  static verifyPaymentOptions() {
    cy.get('.payment-options').should('contain', 'Credit Card').and('contain', 'PayPal');
  }

  static enterPaymentDetails() {
    cy.get('#card-number').type('4111111111111111');
    cy.get('#card-expiry').type('12/23');
    cy.get('#card-cvc').type('123');
  }

  static verifySecureCheckout() {
    cy.get('.secure-checkout').should('be.visible');
  }

  static verifyUnauthorizedAccessPrevention() {
    cy.get('.access-prevention').should('be.visible');
  }

  static completeCheckoutProcess() {
    cy.get('.complete-checkout').click();
  }

  static verifyTransactionSuccess() {
    cy.get('.transaction-success').should('be.visible');
  }

  static verifySuccessNotification() {
    cy.get('.success-notification').should('be.visible');
  }

  static enterInvalidInformation() {
    cy.get('#shipping-address').type('');
    cy.get('#billing-address').type('');
  }

  static verifyErrorMessage() {
    cy.get('.error-message').should('be.visible');
  }

  static proceedWithCheckoutProcess() {
    cy.get('.proceed-checkout').click();
  }

  static completeOperation() {
    cy.get('.complete-operation').click();
  }

  static verifyOperationLogging() {
    cy.get('.operation-logged').should('be.visible');
  }
}

module.exports = CheckoutPage;