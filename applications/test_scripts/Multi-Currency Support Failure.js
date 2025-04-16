describe('Multi-Currency Support Failure Test', () => {
  const loginPage = new LoginPage();
  const homePage = new HomePage();
  const accountSettingsPage = new AccountSettingsPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should handle error when selecting an unsupported currency', () => {
    // Step 1: Log in to the user account
    loginPage.login('validUsername', 'validPassword');
    homePage.verifyHomePage();

    // Step 2: Navigate to the account settings
    homePage.goToAccountSettings();
    accountSettingsPage.verifyAccountSettingsPage();

    // Step 3: Attempt to select XYZ as the preferred currency
    accountSettingsPage.selectCurrency('XYZ');
    accountSettingsPage.verifyUnsupportedCurrencyError();

    // Step 4: Verify the currency preference remains unchanged
    accountSettingsPage.verifyCurrencyPreferenceUnchanged();

    // Step 5: Log out from the user account
    homePage.logout();
    loginPage.verifyLoggedOut();
  });
});