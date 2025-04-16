describe('High-Risk Patient Health Alerts', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const healthAlertsPage = new HealthAlertsPage();
  const patientDetailsPage = new PatientDetailsPage();

  beforeEach(() => {
    cy.visit('/login');
  });

  it('should ensure high-risk patients receive real-time notifications', () => {
    // Step 1: Log in as a healthcare provider
    loginPage.login('providerUsername', 'providerPassword');
    dashboardPage.verifyDashboardDisplayed();

    // Step 2: Navigate to the 'Health Alerts' section
    dashboardPage.goToHealthAlerts();
    healthAlertsPage.verifyHealthAlertsPageDisplayed();

    // Step 3: Select 'High-Risk Patients' from the alert category
    healthAlertsPage.selectAlertCategory('High-Risk Patients');
    healthAlertsPage.verifyHighRiskPatientsListDisplayed();

    // Step 4: Choose patient with ID HR12345
    healthAlertsPage.selectPatientById('HR12345');
    patientDetailsPage.verifyPatientDetailsDisplayed();

    // Step 5: Verify that notification preferences are set to SMS
    patientDetailsPage.verifyNotificationMethod('SMS');

    // Step 6: Simulate health alert trigger for 'Heart Attack' condition
    patientDetailsPage.simulateHealthAlert('Heart Attack');
    patientDetailsPage.verifySmsNotificationSent();

    // Step 7: Check patient notification history
    patientDetailsPage.verifyNotificationLogged();
  });
});