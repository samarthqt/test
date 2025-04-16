describe('Utility Cost Tracking for Electricity', () => {
  it('should track electricity costs accurately for a registered property', () => {
    const loginPage = new LoginPage();
    const dashboardPage = new DashboardPage();
    const utilitiesPage = new UtilitiesPage();
    const billingPage = new BillingPage();

    // Step 1: Log in to the property management portal
    loginPage.visit();
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    dashboardPage.verifyDashboard();

    // Step 2: Navigate to the 'Utilities' section
    dashboardPage.navigateToUtilities();
    utilitiesPage.verifyUtilitiesSection();

    // Step 3: Select 'Electricity' as the utility type
    utilitiesPage.selectElectricity();
    utilitiesPage.verifyElectricityTrackingForm();

    // Step 4: Enter the property ID and date range for tracking
    utilitiesPage.enterPropertyId('1001');
    utilitiesPage.enterDateRange('01/01/2023', '01/31/2023');
    utilitiesPage.verifyDetailsAccepted();

    // Step 5: Enter the electricity cost for the specified period
    utilitiesPage.enterElectricityCost('200');
    utilitiesPage.verifyCostAccepted();

    // Step 6: Submit the tracking information
    utilitiesPage.submitTrackingInformation();
    utilitiesPage.verifyCostRecorded();

    // Step 7: Verify the utility cost is reflected in the billing section
    billingPage.navigateToBilling();
    billingPage.verifyElectricityCostBilled('200');
  });
});