class PaymentPage {
  static selectPaymentMethod(method) {
    cy.get('#payment-method').select(method);
  }

  static enterCardDetails(cardNumber, expiryDate, cvv) {
    cy.get('#card-number').type(cardNumber);
    cy.get('#expiry-date').type(expiryDate);
    cy.get('#cvv').type(cvv);
  }

  static enterAmount(amount) {
    cy.get('#amount').type(amount);
  }

  static submitPayment() {
    cy.get('#submit-payment').click();
  }

  static verifyPaymentConfirmation() {
    cy.get('.confirmation-message').should('contain', 'Payment processed successfully');
  }

  static verifyErrorMessage(message) {
    cy.get('.error-message').should('contain', message);
  }

  static verifyLoginPrompt() {
    cy.get('.login-prompt').should('be.visible');
  }
}

export default PaymentPage;