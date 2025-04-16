class CustomerManagementPage {
  navigate() {
    cy.visit('/customer-management');
  }

  createNewProfile(data) {
    cy.get('#createNewProfileButton').click();
    cy.get('#nameField').type(data.name);
    cy.get('#emailField').type(data.email);
    cy.get('#phoneField').type(data.phone);
    cy.get('#addressField').type(data.address);
    cy.get('#saveButton').click();
  }

  verifyProfileCreation(data) {
    cy.contains(data.name).should('be.visible');
    cy.contains(data.email).should('be.visible');
  }

  editProfile(email) {
    cy.contains(email).click();
    cy.get('#editButton').click();
  }

  updatePreferencesAndHistory(details) {
    cy.get('#preferencesField').type(details.preferences);
    cy.get('#orderHistoryField').type(details.orderHistory);
    cy.get('#saveButton').click();
  }

  verifyProfileUpdate(email) {
    cy.contains(email).should('be.visible');
  }

  deleteProfile(email) {
    cy.contains(email).click();
    cy.get('#deleteButton').click();
    cy.get('#confirmDeleteButton').click();
  }

  verifyProfileDeletion(email) {
    cy.contains(email).should('not.exist');
  }
}