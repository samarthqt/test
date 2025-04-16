describe('User Registration with Invalid Email Format', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    cy.visit('/registration');
  });

  it('should display error for invalid email format', () => {
    registrationPage.enterEmail('testuser@com');
    registrationPage.enterPassword('Test@1234');
    registrationPage.enterConfirmPassword('Test@1234');
    registrationPage.clickRegister();

    cy.get('.error-message')
      .should('be.visible')
      .and('contain', 'Invalid email format');
  });
});