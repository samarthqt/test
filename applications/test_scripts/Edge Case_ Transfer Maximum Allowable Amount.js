describe('Edge Case: Transfer Maximum Allowable Amount', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const fundsTransferPage = new FundsTransferPage();

    before(() => {
        cy.visit('/');
    });

    it('should log in to the system', () => {
        loginPage.login('username', 'password');
        dashboardPage.verifyDashboardPage();
    });

    it('should navigate to the Funds Transfer section', () => {
        dashboardPage.navigateToFundsTransfer();
        fundsTransferPage.verifyFundsTransferPage();
    });

    it('should select the From Account with ID 405', () => {
        fundsTransferPage.selectFromAccount('405');
    });

    it('should select the To Account with ID 406', () => {
        fundsTransferPage.selectToAccount('406');
    });

    it('should enter the transfer amount as $10,000', () => {
        fundsTransferPage.enterTransferAmount('10000');
    });

    it('should click on the Transfer button and verify success', () => {
        fundsTransferPage.clickTransferButton();
        fundsTransferPage.verifyTransferSuccess();
    });

    it('should verify the funds have been deducted from the source account', () => {
        fundsTransferPage.verifySourceAccountBalance('405', '-10000');
    });

    it('should verify the funds have been added to the destination account', () => {
        fundsTransferPage.verifyDestinationAccountBalance('406', '+10000');
    });
});