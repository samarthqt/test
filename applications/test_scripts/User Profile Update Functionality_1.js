describe('User Profile Update Functionality', () => {
  const userProfile = new UserProfilePage();
  beforeEach(() => {
    cy.login(); // Assume cy.login() logs in the user
    userProfile.navigateToProfile();
  });

  it('should update profile details successfully', () => {
    userProfile.clickEditProfile();
    userProfile.updateEmail('new_email@example.com');
    userProfile.updatePhone('1234567890');
    userProfile.selectPreference('Weekly newsletter');
    userProfile.saveChanges();
    userProfile.verifyUpdatedDetails('new_email@example.com', '1234567890', 'Weekly newsletter');
  });

  it('should reflect changes immediately on profile page refresh', () => {
    cy.reload();
    userProfile.verifyUpdatedDetails('new_email@example.com', '1234567890', 'Weekly newsletter');
  });

  it('should maintain updated details after re-login', () => {
    cy.logout();
    cy.login();
    userProfile.verifyUpdatedDetails('new_email@example.com', '1234567890', 'Weekly newsletter');
  });

  it('should show error for invalid email format', () => {
    userProfile.clickEditProfile();
    userProfile.updateEmail('invalid-email');
    userProfile.saveChanges();
    userProfile.verifyErrorMessage('Invalid email format');
  });

  it('should show error for invalid phone number format', () => {
    userProfile.clickEditProfile();
    userProfile.updatePhone('invalid-phone');
    userProfile.saveChanges();
    userProfile.verifyErrorMessage('Invalid phone number format');
  });

  it('should show error for unsupported preferences', () => {
    userProfile.clickEditProfile();
    userProfile.selectPreference('Unsupported option');
    userProfile.saveChanges();
    userProfile.verifyErrorMessage('Unsupported preference');
  });
});