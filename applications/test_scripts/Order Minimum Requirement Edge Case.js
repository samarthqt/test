describe('Order Minimum Requirement Edge Case', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const productPage = new ProductPage();
  const cartPage = new CartPage();
  const checkoutPage = new CheckoutPage();
  const orderConfirmationPage = new OrderConfirmationPage();
  const orderHistoryPage = new OrderHistoryPage();

  before(() => {
    cy.visit('/');
  });

  it('logs in to user account', () => {
    loginPage.login('validUser', 'validPassword');
    homePage.verifyHomePage();
  });

  it('searches and adds product to cart', () => {
    homePage.searchProduct('67890');
    productPage.verifyProductDetails();
    productPage.addToCart(2);
    cartPage.verifyCartSummary();
  });

  it('proceeds to checkout', () => {
    cartPage.proceedToCheckout();
    checkoutPage.verifyCheckoutPage();
  });

  it('verifies order value and free shipping', () => {
    checkoutPage.verifyOrderValue('$50');
    checkoutPage.verifyFreeShipping();
  });

  it('completes payment process', () => {
    checkoutPage.completePayment();
    orderConfirmationPage.verifyOrderConfirmation();
  });

  it('verifies shipping details in order confirmation', () => {
    orderConfirmationPage.verifyFreeShipping();
  });

  it('navigates to order history', () => {
    orderHistoryPage.navigateToOrderHistory();
    orderHistoryPage.verifyRecentOrderWithFreeShipping();
  });

  it('logs out from user account', () => {
    homePage.logout();
    loginPage.verifyLoggedOut();
  });
});