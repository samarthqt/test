class ProfilePage {
  navigateToProfile() {
    cy.get('nav').contains('Profile').click();
    cy.url().should('include', '/profile');
  }

  clickEditProfile() {
    cy.get('.edit-profile-btn').click();
  }

  updateName(name) {
    cy.get('#name').clear().type(name);
  }

  updateEmail(email) {
    cy.get('#email').clear().type(email);
  }

  updatePhoneNumber(phoneNumber) {
    cy.get('#phone').clear().type(phoneNumber);
  }

  uploadProfilePicture(filePath) {
    cy.get('#profilePicture').attachFile(filePath);
  }

  updateAddress(street, city, zip) {
    cy.get('#street').clear().type(street);
    cy.get('#city').clear().type(city);
    cy.get('#zip').clear().type(zip);
  }

  saveChanges() {
    cy.get('.save-btn').click();
  }

  verifyUpdatedName(name) {
    cy.get('.profile-name').should('contain', name);
  }

  verifyUpdatedEmail(email) {
    cy.get('.profile-email').should('contain', email);
  }

  verifyUpdatedPhoneNumber(phoneNumber) {
    cy.get('.profile-phone').should('contain', phoneNumber);
  }

  verifyProfilePictureUpdated() {
    cy.get('.profile-picture').should('have.attr', 'src').and('include', 'newProfilePic.jpg');
  }

  verifyUpdatedAddress(street, city, zip) {
    cy.get('.profile-address').should('contain', street);
    cy.get('.profile-address').should('contain', city);
    cy.get('.profile-address').should('contain', zip);
  }

  verifyAllChangesPersist() {
    this.verifyUpdatedName('New Name');
    this.verifyUpdatedEmail('newemail@example.com');
    this.verifyUpdatedPhoneNumber('1234567890');
    this.verifyUpdatedAddress('123 New St', 'New City', '12345');
  }

  verifyEmailFormatError() {
    cy.get('.error-message').should('contain', 'Invalid email format');
  }

  clearRequiredFields() {
    cy.get('#name').clear();
    cy.get('#email').clear();
  }

  verifyRequiredFieldsError() {
    cy.get('.error-message').should('contain', 'Required fields must be filled');
  }

  verifyUnsupportedFileError() {
    cy.get('.error-message').should('contain', 'Unsupported file format');
  }

  verifyResponsiveLayout() {
    cy.get('.profile-container').should('be.visible');
  }

  simulateFailedSave() {
    // Logic to simulate a failed save attempt
  }

  verifyErrorHandling() {
    cy.get('.error-message').should('contain', 'Error saving changes');
  }
}