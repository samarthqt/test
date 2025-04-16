describe('Schedule Financial Advising Appointment', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const financialToolsPage = new FinancialToolsPage();
  const scheduleAppointmentPage = new ScheduleAppointmentPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should not allow scheduling an appointment without selecting a financial advisor', () => {
    loginPage.login('12345', 'password123');
    dashboardPage.navigateToFinancialTools();
    financialToolsPage.selectFinancialAdvisory();
    scheduleAppointmentPage.clickScheduleAppointment();
    scheduleAppointmentPage.enterAppointmentDate('2023-10-15');
    scheduleAppointmentPage.submitAppointment();
    scheduleAppointmentPage.verifyAdvisorSelectionError();
  });

  afterEach(() => {
    dashboardPage.logout();
  });
});