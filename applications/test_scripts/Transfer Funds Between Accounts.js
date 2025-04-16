describe('Transfer Funds Between Accounts', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const fundsTransferPage = new FundsTransferPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in and redirect to the dashboard', () => {
    loginPage.login('user', 'password');
    dashboardPage.verifyDashboardPage();
  });

  it('should navigate to the Funds Transfer section', () => {
    dashboardPage.navigateToFundsTransfer();
    fundsTransferPage.verifyFundsTransferPage();
  });

  it('should transfer funds between accounts', () => {
    fundsTransferPage.selectFromAccount('401');
    fundsTransferPage.selectToAccount('402');
    fundsTransferPage.enterTransferAmount('100');
    fundsTransferPage.clickTransferButton();
    fundsTransferPage.verifyTransferSuccess();
  });

  it('should verify the funds deduction from checking account', () => {
    fundsTransferPage.verifyCheckingAccountBalance('-100');
  });

  it('should verify the funds addition to savings account', () => {
    fundsTransferPage.verifySavingsAccountBalance('+100');
  });
});