describe('Update User Profile Information', () => {
  before(() => {
    // Assume user is logged in
    cy.login();
  });

  it('should update profile information successfully', () => {
    const profilePage = new ProfileManagementPage();

    // Navigate to Profile Management page
    profilePage.visit();
    cy.url().should('include', '/profile');

    // Update name
    profilePage.updateName('John Doe');
    profilePage.getName().should('have.value', 'John Doe');

    // Update email
    profilePage.updateEmail('john.doe@example.com');
    profilePage.getEmail().should('have.value', 'john.doe@example.com');

    // Update password
    profilePage.updatePassword('NewPassword123');

    // Update preferences
    profilePage.updatePreferences(true);
    profilePage.getPreferences().should('be.checked');

    // Save changes
    profilePage.saveChanges();
    cy.contains('Profile information is saved successfully').should('be.visible');
  });
});