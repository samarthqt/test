describe('Transaction Limits', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const settingsPage = new SettingsPage();
  const transactionLimitsPage = new TransactionLimitsPage();

  before(() => {
    cy.visit('/login');
    loginPage.login('user789', 'pass789');
    dashboardPage.verifyDashboard();
  });

  it('should set a daily transaction limit', () => {
    dashboardPage.navigateToSettings();
    settingsPage.navigateToTransactionLimits();
    transactionLimitsPage.setDailyTransactionLimit('$500');
    transactionLimitsPage.saveTransactionLimit();
    transactionLimitsPage.verifyTransactionLimitSet();
  });

  it('should prevent transactions exceeding the limit', () => {
    transactionLimitsPage.attemptTransactionExceedingLimit();
    transactionLimitsPage.verifyTransactionLimitExceededMessage();
  });
});