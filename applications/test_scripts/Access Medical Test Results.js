describe('Access Medical Test Results', () => {
  const patientPortalPage = new PatientPortalPage();
  const testResultsPage = new TestResultsPage();

  before(() => {
    cy.visit('https://patient-portal.example.com');
  });

  it('should log in with valid credentials', () => {
    patientPortalPage.login('P12345', 'password123');
    patientPortalPage.verifyDashboard();
  });

  it('should navigate to Test Results section', () => {
    patientPortalPage.goToTestResults();
    testResultsPage.verifyTestResultsList();
  });

  it('should view specific test result details', () => {
    testResultsPage.selectTestResult('T67890');
    testResultsPage.verifyTestResultDetails();
  });

  it('should verify summary and interpretations', () => {
    testResultsPage.verifySummaryAndInterpretations();
  });

  after(() => {
    patientPortalPage.logout();
  });
});