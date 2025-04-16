class UserDashboard {
  visit() {
    cy.visit('/dashboard');
  }

  getCurrentBalance() {
    return cy.get('#currentBalance');
  }

  getNotifications() {
    return cy.get('#notifications');
  }

  logout() {
    cy.get('#logoutButton').click();
  }
}

class LoginPage {
  visit() {
    cy.visit('/login');
  }

  login(accountId) {
    cy.get('#accountId').type(accountId);
    cy.get('#loginButton').click();
  }
}