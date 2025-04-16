describe('Video Consultation Login Failure', () => {
  const loginPage = new LoginPage();
  const forgotPasswordPage = new ForgotPasswordPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should display error for invalid login credentials', () => {
    loginPage.enterUsername('invalidUser');
    loginPage.enterPassword('invalidPass');
    loginPage.clickLogin();
    loginPage.getErrorMessage().should('contain', 'incorrect login details');
  });

  it('should display error for multiple invalid login attempts', () => {
    for (let i = 0; i < 3; i++) {
      loginPage.enterUsername('invalidUser');
      loginPage.enterPassword('invalidPass');
      loginPage.clickLogin();
    }
    loginPage.getErrorMessage().should('contain', 'incorrect login details');
  });

  it('should reset password using the Forgot Password option', () => {
    loginPage.clickForgotPassword();
    forgotPasswordPage.enterEmail('registeredEmail@example.com');
    forgotPasswordPage.clickSubmit();
    forgotPasswordPage.getConfirmationMessage().should('contain', 'password reset link');
  });

  it('should allow login with new password after reset', () => {
    loginPage.enterUsername('validUser');
    loginPage.enterPassword('newValidPass');
    loginPage.clickLogin();
    dashboardPage.getWelcomeMessage().should('contain', 'Welcome');
  });
});