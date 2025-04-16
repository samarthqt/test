describe('Lease Termination Processing', () => {
  const leaseManagementPage = new LeaseManagementPage();
  const terminationPage = new TerminationPage();

  before(() => {
    cy.login('tenant', 'password');
  });

  it('should navigate to Lease Management module', () => {
    leaseManagementPage.accessLeaseManagement();
    leaseManagementPage.verifyDashboardDisplayed();
  });

  it('should navigate to Termination sub-module', () => {
    terminationPage.navigateToTerminationModule();
    terminationPage.verifyTerminationPageDisplayed();
  });

  it('should locate the lease for Tenant ID T002', () => {
    terminationPage.findLeaseByTenantID('T002');
    terminationPage.verifyLeaseDisplayed();
  });

  it('should request termination for the lease', () => {
    terminationPage.requestTermination();
    terminationPage.verifyTerminationFormDisplayed();
  });

  it('should enter termination reason as Relocation', () => {
    terminationPage.enterTerminationReason('Relocation');
    terminationPage.verifyReasonEntered('Relocation');
  });

  it('should review lease agreement terms', () => {
    terminationPage.reviewLeaseTerms();
    terminationPage.verifyTermsReviewed();
  });

  it('should confirm termination request submission', () => {
    terminationPage.confirmTerminationRequest();
    terminationPage.verifyConfirmationMessageDisplayed();
  });

  it('should check system logs for termination request entries', () => {
    cy.checkSystemLogs('Termination request submitted for Tenant ID T002');
  });

  it('should verify tenant receives confirmation email', () => {
    cy.verifyEmailReceived('tenant@example.com', 'Lease Termination Confirmation');
  });

  it('should check email content for accuracy', () => {
    cy.verifyEmailContent('tenant@example.com', 'Lease ID: L001, Reason: Relocation');
  });

  it('should verify landlord receives notification of the request', () => {
    cy.verifyEmailReceived('landlord@example.com', 'New Lease Termination Request');
  });

  it('should check termination request status in the system', () => {
    terminationPage.checkRequestStatus('Pending Review');
  });

  it('should review request for compliance with lease terms', () => {
    terminationPage.reviewRequestCompliance();
    terminationPage.verifyRequestCompliant();
  });

  it('should approve the termination request', () => {
    terminationPage.approveTerminationRequest();
    terminationPage.verifyStatusUpdated('Approved');
  });

  after(() => {
    cy.logout();
  });
});