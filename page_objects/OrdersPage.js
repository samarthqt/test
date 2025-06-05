import { expect } from 'chai';
import { Page } from './Page';

class OrdersPage extends Page {
  navigateToOrdersModule() {
    cy.get('#ordersModuleLink').click();
  }

  verifyOrdersModuleDisplayed() {
    cy.get('#ordersList').should('be.visible');
  }

  selectOrderById(orderId) {
    cy.get(`#order-${orderId}`).click();
  }

  verifyOrderDetailsDisplayed(orderId) {
    cy.get('#orderDetails').should('contain', orderId);
  }

  updateShipmentStatus(orderId, status) {
    cy.get(`#order-${orderId} #statusDropdown`).select(status);
    cy.get(`#order-${orderId} #updateStatusButton`).click();
  }

  verifyShipmentStatusUpdated(orderId, status) {
    cy.get(`#order-${orderId} #currentStatus`).should('contain', status);
  }

  cancelOrder(orderId) {
    cy.get(`#order-${orderId} #cancelOrderButton`).click();
    cy.get(`#order-${orderId}`).should('not.exist');
  }

  searchOrder(searchTerm) {
    cy.get('#orderSearchInput').type(searchTerm);
    cy.get('#orderSearchButton').click();
  }

  verifySearchResultsContain(searchTerm) {
    cy.get('#ordersList').should('contain', searchTerm);
  }

  applyFilter(filterType, filterValue) {
    cy.get(`#filter-${filterType}`).select(filterValue);
    cy.get('#applyFilterButton').click();
  }

  verifyFilterApplied(filterType, filterValue) {
    cy.get(`#filter-${filterType}`).should('have.value', filterValue);
  }
}

export default OrdersPage;