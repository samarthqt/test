describe('TC-262 200 Edge Case: Maximum Documentation Access', () => {
  const supportPage = new SupportPage();
  const documentationPage = new DocumentationPage();

  before(() => {
    cy.visit('/login');
    cy.login('U12345', 'password');
  });

  it('should log in to the support module', () => {
    supportPage.verifyDashboardAccessible();
  });

  it('should navigate to the documentation section', () => {
    supportPage.navigateToDocumentation();
    documentationPage.verifyDocumentationOptionsDisplayed();
  });

  it('should access extensive online documentation', () => {
    documentationPage.accessExtensiveDocumentation();
    documentationPage.verifyExtensiveDocumentationAccessible();
  });

  it('should verify the comprehensiveness and performance of the documentation', () => {
    documentationPage.verifyDocumentationComprehensiveness();
    documentationPage.verifySystemPerformance();
  });
});