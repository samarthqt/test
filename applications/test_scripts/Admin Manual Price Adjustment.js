describe('Admin Manual Price Adjustment', () => {
  const adminPage = new AdminPage();

  before(() => {
    cy.visit('/admin');
  });

  it('should log in to the admin panel', () => {
    adminPage.login('admin', 'password');
    adminPage.verifyLoginSuccess();
  });

  it('should navigate to the Pricing section', () => {
    adminPage.navigateToPricingSection();
    adminPage.verifyPricingSectionDisplayed();
  });

  it('should search and select the product by ID', () => {
    adminPage.searchProductById('12345');
    adminPage.verifyProductDisplayed('12345');
  });

  it('should edit the product price', () => {
    adminPage.selectProductAndEditPrice('12345');
    adminPage.enterNewPrice('49.99');
  });

  it('should save the new price', () => {
    adminPage.savePrice();
    adminPage.verifyPriceUpdateConfirmation();
  });

  it('should verify the updated price', () => {
    adminPage.verifyUpdatedPrice('12345', '49.99');
  });

  after(() => {
    adminPage.logout();
    adminPage.verifyLogoutSuccess();
  });
});