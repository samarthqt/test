describe('Mobile Banking App - Core Services', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const transfersPage = new TransfersPage();

  before(() => {
    cy.visit('mobile-banking-app-url');
  });

  it('should allow user to login and make a transfer', () => {
    loginPage.enterUserId('user123');
    loginPage.enterPassword('pass123');
    loginPage.clickLoginButton();

    dashboardPage.navigateToTransfers();

    transfersPage.selectTransactionType('Transfer');
    transfersPage.enterAmount('$100');
    transfersPage.enterRecipientAccount('987654321');
    transfersPage.clickSubmitButton();

    transfersPage.verifyTransferSuccess();
    transfersPage.verifyTransactionInHistory('$100', '987654321');
  });
});