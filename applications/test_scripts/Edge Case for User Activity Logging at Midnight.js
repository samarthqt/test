describe('Edge Case for User Activity Logging at Midnight', () => {
  const userId = '12345';

  before(() => {
    cy.visit('/login');
    cy.login(userId);
  });

  it('should login user just before midnight', () => {
    cy.clock(new Date(2023, 9, 1, 23, 59, 59));
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should perform actions across midnight', () => {
    cy.visit('/product');
    cy.get('#viewProduct').click();
    cy.get('#addToCart').click();
    cy.clock(new Date(2023, 9, 2, 0, 0, 1));
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });

  it('should verify user actions in activity logs', () => {
    cy.visit('/admin');
    cy.get('#activityLogs').click();
    cy.get('#searchUserId').type(userId);
    cy.get('#searchButton').click();
    cy.get('.logEntry').should('contain', '2023-10-01 23:59:59');
    cy.get('.logEntry').should('contain', '2023-10-02 00:00:01');
  });
});