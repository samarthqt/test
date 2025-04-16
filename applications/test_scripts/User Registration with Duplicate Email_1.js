describe('User Registration with Duplicate Email', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    registrationPage.navigate();
  });

  it('should prevent registration with an already registered email', () => {
    registrationPage.enterEmail('testuser@example.com');
    registrationPage.enterPassword('Test@1234');
    registrationPage.enterConfirmPassword('Test@1234');
    registrationPage.clickRegister();
    registrationPage.verifyErrorMessage('Email testuser@example.com is already registered.');
  });
});