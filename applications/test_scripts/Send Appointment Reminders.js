describe('Send Appointment Reminders', () => {
  const appointmentPage = new AppointmentPage();
  const settingsPage = new SettingsPage();
  const loginPage = new LoginPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('user', 'password');
  });

  it('Verify scheduled appointment details for the patient', () => {
    appointmentPage.navigateToAppointments();
    appointmentPage.verifyAppointmentDetails('P12345', '2023-10-20');
  });

  it("Ensure 'Appointment Reminders' module is active", () => {
    settingsPage.navigateToModules();
    settingsPage.verifyModuleStatus('Appointment Reminders', 'active');
  });

  it('Check system settings for reminder configuration', () => {
    settingsPage.navigateToReminderSettings();
    settingsPage.verifyReminderConfiguration('24 hours', 'SMS');
  });

  it('Trigger reminder process manually', () => {
    settingsPage.triggerReminderProcess();
    cy.contains('Reminder is triggered and sent successfully').should('be.visible');
  });

  it('Patient receives SMS reminder', () => {
    cy.verifySMSReceived('P12345', '2023-10-20');
  });

  it('Verify reminder logs in the system', () => {
    settingsPage.navigateToLogs();
    settingsPage.verifyLogs('P12345', 'SMS', 'success');
  });

  after(() => {
    loginPage.logout();
  });
});