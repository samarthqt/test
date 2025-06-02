import { expect } from 'chai';

class ProductDetailsPage {

  static visit() {
    cy.visit('/product-details');
  }

  static verifyPageOpened() {
    cy.url().should('include', '/product-details');
  }

  static locateReviewsSection() {
    cy.get('.reviews-section').scrollIntoView();
  }

  static verifyReviewsSectionVisible() {
    cy.get('.reviews-section').should('be.visible');
  }

  static otherUsersView() {
    cy.reload();
  }

  static verifyRatingAndReviewVisible() {
    cy.get('.submitted-review').should('be.visible');
  }

  static verifyReviewsVisibleToOthers() {
    cy.get('.review-item').should('be.visible');
  }

  static verifyProductTitleVisible() {
    cy.get('.product-title').should('be.visible');
  }

  static verifyProductPriceVisible() {
    cy.get('.product-price').should('be.visible');
  }

  static addToCart() {
    cy.get('.add-to-cart-button').click();
  }

  static verifyProductAddedToCart() {
    cy.get('.cart-items').should('contain', '1 item');
  }

  static verifyProductDescriptionVisible() {
    cy.get('.product-description').should('be.visible');
  }

  static verifyProductImagesVisible() {
    cy.get('.product-image').should('be.visible');
  }

  static selectProductOption(option) {
    cy.get('.product-options').select(option);
  }

  static verifySelectedOptionVisible(option) {
    cy.get('.selected-option').should('contain', option);
  }
}

export default ProductDetailsPage;