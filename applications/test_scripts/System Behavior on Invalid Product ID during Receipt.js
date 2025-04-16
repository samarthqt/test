describe('System Behavior on Invalid Product ID during Receipt', () => {
  before(() => {
    cy.visit('/login');
    cy.get('#username').type('validUsername');
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should display an error for invalid Product ID during goods receipt', () => {
    cy.get('#goodsReceiptNav').click();
    cy.url().should('include', '/goods-receipt');

    cy.get('#productIdInput').type('99999');
    cy.get('#submitProductId').click();
    cy.get('.error-message').should('contain', 'Product ID not found');

    cy.get('#quantityInput').type('10');
    cy.get('#submitQuantity').should('be.disabled');
  });
});