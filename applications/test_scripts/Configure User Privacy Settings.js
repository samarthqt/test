describe('User Privacy Settings Configuration', () => {
  const userId = '12345';

  before(() => {
    cy.visit('/login');
    cy.login(userId, 'password');
  });

  it('should navigate to Privacy Settings and opt-out of data collection', () => {
    cy.getAccountSettings().navigateToPrivacySettings();
    cy.privacySettingsPage().selectOptOutDataCollection();
    cy.privacySettingsPage().saveChanges();
    cy.privacySettingsPage().verifyOptOutActive();
  });

  it('should allow data access to specific users', () => {
    cy.privacySettingsPage().selectAllowDataAccess();
    cy.privacySettingsPage().specifyUserAccess(['67890']);
    cy.privacySettingsPage().saveChanges();
  });

  it('should verify settings persist after re-login', () => {
    cy.logout();
    cy.login(userId, 'password');
    cy.privacySettingsPage().verifyOptOutActive();
  });

  it('should deny access from non-specified user and grant access from specified user', () => {
    cy.attemptDataAccess('non-specified-user', false);
    cy.attemptDataAccess('67890', true);
  });

  it('should reset privacy settings to default and verify', () => {
    cy.privacySettingsPage().resetToDefault();
    cy.privacySettingsPage().verifyDefaultSettings();
  });

  it('should opt-out again and verify persistence', () => {
    cy.privacySettingsPage().selectOptOutDataCollection();
    cy.privacySettingsPage().saveChanges();
    cy.logout();
    cy.login(userId, 'password');
    cy.privacySettingsPage().verifyOptOutActive();
  });
});