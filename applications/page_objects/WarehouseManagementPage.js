class WarehouseManagementPage {
  navigateToModule() {
    cy.visit('/warehouse-management');
  }

  selectTransfers() {
    cy.get('#transfers').click();
  }

  initiateNewTransfer() {
    cy.get('#initiate-transfer').click();
  }

  enterProductID(productID) {
    cy.get('#product-id').type(productID);
  }

  selectSourceWarehouse(warehouse) {
    cy.get('#source-warehouse').select(warehouse);
  }

  selectDestinationWarehouse(warehouse) {
    cy.get('#destination-warehouse').select(warehouse);
  }

  enterTransferQuantity(quantity) {
    cy.get('#transfer-quantity').type(quantity);
  }

  submitTransfer() {
    cy.get('#submit-transfer').click();
  }

  verifyTransferInitiation() {
    cy.contains('Transfer initiated successfully').should('be.visible');
  }

  navigateToTransferHistory() {
    cy.get('#transfer-history').click();
  }

  searchTransferByProductID(productID) {
    cy.get('#search-product-id').type(productID);
    cy.get('#search-button').click();
  }

  verifyTransferDetails(source, destination, quantity) {
    cy.contains(source).should('be.visible');
    cy.contains(destination).should('be.visible');
    cy.contains(quantity).should('be.visible');
  }

  checkNotifications() {
    cy.contains('Notification sent to Central').should('be.visible');
    cy.contains('Notification sent to East').should('be.visible');
  }

  verifyErrorMessage() {
    cy.contains('Error: Quantity exceeds available stock').should('be.visible');
  }

  verifyTransferHistory() {
    cy.get('#transfer-history').click();
    cy.contains('Product ID 3003').should('be.visible');
  }
}