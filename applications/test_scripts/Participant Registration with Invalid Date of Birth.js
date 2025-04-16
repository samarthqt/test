describe('Participant Registration with Invalid Date of Birth', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const registrationPage = new RegistrationPage();

  before(() => {
    cy.visit('/login');
  });

  it('should display login page', () => {
    loginPage.verifyLoginPage();
  });

  it('should login with valid credentials', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboardPage();
  });

  it('should navigate to Participant Registration section', () => {
    dashboardPage.goToRegistrationSection();
    registrationPage.verifyRegistrationPage();
  });

  it('should handle invalid date of birth input', () => {
    registrationPage.enterParticipantName('Alice Smith');
    registrationPage.enterDateOfBirth('31/02/1980');
    registrationPage.enterMedicalHistory('No known allergies');
    registrationPage.selectConsent('Agreed');
    registrationPage.submitForm();
    registrationPage.verifyInvalidDateOfBirthError();
    registrationPage.verifyParticipantNotRegistered();
  });

  after(() => {
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});