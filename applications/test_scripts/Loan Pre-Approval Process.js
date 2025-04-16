describe('Loan Pre-Approval Process', () => {
  const loanPage = new LoanPage();

  beforeEach(() => {
    cy.login('validUser', 'validPassword'); // Assume a custom command for login
    loanPage.navigateToLoanManagement();
  });

  it('should allow user to apply for loan pre-approval and receive eligibility indication', () => {
    loanPage.clickPreApproval();
    loanPage.enterApplicantName('John Doe');
    loanPage.enterApplicantIncome('50000');
    loanPage.enterCreditScore('700');
    loanPage.enterLoanAmountRequested('10000');
    loanPage.submitApplication();

    cy.get('.confirmation-message').should('contain', 'pre-approval application has been submitted');
    cy.get('.eligibility-status').should('be.visible');

    loanPage.verifyPreApprovalDetailsSaved();
  });
});