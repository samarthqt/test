describe('TC-777 360 Batch Processing of Asset Records', () => {
  const assetIds = ['12345', '12346', '12347'];
  const batchActionMassAllocation = 'Mass Allocation';
  const batchActionConditionUpdate = 'Condition Update';

  before(() => {
    cy.visit('/login');
    cy.loginAsAdmin();
  });

  it('should navigate to Batch Processing section', () => {
    cy.get('.asset-management-menu').click();
    cy.get('.batch-processing-link').click();
    cy.url().should('include', '/batch-processing');
  });

  it('should select multiple assets for batch processing', () => {
    assetIds.forEach(id => {
      cy.get(`.asset-checkbox[data-id="${id}"]`).check();
    });
  });

  it('should execute Mass Allocation action', () => {
    cy.get('.batch-action-select').select(batchActionMassAllocation);
    cy.get('.execute-batch-action').click();
    cy.get('.notification').should('contain', 'Mass Allocation action is executed successfully');
  });

  it('should verify allocation changes', () => {
    assetIds.forEach(id => {
      cy.get(`.asset-row[data-id="${id}"]`).should('contain', 'Allocated');
    });
  });

  it('should execute Condition Update action', () => {
    cy.get('.batch-action-select').select(batchActionConditionUpdate);
    cy.get('.execute-batch-action').click();
    cy.get('.notification').should('contain', 'Condition Update action is executed successfully');
  });

  it('should verify updated conditions', () => {
    assetIds.forEach(id => {
      cy.get(`.asset-row[data-id="${id}"]`).should('contain', 'Updated Condition');
    });
  });
});