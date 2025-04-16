describe('Add Item to Cart', () => {
  const productId = '101';
  const userId = '202';
  const quantity = 1;

  before(() => {
    cy.login(userId);
  });

  it('should navigate to the product catalog page', () => {
    cy.visit('/product-catalog');
    cy.get('.product-list').should('be.visible');
  });

  it('should select a product from the catalog', () => {
    cy.get(`[data-product-id="${productId}"]`).click();
    cy.get('.product-details').should('be.visible');
  });

  it('should enter the desired quantity for the product', () => {
    cy.get('input.quantity').clear().type(quantity);
    cy.get('input.quantity').should('have.value', quantity);
  });

  it('should add the product to the cart', () => {
    cy.get('button.add-to-cart').click();
    cy.get('.confirmation-message').should('be.visible');
  });

  it('should navigate to the shopping cart page', () => {
    cy.visit('/shopping-cart');
    cy.get('.cart-items').should('contain', productId);
  });

  it('should verify the product details in the cart', () => {
    cy.get('.cart-item').within(() => {
      cy.get('.product-name').should('contain', productId);
      cy.get('.product-quantity').should('contain', quantity);
    });
  });

  it('should check the cart summary section', () => {
    cy.get('.cart-summary').should('contain', `Total Items: ${quantity}`);
  });

  it('should attempt to add the same product again', () => {
    cy.get(`[data-product-id="${productId}"]`).click();
    cy.get('button.add-to-cart').click();
    cy.get('.cart-item .product-quantity').should('contain', quantity + 1);
  });

  it('should remove the product from the cart', () => {
    cy.get('.cart-item .remove').click();
    cy.get('.cart-items').should('not.contain', productId);
  });

  after(() => {
    cy.logout();
  });
});