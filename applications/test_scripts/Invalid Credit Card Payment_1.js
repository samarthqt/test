describe('TC-825 404 Invalid Credit Card Payment', () => {
  const tenantId = '12345';
  const invalidCardNumber = '1234567890123456';
  const invalidExpiryDate = '01/21';
  const invalidCVV = '000';
  const rentAmount = '1000';

  beforeEach(() => {
    cy.visit('/login');
    cy.get('#username').type('validUsername');
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should not process payment with invalid credit card details', () => {
    cy.get('#paymentsSection').click();
    cy.url().should('include', '/payments');

    cy.get('#paymentMethod').select('Credit Card');
    cy.get('#creditCardForm').should('be.visible');

    cy.get('#cardNumber').type(invalidCardNumber);
    cy.get('#expiryDate').type(invalidExpiryDate);
    cy.get('#cvv').type(invalidCVV);

    cy.get('#rentAmount').type(rentAmount);
    cy.get('#payNowButton').click();

    cy.get('.errorMessage').should('contain', 'Invalid card details');
  });
});