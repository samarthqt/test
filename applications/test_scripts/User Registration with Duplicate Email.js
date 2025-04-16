describe('User Registration with Duplicate Email', () => {
  it('should prevent registration with an already registered email', () => {
    const registrationPage = new RegistrationPage();
    registrationPage.navigate();
    registrationPage.enterEmail('duplicate@example.com');
    registrationPage.enterPassword('AnotherPass123!');
    registrationPage.enterFirstName('Alice');
    registrationPage.enterLastName('Smith');
    registrationPage.enterDateOfBirth('02/02/1992');
    registrationPage.clickRegister();
    registrationPage.verifyEmailAlreadyRegisteredError();
  });
});