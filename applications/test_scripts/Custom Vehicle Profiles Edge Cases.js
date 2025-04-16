describe('Custom Vehicle Profiles Edge Cases', () => {
    const profilePage = new ProfilePage();

    before(() => {
        cy.visit('/');
    });

    it('should create a new profile with boundary inputs', () => {
        profilePage.navigateToCreateProfile();
        profilePage.enterDriverName('Jane Smith');
        profilePage.setSeatPosition(5);
        profilePage.setMirrorAngle(10);
        profilePage.submitProfile();
        profilePage.navigateToViewProfiles();
        profilePage.verifyDriverName('Jane Smith');
        profilePage.verifySeatPosition(5);
        profilePage.verifyMirrorAngle(10);
    });

    it('should update the seat position in the profile', () => {
        profilePage.navigateToUpdateProfile();
        profilePage.updateSeatPosition(7);
        profilePage.submitProfile();
        profilePage.navigateToViewProfiles();
        profilePage.verifySeatPosition(7);
    });

    after(() => {
        profilePage.logout();
    });
});