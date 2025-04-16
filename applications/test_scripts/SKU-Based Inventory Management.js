describe('SKU-Based Inventory Management', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const skuManagementPage = new SKUManagementPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should log in to the inventory management system', () => {
    loginPage.login('USR001', 'password');
    dashboardPage.verifyUserIsOnDashboard();
  });

  it('should navigate to SKU Management module', () => {
    dashboardPage.navigateToSKUManagement();
    skuManagementPage.verifySKUManagementPage();
  });

  it('should enter SKU Code and verify product details', () => {
    skuManagementPage.enterSKUCode('SKU001');
    skuManagementPage.verifyProductDetails('Product Name', 'Category', 'Quantity');
  });

  it('should update product quantity and save changes', () => {
    skuManagementPage.updateProductQuantity(100);
    skuManagementPage.saveChanges();
    skuManagementPage.verifyQuantityUpdated(100);
  });

  it('should search for another product using different SKU code', () => {
    skuManagementPage.enterSKUCode('SKU002');
    skuManagementPage.verifyProductDetails('Another Product Name', 'Another Category', 'Another Quantity');
  });

  it('should log out from the system', () => {
    dashboardPage.logout();
    loginPage.verifyUserIsLoggedOut();
  });
});