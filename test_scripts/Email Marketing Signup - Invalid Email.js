describe('Email Marketing Signup - Invalid Email', () => {
  const invalidEmail = 'invalid-email';

  beforeEach(() => {
    cy.visit('/email-signup');
  });

  it('should display an error message for invalid email', () => {
    const emailSignupPage = new EmailSignupPage();
    emailSignupPage.enterEmail(invalidEmail);
    emailSignupPage.clickSignUp();
    emailSignupPage.verifyErrorMessage('Please enter a valid email address.');
  });
});