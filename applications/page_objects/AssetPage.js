class AssetPage {
  searchAssetById(assetId) {
    cy.get('#search-input').type(assetId);
    cy.get('#search-button').click();
  }

  verifyAssetDetailsDisplayed(assetId) {
    cy.get('#asset-details').should('contain', assetId);
  }

  editRegistrationDate(newDate) {
    cy.get('#registration-date').clear().type(newDate);
  }

  provideJustification(justification) {
    cy.get('#justification-input').type(justification);
  }

  saveChanges() {
    cy.get('#save-button').click();
  }

  verifyRegistrationDateUpdated(expectedDate) {
    cy.get('#registration-date').should('have.value', expectedDate);
  }
}

export default AssetPage;