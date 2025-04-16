describe('Funds Transfer to Other Banks with Minimum Transfer Amount', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const fundsTransferPage = new FundsTransferPage();
  const transactionHistoryPage = new TransactionHistoryPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the online banking platform', () => {
    loginPage.enterCredentials('username', 'password');
    loginPage.submit();
    dashboardPage.verifyLoginSuccess();
  });

  it('should navigate to the Funds Transfer section', () => {
    dashboardPage.goToFundsTransfer();
    fundsTransferPage.verifyOnFundsTransferPage();
  });

  it('should select Transfer to Other Banks option', () => {
    fundsTransferPage.selectTransferToOtherBanks();
    fundsTransferPage.verifyOtherBanksOptionDisplayed();
  });

  it('should enter recipient bank details and minimum transfer amount', () => {
    fundsTransferPage.enterRecipientDetails('XYZ Bank', '9876543210');
    fundsTransferPage.enterTransferAmount('1');
  });

  it('should review and confirm the transfer', () => {
    fundsTransferPage.reviewTransferDetails();
    fundsTransferPage.confirmTransfer();
  });

  it('should submit the transfer request and verify confirmation', () => {
    fundsTransferPage.submitTransfer();
    fundsTransferPage.verifyTransferConfirmation();
  });

  it('should check transaction status in transaction history', () => {
    dashboardPage.goToTransactionHistory();
    transactionHistoryPage.verifyTransactionCompleted('9876543210', '1');
  });

  it('should verify transferred amount is deducted', () => {
    dashboardPage.verifyBalanceDeduction('1');
  });

  it('should verify recipient receives the funds', () => {
    // Assuming there's a way to check recipient's account
    fundsTransferPage.verifyRecipientReceivedFunds('9876543210', '1');
  });
});