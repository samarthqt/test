describe('Third-Party Service Integration', () => {
  const bankingApp = new BankingAppPage();
  const integrationPage = new IntegrationPage();

  beforeEach(() => {
    cy.visit('https://bankingapp.com');
    bankingApp.login('user345678', 'password');
    bankingApp.verifyDashboard();
  });

  it('should integrate with third-party service', () => {
    bankingApp.navigateToIntegrationSettings();
    integrationPage.verifyIntegrationSettingsPage();
    integrationPage.addThirdPartyService();
    integrationPage.selectThirdPartyService('Tax Software');
    integrationPage.enterServiceCredentials('ABCDEFGHIJKLMNOP', '567890');
    integrationPage.verifySuccessfulIntegration();
    integrationPage.verifyIntegratedServices('Tax Software');
    integrationPage.exportDataToService();
    integrationPage.verifyDataExported();
  });
});