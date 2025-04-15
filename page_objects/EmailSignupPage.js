class EmailSignupPage {
  enterEmail(email) {
    cy.get('#email-input').type(email);
  }

  clickSignUp() {
    cy.get('#sign-up-button').click();
  }

  verifyErrorMessage(expectedMessage) {
    cy.get('.error-message').should('contain', expectedMessage);
  }
}