describe('Late Payment Tracking for Tenants', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const trackingPage = new TrackingPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should flag tenants with overdue payments and allow landlord action', () => {
    loginPage.loginAsLandlord();
    dashboardPage.verifyDashboardDisplayed();
    dashboardPage.navigateToTrackingSection();
    trackingPage.verifyTrackingInterfaceDisplayed();
    trackingPage.reviewOverdueTenants();
    trackingPage.initiateOverduePaymentAction();
    trackingPage.verifyActionInitiated();
    dashboardPage.logout();
  });
});