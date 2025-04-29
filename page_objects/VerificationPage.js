export class VerificationPage {
  verifyCodePromptIsActive() {
    cy.get('.verification-prompt').should('be.visible');
  }

  enterVerificationCode(code) {
    cy.get('#verification-code-input').type(code);
    cy.get('#submit-code-button').click();
  }

  verifyErrorMessageDisplayed() {
    cy.get('.error-message').should('be.visible');
  }

  verifyAccessGranted() {
    cy.get('.access-granted-message').should('be.visible');
  }

  verifyErrorMessageClarity() {
    cy.get('.error-message').should('contain.text', 'Please check your code and try again.');
  }

  enterIncorrectVerificationCode() {
    this.enterVerificationCode('incorrect');
  }

  verifyIncorrectAttemptLogged() {
    cy.request('/api/logs').its('body').should('contain', 'incorrect attempt');
  }

  enterMultipleIncorrectCodes() {
    this.enterVerificationCode('wrong1');
    this.enterVerificationCode('wrong2');
  }

  verifyRetriesAllowed() {
    cy.get('.retry-message').should('be.visible');
  }

  enterCodeOnDifferentDevices() {
    cy.get('.device-code-input').type('654321');
    cy.get('.device-submit-button').click();
  }

  verifyErrorMessageConsistency() {
    cy.get('.error-message').should('be.visible');
  }

  simulateHighTraffic() {
    cy.intercept('/api/verify', { delay: 1000 });
  }

  verifyPromptErrorMessage() {
    cy.get('.error-message').should('be.visible');
  }

  verifyAlternativeMethodPrompt() {
    cy.get('.alternative-method-prompt').should('be.visible');
  }

  enterCodeWithSpecialCharacters() {
    cy.get('#verification-code-input').type('@#$%^&');
    cy.get('#submit-code-button').click();
  }

  verifySpecialCharacterRejection() {
    cy.get('.error-message').should('contain.text', 'Special characters are not allowed');
  }

  applyCustomErrorSettings() {
    cy.get('#custom-error-settings').check();
  }

  verifyCustomErrorMessages() {
    cy.get('.error-message').should('contain.text', 'Custom error message');
  }

  enterCodeFromDifferentLocations() {
    cy.get('#location-code-input').type('654321');
    cy.get('#location-submit-button').click();
  }

  verifyLocationConsistency() {
    cy.get('.error-message').should('be.visible');
  }

  simulateNetworkDelay() {
    cy.intercept('/api/verify', { delay: 500 });
  }

  verifyNoNetworkDelay() {
    cy.get('.error-message').should('be.visible');
  }

  enterCodeWithIncorrectLength() {
    cy.get('#verification-code-input').type('123');
    cy.get('#submit-code-button').click();
  }

  verifyLengthRejection() {
    cy.get('.error-message').should('contain.text', 'Code length is incorrect');
  }

  enterCodesConcurrently() {
    cy.request('POST', '/api/verify', { code: 'wrong' });
  }

  verifyConcurrentHandling() {
    cy.get('.error-message').should('be.visible');
  }
}