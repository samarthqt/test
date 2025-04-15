class ProductCatalogPage {
  verifyPageLoaded() {
    cy.get('.product-list').should('be.visible');
  }

  selectProductById(productId) {
    cy.get(`.product-item[data-id="${productId}"]`).click();
  }
}

class ProductDetailPage {
  verifyPageLoaded() {
    cy.get('.product-detail').should('be.visible');
  }

  verifyLowStockWarningDisplayed() {
    cy.get('.low-stock-warning').should('be.visible');
  }

  attemptToAddUnitsToCart(units) {
    cy.get('.quantity-input').clear().type(units);
    cy.get('.add-to-cart-button').click();
  }

  verifyStockLimitWarning() {
    cy.get('.stock-limit-warning').should('be.visible');
  }

  simulateStockLevelChange(newStockLevel) {
    cy.intercept('POST', '/update-stock', { statusCode: 200, body: { stockLevel: newStockLevel } });
  }

  verifyWarningMessageUpdates() {
    cy.get('.low-stock-warning').should('contain', 'Only 3 units left');
  }

  verifyWarningMessageResponsive() {
    cy.viewport('iphone-6');
    cy.get('.low-stock-warning').should('be.visible');
  }

  simulateStockReplenishment() {
    cy.intercept('POST', '/update-stock', { statusCode: 200, body: { stockLevel: 15 } });
  }

  verifyWarningMessageDisappears() {
    cy.get('.low-stock-warning').should('not.exist');
  }

  simulateConcurrentStockUpdates() {
    cy.intercept('POST', '/update-stock', { statusCode: 200, body: { stockLevel: 8 } });
  }

  verifyConcurrentUpdatesHandled() {
    cy.get('.low-stock-warning').should('contain', 'Only 8 units left');
  }

  simulateIncorrectStockUpdate() {
    cy.intercept('POST', '/update-stock', { statusCode: 500 });
  }

  verifyErrorHandling() {
    cy.get('.error-message').should('be.visible');
  }

  verifyIntegrationWithNotifications() {
    cy.get('.notification').should('be.visible');
  }

  verifyStockLevelAccuracy() {
    cy.get('.current-stock-level').should('contain', '5 units');
  }
}

class ShoppingCartPage {
  verifyLowStockWarningDisplayed() {
    cy.get('.cart-warning').should('be.visible');
  }
}

class CheckoutPage {
  verifyLowStockWarningDisplayed() {
    cy.get('.checkout-warning').should('be.visible');
  }

  simulatePurchase() {
    cy.intercept('POST', '/purchase', { statusCode: 200 });
  }

  verifyStockLevelUpdates() {
    cy.get('.product-detail .current-stock-level').should('contain', '3 units');
  }
}