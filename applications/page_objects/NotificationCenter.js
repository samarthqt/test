class NotificationCenter {
  open() {
    cy.get('#notification-center').click();
  }

  verifyNotificationReceived(eventId) {
    cy.get(`#notification-${eventId}`).should('be.visible');
  }

  verifyNotificationDetails(eventId, priority) {
    cy.get(`#notification-${eventId}`).within(() => {
      cy.get('.event-id').should('contain', eventId);
      cy.get('.priority').should('contain', priority);
    });
  }

  verifyNotificationTimestamp(eventId) {
    cy.get(`#notification-${eventId} .timestamp`).then(($timestamp) => {
      const eventTimestamp = systemEvent.getEventTimestamp(eventId);
      expect($timestamp.text()).to.equal(eventTimestamp);
    });
  }

  openNotification(eventId) {
    cy.get(`#notification-${eventId}`).click();
  }
}

class SystemEvent {
  triggerEvent(eventId) {
    cy.request('POST', '/api/trigger-event', { eventId });
  }

  getEventTimestamp(eventId) {
    // Assume this function retrieves the correct timestamp from a database or API
    return '2023-10-01T12:00:00Z';
  }

  verifyEventDetailsScreen(eventId) {
    cy.url().should('contain', `/event-details/${eventId}`);
  }

  verifyEventDetails(eventId) {
    cy.get('.event-details').within(() => {
      cy.get('.event-id').should('contain', eventId);
      // Additional checks for event details can be added here
    });
  }
}