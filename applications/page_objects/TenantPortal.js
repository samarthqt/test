class TenantPortal {
  login(email, password) {
    cy.get('#email').type(email);
    cy.get('#password').type(password);
    cy.get('#login-button').click();
  }

  goToPayments() {
    cy.get('#payments-menu').click();
  }

  selectBankTransfer() {
    cy.get('#bank-transfer-option').click();
  }

  enterBankDetails(accountNumber, routingNumber) {
    cy.get('#account-number').type(accountNumber);
    cy.get('#routing-number').type(routingNumber);
  }

  enterRentAmount(amount) {
    cy.get('#rent-amount').type(amount);
  }

  payNow() {
    cy.get('#pay-now-button').click();
  }

  verifyPaymentHistory() {
    cy.get('#payment-history').click();
  }

  checkEmailConfirmation() {
    cy.get('#email-confirmation-menu').click();
  }
}