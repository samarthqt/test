describe('Peer Review Functionality', () => {
  const studentID = '67890';
  const assignmentID = 'ASG001';

  beforeEach(() => {
    cy.visit('/login');
    cy.get('#studentID').type(studentID);
    cy.get('#loginButton').click();
  });

  it('should allow students to review and grade each other's work', () => {
    cy.get('#assignmentsModule').click();
    cy.url().should('include', '/assignments');

    cy.get(`#assignment-${assignmentID}`).click();
    cy.url().should('include', `/assignments/${assignmentID}`);

    cy.get('#peerReviewSection').click();
    cy.get('#peerReviewInterface').should('be.visible');

    cy.get('#reviewInput').type('Great work!');
    cy.get('#gradeInput').type('A');
    cy.get('#submitReviewButton').click();

    cy.get('#feedbackConfirmation').should('contain', 'Feedback submitted successfully');
  });
});