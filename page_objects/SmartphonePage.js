class SmartphonePage {
  navigateToSmartphone() {
    cy.visit('/product/smartphone');
  }

  selectQuantity(quantity) {
    cy.get('select#quantity').select(quantity.toString());
  }

  addToCart() {
    cy.get('button#add-to-cart').click();
  }
}

class HeadphonesPage {
  navigateToHeadphones() {
    cy.visit('/product/headphones');
  }

  selectQuantity(quantity) {
    cy.get('select#quantity').select(quantity.toString());
  }

  addToCart() {
    cy.get('button#add-to-cart').click();
  }
}

class CartPage {
  navigateToCart() {
    cy.visit('/cart');
  }

  verifyProductInCart(productName, quantity) {
    cy.get('.cart-item').should('contain', productName);
    cy.get('.cart-item-quantity').should('contain', quantity.toString());
  }
}