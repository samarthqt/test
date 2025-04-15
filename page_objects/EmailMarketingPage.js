class EmailMarketingPage {
  enterEmail(email) {
    cy.get('#email-input').type(email);
  }

  clickSignUp() {
    cy.get('#sign-up-button').click();
  }

  verifySuccessMessage() {
    cy.get('#confirmation-message').should('contain', 'successfully signed up');
  }
}