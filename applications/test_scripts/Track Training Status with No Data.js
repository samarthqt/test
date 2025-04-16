describe('Track Training Status with No Data', () => {
  const trialManagementPage = new TrialManagementPage();
  const investigatorTrainingPage = new InvestigatorTrainingPage();

  before(() => {
    cy.login();
  });

  it('should display Trial Management dashboard', () => {
    trialManagementPage.navigate();
    trialManagementPage.verifyDashboardDisplayed();
  });

  it('should display Investigator Training page', () => {
    trialManagementPage.selectInvestigatorTrainingSubModule();
    investigatorTrainingPage.verifyPageDisplayed();
  });

  it('should display investigator profile with no training data', () => {
    investigatorTrainingPage.searchInvestigator('Dr. Jane Smith');
    investigatorTrainingPage.verifyInvestigatorProfileDisplayed('Dr. Jane Smith');
    investigatorTrainingPage.verifyTrainingStatus('None');
    investigatorTrainingPage.verifyCertificationStatus('None');
  });

  it('should display message when generating report with no data', () => {
    investigatorTrainingPage.generateReport('Dr. Jane Smith');
    investigatorTrainingPage.verifyNoDataMessageDisplayed();
  });
});