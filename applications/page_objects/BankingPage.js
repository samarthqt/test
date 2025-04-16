class BankingPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  navigateToDigitalWallets() {
    cy.get('#paymentsModule').click();
    cy.get('#digitalWalletsSection').click();
  }

  linkNewWallet(wallet, accountNumber) {
    cy.get('#linkNewWalletButton').click();
    cy.get('#walletOptions').select(wallet);
    cy.get('#bankAccountNumberInput').type(accountNumber);
    cy.get('#confirmAccountDetailsButton').click();
  }

  authenticateTwoFactor() {
    cy.get('#twoFactorAuthInput').type('123456');
    cy.get('#verifyButton').click();
  }

  submitLinkRequest() {
    cy.get('#submitLinkRequestButton').click();
  }

  verifyConfirmationMessage() {
    cy.get('#confirmationMessage').should('contain', 'successfully linked');
  }

  logout() {
    cy.get('#logoutButton').click();
  }
}

class GooglePayPage {
  verifyLinkedAccount(accountNumber) {
    cy.get('#linkedAccounts').should('contain', accountNumber);
  }

  performTestTransaction(wallet, accountNumber) {
    cy.get(`#${wallet}PayButton`).click();
    cy.get('#transactionAccountNumber').should('contain', accountNumber);
    cy.get('#completeTransactionButton').click();
  }

  verifyTransactionInBankStatement() {
    cy.get('#bankStatement').should('contain', 'Test Transaction');
  }

  unlinkBankAccount(accountNumber) {
    cy.get('#linkedAccounts').contains(accountNumber).parent().find('#unlinkButton').click();
  }

  verifyAccountUnlinked(accountNumber) {
    cy.get('#linkedAccounts').should('not.contain', accountNumber);
  }
}

export { BankingPage, GooglePayPage };