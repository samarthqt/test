describe('Funds Transfer to Other Banks with Insufficient Funds', () => {
  const loginPage = new LoginPage();
  const fundsTransferPage = new FundsTransferPage();

  before(() => {
    cy.visit('https://onlinebankingplatform.com');
  });

  it('should not allow transfer if funds are insufficient', () => {
    loginPage.login('validUsername', 'validPassword');

    cy.url().should('include', '/dashboard');

    fundsTransferPage.navigateToFundsTransfer();

    cy.url().should('include', '/funds-transfer');

    fundsTransferPage.selectTransferToOtherBanks();

    fundsTransferPage.enterRecipientDetails('XYZ Bank', '9876543210');

    fundsTransferPage.enterTransferAmount('1000');

    fundsTransferPage.confirmTransferDetails();

    fundsTransferPage.submitTransfer();

    cy.get('.error-message').should('contain', 'Insufficient funds');

    fundsTransferPage.verifyTransactionNotRecorded();

    fundsTransferPage.verifyAccountBalanceUnchanged();
  });
});