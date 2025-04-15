class CheckoutPage {
  proceedToCheckout() {
    cy.get('.checkout-button').click();
  }

  checkoutAsGuest() {
    cy.get('.guest-checkout-option').click();
  }

  enterShippingAddress(address) {
    cy.get('#shipping-address').type(address);
  }

  selectPaymentMethod(method) {
    cy.get('#payment-method').select(method);
  }

  placeOrder() {
    cy.get('.place-order-button').click();
  }
}

export default CheckoutPage;