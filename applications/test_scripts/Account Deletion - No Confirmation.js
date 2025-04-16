describe('Account Deletion - No Confirmation', () => {
  const username = 'test_user';
  const password = 'test_pass';

  beforeEach(() => {
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  });

  it('should not delete account if confirmation is not provided', () => {
    const accountPage = new AccountPage();
    accountPage.navigateToAccountSettings();
    accountPage.verifyAccountSettingsPageDisplayed();
    accountPage.locateDeleteAccountOption();
    accountPage.clickDeleteAccountOption();
    accountPage.closeConfirmationDialog();

    cy.visit('/logout');
    cy.visit('/login');
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();

    cy.url().should('include', '/dashboard');
  });
});