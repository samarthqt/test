class ProductPage {
  navigateToProductBundles() {
    cy.visit('/product-bundles');
  }

  selectProductBundle(bundleName) {
    cy.contains(bundleName).click();
  }

  verifyBundleDetailsDisplayed() {
    cy.get('.bundle-details').should('be.visible');
    cy.get('.discounted-price').should('be.visible');
  }

  addToCart() {
    cy.get('.add-to-cart-button').click();
  }
}

class CartPage {
  navigateToCart() {
    cy.visit('/cart');
  }

  verifyBundleInCart(bundleName) {
    cy.contains(bundleName).should('be.visible');
    cy.get('.discounted-price').should('be.visible');
  }

  proceedToCheckout() {
    cy.get('.checkout-button').click();
  }
}

class CheckoutPage {
  selectPaymentMethod(method) {
    cy.get('.payment-method').select(method);
  }

  placeOrder() {
    cy.get('.place-order-button').click();
  }

  verifyOrderConfirmation() {
    cy.get('.confirmation-message').should('be.visible');
  }
}