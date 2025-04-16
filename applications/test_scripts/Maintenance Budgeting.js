describe('Maintenance Budgeting', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const maintenanceBudgetingPage = new MaintenanceBudgetingPage();

  beforeEach(() => {
    cy.visit('/login');
    loginPage.loginAsPropertyManager();
  });

  it('should set and track maintenance budgets for properties', () => {
    dashboardPage.navigateToMaintenanceBudgeting();
    maintenanceBudgetingPage.verifyPageLoaded();
    maintenanceBudgetingPage.selectPropertyById('PROP456');
    maintenanceBudgetingPage.setBudgetAmount('$5000');
    maintenanceBudgetingPage.addExpense('Plumbing Repair', '$1500');
    maintenanceBudgetingPage.verifyTotalExpenses('$1500');
    maintenanceBudgetingPage.generateBudgetReport('PROP456');
  });
});