describe('TC-623 490 Remote Monitoring Integration', () => {
  const participantId = 'P-001';
  const deviceId = 'MD-001';
  const trackingFrequency = 'Real-time';

  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
  });

  it('should integrate with remote monitoring tools for real-time tracking', () => {
    cy.navigateTo('Remote Monitoring');
    cy.get(RemoteMonitoringPage.integrateDeviceButton).click();
    cy.get(RemoteMonitoringPage.participantIdField).type(participantId);
    cy.get(RemoteMonitoringPage.deviceIdField).type(deviceId);
    cy.get(RemoteMonitoringPage.trackingFrequencyDropdown).select(trackingFrequency);
    cy.get(RemoteMonitoringPage.initiateIntegrationButton).click();
    cy.get(RemoteMonitoringPage.integrationStatus).should('contain', 'successful');
    cy.get(RemoteMonitoringPage.realTimeUpdates).should('be.visible');
    cy.simulateDisconnection();
    cy.get(RemoteMonitoringPage.alert).should('be.visible');
    cy.reconnectDevice();
    cy.get(RemoteMonitoringPage.realTimeUpdates).should('be.visible');
    cy.get(RemoteMonitoringPage.generateReportButton).click();
    cy.get(RemoteMonitoringPage.report).should('contain', participantId);
    cy.logout();
    cy.login('validUsername', 'validPassword');
    cy.navigateTo('Remote Monitoring');
    cy.get(RemoteMonitoringPage.savedSettings).should('be.visible');
  });

  afterEach(() => {
    cy.logout();
  });
});