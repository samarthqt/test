describe('Service Tier Upgrade Functionality', () => {
    const userId = '12345';
    before(() => {
        cy.visit('/login');
        cy.get('#username').type('validUsername');
        cy.get('#password').type('validPassword');
        cy.get('#loginButton').click();
    });

    it('should navigate to Subscription section', () => {
        cy.get('#dashboard').contains('Subscription').click();
        cy.url().should('include', '/subscription');
        cy.get('#currentTier').should('contain', 'Basic');
    });

    it('should display available higher service tiers', () => {
        cy.get('#upgradeButton').click();
        cy.get('#availableTiers').should('contain', 'Premium').and('contain', 'Enterprise');
    });

    it('should select Premium service tier', () => {
        cy.get('#availableTiers').contains('Premium').click();
        cy.get('#availableTiers').contains('Premium').should('have.class', 'highlighted');
    });

    it('should proceed with the upgrade', () => {
        cy.get('#continueButton').click();
        cy.url().should('include', '/confirmation');
    });

    it('should confirm the upgrade', () => {
        cy.get('#confirmButton').click();
        cy.get('#confirmationMessage').should('contain', 'Your service tier has been upgraded to Premium');
    });

    it('should reflect the new service tier in account information', () => {
        cy.get('#accountInfo').should('contain', 'Premium');
    });

    after(() => {
        cy.get('#logoutButton').click();
        cy.url().should('include', '/login');
    });
});