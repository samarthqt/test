describe('Deposit Management Test Suite', () => {
  const tenantName = 'Alex Johnson';
  const leaseId = '54321';
  const securityDepositAmount = '$1000';

  before(() => {
    cy.visit('/login');
    cy.login(tenantName);
  });

  it('should navigate to Financial Management module', () => {
    cy.get('#financial-management').click();
    cy.url().should('include', '/financial-management');
  });

  it('should select Deposits from sub-module menu', () => {
    cy.get('#sub-module-menu').contains('Deposits').click();
    cy.url().should('include', '/deposit-management');
  });

  it('should search for Lease ID and verify deposit information', () => {
    cy.get('#lease-search').type(leaseId);
    cy.get('#search-button').click();
    cy.get('#lease-details').should('contain', leaseId);
    cy.get('#security-deposit').should('contain', securityDepositAmount);
  });

  it('should simulate end of tenancy process', () => {
    cy.get('#end-tenancy-button').click();
    cy.get('#end-tenancy-confirmation').should('be.visible');
  });

  it('should verify refund calculation for security deposit', () => {
    cy.get('#refund-calculation').should('contain', 'Refund calculated correctly');
  });

  it('should process refund for security deposit', () => {
    cy.get('#process-refund-button').click();
    cy.get('#refund-confirmation').should('be.visible');
  });

  it('should check tenant account for refund transaction', () => {
    cy.get('#tenant-account').click();
    cy.get('#transactions').should('contain', 'Refund transaction recorded');
  });

  it('should verify email notification for refund confirmation', () => {
    cy.get('#email-notifications').click();
    cy.get('#email-details').should('contain', 'Refund details');
  });

  after(() => {
    cy.logout();
  });
});