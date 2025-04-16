describe('Maintenance Cost Calculator', () => {
  const maintenancePage = new MaintenancePage();

  beforeEach(() => {
    cy.login();
    maintenancePage.navigate();
  });

  it('should calculate maintenance cost based on vehicle details', () => {
    maintenancePage.enterVehicleMake('Toyota');
    maintenancePage.enterVehicleModel('Camry');
    maintenancePage.enterVehicleYear('2018');
    maintenancePage.enterMileage('30000');
    maintenancePage.selectServiceType('Oil Change');
    maintenancePage.calculateCost();
    maintenancePage.verifyCalculatedCost();
    maintenancePage.checkForErrors();
  });

  afterEach(() => {
    cy.logout();
  });
});