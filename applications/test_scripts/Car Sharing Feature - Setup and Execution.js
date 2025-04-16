describe('Car Sharing Feature - Setup and Execution', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const sharingPage = new SharingPage();
  const carpoolingPage = new CarpoolingPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the application', () => {
    loginPage.login('54321', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to the Sharing module', () => {
    dashboardPage.navigateToSharingModule();
    sharingPage.verifySharingInterface();
  });

  it('should select the Carpooling sub-module', () => {
    sharingPage.selectCarpoolingSubModule();
    carpoolingPage.verifyCarpoolingInterface();
  });

  it('should enter the Vehicle ID', () => {
    carpoolingPage.enterVehicleId('ABC123');
  });

  it('should set the time period for car sharing', () => {
    carpoolingPage.setTimePeriod('2 hours');
  });

  it('should enter the pickup location', () => {
    carpoolingPage.enterPickupLocation('123 Main St');
  });

  it('should click on Share Car', () => {
    carpoolingPage.clickShareCar();
    carpoolingPage.verifyShareConfirmation();
  });

  it('should verify the car sharing details in Upcoming Shares', () => {
    carpoolingPage.verifyUpcomingShares('ABC123', '2 hours', '123 Main St');
  });

  it('should notify the friend or family member', () => {
    carpoolingPage.notifyFriendOrFamily();
    carpoolingPage.verifyNotificationSent();
  });

  it('should check the sharing status after the time period ends', () => {
    carpoolingPage.verifySharingStatus('Completed');
  });

  it('should navigate back to the Carpooling interface', () => {
    carpoolingPage.navigateBackToCarpooling();
    carpoolingPage.verifyCarpoolingInterface();
  });

  it('should log out of the application', () => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});