describe('Product Return History Tracking', () => {
  const adminCredentials = { username: 'admin', password: 'password' };
  const returnID = 'RT12345';
  const invalidReturnID = 'INVALID123';

  before(() => {
    cy.login(adminCredentials);
  });

  it('should display admin dashboard with access to return tracking module', () => {
    cy.get('.dashboard').should('be.visible');
    cy.get('.return-tracking-module').should('exist');
  });

  it('should navigate to the Order Fulfillment module', () => {
    cy.get('.order-fulfillment-module').click();
    cy.url().should('include', '/order-fulfillment');
  });

  it('should select the Return Tracking sub-module', () => {
    cy.get('.return-tracking-sub-module').click();
    cy.get('.return-tracking-interface').should('be.visible');
  });

  it('should display product return details for Return ID RT12345', () => {
    cy.get('.search-field').type(returnID);
    cy.get('.search-button').click();
    cy.get('.return-details').should('contain', 'Defective').and('contain', 'Refund');
  });

  it('should allow filtering returns by reason', () => {
    cy.get('.filter-reason').select('Defective');
    cy.get('.filtered-results').should('contain', 'Defective');
  });

  it('should export return history data to CSV', () => {
    cy.get('.export-button').click();
    cy.verifyDownload('return-history.csv');
  });

  it('should review exported CSV for data accuracy', () => {
    cy.readFile('cypress/downloads/return-history.csv').then((csv) => {
      expect(csv).to.contain('RT12345,Defective,Refund');
    });
  });

  it('should navigate to analytics section within return tracking module', () => {
    cy.get('.analytics-section').click();
    cy.get('.analytics-dashboard').should('be.visible');
  });

  it('should generate report on return reasons and outcomes', () => {
    cy.get('.generate-report-button').click();
    cy.get('.report').should('contain', 'Statistics on return reasons and outcomes');
  });

  it('should log out of the system', () => {
    cy.logout();
    cy.get('.login-page').should('be.visible');
  });

  it('should deny access to return tracking module without logging in', () => {
    cy.visit('/return-tracking');
    cy.get('.login-required-message').should('be.visible');
  });

  it('should display error for invalid Return ID entry', () => {
    cy.login(adminCredentials);
    cy.get('.return-tracking-sub-module').click();
    cy.get('.search-field').type(invalidReturnID);
    cy.get('.search-button').click();
    cy.get('.error-message').should('contain', 'Return ID is invalid or not found');
  });

  it('should prevent deletion of a return record', () => {
    cy.get('.return-record').within(() => {
      cy.get('.delete-button').click();
    });
    cy.get('.error-message').should('contain', 'Deletion not allowed');
  });

  it('should handle large volume of return data efficiently', () => {
    cy.get('.load-large-data-button').click();
    cy.get('.performance-indicator').should('not.contain', 'Degradation');
  });
});