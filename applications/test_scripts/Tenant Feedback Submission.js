describe('Tenant Feedback Submission', () => {
  const feedbackText = 'The property is well-maintained and the landlord is responsive.';

  before(() => {
    cy.visit('/login');
    cy.loginAsTenant();
  });

  it('should display the tenant dashboard with feedback access', () => {
    cy.get('.tenant-dashboard').should('be.visible');
  });

  it('should navigate to the Feedback section', () => {
    cy.get('.feedback-nav').click();
    cy.get('.feedback-interface').should('be.visible');
  });

  it('should enter feedback in the text area', () => {
    cy.get('.feedback-textarea').type(feedbackText);
  });

  it('should submit the feedback and display confirmation', () => {
    cy.get('.submit-feedback').click();
    cy.get('.confirmation-message').should('contain', 'Feedback submitted successfully');
  });

  after(() => {
    cy.logout();
  });
});