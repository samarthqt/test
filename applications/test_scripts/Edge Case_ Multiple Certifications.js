describe('TC-797 487 Edge Case: Multiple Certifications', () => {
  const trialManagementPage = new TrialManagementPage();
  const investigatorTrainingPage = new InvestigatorTrainingPage();

  beforeEach(() => {
    cy.login();
    trialManagementPage.navigate();
  });

  it('Should handle investigators with multiple certifications', () => {
    trialManagementPage.verifyDashboardDisplayed();
    trialManagementPage.selectInvestigatorTraining();
    investigatorTrainingPage.verifyPageDisplayed();
    investigatorTrainingPage.searchInvestigator('Dr. Emily Clark');
    investigatorTrainingPage.verifyInvestigatorProfile('Dr. Emily Clark');
    investigatorTrainingPage.verifyTrainingStatus('Completed');
    investigatorTrainingPage.verifyCertifications(['GCP Certified', 'FDA Certified']);
    investigatorTrainingPage.generateReport('Dr. Emily Clark');
  });
});