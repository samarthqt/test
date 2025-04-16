class PurchasePage {
  selectPaymentMethod(method) {
    cy.get('#payment-method').select(method);
  }

  enterCreditCardDetails(cardNumber, expiryDate, cvv) {
    cy.get('#credit-card-number').type(cardNumber);
    cy.get('#expiry-date').type(expiryDate);
    cy.get('#cvv').type(cvv);
  }

  clickPayNow() {
    cy.get('#pay-now-button').click();
  }

  verifyInvalidCardErrorMessage() {
    cy.get('.error-message').should('contain', 'Invalid credit card number');
  }
}