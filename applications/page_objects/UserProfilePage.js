class UserProfilePage {
  navigateToProfile() {
    cy.visit('/user/profile');
  }

  clickEditProfile() {
    cy.get('button').contains('Edit Profile').click();
  }

  updateEmail(email) {
    cy.get('input[name="email"]').clear().type(email);
  }

  updatePhone(phone) {
    cy.get('input[name="phone"]').clear().type(phone);
  }

  selectPreference(preference) {
    cy.get('select[name="preferences"]').select(preference);
  }

  saveChanges() {
    cy.get('button').contains('Save Changes').click();
  }

  verifyUpdatedDetails(email, phone, preference) {
    cy.get('input[name="email"]').should('have.value', email);
    cy.get('input[name="phone"]').should('have.value', phone);
    cy.get('select[name="preferences"]').should('have.value', preference);
  }

  verifyErrorMessage(message) {
    cy.get('.error-message').should('contain', message);
  }
}