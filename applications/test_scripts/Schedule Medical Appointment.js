describe('Schedule Medical Appointment', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const appointmentPage = new AppointmentPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in with valid credentials', () => {
    loginPage.enterUsername('P12345');
    loginPage.enterPassword('password');
    loginPage.clickLogin();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Appointment Management', () => {
    dashboardPage.navigateToAppointmentManagement();
    appointmentPage.verifyAppointmentManagementSection();
  });

  it('should select Scheduling option', () => {
    appointmentPage.selectSchedulingOption();
    appointmentPage.verifySchedulingInterface();
  });

  it('should choose Doctor ID and Appointment Date', () => {
    appointmentPage.chooseDoctorAndDate('D001', '2023-10-20');
    appointmentPage.verifyDoctorAndDateSelection();
  });

  it('should select Time Slot', () => {
    appointmentPage.selectTimeSlot('10:00 AM - 11:00 AM');
    appointmentPage.verifyTimeSlotSelection();
  });

  it('should submit the appointment', () => {
    appointmentPage.submitAppointment();
    appointmentPage.verifyAppointmentConfirmation();
  });

  it('should receive SMS confirmation', () => {
    appointmentPage.verifySMSConfirmation();
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});