describe('Custom Vehicle Profiles - Create and Manage Profiles', () => {
  const userManagementPage = new UserManagementPage();

  before(() => {
    cy.visit('/');
  });

  it('should create a new profile', () => {
    userManagementPage.navigateToCreateProfile();
    userManagementPage.enterDriverName('John Doe');
    userManagementPage.setSeatPosition('1');
    userManagementPage.setMirrorAngle('2');
    userManagementPage.submitProfile();
    userManagementPage.verifyProfileCreation();
  });

  it('should verify created profile details', () => {
    userManagementPage.navigateToViewProfiles();
    userManagementPage.verifyDriverName('John Doe');
    userManagementPage.verifySeatPosition('1');
    userManagementPage.verifyMirrorAngle('2');
  });

  it('should update the profile seat position', () => {
    userManagementPage.navigateToUpdateProfile();
    userManagementPage.updateSeatPosition('3');
    userManagementPage.submitUpdatedProfile();
    userManagementPage.verifyProfileUpdate();
  });

  it('should verify updated profile details', () => {
    userManagementPage.navigateToViewProfiles();
    userManagementPage.verifySeatPosition('3');
  });

  after(() => {
    userManagementPage.logout();
  });
});