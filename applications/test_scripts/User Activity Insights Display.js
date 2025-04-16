describe('User Activity Insights Display', () => {
    const userId = 'U12345';
    const password = 'password'; // Replace with actual password
    const activityInsightsPage = new ActivityInsightsPage();

    before(() => {
        cy.visit('/login');
        cy.get('#userId').type(userId);
        cy.get('#password').type(password);
        cy.get('#loginButton').click();
    });

    it('should display activity insights options', () => {
        cy.url().should('include', '/dashboard');
        activityInsightsPage.navigateToActivityInsights();
        activityInsightsPage.verifyActivityInsightsOptionsDisplayed();
    });

    it('should display graphical representation of usage trends', () => {
        activityInsightsPage.selectGraphicalRepresentationOption();
        activityInsightsPage.verifyGraphicalRepresentationDisplayed();
    });

    it('should accurately display usage trends, peaks, and patterns', () => {
        activityInsightsPage.verifyAccuracyOfGraphicalData();
    });
});