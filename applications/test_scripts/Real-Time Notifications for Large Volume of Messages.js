describe('Real-Time Notifications for Large Volume of Messages', () => {
  const messageIds = ['12345', '12346', '12347'];
  const userId = '67890';

  before(() => {
    cy.login(userId); // Custom command to log in the user
  });

  it('should send a large volume of messages and receive notifications', () => {
    messageIds.forEach(id => {
      cy.sendMessage(id, userId); // Custom command to send a message
    });
    cy.getNotificationCenter().should('have.length', messageIds.length);
  });

  it('should verify the notification center displays all notifications with correct details', () => {
    cy.getNotificationCenter().each((notification, index) => {
      cy.wrap(notification).should('contain.text', messageIds[index]);
    });
  });

  it('should check system performance metrics', () => {
    cy.checkPerformanceMetrics().should(metrics => {
      expect(metrics.delays).to.be.lessThan(1000);
    });
  });

  it('should open multiple notifications simultaneously and redirect correctly', () => {
    cy.getNotificationCenter().each(notification => {
      cy.wrap(notification).click();
      cy.url().should('include', '/message/');
    });
  });

  it('should verify message content for each notification', () => {
    cy.getNotificationCenter().each((notification, index) => {
      cy.wrap(notification).click();
      cy.getMessageContent().should('contain.text', `Message content for ID: ${messageIds[index]}`);
    });
  });
});