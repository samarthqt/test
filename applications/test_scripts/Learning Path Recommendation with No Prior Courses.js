describe('Learning Path Recommendation with No Prior Courses', () => {
    beforeEach(() => {
        cy.visit('https://example.com/login');
        cy.login('user67890', 'password');
    });

    it('should navigate to Learning Paths section', () => {
        cy.get('.dashboard').should('be.visible');
        cy.get('.nav-learning-paths').click();
        cy.url().should('include', '/learning-paths');
    });

    it('should show no recommendations with no completed courses', () => {
        cy.get('.recommendations').should('contain', 'No recommendations available');
        cy.get('.user-preferences').should('contain', 'General interest in technology');
    });

    it('should not display any recommended courses and provide guidance', () => {
        cy.get('.recommended-courses').should('not.exist');
        cy.get('.guidance-message').should('contain', 'Start with introductory courses');
    });
});