describe('Account Deletion Process', () => {
    const userId = '98765';
    const username = 'testuser';
    const password = 'password123';

    before(() => {
        cy.visit('/login');
        cy.get('#username').type(username);
        cy.get('#password').type(password);
        cy.get('#loginButton').click();
    });

    it('should navigate to Account Management section', () => {
        cy.get('#accountManagementLink').click();
        cy.url().should('include', '/account-management');
    });

    it('should select Account Deletion option', () => {
        cy.get('#accountDeletionOption').click();
        cy.get('#deletionWarnings').should('be.visible');
    });

    it('should acknowledge account deletion warnings', () => {
        cy.get('#acknowledgeCheckbox').click();
        cy.get('#deleteAccountButton').should('be.enabled');
    });

    it('should confirm account deletion', () => {
        cy.get('#deleteAccountButton').click();
        cy.get('#confirmDeletionPrompt').should('be.visible');
        cy.get('#confirmDeletionButton').click();
        cy.get('#deletionConfirmationMessage').should('contain', 'Account has been deleted');
    });

    it('should fail to log into deleted account', () => {
        cy.visit('/login');
        cy.get('#username').type(username);
        cy.get('#password').type(password);
        cy.get('#loginButton').click();
        cy.get('#loginErrorMessage').should('contain', 'Account does not exist');
    });
});