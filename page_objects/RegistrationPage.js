class RegistrationPage {
  enterUsername(username) {
    cy.get('#username').type(username);
  }

  enterPassword(password) {
    cy.get('#password').type(password);
  }

  enterEmail(email) {
    cy.get('#email').type(email);
  }

  clickRegister() {
    cy.get('#registerButton').click();
  }

  verifyEmailFormatError() {
    cy.get('.error-message').should('contain', 'invalid email format');
  }
}

export default RegistrationPage;