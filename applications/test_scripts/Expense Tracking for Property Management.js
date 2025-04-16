describe('Expense Tracking for Property Management', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const expensesPage = new ExpensesPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as landlord', () => {
    loginPage.login('landlord_username', 'landlord_password');
    dashboardPage.verifyDashboardIsDisplayed();
  });

  it('should navigate to the Expenses section', () => {
    dashboardPage.goToExpensesSection();
    expensesPage.verifyExpensesInterfaceIsDisplayed();
  });

  it('should enter expense details', () => {
    expensesPage.enterExpenseDetails('Repair', 200, 'Plumbing repair');
    expensesPage.verifyExpenseDetailsEntered();
  });

  it('should submit the expense entry', () => {
    expensesPage.submitExpense();
    expensesPage.verifyExpenseSubmission();
  });

  it('should log out', () => {
    dashboardPage.logout();
    loginPage.verifyLoggedOut();
  });
});