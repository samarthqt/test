describe('Maximum Permissions Assignment', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const roleManagementPage = new RoleManagementPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as admin', () => {
    loginPage.enterUsername('admin');
    loginPage.enterPassword('adminPassword');
    loginPage.submit();
    dashboardPage.verifyDashboardIsVisible();
  });

  it('should navigate to role management', () => {
    dashboardPage.goToRoleManagement();
    roleManagementPage.verifyRoleManagementOptions();
  });

  it('should assign all permissions to Admin role', () => {
    roleManagementPage.selectRole('Admin');
    roleManagementPage.assignAllPermissions();
    roleManagementPage.confirmPermissionsAssignment();
    roleManagementPage.verifyPermissionsAssigned();
  });
});