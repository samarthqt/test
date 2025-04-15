class SessionPage {
  login() {
    cy.visit('/login');
    cy.get('#username').type('user');
    cy.get('#password').type('password');
    cy.get('#login-button').click();
    cy.url().should('include', '/dashboard');
  }

  waitForInactivity() {
    cy.wait(600000); // Wait for 10 minutes
  }

  verifyLoggedOut() {
    cy.url().should('include', '/login');
  }

  simulateInactivity() {
    cy.wait(5000); // Simulate inactivity
  }

  checkSessionTimeoutWarning() {
    cy.get('.timeout-warning').should('be.visible');
  }

  verifyWarningNotification() {
    cy.get('.notification').should('contain', 'Your session is about to expire');
  }

  performActivity() {
    cy.get('#activity').click();
  }

  verifySessionReset() {
    cy.get('.session-timeout').should('not.exist');
  }

  checkSessionTimeout() {
    cy.wait(600000); // Wait for session timeout
  }

  verifyRedirectToLogin() {
    cy.url().should('include', '/login');
  }

  accessSessionSettings() {
    cy.visit('/admin/settings');
  }

  adjustSessionTimeout() {
    cy.get('#session-timeout').clear().type('15');
    cy.get('#save-settings').click();
  }

  verifyTimeoutAdjustment() {
    cy.get('#session-timeout').should('have.value', '15');
  }

  loginMultipleDevices() {
    cy.visit('/login');
    cy.get('#username').type('user');
    cy.get('#password').type('password');
    cy.get('#login-button').click();
  }

  simulateInactivityOnDevice() {
    cy.wait(600000); // Wait for session timeout
  }

  checkDeviceSessionTimeout() {
    cy.get('.timeout-warning').should('be.visible');
  }

  verifyOtherDevicesLoggedIn() {
    cy.url().should('include', '/dashboard');
  }
}