describe('Boundary Test for Budget Amount', () => {
  const budgetManagementPage = new BudgetManagementPage();

  beforeEach(() => {
    cy.login();
    budgetManagementPage.navigateToBudgetManagement();
  });

  it('should display error for zero budget amount', () => {
    budgetManagementPage.createNewBudget();
    budgetManagementPage.enterBudgetName('Asset Purchase Boundary Test');
    budgetManagementPage.enterBudgetAmount('$0');
    budgetManagementPage.saveBudget();
    budgetManagementPage.verifyErrorMessage('Budget amount cannot be zero');
  });

  it('should save budget with minimum amount', () => {
    budgetManagementPage.enterBudgetAmount('$1');
    budgetManagementPage.saveBudget();
    budgetManagementPage.verifyBudgetSaved('$1');
  });

  it('should save budget with maximum amount', () => {
    budgetManagementPage.enterBudgetAmount('$999,999,999');
    budgetManagementPage.saveBudget();
    budgetManagementPage.verifyBudgetSaved('$999,999,999');
  });
});