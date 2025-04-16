describe('Loyalty Program Points Accumulation', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const productPage = new ProductPage();
  const checkoutPage = new CheckoutPage();
  const loyaltyProgramPage = new LoyaltyProgramPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the user account', () => {
    loginPage.login('user98765', 'password123');
    dashboardPage.verifySuccessfulLogin();
  });

  it('should add a product to the shopping cart', () => {
    productPage.addProductToCart('$100 product');
    productPage.verifyProductAddedToCart();
  });

  it('should proceed to checkout with the selected product', () => {
    checkoutPage.proceedToCheckout();
    checkoutPage.verifyCheckoutPage();
  });

  it('should complete the checkout process', () => {
    checkoutPage.completeCheckout('Credit Card');
    checkoutPage.verifyOrderConfirmation();
  });

  it('should navigate to the Loyalty Program section', () => {
    dashboardPage.goToLoyaltyProgram();
    loyaltyProgramPage.verifyLoyaltyProgramPage();
  });

  it('should verify the loyalty points earned from the recent purchase', () => {
    loyaltyProgramPage.verifyLoyaltyPoints(100);
  });
});