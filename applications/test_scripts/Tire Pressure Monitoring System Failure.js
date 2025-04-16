describe('Tire Pressure Monitoring System Failure', () => {
  const vehicleId = 'V12345';

  beforeEach(() => {
    cy.visit('/');
    cy.startVehicle(vehicleId);
  });

  it('should ensure the tire pressure monitoring system is active', () => {
    cy.getTirePressureSystemStatus(vehicleId).should('be.active');
  });

  it('should simulate a sensor failure and verify detection', () => {
    cy.simulateSensorFailure(vehicleId);
    cy.getTirePressureSystemStatus(vehicleId).should('detect.sensorFailure');
  });

  it('should check the user's mobile app for notifications', () => {
    cy.checkMobileAppForNotifications().should('contain', 'System Malfunction Alert');
  });

  it('should verify the alert message content', () => {
    cy.getMobileAppAlertMessage().should('contain', 'Sensor Failure detected. Please check the system.');
  });

  it('should check if the malfunction alert is logged in the system history', () => {
    cy.getNotificationHistory().should('contain', 'Sensor Failure Alert');
  });
});