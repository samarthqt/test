class AppStorePage {
  visit() {
    cy.visit('app-store-url');
  }

  searchApp(appName) {
    cy.get('#search-bar').type(appName);
    cy.get('#search-button').click();
  }

  selectApp() {
    cy.get('.search-results').contains('App Name').click();
  }
}

class AppPage {
  downloadApp() {
    cy.get('#download-button').click();
  }

  openApp() {
    cy.get('#open-app-button').click();
  }
}

class RegistrationPage {
  register(email, password) {
    cy.get('#register-button').click();
    cy.get('#email-input').type(email);
    cy.get('#password-input').type(password);
    cy.get('#submit-button').click();
  }
}

module.exports = { AppStorePage, AppPage, RegistrationPage };