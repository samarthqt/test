describe('Order Minimum Requirement for Free Shipping', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();
  const orderConfirmationPage = new OrderConfirmationPage();
  const orderHistoryPage = new OrderHistoryPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    loginPage.login('validUser', 'validPassword');
    homePage.verifyHomePage();
  });

  it('should search and add product to cart', () => {
    homePage.searchProduct('12345');
    productPage.addToCart(3);
    cartPage.verifyCartSummary('$60');
  });

  it('should proceed to checkout and verify free shipping', () => {
    cartPage.proceedToCheckout();
    checkoutPage.verifyOrderValue('$60');
    checkoutPage.verifyFreeShipping();
  });

  it('should complete payment and verify order confirmation', () => {
    checkoutPage.completePayment();
    orderConfirmationPage.verifyOrderConfirmation();
    orderConfirmationPage.verifyFreeShipping();
  });

  it('should verify order in order history', () => {
    orderHistoryPage.navigateToOrderHistory();
    orderHistoryPage.verifyRecentOrderWithFreeShipping();
  });

  it('should log out from the user account', () => {
    homePage.logout();
  });
});