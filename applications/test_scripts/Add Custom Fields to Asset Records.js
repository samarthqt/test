describe('Add Custom Fields to Asset Records', () => {
  const assetManagementPage = new AssetManagementPage();

  before(() => {
    cy.loginAsAdmin();
  });

  it('should navigate to the Custom Fields section', () => {
    assetManagementPage.navigateToCustomFields();
    assetManagementPage.verifyCustomFieldsSection();
  });

  it('should add a Warranty Period field', () => {
    assetManagementPage.clickAddNewField();
    assetManagementPage.enterFieldName('Warranty Period');
    assetManagementPage.selectFieldType('Date');
    assetManagementPage.clickSave();
    assetManagementPage.verifyFieldAdded('Warranty Period');
  });

  it('should add a Vendor Name field', () => {
    assetManagementPage.clickAddNewField();
    assetManagementPage.enterFieldName('Vendor Name');
    assetManagementPage.selectFieldType('Text');
    assetManagementPage.clickSave();
    assetManagementPage.verifyFieldAdded('Vendor Name');
  });

  it('should verify the presence of new custom fields in asset records', () => {
    assetManagementPage.navigateToAssetRecord();
    assetManagementPage.verifyCustomFieldsInAssetRecord(['Warranty Period', 'Vendor Name']);
  });
});