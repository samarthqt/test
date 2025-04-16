describe('Multi-language Support Test', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const userInterfaceSettingsPage = new UserInterfaceSettingsPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the system with user credentials', () => {
    loginPage.enterUserId('55678');
    loginPage.enterPassword('password123');
    loginPage.clickLoginButton();
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to the User Interface Settings module', () => {
    dashboardPage.goToUserInterfaceSettings();
    userInterfaceSettingsPage.verifySettingsPageIsDisplayed();
  });

  it('should select Spanish as the preferred language', () => {
    userInterfaceSettingsPage.selectLanguage('Spanish');
    userInterfaceSettingsPage.saveLanguageSettings();
    userInterfaceSettingsPage.verifyLanguageIsSetToSpanish();
  });

  it('should ensure consistent language application across modules', () => {
    dashboardPage.navigateThroughModules();
    dashboardPage.verifyModulesDisplayInSpanish();
  });

  it('should log out and verify language persistence upon re-login', () => {
    dashboardPage.logout();
    loginPage.verifyLoginPageIsDisplayed();
    loginPage.enterUserId('55678');
    loginPage.enterPassword('password123');
    loginPage.clickLoginButton();
    dashboardPage.verifyDashboardIsDisplayedInSpanish();
  });
});