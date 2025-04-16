describe('Email Address Verification Failure', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    cy.visit('/register');
  });

  it('should display an error for invalid email format', () => {
    registrationPage.enterEmail('invalidemail');
    registrationPage.enterPassword('ValidPass123');
    registrationPage.submitForm();
    registrationPage.getEmailErrorMessage().should('contain', 'invalid email format');
  });
});