class LoanPage {
  navigateToLoanManagement() {
    cy.visit('/loan-management');
    cy.url().should('include', '/loan-management');
  }

  clickPreApproval() {
    cy.get('.pre-approval-link').click();
    cy.url().should('include', '/loan-pre-approval');
  }

  enterApplicantName(name) {
    cy.get('#applicantName').type(name);
  }

  enterApplicantIncome(income) {
    cy.get('#applicantIncome').type(income);
  }

  enterCreditScore(score) {
    cy.get('#creditScore').type(score);
  }

  enterLoanAmountRequested(amount) {
    cy.get('#loanAmountRequested').type(amount);
  }

  submitApplication() {
    cy.get('#submitButton').click();
  }

  verifyPreApprovalDetailsSaved() {
    cy.get('.pre-approval-details').should('contain', 'John Doe')
      .and('contain', '$50,000')
      .and('contain', '700')
      .and('contain', '$10,000');
  }
}