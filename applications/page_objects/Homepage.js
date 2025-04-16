class Homepage {
  verifyFlashSaleBanner() {
    cy.get('.flash-sale-banner').should('be.visible');
  }
}

class ProductPage {
  navigateToProductPage(productId) {
    cy.visit(`/product/${productId}`);
  }

  verifyDiscountedPrice(discount) {
    cy.get('.product-price').should('contain', `-${discount}%`);
  }

  addToCart() {
    cy.get('.add-to-cart-button').click();
  }
}

class CartPage {
  verifyDiscountedPrice(discount) {
    cy.get('.cart-price').should('contain', `-${discount}%`);
  }

  proceedToCheckout() {
    cy.get('.checkout-button').click();
  }
}

class CheckoutPage {
  verifyDiscountedPriceAndTotal() {
    cy.get('.checkout-price').should('contain', '-20%');
    cy.get('.total-amount').should('be.visible');
  }

  completePurchase() {
    cy.get('.complete-purchase-button').click();
  }

  verifyOrderCompletion() {
    cy.get('.order-confirmation').should('be.visible');
  }
}