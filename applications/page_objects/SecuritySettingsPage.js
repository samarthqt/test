class SecuritySettingsPage {
  navigateTo() {
    cy.visit('/security-settings');
  }

  verifyPageDisplayed() {
    cy.contains('Security Settings').should('be.visible');
  }

  selectTwoFactorAuthentication() {
    cy.get('#enable-two-factor').click();
  }

  enterPhoneNumber(phoneNumber) {
    cy.get('#phone-number').type(phoneNumber);
  }

  clickSendVerificationCode() {
    cy.get('#send-verification-code').click();
  }

  enterVerificationCode(code) {
    cy.get('#verification-code').type(code);
  }

  clickVerify() {
    cy.get('#verify-button').click();
  }

  verifyTwoFactorEnabled() {
    cy.contains('Two-factor authentication is enabled').should('be.visible');
  }
}