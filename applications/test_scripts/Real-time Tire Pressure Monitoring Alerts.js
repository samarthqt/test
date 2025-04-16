describe('Real-time Tire Pressure Monitoring Alerts', () => {
  const vehicleID = 'V12345';
  const tirePressureThreshold = 30;
  const currentTirePressure = 28;

  before(() => {
    cy.visit('/vehicle/' + vehicleID);
    cy.activateTirePressureMonitoring();
  });

  it('should detect a drop in tire pressure below the threshold', () => {
    cy.simulateTirePressureDrop(currentTirePressure);
    cy.verifyTirePressureDropDetected(currentTirePressure);
  });

  it('should receive a real-time alert notification on the mobile app', () => {
    cy.checkMobileAppForNotification().should('contain', 'Low tire pressure detected');
  });

  it('should verify the alert message content', () => {
    cy.getNotificationContent().should('contain', 'Front left tire is below recommended pressure. Please inflate to at least ' + tirePressureThreshold + ' PSI.');
  });

  it('should log the alert in the system history', () => {
    cy.checkNotificationHistory().should('contain', 'Low tire pressure alert logged for vehicle ' + vehicleID);
  });
});