describe('Investigator Dashboard Functionality', () => {
  const investigatorID = 'I54321';
  const invalidCredentials = { username: 'invalidUser', password: 'invalidPass' };

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should log in successfully and redirect to the dashboard', () => {
    cy.login(investigatorID);
    cy.url().should('include', '/dashboard');
  });

  it('should display the Investigator Dashboard with trial summaries', () => {
    cy.login(investigatorID);
    cy.get('.main-menu').contains('Investigator Dashboard').click();
    cy.get('.dashboard').should('be.visible');
  });

  it('should verify enrollment status for ongoing trials', () => {
    cy.login(investigatorID);
    cy.get('.enrollment-status').should('contain', 'Current Participant Numbers');
  });

  it('should check data entry progress for selected trials', () => {
    cy.login(investigatorID);
    cy.get('.data-entry-progress').should('contain', '% of Completion');
  });

  it('should review the list of recorded adverse events', () => {
    cy.login(investigatorID);
    cy.get('.adverse-events').should('contain', 'Date').and('contain', 'Type').and('contain', 'Severity');
  });

  it('should navigate to detailed trial data from the dashboard', () => {
    cy.login(investigatorID);
    cy.get('.detailed-trial-data').click();
    cy.url().should('include', '/detailed-data');
  });

  it('should filter dashboard data by trial phase or date', () => {
    cy.login(investigatorID);
    cy.get('.filter-options').select('Trial Phase');
    cy.get('.filtered-data').should('be.visible');
  });

  it('should check for real-time updates on the dashboard', () => {
    cy.login(investigatorID);
    cy.get('.real-time-updates').should('contain', 'Updated Now');
  });

  it('should deny access with invalid investigator credentials', () => {
    cy.login(invalidCredentials.username, invalidCredentials.password);
    cy.get('.error-message').should('contain', 'Access Denied');
  });

  it('should log out successfully', () => {
    cy.login(investigatorID);
    cy.get('.logout-button').click();
    cy.url().should('include', '/login');
  });

  it('should verify dashboard data consistency upon re-login', () => {
    cy.login(investigatorID);
    cy.get('.dashboard-data').then((dataBeforeLogout) => {
      cy.get('.logout-button').click();
      cy.login(investigatorID);
      cy.get('.dashboard-data').should('deep.equal', dataBeforeLogout);
    });
  });

  it('should maintain performance under high data volume', () => {
    cy.login(investigatorID);
    cy.get('.high-volume-data').should('not.have.class', 'loading');
  });

  it('should verify the dashboard UI for ease of navigation', () => {
    cy.login(investigatorID);
    cy.get('.dashboard-ui').should('be.visible');
  });

  it('should test dashboard accessibility on different devices', () => {
    cy.viewport('ipad-2');
    cy.login(investigatorID);
    cy.get('.dashboard').should('be.visible');
    cy.viewport('iphone-6');
    cy.get('.dashboard').should('be.visible');
  });

  it('should validate data export functionality from the dashboard', () => {
    cy.login(investigatorID);
    cy.get('.export-button').click();
    cy.get('.export-options').contains('CSV').click();
    cy.verifyFileDownload('data.csv');
  });
});