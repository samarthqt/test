describe('Eligibility Criteria Verification', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const eligibilityPage = new EligibilityPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the system as a trial coordinator', () => {
    loginPage.loginAsCoordinator();
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to the Eligibility Verification module', () => {
    dashboardPage.goToEligibilityModule();
    eligibilityPage.verifyModuleDisplayed();
  });

  it('should select participant P002 and verify eligibility', () => {
    eligibilityPage.selectParticipant('P002');
    eligibilityPage.verifyParticipantDetailsDisplayed();
    eligibilityPage.clickVerifyEligibility();
    eligibilityPage.verifyMedicalCriteriaEvaluated('Diabetes');
    eligibilityPage.verifyDemographicCriteriaEvaluated('Age 30-50');
    eligibilityPage.verifyEligibilityStatusUpdated();
  });

  it('should send notifications to trial staff', () => {
    eligibilityPage.verifyNotificationsSent();
  });

  it('should access eligibility dashboard and export data', () => {
    eligibilityPage.accessEligibilityDashboard();
    eligibilityPage.verifyDashboardStatistics();
    eligibilityPage.exportDataToExcel('P002');
  });

  it('should generate eligibility summary report', () => {
    eligibilityPage.generateSummaryReport();
  });

  it('should allow manual override of eligibility status', () => {
    eligibilityPage.verifyManualOverrideOption();
  });

  it('should review audit trail for participant P002', () => {
    eligibilityPage.reviewAuditTrail('P002');
  });

  it('should validate security measures for data storage', () => {
    eligibilityPage.verifyDataSecurity();
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLogoutSuccess();
  });
});