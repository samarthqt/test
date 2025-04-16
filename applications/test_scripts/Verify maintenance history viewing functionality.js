describe('Maintenance History Viewing Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const maintenancePage = new MaintenancePage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials and redirect to dashboard', () => {
    loginPage.login('U987654', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to history sub-module and display maintenance history', () => {
    loginPage.login('U987654', 'validPassword');
    dashboardPage.navigateToMaintenanceHistory();
    maintenancePage.verifyHistorySubModuleDisplayed();
    maintenancePage.selectVehicle('V123456');
    maintenancePage.verifyMaintenanceHistoryDisplayed();
  });

  it('should verify maintenance records include dates and services', () => {
    maintenancePage.verifyMaintenanceRecordsIncludeDatesAndServices();
  });

  it('should check all completed maintenance activities are listed', () => {
    maintenancePage.verifyAllCompletedActivitiesListed();
  });

  it('should filter maintenance history by date range', () => {
    maintenancePage.filterHistoryByDateRange('2023-01-01', '2023-12-31');
    maintenancePage.verifyHistoryFilteredByDateRange();
  });

  it('should sort maintenance records by date in descending order', () => {
    maintenancePage.sortHistoryByDateDescending();
    maintenancePage.verifyRecordsSortedByDateDescending();
  });

  it('should display error when viewing history without selecting vehicle', () => {
    maintenancePage.attemptToViewHistoryWithoutVehicle();
    maintenancePage.verifyErrorForNoVehicleSelection();
  });

  it('should export maintenance history as a report', () => {
    maintenancePage.exportHistoryAsReport();
    maintenancePage.verifyReportExportedSuccessfully();
  });

  it('should allow adding notes to maintenance records', () => {
    maintenancePage.addNotesToRecord('Routine check-up completed');
    maintenancePage.verifyNotesAddedSuccessfully();
  });

  it('should display message for no records when viewing empty history', () => {
    maintenancePage.selectVehicle('V000000');
    maintenancePage.verifyNoRecordsMessageDisplayed();
  });

  it('should view detailed information for each maintenance record', () => {
    maintenancePage.viewDetailedInformation();
    maintenancePage.verifyDetailedInformationDisplayed();
  });

  it('should prevent deletion of maintenance records', () => {
    maintenancePage.attemptToDeleteRecord();
    maintenancePage.verifyDeletionNotAllowed();
  });

  it('should print the maintenance history', () => {
    maintenancePage.printHistory();
    maintenancePage.verifyHistoryPrintedSuccessfully();
  });

  it('should prevent access with invalid credentials', () => {
    loginPage.login('U987654', 'invalidPassword');
    loginPage.verifyInvalidCredentialsMessage();
  });
});