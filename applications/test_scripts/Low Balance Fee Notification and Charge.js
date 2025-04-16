describe('Low Balance Fee Notification and Charge', () => {
  const userAccountId = '123456';
  const initialBalance = 15;
  const transactionAmount = 6;
  const lowBalanceFee = 5;
  const thresholdBalance = 10;

  beforeEach(() => {
    cy.visit('/login');
    cy.get('#accountId').type(userAccountId);
    cy.get('#password').type('password123');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should notify and charge a fee when balance falls below threshold', () => {
    cy.get('#currentBalance').should('contain', `$${initialBalance}`);
    cy.get('#performTransaction').click();
    cy.get('#transactionAmount').type(transactionAmount);
    cy.get('#confirmTransaction').click();
    cy.get('#currentBalance').should('contain', `$${initialBalance - transactionAmount}`);
    cy.get('#notifications').should('contain', 'Low balance fee will be charged');
    cy.get('#confirmFee').click();
    cy.get('#currentBalance').should('contain', `$${initialBalance - transactionAmount - lowBalanceFee}`);
  });

  afterEach(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});