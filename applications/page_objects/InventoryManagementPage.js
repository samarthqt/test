class InventoryManagementPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#login-button').click();
  }

  navigateToGoodsShipment() {
    cy.get('#goods-shipment-menu').click();
  }

  enterProductId(productId) {
    cy.get('#product-id').type(productId);
    cy.get('#fetch-details-button').click();
  }

  enterShippedQuantity(quantity) {
    cy.get('#shipped-quantity').type(quantity);
  }

  submitShipment() {
    cy.get('#submit-shipment-button').click();
  }
}