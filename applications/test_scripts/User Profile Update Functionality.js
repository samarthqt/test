describe('User Profile Update Functionality', () => {
  before(() => {
    cy.login('username', 'password');
  });

  it('should update user profile details successfully', () => {
    const userProfilePage = new UserProfilePage();

    userProfilePage.navigateToUserProfile();
    userProfilePage.verifyUserProfilePageDisplayed();
    userProfilePage.clickEditProfile();
    userProfilePage.updateEmail('newemail@example.com');
    userProfilePage.updatePhoneNumber('123-456-7890');
    userProfilePage.updateAddress('123 New Street, New City, NC');
    userProfilePage.saveChanges();
    userProfilePage.verifyProfileUpdated();

    cy.reload();
    userProfilePage.verifyUpdatedProfileDetails();

    cy.logout();
    cy.login('username', 'password');
    userProfilePage.verifyLoginSuccess();
  });
});