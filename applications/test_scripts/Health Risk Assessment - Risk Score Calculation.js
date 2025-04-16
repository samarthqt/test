describe('Health Risk Assessment - Risk Score Calculation', () => {
  beforeEach(() => {
    cy.login('patientUser', 'password'); // Replace with actual login credentials
    cy.visit('/consultation-module');
  });
  it('should prompt for health assessment and calculate risk score', () => {
    const healthRiskPage = new HealthRiskAssessmentPage();
    healthRiskPage.navigateToAssessmentSection();
    healthRiskPage.startAssessment();
    healthRiskPage.enterAge(45);
    healthRiskPage.selectGender('Male');
    healthRiskPage.selectMedicalHistory(['Hypertension', 'Diabetes']);
    healthRiskPage.completeRequiredFields();
    healthRiskPage.submitAssessment();
    healthRiskPage.verifyRiskScoreDisplayed();
    cy.logout();
    cy.login('patientUser', 'password');
    healthRiskPage.verifyAssessmentResultsPersistence();
    healthRiskPage.submitIncompleteAssessment();
    healthRiskPage.verifyErrorMessageForIncompleteFields();
    healthRiskPage.verifyReassessmentAllowed();
    healthRiskPage.verifyRecommendationsBasedOnRiskScore();
    healthRiskPage.enterInvalidAge(-5);
    healthRiskPage.verifyErrorMessageForInvalidAge();
    healthRiskPage.verifyDataConfidentiality();
    healthRiskPage.verifyEmailSummarySent();
  });
});