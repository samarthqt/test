describe('User Registration with Weak Password', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    cy.visit('/register');
  });

  it('should display an error message for weak password', () => {
    registrationPage.enterEmail('newuser@example.com');
    registrationPage.enterPassword('12345');
    registrationPage.enterConfirmPassword('12345');
    registrationPage.clickRegister();
    registrationPage.verifyWeakPasswordError();
  });
});