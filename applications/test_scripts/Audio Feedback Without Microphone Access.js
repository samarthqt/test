describe('Audio Feedback Without Microphone Access', () => {
  const instructorId = '78901';
  const assignmentId = 'ASG002';

  before(() => {
    cy.visit('/login');
    cy.loginAsInstructor(instructorId);
  });

  it('should navigate to the Assignments module', () => {
    cy.get('nav').contains('Assignments').click();
    cy.url().should('include', '/assignments');
  });

  it('should select the assignment and display details', () => {
    cy.get(`[data-assignment-id="${assignmentId}"]`).click();
    cy.get('.assignment-details').should('be.visible');
  });

  it('should access the feedback section', () => {
    cy.get('.feedback-section').click();
    cy.get('.feedback-interface').should('be.visible');
  });

  it('should attempt to record audio feedback without microphone access', () => {
    cy.get('.record-audio-feedback').click();
    cy.on('window:alert', (text) => {
      expect(text).to.contains('Microphone access is required');
    });
  });
});