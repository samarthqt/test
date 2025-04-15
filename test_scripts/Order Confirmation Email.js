describe('Order Confirmation Email Test', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const checkoutPage = new CheckoutPage();
  const emailService = new EmailService();

  before(() => {
    cy.visit('/login');
  });

  it('should log in successfully', () => {
    loginPage.login('validUser', 'validPassword');
    homePage.verifyUserLoggedIn();
  });

  it('should add products to cart and proceed to checkout', () => {
    homePage.addProductsToCart();
    homePage.proceedToCheckout();
    checkoutPage.verifyCheckoutPage();
  });

  it('should complete purchase and verify order confirmation email', () => {
    checkoutPage.completePurchase();
    checkoutPage.verifyPurchaseCompletion();
    emailService.verifyOrderConfirmationEmail('user@example.com', '5001');
  });

  after(() => {
    cy.clearCookies();
  });
});