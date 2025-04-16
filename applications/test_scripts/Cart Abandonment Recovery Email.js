describe('Cart Abandonment Recovery Email', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const cartPage = new CartPage();
  const emailService = new EmailService();

  before(() => {
    cy.visit('/login');
  });

  it('should log in and add items to cart', () => {
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyLoginSuccess();
    cartPage.addItemToCart('Product A');
    cartPage.addItemToCart('Product B');
    cartPage.verifyItemsInCart(['Product A', 'Product B']);
  });

  it('should abandon the cart and verify email is received', () => {
    cartPage.navigateAwayFromCart();
    emailService.waitForAbandonmentEmail('user@example.com').then((email) => {
      expect(email.subject).to.include('Complete your purchase');
    });
  });
});