describe('Funds Transfer to Invalid Bank Account', () => {
  const loginPage = new LoginPage();
  const fundsTransferPage = new FundsTransferPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log into the online banking platform', () => {
    loginPage.enterCredentials('username', 'password');
    loginPage.submit();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to the Funds Transfer section', () => {
    fundsTransferPage.navigateToFundsTransfer();
    cy.url().should('include', '/funds-transfer');
  });

  it('should select Transfer to Other Banks option', () => {
    fundsTransferPage.selectTransferToOtherBanks();
    fundsTransferPage.verifyTransferOptionsDisplayed();
  });

  it('should enter recipient bank details with invalid account number', () => {
    fundsTransferPage.enterRecipientDetails('XYZ Bank', '0000000000');
    fundsTransferPage.enterTransferAmount('500');
    fundsTransferPage.selectTransferDateAsToday();
  });

  it('should review and confirm the transfer', () => {
    fundsTransferPage.reviewDetails();
    fundsTransferPage.confirmTransfer();
  });

  it('should submit the transfer request and verify error message', () => {
    fundsTransferPage.submitTransfer();
    fundsTransferPage.verifyErrorMessage('Invalid account number');
  });

  it('should check transaction history and verify account balance', () => {
    fundsTransferPage.verifyTransactionNotRecorded();
    fundsTransferPage.verifyAccountBalanceUnchanged();
  });
});