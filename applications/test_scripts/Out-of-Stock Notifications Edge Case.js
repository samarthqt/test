describe('Out-of-Stock Notifications Edge Case', () => {
  const userEmail = 'a'.repeat(254) + '@example.com'; // Maximum length email
  const productId = '22334';

  before(() => {
    cy.visit('/login');
    LoginPage.login('validUser', 'validPassword');
  });

  it('should search for the out-of-stock product', () => {
    HomePage.searchProduct(productId);
    ProductPage.verifyOutOfStockStatus();
  });

  it('should opt-in for restock notifications with maximum length email', () => {
    ProductPage.optInForNotifications(userEmail);
    ProductPage.verifyOptInSuccess();
  });

  it('should verify notification preference in user account settings', () => {
    AccountPage.navigateToSettings();
    AccountPage.verifyNotificationPreference(userEmail);
  });

  it('should restock the product and verify notification', () => {
    cy.restockProduct(productId); // Custom command or API request to restock
    cy.checkEmailForNotification(userEmail, productId);
  });

  after(() => {
    AccountPage.logout();
  });
});