describe('Instructor Feedback Feature', () => {
  beforeEach(() => {
    cy.visit('https://application-url.com');
    cy.login('student_username', 'student_password');
  });

  it('should allow students to rate instructors and leave feedback', () => {
    cy.get('nav').contains('Course Management').click();
    cy.get('.course-list').contains('Course Name').click();
    cy.get('.feedback-button').click();
    cy.get('.rating-input').type('5');
    cy.get('.feedback-textarea').type('Great teaching style and course content.');
    cy.get('.submit-feedback').click();
    cy.get('.confirmation-message').should('contain', 'Feedback successfully submitted');
    cy.get('.feedback-history').should('contain', 'Great teaching style and course content.');
  });

  it('should prompt for rating and feedback text before submission', () => {
    cy.get('nav').contains('Course Management').click();
    cy.get('.course-list').contains('Course Name').click();
    cy.get('.feedback-button').click();
    cy.get('.submit-feedback').click();
    cy.get('.error-message').should('contain', 'Rating is required');
    cy.get('.rating-input').type('5');
    cy.get('.submit-feedback').click();
    cy.get('.error-message').should('contain', 'Feedback text is required');
  });

  it('should accept feedback with maximum character limit', () => {
    cy.get('nav').contains('Course Management').click();
    cy.get('.course-list').contains('Course Name').click();
    cy.get('.feedback-button').click();
    cy.get('.rating-input').type('5');
    cy.get('.feedback-textarea').type('A'.repeat(500));
    cy.get('.submit-feedback').click();
    cy.get('.confirmation-message').should('contain', 'Feedback successfully submitted');
  });

  it('should display error when submitting feedback in offline mode', () => {
    cy.get('nav').contains('Course Management').click();
    cy.get('.course-list').contains('Course Name').click();
    cy.get('.feedback-button').click();
    cy.get('.rating-input').type('5');
    cy.get('.feedback-textarea').type('Great teaching style and course content.');
    cy.setOffline();
    cy.get('.submit-feedback').click();
    cy.get('.error-message').should('contain', 'Network connection is required');
  });

  it('should allow feedback editing and deletion', () => {
    cy.get('nav').contains('Course Management').click();
    cy.get('.course-list').contains('Course Name').click();
    cy.get('.feedback-history').contains('Great teaching style and course content.').click();
    cy.get('.edit-feedback').click();
    cy.get('.feedback-textarea').clear().type('Updated feedback text.');
    cy.get('.save-feedback').click();
    cy.get('.confirmation-message').should('contain', 'Feedback successfully updated');
    cy.get('.delete-feedback').click();
    cy.get('.confirmation-dialog').contains('Yes').click();
    cy.get('.confirmation-message').should('contain', 'Feedback successfully deleted');
  });

  it('should notify instructor upon feedback submission', () => {
    cy.get('nav').contains('Course Management').click();
    cy.get('.course-list').contains('Course Name').click();
    cy.get('.feedback-button').click();
    cy.get('.rating-input').type('5');
    cy.get('.feedback-textarea').type('Great teaching style and course content.');
    cy.get('.submit-feedback').click();
    cy.get('.confirmation-message').should('contain', 'Feedback successfully submitted');
    cy.get('.notification').should('contain', 'Instructor notified of new feedback');
  });
});