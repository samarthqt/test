describe('Account Deletion Process', () => {
  const accountSettingsPage = new AccountSettingsPage();
  const loginPage = new LoginPage();
  const homePage = new HomePage();

  before(() => {
    cy.login('user12345', 'password'); // Assuming a custom command for login
  });

  it('should navigate to account settings', () => {
    accountSettingsPage.navigateToAccountSettings();
    accountSettingsPage.verifyAccountSettingsPage();
  });

  it('should delete the account after confirmation', () => {
    accountSettingsPage.clickDeleteAccountButton();
    accountSettingsPage.verifyDeleteConfirmationMessage();
    accountSettingsPage.confirmAccountDeletion();
  });

  it('should log out and redirect to homepage', () => {
    homePage.verifyUserIsLoggedOut();
    homePage.verifyRedirectedToHomepage();
  });

  it('should fail to log in with deleted account credentials', () => {
    loginPage.navigateToLoginPage();
    loginPage.attemptLogin('user12345', 'password');
    loginPage.verifyLoginFailed();
  });
});