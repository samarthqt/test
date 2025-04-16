describe('Inspection Scheduling', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const inspectionPage = new InspectionPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.loginAsPropertyManager();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should schedule an inspection with tenant', () => {
    dashboardPage.navigateToInspectionScheduling();
    inspectionPage.verifyInspectionSchedulingPageDisplayed();
    inspectionPage.selectProperty('PROP789');
    inspectionPage.enterTenantName('John Doe');
    inspectionPage.setInspectionDate('2023-12-01');
    inspectionPage.setInspectionTime('10:00 AM');
    inspectionPage.sendInspectionNotification();
    inspectionPage.verifyInspectionAddedToCalendar('2023-12-01');
  });
});