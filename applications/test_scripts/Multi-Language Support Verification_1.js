describe('Multi-Language Support Verification', () => {
  const loginPage = new LoginPage();
  const settingsPage = new SettingsPage();
  const homePage = new HomePage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.login('validUsername', 'validPassword');
    homePage.verifyUserIsLoggedIn();
  });

  it('should navigate to settings and verify language options', () => {
    homePage.navigateToSettings();
    settingsPage.verifySettingsMenuIsDisplayed();
    settingsPage.selectLanguageOption();
    settingsPage.verifyLanguageScreenDisplayed();
  });

  const languages = ['English', 'Spanish', 'French', 'Chinese', 'Arabic'];

  languages.forEach(language => {
    it(`should change language to ${language} and verify`, () => {
      settingsPage.changeLanguageTo(language);
      settingsPage.verifyLanguageChangedTo(language);
    });
  });

  it('should persist language selection after logout and re-login', () => {
    settingsPage.changeLanguageTo('Spanish');
    homePage.logout();
    loginPage.login('validUsername', 'validPassword');
    settingsPage.verifyLanguageChangedTo('Spanish');
  });

  it('should ensure consistent language support across sections', () => {
    homePage.navigateThroughSections();
    homePage.verifyLanguageConsistency('Spanish');
  });

  it('should change language while performing an action', () => {
    homePage.startFillingForm();
    settingsPage.changeLanguageTo('French');
    homePage.verifyFormIsIntact();
  });

  it('should check for untranslated text or errors', () => {
    homePage.verifyNoUntranslatedTextOrErrors('French');
  });

  it('should handle rapid language changes smoothly', () => {
    settingsPage.rapidLanguageSwitch(languages);
    settingsPage.verifySystemStability();
  });

  it('should verify language change in notifications and alerts', () => {
    homePage.triggerNotification();
    homePage.verifyNotificationLanguage('French');
  });

  it('should ensure language selection is available on all platforms', () => {
    homePage.verifyLanguageSelectionAcrossDevices();
  });
});