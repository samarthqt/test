describe('Maximum Data Display Test', () => {
  const analyticsPage = new AnalyticsPage();

  before(() => {
    cy.visit('/login');
    cy.login('U12345', 'password');
  });

  it('should display user dashboard with activity insights', () => {
    analyticsPage.verifyDashboard();
  });

  it('should navigate to activity insights section', () => {
    analyticsPage.goToActivityInsights();
    analyticsPage.verifyActivityInsightsDisplayed();
  });

  it('should display graphical representation of extensive usage trends', () => {
    analyticsPage.viewGraphicalRepresentation();
    analyticsPage.verifyGraphicalDisplay();
  });

  it('should verify accuracy and performance of displayed data', () => {
    analyticsPage.verifyDataAccuracy();
    analyticsPage.verifyPerformance();
  });
});