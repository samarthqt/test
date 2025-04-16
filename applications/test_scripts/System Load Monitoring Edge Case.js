describe('System Load Monitoring Edge Case', () => {
  const dashboard = new DashboardPage();

  before(() => {
    cy.visit('/login');
    dashboard.login('admin', 'adminpassword');
  });

  it('should set load threshold to 80%', () => {
    dashboard.setLoadThreshold(80);
    dashboard.verifyThresholdSet(80);
  });

  it('should simulate system load of 80%', () => {
    dashboard.simulateSystemLoad(80);
    dashboard.verifyCurrentLoad(80);
  });

  it('should trigger alert when load meets threshold', () => {
    dashboard.checkForAlerts();
    dashboard.verifyAlertTriggered();
  });

  it('should review alert details', () => {
    dashboard.reviewAlertDetails();
    dashboard.verifyAlertDetails();
  });

  after(() => {
    dashboard.logout();
  });
});