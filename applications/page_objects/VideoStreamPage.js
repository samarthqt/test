class VideoStreamPage {
  constructor() {
    this.videoElement = 'video#stream';
  }

  accessVideoStream() {
    cy.get(this.videoElement).click();
  }

  refreshVideoStream() {
    cy.reload();
  }
}

Cypress.Commands.add('simulateHighTraffic', () => {
  // Custom command to simulate high traffic conditions
  cy.log('Simulating high traffic conditions');
});

Cypress.Commands.add('setGeolocation', (city, country) => {
  // Custom command to set the geolocation
  cy.log(`Setting geolocation to ${city}, ${country}`);
});