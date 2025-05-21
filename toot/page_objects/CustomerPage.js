import { expect } from 'chai';

class CustomerPage {
  static setCustomerId(customerId) {
    cy.wrap({ customerId }).as('customerData');
  }

  static login() {
    cy.get('@customerData').then((data) => {
      cy.get('#username').type(data.customerId);
      cy.get('#password').type('validPassword');
      cy.get('#loginBtn').click();
    });
  }

  static verifyLoginSuccess() {
    cy.url().should('include', '/dashboard');
  }

  static navigateToTrackShipment() {
    cy.get('#trackShipmentNav').click();
  }

  static verifyTrackShipmentDisplayed() {
    cy.get('#trackShipmentSection').should('be.visible');
  }

  static enterShipmentId(shipmentId) {
    cy.get('#shipmentSearchBar').type(shipmentId);
    cy.get('#searchBtn').click();
  }

  static verifyInputProcessing() {
    cy.get('#processingIndicator').should('not.exist');
  }

  static verifyFeedbackForLongId() {
    cy.get('#feedbackMessage').should('be.visible');
  }

  static verifyGracefulHandling() {
    cy.get('#errorMessage').should('exist').or('#successMessage').should('exist');
  }

  static logout() {
    cy.get('#logoutBtn').click();
  }

  static verifyLogoutSuccess() {
    cy.url().should('include', '/login');
  }

  static verifyErrorMessage(message) {
    cy.get('#errorMessage').should('contain.text', message);
  }

  static verifySuccessMessage(message) {
    cy.get('#successMessage').should('contain.text', message);
  }

  static clearShipmentSearch() {
    cy.get('#shipmentSearchBar').clear();
  }
}

export default CustomerPage;