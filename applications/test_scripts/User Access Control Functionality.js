describe('User Access Control Functionality', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const userManagementPage = new UserManagementPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('Admin user can access dashboard', () => {
    loginPage.login('admin@example.com', 'adminPassword');
    dashboardPage.verifyAdminDashboardAccess();
    dashboardPage.verifyAdminFeaturesAccess();
    dashboardPage.logout();
  });

  it('Regular user cannot access admin features', () => {
    loginPage.login('user@example.com', 'userPassword');
    dashboardPage.verifyUserDashboardAccess();
    dashboardPage.verifyNoAdminFeaturesAccess();
    dashboardPage.verifyUserFeaturesAccess();
    dashboardPage.logout();
  });

  it('Login fails with invalid credentials', () => {
    loginPage.login('invalid@example.com', 'wrongPassword');
    loginPage.verifyLoginFailure();
  });

  it('Access denied without login', () => {
    dashboardPage.verifyAccessDeniedWithoutLogin();
  });

  it('Role change updates access permissions', () => {
    loginPage.login('admin@example.com', 'adminPassword');
    userManagementPage.changeUserRole('user@example.com', 'newRole');
    userManagementPage.verifyRoleChange('user@example.com', 'newRole');
    dashboardPage.logout();
    loginPage.login('user@example.com', 'userPassword');
    dashboardPage.verifyUpdatedRoleAccess();
    dashboardPage.logout();
  });

  it('Unauthorized role change is prevented', () => {
    loginPage.login('user@example.com', 'userPassword');
    userManagementPage.attemptUnauthorizedRoleChange();
    userManagementPage.verifyUnauthorizedRoleChangePrevention();
    dashboardPage.logout();
  });

  it('Review access logs', () => {
    loginPage.login('admin@example.com', 'adminPassword');
    dashboardPage.reviewAccessLogs();
    dashboardPage.logout();
  });

  it('Access control settings are backed up', () => {
    loginPage.login('admin@example.com', 'adminPassword');
    dashboardPage.verifyAccessControlBackup();
    dashboardPage.logout();
  });
});