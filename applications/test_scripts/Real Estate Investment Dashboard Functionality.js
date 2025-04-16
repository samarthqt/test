describe('Real Estate Investment Dashboard Functionality', () => {
  const dashboardPage = new DashboardPage();

  before(() => {
    cy.login('002');
  });

  it('Navigate to the Investment Management module', () => {
    dashboardPage.navigateToInvestmentManagement();
    cy.url().should('include', '/investment-management');
  });

  it('Open the Real Estate Investment Dashboard', () => {
    dashboardPage.openRealEstateDashboard();
    cy.get('#investment-overview').should('be.visible');
  });

  it('Verify the current value of each listed investment', () => {
    dashboardPage.verifyCurrentInvestmentValues();
  });

  it('Check the display of investment trends over time', () => {
    dashboardPage.checkInvestmentTrends();
  });

  it('Review rental yield information for properties generating income', () => {
    dashboardPage.reviewRentalYield();
  });

  it('Interact with dashboard filters to view specific investment types', () => {
    dashboardPage.applyFilters();
  });

  it('Export the investment data displayed on the dashboard', () => {
    dashboardPage.exportInvestmentData('csv');
  });

  it('Verify that investment data updates in real-time with market changes', () => {
    dashboardPage.verifyRealTimeUpdates();
  });

  it('Check the dashboard on different devices', () => {
    cy.viewport('iphone-x');
    cy.get('#investment-overview').should('be.visible');
    cy.viewport('ipad-2');
    cy.get('#investment-overview').should('be.visible');
  });

  it('Attempt to access the dashboard without any investments', () => {
    dashboardPage.checkNoInvestmentsMessage();
  });

  it('Test the dashboard with a high volume of investments', () => {
    dashboardPage.loadHighVolumeInvestments();
  });

  it('Check for any discrepancies in investment data', () => {
    dashboardPage.verifyDataConsistency();
  });

  it('Verify user permissions for accessing and modifying investment data', () => {
    dashboardPage.checkUserPermissions();
  });

  it('Log out and try to access the dashboard again', () => {
    cy.logout();
    dashboardPage.checkRestrictedAccess();
  });

  it('Test dashboard customization options for layout and data display', () => {
    dashboardPage.customizeDashboard();
  });
});