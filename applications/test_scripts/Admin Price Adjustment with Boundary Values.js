describe('Admin Price Adjustment with Boundary Values', () => {
  const adminPage = new AdminPage();

  before(() => {
    cy.visit('/admin');
  });

  it('should log in as admin', () => {
    adminPage.login('admin', 'password');
    adminPage.verifyLogin();
  });

  it('should navigate to the Pricing section', () => {
    adminPage.goToPricingSection();
    adminPage.verifyPricingSection();
  });

  it('should search for the product by ID and edit price to $0.01', () => {
    adminPage.searchProductById('12345');
    adminPage.selectProduct();
    adminPage.editPrice('0.01');
    adminPage.savePrice();
    adminPage.verifyUpdatedPrice('0.01');
  });

  it('should edit price to $99999.99', () => {
    adminPage.editPrice('99999.99');
    adminPage.savePrice();
    adminPage.verifyUpdatedPrice('99999.99');
  });

  it('should log out from admin panel', () => {
    adminPage.logout();
    adminPage.verifyLogout();
  });
});