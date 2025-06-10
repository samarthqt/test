import { Cypress } from 'cypress';
class ErrorPage {
  static performInvalidAction() {
    cy.get('#invalid-action').click();
  }

  static displayErrorMessage() {
    cy.get('.error-message').should('be.visible');
  }

  static verifyClearErrorMessage() {
    cy.get('.error-message').should('contain', 'Invalid action');
  }

  static verifyActionableErrorMessage() {
    cy.get('.error-message').should('contain', 'Please try again');
  }

  static verifyErrorMessageContent(expectedMessage) {
    cy.get('.error-message').should('contain', expectedMessage);
  }

  static clearErrorMessage() {
    cy.get('.error-message').invoke('text', '');
  }
}

export default ErrorPage;