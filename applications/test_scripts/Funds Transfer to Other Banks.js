describe('Funds Transfer to Other Banks', () => {
  const loginPage = new LoginPage();
  const fundsTransferPage = new FundsTransferPage();
  const transactionHistoryPage = new TransactionHistoryPage();

  before(() => {
    cy.visit('https://onlinebankingplatform.com');
  });

  it('should login to the online banking platform', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Funds Transfer section', () => {
    fundsTransferPage.navigateToFundsTransfer();
    cy.url().should('include', '/funds-transfer');
  });

  it('should select Transfer to Other Banks option', () => {
    fundsTransferPage.selectTransferToOtherBanks();
    fundsTransferPage.verifyOtherBanksOptionsDisplayed();
  });

  it('should enter recipient bank details and transfer amount', () => {
    fundsTransferPage.enterRecipientBankDetails('XYZ Bank', '9876543210');
    fundsTransferPage.enterTransferAmount('500');
    fundsTransferPage.selectTransferDate('today');
  });

  it('should review and confirm the transfer details', () => {
    fundsTransferPage.reviewAndConfirmDetails();
  });

  it('should submit the transfer request', () => {
    fundsTransferPage.submitTransfer();
    fundsTransferPage.verifyConfirmationMessage();
  });

  it('should check transaction status in transaction history', () => {
    transactionHistoryPage.navigateToTransactionHistory();
    transactionHistoryPage.verifyTransactionCompleted();
  });

  it('should verify transferred amount is deducted from user account', () => {
    transactionHistoryPage.verifyAmountDeducted('500');
  });

  it('should verify recipient receives the funds', () => {
    transactionHistoryPage.verifyRecipientReceipt();
  });
});