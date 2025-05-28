import { Selector } from 'testcafe';

class OrderPage {
  constructor() {
    this.orderList = Selector('.order-list');
    this.orderDetails = Selector('.order-details');
    this.initiateReturnButton = Selector('#initiateReturnButton');
    this.returnExpiredMessage = Selector('.return-expired-message');
  }

  visit() {
    cy.visit('/orders');
  }

  selectOrder(orderID) {
    cy.contains(orderID).click();
  }

  verifyOrderDetails(orderID) {
    cy.url().should('include', `/orders/${orderID}`);
    cy.get(this.orderDetails).should('be.visible');
  }

  verifyInitiateReturnDisabled() {
    cy.get(this.initiateReturnButton).should('be.disabled');
  }

  verifyReturnPeriodExpiredMessage() {
    cy.get(this.returnExpiredMessage).should('be.visible');
  }

  filterOrders(filterCriteria) {
    cy.get('.filter-input').type(filterCriteria);
    cy.get('.filter-button').click();
  }

  sortOrders(sortOption) {
    cy.get('.sort-dropdown').select(sortOption);
  }

  verifyOrderInList(orderID) {
    cy.get(this.orderList).contains(orderID).should('be.visible');
  }

  verifyOrderNotInList(orderID) {
    cy.get(this.orderList).contains(orderID).should('not.exist');
  }
}

export default OrderPage;