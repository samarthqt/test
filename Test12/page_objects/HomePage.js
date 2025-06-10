import { Selector } from 'testcafe';

class HomePage {
  static visit() {
    cy.visit('/');
  }

  static viewCategories() {
    cy.get('.categories').should('be.visible');
  }

  static verifyCategoriesLabel() {
    cy.get('.categories').each(($el) => {
      cy.wrap($el).should('have.text', 'Category Name');
    });
  }

  static clickCategory(categoryName) {
    cy.contains('.category-item', categoryName).click();
  }

  static verifyCategoryPageTitle(categoryName) {
    cy.get('h1').should('contain.text', categoryName);
  }

  static searchProduct(productName) {
    cy.get('.search-input').type(productName);
    cy.get('.search-button').click();
  }

  static verifySearchResults(productName) {
    cy.get('.product-list').should('contain.text', productName);
  }

  static addToCart(productName) {
    cy.contains('.product-item', productName).find('.add-to-cart-button').click();
  }

  static verifyProductInCart(productName) {
    cy.get('.cart-items').should('contain.text', productName);
  }

  static viewCart() {
    cy.get('.cart-icon').click();
  }

  static proceedToCheckout() {
    cy.get('.checkout-button').click();
  }

  static verifyCheckoutPage() {
    cy.url().should('include', '/checkout');
    cy.get('.checkout-title').should('be.visible');
  }
}

export default HomePage;