describe('Account Deletion - Successful Deletion', () => {
  const username = 'test_user';
  const password = 'test_pass';

  before(() => {
    cy.login(username, password); // Assuming a custom command for login
  });

  it('should delete the account permanently', () => {
    const accountSettingsPage = new AccountSettingsPage();
    accountSettingsPage.navigateToSettings();
    accountSettingsPage.verifyAccountSettingsPageDisplayed();
    accountSettingsPage.locateDeleteAccountOption();
    accountSettingsPage.clickDeleteAccountOption();
    accountSettingsPage.confirmAccountDeletion(password);
    accountSettingsPage.verifyAccountDeletionSuccess();
  });

  it('should not allow login with deleted account credentials', () => {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
    cy.get('.error-message').should('contain', 'account does not exist');
  });
});