describe('Instructor Profile Creation Failure', () => {
  const instructorManagementPage = new InstructorManagementPage();
  before(() => {
    cy.visit('/login');
    instructorManagementPage.login('username', 'password');
  });

  it('should display error messages for missing mandatory fields', () => {
    instructorManagementPage.navigateToProfileSection();
    instructorManagementPage.createNewProfile();
    instructorManagementPage.submitProfileForm();
    instructorManagementPage.verifyErrorMessages();
  });

  after(() => {
    instructorManagementPage.logout();
  });
});