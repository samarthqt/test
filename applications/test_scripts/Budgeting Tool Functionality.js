describe('Budgeting Tool Functionality', () => {
  const loginPage = new LoginPage();
  const financialToolsPage = new FinancialToolsPage();
  const budgetingToolPage = new BudgetingToolPage();

  beforeEach(() => {
    cy.visit('/');
    loginPage.login('54321', 'password');
  });

  it('should allow users to set budget categories, track spending, and receive notifications', () => {
    financialToolsPage.navigateToFinancialTools();
    financialToolsPage.selectBudgetingTool();

    budgetingToolPage.createBudgetCategory('Groceries');
    budgetingToolPage.setBudgetLimit('Groceries', 300);

    budgetingToolPage.logTransaction('Groceries', 100);
    budgetingToolPage.logTransaction('Groceries', 250);

    budgetingToolPage.viewSpendingSummary('Groceries');
  });

  afterEach(() => {
    loginPage.logout();
  });
});