import { Selector } from 'testcafe';

class TrackShipmentPage {
  constructor() {
    this.shipmentIdInput = '#shipmentIdInput';
    this.searchButton = '#searchButton';
    this.trackShipmentSection = '#trackShipmentSection';
    this.currentLocation = '#currentLocation';
    this.estimatedDeliveryTime = '#estimatedDeliveryTime';
    this.shipmentDetails = '#shipmentDetails';
    this.currentStatus = '#currentStatus';
    this.errorMessage = '#errorMessage';
    this.feedbackMessage = '#feedbackMessage';
    this.trackShipmentHeader = '#trackShipmentHeader';
  }

  navigate() {
    cy.get('#trackShipmentLink').click();
  }

  verifyTrackShipmentSectionDisplayed() {
    cy.get(this.trackShipmentSection).should('be.visible');
  }

  verifyTrackShipmentPage() {
    cy.url().should('include', '/track-shipment');
    cy.get(this.trackShipmentHeader).should('be.visible');
  }

  enterShipmentId(shipmentId) {
    cy.get(this.shipmentIdInput).type(shipmentId);
  }

  clickSearch() {
    cy.get(this.searchButton).click();
  }

  searchShipment(shipmentId) {
    this.enterShipmentId(shipmentId);
    this.clickSearch();
  }

  verifyShipmentDetails(expectedLocation, expectedDeliveryTime) {
    cy.get(this.currentLocation).should('have.text', expectedLocation);
    cy.get(this.estimatedDeliveryTime).should('have.text', expectedDeliveryTime);
  }

  verifyShipmentDetailsById(shipmentId) {
    cy.get(this.shipmentDetails).should('contain', shipmentId);
  }

  verifyCurrentStatus(expectedStatus) {
    cy.get(this.currentStatus).should('contain', expectedStatus);
  }

  verifyErrorMessage(expectedMessage) {
    cy.get(this.errorMessage).should('contain', expectedMessage);
  }

  verifySystemFeedback() {
    cy.get(this.feedbackMessage).should('exist');
    cy.get(this.feedbackMessage).should('not.contain', 'error');
  }

  checkFeedback() {
    cy.get(this.feedbackMessage).should('exist');
  }

  refreshPage() {
    cy.reload();
  }
}

export default TrackShipmentPage;