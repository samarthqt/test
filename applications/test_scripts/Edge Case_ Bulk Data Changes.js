describe('Bulk Data Changes Test', () => {
  const dataManagementPage = new DataManagementPage();
  const auditTrailPage = new AuditTrailPage();

  beforeEach(() => {
    cy.visit('/data-management');
  });

  it('should navigate to Data Management module and display dashboard', () => {
    dataManagementPage.verifyDashboardDisplayed();
  });

  it('should select Audit Trail sub-module and display Audit Trail page', () => {
    dataManagementPage.selectAuditTrailSubModule();
    auditTrailPage.verifyAuditTrailPageDisplayed();
  });

  it('should search for changes related to Trial Data IDs 10001-10010', () => {
    auditTrailPage.searchChangesByTrialDataIDs('10001-10010');
    auditTrailPage.verifyChangesDisplayedForTrialDataIDs('10001-10010');
  });

  it('should verify change description for each entry', () => {
    auditTrailPage.verifyChangeDescriptionForEntries('Updated protocol details');
  });

  it('should verify user field for each entry', () => {
    auditTrailPage.verifyUserForEntries('Data Manager');
  });

  it('should verify reason field for each entry', () => {
    auditTrailPage.verifyReasonForEntries('Protocol update');
  });

  it('should generate a bulk report for the audit trail of Trial Data IDs 10001-10010', () => {
    auditTrailPage.generateBulkReportForTrialDataIDs('10001-10010');
    auditTrailPage.verifyBulkReportGenerated();
  });
});