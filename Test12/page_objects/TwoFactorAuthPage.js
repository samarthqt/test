import { trigger2FAActivity, verify2FA } from '../helpers/2faHelpers';

class TwoFactorAuthPage {
  
  static navigateToSecuritySettings() {
    cy.get('#security-settings').click();
  }

  static enableTwoFactorAuth() {
    cy.get('#enable-2fa').click();
  }

  static verifyMultiple2FAMethods() {
    cy.get('.2fa-methods').should('exist');
  }

  static choosePreferred2FAMethod() {
    cy.get('#preferred-2fa-method').select('SMS');
  }

  static trigger2FAActivity() {
    trigger2FAActivity();
  }

  static verify2FANotification() {
    cy.get('.notification').should('contain', '2FA activity detected');
  }

  static verify2FAPrompt() {
    cy.get('.2fa-prompt').should('be.visible');
  }

  static verify2FAFunctionality() {
    verify2FA();
  }

  static visitSetupPage() {
    cy.visit('/2fa-setup');
  }

  static select2FAMethod(method) {
    cy.get(`.method-${method}`).click();
  }

  static configure2FAMethod(method) {
    cy.get(`.configure-${method}`).click();
  }
}

export default TwoFactorAuthPage;