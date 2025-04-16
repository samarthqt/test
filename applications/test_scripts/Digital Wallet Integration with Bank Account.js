describe('Digital Wallet Integration with Bank Account', () => {
  const bankAccountNumber = '123456789';
  const digitalWallet = 'Google Pay';

  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUser', 'validPassword');
  });

  it('should link bank account to Google Pay', () => {
    cy.get('#paymentsModule').click();
    cy.get('#digitalWalletsSection').click();
    cy.get('#linkNewWalletButton').click();
    cy.get('#walletOptions').select(digitalWallet);
    cy.get('#bankAccountNumberInput').type(bankAccountNumber);
    cy.get('#confirmAccountDetailsButton').click();
    cy.authenticateTwoFactor();
    cy.get('#submitLinkRequestButton').click();
    cy.get('#confirmationMessage').should('contain', 'successfully linked');
  });

  it('should verify bank account in Google Pay', () => {
    cy.verifyLinkedAccountInGooglePay(bankAccountNumber);
  });

  it('should perform a test transaction using Google Pay', () => {
    cy.performTestTransaction(digitalWallet, bankAccountNumber);
    cy.verifyTransactionInBankStatement();
  });

  it('should unlink bank account from Google Pay', () => {
    cy.unlinkBankAccountFromGooglePay(bankAccountNumber);
    cy.verifyAccountUnlinkedInGooglePay(bankAccountNumber);
  });

  afterEach(() => {
    cy.logout();
  });
});