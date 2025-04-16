describe('User Profile Management - Invalid Email Update', () => {
  const userProfilePage = new UserProfilePage();

  beforeEach(() => {
    // Assuming user is already logged in
    cy.visit('/user-profile');
  });

  it('should prevent updating profile with invalid email', () => {
    userProfilePage.enterEmail('invalid-email-format');
    userProfilePage.clickSaveChanges();
    userProfilePage.getEmailField().should('have.class', 'invalid');
    userProfilePage.getErrorMessage().should('contain', 'invalid email format');
  });
});