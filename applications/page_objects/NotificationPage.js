class NotificationPage {
  visit() {
    cy.visit('/notification-settings');
  }

  verifyNotificationOptionsVisible() {
    cy.get('.notification-options').should('be.visible');
  }

  ensureAllNotificationsEnabled() {
    cy.get('.notification-type').each(($el) => {
      cy.wrap($el).should('be.checked');
    });
  }

  simulateNewListingEvent(content) {
    cy.get('.simulate-event').click();
    cy.get('.event-log').should('contain', content);
  }

  simulateNetworkFailure() {
    cy.intercept('POST', '/send-notification', {
      forceNetworkError: true
    });
  }

  resendNotification() {
    cy.get('.resend-notification').click();
  }

  resolveNetworkIssue() {
    cy.intercept('POST', '/send-notification', (req) => {
      req.reply({ statusCode: 200 });
    });
  }

  openNotification() {
    cy.get('.notification-item').first().click();
  }
}

export default new NotificationPage();