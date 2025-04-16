describe('Admin Price Adjustment with Invalid Price', () => {
  const adminPage = new AdminPage();
  const pricingPage = new PricingPage();

  before(() => {
    cy.visit('/admin');
    adminPage.login('admin', 'password');
  });

  it('should display an error when an invalid price is entered', () => {
    pricingPage.navigateToPricingSection();
    pricingPage.searchProductById('12345');
    pricingPage.selectProductAndEditPrice();
    pricingPage.enterInvalidPrice('-$10.00');
    pricingPage.savePrice();
    pricingPage.verifyErrorMessage('Price cannot be negative');
    pricingPage.verifyPriceUnchanged('12345');
  });

  after(() => {
    adminPage.logout();
  });
});