class RoleManagementPage {
  navigateToRoleManagement() {
    cy.visit('/security/role-management');
  }

  selectRole(roleName) {
    cy.get(`[data-role-name="${roleName}"]`).click();
  }

  verifyRoleDetails(roleName) {
    cy.get('.role-details').should('contain', roleName);
  }

  verifyAccessPermissions(expectedPermissions) {
    expectedPermissions.forEach(permission => {
      cy.get('.permissions-list').should('contain', permission);
    });
  }
}