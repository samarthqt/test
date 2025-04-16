describe('Invalid API Key Request', () => {
  const loginPage = new LoginPage();
  const apiKeyRequestPage = new ApiKeyRequestPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in with developer credentials', () => {
    loginPage.enterUsername('developer_username');
    loginPage.enterPassword('developer_password');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to API key request section', () => {
    apiKeyRequestPage.navigateToApiKeyRequestSection();
    apiKeyRequestPage.verifyApiKeyRequestFormDisplayed();
  });

  it('should display validation errors for invalid form data', () => {
    apiKeyRequestPage.fillInvalidApiKeyRequestForm();
    apiKeyRequestPage.submitForm();
    apiKeyRequestPage.verifyValidationErrors();
  });
});