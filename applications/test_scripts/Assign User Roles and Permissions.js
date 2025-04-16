describe('Assign User Roles and Permissions', () => {
  const adminCredentials = { username: 'admin', password: 'admin123' };
  const userCredentials = { username: 'John Doe', password: 'password123' };
  const userManagementPage = new UserManagementPage();
  const assetManagementPage = new AssetManagementPage();

  before(() => {
    cy.login(adminCredentials.username, adminCredentials.password);
  });

  it('should assign roles and permissions to a user', () => {
    userManagementPage.navigateToUserManagement();
    userManagementPage.selectRolesAndPermissions();
    userManagementPage.searchUser('John Doe');
    userManagementPage.assignRoleToUser('John Doe', 'Manager');
    userManagementPage.assignPermissionsToUser('John Doe', ['View', 'Edit', 'Delete Assets']);
  });

  it('should verify user permissions', () => {
    cy.logout();
    cy.login(userCredentials.username, userCredentials.password);
    assetManagementPage.navigateToAssetManagement();
    assetManagementPage.verifyUserPermissions(['View', 'Edit', 'Delete Assets']);
  });

  after(() => {
    cy.logout();
  });
});