describe('Display Total Price with Taxes and Shipping', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('Verify total price including taxes and shipping fees is displayed before checkout', () => {
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyUserIsLoggedIn();

    dashboardPage.navigateToCart();
    cartPage.verifyCartPageIsDisplayed();
    cartPage.verifyItemInCart('201', 100);

    cartPage.proceedToCheckout();
    checkoutPage.verifyCheckoutPageIsDisplayed();
    checkoutPage.verifyTotalPrice(120, 10, 10);
  });
});