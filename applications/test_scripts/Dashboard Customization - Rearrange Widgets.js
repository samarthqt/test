describe('Dashboard Customization - Rearrange Widgets', () => {
  const dashboardPage = new DashboardPage();

  beforeEach(() => {
    cy.login();
    dashboardPage.navigateToDashboard();
  });

  it('should rearrange Sales widget', () => {
    dashboardPage.dragWidget('Sales', 'newPosition');
    dashboardPage.verifyWidgetPosition('Sales', 'newPosition');
  });

  it('should save layout after refresh', () => {
    dashboardPage.refreshPage();
    dashboardPage.verifyWidgetPosition('Sales', 'newPosition');
  });

  it('should rearrange Performance widget', () => {
    dashboardPage.dragWidget('Performance', 'newPosition');
    dashboardPage.verifyWidgetPosition('Performance', 'newPosition');
  });

  it('should move widget to an empty position', () => {
    dashboardPage.dragWidget('Notifications', 'emptyPosition');
    dashboardPage.verifyWidgetPosition('Notifications', 'emptyPosition');
  });

  it('should prevent overlapping widgets', () => {
    dashboardPage.dragWidgetOverAnother('Sales', 'Performance');
    dashboardPage.verifyErrorMessage('Overlap not allowed');
  });

  it('should rearrange widgets using touchscreen', () => {
    dashboardPage.rearrangeUsingTouchscreen('Sales', 'newPosition');
    dashboardPage.verifyWidgetPosition('Sales', 'newPosition');
  });

  it('should reflect changes across devices', () => {
    dashboardPage.verifyConsistencyAcrossDevices();
  });

  it('should retain changes after re-login', () => {
    cy.logout();
    cy.login();
    dashboardPage.verifyWidgetPosition('Sales', 'newPosition');
  });

  it('should handle unstable internet connection', () => {
    dashboardPage.simulateUnstableConnection();
    dashboardPage.verifyWidgetPosition('Sales', 'newPosition');
  });

  it('should restrict rearrangement without permissions', () => {
    dashboardPage.attemptRearrangementWithoutPermission();
    dashboardPage.verifyPermissionsError();
  });

  it('should not affect widget functionality', () => {
    dashboardPage.verifyWidgetFunctionality('Sales');
  });

  it('should maintain visual alignment', () => {
    dashboardPage.verifyNoVisualGlitches();
  });
});