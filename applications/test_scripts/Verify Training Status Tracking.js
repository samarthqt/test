describe('Training Status Tracking', () => {
  const trialManagementPage = new TrialManagementPage();
  const investigatorTrainingPage = new InvestigatorTrainingPage();

  beforeEach(() => {
    cy.login(); // Assuming a login command is available
  });

  it('should display the Trial Management dashboard', () => {
    trialManagementPage.navigateTo();
    trialManagementPage.verifyDashboardDisplayed();
  });

  it('should display Investigator Training page with a list of investigators', () => {
    trialManagementPage.selectInvestigatorTraining();
    investigatorTrainingPage.verifyPageDisplayed();
  });

  it('should display Dr. John Doe profile with completed training status and GCP certification', () => {
    investigatorTrainingPage.searchInvestigator('Dr. John Doe');
    investigatorTrainingPage.verifyInvestigatorProfileDisplayed('Dr. John Doe');
    investigatorTrainingPage.verifyTrainingStatus('Completed');
    investigatorTrainingPage.verifyCertification('GCP Certified');
  });

  it('should generate a report for Dr. John Doe's training status', () => {
    investigatorTrainingPage.generateReport('Dr. John Doe');
    investigatorTrainingPage.verifyReportGenerated();
  });
});