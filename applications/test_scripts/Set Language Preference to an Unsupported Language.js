describe('Set Language Preference to an Unsupported Language', () => {
  before(() => {
    cy.visit('/login');
    cy.login('testuser', 'password');
  });

  it('should not allow setting an unsupported language', () => {
    const settingsPage = new SettingsPage();
    settingsPage.navigateToSettings();
    settingsPage.selectLanguagePreferences();
    settingsPage.selectUnsupportedLanguage('Klingon');
    settingsPage.verifyUnsupportedLanguageError();
  });
});