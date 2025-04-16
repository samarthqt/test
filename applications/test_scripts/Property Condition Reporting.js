describe('Property Condition Reporting', () => {
  const tenant = new TenantPage();
  const manager = new ManagerPage();

  it('should allow tenant to report property damage or maintenance', () => {
    cy.loginAsTenant();
    tenant.verifyDashboard();
    tenant.navigateToDamageReporting();
    tenant.selectProperty('Property Name');
    tenant.enterIssueDescription('Sample damage or maintenance issue description.');
    tenant.attachPhotos(['photo1.jpg', 'document1.pdf']);
    tenant.submitReport();
    tenant.verifyReportInSubmittedList();
  });

  it('should allow manager to process the damage report', () => {
    cy.loginAsManager();
    manager.checkIncomingReports();
    manager.acknowledgeReport();
    manager.assignReportToTeam();
    cy.logout();
  });
});