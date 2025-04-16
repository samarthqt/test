describe('Profile Picture Upload Edge Case', () => {
  before(() => {
    cy.login('user', 'password');
  });

  it('should display an error when uploading a large profile picture', () => {
    const profilePage = new ProfilePage();
    profilePage.visit();
    profilePage.uploadProfilePicture('large_profile_pic.jpg');
    profilePage.getUploadError().should('contain', 'File size limit exceeded');
  });
});