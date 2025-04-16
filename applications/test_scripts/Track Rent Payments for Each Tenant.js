describe('TC-527 393 Track Rent Payments for Each Tenant', () => {
  const tenantId = 'T001';
  const paymentAmount = 1200;
  const dueDate = '2023-11-01';
  const paymentStatusPending = 'Pending';
  const paymentStatusPaid = 'Paid';

  before(() => {
    cy.visit('/login');
    cy.loginAsAdmin();
  });

  it('should navigate to Rent Payments module', () => {
    cy.get('.dashboard').should('be.visible');
    cy.get('.rent-payments-module-link').click();
    cy.get('.rent-payments-module').should('be.visible');
  });

  it('should display payment details for tenant T001', () => {
    cy.get('.tenant-list').contains(tenantId).click();
    cy.get('.payment-details').should('be.visible');
    cy.get('.payment-amount').should('have.text', `$${paymentAmount}`);
    cy.get('.due-date').should('have.text', dueDate);
    cy.get('.payment-status').should('have.text', paymentStatusPending);
  });

  it('should record a payment of $1200 for tenant T001', () => {
    cy.get('.record-payment-button').click();
    cy.get('.payment-amount-input').type(paymentAmount);
    cy.get('.submit-payment-button').click();
    cy.get('.payment-status').should('have.text', paymentStatusPaid);
  });

  it('should check the payment history for tenant T001', () => {
    cy.get('.payment-history-button').click();
    cy.get('.payment-history').should('contain', `$${paymentAmount}`);
  });

  it('should ensure system sends confirmation email', () => {
    cy.verifyEmailSent(tenantId, paymentAmount);
  });

  after(() => {
    cy.logout();
  });
});