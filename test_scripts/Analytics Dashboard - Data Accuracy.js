describe('TC-82 Analytics Dashboard - Data Accuracy', () => {
  before(() => {
    cy.visit('/login');
    cy.fixture('admin').then((admin) => {
      LoginPage.login(admin.username, admin.password);
    });
  });

  it('should navigate to the analytics dashboard', () => {
    DashboardPage.navigateToAnalytics();
    cy.url().should('include', '/analytics');
  });

  it('should verify sales data accuracy', () => {
    cy.fixture('expectedSalesData').then((expectedData) => {
      AnalyticsPage.verifySalesData(expectedData.currentMonth);
    });
  });
});