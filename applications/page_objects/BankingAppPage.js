class BankingAppPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  verifyDashboard() {
    cy.url().should('include', '/dashboard');
  }

  navigateToIntegrationSettings() {
    cy.get('#settingsMenu').click();
    cy.get('#integrationSettings').click();
  }
}

class IntegrationPage {
  verifyIntegrationSettingsPage() {
    cy.url().should('include', '/integration');
  }

  addThirdPartyService() {
    cy.get('#addThirdPartyService').click();
  }

  selectThirdPartyService(serviceName) {
    cy.get('.service-list').contains(serviceName).click();
  }

  enterServiceCredentials(apiKey, serviceAccountId) {
    cy.get('#apiKey').type(apiKey);
    cy.get('#serviceAccountId').type(serviceAccountId);
    cy.get('#confirmIntegration').click();
  }

  verifySuccessfulIntegration() {
    cy.get('.success-message').should('be.visible');
  }

  verifyIntegratedServices(serviceName) {
    cy.get('.integrated-services').contains(serviceName).should('exist');
  }

  exportDataToService() {
    cy.get('#exportDataButton').click();
  }

  verifyDataExported() {
    cy.get('.export-success-message').should('be.visible');
  }
}