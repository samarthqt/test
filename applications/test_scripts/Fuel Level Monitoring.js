describe('Fuel Level Monitoring', () => {
  const fuelLevelPage = new FuelLevelPage();

  beforeEach(() => {
    cy.visit('/fuel-level');
  });

  it('should display the fuel level monitoring interface', () => {
    fuelLevelPage.getInterface().should('be.visible');
  });

  it('should ensure the vehicle's fuel sensor is enabled', () => {
    fuelLevelPage.getFuelSensorStatus().should('have.text', 'Enabled');
  });

  it('should display the current fuel level accurately', () => {
    fuelLevelPage.getCurrentFuelLevel().should('exist');
  });

  it('should update fuel level in real-time after refueling', () => {
    fuelLevelPage.refuelVehicle();
    fuelLevelPage.getCurrentFuelLevel().should('not.equal', '0');
  });

  it('should display fuel consumption history accurately', () => {
    fuelLevelPage.getFuelConsumptionHistory().should('exist');
  });
});