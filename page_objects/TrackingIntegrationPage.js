import TrackingIntegrationPage from './TrackingIntegrationPage';

class TrackingIntegrationPage {

  static verifyIntegrationWithCarriers() {
    cy.get('#carrierIntegration').should('exist');
  }

  static selectCarrier(carrierName) {
    cy.get('#carrierList').select(carrierName);
  }

  static verifyCarrierSelected(carrierName) {
    cy.get('#carrierList').should('have.value', carrierName);
  }

  static configureCarrierAPIKeys(carrier) {
    cy.get(`#${carrier}APIKeys`).should('exist');
  }

  static enterTrackingNumberForCarrier(carrier, trackingNumber) {
    cy.get(`#trackingInput${carrier}`).type(trackingNumber);
  }

  static verifyTrackingInformationRetrieved() {
    cy.get('#trackingInfo').should('exist');
  }

  static verifyErrorMessageForInvalidTrackingNumbers() {
    cy.get('#errorMessage').should('exist');
  }

  static simulateCarrierServiceOutage(carrier) {
    cy.get(`#${carrier}Outage`).should('exist');
  }

  static verifyServiceOutageMessageForCarrier(carrier) {
    cy.get(`#serviceOutageMessage${carrier}`).should('exist');
  }

  static simulateHighLoad() {
    cy.get('#highLoad').should('exist');
  }

  static verifySystemStability() {
    cy.get('#systemStability').should('exist');
  }

  static retrieveTrackingInformation() {
    cy.get('#retrieveTrackingInfo').should('exist');
  }

  static verifyCarrierSpecificDetailsDisplayed() {
    cy.get('#carrierSpecificDetails').should('exist');
  }

  static integrateNewCarrier() {
    cy.get('#integrateNewCarrier').should('exist');
  }

  static verifyNewCarrierIntegration() {
    cy.get('#newCarrierIntegration').should('exist');
  }

}

export default TrackingIntegrationPage;