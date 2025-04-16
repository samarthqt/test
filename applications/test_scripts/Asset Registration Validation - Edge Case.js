describe('Asset Registration Validation - Edge Case', () => {
 it('should register asset with boundary values and unusual data inputs', () => {
 cy.login('username', 'password');
 cy.visit('/asset-registration');
 cy.get(AssetRegistrationPage.assetNameField).type('A');
 cy.get(AssetRegistrationPage.assetTypeDropdown).select('Electronics');
 cy.get(AssetRegistrationPage.serialNumberField).type('SN999999999999999999999999999999');
 cy.get(AssetRegistrationPage.purchaseDateField).type('1900-01-01');
 cy.get(AssetRegistrationPage.costField).type('$0.01');
 cy.get(AssetRegistrationPage.submitButton).click();
 cy.get(AssetRegistrationPage.assetList).should('contain', 'A')
 .and('contain', 'Electronics')
 .and('contain', 'SN999999999999999999999999999999')
 .and('contain', '1900-01-01')
 .and('contain', '$0.01');
 });
});