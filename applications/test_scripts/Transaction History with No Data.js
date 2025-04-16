describe('Transaction History with No Data', () => {
  const transactionPage = new TransactionPage();

  beforeEach(() => {
    cy.visit('/transaction-history');
  });

  it('should display no transactions message when filtered with no matching criteria', () => {
    transactionPage.selectDateRange('Last 7 days');
    transactionPage.selectTransactionType('Refund');
    transactionPage.enterAmountRange('5000', '10000');
    transactionPage.verifyNoTransactionsMessage();
  });
});