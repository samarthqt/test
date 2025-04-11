class ProfilePage {
  navigateToProfileManagement() {
    cy.visit('/profile-management');
  }

  updateName(name) {
    cy.get('#name').clear().type(name);
    cy.get('#save-changes').click();
  }

  updateEmail(email) {
    cy.get('#email').clear().type(email);
    cy.get('#save-changes').click();
  }

  updateShippingAddress(address) {
    cy.get('#shipping-address').clear().type(address);
    cy.get('#save-changes').click();
  }

  updateBillingAddress(address) {
    cy.get('#billing-address').clear().type(address);
    cy.get('#save-changes').click();
  }

  updatePhoneNumber(phoneNumber) {
    cy.get('#phone-number').clear().type(phoneNumber);
    cy.get('#save-changes').click();
  }

  verifyChangesSaved() {
    cy.get('.notification').should('contain', 'Changes saved successfully');
  }

  verifyProfileUpdates() {
    cy.reload();
    cy.get('#name').should('have.value', 'New Name');
    cy.get('#email').should('have.value', 'newemail@example.com');
  }

  verifyUpdateNotification() {
    cy.get('.notification').should('contain', 'Profile updated successfully');
  }

  navigateToPasswordChange() {
    cy.visit('/password-change');
  }

  changePassword(oldPassword, newPassword) {
    cy.get('#old-password').type(oldPassword);
    cy.get('#new-password').type(newPassword);
    cy.get('#confirm-password').type(newPassword);
    cy.get('#change-password').click();
  }

  verifyPasswordChangeNotification() {
    cy.get('.notification').should('contain', 'Password changed successfully');
  }

  enterInvalidData() {
    cy.get('#email').clear().type('invalid-email');
    cy.get('#save-changes').click();
  }

  verifyInvalidInputError() {
    cy.get('.error-message').should('contain', 'Invalid input');
  }

  updatePersonalInformation() {
    this.updateName('Updated Name');
    this.updateEmail('updatedemail@example.com');
    this.updateShippingAddress('789 New Shipping St');
    this.updateBillingAddress('101 New Billing Rd');
    this.updatePhoneNumber('0987654321');
  }

  verifyDataEncryption() {
    // Verification logic for encrypted data storage
  }

  makeProfileChanges() {
    this.updateName('Changed Name');
  }

  verifyProfileChangeLogs() {
    // Verification logic for profile change logs
  }
}

export default ProfilePage;