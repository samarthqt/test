describe('Insurance Management System Edge Cases', () => {
  const insurancePage = new InsurancePage();

  beforeEach(() => {
    cy.visit('/'); // Launch the insurance management application
  });

  it('should add and verify insurance details', () => {
    insurancePage.navigateToAddInsurance();
    insurancePage.enterPolicyNumber('INS123456');
    insurancePage.enterProvider('ABC Insurance');
    insurancePage.selectCoverageType('Comprehensive');
    insurancePage.submitInsuranceDetails();

    insurancePage.navigateToViewInsurance();
    insurancePage.verifyPolicyNumber('INS123456');
    insurancePage.verifyProviderName('ABC Insurance');
    insurancePage.verifyCoverageType('Comprehensive');
  });

  it('should update and verify insurance coverage type', () => {
    insurancePage.navigateToUpdateInsurance();
    insurancePage.updateCoverageType('Third Party');
    insurancePage.submitUpdatedInsuranceDetails();

    insurancePage.navigateToViewInsurance();
    insurancePage.verifyCoverageType('Third Party');
  });

  after(() => {
    insurancePage.logout();
  });
});