describe('Bulk Order Option Negative Scenario', () => {
  const loginPage = new LoginPage();
  const productPage = new ProductPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.login('customer@example.com', 'password123');
  });

  it('should fail when selecting a quantity exceeding stock', () => {
    productPage.navigateToProduct('12345');
    productPage.selectQuantity(1000);
    productPage.verifyInsufficientStockError();
  });
});