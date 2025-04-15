class RegistrationPage {
  visit() {
    cy.visit('/register');
  }

  enterName(name) {
    cy.get('#name').clear().type(name);
  }

  enterEmail(email) {
    cy.get('#email').clear().type(email);
  }

  enterPassword(password) {
    cy.get('#password').clear().type(password);
  }

  submitForm() {
    cy.get('#registerButton').click();
  }

  verifyConfirmationMessage(message) {
    cy.get('.confirmation-message').should('contain', message);
  }

  verifyRedirectionToLogin() {
    cy.url().should('include', '/login');
  }

  verifyErrorMessage(message) {
    cy.get('.error-message').should('contain', message);
  }

  setEmailAsRegistered(email) {
    // Mocking or setting up precondition for already registered email
    cy.intercept('POST', '/api/register', {
      statusCode: 400,
      body: { message: 'Email is already registered' }
    }).as('emailRegistered');
  }
}

export default RegistrationPage;