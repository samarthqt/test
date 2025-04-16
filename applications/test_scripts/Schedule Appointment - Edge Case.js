describe('Schedule Appointment - Edge Case', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const appointmentPage = new AppointmentPage();

  before(() => {
    cy.visit('https://example.com');
  });

  it('should log in with valid credentials', () => {
    loginPage.login('P12345', 'validPassword');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Appointment Management section', () => {
    dashboardPage.goToAppointmentManagement();
    appointmentPage.verifyAppointmentManagementPage();
  });

  it('should display error for non-working hours', () => {
    appointmentPage.selectScheduling();
    appointmentPage.selectDoctor('D001');
    appointmentPage.selectDate('2023-10-20');
    appointmentPage.selectTimeSlot('2:00 AM - 3:00 AM');
    appointmentPage.submitAppointment();
    appointmentPage.verifyErrorMessage('Non-working hours');
  });

  after(() => {
    dashboardPage.logout();
  });
});