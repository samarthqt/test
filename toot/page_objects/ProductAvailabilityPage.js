import { expect } from 'chai';

class ProductAvailabilityPage {
  static verifyOutOfStock() {
    cy.get('.product-status').should('contain', 'Out of Stock');
  }

  static subscribeUser() {
    cy.get('#subscribeButton').click();
  }

  static verifyNotSubscribed() {
    cy.get('#subscribeButton').should('not.have.class', 'subscribed');
  }

  static subscribeMultipleUsers() {
    cy.get('#subscribeButton').click({ multiple: true });
  }

  static setPreferredChannelEmail() {
    cy.get('#communicationChannel').select('Email');
  }

  static updateProductAvailability() {
    cy.get('#updateInventory').click();
  }

  static unsubscribeUser() {
    cy.get('#unsubscribeButton').click();
  }

  static verifyNotificationReceived() {
    cy.get('.notification').should('contain', 'Product is back in stock');
  }

  static verifyNoNotificationReceived() {
    cy.get('.notification').should('not.exist');
  }

  static verifyNotificationReceivedByAll() {
    cy.get('.notification').should('contain', 'Product is back in stock').and('have.length.gte', 2);
  }

  static verifyNotificationDetails() {
    cy.get('.notification').should('contain', 'Product Name').and('contain', 'Quantity Available');
  }

  static verifyEmailNotificationReceived() {
    cy.get('.email-notification').should('contain', 'Product is back in stock');
  }

  static verifyUnsubscribeNoNotification() {
    cy.get('.notification').should('not.exist');
  }
}

export default ProductAvailabilityPage;