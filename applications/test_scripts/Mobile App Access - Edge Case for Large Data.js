describe('Mobile App Registration - Large Data Input', () => {
  beforeEach(() => {
    cy.visit('app-url');
  });

  it('should register with large data inputs without performance issues', () => {
    const registrationPage = new RegistrationPage();
    registrationPage.navigateToRegistration();
    registrationPage.enterEmail('verylongemailaddress@example.com');
    registrationPage.enterPassword('VeryLongPasswordWithSpecialCharacters123!@#');
    registrationPage.submitForm();

    // Assertions
    cy.url().should('include', '/dashboard');
    cy.get('.success-message').should('contain', 'Account created successfully');
  });
});