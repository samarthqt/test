describe('Subscription Payment Processing', () => {
  before(() => {
    // Assuming user is already logged in
    cy.visit('/subscription-service');
  });

  it('should display subscription service page with available plans', () => {
    cy.get('h1').should('contain', 'Subscription Plans');
  });

  it('should select a premium service plan', () => {
    cy.get('[data-service-id="111"]').click();
    cy.get('.plan-details').should('be.visible');
  });

  it('should choose PayPal as the payment method', () => {
    cy.get('#payment-method').select('PayPal');
    cy.get('#payment-method').should('have.value', 'PayPal');
  });

  it('should log into PayPal and confirm payment', () => {
    cy.get('#paypal-login').type('user@example.com');
    cy.get('#paypal-password').type('password123');
    cy.get('#confirm-payment').click();
    cy.get('.payment-status').should('contain', 'Payment Successful');
  });

  it('should verify payment confirmation in user account', () => {
    cy.visit('/user-account');
    cy.get('.payment-history').should('contain', 'Payment Successful');
  });
});