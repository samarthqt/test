describe('Email Address Verification during Registration', () => {
  const registrationPage = new RegistrationPage();
  const verificationPage = new VerificationPage();
  const loginPage = new LoginPage();

  it('should verify email during registration', () => {
    // Navigate to the user registration page
    cy.visit('/register');
    registrationPage.verifyPageLoaded();

    // Enter a valid email
    registrationPage.enterEmail('validuser@example.com');

    // Enter a valid password
    registrationPage.enterPassword('ValidPass123');

    // Submit the registration form
    registrationPage.submitForm();
    registrationPage.verifyEmailSentMessage();

    // Simulate checking the inbox and clicking the verification link
    cy.task('getVerificationLink', 'validuser@example.com').then(link => {
      cy.visit(link);
    });

    // Verify redirection to success page
    verificationPage.verifySuccessPage();

    // Attempt to log in
    cy.visit('/login');
    loginPage.login('validuser@example.com', 'ValidPass123');
    loginPage.verifyLoginSuccess();
  });
});