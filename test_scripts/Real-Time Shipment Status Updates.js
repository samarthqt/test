describe('Real-Time Shipment Status Updates', () => {
  const shipmentId = '12345';
  const userId = '67890';

  before(() => {
    cy.login(userId);
  });

  it('should navigate to the shipment tracking page', () => {
    cy.visit('/shipment-tracking');
    cy.url().should('include', '/shipment-tracking');
  });

  it('should enter Shipment ID and display shipment details', () => {
    cy.get('#trackingField').type(shipmentId);
    cy.get('#shipmentDetails').should('contain', shipmentId);
  });

  it('should check the current status of the shipment', () => {
    cy.get('#currentStatus').should('contain', 'In Transit');
  });

  it('should simulate status update to Out for Delivery', () => {
    cy.simulateStatusUpdate(shipmentId, 'Out for Delivery');
    cy.get('#currentStatus').should('contain', 'Out for Delivery');
  });

  it('should simulate status update to Delivered', () => {
    cy.simulateStatusUpdate(shipmentId, 'Delivered');
    cy.get('#currentStatus').should('contain', 'Delivered');
  });

  it('should verify the timestamp of the latest status update', () => {
    cy.get('#statusTimestamp').should('equal', Cypress.moment().format('HH:mm')); // Assuming timestamp format
  });

  it('should refresh the page and verify status remains Delivered', () => {
    cy.reload();
    cy.get('#currentStatus').should('contain', 'Delivered');
  });

  it('should log out and log back in', () => {
    cy.logout();
    cy.login(userId);
    cy.get('#currentStatus').should('contain', 'Delivered');
  });

  it('should check notification settings for shipment updates', () => {
    cy.visit('/notification-settings');
    cy.get('#realTimeUpdates').should('be.checked');
  });

  it('should simulate a network issue and attempt to update status', () => {
    cy.simulateNetworkIssue();
    cy.simulateStatusUpdate(shipmentId, 'Delivered');
    cy.get('#currentStatus').should('contain', 'Delivered');
  });

  it('should verify the shipment history log', () => {
    cy.visit('/shipment-history');
    cy.get('#historyLog').should('contain', 'Delivered');
  });

  it('should check for error messages during status updates', () => {
    cy.get('#errorMessages').should('not.exist');
  });

  it('should attempt to update status from a different device', () => {
    cy.simulateStatusUpdateFromDevice(shipmentId, 'Delivered');
    cy.get('#currentStatus').should('contain', 'Delivered');
  });

  it('should verify shipment status on a mobile device', () => {
    cy.viewport('iphone-x');
    cy.visit('/shipment-tracking');
    cy.get('#currentStatus').should('contain', 'Delivered');
  });

  it('should check shipment status after a system reboot', () => {
    cy.rebootSystem();
    cy.visit('/shipment-tracking');
    cy.get('#currentStatus').should('contain', 'Delivered');
  });
});