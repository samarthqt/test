describe('Real-Time Shipment Status Updates', () => {
  const shipmentId = '12345';
  const userId = '67890';

  beforeEach(() => {
    cy.login(userId); // Custom command to log in
    cy.visit('/shipment-tracking');
  });

  it('should display shipment details for a valid shipment ID', () => {
    cy.get('#trackingField').type(shipmentId);
    cy.get('#trackButton').click();
    cy.get('#shipmentDetails').should('contain', shipmentId);
  });

  it('should update status to Out for Delivery in real-time', () => {
    cy.simulateStatusUpdate(shipmentId, 'Out for Delivery');
    cy.get('#shipmentStatus').should('contain', 'Out for Delivery');
  });

  it('should update status to Delivered in real-time', () => {
    cy.simulateStatusUpdate(shipmentId, 'Delivered');
    cy.get('#shipmentStatus').should('contain', 'Delivered');
  });

  it('should verify the timestamp of the latest status update', () => {
    cy.get('#statusTimestamp').should('contain', new Date().toLocaleString());
  });

  it('should maintain status after page refresh', () => {
    cy.reload();
    cy.get('#shipmentStatus').should('contain', 'Delivered');
  });

  it('should maintain status after logout and login', () => {
    cy.logout();
    cy.login(userId);
    cy.visit('/shipment-tracking');
    cy.get('#trackingField').type(shipmentId);
    cy.get('#trackButton').click();
    cy.get('#shipmentStatus').should('contain', 'Delivered');
  });

  it('should have notifications enabled for real-time updates', () => {
    cy.get('#notificationSettings').should('be.checked');
  });

  it('should handle network issues gracefully during status updates', () => {
    cy.simulateNetworkIssue();
    cy.simulateStatusUpdate(shipmentId, 'In Transit');
    cy.get('#shipmentStatus').should('contain', 'In Transit');
  });

  it('should verify shipment history log contains all updates', () => {
    cy.get('#historyLog').should('contain', 'Out for Delivery')
                         .and('contain', 'Delivered');
  });

  it('should not display error messages during status updates', () => {
    cy.get('#errorMessages').should('not.exist');
  });

  it('should synchronize status updates across devices', () => {
    cy.simulateStatusUpdateFromDifferentDevice(shipmentId, 'In Transit');
    cy.get('#shipmentStatus').should('contain', 'In Transit');
  });

  it('should verify shipment status on a mobile device', () => {
    cy.viewport('iphone-x');
    cy.visit('/shipment-tracking');
    cy.get('#trackingField').type(shipmentId);
    cy.get('#trackButton').click();
    cy.get('#shipmentStatus').should('contain', 'Delivered');
  });

  it('should maintain shipment status after a system reboot', () => {
    cy.systemReboot(); // Custom command to simulate reboot
    cy.visit('/shipment-tracking');
    cy.get('#trackingField').type(shipmentId);
    cy.get('#trackButton').click();
    cy.get('#shipmentStatus').should('contain', 'Delivered');
  });
});