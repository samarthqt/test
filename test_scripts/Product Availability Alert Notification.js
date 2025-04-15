describe('Product Availability Alert Notification', () => {
  const loginPage = new LoginPage();
  const productPage = new ProductPage();
  const accountPage = new AccountPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in to the user account', () => {
    loginPage.login('testuser@example.com', 'password');
    accountPage.verifyLoginSuccess();
  });

  it('should search for the out of stock product', () => {
    productPage.searchProduct('Product C');
    productPage.verifyProductOutOfStock();
  });

  it('should subscribe to product availability alert', () => {
    productPage.clickNotifyMe();
    productPage.confirmNotificationSubscription();
  });

  it('should simulate product coming back in stock', () => {
    productPage.simulateProductInStock();
    productPage.verifyProductInStock();
  });

  it('should check user email for notification', () => {
    cy.checkEmailForNotification('Product C is back in stock');
  });

  it('should check user account notifications', () => {
    accountPage.verifyNotificationInAccount('Product C is back in stock');
  });

  it('should log out from the user account', () => {
    accountPage.logout();
    accountPage.verifyLogoutSuccess();
  });
});