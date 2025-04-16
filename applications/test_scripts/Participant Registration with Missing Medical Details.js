describe('Participant Registration with Missing Medical Details', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const registrationPage = new RegistrationPage();

  before(() => {
    cy.visit('/login');
  });

  it('should display login page', () => {
    loginPage.verifyLoginPageDisplayed();
  });

  it('should login with valid credentials', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboardDisplayed();
  });

  it('should navigate to Participant Registration section', () => {
    dashboardPage.navigateToRegistration();
    registrationPage.verifyRegistrationFormDisplayed();
  });

  it('should enter participant details except medical history', () => {
    registrationPage.enterParticipantName('Jane Doe');
    registrationPage.enterDateOfBirth('02/02/1985');
    registrationPage.selectConsent('Agreed');
  });

  it('should submit registration and verify error message', () => {
    registrationPage.submitRegistration();
    registrationPage.verifyErrorMessage('Medical history is required');
  });

  it('should verify participant is not registered', () => {
    registrationPage.verifyParticipantNotRegistered('Jane Doe');
  });

  after(() => {
    dashboardPage.logout();
  });
});