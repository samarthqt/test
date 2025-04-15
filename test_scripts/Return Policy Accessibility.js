describe('Return Policy Accessibility', () => {
  const footerPage = new FooterPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should display footer with various links', () => {
    footerPage.scrollToFooter();
    footerPage.footerLinks().should('be.visible');
  });

  it('should navigate to return policy page when Return Policy link is clicked', () => {
    footerPage.scrollToFooter();
    footerPage.clickReturnPolicyLink();
    cy.url().should('include', '/return-policy');
    cy.contains('Return Policy').should('be.visible');
  });
});