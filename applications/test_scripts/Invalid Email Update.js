describe('Profile Update - Invalid Email Test', () => {
  before(() => {
    cy.login('validUser', 'validPassword'); // Assuming a custom command for login
  });

  it('should display an error for invalid email format', () => {
    const profilePage = new ProfilePage();
    profilePage.visitProfile();
    profilePage.updateEmail('johndoe.com');
    profilePage.submitChanges();
    profilePage.getEmailErrorMessage().should('contain', 'The email format is invalid');
  });
});