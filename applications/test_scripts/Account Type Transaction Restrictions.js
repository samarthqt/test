describe('Account Type Transaction Restrictions', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const accountTypePage = new AccountTypePage();
  const transactionPage = new TransactionPage();

  before(() => {
    cy.visit('/login');
  });

  it('should restrict transactions based on account type', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToAccountTypeSettings();

    accountTypePage.selectAccountType('Checking');
    accountTypePage.verifyAccountTypeSelected('Checking');

    transactionPage.initiateTransfer(5000);
    transactionPage.verifyRestrictionMessage('Transactions above $4000 are not allowed for Checking accounts');
    transactionPage.verifyTransactionNotProcessed();
  });
});