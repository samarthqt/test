import RegistrationPage from '../pageObjects/RegistrationPage';

describe('User Registration with Invalid Email', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    cy.visit('/register');
  });

  it('should display an error message for invalid email format', () => {
    registrationPage.enterUsername('testuser');
    registrationPage.enterPassword('Test@1234');
    registrationPage.enterEmail('invalidemail.com');
    registrationPage.clickRegister();
    registrationPage.verifyEmailFormatError();
  });
});