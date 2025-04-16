describe('Edit Existing Custom Fields', () => {
  const customFieldsPage = new CustomFieldsPage();

  beforeEach(() => {
    cy.loginAsAdmin();
    cy.visit('/asset-management/custom-fields');
  });

  it('should edit an existing custom field', () => {
    customFieldsPage.selectCustomField('Warranty Period');
    customFieldsPage.clickEditField();
    customFieldsPage.changeFieldName('Warranty Duration');
    customFieldsPage.saveChanges();
    customFieldsPage.verifyFieldUpdateInAssetRecord('Warranty Duration');
  });
});