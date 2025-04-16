describe('Out-of-Stock Notifications Failure', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const productPage = new ProductPage();
  const accountSettingsPage = new AccountSettingsPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should handle error when opting-in for notifications with invalid email', () => {
    loginPage.login('validUsername', 'validPassword');
    homePage.verifyUserIsLoggedIn();
    homePage.searchProductById('99001');
    productPage.verifyOutOfStockStatus();
    productPage.optInForRestockNotification('invalidEmailFormat');
    productPage.verifyInvalidEmailErrorMessage();
    accountSettingsPage.verifyNotificationPreferenceNotSaved();
    homePage.logout();
    homePage.verifyUserIsLoggedOut();
  });
});