describe('Admin Access Control by Roles', () => {
  const roleManagementPage = new RoleManagementPage();

  beforeEach(() => {
    cy.loginAsAdmin();
    roleManagementPage.navigateToRoleManagement();
  });

  it('should display Doctor role details with correct permissions', () => {
    roleManagementPage.selectRole('Doctor');
    roleManagementPage.verifyRoleDetails('Doctor');
    roleManagementPage.verifyAccessPermissions(['patient management', 'prescription']);
  });

  it('should display Nurse role details with correct permissions', () => {
    roleManagementPage.selectRole('Nurse');
    roleManagementPage.verifyRoleDetails('Nurse');
    roleManagementPage.verifyAccessPermissions(['patient care', 'appointment scheduling']);
  });

  it('should display Support Staff role details with correct permissions', () => {
    roleManagementPage.selectRole('Support Staff');
    roleManagementPage.verifyRoleDetails('Support Staff');
    roleManagementPage.verifyAccessPermissions(['administrative', 'scheduling']);
  });
});