class RentPaymentsPage {
  visit() {
    cy.get('.rent-payments-module-link').click();
  }

  selectTenant(tenantId) {
    cy.get('.tenant-list').contains(tenantId).click();
  }

  verifyPaymentDetails(amount, dueDate, status) {
    cy.get('.payment-amount').should('have.text', `$${amount}`);
    cy.get('.due-date').should('have.text', dueDate);
    cy.get('.payment-status').should('have.text', status);
  }

  recordPayment(amount) {
    cy.get('.record-payment-button').click();
    cy.get('.payment-amount-input').type(amount);
    cy.get('.submit-payment-button').click();
  }

  verifyPaymentHistory(amount) {
    cy.get('.payment-history-button').click();
    cy.get('.payment-history').should('contain', `$${amount}`);
  }
}

export default RentPaymentsPage;