describe('TC-10 Return Flow for Expired Return Period', () => {
  const orderID = '87654';
  const customerEmail = 'customer@example.com';

  before(() => {
    cy.visit('/login');
    cy.get('#email').type(customerEmail);
    cy.get('#password').type('customerPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Order Details section', () => {
    cy.contains('Order Details').click();
    cy.url().should('include', '/orders');
  });

  it('should display order details for order ID 87654', () => {
    cy.contains(orderID).click();
    cy.url().should('include', `/orders/${orderID}`);
  });

  it('should verify that Initiate Return button is disabled or not present', () => {
    cy.get('#achieveAccessCode').contains('ACH54321');
    cy.get('#initiateReturnButton').should('be.disabled');
    cy.contains('The return period has expired').should('be.visible');
  });
});