describe('Profile Management - Update Email', () => {
  before(() => {
    // Assuming user is already logged in
    cy.visit('/profile-management');
  });

  it('should not allow updating profile with an invalid email format', () => {
    const profilePage = new ProfilePage();
    profilePage.enterEmail('invalid-email-format');
    profilePage.submitForm();
    profilePage.getEmailErrorMessage().should('contain', 'Invalid email format');
  });
});