describe('Account Deletion - Edge Case - Simultaneous Deletion', () => {
  const accountSettingsPageA = new AccountSettingsPage();
  const accountSettingsPageB = new AccountSettingsPage();

  beforeEach(() => {
    cy.login('test_user', 'test_pass', 'Device A');
    cy.login('test_user', 'test_pass', 'Device B');
  });

  it('should navigate to account settings page on Device A', () => {
    accountSettingsPageA.navigateToSettings();
    accountSettingsPageA.verifySettingsPageDisplayed();
  });

  it('should navigate to account settings page on Device B', () => {
    accountSettingsPageB.navigateToSettings();
    accountSettingsPageB.verifySettingsPageDisplayed();
  });

  it('should initiate account deletion on Device A', () => {
    accountSettingsPageA.initiateAccountDeletion();
    accountSettingsPageA.verifyDeletionConfirmationDialog();
  });

  it('should initiate account deletion on Device B', () => {
    accountSettingsPageB.initiateAccountDeletion();
    accountSettingsPageB.verifyDeletionConfirmationDialog();
  });

  it('should confirm account deletion on Device A', () => {
    accountSettingsPageA.confirmAccountDeletion();
    accountSettingsPageA.verifyAccountDeletedSuccessfully();
  });

  it('should display error message on Device B when confirming deletion', () => {
    accountSettingsPageB.confirmAccountDeletion();
    accountSettingsPageB.verifyAccountDeletionError();
  });
});