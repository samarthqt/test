class LoginPage {
  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('button[type=submit]').click();
  }
}

class HomePage {
  verifyHomeScreen() {
    cy.url().should('include', '/home');
  }

  goToSettings() {
    cy.get('#settings').click();
  }

  verifyNotification(message) {
    cy.get('.notification').should('contain.text', message);
  }
}

class SettingsPage {
  enableInAppNotifications() {
    cy.get('#enable-notifications').check();
  }

  verifyInAppNotificationsEnabled() {
    cy.get('#enable-notifications').should('be.checked');
  }
}

class AdminPanel {
  triggerUnplannedDowntimeNotification() {
    cy.visit('/admin');
    cy.get('#trigger-downtime').click();
  }
}