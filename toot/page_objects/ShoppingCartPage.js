import { expect } from 'chai';

class ShoppingCartPage {
  static visit() {
    cy.visit('/shopping-cart');
  }

  static verifyProductsInCart() {
    cy.get('.cart-item').should('have.length.greaterThan', 0);
  }

  static verifyProductDetails() {
    cy.get('.cart-item').each(($el) => {
      cy.wrap($el).find('.product-name').should('exist');
      cy.wrap($el).find('.quantity').should('exist');
      cy.wrap($el).find('.price').should('exist');
      cy.wrap($el).find('.total-price').should('exist');
    });
  }

  static emptyCart() {
    cy.get('.empty-cart-button').click();
    this.verifyEmptyCartMessage();
  }

  static verifyEmptyCartMessage() {
    cy.get('.empty-cart-message').should('be.visible');
  }

  static updateProductQuantity(productName, quantity) {
    cy.get('.cart-item').contains(productName).parent().find('.quantity-input').clear().type(quantity);
    cy.get('.update-quantity-button').click();
    this.verifyUpdatedQuantity(productName, quantity);
  }

  static verifyUpdatedQuantity(productName, quantity) {
    cy.get('.cart-item').contains(productName).parent().find('.quantity').should('have.text', quantity);
  }

  static verifyTotalPrice() {
    let totalPrice = 0;
    cy.get('.cart-item').each(($el) => {
      const price = parseFloat($el.find('.price').text().replace('$', ''));
      const quantity = parseInt($el.find('.quantity').text());
      totalPrice += price * quantity;
    }).then(() => {
      cy.get('.total-price').should(($el) => {
        const displayedTotalPrice = parseFloat($el.text().replace('$', ''));
        expect(displayedTotalPrice).to.equal(totalPrice);
      });
    });
  }

  static removeProduct(productName) {
    cy.get('.cart-item').contains(productName).parent().find('.remove-button').click();
    this.verifyProductRemoved(productName);
  }

  static verifyProductRemoved(productName) {
    cy.get('.cart-item').contains(productName).should('not.exist');
  }

  static proceedToCheckout() {
    cy.get('.checkout-button').click();
  }
}

export default ShoppingCartPage;