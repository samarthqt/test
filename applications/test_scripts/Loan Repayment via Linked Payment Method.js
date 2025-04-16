describe('Loan Repayment via Linked Payment Method', () => {
    const loanManagementPage = new LoanManagementPage();

    beforeEach(() => {
        cy.visit('/loan-management');
    });

    it('should allow user to make a loan repayment using a linked bank account', () => {
        loanManagementPage.navigateToLoanManagement();
        loanManagementPage.selectRepayLoanOption();
        loanManagementPage.enterRepaymentAmount('500');
        loanManagementPage.selectPaymentMethod('Linked Bank Account');
        loanManagementPage.proceedWithPayment();
        loanManagementPage.verifyPaymentConfirmation('$500');
        loanManagementPage.checkUpdatedLoanBalance('$500');
    });
});