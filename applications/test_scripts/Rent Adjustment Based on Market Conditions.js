describe('Rent Adjustment Based on Market Conditions', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const rentAdjustmentPage = new RentAdjustmentPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should allow landlord to adjust rent based on market conditions', () => {
    // Step 1: Log in as a landlord
    loginPage.login('landlord@example.com', 'password123');
    dashboardPage.verifyDashboard();

    // Step 2: Navigate to Rent Adjustment module
    dashboardPage.navigateToRentAdjustment();
    rentAdjustmentPage.verifyRentAdjustmentPage();

    // Step 3: Select property with ID P12345
    rentAdjustmentPage.selectProperty('P12345');
    rentAdjustmentPage.verifyPropertyDetails('$1200');

    // Step 4: Enter new market rent value
    rentAdjustmentPage.enterNewRentValue('$1300');
    rentAdjustmentPage.verifyNewRentValue('$1300');

    // Step 5: Review lease agreement
    rentAdjustmentPage.reviewLeaseAgreement('L67890');
    rentAdjustmentPage.verifyLeaseAgreementDetails();

    // Step 6: Confirm the rent adjustment
    rentAdjustmentPage.confirmRentAdjustment();
    rentAdjustmentPage.verifyConfirmationMessage();

    // Step 7: Approve the rent adjustment
    rentAdjustmentPage.approveRentAdjustment();
    rentAdjustmentPage.verifyRentAdjustmentSuccess();

    // Step 8: Verify updated rent in property details
    rentAdjustmentPage.verifyUpdatedRentInPropertyDetails('$1300');

    // Step 9: Check notifications sent to tenants
    rentAdjustmentPage.verifyTenantNotifications();

    // Step 10: Ensure rent adjustment does not affect current lease agreements
    rentAdjustmentPage.verifyLeaseAgreementsUnchanged();

    // Step 11: Log out from the landlord account
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});