describe('Boundary Test for Tire Pressure Monitoring', () => {
  const vehicleId = 'V12345';
  const tirePressureThreshold = 30;

  before(() => {
    cy.startVehicle(vehicleId);
    cy.ensureTirePressureMonitoringSystemIsActive();
  });

  it('should not alert at 30 PSI', () => {
    cy.setTirePressure(30);
    cy.verifyTirePressure(30);
    cy.checkMobileAppNotifications().should('not.contain', 'low tire pressure');
  });

  it('should not alert at 31 PSI', () => {
    cy.setTirePressure(31);
    cy.verifyTirePressure(31);
    cy.checkMobileAppNotifications().should('not.contain', 'low tire pressure');
  });

  it('should alert at 29 PSI', () => {
    cy.setTirePressure(29);
    cy.verifyTirePressure(29);
    cy.checkMobileAppNotifications().should('contain', 'low tire pressure');
  });
});