describe('Audio Feedback Functionality', () => {
    const instructorId = '78901';
    const assignmentId = 'ASG002';
    before(() => {
        cy.visit('/login');
        cy.get('input[name="instructorId"]').type(instructorId);
        cy.get('button[type="submit"]').click();
    });

    it('should navigate to Assignments module', () => {
        cy.get('nav').contains('Assignments').click();
        cy.url().should('include', '/assignments');
    });

    it('should select the assignment', () => {
        cy.get(`.assignment-list-item[data-id="${assignmentId}"]`).click();
        cy.url().should('include', `/assignments/${assignmentId}`);
    });

    it('should access feedback section', () => {
        cy.get('.feedback-section').click();
        cy.get('.feedback-interface').should('be.visible');
    });

    it('should record and submit audio feedback', () => {
        cy.get('.record-audio-button').click();
        cy.wait(3000); // Simulate recording time
        cy.get('.stop-recording-button').click();
        cy.get('.submit-feedback-button').click();
        cy.get('.feedback-success-message').should('contain', 'Audio feedback submitted successfully');
    });
});