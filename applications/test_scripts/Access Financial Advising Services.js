describe('Access Financial Advising Services', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const financialToolsPage = new FinancialToolsPage();
  const advisoryPage = new AdvisoryPage();
  const emailUtils = new EmailUtils();

  before(() => {
    cy.visit('/login');
  });

  it('should log in with valid credentials', () => {
    loginPage.enterUserId('12345');
    loginPage.enterPassword('password');
    loginPage.clickLogin();
    dashboardPage.verifyDashboard();
  });

  it('should navigate to Financial Tools section', () => {
    dashboardPage.navigateToFinancialTools();
    financialToolsPage.verifyFinancialToolsSection();
  });

  it('should select Financial Advisory service', () => {
    financialToolsPage.selectFinancialAdvisory();
    advisoryPage.verifyAdvisoryServicesDisplayed();
  });

  it('should schedule an appointment', () => {
    advisoryPage.clickScheduleAppointment();
    advisoryPage.enterAppointmentDate('2023-10-15');
    advisoryPage.selectFinancialAdvisor('FA001');
    advisoryPage.selectPreferredContactMethod('Email');
    advisoryPage.clickSubmit();
    advisoryPage.verifyAppointmentConfirmation();
  });

  it('should receive appointment confirmation email', () => {
    emailUtils.checkEmailForConfirmation('Email');
  });

  after(() => {
    dashboardPage.logout();
  });
});