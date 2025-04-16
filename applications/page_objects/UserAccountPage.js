class UserAccountPage {
  login(accountId) {
    cy.get('#account-id').type(accountId);
    cy.get('#login-button').click();
  }

  verifyDashboardDisplayed() {
    cy.get('#dashboard').should('be.visible');
  }

  verifyCurrentBalance(expectedBalance) {
    cy.get('#balance').should('contain', expectedBalance);
  }

  performTransaction(amount) {
    cy.get('#transaction-amount').type(amount);
    cy.get('#submit-transaction').click();
  }

  verifyBalanceAbove(threshold) {
    cy.get('#balance').invoke('text').then((balance) => {
      expect(parseFloat(balance)).to.be.greaterThan(parseFloat(threshold));
    });
  }

  verifyNoLowBalanceFeeNotification() {
    cy.get('#notifications').should('not.contain', 'Low Balance Fee');
  }

  verifyBalancePostTransaction(expectedBalance) {
    cy.get('#balance').should('contain', expectedBalance);
  }

  logout() {
    cy.get('#logout-button').click();
  }

  verifyLogoutSuccessful() {
    cy.get('#login-page').should('be.visible');
  }
}