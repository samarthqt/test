describe('Assign Multiple Roles to User', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const userManagementPage = new UserManagementPage();
  const rolesPermissionsPage = new RolesPermissionsPage();
  const assetManagementPage = new AssetManagementPage();
  
  before(() => {
    cy.visit('/login');
  });

  it('should login as admin and navigate to User Management', () => {
    loginPage.login('admin', 'admin_password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToUserManagement();
    userManagementPage.verifyPage();
  });

  it('should assign multiple roles to Alice Johnson', () => {
    userManagementPage.navigateToRolesAndPermissions();
    rolesPermissionsPage.verifyPage();
    rolesPermissionsPage.searchUser('Alice Johnson');
    rolesPermissionsPage.assignRole('Alice Johnson', 'Manager');
    rolesPermissionsPage.assignRole('Alice Johnson', 'Employee');
  });

  it('should login as Alice Johnson and verify roles', () => {
    loginPage.logout();
    loginPage.login('Alice Johnson', 'alice_password');
    dashboardPage.verifyDashboard();
    dashboardPage.navigateToAssetManagement();
    assetManagementPage.verifyAccess();
    assetManagementPage.verifyPermissions(['Manager', 'Employee']);
  });
});