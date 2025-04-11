class ProductComparisonPage {
  visitComparisonPage() {
    cy.visit('/product-comparison');
  }

  selectSimilarProducts(count) {
    for (let i = 0; i < count; i++) {
      cy.get(`.product-checkbox:eq(${i})`).check();
    }
  }

  clearProductSelection() {
    cy.get('.product-checkbox').uncheck();
  }

  selectDifferentAttributeProducts() {
    cy.get('.product-checkbox.different-attributes').check();
  }

  selectSimilarPriceProducts() {
    cy.get('.product-checkbox.similar-prices').check();
  }

  selectProductFromList() {
    cy.get('.comparison-list .product-item:first').click();
  }

  resetComparisonSelection() {
    cy.get('.reset-comparison-button').click();
  }

  verifySideBySideComparison() {
    cy.get('.comparison-table').should('be.visible');
  }

  verifyPriceDifference() {
    cy.get('.price-difference').should('be.visible');
  }

  verifyPriceDifferences() {
    cy.get('.price-differences').should('be.visible');
  }

  verifyNoProductsSelectedMessage() {
    cy.get('.no-products-message').should('be.visible');
  }

  verifyNonComparableAttributes() {
    cy.get('.non-comparable-attributes').should('be.visible');
  }

  verifySimilarPricesMessage() {
    cy.get('.similar-prices-message').should('be.visible');
  }

  verifyDetailedProductInformation() {
    cy.get('.product-details').should('be.visible');
  }

  verifyProductsDeselected() {
    cy.get('.product-checkbox').should('not.be.checked');
  }

  verifyPageReset() {
    cy.get('.comparison-table').should('not.exist');
  }
}

export default ProductComparisonPage;