class SiteManagementPage {
  navigateToSiteManagement() {
    cy.get('.nav-site-management').click();
  }

  selectPerformanceSection() {
    cy.get('.performance-tab').click();
  }

  clickAddNewSite() {
    cy.get('.add-new-site-button').click();
  }

  enterSiteId(siteId) {
    cy.get('#site-id-input').type(siteId);
  }

  setDataEntryCompletion(value) {
    cy.get('#data-entry-completion-input').type(value);
  }

  setEnrollmentRate(value) {
    cy.get('#enrollment-rate-input').type(value);
  }

  submitSiteData() {
    cy.get('.submit-site-data-button').click();
  }

  navigateToViewSites() {
    cy.get('.view-sites-tab').click();
  }

  searchSiteById(siteId) {
    cy.get('#search-site-input').type(siteId);
    cy.get('.search-button').click();
  }

  verifySiteDetails(siteId, dataEntryCompletion, enrollmentRate) {
    cy.get(`.site-row[data-site-id="${siteId}"]`).within(() => {
      cy.get('.data-entry-completion').should('contain', dataEntryCompletion);
      cy.get('.enrollment-rate').should('contain', enrollmentRate);
    });
  }

  updateDataEntryCompletion(value) {
    cy.get('#data-entry-completion-input').clear().type(value);
    cy.get('.save-button').click();
  }

  verifyEnrollmentRate(value) {
    cy.get('.enrollment-rate-display').should('contain', value);
  }

  deleteSite(siteId) {
    cy.get(`.delete-button[data-site-id="${siteId}"]`).click();
    cy.get('.confirmation-dialog .confirm-button').click();
  }

  verifySiteNotPresent(siteId) {
    cy.get('.site-list').should('not.contain', siteId);
  }

  verifyDatabaseIntegrity(siteId) {
    // Placeholder for database verification logic
  }
}

export default SiteManagementPage;