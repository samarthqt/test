class ProductPage {
  visit() {
    cy.visit('/product-page');
  }

  selectProduct() {
    cy.get('.product-item').first().click();
  }

  addToCart() {
    cy.get('.add-to-cart-button').click();
  }
}

class ShoppingCartPage {
  visit() {
    cy.visit('/shopping-cart');
  }

  checkProductInCart(productName) {
    cy.get('.shopping-cart').should('contain', productName);
  }

  removeProduct() {
    cy.get('.remove-product-button').first().click();
  }

  modifyProductQuantity(quantity) {
    cy.get('.product-quantity-input').clear().type(quantity);
    cy.get('.update-quantity-button').click();
  }

  saveChanges() {
    cy.get('.save-changes-button').click();
  }

  checkNotification(message) {
    cy.get('.notification').should('contain', message);
  }

  checkErrorMessage() {
    cy.get('.error-message').should('be.visible');
  }

  checkLogEntry(entry) {
    cy.get('.log-entry').should('contain', entry);
  }

  checkCartDetails() {
    cy.get('.shopping-cart').within(() => {
      cy.get('.product-name').should('be.visible');
      cy.get('.product-price').should('be.visible');
      cy.get('.product-quantity').should('be.visible');
      cy.get('.product-subtotal').should('be.visible');
    });
  }
}