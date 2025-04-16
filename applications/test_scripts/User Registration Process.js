describe('User Registration Process', () => {
  const registrationPage = new RegistrationPage();
  const loginPage = new LoginPage();
  const userProfilePage = new UserProfilePage();

  it('should navigate to the registration page', () => {
    registrationPage.visit();
    registrationPage.checkPageIsDisplayed();
  });

  it('should register a new user', () => {
    registrationPage.enterEmail('new_user@example.com');
    registrationPage.enterPassword('SecurePass123');
    registrationPage.enterName('John Doe');
    registrationPage.enterAddress('123 Main St, Anytown, USA');
    registrationPage.clickRegister();
    registrationPage.verifyAccountCreated();
  });

  it('should receive a registration confirmation email', () => {
    registrationPage.verifyConfirmationEmailReceived('new_user@example.com');
  });

  it('should log in with newly created account credentials', () => {
    loginPage.visit();
    loginPage.login('new_user@example.com', 'SecurePass123');
    loginPage.verifyLoginSuccess();
  });

  it('should check user profile for accuracy', () => {
    userProfilePage.visit();
    userProfilePage.verifyProfileInformation('John Doe', '123 Main St, Anytown, USA');
  });

  it('should verify email uniqueness during registration', () => {
    registrationPage.visit();
    registrationPage.enterEmail('new_user@example.com');
    registrationPage.clickRegister();
    registrationPage.verifyEmailAlreadyInUseMessage();
  });

  it('should ensure password meets security requirements', () => {
    registrationPage.verifyPasswordSecurity('SecurePass123');
  });

  it('should verify system handles registration errors gracefully', () => {
    registrationPage.enterInvalidData();
    registrationPage.verifyErrorMessagesDisplayed();
  });

  it('should check registration process responsiveness', () => {
    registrationPage.verifyResponsiveAndFunctional();
  });

  it('should verify secure data handling during registration', () => {
    registrationPage.verifySecureDataHandling();
  });

  it('should ensure registration page is accessible', () => {
    registrationPage.verifyPageAccessibility();
  });
});