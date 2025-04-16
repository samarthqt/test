class GPSNavigationPage {
  launchApplication() {
    cy.visit('/gps-navigation');
    cy.contains('Main Navigation Screen').should('be.visible');
  }

  enterStartLocation(location) {
    cy.get('#start-location-input').type(location);
    cy.contains(location).should('be.visible');
  }

  enterDestination(destination) {
    cy.get('#destination-input').type(destination);
    cy.contains(destination).should('be.visible');
  }

  initiateRoutePlanning(trafficCondition) {
    cy.get('#traffic-condition-select').select(trafficCondition);
    cy.get('#plan-route-btn').click();
    cy.contains('Optimal Route with ETA').should('be.visible');
  }

  checkRealTimeTrafficUpdates() {
    cy.contains('Current Traffic Conditions').should('be.visible');
  }

  simulateRoadClosure() {
    cy.get('#simulate-road-closure-btn').click();
    cy.contains('Road Closure Alert').should('be.visible');
  }

  selectAlternativeRoute() {
    cy.get('#alternative-route-btn').click();
    cy.contains('New Route with Updated ETA').should('be.visible');
  }

  continueOnOriginalRoute() {
    cy.get('#continue-original-route-btn').click();
    cy.contains('Continuing on Original Route').should('be.visible');
  }

  verifyETAUpdates() {
    cy.contains('ETA Updated').should('be.visible');
  }

  reachDestination() {
    cy.contains('You Have Arrived').should('be.visible');
  }

  verifyNavigationHistory() {
    cy.get('#navigation-history-btn').click();
    cy.contains('Navigation Session Log').should('be.visible');
  }

  checkSystemErrorsOrAlerts() {
    cy.contains('No Errors or Alerts').should('be.visible');
  }

  closeApplication() {
    cy.get('#close-app-btn').click();
  }

  reopenApplication() {
    cy.visit('/gps-navigation');
    cy.contains('Main Navigation Screen').should('be.visible');
  }

  verifySavedRoutes() {
    cy.get('#saved-routes-btn').click();
    cy.contains('Previously Navigated Route').should('be.visible');
  }

  testShortestRoute() {
    cy.get('#shortest-route-btn').click();
    cy.contains('Shortest Route with ETA').should('be.visible');
  }
}