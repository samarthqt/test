class Slapage {
  navigateTo() {
    cy.visit('/sla-tracking');
  }

  verifyPageIsDisplayed() {
    cy.get('h1').should('contain', 'SLA Tracking');
  }

  enterAssetId(assetId) {
    cy.get('#asset-id-field').type(assetId);
    cy.get('#submit-button').click();
  }

  verifySlaDetails(assetId, endDate) {
    cy.get('#sla-details').should('contain', assetId);
    cy.get('#sla-end-date').should('contain', endDate);
  }

  logNewSlaEntry(assetId) {
    cy.get('#new-sla-entry-button').click();
    cy.get('#asset-id-field').type(assetId);
    cy.get('#save-button').click();
  }

  verifyNewSlaEntryLogged(assetId) {
    cy.get('#sla-log').should('contain', assetId);
  }

  monitorSlaStatusAndEndDate(endDate) {
    cy.get('#sla-status').should('be.visible');
    cy.get('#sla-end-date').should('contain', endDate);
  }
}