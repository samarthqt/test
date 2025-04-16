describe('Remove Custom Fields from Asset Records', () => { beforeEach(() => { cy.loginAsAdmin(); cy.visit('/asset-management/custom-fields'); }); it('should remove Vendor Name custom field from asset records', () => { const customFieldsPage = new CustomFieldsPage(); customFieldsPage.selectCustomField('Vendor Name'); customFieldsPage.clickRemoveField(); customFieldsPage.confirmFieldRemoval(); customFieldsPage.verifyFieldRemoved('Vendor Name'); }); });