import { Selector } from 'testcafe';

class AchieveService {

  constructor() {
    this.accessStatus = Selector('.access-status');
    this.accessCodeStatus = Selector('.access-code-status');
    this.submitButton = Selector('.submit-button');
    this.inputField = Selector('.input-field');
  }

  checkAccessRevoked() {
    cy.get(this.accessStatus).should('contain', 'revoked');
  }

  checkAccessCodeZeroed() {
    cy.get(this.accessCodeStatus).should('contain', 'zeroed');
  }

  checkAccessCodeInvalid() {
    cy.get(this.accessCodeStatus).should('contain', 'invalid');
  }

  enterAccessCode(accessCode) {
    cy.get(this.inputField).type(accessCode);
  }

  submitAccessCode() {
    cy.get(this.submitButton).click();
  }

  verifyAccessGranted() {
    cy.get(this.accessStatus).should('contain', 'granted');
  }

  verifyErrorMessage(expectedMessage) {
    cy.get('.error-message').should('contain', expectedMessage);
  }

}

export default AchieveService;