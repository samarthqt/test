describe('Health Alerts with Invalid Notification Method', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const healthAlertsPage = new HealthAlertsPage();

  before(() => {
    cy.visit('/login');
  });

  it('should log in as a healthcare provider', () => {
    loginPage.enterUsername('validUsername');
    loginPage.enterPassword('validPassword');
    loginPage.submit();
    dashboardPage.verifyDashboardPage();
  });

  it('should navigate to Health Alerts section', () => {
    dashboardPage.navigateToHealthAlerts();
    healthAlertsPage.verifyHealthAlertsPage();
  });

  it('should select High-Risk Patients and choose patient HR12345', () => {
    healthAlertsPage.selectHighRiskPatients();
    healthAlertsPage.selectPatientById('HR12345');
    healthAlertsPage.verifyPatientDetails('HR12345');
  });

  it('should attempt to set notification method as InvalidMethod', () => {
    healthAlertsPage.setNotificationMethod('InvalidMethod');
    healthAlertsPage.verifyErrorMessage('Invalid notification method selected.');
  });

  it('should attempt to trigger health alert for Stroke condition', () => {
    healthAlertsPage.triggerHealthAlert('Stroke');
    healthAlertsPage.verifyNoNotificationSent();
  });
});