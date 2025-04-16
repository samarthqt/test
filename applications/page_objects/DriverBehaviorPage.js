class DriverBehaviorPage {
  setupDriverMonitoringSystem() {
    cy.visit('/setup');
    cy.get('#configureSensor').click();
  }

  startVehicle() {
    cy.get('#startVehicle').click();
  }

  driveAtSpeed(speed) {
    cy.get('#setSpeed').type(speed);
    cy.get('#confirmSpeed').click();
  }

  verifyNoAlerts() {
    cy.get('#alertStatus').should('not.exist');
  }

  accelerateTo(acceleration) {
    cy.get('#setAcceleration').type(acceleration);
    cy.get('#confirmAcceleration').click();
  }

  verifyAccelerationLogged() {
    cy.get('#log').should('contain', 'Acceleration logged');
  }

  driveAtBoundarySpeedLimit(speed, duration) {
    cy.get('#setSpeedLimit').type(speed);
    cy.get('#setDuration').type(duration);
    cy.get('#confirmBoundarySpeed').click();
  }

  verifyContinuousMonitoring() {
    cy.get('#monitoringStatus').should('contain', 'Monitoring active');
  }

  decelerateAtThreshold(threshold) {
    cy.get('#setDeceleration').type(threshold);
    cy.get('#confirmDeceleration').click();
  }

  verifyDecelerationLogged() {
    cy.get('#log').should('contain', 'Deceleration logged');
  }

  testQuickAccelerationDecelerationCycles() {
    cy.get('#quickCycleTest').click();
  }

  verifyEventsLogged() {
    cy.get('#log').should('contain', 'Events logged');
  }

  verifyAlertsOnThresholdExceeded() {
    cy.get('#alertStatus').should('contain', 'Alert triggered');
  }
}