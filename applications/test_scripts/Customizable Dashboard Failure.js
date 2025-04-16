describe('Dashboard Customization Error Handling', () => {
  beforeEach(() => {
    cy.login();
    cy.visit('/dashboard/customization');
  });

  it('should display error for invalid widget selection', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.selectWidget('InvalidWidgetName');
    cy.contains('Error: Invalid widget selection').should('be.visible');
  });

  it('should display error for invalid layout option', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.selectLayout('InvalidLayoutOption');
    cy.contains('Error: Invalid layout selection').should('be.visible');
  });

  it('should display error for invalid statistics selection', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.selectStatistics('InvalidStatistics');
    cy.contains('Error: Invalid statistics selection').should('be.visible');
  });
});