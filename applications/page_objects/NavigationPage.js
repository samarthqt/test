class NavigationPage {
  navigateToNavigationModule() {
    cy.visit('/navigation');
  }

  verifyNavigationScreen() {
    cy.url().should('include', '/navigation');
    cy.get('.navigation-screen').should('be.visible');
  }

  enterStartLocation(location) {
    cy.get('#start-location').type(location);
  }

  verifyStartLocation(location) {
    cy.get('#start-location').should('have.value', location);
  }

  enterDestination(destination) {
    cy.get('#destination').type(destination);
  }

  verifyDestination(destination) {
    cy.get('#destination').should('have.value', destination);
  }

  clickGetDirections() {
    cy.get('#get-directions').click();
  }

  verifyRouteDisplayed() {
    cy.get('.route-display').should('be.visible');
  }

  verifyRealTimeAlerts() {
    cy.get('.alerts').should('contain', 'road closures').and('contain', 'accidents').and('contain', 'hazards');
  }

  verifyNoErrorMessages() {
    cy.get('.error-message').should('not.exist');
    cy.get('.warning-message').should('not.exist');
  }

  logout() {
    cy.get('#logout').click();
    cy.url().should('include', '/login');
  }
}

export default NavigationPage;