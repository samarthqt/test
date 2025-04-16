describe('Loan Application Submission', () => {
    beforeEach(() => {
        cy.login(); // Custom command to log in
        cy.visit('/loan-management');
    });

    it('should allow a user to apply for a personal loan', () => {
        const loanPage = new LoanPage();

        loanPage.applyForLoan();
        loanPage.selectLoanType('Personal Loan');
        loanPage.enterLoanAmount('10000');
        loanPage.selectLoanTerm('5 years');
        loanPage.enterAnnualIncome('50000');
        loanPage.enterCreditScore('720');
        loanPage.submitApplication();

        loanPage.verifyConfirmationMessage('Your loan application has been submitted successfully');
        loanPage.checkApplicationStatus('Under Review');
    });
});