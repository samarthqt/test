class ShoppingCartPage {
  verifyPageDisplayed() {
    cy.contains('Shopping Cart').should('be.visible');
  }

  proceedToCheckout() {
    cy.get('button').contains('Proceed to Checkout').click();
  }
}

class CheckoutPage {
  verifyCheckoutPageDisplayed() {
    cy.contains('Checkout').should('be.visible');
  }

  selectGuestCheckout() {
    cy.get('input[type="radio"]').check('guest');
  }

  verifyGuestCheckoutFormDisplayed() {
    cy.contains('Guest Checkout Form').should('be.visible');
  }

  enterShippingAddress(street, city) {
    cy.get('input[name="street"]').type(street);
    cy.get('input[name="city"]').type(city);
  }

  verifyShippingAddressDisplayed() {
    cy.contains('123 Test St').should('be.visible');
    cy.contains('Testville').should('be.visible');
  }

  selectShippingMethod(method) {
    cy.get('select[name="shippingMethod"]').select(method);
  }

  enterPaymentDetails(cardNumber, expiry, cvv) {
    cy.get('input[name="cardNumber"]').type(cardNumber);
    cy.get('input[name="expiry"]').type(expiry);
    cy.get('input[name="cvv"]').type(cvv);
  }

  verifyPaymentDetailsDisplayed() {
    cy.contains('**** **** **** 1111').should('be.visible');
  }

  reviewOrderSummary() {
    cy.contains('Order Summary').should('be.visible');
  }

  placeOrder() {
    cy.get('button').contains('Place Order').click();
  }

  verifyOrderPlaced() {
    cy.contains('Order Confirmation').should('be.visible');
  }
}