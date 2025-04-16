describe('Health Tracking Wearable Integration - Unsupported Device', () => {
  const patientId = 'P12345';
  const deviceId = 'U12345';
  const deviceType = 'UnknownDevice';

  before(() => {
    cy.visit('/login');
    cy.login(patientId);
  });

  it('should navigate to Wearable Integration module', () => {
    cy.get('nav').contains('Wearable Integration').click();
    cy.url().should('include', '/wearable-integration');
  });

  it('should attempt to add an unsupported device', () => {
    cy.get('.add-device-button').click();
    cy.get('.device-type-select').select(deviceType);
    cy.get('.device-id-input').type(deviceId);
    cy.get('.sync-device-button').click();
    cy.get('.error-message').should('contain', 'Device type is unsupported');
  });

  after(() => {
    cy.logout();
  });
});