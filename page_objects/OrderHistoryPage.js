class OrderHistoryPage {
  navigateToOrderHistory() {
    cy.get('[data-test=order-history-tab]').click();
  }

  verifyOrderDetails(orderId) {
    cy.get('[data-test=order-id]').contains(orderId);
    cy.get('[data-test=order-date]').should('be.visible');
    cy.get('[data-test=order-total]').should('be.visible');
  }

  viewInvoice() {
    cy.get('[data-test=view-invoice-button]').first().click();
  }

  verifyInvoiceDetails(invoiceId) {
    cy.get('[data-test=invoice-id]').contains(invoiceId);
    cy.get('[data-test=invoice-items]').should('be.visible');
    cy.get('[data-test=invoice-total]').should('be.visible');
  }

  downloadInvoicePDF() {
    cy.get('[data-test=download-pdf-button]').first().click();
  }

  searchOrder(orderId) {
    cy.get('[data-test=search-input]').type(orderId);
    cy.get('[data-test=search-button]').click();
  }

  paginateOrders() {
    cy.get('[data-test=next-page-button]').click();
    cy.get('[data-test=previous-page-button]').click();
  }

  filterOrdersByDate(startDate, endDate) {
    cy.get('[data-test=date-filter]').click();
    cy.get('[data-test=start-date]').type(startDate);
    cy.get('[data-test=end-date]').type(endDate);
    cy.get('[data-test=apply-filter]').click();
  }

  sortOrders() {
    cy.get('[data-test=sort-by-date]').click();
    cy.get('[data-test=sort-by-amount]').click();
  }

  verifyOrderStatus() {
    cy.get('[data-test=order-status]').should('be.visible');
  }

  checkResponsiveness(viewport) {
    cy.viewport(viewport);
    cy.get('[data-test=order-list]').should('be.visible');
  }

  verifyCustomerSupportInfo() {
    cy.get('[data-test=customer-support]').should('be.visible');
  }

  exportToCSV() {
    cy.get('[data-test=export-csv-button]').click();
  }
}

export default OrderHistoryPage;