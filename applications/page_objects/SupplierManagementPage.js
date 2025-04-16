class SupplierManagementPage {
  navigateToSupplierManagement() {
    cy.get('nav').contains('Supplier Management').click();
  }

  selectOrderTracking() {
    cy.get('nav').contains('Order Tracking').click();
  }

  searchBySupplierID(supplierID) {
    cy.get('#supplierIdInput').type(supplierID);
    cy.get('#searchButton').click();
  }

  viewOrderDetails(orderID) {
    cy.get('table').contains('td', orderID).click();
  }

  verifyOrderStatus(orderID) {
    cy.get('#orderStatus').should('be.visible');
  }

  verifyExpectedDeliveryDate(orderID, expectedDate) {
    cy.get('#expectedDeliveryDate').should('contain.text', expectedDate);
  }

  navigateToOrderTrackingOverview() {
    cy.get('#backToOverviewButton').click();
  }

  filterOrdersByStatus(status) {
    cy.get('#statusFilter').select(status);
    cy.get('#filterButton').click();
  }

  viewInTransitOrderDetails() {
    cy.get('table').contains('td', 'In Transit').first().click();
  }

  exportOrderTrackingToExcel() {
    cy.get('#exportButton').click();
  }
}

export default SupplierManagementPage;