describe('Transaction History Page', () => {
  const transactionHistoryPage = new TransactionHistoryPage();

  beforeEach(() => {
    // Assuming login is required and user is logged in
    cy.visit('/transaction-history');
  });

  it('should display transaction history with filtering options', () => {
    transactionHistoryPage.verifyPageIsDisplayed();
  });

  it('should filter transactions by last 30 days', () => {
    transactionHistoryPage.selectDateRange('Last 30 days');
    transactionHistoryPage.verifyTransactionsFilteredByDate('Last 30 days');
  });

  it('should display all transaction types', () => {
    transactionHistoryPage.selectTransactionType('All');
    transactionHistoryPage.verifyAllTransactionTypesDisplayed();
  });

  it('should filter transactions by amount range $0 to $1000', () => {
    transactionHistoryPage.enterAmountRange(0, 1000);
    transactionHistoryPage.verifyTransactionsFilteredByAmount(0, 1000);
  });
});