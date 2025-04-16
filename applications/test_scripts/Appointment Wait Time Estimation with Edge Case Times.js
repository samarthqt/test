describe('Appointment Wait Time Estimation', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const waitTimeEstimationPage = new WaitTimeEstimationPage();

  before(() => {
    cy.visit('/');
  });

  it('should log in and estimate wait times for morning and evening appointments', () => {
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboard();

    dashboardPage.navigateToWaitTimeEstimation();
    waitTimeEstimationPage.verifyWaitTimeEstimationScreen();

    waitTimeEstimationPage.searchPatient('45678');
    waitTimeEstimationPage.selectAppointment('APT2001');
    waitTimeEstimationPage.estimateWaitTime();
    waitTimeEstimationPage.verifyEstimatedWaitTime('15 minutes');

    waitTimeEstimationPage.searchPatient('45679');
    waitTimeEstimationPage.selectAppointment('APT2002');
    waitTimeEstimationPage.estimateWaitTime();
    waitTimeEstimationPage.verifyEstimatedWaitTime('15 minutes');

    dashboardPage.logOut();
  });
});