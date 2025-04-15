describe('Real-Time Shipment Status Updates', () => {
  const shipmentID = '12345';
  const userID = '67890';

  before(() => {
    cy.login(userID);
  });

  it('should navigate to the shipment tracking page', () => {
    cy.visit('/shipment-tracking');
    cy.url().should('include', '/shipment-tracking');
  });

  it('should enter the Shipment ID and display shipment details', () => {
    cy.get(ShipmentTrackingPage.trackingField).type(shipmentID);
    cy.get(ShipmentTrackingPage.submitButton).click();
    cy.get(ShipmentTrackingPage.shipmentDetails).should('contain', shipmentID);
  });

  it('should check the current status of the shipment', () => {
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'In Transit');
  });

  it('should simulate status update to Out for Delivery', () => {
    cy.simulateStatusUpdate(shipmentID, 'Out for Delivery');
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'Out for Delivery');
  });

  it('should simulate status update to Delivered', () => {
    cy.simulateStatusUpdate(shipmentID, 'Delivered');
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'Delivered');
  });

  it('should verify the timestamp of the latest status update', () => {
    cy.get(ShipmentTrackingPage.timestamp).should('contain', new Date().toLocaleTimeString());
  });

  it('should refresh the page and verify status remains Delivered', () => {
    cy.reload();
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'Delivered');
  });

  it('should log out and log back in, status remains Delivered', () => {
    cy.logout();
    cy.login(userID);
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'Delivered');
  });

  it('should check notification settings for shipment updates', () => {
    cy.get(ShipmentTrackingPage.notificationSettings).should('be.checked');
  });

  it('should simulate network issue and attempt to update status', () => {
    cy.simulateNetworkIssue();
    cy.simulateStatusUpdate(shipmentID, 'Delivered');
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'Delivered');
  });

  it('should verify the shipment history log', () => {
    cy.get(ShipmentTrackingPage.historyLog).should('contain', 'Delivered');
  });

  it('should check for any error messages during status updates', () => {
    cy.get(ShipmentTrackingPage.errorMessages).should('not.exist');
  });

  it('should attempt to update status from a different device', () => {
    cy.simulateStatusUpdateFromDifferentDevice(shipmentID, 'Delivered');
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'Delivered');
  });

  it('should verify shipment status on a mobile device', () => {
    cy.viewport('iphone-x');
    cy.visit('/shipment-tracking');
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'Delivered');
  });

  it('should check shipment status after a system reboot', () => {
    cy.systemReboot();
    cy.visit('/shipment-tracking');
    cy.get(ShipmentTrackingPage.currentStatus).should('contain', 'Delivered');
  });
});