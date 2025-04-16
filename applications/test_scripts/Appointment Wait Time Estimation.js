describe('Appointment Wait Time Estimation', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const waitTimeEstimationPage = new WaitTimeEstimationPage();

  beforeEach(() => {
    cy.visit('/');
  });

  it('should provide accurate estimated wait times for in-person appointments', () => {
    // Step 1: Log in to the Appointment Management system using valid credentials
    loginPage.login('validUsername', 'validPassword');
    dashboardPage.verifyDashboard();

    // Step 2: Navigate to the 'Wait Time Estimation' module
    dashboardPage.navigateToWaitTimeEstimation();
    waitTimeEstimationPage.verifyWaitTimeEstimationPage();

    // Step 3: Enter the Patient ID and click on 'Search'
    waitTimeEstimationPage.searchPatientById('12345');
    waitTimeEstimationPage.verifyAppointmentsRetrieved();

    // Step 4: Select Appointment ID from the list
    waitTimeEstimationPage.selectAppointmentById('APT1001');
    waitTimeEstimationPage.verifyAppointmentDetails();

    // Step 5: Click on 'Estimate Wait Time' button
    waitTimeEstimationPage.estimateWaitTime();
    waitTimeEstimationPage.verifyEstimatedWaitTime('30 minutes');

    // Step 6: Verify that the estimated wait time is displayed on the patient's dashboard
    dashboardPage.verifyEstimatedWaitTimeOnDashboard('30 minutes');

    // Step 7: Log out of the system
    dashboardPage.logout();
    loginPage.verifyLogout();
  });
});