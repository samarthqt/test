class PropertyManagementPage {
  visit() {
    cy.visit('/property-management');
  }

  getDashboard() {
    return cy.get('.dashboard');
  }

  selectViewings() {
    cy.get('.menu-viewings').click();
  }

  getViewingSchedulingInterface() {
    return cy.get('.viewing-scheduling-interface');
  }

  searchProperty(propertyId) {
    cy.get('.search-input').type(propertyId);
    cy.get('.search-button').click();
  }

  getPropertyDetails() {
    return cy.get('.property-details');
  }

  selectAvailableSlot(slot) {
    cy.get('.available-slot').contains(slot).click();
  }

  getSelectedSlot() {
    return cy.get('.selected-slot');
  }

  bookViewing() {
    cy.get('.book-viewing-button').click();
  }

  getConfirmationMessage() {
    return cy.get('.confirmation-message');
  }

  navigateToMyViewings() {
    cy.get('.menu-my-viewings').click();
  }

  getScheduledViewings() {
    return cy.get('.scheduled-viewings');
  }

  getErrorMessage() {
    return cy.get('.error-message');
  }
}

export default PropertyManagementPage;