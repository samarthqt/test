class ShoppingCartPage {
  verifyItemsListed() {
    cy.url().should('include', '/shopping-cart');
    cy.get('.cart-item').should('have.length.greaterThan', 0);
  }

  clickProceedToCheckout() {
    cy.get('#proceed-to-checkout').click();
  }
}

class CheckoutPage {
  selectCheckoutAsGuest() {
    cy.get('#checkout-as-guest').click();
  }

  enterShippingAddress(address) {
    cy.get('#shipping-address').type(address);
  }

  selectPaymentMethod(method) {
    cy.get('#payment-method').select(method);
  }

  enterDiscountCode(code) {
    cy.get('#discount-code').type(code);
    cy.get('#apply-discount').click();
  }

  verifyDiscountApplied() {
    cy.get('.discount-applied').should('be.visible');
  }

  clickPlaceOrder() {
    cy.get('#place-order').click();
  }

  verifyOrderConfirmation() {
    cy.get('.order-confirmation').should('be.visible');
  }

  verifyOrderConfirmationEmail() {
    // Assume we have a function to check emails
    cy.checkEmail('Order Confirmation').should('exist');
  }
}