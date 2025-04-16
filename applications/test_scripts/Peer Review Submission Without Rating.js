describe('TC-357 270 Peer Review Submission Without Rating', () => {
    const studentId = '67890';
    const assignmentId = 'ASG001';

    beforeEach(() => {
        cy.visit('/login');
        cy.get('#studentIdInput').type(studentId);
        cy.get('#loginButton').click();
        cy.url().should('include', '/dashboard');
    });

    it('should prevent peer review submission without rating', () => {
        cy.get('#assignmentsModule').click();
        cy.url().should('include', '/assignments');

        cy.get(`#assignment-${assignmentId}`).click();
        cy.url().should('include', `/assignments/${assignmentId}`);

        cy.get('#peerReviewSection').click();
        cy.url().should('include', '/peer-review');

        cy.get('#submitReviewButton').click();
        cy.get('#ratingError').should('be.visible');
        cy.get('#ratingError').should('contain', 'Please provide a rating');
    });
});