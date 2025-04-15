describe('User Registration', () => {
  it('should register a user with valid data', () => {
    const registrationPage = new RegistrationPage();
    registrationPage.navigate();
    registrationPage.enterUsername('testuser');
    registrationPage.enterPassword('Test@1234');
    registrationPage.enterEmail('testuser@example.com');
    registrationPage.clickRegister();
    cy.url().should('include', '/welcome');
  });
});