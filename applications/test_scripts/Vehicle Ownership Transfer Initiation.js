describe('Vehicle Ownership Transfer Initiation', () => {
  const currentOwnerId = 'CO123456';
  const newOwnerId = 'NO987654';
  const vehicleId = 'V654321';

  before(() => {
    // Assuming user is logged in
    cy.visit('/vehicle-management');
  });

  it('should navigate to Ownership Transfer module', () => {
    cy.get('[data-testid="ownership-transfer-module"]').click();
    cy.url().should('include', '/ownership-transfer');
  });

  it('should select the vehicle to be transferred', () => {
    cy.get(`[data-testid="vehicle-${vehicleId}"]`).click();
    cy.get('[data-testid="vehicle-details"]').should('contain', vehicleId);
  });

  it('should initiate transfer', () => {
    cy.get('[data-testid="initiate-transfer-button"]').click();
    cy.get('[data-testid="new-owner-id-input"]').should('be.visible');
  });

  it('should enter new owner ID and confirm transfer', () => {
    cy.get('[data-testid="new-owner-id-input"]').type(newOwnerId);
    cy.get('[data-testid="confirm-transfer-button"]').click();
  });

  it('should verify tracking of transfer status', () => {
    cy.get('[data-testid="transfer-status"]').should('contain', 'Transfer initiated');
  });
});