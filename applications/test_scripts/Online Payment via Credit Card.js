describe('TC-823 404 Online Payment via Credit Card', () => {
  const tenantId = '12345';
  const creditCardNumber = '4111111111111111';
  const expiryDate = '12/25';
  const cvv = '123';
  const rentAmount = '1000';

  before(() => {
    cy.visit('/login');
    cy.login(tenantId, 'valid_password');
  });

  it('should navigate to Payments section', () => {
    cy.visit('/dashboard');
    cy.get('.payments-section').click();
    cy.url().should('include', '/payments');
  });

  it('should select Credit Card as payment method', () => {
    cy.get('#payment-methods').select('Credit Card');
    cy.get('#credit-card-form').should('be.visible');
  });

  it('should enter credit card details', () => {
    cy.get('#card-number').type(creditCardNumber);
    cy.get('#expiry-date').type(expiryDate);
    cy.get('#cvv').type(cvv);
  });

  it('should enter rent amount', () => {
    cy.get('#rent-amount').type(rentAmount);
  });

  it('should process the payment', () => {
    cy.get('#pay-now').click();
    cy.get('.confirmation-message').should('contain', 'Payment processed successfully');
  });

  it('should verify transaction in payment history', () => {
    cy.get('.payment-history').click();
    cy.get('.transaction-details').should('contain', rentAmount);
  });

  it('should check email for payment confirmation', () => {
    cy.checkEmail('tenant@example.com').should('contain', 'Payment Confirmation');
  });
});