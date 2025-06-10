import { Selector } from 'testcafe'; 
class PasswordRecoveryPage {
  static visit() {
    cy.visit('/password-recovery');
  }

  static enterEmail(email) {
    cy.get('#email').type(email);
  }

  static clickRecoverPassword() {
    cy.get('#recoverPasswordBtn').click();
  }

  static verifyRecoveryEmailSent() {
    cy.contains('Recovery email sent').should('be.visible');
  }

  static enterSecurityQuestionAnswer(answer) {
    cy.get('#securityQuestion').type(answer);
  }

  static clickSubmitSecurityAnswer() {
    cy.get('#submitSecurityAnswerBtn').click();
  }

  static verifySecurityAnswerCorrect() {
    cy.contains('Security answer correct').should('be.visible');
  }

  static verifySecurityAnswerIncorrect() {
    cy.contains('Security answer incorrect').should('be.visible');
  }
}

export default PasswordRecoveryPage;