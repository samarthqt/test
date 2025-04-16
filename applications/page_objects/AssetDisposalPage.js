class AssetDisposalPage {
  visit() {
    cy.visit('/asset-disposal');
  }

  selectAsset(assetId) {
    cy.get(`#assetList [data-asset-id="${assetId}"]`).click();
  }

  verifyAssetDetails(assetId) {
    cy.get('#assetDetails').should('contain', assetId);
  }

  markAssetAsDisposed(reason) {
    cy.get('#disposalReason').select(reason);
    cy.get('#markDisposedButton').click();
  }

  verifyAssetStatus(status) {
    cy.get('#assetStatus').should('contain', status);
  }
}

module.exports = new AssetDisposalPage();