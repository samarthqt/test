describe('Customizable Products Edge Case Test', () => {
  const productId = '55667';
  const engravingText = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890';

  before(() => {
    cy.visit('/login');
    cy.login('validUser', 'validPassword');
  });

  it('should navigate to home page after login', () => {
    cy.url().should('include', '/home');
  });

  it('should search for the customizable product', () => {
    cy.visit('/search');
    cy.get('#search-input').type(productId);
    cy.get('#search-button').click();
    cy.url().should('include', `/product/${productId}`);
  });

  it('should select engraving customization option', () => {
    cy.get('#engraving-option').click();
    cy.get('#engraving-input').should('be.visible');
  });

  it('should enter maximum length engraving text', () => {
    cy.get('#engraving-input').type(engravingText);
    cy.get('#engraving-input').should('have.value', engravingText);
  });

  it('should add customized product to the cart', () => {
    cy.get('#add-to-cart-button').click();
    cy.get('#cart-summary').should('contain', engravingText);
  });

  it('should proceed to checkout', () => {
    cy.get('#checkout-button').click();
    cy.url().should('include', '/checkout');
  });

  it('should verify customization details in order summary', () => {
    cy.get('#order-summary').should('contain', engravingText);
  });

  it('should complete the payment process', () => {
    cy.get('#payment-button').click();
    cy.get('#order-confirmation').should('be.visible');
  });

  it('should verify customization details in order confirmation', () => {
    cy.get('#order-confirmation').should('contain', engravingText);
  });

  it('should navigate to order history page', () => {
    cy.get('#order-history-link').click();
    cy.url().should('include', '/order-history');
    cy.get('#recent-order').should('contain', engravingText);
  });

  after(() => {
    cy.logout();
  });
});