describe('Custom Vehicle Profiles - Input Validation', () => {
  const profilePage = new ProfilePage();

  beforeEach(() => {
    cy.visit('/user-management');
  });

  it('should prompt for a valid driver's name when the field is empty', () => {
    profilePage.navigateToCreateProfile();
    profilePage.submitProfileForm();
    profilePage.getDriverNameError().should('contain', 'Please enter a valid driver's name');
  });

  it('should display an error for invalid seat position', () => {
    profilePage.navigateToCreateProfile();
    profilePage.enterSeatPosition('Invalid');
    profilePage.submitProfileForm();
    profilePage.getSeatPositionError().should('contain', 'Seat position is invalid');
  });

  it('should not accept special characters in driver's name', () => {
    profilePage.navigateToCreateProfile();
    profilePage.enterDriverName('@#$%');
    profilePage.submitProfileForm();
    profilePage.getDriverNameError().should('contain', 'Special characters are not allowed');
  });

  it('should prompt for valid driver's name format when numerical value is entered', () => {
    profilePage.navigateToCreateProfile();
    profilePage.enterDriverName('12345');
    profilePage.submitProfileForm();
    profilePage.getDriverNameError().should('contain', 'Please enter a valid driver's name');
  });

  it('should display a message for duplicate driver profiles', () => {
    profilePage.navigateToCreateProfile();
    profilePage.enterDriverName('Existing Driver');
    profilePage.submitProfileForm();
    profilePage.getProfileExistsError().should('contain', 'Profile already exists');
  });

  it('should prevent profile update with invalid data', () => {
    profilePage.navigateToProfileDetails('Existing Driver');
    profilePage.enterDriverName('Invalid Name!');
    profilePage.updateProfile();
    profilePage.getUpdateError().should('contain', 'Please enter valid data');
  });

  it('should prompt for confirmation before deleting a profile', () => {
    profilePage.navigateToProfileDetails('Existing Driver');
    profilePage.deleteProfile();
    profilePage.getDeleteConfirmation().should('be.visible');
  });

  it('should truncate or prompt for long driver's name', () => {
    profilePage.navigateToCreateProfile();
    profilePage.enterDriverName('VeryLongDriverNameExceedingLimit');
    profilePage.submitProfileForm();
    profilePage.getDriverNameError().should('contain', 'Please shorten the driver's name');
  });

  it('should handle abrupt closure gracefully', () => {
    profilePage.navigateToCreateProfile();
    cy.window().then(win => win.close());
    cy.visit('/user-management');
    profilePage.verifyGracefulClosure();
  });

  it('should retain and display previous input validation messages', () => {
    profilePage.navigateToCreateProfile();
    profilePage.enterDriverName('12345');
    profilePage.submitProfileForm();
    cy.reload();
    profilePage.getDriverNameError().should('contain', 'Please enter a valid driver's name');
  });

  it('should logout successfully without errors', () => {
    profilePage.logout();
    cy.url().should('contain', '/login');
  });

  it('should display message for non-existing driver profile creation', () => {
    profilePage.navigateToCreateProfile();
    profilePage.enterDriverName('NonExisting Driver');
    profilePage.submitProfileForm();
    profilePage.getDriverNotExistError().should('contain', 'Driver does not exist');
  });
});