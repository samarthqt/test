describe('Patient Registration - Edge Case Test', () => {
  const registrationPage = new RegistrationPage();

  before(() => {
    cy.visit('/registration');
  });

  it('should register a patient with boundary conditions', () => {
    registrationPage.enterName('A');
    registrationPage.enterDOB('01/01/2023');
    registrationPage.enterEmail('edgecase@example.com');
    registrationPage.enterPassword('A1@');
    registrationPage.enterMedicalHistory('Extensive details exceeding typical length');
    registrationPage.clickRegister();

    // Add assertions to verify successful registration
    cy.url().should('include', '/registration-success');
    cy.contains('Registration successful').should('be.visible');
  });
});