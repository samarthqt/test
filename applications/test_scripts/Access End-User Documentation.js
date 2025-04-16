describe('TC-260 200 Access End-User Documentation', () => {
  const userCredentials = { userId: 'U12345', password: 'password123' };
  const supportPage = new SupportPage();

  before(() => {
    cy.visit('/login');
    supportPage.login(userCredentials.userId, userCredentials.password);
  });

  it('should access the user dashboard with documentation options', () => {
    supportPage.verifyDashboardAccess();
  });

  it('should navigate to the documentation section', () => {
    supportPage.navigateToDocumentationSection();
    supportPage.verifyDocumentationOptionsDisplayed();
  });

  it('should access online documentation', () => {
    supportPage.accessOnlineDocumentation();
    supportPage.verifyOnlineDocumentationAccessible();
  });

  it('should verify the comprehensiveness and accuracy of the documentation', () => {
    supportPage.verifyDocumentationAccuracy();
  });
});