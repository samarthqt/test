describe('Late Payment Penalty Tracking', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const penaltiesPage = new PenaltiesPage();
  const tenantAccountPage = new TenantAccountPage();

  before(() => {
    cy.visit('https://financial-management-system.com');
  });

  it('should log in as property manager', () => {
    loginPage.loginAsPropertyManager('propertyManagerUsername', 'password');
    dashboardPage.verifyDashboard();
  });

  it('should navigate to penalties section', () => {
    dashboardPage.goToPenaltiesSection();
    penaltiesPage.verifyPenaltiesPage();
  });

  it('should select tenant account with overdue rent', () => {
    penaltiesPage.selectTenantWithOverdueRent();
    tenantAccountPage.verifyTenantAccountDetails();
  });

  it('should check current rent status and due date', () => {
    tenantAccountPage.verifyRentStatusAndDueDate();
  });

  it('should verify late payment penalty calculation', () => {
    tenantAccountPage.verifyLatePaymentPenaltyCalculation();
  });

  it('should confirm penalty is applied to tenant account', () => {
    tenantAccountPage.verifyPenaltyApplied();
  });

  it('should generate report of applied penalties', () => {
    penaltiesPage.generatePenaltiesReport();
    penaltiesPage.verifyGeneratedReport();
  });

  it('should notify tenant of penalty', () => {
    tenantAccountPage.notifyTenantOfPenalty();
  });

  after(() => {
    dashboardPage.logout();
  });
});