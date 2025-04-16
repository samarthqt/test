class AccountManagementPage {
  selectRequestReinstatement() {
    cy.contains('Request Reinstatement').click();
  }

  enterReinstatementReason(reason) {
    cy.get('#reasonField').type(reason);
  }

  submitReinstatementRequest() {
    cy.get('#submitRequestButton').click();
  }

  verifyConfirmationMessage() {
    cy.contains('Your reinstatement request has been submitted successfully').should('be.visible');
  }
}