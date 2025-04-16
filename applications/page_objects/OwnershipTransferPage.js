class OwnershipTransferPage {
  navigate() {
    return cy.get('[data-testid="ownership-transfer-module"]').click();
  }

  selectVehicle(vehicleId) {
    return cy.get(`[data-testid="vehicle-${vehicleId}"]`).click();
  }

  initiateTransfer() {
    return cy.get('[data-testid="initiate-transfer-button"]').click();
  }

  enterNewOwnerId(newOwnerId) {
    return cy.get('[data-testid="new-owner-id-input"]').type(newOwnerId);
  }

  confirmTransfer() {
    return cy.get('[data-testid="confirm-transfer-button"]').click();
  }

  verifyTransferStatus() {
    return cy.get('[data-testid="transfer-status"]').should('contain', 'Transfer initiated');
  }
}

export default OwnershipTransferPage;