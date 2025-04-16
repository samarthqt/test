describe('Symptom Checker Negative Input Test', () => {
  const symptomCheckerPage = new SymptomCheckerPage();

  before(() => {
    cy.login(); // Assuming a custom command for login
  });

  it('should handle invalid symptom inputs gracefully', () => {
    symptomCheckerPage.navigateToSymptomChecker();
    symptomCheckerPage.enterInvalidSymptom('@#$%^&*');
    symptomCheckerPage.verifyInputRejected();
    symptomCheckerPage.attemptToCheckSymptoms();
    symptomCheckerPage.verifyCheckSymptomsButtonDisabled();
  });

  after(() => {
    cy.logout(); // Assuming a custom command for logout
  });
});