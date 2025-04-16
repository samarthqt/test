describe('Receive Vehicle Recall Notification', () => {
  const vehicleVIN = '1HGCM82633A004352';
  const deviceID = '123456789';

  before(() => {
    // Ensure the vehicle is marked for recall in the system
    cy.markVehicleForRecall(vehicleVIN);
  });

  it('should trigger the recall notification process', () => {
    // Trigger the recall notification
    cy.triggerRecallNotification(vehicleVIN);
  });

  it('should receive a push notification on the user's device', () => {
    // Check if the push notification is received
    cy.checkPushNotification(deviceID).should('contain', 'Vehicle recall notification for VIN: ' + vehicleVIN);
  });
});