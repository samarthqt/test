describe('Live Tracking for Shipments', () => {
  const shipmentId = '54321';
  const userId = '09876';
  const trackingPage = new LiveTrackingPage();

  before(() => {
    cy.login(userId);
  });

  it('should navigate to the live tracking page', () => {
    trackingPage.navigate();
    trackingPage.verifyPageDisplayed();
  });

  it('should enter shipment ID and display tracking details', () => {
    trackingPage.enterShipmentId(shipmentId);
    trackingPage.verifyTrackingDetailsDisplayed(shipmentId);
  });

  it('should check current location of the shipment', () => {
    trackingPage.verifyCurrentLocationDisplayed();
  });

  it('should simulate a change in shipment location', () => {
    trackingPage.simulateLocationChange();
    trackingPage.verifyLocationUpdatesRealTime();
  });

  it('should verify the estimated delivery time', () => {
    trackingPage.verifyEstimatedDeliveryTime();
  });

  it('should refresh the page and verify tracking information consistency', () => {
    trackingPage.refreshPage();
    trackingPage.verifyTrackingInfoConsistency();
  });

  it('should log out and log back in, verifying tracking information availability', () => {
    cy.logout();
    cy.login(userId);
    trackingPage.verifyTrackingInfoAvailability();
  });

  it('should check notification settings for live tracking updates', () => {
    trackingPage.verifyNotificationSettings();
  });

  it('should simulate network issue and verify graceful handling', () => {
    trackingPage.simulateNetworkIssue();
    trackingPage.verifyNetworkIssueHandling();
  });

  it('should verify tracking history log', () => {
    trackingPage.verifyTrackingHistoryLog();
  });

  it('should check for error messages during location updates', () => {
    trackingPage.verifyNoErrorMessages();
  });

  it('should attempt location update from a different device', () => {
    trackingPage.verifyLocationUpdateSyncAcrossDevices();
  });

  it('should verify live tracking on a mobile device', () => {
    trackingPage.verifyTrackingConsistencyMobile();
  });

  it('should check live tracking after system reboot', () => {
    trackingPage.verifyTrackingInfoPostReboot();
  });

  it('should verify accuracy of the live tracking system', () => {
    trackingPage.verifyTrackingAccuracy();
  });
});