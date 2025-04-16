describe('Real-Time Performance Monitoring', () => {
  const dashboard = new DashboardPage();
  const notifications = new NotificationsPage();

  beforeEach(() => {
    cy.visit('/dashboard');
  });

  it('Access the system performance monitoring dashboard', () => {
    dashboard.verifyResourceUsage({ cpu: '75%', memory: '60%', disk: '70%', network: '65%' });
  });

  it('Simulate high CPU usage and check notifications', () => {
    dashboard.simulateHighCpuUsage();
    dashboard.verifyCpuUsage('> 80%');
    notifications.verifyNotification('High CPU Usage');
  });

  it('Repeat process for memory, disk, and network usage', () => {
    dashboard.simulateHighMemoryUsage();
    notifications.verifyNotification('High Memory Usage');
    dashboard.simulateHighDiskUsage();
    notifications.verifyNotification('High Disk Usage');
    dashboard.simulateHighNetworkUsage();
    notifications.verifyNotification('High Network Usage');
  });

  it('Verify all notifications are logged', () => {
    notifications.verifyAllNotificationsLogged();
  });

  it('Test notification settings by changing alert thresholds', () => {
    notifications.changeAlertThresholds();
    notifications.verifyNotificationSettings();
  });

  it('Simulate normal resource usage and ensure no notifications', () => {
    dashboard.simulateNormalUsage();
    notifications.verifyNoNotifications();
  });

  it('Access historical performance data for analysis', () => {
    dashboard.accessHistoricalData();
  });

  it('Verify system response time under high load', () => {
    dashboard.verifySystemResponseTime();
  });

  it('Check system alerts when resource usage returns to normal', () => {
    dashboard.verifyResourceUsageNormalizationAlerts();
  });

  it('Test the ability to customize notification preferences', () => {
    notifications.customizeNotificationPreferences();
  });

  it('Ensure notifications are received on all devices', () => {
    notifications.verifyNotificationsOnAllDevices();
  });

  it('Test system ability to handle multiple alerts simultaneously', () => {
    notifications.verifyMultipleAlertsHandling();
  });

  it('Verify accuracy of resource usage data on the dashboard', () => {
    dashboard.verifyResourceUsageDataAccuracy();
  });

  it('Check system logs for errors during monitoring', () => {
    dashboard.verifyNoErrorsInLogs();
  });
});