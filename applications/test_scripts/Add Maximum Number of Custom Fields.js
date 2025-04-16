describe('Add Maximum Number of Custom Fields', () => {
  const maxFields = 100; // Assuming maximum limit is 100
  before(() => {
    cy.loginAsAdmin(); // Custom command to login as admin
    cy.visit('/asset-management/custom-fields');
  });
  it('should allow adding fields up to the maximum limit', () => {
    for (let i = 0; i < maxFields; i++) {
      cy.get(CustomFieldsPage.addNewFieldButton).click();
      cy.get(CustomFieldsPage.fieldNameInput).type(`Field${i + 1}`);
      cy.get(CustomFieldsPage.saveFieldButton).click();
      cy.get(CustomFieldsPage.successMessage).should('contain', 'Field added successfully');
    }
  });
  it('should prevent adding more fields beyond the maximum limit', () => {
    cy.get(CustomFieldsPage.addNewFieldButton).click();
    cy.get(CustomFieldsPage.fieldNameInput).type('Field101');
    cy.get(CustomFieldsPage.saveFieldButton).click();
    cy.get(CustomFieldsPage.errorMessage).should('contain', 'Limit reached');
  });
});