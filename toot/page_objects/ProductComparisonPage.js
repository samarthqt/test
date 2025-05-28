import { expect } from 'chai';

class ProductComparisonPage {

  static visit() {
    cy.visit('/product-comparison');
  }

  static selectProducts(count) {
    cy.get('.product-selection').eq(count).click();
  }

  static selectMultipleProducts() {
    cy.get('.product-selection').click({ multiple: true });
  }

  static selectDifferentAttributeProducts() {
    cy.get('.different-attributes').click();
  }

  static selectSimilarPriceProducts() {
    cy.get('.similar-price-products').click();
  }

  static selectProductFromList() {
    cy.get('.comparison-list .product-item').click();
  }

  static verifySideBySideComparison() {
    cy.get('.comparison-table').should('be.visible');
  }

  static verifyPriceDifference() {
    cy.get('.price-difference').should('be.visible');
  }

  static verifyPriceDifferences() {
    cy.get('.price-differences').should('be.visible');
  }

  static verifyNoSelection() {
    cy.get('.product-selection').should('not.be.checked');
  }

  static verifyNoSelectionMessage() {
    cy.get('.no-selection-message').should('be.visible');
  }

  static verifyNonComparableAttributes() {
    cy.get('.non-comparable-attributes').should('be.visible');
  }

  static verifySimilarPriceMessage() {
    cy.get('.similar-price-message').should('be.visible');
  }

  static verifyDetailedProductInformation() {
    cy.get('.product-detail').should('be.visible');
  }

  static verifyProductsSelected() {
    cy.get('.selected-products').should('exist');
  }

  static resetSelection() {
    cy.get('.reset-selection').click();
  }

  static verifyDeselection() {
    cy.get('.selected-products').should('not.exist');
  }

  static verifyPageReset() {
    cy.get('.comparison-page').should('be.visible');
  }
}

export default ProductComparisonPage;