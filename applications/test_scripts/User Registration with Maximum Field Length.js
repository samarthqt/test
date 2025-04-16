describe('User Registration with Maximum Field Length', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    registrationPage.navigateToRegistrationPage();
  });

  it('should register a user with maximum field lengths successfully', () => {
    registrationPage.enterEmail('longemail@example.com');
    registrationPage.enterPassword('AVeryLongPasswordThatExceedsNormalLength123!');
    registrationPage.enterFirstName('ANameThatIsWayTooLongToBeNormal');
    registrationPage.enterLastName('AnotherNameThatIsWayTooLongToBeNormal');
    registrationPage.enterDateOfBirth('12/12/1999');
    registrationPage.clickRegister();
    registrationPage.verifySuccessfulRegistration();
  });
});