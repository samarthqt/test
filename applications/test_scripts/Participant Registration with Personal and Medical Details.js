describe('Participant Registration with Personal and Medical Details', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const registrationPage = new RegistrationPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in successfully', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.clickLogin();
    dashboardPage.verifyDashboardPage();
  });

  it('should register a participant successfully', () => {
    dashboardPage.navigateToRegistration();
    registrationPage.enterParticipantName('John Doe');
    registrationPage.enterDateOfBirth('01/01/1980');
    registrationPage.enterMedicalHistory('No known allergies');
    registrationPage.selectConsent('Agreed');
    registrationPage.clickSubmit();
    registrationPage.verifyConfirmationMessage();
  });

  after(() => {
    dashboardPage.logout();
  });
});