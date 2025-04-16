describe('Unauthorized Access to Instructor Dashboard', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should deny access to instructor dashboard for non-instructor account', () => {
    loginPage.login('nonInstructorUser', 'password123');
    cy.url().should('include', '/home');

    dashboardPage.accessInstructorDashboard();
    cy.url().should('not.include', '/instructor-dashboard');
    cy.contains('Access Denied').should('be.visible');
  });
});