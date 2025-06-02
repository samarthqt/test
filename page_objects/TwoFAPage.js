import { Selector } from 'cypress';

class TwoFAPage {

  static enter2FACode(code) {
    cy.get('#2faCode').type(code);
  }

  static submit() {
    cy.get('#submit2FABtn').click();
  }

  static verifyInvalid2FA() {
    cy.get('#invalid2faMessage').should('be.visible');
  }

  static simulateMultipleFailedAttempts() {
    for (let i = 0; i < 3; i++) {
      this.enter2FACode('000000');
      this.submit();
      this.verifyInvalid2FA();
    }
  }

  static enter2FA(code) {
    this.enter2FACode(code);
    this.submit();
  }

  static checkGuidance() {
    cy.get('#2faGuidance').should('exist');
  }

  static verifyGuidanceProvided() {
    cy.get('#2faGuidance').should('be.visible');
  }

  static is2FAPageLoaded() {
    cy.url().should('include', '/2fa');
    cy.get('#2faCode').should('be.visible');
  }

}

export default TwoFAPage;