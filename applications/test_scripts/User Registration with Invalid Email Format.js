describe('User Registration with Invalid Email Format', () => {
  beforeEach(() => {
    cy.visit('/register');
  });
  it('should display an error for invalid email format', () => {
    const registrationPage = new RegistrationPage();
    registrationPage.enterEmail('invalid-email');
    registrationPage.enterPassword('ValidPass123!');
    registrationPage.enterFirstName('Bob');
    registrationPage.enterLastName('Johnson');
    registrationPage.enterDateOfBirth('03/03/1993');
    registrationPage.clickRegister();
    registrationPage.verifyInvalidEmailError();
  });
});