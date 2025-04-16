describe('Real-Time Inventory Updates on Purchase', () => {
  const adminPage = new AdminPage();
  const userPage = new UserPage();
  const productPage = new ProductPage();

  before(() => {
    cy.visit('/admin');
    adminPage.login('admin', 'admin123');
  });

  it('should verify initial inventory level', () => {
    adminPage.checkInventoryLevel('98765', 100);
  });

  it('should log in and purchase a product', () => {
    cy.visit('/login');
    userPage.login('user', 'user123');
    productPage.navigateToProduct('98765');
    productPage.addToCart(1);
    productPage.proceedToCheckout();
    productPage.completePurchase();
  });

  it('should verify inventory level after purchase', () => {
    cy.visit('/admin');
    adminPage.login('admin', 'admin123');
    adminPage.checkInventoryLevel('98765', 99);
  });
});