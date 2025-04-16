describe('User Profile Update', () => {
  const profilePage = new ProfilePage();

  before(() => {
    cy.login();
  });

  it('should update user profile information', () => {
    profilePage.navigateToProfileManagement();
    profilePage.verifyCurrentProfileInformation();
    profilePage.updateName('John Doe');
    profilePage.verifyNameUpdated('John Doe');
    profilePage.updateEmail('john.doe@example.com');
    profilePage.verifyEmailUpdated('john.doe@example.com');
    profilePage.uploadProfilePicture('profile_pic.jpg');
    profilePage.verifyProfilePictureUpdated('profile_pic.jpg');
    profilePage.updatePhoneNumber('+9876543210');
    profilePage.verifyPhoneNumberUpdated('+9876543210');
    profilePage.saveChanges();
    profilePage.verifyChangesSaved();
  });
});