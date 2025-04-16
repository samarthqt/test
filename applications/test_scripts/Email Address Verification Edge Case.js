describe('Email Address Verification Edge Case Test', () => {
  it('should verify email registration with boundary conditions', () => {
    const registrationPage = new RegistrationPage();
    const verificationPage = new VerificationPage();
    const loginPage = new LoginPage();

    // Step 1: Navigate to the user registration page
    registrationPage.visit();
    cy.url().should('include', '/register');

    // Step 2: Enter a very long email address in the email field
    registrationPage.enterEmail('user_with_very_long_email_address_1234567890@example.com');

    // Step 3: Enter a valid password in the password field
    registrationPage.enterPassword('ValidPass123');

    // Step 4: Submit the registration form
    registrationPage.submitForm();
    cy.contains('Check your email for verification').should('be.visible');

    // Step 5: Check the inbox of the provided email address
    cy.task('checkEmail', 'user_with_very_long_email_address_1234567890@example.com').then((email) => {
      expect(email.subject).to.include('Verification Link');
      const verificationLink = email.body.match(/https?:\/\/\S+/)[0];

      // Step 6: Click on the verification link in the email
      cy.visit(verificationLink);
      cy.url().should('include', '/verification-success');

      // Step 7: Attempt to log in using the verified email and password
      loginPage.visit();
      loginPage.login('user_with_very_long_email_address_1234567890@example.com', 'ValidPass123');
      cy.contains('Welcome back!').should('be.visible');
    });
  });
});