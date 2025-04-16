class AdminPage {
  navigateToAdminPanel() {
    cy.visit('/admin');
  }

  triggerScheduledMaintenanceNotification() {
    this.navigateToAdminPanel();
    cy.get('#trigger-maintenance').click();
  }
}

class UserPage {
  navigateToUserProfile() {
    cy.visit('/user/profile');
  }

  verifyEmailIsRegistered() {
    cy.get('#email-status').should('contain', 'Registered');
  }

  verifyEmailNotificationsEnabled() {
    cy.get('#email-notifications').should('be.checked');
  }
}

Cypress.Commands.add('checkEmailInbox', (expectedMessage) => {
  // Custom command to check email inbox for a specific message
  cy.get('#email-inbox').should('contain', expectedMessage);
});