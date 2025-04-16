class PasswordRecoveryPage {
  constructor() {
    this.emailInput = 'input[name="email"]';
    this.submitButton = 'button[type="submit"]';
    this.errorMessage = '.error-message';
  }
  enterEmail(email) {
    cy.get(this.emailInput).type(email);
  }
  submitRequest() {
    cy.get(this.submitButton).click();
  }
  getErrorMessage() {
    return cy.get(this.errorMessage);
  }
}