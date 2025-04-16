describe('Maintenance Cost Estimation', () => {
  const maintenancePage = new MaintenancePage();
  const estimationPage = new EstimationPage();

  before(() => {
    cy.login();
    maintenancePage.navigateToMaintenanceManagement();
  });

  it('should navigate to Estimation module', () => {
    maintenancePage.navigateToEstimationModule();
    estimationPage.verifyEstimationPageDisplayed();
  });

  it('should locate and select the issue for Apartment 101', () => {
    estimationPage.findIssue('Apartment 101');
    estimationPage.selectGenerateEstimate();
  });

  it('should enter issue details and submit estimation request', () => {
    estimationPage.enterIssueType('Plumbing');
    estimationPage.enterIssueDescription('Leaking sink');
    estimationPage.reviewEstimationParameters();
    estimationPage.submitEstimationRequest();
    estimationPage.verifyConfirmationMessage();
  });

  it('should verify system logs and estimated cost', () => {
    estimationPage.checkSystemLogs();
    estimationPage.verifyEstimatedCostDisplayed();
    estimationPage.checkEstimationBreakdown();
    estimationPage.ensureEstimationWithinRange();
  });

  it('should verify email is sent to tenant with accurate content', () => {
    estimationPage.verifyEmailSentToTenant();
    estimationPage.checkEmailContent();
  });

  after(() => {
    cy.logout();
  });
});