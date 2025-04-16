class PrivacySettingsPage {
  navigateToPrivacySettings() {
    cy.get('#account-settings-menu').click();
    cy.get('#privacy-settings-link').click();
  }

  selectOptOutDataCollection() {
    cy.get('#opt-out-marketing').check();
  }

  selectAllowDataAccess() {
    cy.get('#allow-data-access').check();
  }

  specifyUserAccess(userIds) {
    cy.get('#user-access-input').type(userIds.join(', '));
  }

  saveChanges() {
    cy.get('#save-privacy-settings').click();
    cy.contains('Changes saved successfully').should('be.visible');
  }

  verifyOptOutActive() {
    cy.get('#opt-out-marketing').should('be.checked');
  }

  resetToDefault() {
    cy.get('#reset-default').click();
  }

  verifyDefaultSettings() {
    cy.get('#opt-out-marketing').should('not.be.checked');
    cy.get('#allow-data-access').should('not.be.checked');
  }
}

export default PrivacySettingsPage;