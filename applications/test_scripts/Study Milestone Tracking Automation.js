describe('Study Milestone Tracking Automation', () => {
  const studyID = 'ST123';
  const milestone = 'Recruitment Goal';
  const targetDate = '2023-12-01';

  before(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
  });

  it('should navigate to the Trial Management module', () => {
    cy.get('.trial-management-link').click();
    cy.url().should('include', '/milestones-tracking');
  });

  it('should select the study and verify details', () => {
    cy.get('.study-list').contains(studyID).click();
    cy.get('.study-details').should('contain', studyID);
    cy.get('.study-details').should('contain', targetDate);
  });

  it('should verify automatic tracking of recruitment goals', () => {
    cy.get('.milestone-tracking').should('contain', milestone);
    cy.get('.milestone-status').should('contain', 'Tracked');
  });

  it('should check the milestone completion status', () => {
    cy.get('.completion-status').should('contain', 'Complete');
  });

  it('should generate milestone report', () => {
    cy.get('.generate-report-button').click();
    cy.get('.report-status').should('contain', 'Generated Successfully');
  });

  after(() => {
    cy.logout();
  });
});