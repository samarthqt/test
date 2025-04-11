class ProfilePage {
  visitProfilePage() {
    cy.visit('/profile');
  }

  clickButton(button) {
    cy.contains(button).click();
  }

  updateProfileWithValidData() {
    cy.get('#name').clear().type('Valid Name');
    cy.get('#email').clear().type('valid.email@example.com');
    // Add more fields as necessary
  }

  updateProfileWithInvalidData() {
    cy.get('#name').clear().type('');
    cy.get('#email').clear().type('invalid-email');
    // Add more fields as necessary
  }

  updateProfile() {
    cy.get('#name').clear().type('Updated Name');
    cy.get('#email').clear().type('updated.email@example.com');
    // Add more fields as necessary
  }

  leaveProfileUnchanged() {
    // No changes made
  }

  navigateToSection(section) {
    cy.contains(section).click();
  }

  verifyProfileUpdated() {
    cy.get('#name').should('have.value', 'Valid Name');
    cy.get('#email').should('have.value', 'valid.email@example.com');
    // Add more assertions as necessary
  }

  verifyConfirmationMessage() {
    cy.contains('Profile updated successfully').should('be.visible');
  }

  verifyProfileNotUpdated() {
    cy.get('#name').should('not.have.value', 'Invalid Name');
    cy.get('#email').should('not.have.value', 'invalid-email');
    // Add more assertions as necessary
  }

  verifyErrorMessage() {
    cy.contains('Please correct the highlighted fields').should('be.visible');
  }

  verifyRedirectToProfilePage() {
    cy.url().should('include', '/profile');
  }

  verifyEditHistory() {
    cy.get('.edit-history').should('be.visible');
  }

  verifyEditHistoryDetails() {
    cy.get('.edit-history-entry').each(($el) => {
      cy.wrap($el).contains(/\d{2}\/\d{2}\/\d{4} \d{2}:\d{2}/).should('be.visible');
    });
  }

  verifyProfileUnchanged() {
    cy.get('#name').should('have.value', 'Original Name');
    cy.get('#email').should('have.value', 'original.email@example.com');
    // Add more assertions as necessary
  }

  verifyNoChangesMessage() {
    cy.contains('No changes were made').should('be.visible');
  }
}

export default ProfilePage;