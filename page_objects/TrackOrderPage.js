import { should } from 'chai';
import { expect } from 'chai';

class TrackOrderPage {
  static visitTrackOrderSection() {
    cy.visit('/track-order');
  }

  static enterTrackingNumber(trackingNumber) {
    cy.get('#trackingNumberField').type(trackingNumber);
  }

  static submitTrackingRequest() {
    cy.get('#submitTrackingBtn').click();
  }

  static verifyOrderStatus() {
    cy.get('#orderStatus').should('be.visible');
  }

  static verifyEstimatedDeliveryTime() {
    cy.get('#estimatedDeliveryTime').should('be.visible');
  }

  static verifyCarrierInformation() {
    cy.get('#carrierInfo').should('be.visible');
  }

  static verifyTrackingDetailsConsistency() {
    cy.get('#trackingDetails').should('have.class', 'consistent');
  }

  static verifyRealTimeUpdates() {
    cy.get('#realTimeUpdates').should('have.class', 'updated');
  }

  static verifyInformationSecurity() {
    cy.get('#securityCheck').should('be.visible');
  }

  static verifyInterfaceEaseOfUse() {
    cy.get('#interface').should('have.class', 'easy-to-use');
  }

  static verifyPageResponsiveness() {
    cy.get('#responsiveCheck').should('be.visible');
  }

  static verifyMultipleRequestsHandling() {
    cy.get('#multipleRequests').should('not.have.class', 'error');
  }

  static verifyTrackingHistoryAccessibility() {
    cy.get('#trackingHistory').should('be.visible');
  }

  static accessTrackingInformation() {
    cy.get('#accessTrackingInfo').click();
  }

  static interactWithInterface() {
    cy.get('#interfaceInteract').click();
  }

  static loadPage() {
    cy.get('#pageLoad').should('be.visible');
  }

  static submitMultipleTrackingRequests() {
    cy.get('#submitMultipleTrackingBtn').click();
  }

  static accessTrackingHistory() {
    cy.get('#accessTrackingHistory').click();
  }
}

export default TrackOrderPage;