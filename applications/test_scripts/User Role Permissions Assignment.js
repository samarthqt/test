describe('User Role Permissions Assignment', () => {
  const securityModulePage = new SecurityModulePage();

  before(() => {
    cy.visit('/login');
    securityModulePage.loginAsAdmin('adminUser', 'adminPass');
  });

  it('should navigate to the role management section', () => {
    securityModulePage.navigateToRoleManagement();
    securityModulePage.verifyRoleManagementOptionsDisplayed();
  });

  it('should assign full access permissions to Admin role', () => {
    securityModulePage.selectRole('Admin');
    securityModulePage.assignPermissions('Full Access');
    securityModulePage.verifyPermissionsAssigned('Admin', 'Full Access');
  });

  it('should assign limited access permissions to User role', () => {
    securityModulePage.selectRole('User');
    securityModulePage.assignPermissions('Limited Access');
    securityModulePage.verifyPermissionsAssigned('User', 'Limited Access');
  });

  it('should assign view-only access permissions to Guest role', () => {
    securityModulePage.selectRole('Guest');
    securityModulePage.assignPermissions('View-only Access');
    securityModulePage.verifyPermissionsAssigned('Guest', 'View-only Access');
  });
});