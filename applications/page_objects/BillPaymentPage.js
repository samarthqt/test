class BillPaymentPage {
  selectBiller(billerName) {
    cy.get('.biller-list').contains(billerName).click();
  }

  enterPaymentAmount(amount) {
    cy.get('#payment-amount').type(amount);
  }

  selectBankAccount(accountNumber) {
    cy.get('.bank-account-list').contains(accountNumber).click();
  }

  confirmPayment() {
    cy.get('#confirm-payment').click();
  }

  verifyInsufficientFundsError() {
    cy.get('.error-message').should('contain', 'insufficient funds');
  }
}