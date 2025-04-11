class ShoppingCartPage {
  navigateToShoppingCart() {
    cy.visit('/shopping-cart');
  }

  verifyProductsInCart() {
    cy.get('.cart-product').should('have.length.greaterThan', 0);
  }

  verifyProductDetails() {
    cy.get('.cart-product').each(product => {
      cy.wrap(product).find('.product-name').should('exist');
      cy.wrap(product).find('.product-quantity').should('exist');
      cy.wrap(product).find('.product-price').should('exist');
      cy.wrap(product).find('.product-total-price').should('exist');
    });
  }

  emptyCart() {
    cy.get('.empty-cart-button').click();
  }

  verifyEmptyCartMessage() {
    cy.get('.empty-cart-message').should('be.visible');
  }

  verifyCartContainsProducts() {
    cy.get('.cart-product').should('have.length.greaterThan', 0);
  }

  updateProductQuantity() {
    cy.get('.product-quantity-input').first().clear().type('2');
    cy.get('.update-quantity-button').first().click();
  }

  verifyUpdatedQuantity() {
    cy.get('.product-quantity-input').first().should('have.value', '2');
  }

  verifyUpdatedTotalPrice() {
    // Implement logic to verify the total price is updated
  }

  removeProductFromCart() {
    cy.get('.remove-product-button').first().click();
  }

  verifyProductRemoved() {
    cy.get('.cart-product').should('have.length.lessThan', initialProductCount);
  }

  verifyTotalPriceAfterRemoval() {
    // Implement logic to verify the total price is updated after removal
  }

  proceedToCheckout() {
    cy.get('.proceed-to-checkout-button').click();
  }

  verifyCheckoutProcess() {
    cy.url().should('include', '/checkout');
  }
}

export default ShoppingCartPage;