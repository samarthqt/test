describe('Multi-Currency Support Edge Case Test', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const accountSettingsPage = new AccountSettingsPage();
  const productPage = new ProductPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display currency with maximum decimal precision', () => {
    // Step 1: Log in to the user account
    loginPage.login('validUser', 'validPassword');
    homePage.verifyUserIsOnHomePage();

    // Step 2: Navigate to the account settings
    homePage.goToAccountSettings();
    accountSettingsPage.verifyAccountSettingsPage();

    // Step 3: Select JPY as the preferred currency
    accountSettingsPage.selectCurrency('JPY');
    accountSettingsPage.verifyCurrencyUpdated('JPY');

    // Step 4: Search for a product
    homePage.searchForProduct('Sample Product');
    productPage.verifyProductDetailsDisplayedInCurrency('JPY');

    // Step 5: Change user location to Germany
    accountSettingsPage.changeUserLocation('Germany');
    accountSettingsPage.verifyCurrencyUpdated('EUR');

    // Step 6: Search for a product again
    homePage.searchForProduct('Sample Product');
    productPage.verifyProductDetailsDisplayedInCurrency('EUR');

    // Step 7: Log out from the user account
    homePage.logout();
    loginPage.verifyUserIsLoggedOut();
  });
});