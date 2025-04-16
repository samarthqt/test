describe('Budget Exceedance Alert for Asset Purchases', () => {
  const budgetManagementPage = new BudgetManagementPage();

  beforeEach(() => {
    cy.visit('/budget-management');
  });

  it('should alert when actual spending exceeds the budget', () => {
    budgetManagementPage.navigateToBudgetManagement();
    budgetManagementPage.selectBudget('Asset Purchase 2023');
    budgetManagementPage.enterActualSpending('105000');
    budgetManagementPage.updateSpending();
    budgetManagementPage.verifyAlert();
    budgetManagementPage.checkBudgetStatus();
  });
});