describe('Service Downtime Notification Edge Case Test', () => {
  const downtimeIds = [222, 223, 224];
  const userId = 67890;

  before(() => {
    // Setup: Schedule multiple overlapping service downtimes
    downtimeIds.forEach((id) => {
      cy.scheduleDowntime(id);
    });
    // Ensure user is subscribed to downtime alerts
    cy.subscribeUserToDowntimeAlerts(userId);
  });

  it('should verify notifications are sent to users for each downtime', () => {
    downtimeIds.forEach((id) => {
      cy.verifyNotificationSent(userId, id);
    });
  });

  it('should check the notification center for downtime alerts', () => {
    cy.visitNotificationCenter(userId);
    downtimeIds.forEach((id) => {
      cy.verifyDowntimeNotificationDisplayed(id);
    });
  });

  it('should open each downtime notification and verify details', () => {
    downtimeIds.forEach((id) => {
      cy.openDowntimeNotification(id);
      cy.verifyDowntimeDetails(id);
    });
  });
});