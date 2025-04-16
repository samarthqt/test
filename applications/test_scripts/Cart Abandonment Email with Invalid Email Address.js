describe('Cart Abandonment Email with Invalid Email Address', () => {
  const userId = '45678';
  const invalidEmail = 'user@invalid';

  before(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    cy.get('#userId').type(userId);
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should add items to the cart', () => {
    cy.visit('/products');
    cy.get('#productC').click();
    cy.get('#addToCartButton').click();
    cy.get('#productD').click();
    cy.get('#addToCartButton').click();
    cy.get('#cart').should('contain', 'Product C');
    cy.get('#cart').should('contain', 'Product D');
  });

  it('should abandon the cart', () => {
    cy.visit('/dashboard');
    cy.get('#cart').should('contain', 'Product C');
    cy.get('#cart').should('contain', 'Product D');
  });

  it('should fail to send cart abandonment email due to invalid email', () => {
    // Simulate waiting for email
    cy.wait(5000);
    cy.request('/checkEmailStatus').then((response) => {
      expect(response.body).to.have.property('emailSent', false);
    });
  });
});