describe('Audit Trail with Invalid Data', () => {
  const dataManagementPage = new DataManagementPage();
  const auditTrailPage = new AuditTrailPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should display no changes for invalid Trial Data ID', () => {
    dataManagementPage.navigateToDataManagement();
    dataManagementPage.selectAuditTrailSubModule();
    auditTrailPage.searchForTrialDataID('99999');
    auditTrailPage.verifyNoChangesFound();
    auditTrailPage.attemptToGenerateReport('99999');
    auditTrailPage.verifyNoDataAvailableMessage();
  });
});