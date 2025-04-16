describe('User Profile Management - View and Edit Profile', () => {
  const userProfilePage = new UserProfilePage();
  const newEmail = 'updateduser@example.com';
  const newPassword = 'NewSecurePass123!';
  const newFirstName = 'UpdatedName';

  before(() => {
    cy.login('currentEmail@example.com', 'currentPassword');
  });

  it('should navigate to the user profile page', () => {
    userProfilePage.visit();
    userProfilePage.verifyPageDisplayed();
  });

  it('should display current profile details', () => {
    userProfilePage.verifyProfileDetails('currentEmail@example.com', 'CurrentName');
  });

  it('should update email, password, and first name', () => {
    userProfilePage.updateEmail(newEmail);
    userProfilePage.updatePassword(newPassword);
    userProfilePage.updateFirstName(newFirstName);
    userProfilePage.saveChanges();
    userProfilePage.verifyUpdateSuccess();
  });

  it('should log out and log back in with updated credentials', () => {
    cy.logout();
    cy.login(newEmail, newPassword);
  });

  it('should display updated profile details', () => {
    userProfilePage.visit();
    userProfilePage.verifyProfileDetails(newEmail, newFirstName);
  });
});