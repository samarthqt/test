describe('Unauthorized Access to Medical Test Results', () => {
  const loginPage = new LoginPage();
  const testResultsPage = new TestResultsPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should deny access with unauthorized user credentials', () => {
    loginPage.enterUsername('U12345');
    loginPage.enterPassword('incorrect_password');
    loginPage.submit();
    loginPage.getErrorMessage().should('contain', 'Access is denied');
  });

  it('should redirect unauthorized user when accessing Test Results URL directly', () => {
    cy.visit('/test-results');
    cy.url().should('include', '/login');
  });
});