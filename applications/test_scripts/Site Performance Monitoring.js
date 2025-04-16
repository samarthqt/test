describe('Site Performance Monitoring', () => {
  const siteId = 'S789';
  const dataEntryCompletionInitial = '95%';
  const enrollmentRateInitial = '80%';
  const dataEntryCompletionUpdated = '100%';
  const enrollmentRateUpdated = '85%';

  before(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
  });

  it('should log in and navigate to the Site Management module', () => {
    cy.get('.dashboard').should('be.visible');
    cy.navigateToSiteManagement();
    cy.get('.site-management').should('be.visible');
  });

  it('should add a new site and verify its details', () => {
    cy.selectPerformanceSection();
    cy.get('.performance-section').should('be.visible');
    cy.clickAddNewSite();
    cy.get('.site-form').should('be.visible');
    cy.enterSiteId(siteId);
    cy.setDataEntryCompletion(dataEntryCompletionInitial);
    cy.setEnrollmentRate(enrollmentRateInitial);
    cy.submitSiteData();
    cy.get('.confirmation-message').should('be.visible');
  });

  it('should verify the site details in View Sites section', () => {
    cy.navigateToViewSites();
    cy.get('.site-list').should('be.visible');
    cy.searchSiteById(siteId);
    cy.verifySiteDetails(siteId, dataEntryCompletionInitial, enrollmentRateInitial);
  });

  it('should update site details and verify changes', () => {
    cy.updateDataEntryCompletion(dataEntryCompletionUpdated);
    cy.verifyEnrollmentRate(enrollmentRateUpdated);
  });

  it('should delete the site and verify it is removed', () => {
    cy.deleteSite(siteId);
    cy.verifySiteNotPresent(siteId);
  });

  after(() => {
    cy.logout();
    cy.verifyDatabaseIntegrity(siteId);
  });
});