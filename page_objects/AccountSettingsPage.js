class AccountSettingsPage {
  navigate() {
    cy.get('a[href="/account/settings"]').click();
  }

  verifyLocationServicesEnabled() {
    cy.get('#location-services-status').should('contain', 'Enabled');
  }

  changeUserLocation(location) {
    cy.get('#location-dropdown').select(location);
    cy.get('#update-location-button').click();
  }

  disableLocationServices() {
    cy.get('#location-services-toggle').click();
  }
}

class ShoppingCartPage {
  addProductToCart(price) {
    cy.get('#product-price').clear().type(price);
    cy.get('#add-to-cart-button').click();
  }

  proceedToCheckout() {
    cy.get('#checkout-button').click();
  }
}

class CheckoutPage {
  verifyTaxCalculation(taxRate, price = 100) {
    const expectedTax = price * taxRate;
    cy.get('#tax-amount').should('contain', expectedTax.toFixed(2));
  }

  verifyInternationalTaxCalculation() {
    cy.get('#tax-amount').should('contain', '0.00');
  }

  verifyTaxCalculationDisabled() {
    cy.get('#tax-amount').should('not.exist');
  }

  completePurchase() {
    cy.get('#complete-purchase-button').click();
  }
}

class OrderConfirmationPage {
  verifyOrderConfirmationEmail() {
    cy.get('#order-confirmation-email').should('contain', 'Tax details');
  }
}

export const accountSettingsPage = new AccountSettingsPage();
export const shoppingCartPage = new ShoppingCartPage();
export const checkoutPage = new CheckoutPage();
export const orderConfirmationPage = new OrderConfirmationPage();