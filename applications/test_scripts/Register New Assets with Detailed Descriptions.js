describe('Asset Management System', () => {
  before(() => {
    cy.visit('/login');
    cy.login('username', 'password');
  });

  it('should register a new asset with detailed descriptions', () => {
    const assetDetails = {
      id: 'A001',
      description: 'Office Laptop',
      location: 'HQ',
      category: 'Electronics'
    };

    cy.navigateToAssetRegistration();
    cy.addNewAsset();
    cy.enterAssetDetails(assetDetails);
    cy.submitAssetForm();
    cy.verifyAssetInList(assetDetails);
  });

  it('should edit the asset details and save changes', () => {
    const updatedDetails = {
      description: 'Office Laptop - Updated'
    };

    cy.editAssetDetails('A001', updatedDetails);
    cy.verifyAssetInList({ ...updatedDetails, id: 'A001' });
  });

  it('should check the asset history log for registration and updates', () => {
    cy.checkAssetHistory('A001');
  });

  it('should prevent duplicate asset registration', () => {
    const duplicateAsset = {
      id: 'A001',
      description: 'Office Laptop Duplicate',
      location: 'HQ',
      category: 'Electronics'
    };

    cy.navigateToAssetRegistration();
    cy.addNewAsset();
    cy.enterAssetDetails(duplicateAsset);
    cy.submitAssetForm();
    cy.verifyDuplicateAssetError();
  });

  it('should delete an asset and verify removal', () => {
    cy.deleteAsset('A001');
    cy.verifyAssetAbsence('A001');
  });

  it('should reactivate a deleted asset and verify details', () => {
    cy.reactivateAsset('A001');
    cy.verifyAssetInList({ id: 'A001', description: 'Office Laptop', location: 'HQ', category: 'Electronics' });
  });

  after(() => {
    cy.logout();
  });
});