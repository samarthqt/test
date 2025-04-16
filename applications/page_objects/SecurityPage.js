class SecurityPage {
  static moduleTitle = '[data-test=module-title]';
}

class UserRolesPage {
  static sectionTitle = '[data-test=section-title]';

  assignRole(userId, role) {
    cy.get(`[data-test=assign-role-${userId}]`).click();
    cy.get('[data-test=role-selector]').select(role);
    cy.get('[data-test=confirm-role]').click();
  }

  modifyRole(userId, role) {
    cy.get(`[data-test=modify-role-${userId}]`).click();
    cy.get('[data-test=role-selector]').select(role);
    cy.get('[data-test=confirm-modification]').click();
  }

  revokeRole(userId, role) {
    cy.get(`[data-test=revoke-role-${userId}]`).click();
    cy.get('[data-test=confirm-revocation]').click();
  }

  verifyUserRole(userId, role) {
    cy.get(`[data-test=user-role-${userId}]`).should('contain', role);
  }

  verifyUserRoleRevocation(userId, role) {
    cy.get(`[data-test=user-role-${userId}]`).should('not.contain', role);
  }

  assignMultipleRoles(userId, roles) {
    roles.forEach(role => {
      this.assignRole(userId, role);
    });
  }

  verifyUserRoles(userId, roles) {
    roles.forEach(role => {
      this.verifyUserRole(userId, role);
    });
  }

  deleteRole(userId, role) {
    cy.get(`[data-test=delete-role-${userId}]`).click();
    cy.get('[data-test=confirm-deletion]').click();
  }

  verifyRoleDeletion(userId, role) {
    cy.get(`[data-test=user-role-${userId}]`).should('not.exist');
  }

  verifyRealTimeRoleUpdates(userId) {
    cy.get('[data-test=real-time-updates]').should('contain', `Updates for ${userId}`);
  }

  checkAccessRestrictions(userId) {
    cy.get(`[data-test=access-check-${userId}]`).should('contain', 'Access Restricted');
  }

  verifyAuditLogs(userId) {
    cy.get('[data-test=audit-logs]').should('contain', `Logs for ${userId}`);
  }

  checkFeatureAccessRestriction(userId, feature) {
    cy.get(`[data-test=feature-access-${userId}-${feature}]`).should('contain', 'Access Denied');
  }

  verifyAdminAccessRestriction(path) {
    cy.visit(path);
    cy.get('[data-test=admin-access]').should('exist');
  }

  checkResponsiveInterface(path) {
    cy.viewport('macbook-15');
    cy.visit(path);
    cy.get('[data-test=responsive-check]').should('be.visible');

    cy.viewport('iphone-6');
    cy.visit(path);
    cy.get('[data-test=responsive-check]').should('be.visible');

    cy.viewport('ipad-2');
    cy.visit(path);
    cy.get('[data-test=responsive-check]').should('be.visible');
  }
}