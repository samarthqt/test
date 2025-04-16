class RemoteMonitoringPage {
  static integrateDeviceButton = 'button#integrateDevice';
  static participantIdField = 'input#participantId';
  static deviceIdField = 'input#deviceId';
  static trackingFrequencyDropdown = 'select#trackingFrequency';
  static initiateIntegrationButton = 'button#initiateIntegration';
  static integrationStatus = 'div#integrationStatus';
  static realTimeUpdates = 'div#realTimeUpdates';
  static alert = 'div#alert';
  static generateReportButton = 'button#generateReport';
  static report = 'div#report';
  static savedSettings = 'div#savedSettings';

  static navigateTo(moduleName) {
    cy.get(`a[href="/${moduleName.replace(' ', '').toLowerCase()}"]`).click();
  }

  static simulateDisconnection() {
    cy.get('button#simulateDisconnection').click();
  }

  static reconnectDevice() {
    cy.get('button#reconnectDevice').click();
  }
}

export default RemoteMonitoringPage;