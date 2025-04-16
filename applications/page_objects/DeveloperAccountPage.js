class DeveloperAccountPage {
  visit() {
    cy.visit('/developer/account');
  }

  getApiKeyStatus() {
    return cy.get('.api-key-status');
  }

  requestNewApiKey() {
    cy.get('.request-new-api-key').click();
  }

  getNotification() {
    return cy.get('.notification');
  }

  getApiKeyList() {
    return cy.get('.api-key-list');
  }

  getLastApiKey() {
    return this.getApiKeyList().find('.api-key').last();
  }
}

export default DeveloperAccountPage;