describe('Dashboard Customization with Maximum Widgets', () => {
  before(() => {
    cy.login('77889');
  });

  it('should navigate to Course Dashboard', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.navigateToDashboard();
    cy.url().should('include', '/dashboard');
  });

  it('should display customization options', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.clickCustomize();
    cy.get('.customization-options').should('be.visible');
  });

  it('should add widgets up to the maximum limit', () => {
    const dashboardPage = new DashboardPage();
    for (let i = 0; i < 10; i++) {
      dashboardPage.addWidget();
    }
    cy.get('.widget').should('have.length', 10);
  });

  it('should prevent adding more widgets beyond the maximum limit', () => {
    const dashboardPage = new DashboardPage();
    dashboardPage.addWidget();
    cy.get('.notification').should('contain', 'Maximum widget limit reached');
  });
});