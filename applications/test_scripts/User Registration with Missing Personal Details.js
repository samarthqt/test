describe('User Registration with Missing Personal Details', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    cy.visit('/registration');
  });

  it('should display error when personal details are missing', () => {
    registrationPage.enterEmail('missingdetails@example.com');
    registrationPage.enterPassword('SecurePass123!');
    registrationPage.submitForm();

    registrationPage.getFirstNameField().should('have.class', 'error');
    registrationPage.getLastNameField().should('have.class', 'error');
    registrationPage.getDateOfBirthField().should('have.class', 'error');
    registrationPage.getErrorMessage().should('contain', 'missing personal details');
  });
});