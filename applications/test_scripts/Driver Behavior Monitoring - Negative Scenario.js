describe('Driver Behavior Monitoring - Negative Scenario', () => {
  const driverBehaviorPage = new DriverBehaviorPage();

  beforeEach(() => {
    cy.visit('/driver-behavior-monitoring');
  });

  it('should trigger alert for speeding and log the event', () => {
    driverBehaviorPage.startVehicle();
    driverBehaviorPage.accelerateTo(70);
    driverBehaviorPage.verifySpeedingAlert();
    driverBehaviorPage.verifyEventLogged('Speeding');
  });

  it('should trigger alert for harsh braking and log the event', () => {
    driverBehaviorPage.decelerateTo(30);
    driverBehaviorPage.verifyHarshBrakingAlert();
    driverBehaviorPage.verifyEventLogged('Harsh Braking');
  });

  it('should continuously alert for speeding and log the duration', () => {
    driverBehaviorPage.driveAtSpeed(65, 10);
    driverBehaviorPage.verifyContinuousSpeedingAlert();
    driverBehaviorPage.verifyDurationLogged(10);
  });

  it('should prevent acceleration beyond 80 mph and alert the driver', () => {
    driverBehaviorPage.attemptToAccelerateBeyond(80);
    driverBehaviorPage.verifyAccelerationPrevented();
    driverBehaviorPage.verifyDriverAlerted();
  });

  it('should log harsh stop and alert the driver', () => {
    driverBehaviorPage.stopVehicleAbruptly();
    driverBehaviorPage.verifyHarshStopLogged();
    driverBehaviorPage.verifyDriverAlerted();
  });
});