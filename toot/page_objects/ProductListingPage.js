import { expect } from 'chai';

class ProductListingPage {
  static visit() {
    cy.visit('/products');
  }

  static selectSortOption(option) {
    cy.get('#sortDropdown').select(option);
  }

  static chooseOrder(order) {
    cy.get('#orderDropdown').select(order);
  }

  static verifySorting(criteria, order) {
    cy.get('.product').should('be.sorted', { criteria, order });
  }

  static searchProduct(productName) {
    cy.get('#searchInput').type(productName);
    cy.get('#searchButton').click();
  }

  static verifyProductVisible(productName) {
    cy.get('.product-title').contains(productName).should('be.visible');
  }

  static filterByCategory(category) {
    cy.get('#categoryDropdown').select(category);
  }

  static verifyProductCount(expectedCount) {
    cy.get('.product').should('have.length', expectedCount);
  }

  static addToCart(productName) {
    cy.get('.product-title').contains(productName)
      .parents('.product')
      .find('.add-to-cart-button')
      .click();
  }

  static verifyProductInCart(productName) {
    cy.get('#cart').click();
    cy.get('.cart-item').contains(productName).should('be.visible');
  }
}

export default ProductListingPage;