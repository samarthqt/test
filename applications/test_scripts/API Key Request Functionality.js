describe('API Key Request Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const apiKeyRequestPage = new APIKeyRequestPage();
  const emailPage = new EmailPage();

  before(() => {
    cy.visit('https://api-management-portal.com');
  });

  it('should log in to the API management portal', () => {
    loginPage.enterUsername('dev_user');
    loginPage.enterPassword('dev_pass');
    loginPage.submit();
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to the API key request section', () => {
    dashboardPage.goToAPIKeyRequestSection();
    apiKeyRequestPage.verifyAPIKeyRequestFormIsDisplayed();
  });

  it('should fill out the API request form with valid details', () => {
    apiKeyRequestPage.fillAPIRequestForm({
      applicationName: 'Test Application',
      description: 'Requesting API key for testing purposes'
    });
    apiKeyRequestPage.verifyNoValidationErrors();
  });

  it('should submit the API key request form', () => {
    apiKeyRequestPage.submitForm();
    apiKeyRequestPage.verifyConfirmationMessage();
  });

  it('should check email for confirmation of API key request', () => {
    emailPage.openEmailClient();
    emailPage.verifyEmailReceived('API Key Request Confirmation');
  });

  it('should verify the API key is generated and available in the developer account', () => {
    dashboardPage.goToAPIKeysSection();
    dashboardPage.verifyAPIKeyIsGenerated('Test Application');
  });
});