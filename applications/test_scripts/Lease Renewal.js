describe('Lease Renewal', () => {
  const leaseManagementPage = new LeaseManagementPage();
  const tenantDashboardPage = new TenantDashboardPage();

  before(() => {
    cy.login('Jane Smith', 'password');
  });

  it('should renew lease with updated terms', () => {
    leaseManagementPage.navigateToLeaseManagement();
    leaseManagementPage.selectRenewals();
    leaseManagementPage.searchLeaseID('67890');
    leaseManagementPage.selectRenewLease();
    leaseManagementPage.enterNewLeaseTerms('$1500/month', '12 months');
    leaseManagementPage.submitLeaseRenewal();
    leaseManagementPage.verifyConfirmationMessage();
    tenantDashboardPage.verifyUpdatedLeaseAgreement('$1500/month', '12 months');
    tenantDashboardPage.checkEmailNotification();
  });

  after(() => {
    cy.logout();
  });
});