describe('Real-Time Notifications for System Events', () => {
  const notificationCenter = new NotificationCenter();
  const systemEvent = new SystemEvent();

  before(() => {
    // Setup: Ensure user is subscribed to system alerts
    cy.login('user_id_67890');
    cy.subscribeToSystemAlerts();
  });

  it('should trigger a system event and receive a notification', () => {
    systemEvent.triggerEvent('54321');
    notificationCenter.verifyNotificationReceived('54321');
  });

  it('should verify the notification appears in the notification center', () => {
    notificationCenter.open();
    notificationCenter.verifyNotificationDetails('54321', 'High');
  });

  it('should check the timestamp of the notification', () => {
    notificationCenter.verifyNotificationTimestamp('54321');
  });

  it('should open the notification and redirect to event details', () => {
    notificationCenter.openNotification('54321');
    systemEvent.verifyEventDetailsScreen('54321');
  });

  it('should verify the event details match the triggered event', () => {
    systemEvent.verifyEventDetails('54321');
  });
});