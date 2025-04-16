describe('Health Tracking Wearable Integration - Successful Sync', () => {
  const patientPortal = new PatientPortal();
  const wearableIntegration = new WearableIntegration();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should successfully sync with a health tracking wearable device', () => {
    patientPortal.login('P12345', 'validPassword');
    cy.url().should('include', '/dashboard');

    wearableIntegration.navigateToModule();
    wearableIntegration.addDevice();
    wearableIntegration.selectDeviceType('Fitbit');
    wearableIntegration.authorizeDeviceAccess();
    wearableIntegration.initiateDataSync();

    wearableIntegration.verifySyncStatus();
    wearableIntegration.checkSyncedData(['heart rate', 'steps', 'sleep patterns']);

    patientPortal.logout();
    cy.url().should('include', '/login');
  });
});