class MfaPage {
  verifyRegisteredPhoneNumber() {
    cy.get('#registered-phone').should('exist');
  }

  loginWithRegisteredAccount() {
    cy.get('#login-button').click();
  }

  verifyMFAPrompt() {
    cy.get('#mfa-prompt').should('be.visible');
  }

  selectPhoneNumberVerificationMethod() {
    cy.get('#phone-method').click();
  }

  displayRegisteredPhoneNumber() {
    cy.get('#registered-phone-display').should('contain.text', 'Your registered phone number');
  }

  verifyPhoneNumberSelected() {
    cy.get('#phone-method-selected').should('exist');
  }

  confirmPhoneNumberSelection() {
    cy.get('#confirm-phone-selection').click();
  }

  sendVerificationCode() {
    cy.get('#send-code').click();
  }

  verifyCodeSent() {
    cy.get('#code-sent').should('exist');
  }

  checkReceivedCode() {
    cy.get('#received-code').should('contain.text', '123456');
  }

  verifyReceivedCode(expectedCode) {
    cy.get('#received-code').should('contain.text', expectedCode);
  }

  verifyCodeReceived() {
    cy.get('#code-received').should('exist');
  }

  enterReceivedCode() {
    cy.get('#verification-code-input').type('123456');
  }

  verifyCodeAndGrantAccess() {
    cy.get('#access-granted').should('be.visible');
  }

  checkCodeFormat() {
    cy.get('#received-code').invoke('text').should('match', /\d{6}/);
  }

  verifyCodeLength() {
    cy.get('#received-code').invoke('text').should('have.length', 6);
  }

  verifyDifferentRegisteredNumber() {
    cy.get('#different-registered-phone').should('exist');
  }

  repeatMFAWithDifferentNumber() {
    cy.get('#repeat-mfa').click();
  }

  verifyCodeSentToNewNumber() {
    cy.get('#code-sent-new-number').should('exist');
  }

  initiateMFAProcess() {
    cy.get('#initiate-mfa').click();
  }

  skipPhoneNumberSelection() {
    cy.get('#skip-phone-selection').click();
  }

  promptToSelectPhoneNumber() {
    cy.get('#select-phone-prompt').should('be.visible');
  }

  checkDeliveryTime() {
    cy.get('#delivery-time').should('be.lessThan', 30000);
  }

  verifyCodeReceivedInTime() {
    cy.get('#code-received-time').should('be.lessThan', 30000);
  }

  checkSMSContent() {
    cy.get('#sms-content').should('not.contain.text', 'sensitive');
  }

  verifySMSContent() {
    cy.get('#sms-content').should('contain.text', 'Verification code');
  }

  verifyMultipleLoginAttempts() {
    cy.get('#multiple-login-attempts').should('exist');
  }

  checkVerificationCodes() {
    cy.get('#verification-codes').children().should('have.length.greaterThan', 1);
  }

  verifyUniqueCodes() {
    cy.get('#unique-codes').should('exist');
  }

  verifyLoginAttempt() {
    cy.get('#login-attempt').should('exist');
  }

  checkNumberOfCodesSent() {
    cy.get('#code-count').should('be.equal', 1);
  }

  verifyNoDuplicateCodes() {
    cy.get('#no-duplicate-codes').should('exist');
  }

  verifyPhoneNumberRegistered() {
    cy.get('#registered-phone').should('exist');
  }

  checkPhoneNumberFormat() {
    cy.get('#phone-format').should('match', /\+\d{1,3}-\d{3}-\d{3}-\d{4}/);
  }

  verifyPhoneNumberFormat() {
    cy.get('#phone-format').should('exist');
  }

  checkSystemLogs() {
    cy.get('#system-logs').should('contain.text', 'Verification code sent');
  }

  verifySystemLogs() {
    cy.get('#system-logs').should('contain.text', 'Verification code sent');
  }

  verifyUnregisteredPhoneNumber() {
    cy.get('#unregistered-phone').should('exist');
  }

  attemptMFA() {
    cy.get('#attempt-mfa').click();
  }

  promptToRegisterNumber() {
    cy.get('#register-number-prompt').should('be.visible');
  }
}

module.exports = new MfaPage();