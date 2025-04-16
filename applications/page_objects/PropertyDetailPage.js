class PropertyDetailPage {
  static get requestInfoButton() {
    return '#request-info-btn';
  }
}

class RequestFormPage {
  static get requestTypeSelect() {
    return '#request-type';
  }

  static get requestDetailsInput() {
    return '#request-details';
  }

  static get submitButton() {
    return '#submit-request';
  }

  static get confirmationMessage() {
    return '#confirmation-message';
  }

  static get errorMessage() {
    return '#error-message';
  }
}

class LoginPage {
  static get loginPrompt() {
    return '#login-prompt';
  }
}

Cypress.Commands.add('login', (userId) => {
  // Custom command to log in a user
  cy.visit('/login');
  cy.get('#username').type(userId);
  cy.get('#password').type('password');
  cy.get('#login-button').click();
});

Cypress.Commands.add('logout', () => {
  // Custom command to log out a user
  cy.get('#logout-button').click();
});

Cypress.Commands.add('checkAdminNotification', (propertyId, userId) => {
  // Custom command to check admin notification
  cy.request(`/admin/notifications?propertyId=${propertyId}&userId=${userId}`)
    .its('body')
    .should('contain', 'New request for property');
});

Cypress.Commands.add('verifyRequestStatus', (userId, propertyId, status) => {
  // Custom command to verify request status
  cy.visit(`/user/${userId}/requests`);
  cy.get(`#request-status-${propertyId}`).should('contain', status);
});

Cypress.Commands.add('checkEmailConfirmation', (userId, propertyId) => {
  // Custom command to check email confirmation
  cy.request(`/email/confirmations?userId=${userId}&propertyId=${propertyId}`)
    .its('body')
    .should('contain', 'Your request has been submitted');
});