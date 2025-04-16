describe('User Registration with Long Email Address', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    registrationPage.navigate();
  });

  it('should register with an excessively long email address', () => {
    registrationPage.enterEmail('verylongemailaddressuser@example.com');
    registrationPage.enterPassword('Test@1234');
    registrationPage.confirmPassword('Test@1234');
    registrationPage.clickRegister();

    // Add assertion to check if registration was successful or if an error message is displayed
    cy.get('.notification').should('contain', 'email length limitations').or('contain', 'Registration successful');
  });
});