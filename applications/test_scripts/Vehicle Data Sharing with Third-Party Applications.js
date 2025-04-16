describe('Vehicle Data Sharing with Third-Party Applications', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const vehicleDataSharingPage = new VehicleDataSharingPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in to the system', () => {
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyDashboardPage();
  });

  it('should navigate to Vehicle Data Sharing section', () => {
    dashboardPage.goToVehicleDataSharing();
    vehicleDataSharingPage.verifyPage();
  });

  it('should select the vehicle and third-party application', () => {
    vehicleDataSharingPage.selectVehicle('123ABC');
    vehicleDataSharingPage.selectThirdPartyApp('InsuranceApp');
  });

  it('should enable vehicle data sharing and confirm agreement', () => {
    vehicleDataSharingPage.enableDataSharing();
    vehicleDataSharingPage.confirmAgreement();
  });

  it('should submit the data sharing request and verify confirmation', () => {
    vehicleDataSharingPage.submitRequest();
    vehicleDataSharingPage.verifyConfirmationMessage();
  });

  it('should verify the third-party application for received data', () => {
    vehicleDataSharingPage.checkThirdPartyAppData('InsuranceApp');
  });

  after(() => {
    dashboardPage.logout();
  });
});