describe('Bulk Order Option Functionality', () => {
  beforeEach(() => {
    cy.visit('https://example.com/login');
    const loginPage = new LoginPage();
    loginPage.login('customer@example.com', 'password123');
  });

  it('should allow customers to order multiple quantities and receive discounts', () => {
    const productPage = new ProductPage();
    productPage.navigateToProduct('12345');
    productPage.selectQuantity(100);
    productPage.verifyDiscount(10);
    productPage.proceedToCheckout();
  });
});