describe('User Registration with Personal Details', () => {
  const registrationPage = new RegistrationPage();
  const email = 'user@example.com';
  const password = 'Password123!';
  const firstName = 'John';
  const lastName = 'Doe';
  const dateOfBirth = '01/01/1990';
  const phoneNumber = '123-456-7890';

  before(() => {
    // Set up any preconditions here
  });

  it('should navigate to the user registration page', () => {
    registrationPage.visit();
    registrationPage.verifyPageLoaded();
  });

  it('should enter a valid email address', () => {
    registrationPage.enterEmail(email);
  });

  it('should enter a strong password', () => {
    registrationPage.enterPassword(password);
  });

  it('should enter first and last name', () => {
    registrationPage.enterFirstName(firstName);
    registrationPage.enterLastName(lastName);
  });

  it('should enter date of birth', () => {
    registrationPage.enterDateOfBirth(dateOfBirth);
  });

  it('should enter phone number', () => {
    registrationPage.enterPhoneNumber(phoneNumber);
  });

  it('should click on the Register button', () => {
    registrationPage.clickRegister();
    registrationPage.verifyRegistrationSuccess();
  });

  it('should check the email inbox for a confirmation email', () => {
    // Simulate checking email inbox for confirmation email
    registrationPage.verifyConfirmationEmailReceived();
  });

  it('should click on the activation link in the email', () => {
    // Simulate clicking activation link in email
    registrationPage.activateAccount();
  });

  it('should log in using the registered email and password', () => {
    registrationPage.login(email, password);
    registrationPage.verifyLoginSuccess();
  });

  after(() => {
    // Clean up any postconditions here
  });
});