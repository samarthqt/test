class BillingPortal {
  login(userId) {
    cy.get('#username').type(userId);
    cy.get('#password').type('password');
    cy.get('#loginButton').click();
  }

  navigateToManualPayment() {
    cy.get('#manualPaymentSection').click();
  }

  selectInvoice(amount) {
    cy.get('.invoice').contains(amount).click();
  }

  choosePaymentMethod(method) {
    cy.get('#paymentMethod').select(method);
  }

  initiatePayment() {
    cy.get('#initiatePaymentButton').click();
  }

  completePaymentThroughPayPal() {
    cy.origin('https://www.paypal.com', () => {
      cy.get('#confirmPaymentButton').click();
    });
  }

  verifyTransactionRecord(amount) {
    cy.get('.transactionRecord').should('contain', amount);
  }

  checkEmailNotification() {
    cy.get('.emailNotification').should('contain', 'Payment Confirmation');
  }

  verifyInvoiceStatus(status) {
    cy.get('.invoiceStatus').should('contain', status);
  }

  testInvalidPaymentMethod() {
    cy.get('#paymentMethod').select('InvalidMethod');
    cy.get('#initiatePaymentButton').click();
    cy.get('.errorMessage').should('be.visible');
  }

  switchToAutomaticBilling() {
    cy.get('#automaticBillingToggle').click();
  }

  checkManualPaymentOptionForAllInvoices() {
    cy.get('.invoiceType').each((invoice) => {
      cy.wrap(invoice).should('contain', 'Manual Payment Available');
    });
  }

  reviewSystemLogs() {
    cy.get('.systemLogs').should('not.contain', 'Error');
  }

  ensureCompliance() {
    cy.get('.complianceStatus').should('contain', 'Compliant');
  }

  gatherUserFeedback() {
    cy.get('.userFeedback').should('contain', 'Satisfied');
  }
}