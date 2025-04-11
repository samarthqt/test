class ProductPage {
  selectProduct() {
    cy.get('.product-item').first().click();
  }

  clickAddToCart() {
    cy.get('.add-to-cart-button').click();
  }

  selectMultipleProducts() {
    cy.get('.product-item').each(($el) => {
      cy.wrap($el).click();
    });
  }

  clickAddToCartForEach() {
    cy.get('.product-item').each(($el) => {
      cy.wrap($el).find('.add-to-cart-button').click();
    });
  }

  clickAddToCartMultipleTimes() {
    cy.get('.add-to-cart-button').click().click().click();
  }

  addProductToCart() {
    this.selectProduct();
    this.clickAddToCart();
  }

  selectOutOfStockProduct() {
    cy.get('.product-item.out-of-stock').click();
  }
}

class CartPage {
  verifyProductAdded() {
    cy.get('.cart-items').should('contain', 'Product Name');
  }

  verifyCartDisplay() {
    cy.get('.cart-items').should('be.visible');
  }

  verifyMultipleProductsAdded() {
    cy.get('.cart-items').should('contain', 'Multiple Products');
  }

  verifyCartDisplayMultiple() {
    cy.get('.cart-items').should('have.length', 3);
  }

  verifyCorrectQuantity() {
    cy.get('.cart-item-quantity').should('have.text', '3');
  }

  navigateToCart() {
    cy.get('.cart-link').click();
  }

  verifyAllProductsListed() {
    cy.get('.cart-items').should('contain', 'All Products');
  }

  verifyTotalCost() {
    cy.get('.total-cost').should('have.text', '$100');
  }

  verifyLoginPrompt() {
    cy.get('.login-prompt').should('be.visible');
  }

  verifyOutOfStockNotification() {
    cy.get('.notification').should('contain', 'Out of Stock');
  }

  verifyProductNotAdded() {
    cy.get('.cart-items').should('not.contain', 'Out of Stock Product');
  }
}