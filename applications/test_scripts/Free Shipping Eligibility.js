describe('Free Shipping Eligibility Test', () => {
  const loginPage = new LoginPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the customer account successfully', () => {
    loginPage.login('customer@example.com', 'password123');
    cy.url().should('include', '/dashboard');
  });

  it('should add products to the cart with a total exceeding $100', () => {
    cartPage.addProductToCart('Product A', 2);
    cartPage.addProductToCart('Product B', 3);
    cartPage.verifyCartTotal(150);
  });

  it('should proceed to checkout and verify free shipping option', () => {
    checkoutPage.proceedToCheckout();
    checkoutPage.verifyFreeShippingOption();
  });
});