describe('Email Unsubscription Test', () => {
  const accountSettingsPage = new AccountSettingsPage();

  before(() => {
    cy.login(); // Custom command to log in the user
  });

  it('should allow users to unsubscribe from marketing emails', () => {
    accountSettingsPage.navigateToAccountSettings();
    accountSettingsPage.verifyEmailPreferencesVisible();
    accountSettingsPage.unsubscribeFromMarketingEmails();
    accountSettingsPage.confirmUnsubscription();
  });
});