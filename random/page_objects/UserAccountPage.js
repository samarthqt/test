class UserAccountPage {
  navigateToOrderHistory() {
    cy.get('#order-history-link').click();
  }

  verifyOrderList() {
    cy.get('.order-list').should('be.visible');
  }

  verifyOrderDetails() {
    cy.get('.order-details').should('contain', 'Product').and('contain', 'Price').and('contain', 'Purchase Date');
  }

  viewOrderStatus() {
    cy.get('#order-status-link').click();
  }

  verifyRealTimeStatus() {
    cy.get('.order-status').should('have.class', 'real-time');
  }

  verifyOrderStatusNotifications() {
    cy.get('.notification').should('contain', 'Order status updated');
  }

  addItemToWishlist() {
    cy.get('#add-to-wishlist').click();
  }

  verifyItemAddedToWishlist() {
    cy.get('.wishlist').should('contain', 'Item added');
  }

  verifyWishlistChangeSaved() {
    cy.get('.wishlist-save').should('be.visible');
  }

  removeItemFromWishlist() {
    cy.get('#remove-from-wishlist').click();
  }

  verifyItemRemovedFromWishlist() {
    cy.get('.wishlist').should('not.contain', 'Item removed');
  }

  performInvalidOperation() {
    cy.get('#invalid-operation').click();
  }

  verifyErrorMessage() {
    cy.get('.error-message').should('be.visible');
  }

  logUserInteractions() {
    cy.get('#log-interactions').click();
  }

  verifyInteractionsLogged() {
    cy.get('.log').should('contain', 'User interactions logged');
  }
}

module.exports = new UserAccountPage();