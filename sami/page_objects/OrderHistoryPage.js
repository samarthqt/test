class OrderHistoryPage {
  navigateToOrderHistory() {
    cy.visit('/order-history');
  }

  verifyPageLoad() {
    cy.get('.order-history').should('be.visible');
  }

  verifyPastOrdersList() {
    cy.get('.order-list').should('have.length.greaterThan', 0);
  }

  verifyOnOrderHistoryPage() {
    cy.url().should('include', '/order-history');
  }

  selectOrderFromList() {
    cy.get('.order-list-item').first().click();
  }

  verifyOrderDetailsAndInvoice() {
    cy.get('.order-details').should('be.visible');
    cy.get('.invoice').should('be.visible');
  }

  verifyNoPastOrders() {
    cy.get('.order-list').should('have.length', 0);
  }

  verifyNoPastOrdersMessage() {
    cy.get('.no-orders-message').should('be.visible');
  }

  verifyOrdersExceedOnePage() {
    cy.get('.pagination').should('be.visible');
  }

  navigateThroughPages() {
    cy.get('.pagination-next').click();
  }

  verifyAllOrdersAcrossPages() {
    cy.get('.order-list').should('have.length.greaterThan', 0);
  }

  applyDateFilter() {
    cy.get('.date-filter').type('2021-01-01 to 2021-12-31');
    cy.get('.apply-filter').click();
  }

  verifyFilteredOrdersByDate() {
    cy.get('.order-list-item').each(($el) => {
      cy.wrap($el).invoke('text').should('match', /2021/);
    });
  }

  downloadInvoice() {
    cy.get('.download-invoice').click();
  }

  verifyInvoiceDownloaded() {
    // Implement verification for downloaded invoice
  }
}

export default OrderHistoryPage;