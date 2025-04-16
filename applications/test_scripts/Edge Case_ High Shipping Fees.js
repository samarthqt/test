describe('High Shipping Fees Edge Case', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();

  it('should calculate total price correctly with high shipping fees', () => {
    // Step 1: Log in to the system
    cy.visit('/login');
    loginPage.enterUsername('testUser');
    loginPage.enterPassword('password123');
    loginPage.clickLogin();
    dashboardPage.verifyDashboardPage();

    // Step 2: Navigate to the shopping cart
    dashboardPage.goToCart();
    cartPage.verifyCartPage();

    // Step 3: Verify item in cart
    cartPage.verifyItemInCart(203, 200);

    // Step 4: Proceed to checkout
    cartPage.proceedToCheckout();
    checkoutPage.verifyCheckoutPage();

    // Step 5: Verify total price
    checkoutPage.verifyTotalPrice(1330);
  });
});