class AccountCreationPage {
  visit() {
    cy.visit('/account-creation');
  }

  enterAccountInformation() {
    // Code to enter account information
    cy.get('#name').type('John Doe');
    cy.get('#email').type('john.doe@example.com');
    cy.get('#password').type('Password123');
  }

  clickCancelButton() {
    cy.get('#cancel-button').click();
  }

  verifyConfirmationMessage() {
    cy.get('.confirmation-message').should('be.visible');
  }

  confirmCancellation() {
    cy.get('.confirm-cancel').click();
  }

  verifyNavigationToPreviousPage() {
    cy.url().should('eq', 'https://example.com/previous-page');
  }

  verifyInformationNotSaved() {
    // Code to verify information is not saved
    cy.reload();
    cy.get('#name').should('have.value', '');
    cy.get('#email').should('have.value', '');
    cy.get('#password').should('have.value', '');
  }
}

export default AccountCreationPage;