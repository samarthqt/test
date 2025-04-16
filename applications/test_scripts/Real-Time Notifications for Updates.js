describe('Real-Time Notifications for Updates', () => {
    beforeEach(() => {
        // Assuming the user is already logged in and subscribed to update alerts
        cy.visit('/notifications');
    });

    it('should verify users receive notifications for system updates', () => {
        // Step 1: Schedule a system update
        cy.scheduleSystemUpdate('98765');

        // Step 2: Verify the notification appears in the notification center
        cy.get(NotificationPage.notificationCenter).should('contain', 'Update ID: 98765');

        // Step 3: Check the timestamp of the notification
        cy.get(NotificationPage.notificationTimestamp).should('have.text', 'Scheduled Time');

        // Step 4: Open the notification
        cy.get(NotificationPage.openNotificationButton).click();
        cy.url().should('include', '/update-details');

        // Step 5: Verify the update details
        cy.get(UpdateDetailsPage.updateDetails).should('contain', 'Update ID: 98765');
    });
});