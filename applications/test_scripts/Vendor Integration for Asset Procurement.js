describe('Vendor Integration for Asset Procurement', () => {
  const vendorId = 'V123';
  const assetType = 'Laptop';

  before(() => {
    cy.visit('/login');
    cy.get('#username').type('validUsername');
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Vendor Management module', () => {
    cy.get('#vendorManagementLink').click();
    cy.url().should('include', '/vendor-management');
  });

  it('should select the Integration sub-module', () => {
    cy.get('#integrationSubModuleLink').click();
    cy.contains('Manage Vendor Integrations').should('be.visible');
  });

  it('should verify vendor system is listed', () => {
    cy.get(`#vendor-${vendorId}`).should('exist');
    cy.get(`#vendor-${vendorId}-status`).should('have.text', 'Connected');
  });

  it('should initiate a test procurement order', () => {
    cy.get(`#initiateOrder-${assetType}`).click();
    cy.contains('Order initiated successfully').should('be.visible');
  });

  it('should check for automatic updates from the vendor system', () => {
    cy.wait(5000); // Wait for updates
    cy.get('#procurementStatus').should('have.text', 'Updated');
  });

  it('should verify the asset details', () => {
    cy.get('#assetDetails').should('contain.text', assetType);
    cy.get('#assetDetails').should('contain.text', 'Updated Information');
  });

  it('should attempt to disconnect vendor integration', () => {
    cy.get(`#disconnectVendor-${vendorId}`).click();
    cy.contains('Vendor integration successfully disconnected').should('be.visible');
  });

  after(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});