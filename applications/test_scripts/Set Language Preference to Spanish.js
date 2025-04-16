describe('Language Preference Test Suite', () => {
  beforeEach(() => {
    cy.visit('/login');
    const loginPage = new LoginPage();
    loginPage.login('testuser', 'password');
  });

  it('should set language preference to Spanish', () => {
    const settingsPage = new SettingsPage();
    settingsPage.navigateToSettings();
    settingsPage.selectLanguagePreferences();
    settingsPage.chooseLanguage('Spanish');
    settingsPage.saveChanges();
    cy.get('body').should('contain.text', 'Bienvenido'); // Verify interface updates to Spanish
  });
});