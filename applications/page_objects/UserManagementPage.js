class UserManagementPage {
  navigateToCreateProfile() {
    cy.get('#createProfileButton').click();
    cy.get('#createProfileForm').should('be.visible');
  }

  enterDriverName(name) {
    cy.get('#driverNameInput').type(name);
  }

  setSeatPosition(position) {
    cy.get('#seatPositionInput').type(position);
  }

  setMirrorAngle(angle) {
    cy.get('#mirrorAngleInput').type(angle);
  }

  submitProfile() {
    cy.get('#submitProfileButton').click();
    cy.get('#confirmationMessage').should('contain', 'Profile created successfully');
  }

  verifyProfileCreation() {
    cy.get('#viewProfilesButton').click();
    cy.get('#profilesList').should('contain', 'John Doe');
  }

  navigateToViewProfiles() {
    cy.get('#viewProfilesButton').click();
    cy.get('#profilesList').should('be.visible');
  }

  verifyDriverName(name) {
    cy.get('#profilesList').should('contain', name);
  }

  verifySeatPosition(position) {
    cy.get('#profilesList').should('contain', position);
  }

  verifyMirrorAngle(angle) {
    cy.get('#profilesList').should('contain', angle);
  }

  navigateToUpdateProfile() {
    cy.get('#updateProfileButton').click();
    cy.get('#updateProfileForm').should('be.visible');
  }

  updateSeatPosition(position) {
    cy.get('#seatPositionInput').clear().type(position);
  }

  submitUpdatedProfile() {
    cy.get('#submitProfileButton').click();
    cy.get('#confirmationMessage').should('contain', 'Profile updated successfully');
  }

  verifyProfileUpdate() {
    cy.get('#viewProfilesButton').click();
    cy.get('#profilesList').should('contain', '3');
  }

  logout() {
    cy.get('#logoutButton').click();
    cy.get('#loginPage').should('be.visible');
  }
}