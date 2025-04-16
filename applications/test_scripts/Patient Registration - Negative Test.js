describe('Patient Registration - Negative Test', () => {
  const registrationPage = new RegistrationPage();

  beforeEach(() => {
    cy.visit('/registration');
  });

  it('should handle invalid inputs during patient registration', () => {
    registrationPage.submitForm();
    registrationPage.getNameError().should('be.visible');

    registrationPage.enterDOB('01/01/1980');
    registrationPage.getDOBField().should('have.value', '01/01/1980');

    registrationPage.enterEmail('invalidemail');
    registrationPage.getEmailError().should('be.visible');

    registrationPage.enterPassword('pass');
    registrationPage.getPasswordError().should('be.visible');

    registrationPage.enterMedicalHistory('None');
    registrationPage.getMedicalHistoryField().should('have.value', 'None');

    registrationPage.submitForm();
    registrationPage.getNameError().should('be.visible');
    registrationPage.getEmailError().should('be.visible');
    registrationPage.getPasswordError().should('be.visible');
  });
});