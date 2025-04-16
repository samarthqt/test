describe('Assign Invalid Role to User', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const userManagementPage = new UserManagementPage();
  const rolesPermissionsPage = new RolesPermissionsPage();
  
  before(() => {
    cy.visit('/login');
  });

  it('should prevent assigning invalid roles to users', () => {
    loginPage.loginAsAdmin();
    dashboardPage.verifyDashboardDisplayed();
    dashboardPage.navigateToUserManagement();
    userManagementPage.verifyUserManagementModuleOpened();
    userManagementPage.selectRolesAndPermissions();
    rolesPermissionsPage.verifyRolesPermissionsScreenDisplayed();
    rolesPermissionsPage.searchUser('Jane Smith');
    rolesPermissionsPage.verifyUserFound('Jane Smith');
    rolesPermissionsPage.selectAssignRole('Jane Smith');
    rolesPermissionsPage.attemptToAssignInvalidRole('InvalidRole');
    rolesPermissionsPage.verifyErrorMessageDisplayed('InvalidRole is not a valid role');
  });
});