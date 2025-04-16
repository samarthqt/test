describe('User Login with Incorrect Credentials', () => {
  const loginPage = new LoginPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display an error message for invalid credentials', () => {
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('IncorrectPassword');
    loginPage.clickLoginButton();

    loginPage.getErrorMessage().should('be.visible').and('contain', 'Invalid credentials');
  });

  it('should deny access to the user dashboard', () => {
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('IncorrectPassword');
    loginPage.clickLoginButton();

    cy.visit('/dashboard');
    cy.url().should('not.include', '/dashboard');
  });

  it('should log failed login attempts', () => {
    loginPage.enterUsername('testuser');
    loginPage.enterPassword('IncorrectPassword');
    loginPage.clickLoginButton();

    // Assuming there's an API or method to check logs
    cy.request('/api/logs').then((response) => {
      expect(response.body).to.include('Failed login attempt for user testuser');
    });
  });
});