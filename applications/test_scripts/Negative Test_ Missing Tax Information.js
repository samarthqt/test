describe('Negative Test: Missing Tax Information', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should prompt an error if tax information is missing', () => {
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyLoginSuccess();
    dashboardPage.navigateToCart();

    cartPage.verifyItemInCart(202, 150);
    cartPage.proceedToCheckout();

    checkoutPage.verifyMissingTaxError();
  });
});