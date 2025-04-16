describe('Real-Time Notifications for New Messages', () => {
  beforeEach(() => {
    cy.login('user@example.com', 'password123'); // Custom command for logging in
  });

  it('should receive a notification for a new message', () => {
    // Simulate sending a new message
    cy.sendMessage('67890', 'Hello, this is a test message', '12345');

    // Verify notification appears
    cy.get(NotificationPage.notificationCenter)
      .should('contain', 'Hello, this is a test message')
      .and('contain', '12345');

    // Check the timestamp
    cy.get(NotificationPage.notificationTimestamp)
      .should('have.text', new Date().toLocaleTimeString());

    // Open the notification
    cy.get(NotificationPage.notificationItem).click();

    // Verify redirection to the message screen
    cy.url().should('include', '/messages/12345');

    // Verify the message content
    cy.get(MessagePage.messageContent)
      .should('have.text', 'Hello, this is a test message');
  });
});