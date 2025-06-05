describe('Find a Partner Page Test Suite', () => {
    before(() => {
        cy.visit('http://www.qasymphony.com/partners.html');
    });

    it('should navigate to Find a Partner page', () => {
        const findPartnerPage = new FindPartnerPage();
        findPartnerPage.clickFindPartnerButton();
        cy.url().should('include', '/partners.html');
    });
});