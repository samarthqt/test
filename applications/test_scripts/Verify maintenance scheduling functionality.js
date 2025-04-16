describe('Maintenance Scheduling Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const schedulingPage = new SchedulingPage();
  const scheduledMaintenancePage = new ScheduledMaintenancePage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in and schedule maintenance', () => {
    loginPage.login('U987654', 'password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToScheduling();
    schedulingPage.verifySchedulingPage();
    schedulingPage.selectVehicle('V123456');
    schedulingPage.selectMaintenanceType('Oil Change');
    schedulingPage.selectDateTime('2023-10-15', '10:00 AM');
    schedulingPage.submitSchedule();
    schedulingPage.verifyConfirmationMessage();
    cy.checkEmailForConfirmation();
    dashboardPage.navigateToScheduledMaintenance();
    scheduledMaintenancePage.verifyScheduledMaintenance('V123456', '2023-10-15', '10:00 AM', 'Oil Change');
  });

  it('should prevent scheduling at the same time', () => {
    dashboardPage.navigateToScheduling();
    schedulingPage.selectVehicle('V123456');
    schedulingPage.selectMaintenanceType('Oil Change');
    schedulingPage.selectDateTime('2023-10-15', '10:00 AM');
    schedulingPage.submitSchedule();
    schedulingPage.verifyConflictErrorMessage();
  });

  it('should show error when no vehicle is selected', () => {
    dashboardPage.navigateToScheduling();
    schedulingPage.selectMaintenanceType('Oil Change');
    schedulingPage.selectDateTime('2023-10-15', '10:00 AM');
    schedulingPage.submitSchedule();
    schedulingPage.verifyVehicleSelectionError();
  });

  it('should show error when scheduling for past date', () => {
    dashboardPage.navigateToScheduling();
    schedulingPage.selectVehicle('V123456');
    schedulingPage.selectMaintenanceType('Oil Change');
    schedulingPage.selectDateTime('2022-10-15', '10:00 AM');
    schedulingPage.submitSchedule();
    schedulingPage.verifyDateErrorMessage();
  });

  it('should prevent scheduling non-existent maintenance type', () => {
    dashboardPage.navigateToScheduling();
    schedulingPage.selectVehicle('V123456');
    schedulingPage.selectMaintenanceType('Non-Existent Type');
    schedulingPage.submitSchedule();
    schedulingPage.verifyMaintenanceTypeError();
  });

  it('should allow editing scheduled maintenance', () => {
    dashboardPage.navigateToScheduledMaintenance();
    scheduledMaintenancePage.editScheduledMaintenance('V123456', '2023-10-16', '11:00 AM', 'Tire Rotation');
    scheduledMaintenancePage.verifyScheduledMaintenance('V123456', '2023-10-16', '11:00 AM', 'Tire Rotation');
  });
});