describe('User Profile Editing Functionality', () => {
  beforeEach(() => {
    cy.visit('/login');
    cy.login('validUsername', 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should allow user to edit profile information', () => {
    const profilePage = new ProfilePage();
    profilePage.navigateToProfile();
    profilePage.clickEditProfile();

    profilePage.updateName('New Name');
    profilePage.saveChanges();
    profilePage.verifyUpdatedName('New Name');

    profilePage.updateEmail('newemail@example.com');
    profilePage.saveChanges();
    profilePage.verifyUpdatedEmail('newemail@example.com');

    profilePage.updatePhoneNumber('1234567890');
    profilePage.saveChanges();
    profilePage.verifyUpdatedPhoneNumber('1234567890');

    profilePage.uploadProfilePicture('path/to/newProfilePic.jpg');
    profilePage.verifyProfilePictureUpdated();

    profilePage.updateAddress('123 New St', 'New City', '12345');
    profilePage.saveChanges();
    profilePage.verifyUpdatedAddress('123 New St', 'New City', '12345');

    profilePage.verifyAllChangesPersist();
  });

  it('should validate incorrect email format', () => {
    const profilePage = new ProfilePage();
    profilePage.navigateToProfile();
    profilePage.clickEditProfile();

    profilePage.updateEmail('invalidEmail');
    profilePage.saveChanges();
    profilePage.verifyEmailFormatError();
  });

  it('should prompt for required fields', () => {
    const profilePage = new ProfilePage();
    profilePage.navigateToProfile();
    profilePage.clickEditProfile();

    profilePage.clearRequiredFields();
    profilePage.saveChanges();
    profilePage.verifyRequiredFieldsError();
  });

  it('should handle unsupported file formats for profile picture', () => {
    const profilePage = new ProfilePage();
    profilePage.navigateToProfile();
    profilePage.clickEditProfile();

    profilePage.uploadProfilePicture('path/to/unsupportedFile.txt');
    profilePage.verifyUnsupportedFileError();
  });

  it('should be responsive', () => {
    cy.viewport('iphone-6');
    const profilePage = new ProfilePage();
    profilePage.navigateToProfile();
    profilePage.verifyResponsiveLayout();
  });

  it('should handle errors gracefully during save attempts', () => {
    const profilePage = new ProfilePage();
    profilePage.navigateToProfile();
    profilePage.clickEditProfile();

    profilePage.simulateFailedSave();
    profilePage.verifyErrorHandling();
  });

  afterEach(() => {
    cy.logout();
    cy.login('validUsername', 'validPassword');
    cy.url().should('include', '/dashboard');
    const profilePage = new ProfilePage();
    profilePage.navigateToProfile();
    profilePage.verifyAllChangesPersist();
  });
});