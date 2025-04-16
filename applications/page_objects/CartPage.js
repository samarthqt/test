class CartPage {
  addProductToCart(productId, quantity) {
    cy.get(`[data-product-id="${productId}"] .quantity-input`).clear().type(quantity);
    cy.get(`[data-product-id="${productId}"] .add-to-cart-btn`).click();
  }

  getValidationMessage() {
    return cy.get('.validation-message');
  }

  verifyCartSummary(expectedQuantity) {
    cy.get('.cart-summary .total-quantity').should('contain', expectedQuantity);
    // Assuming price calculation logic is handled elsewhere
  }
}