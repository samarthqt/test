describe('Add Invalid Custom Field Type', () => {
  it('should prevent adding invalid field types to asset records', () => {
    const assetManagementPage = new AssetManagementPage();
    const customFieldsPage = new CustomFieldsPage();

    assetManagementPage.navigateToCustomFields();
    customFieldsPage.clickAddNewField();
    customFieldsPage.enterFieldName('Invalid Field');
    customFieldsPage.selectFieldType('UnsupportedType');
    customFieldsPage.saveField();

    customFieldsPage.verifyErrorMessage('Field type is not supported');
  });
});