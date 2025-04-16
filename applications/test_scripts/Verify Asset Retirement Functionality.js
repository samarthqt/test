describe('Asset Retirement Functionality', () => {
  const assetID = 'A12345';
  const retirementDate = '2023-10-01';
  const retirementReason = 'End of lifecycle';

  beforeEach(() => {
    cy.visit('/asset-management');
  });

  it('should access the Asset Management module', () => {
    cy.url().should('include', '/asset-management');
  });

  it('should search for the asset using Asset ID', () => {
    cy.get('#search-input').type(assetID);
    cy.get('#search-button').click();
    cy.get('#asset-details').should('be.visible');
  });

  it('should display the retirement form when clicking Retire Asset button', () => {
    cy.get('#retire-asset-button').click();
    cy.get('#retirement-form').should('be.visible');
  });

  it('should accept the retirement date', () => {
    cy.get('#retirement-date').type(retirementDate);
    cy.get('#retirement-date').should('have.value', retirementDate);
  });

  it('should select the reason for retirement', () => {
    cy.get('#retirement-reason').select(retirementReason);
    cy.get('#retirement-reason').should('have.value', retirementReason);
  });

  it('should submit the retirement form and mark asset as retired', () => {
    cy.get('#submit-retirement').click();
    cy.get('#active-inventory').should('not.contain', assetID);
  });

  it('should verify the asset is no longer in the active inventory list', () => {
    cy.get('#active-inventory').should('not.contain', assetID);
  });

  it('should check the asset status is updated to Retired', () => {
    cy.get('#asset-status').should('have.text', 'Retired');
  });

  it('should not allow transactions on retired assets', () => {
    cy.get('#transaction-button').should('be.disabled');
  });

  it('should check the audit trail for asset retirement', () => {
    cy.get('#audit-trail').should('contain', retirementDate);
    cy.get('#audit-trail').should('contain', retirementReason);
  });
});