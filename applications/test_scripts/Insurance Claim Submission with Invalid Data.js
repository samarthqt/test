describe('Insurance Claim Submission with Invalid Data', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const insuranceClaimsPage = new InsuranceClaimsPage();

  beforeEach(() => {
    cy.visit('/');
    loginPage.login('patientUsername', 'patientPassword');
    dashboardPage.verifyDashboard();
  });

  it('should handle invalid data inputs during claim submission', () => {
    dashboardPage.navigateToInsuranceClaims();
    insuranceClaimsPage.clickFileNewClaim();
    insuranceClaimsPage.enterPatientID('P12345');
    insuranceClaimsPage.selectInsuranceProvider('HealthInsure');
    insuranceClaimsPage.enterMedicalService('Consultation');
    insuranceClaimsPage.enterDateOfService('Invalid Date');
    insuranceClaimsPage.verifyErrorMessage('Invalid date format.');
    insuranceClaimsPage.enterClaimAmount('-$150');
    insuranceClaimsPage.verifyErrorMessage('Claim amount cannot be negative.');
    insuranceClaimsPage.submitClaim();
    insuranceClaimsPage.verifySubmissionFailed();
  });
});