describe('Patient Registration - Positive Test', () => {
  it('should register a patient successfully', () => {
    const registrationPage = new RegistrationPage();
    registrationPage.navigate();
    registrationPage.enterName('John Doe');
    registrationPage.enterDOB('01/01/1980');
    registrationPage.enterEmail('johndoe@example.com');
    registrationPage.enterPassword('Password123');
    registrationPage.enterMedicalHistory('None');
    registrationPage.clickRegister();
    registrationPage.verifyRegistrationSuccess();
  });
});