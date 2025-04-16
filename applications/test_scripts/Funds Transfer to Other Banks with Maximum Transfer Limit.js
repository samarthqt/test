describe('Funds Transfer to Other Banks with Maximum Transfer Limit', () => {
  const accountNumber = '1234567890';
  const recipientBank = 'XYZ Bank';
  const recipientAccountNumber = '9876543210';
  const transferAmount = 10000;

  before(() => {
    cy.visit('/login');
    cy.login(accountNumber, 'validPassword');
  });

  it('should navigate to the Funds Transfer section', () => {
    cy.get('.funds-transfer-link').click();
    cy.url().should('include', '/funds-transfer');
  });

  it('should select Transfer to Other Banks option', () => {
    cy.get('.transfer-other-banks-option').click();
    cy.get('.recipient-bank-input').should('be.visible');
  });

  it('should enter recipient bank details and transfer amount', () => {
    cy.get('.recipient-bank-input').type(recipientBank);
    cy.get('.recipient-account-number-input').type(recipientAccountNumber);
    cy.get('.transfer-amount-input').type(transferAmount);
    cy.get('.transfer-date-input').type(new Date().toLocaleDateString());
  });

  it('should review and confirm the transfer', () => {
    cy.get('.review-transfer-button').click();
    cy.get('.confirm-transfer-button').click();
    cy.get('.confirmation-message').should('be.visible');
  });

  it('should check transaction status in transaction history', () => {
    cy.get('.transaction-history-link').click();
    cy.get('.transaction-status').should('contain', 'Completed');
  });

  it('should verify the transferred amount is deducted from user account balance', () => {
    cy.get('.account-balance').should('contain', '$0');  // Assuming initial balance was $10,000
  });

  it('should verify the recipient receives the funds', () => {
    // Simulate recipient confirmation of funds receipt
    cy.verifyRecipientFundsReceipt(recipientAccountNumber, transferAmount);
  });
});