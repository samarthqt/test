class SecurityModulePage {
  loginAsAdmin(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  navigateToRoleManagement() {
    cy.get('#roleManagement').click();
  }

  verifyRoleManagementOptionsDisplayed() {
    cy.get('#roleOptions').should('be.visible');
  }

  selectRole(roleName) {
    cy.get(`#role-${roleName}`).click();
  }

  assignPermissions(permissionType) {
    cy.get('#permissionsDropdown').select(permissionType);
    cy.get('#assignButton').click();
  }

  verifyPermissionsAssigned(roleName, permissionType) {
    cy.get(`#assigned-${roleName}`).should('contain', permissionType);
  }
}