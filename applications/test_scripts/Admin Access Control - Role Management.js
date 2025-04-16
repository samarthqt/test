describe('Admin Access Control - Role Management', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const roleManagementPage = new RoleManagementPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as a regular user', () => {
    loginPage.enterUsername('regular_user');
    loginPage.enterPassword('regular_pass');
    loginPage.submit();
    dashboardPage.verifyDashboard();
  });

  it('should deny access to role management section', () => {
    roleManagementPage.navigateToRoleManagement();
    roleManagementPage.verifyAccessDenied();
  });

  it('should not allow actions like adding or editing roles', () => {
    roleManagementPage.attemptRoleActions();
    roleManagementPage.verifyActionsDenied();
  });
});