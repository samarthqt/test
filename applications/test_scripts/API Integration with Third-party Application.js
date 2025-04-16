describe('API Integration with Third-party Application', () => {
  const apiKey = 'abc123xyz';
  const thirdPartyUrl = 'https://thirdpartyapp.com';

  before(() => {
    cy.visit(thirdPartyUrl);
  });

  it('Logs in to the third-party application', () => {
    const loginPage = new LoginPage();
    loginPage.login('username', 'password');
    cy.url().should('include', '/dashboard');
  });

  it('Navigates to the API integration settings', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.goToApiIntegrationSettings();
    cy.url().should('include', '/api-settings');
  });

  it('Enters the API key into the integration settings', () => {
    const apiSettingsPage = new ApiSettingsPage();
    apiSettingsPage.enterApiKey(apiKey);
    apiSettingsPage.verifyApiKeyEntered(apiKey);
  });

  it('Saves the integration settings', () => {
    const apiSettingsPage = new ApiSettingsPage();
    apiSettingsPage.saveSettings();
    apiSettingsPage.verifySettingsSaved();
  });

  it('Performs a test API call from the third-party application', () => {
    const apiSettingsPage = new ApiSettingsPage();
    apiSettingsPage.performTestApiCall();
    apiSettingsPage.verifyApiCallSuccess();
  });
});