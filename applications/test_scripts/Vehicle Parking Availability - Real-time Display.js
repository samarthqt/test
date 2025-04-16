describe('Vehicle Parking Availability - Real-time Display', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const parkingPage = new ParkingPage();
  const bookingsPage = new BookingsPage();

  before(() => {
    cy.visit('/');
  });

  it('Log into the application', () => {
    loginPage.login('user67890', 'password');
    dashboardPage.verifyDashboard();
  });

  it('Ensure location services are enabled', () => {
    dashboardPage.enableLocationServices();
    dashboardPage.verifyLocationEnabled('456 Elm St');
  });

  it('Navigate to Parking module', () => {
    dashboardPage.navigateToParkingModule();
    parkingPage.verifyParkingModuleInterface();
  });

  it('Verify location detection', () => {
    parkingPage.verifyCurrentLocation('456 Elm St');
  });

  it('Check real-time display of parking spots', () => {
    parkingPage.verifyAvailableParkingSpots();
  });

  it('Select a parking spot to view details', () => {
    parkingPage.selectParkingSpot();
    parkingPage.verifyParkingSpotDetails();
  });

  it('Sort parking spots by price', () => {
    parkingPage.sortParkingSpotsByPrice();
    parkingPage.verifySortedParkingSpots();
  });

  it('Check full parking spots', () => {
    parkingPage.verifyFullParkingSpots();
  });

  it('Book a parking spot', () => {
    parkingPage.bookParkingSpot();
    parkingPage.verifyBookingConfirmation();
  });

  it('Verify booking details', () => {
    bookingsPage.verifyBookingDetails();
  });

  it('Navigate back to Parking module', () => {
    bookingsPage.navigateToParkingModule();
    parkingPage.verifyParkingModuleInterface();
  });

  it('Log out of the application', () => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});