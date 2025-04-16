describe('Account Deletion - Incorrect Password', () => {
  before(() => {
    cy.login('test_user'); // Custom command to log in
  });

  it('should not delete account with incorrect password', () => {
    cy.visit('/account-settings');

    cy.get(AccountSettingsPage.deleteAccountButton).should('be.visible');
    cy.get(AccountSettingsPage.deleteAccountButton).click();

    cy.get(AccountSettingsPage.confirmationDialog).should('be.visible');
    cy.get(AccountSettingsPage.passwordInput).type('incorrect_pass');
    cy.get(AccountSettingsPage.confirmButton).click();

    cy.get(AccountSettingsPage.errorMessage).should('contain', 'password is incorrect');

    cy.logout();
    cy.login('test_user');
    cy.url().should('include', '/dashboard');
  });
});