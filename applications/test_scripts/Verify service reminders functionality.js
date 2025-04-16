describe('Service Reminders Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const serviceAlertsPage = new ServiceAlertsPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    loginPage.login('U987654', 'validPassword');
    dashboardPage.verifyRedirection();
  });

  it('should navigate to Service Alerts sub-module', () => {
    dashboardPage.goToServiceAlerts();
    serviceAlertsPage.verifyServiceAlertsDisplay();
  });

  it('should set a service reminder for Tire Rotation', () => {
    serviceAlertsPage.selectVehicle('V123456');
    serviceAlertsPage.setServiceReminder('Tire Rotation', '2023-11-01');
    serviceAlertsPage.submitReminder();
    serviceAlertsPage.verifyConfirmationMessage();
  });

  it('should receive a confirmation email', () => {
    serviceAlertsPage.checkEmailForConfirmation();
  });

  it('should send reminder notification on due date', () => {
    serviceAlertsPage.simulateReminderDate('2023-11-01');
    serviceAlertsPage.verifyReminderNotification();
  });

  it('should not set a reminder without selecting a vehicle', () => {
    serviceAlertsPage.attemptSetReminderWithoutVehicle();
    serviceAlertsPage.verifyVehicleSelectionError();
  });

  it('should prevent setting reminders for non-existent maintenance types', () => {
    serviceAlertsPage.attemptSetInvalidMaintenanceType();
    serviceAlertsPage.verifyInvalidMaintenanceTypeError();
  });

  it('should not set a reminder for a past date', () => {
    serviceAlertsPage.attemptSetPastDateReminder();
    serviceAlertsPage.verifyPastDateError();
  });

  it('should allow editing reminder details', () => {
    serviceAlertsPage.editReminderDetails();
    serviceAlertsPage.verifyEditSuccess();
  });

  it('should allow deleting a reminder', () => {
    serviceAlertsPage.deleteReminder();
    serviceAlertsPage.verifyDeleteSuccess();
  });

  it('should prevent access with invalid credentials', () => {
    loginPage.login('InvalidUser', 'InvalidPassword');
    loginPage.verifyInvalidCredentialsError();
  });
});