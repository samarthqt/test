describe('Warehouse Layout Creation', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.loginAsAdmin();
  });

  it('should allow admin to create a new warehouse layout', () => {
    const warehouseName = 'Main Warehouse Low';
    const layoutDetails = 'Aisle 1, Aisle 2, Storage Area';

    cy.get('#warehouseLayoutManagement').click();
    cy.url().should('include', '/warehouse-layout-management');

    cy.get('#createNewLayoutButton').click();
    cy.get('#layoutForm').should('be.visible');

    cy.get('#warehouseNameInput').type(warehouseName);
    cy.get('#layoutDetailsInput').type(layoutDetails);

    cy.get('#submitLayoutButton').click();

    cy.contains(warehouseName).should('be.visible');
    cy.contains(layoutDetails).should('be.visible');
  });
});