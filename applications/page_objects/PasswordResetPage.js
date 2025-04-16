class PasswordResetPage {
  visitExpiredLink() {
    cy.visit('https://example.com/reset?token=expired123');
  }

  verifyExpirationMessage() {
    cy.contains('The link has expired').should('be.visible');
  }

  verifyRequestNewLinkPrompt() {
    cy.contains('Request a new link').should('be.visible');
  }
}

export default PasswordResetPage;