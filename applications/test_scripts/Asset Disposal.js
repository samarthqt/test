describe('Asset Disposal Test', () => {
  const assetId = 'C789';
  const disposalReason = 'Damaged';

  before(() => {
    // Log in to the asset management system
    cy.visit('/login');
    cy.get('#username').type('user');
    cy.get('#password').type('password');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Asset Disposal module and mark asset as disposed', () => {
    // Navigate to the Asset Disposal module
    cy.get('#assetDisposalModule').click();
    cy.url().should('include', '/asset-disposal');

    // Select the asset with ID 'C789'
    cy.get(`#assetList [data-asset-id="${assetId}"]`).click();
    cy.get('#assetDetails').should('contain', assetId);

    // Mark the asset as 'Disposed' with reason 'Damaged'
    cy.get('#disposalReason').select(disposalReason);
    cy.get('#markDisposedButton').click();

    // Verify that the asset status is updated to 'Disposed'
    cy.get('#assetStatus').should('contain', 'Disposed');
  });
});