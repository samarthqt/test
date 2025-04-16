class RoadsidePage {
  constructor() {
    this.assistanceMenu = '#assistanceMenu';
    this.roadsideAssistanceOption = '#roadsideAssistanceOption';
    this.contactDetailsInput = '#contactDetails';
    this.locationInput = '#location';
    this.submitDetailsButton = '#submitDetails';
    this.callAssistanceButton = '#callAssistance';
    this.map = '#serviceVehicleMap';
    this.cancelRequestButton = '#cancelRequest';
    this.notifications = '#notifications';
    this.feedbackButton = '#feedback';
  }

  login(username, password) {
    cy.get('#username').type(username);
    cy.get('#password').type(password);
    cy.get('#loginButton').click();
  }

  simulateOffline() {
    cy.intercept('POST', '**/assistance', { forceNetworkError: true });
  }

  simulateVehicleIssue() {
    cy.intercept('GET', '**/vehicleLocation', { fixture: 'vehicleIssue.json' });
  }

  setLocation(region) {
    cy.intercept('GET', '**/location', { fixture: `${region}.json` });
  }

  checkDeviceCompatibility() {
    cy.viewport('iphone-x');
    cy.visit('/');
    cy.viewport('ipad-2');
    cy.visit('/');
    cy.viewport('macbook-15');
    cy.visit('/');
  }
}