describe('Child Vaccination Tracking and Reminder', () => {
    before(() => {
        cy.visit('/login');
        cy.login('parent_username', 'parent_password');
    });

    it('should navigate to Vaccination Tracking section', () => {
        cy.get('#vaccinationTrackingNav').click();
        cy.url().should('include', '/vaccination-tracking');
    });

    it('should display child vaccination details', () => {
        cy.get('#childSelect').select('C12345');
        cy.get('#vaccinationSchedule').should('contain', 'MMR');
    });

    it('should confirm upcoming vaccine details', () => {
        cy.get('#upcomingVaccines').should('contain', 'MMR').and('contain', '2023-11-01');
    });

    it('should check reminder settings for upcoming vaccines', () => {
        cy.get('#reminderSettings').should('contain', 'SMS notifications enabled');
    });

    it('should simulate due date arrival and verify SMS reminder', () => {
        cy.simulateDate('2023-11-01');
        cy.get('#notificationHistory').should('contain', 'MMR reminder sent');
    });
});