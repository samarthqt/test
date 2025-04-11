class GuestCheckoutPage {
  verifyItemsInCart() {
    cy.get('.cart-items').should('exist');
  }

  selectCheckoutAsGuest() {
    cy.get('#checkout-as-guest').click();
  }

  enterShippingInformation(type) {
    if (type === 'valid') {
      cy.get('#shipping-address').type('123 Main St');
      cy.get('#shipping-city').type('Anytown');
      cy.get('#shipping-zip').type('12345');
    } else {
      cy.get('#shipping-address').type('');
      cy.get('#shipping-city').type('');
      cy.get('#shipping-zip').type('');
    }
  }

  enterPaymentInformation(type) {
    if (type === 'valid') {
      cy.get('#payment-card-number').type('4111111111111111');
      cy.get('#payment-expiry').type('12/23');
      cy.get('#payment-cvc').type('123');
    } else {
      cy.get('#payment-card-number').type('');
      cy.get('#payment-expiry').type('');
      cy.get('#payment-cvc').type('');
    }
  }

  reviewOrderSummary() {
    cy.get('#order-summary').should('be.visible');
  }

  confirmPurchase() {
    cy.get('#confirm-purchase').click();
  }

  leaveFieldsEmpty() {
    cy.get('#shipping-address').clear();
    cy.get('#payment-card-number').clear();
  }

  cancelCheckout() {
    cy.get('#cancel-checkout').click();
  }

  enterPromotionalCode(code) {
    cy.get('#promo-code').type(code);
    cy.get('#apply-promo').click();
  }

  verifyConfirmationMessage() {
    cy.get('.confirmation-message').should('be.visible');
  }

  verifyOrderPlacement() {
    cy.get('.order-success').should('exist');
  }

  verifyShippingErrorMessage() {
    cy.get('.shipping-error').should('be.visible');
  }

  promptCorrectShippingInformation() {
    cy.get('.correct-shipping-prompt').should('be.visible');
  }

  verifyPaymentErrorMessage() {
    cy.get('.payment-error').should('be.visible');
  }

  promptCorrectPaymentInformation() {
    cy.get('.correct-payment-prompt').should('be.visible');
  }

  verifyMissingInfoErrorMessage() {
    cy.get('.missing-info-error').should('be.visible');
  }

  promptCompleteRequiredFields() {
    cy.get('.complete-fields-prompt').should('be.visible');
  }

  verifyRedirectToCart() {
    cy.url().should('include', '/cart');
  }

  verifyDiscountApplied() {
    cy.get('.discount-applied').should('be.visible');
  }
}

export default GuestCheckoutPage;