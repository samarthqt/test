describe('Cart Abandonment Recovery Email with No Items', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const cartPage = new CartPage();

  before(() => {
    cy.visit('/');
  });

  it('should not send a cart abandonment email if the cart is empty', () => {
    loginPage.login('user34567', 'password123');
    dashboardPage.verifyUserLoggedIn();
    cartPage.verifyCartIsEmpty();
    cartPage.navigateAwayFromCart();
    cy.wait(10000); // Wait for any potential email sending process
    cy.task('checkEmailNotSent', 'user34567@example.com').should('be.false');
  });
});