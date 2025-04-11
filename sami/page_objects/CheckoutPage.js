class CheckoutPage {
  visitCheckoutPage() {
    cy.visit('/checkout');
  }

  selectPaymentMethod(paymentMethod) {
    cy.get('select[name="payment-method"]').select(paymentMethod);
  }

  enterValidPaymentDetails() {
    // Enter valid payment details based on the payment method
    cy.get('input[name="card-number"]').type('4111111111111111');
    cy.get('input[name="expiry-date"]').type('12/25');
    cy.get('input[name="cvv"]').type('123');
  }

  enterInvalidCreditCardDetails() {
    cy.get('input[name="card-number"]').type('0000000000000000');
    cy.get('input[name="expiry-date"]').type('00/00');
    cy.get('input[name="cvv"]').type('000');
  }

  enterInvalidPayPalDetails() {
    cy.get('input[name="paypal-email"]').type('invalid@paypal.com');
    cy.get('input[name="paypal-password"]').type('wrongpassword');
  }

  cancelPayment() {
    cy.get('button.cancel-payment').click();
  }

  confirmPayment() {
    cy.get('button.confirm-payment').click();
  }

  loginToPayPal() {
    cy.get('input[name="paypal-email"]').type('user@paypal.com');
    cy.get('input[name="paypal-password"]').type('correctpassword');
    cy.get('button.login-paypal').click();
  }

  verifyPaymentSuccess() {
    cy.get('.payment-success').should('be.visible');
  }

  verifyPaymentFailure() {
    cy.get('.payment-error').should('be.visible');
  }

  verifyConfirmationMessage() {
    cy.get('.confirmation-message').should('be.visible');
  }

  verifyErrorMessage() {
    cy.get('.error-message').should('be.visible');
  }

  verifyRedirectionToCheckoutPage() {
    cy.url().should('include', '/checkout');
  }

  verifyConfirmationEmail() {
    cy.get('.email-confirmation').should('be.visible');
  }
}

export default CheckoutPage;