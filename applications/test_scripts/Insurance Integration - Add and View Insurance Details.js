describe('Insurance Management Application', () => {
  const insurancePage = new InsurancePage();

  before(() => {
    cy.visit('https://insurance-management-app.com');
  });

  it('should add, view, and update insurance details', () => {
    // Add Insurance
    insurancePage.navigateToAddInsurance();
    insurancePage.enterPolicyNumber('INS123456');
    insurancePage.enterProvider('ABC Insurance');
    insurancePage.selectCoverageType('Comprehensive');
    insurancePage.submitInsuranceDetails();

    // View Insurance
    insurancePage.navigateToViewInsurance();
    insurancePage.verifyPolicyNumber('INS123456');
    insurancePage.verifyProviderName('ABC Insurance');
    insurancePage.verifyCoverageType('Comprehensive');

    // Update Insurance
    insurancePage.navigateToUpdateInsurance();
    insurancePage.updateCoverageType('Third Party');
    insurancePage.submitUpdatedInsuranceDetails();

    // Verify Updated Details
    insurancePage.navigateToViewInsurance();
    insurancePage.verifyCoverageType('Third Party');
  });

  after(() => {
    insurancePage.logout();
  });
});