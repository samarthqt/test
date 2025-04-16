describe('User Registration with Empty Fields', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    registrationPage.visit();
  });

  it('should require all fields to be filled during registration', () => {
    registrationPage.submitRegistration();
    registrationPage.verifyErrorMessage('All fields are required.');
  });
});