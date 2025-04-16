describe('Investment Product Browsing with Insufficient Funds', () => {
    before(() => {
        // Assuming user is already logged in and has a verified investment account
        cy.visit('/investment');
    });

    it('should prevent investment initiation when funds are insufficient', () => {
        const investmentPage = new InvestmentPage();
        investmentPage.selectProductType('Bonds');
        investmentPage.selectBondOption();
        investmentPage.enterInvestmentAmount(1000);
        investmentPage.initiateInvestment();
        investmentPage.verifyErrorMessage('Insufficient funds for the investment.');
        investmentPage.verifyAccountBalance(500);
    });
});