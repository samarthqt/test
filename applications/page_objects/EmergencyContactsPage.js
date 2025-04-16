class EmergencyContactsPage {
  navigateToEmergencyContacts() {
    cy.get('#emergency-contacts-section').click();
  }

  clickAddNewContact() {
    cy.get('#add-new-contact-btn').click();
  }

  enterContactName(name) {
    cy.get('#contact-name-field').type(name);
  }

  enterContactPhone(phone) {
    cy.get('#contact-phone-field').type(phone);
  }

  selectRelationship(relationship) {
    cy.get('#relationship-dropdown').select(relationship);
  }

  clickSaveButton() {
    cy.get('#save-contact-btn').click();
  }

  selectContactFromList(name) {
    cy.contains('.contact-list-item', name).click();
  }

  updateContactPhone(phone) {
    cy.get('#contact-phone-field').clear().type(phone);
  }

  clickUpdateButton() {
    cy.get('#update-contact-btn').click();
  }

  verifyContactInList(name, phone) {
    cy.contains('.contact-list-item', `${name} - ${phone}`).should('exist');
  }

  verifyDuplicateEntryError() {
    cy.get('.error-message').should('contain', 'duplicate entry is not allowed');
  }

  verifyPhoneNumberRequiredError() {
    cy.get('.error-message').should('contain', 'phone number is required');
  }

  verifyInvalidPhoneNumberError() {
    cy.get('.error-message').should('contain', 'phone number format is invalid');
  }
}