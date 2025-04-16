describe('User Registration', () => {
  const userRegistrationPage = new UserRegistrationPage();
  const email = 'testuser@example.com';
  const password = 'Test@1234';
  const fullName = 'Test User';
  const phoneNumber = '1234567890';

  it('should allow a user to register', () => {
    cy.visit('/user-registration');
    userRegistrationPage.enterEmail(email);
    userRegistrationPage.enterPassword(password);
    userRegistrationPage.confirmPassword(password);
    userRegistrationPage.enterFullName(fullName);
    userRegistrationPage.enterPhoneNumber(phoneNumber);
    userRegistrationPage.clickRegister();

    // Simulate email verification
    cy.task('checkEmail', email).then((verificationLink) => {
      cy.visit(verificationLink);
    });

    // Attempt to log in with new credentials
    cy.visit('/login');
    cy.get('#email').type(email);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();

    // Assert successful login
    cy.contains('Welcome, ' + fullName).should('be.visible');
  });
});