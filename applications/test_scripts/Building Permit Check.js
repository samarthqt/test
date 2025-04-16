describe('Building Permit Check', () => {
  const legalCompliancePage = new LegalCompliancePage();

  before(() => {
    cy.login();
  });

  beforeEach(() => {
    cy.visit('/legal-compliance');
  });

  it('should verify building permit for the property', () => {
    legalCompliancePage.navigateToDashboard();
    legalCompliancePage.selectProperty('123 Main St, Springfield');
    legalCompliancePage.enterPermitNumber('123456');
    legalCompliancePage.verifyPermit();
    legalCompliancePage.reviewVerificationResults();
    legalCompliancePage.checkForWarnings();
    legalCompliancePage.saveVerificationReport();
  });

  after(() => {
    cy.logout();
  });
});