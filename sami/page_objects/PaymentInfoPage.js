class PaymentInfoPage {
  navigateToPage(page) {
    cy.visit(`/${page}`);
  }

  enterPaymentDetails({ 'Card Number': cardNumber, 'Expiry Date': expiryDate, 'CVV': cvv }) {
    if (cardNumber) cy.get('#card-number').type(cardNumber);
    if (expiryDate) cy.get('#expiry-date').type(expiryDate);
    if (cvv) cy.get('#cvv').type(cvv);
  }

  savePaymentInfo() {
    cy.get('#save-payment-info').click();
  }

  deletePaymentInfo() {
    cy.get('#delete-payment-info').click();
  }

  checkSavedPaymentInfo() {
    // Code to check if payment info is saved
  }

  verifyPaymentInfoSaved() {
    // Code to verify that payment info is saved securely
  }

  verifyConfirmationMessage(message) {
    cy.contains(message).should('be.visible');
  }

  verifyErrorMessage(message) {
    cy.contains(message).should('be.visible');
  }

  verifyPaymentInfoNotSaved() {
    // Code to verify that payment info is not saved
  }

  verifyPaymentInfoUpdated() {
    // Code to verify that payment info is updated
  }

  verifyPaymentInfoDeleted() {
    // Code to verify that payment info is deleted
  }
}

export default PaymentInfoPage;