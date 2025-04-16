describe('Vehicle Tracking', () => {
  const vehicleTrackingPage = new VehicleTrackingPage();

  before(() => {
    cy.visit('/tracking');
  });

  it('should display the vehicle tracking interface with a map', () => {
    vehicleTrackingPage.verifyTrackingInterface();
  });

  it('should ensure the vehicle GPS is enabled', () => {
    vehicleTrackingPage.enableGPS();
    vehicleTrackingPage.verifyGPSEnabled();
  });

  it('should check the map for the vehicle's current location', () => {
    vehicleTrackingPage.verifyCurrentLocation();
  });

  it('should update the vehicle's location on the map every minute', () => {
    vehicleTrackingPage.moveVehicle();
    vehicleTrackingPage.verifyLocationUpdate();
  });

  it('should verify the location history is accurately recorded and displayed', () => {
    vehicleTrackingPage.verifyLocationHistory();
  });
});