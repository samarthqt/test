describe('TC-118 93 Edge Case: Low Balance Fee with Exact Threshold Balance', () => {
  const userAccountID = '123456';
  const initialBalance = 10;
  const thresholdBalance = 10;

  before(() => {
    cy.visit('/login');
    cy.get('#accountId').type(userAccountID);
    cy.get('#loginButton').click();
  });

  it('should display the user dashboard with current balance', () => {
    cy.url().should('include', '/dashboard');
    cy.get('#currentBalance').should('contain', `$${initialBalance}`);
  });

  it('should confirm the balance is exactly $10', () => {
    cy.get('#currentBalance').should('have.text', `$${thresholdBalance}`);
  });

  it('should not receive a notification about the low balance fee', () => {
    cy.get('#notifications').should('not.contain', 'Low balance fee applied');
  });

  it('should verify the account balance remains at $10 with no fees charged', () => {
    cy.get('#currentBalance').should('have.text', `$${thresholdBalance}`);
  });

  after(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});