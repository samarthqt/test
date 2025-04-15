class MobilePage {
  static navigateToHomepage() {
    cy.visit('/');
  }

  static verifyNoLayoutIssues() {
    cy.get('body').should('not.have.css', 'overflow', 'hidden');
  }

  static verifyInteractiveElements() {
    cy.get('button, a').should('not.be.disabled');
  }

  static verifyNavigationMenu() {
    cy.get('nav').should('be.visible');
  }

  static verifyContentReadability() {
    cy.get('body').should('have.css', 'font-size', '16px');
  }

  static verifyPortraitOrientation() {
    cy.viewport('iphone-x', 'portrait');
  }

  static verifyNoHorizontalScrolling() {
    cy.get('body').should('not.have.css', 'overflow-x', 'scroll');
  }

  static switchToLandscape() {
    cy.viewport('iphone-x', 'landscape');
  }

  static verifyNoVerticalScrolling() {
    cy.get('body').should('not.have.css', 'overflow-y', 'scroll');
  }

  static tapButtonOrLink() {
    cy.get('button, a').first().click();
  }

  static verifyActionPerformed() {
    cy.url().should('include', '/action-page');
  }

  static verifyNoDelayInResponse() {
    cy.get('body').should('not.have.css', 'animation-delay', '0s');
  }

  static focusOnTextInput() {
    cy.get('input[type="text"]').focus();
  }

  static verifyKeyboardAppearance() {
    cy.get('input[type="text"]').should('be.focused');
  }

  static verifyTextInput() {
    cy.get('input[type="text"]').type('Sample text').should('have.value', 'Sample text');
  }

  static playMediaFile() {
    cy.get('video, audio').first().play();
  }

  static verifyMediaPlayback() {
    cy.get('video, audio').should('have.prop', 'paused', false);
  }

  static verifyMediaControls() {
    cy.get('video, audio').within(() => {
      cy.get('.controls').should('be.visible');
    });
  }
}

module.exports = MobilePage;