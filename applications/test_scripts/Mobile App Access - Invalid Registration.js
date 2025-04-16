describe('TC-203 165 Mobile App Access - Invalid Registration', () => {
  beforeEach(() => {
    cy.visit('/'); // Assuming the app is hosted and accessible via a URL
  });

  it('should display error message for invalid registration', () => {
    const registrationPage = new RegistrationPage();
    registrationPage.navigateToRegistration();
    registrationPage.enterEmail('invalid-email');
    registrationPage.enterPassword('short');
    registrationPage.submitForm();
    registrationPage.verifyErrorMessage();
  });
});