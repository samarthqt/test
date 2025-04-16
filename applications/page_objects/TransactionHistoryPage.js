class TransactionHistoryPage {
  verifyPageIsDisplayed() {
    cy.get('.transaction-history-page').should('be.visible');
    cy.get('.filter-options').should('be.visible');
  }

  selectDateRange(range) {
    cy.get('.date-range-filter').select(range);
  }

  verifyTransactionsFilteredByDate(range) {
    // Add assertions to verify transactions are filtered by date
  }

  selectTransactionType(type) {
    cy.get('.transaction-type-filter').select(type);
  }

  verifyAllTransactionTypesDisplayed() {
    // Add assertions to verify all transaction types are displayed
  }

  enterAmountRange(min, max) {
    cy.get('.amount-range-min').type(min);
    cy.get('.amount-range-max').type(max);
  }

  verifyTransactionsFilteredByAmount(min, max) {
    // Add assertions to verify transactions are filtered by amount
  }
}