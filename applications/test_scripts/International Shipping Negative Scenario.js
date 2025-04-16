describe('International Shipping Negative Scenario', () => {
  const loginPage = new LoginPage();
  const productPage = new ProductPage();
  const cartPage = new CartPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the customer account', () => {
    loginPage.login('activeUser', 'password123');
    cy.url().should('include', '/dashboard');
  });

  it('should add products to the cart', () => {
    productPage.addProductToCart('Product Name');
    cy.get('.cart-items').should('contain', 'Product Name');
  });

  it('should display error for invalid international shipping address', () => {
    cartPage.enterShippingAddress('Invalid Address');
    cy.get('.error-message').should('contain', 'invalid shipping address');
  });
});