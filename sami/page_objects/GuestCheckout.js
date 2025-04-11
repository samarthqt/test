class GuestCheckout {
  visitCart() {
    cy.visit('/cart');
  }

  verifyCartItems() {
    cy.get('.cart-item').should('exist');
  }

  proceedToCheckout() {
    cy.get('.checkout-button').click();
  }

  selectGuestCheckout() {
    cy.get('.guest-checkout-option').click();
  }

  enterShippingInformation(address) {
    cy.get('#shipping-address').type(address);
  }

  enterPaymentInformation(cardNumber) {
    cy.get('#payment-info').type(cardNumber);
  }

  enterEmail(email) {
    cy.get('#email').type(email);
  }

  reviewOrder() {
    cy.get('.review-order').click();
  }

  confirmOrder() {
    cy.get('.confirm-order').click();
  }

  chooseToCreateAccount() {
    cy.get('.create-account-checkbox').check();
  }

  verifyConfirmationMessage() {
    cy.get('.confirmation-message').should('contain', 'Thank you for your order');
  }

  verifyEmailConfirmation() {
    cy.get('.email-confirmation').should('contain', 'Order Confirmation');
  }

  verifyPaymentFailureMessage() {
    cy.get('.error-message').should('contain', 'Payment failed');
  }

  verifyMissingShippingInfoMessage() {
    cy.get('.error-message').should('contain', 'Shipping information required');
  }

  verifyInvalidEmailFormatMessage() {
    cy.get('.error-message').should('contain', 'Invalid email format');
  }

  verifyAccountCreationEmail() {
    cy.get('.email-confirmation').should('contain', 'Account Creation Confirmation');
  }
}