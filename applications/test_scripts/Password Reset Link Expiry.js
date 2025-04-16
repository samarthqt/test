describe('Password Reset Link Expiry', () => {
  it('should display expiration message for expired password reset link', () => {
    const expiredLink = 'https://example.com/reset?token=expired123';
    cy.visit(expiredLink);
    cy.contains('The link has expired').should('be.visible');
    cy.contains('Request a new link').should('be.visible');
  });
});