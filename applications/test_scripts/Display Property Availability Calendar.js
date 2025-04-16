describe('Display Property Availability Calendar', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const propertyManagementPage = new PropertyManagementPage();
  const availabilityPage = new AvailabilityPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.loginAsPropertyManager();
  });

  it('should display real-time property availability calendar', () => {
    dashboardPage.navigateToPropertyManagement();
    propertyManagementPage.accessAvailabilitySection();
    availabilityPage.viewCalendarForProperty('67890');

    // Verify calendar displays availability
    availabilityPage.verifyCalendarDisplaysAvailability('67890');

    // Verify real-time updates
    availabilityPage.modifyLeaseDates('01/03/2024', '01/03/2025');
    availabilityPage.verifyCalendarUpdatesInRealTime();

    // Check visual representation
    availabilityPage.checkVisualRepresentation();
  });

  afterEach(() => {
    dashboardPage.logout();
  });
});