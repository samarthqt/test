describe('TC-694 102 Schedule Medical Appointment with Invalid Date', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const appointmentManagementPage = new AppointmentManagementPage();
  const schedulingPage = new SchedulingPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should not allow scheduling an appointment with an invalid date', () => {
    // Step 1: Log in to the application using valid patient credentials
    loginPage.login('P12345', 'validPassword');
    dashboardPage.verifyDashboard();

    // Step 2: Navigate to the 'Appointment Management' section
    dashboardPage.goToAppointmentManagement();
    appointmentManagementPage.verifyPage();

    // Step 3: Select 'Scheduling' from the available options
    appointmentManagementPage.selectScheduling();
    schedulingPage.verifySchedulingInterface();

    // Step 4: Choose 'Doctor ID' and enter an invalid 'Appointment Date'
    schedulingPage.enterDoctorId('D001');
    schedulingPage.enterAppointmentDate('invalidDate');
    schedulingPage.selectTimeSlot('10:00 AM - 11:00 AM');

    // Step 5: Attempt to submit the appointment with invalid date
    schedulingPage.submitAppointment();
    schedulingPage.verifyInvalidDateError();

    // Step 6: Log out from the application
    dashboardPage.logout();
  });
});