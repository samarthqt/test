class ProductCategoryPage {
  navigate() {
    cy.visit('/category/electronics');
  }

  selectProducts(productIds) {
    productIds.forEach(id => {
      cy.get(`[data-product-id="${id}"]`).click();
    });
  }

  clickCompareButton() {
    cy.get('#compare-button').click();
  }
}

class ComparisonPage {
  verifyComparisonPageDisplayed() {
    cy.url().should('include', '/comparison');
  }

  verifyProductDetails() {
    cy.get('.product-details').should('be.visible');
  }

  verifyPriceVariationsAndDiscounts() {
    cy.get('.price-variations').should('be.visible');
  }

  verifyResponsiveness() {
    cy.viewport('iphone-6');
    cy.get('.comparison-page').should('be.visible');
  }

  addToCartFromComparison() {
    cy.get('.add-to-cart').click();
  }

  removeProductFromComparison(productId) {
    cy.get(`[data-remove-id="${productId}"]`).click();
    cy.get(`[data-product-id="${productId}"]`).should('not.exist');
  }

  verifySharingOptions() {
    cy.get('.share-options').should('be.visible');
  }

  verifySortingFunctionality() {
    cy.get('.sort-options').select('Price');
    cy.get('.sorted-products').should('be.visible');
  }

  verifyPageLoadPerformance() {
    cy.window().its('performance').then((performance) => {
      expect(performance.timing.loadEventEnd - performance.timing.navigationStart).to.be.lessThan(2000);
    });
  }

  verifyBackButtonFunctionality() {
    cy.get('.back-button').click();
    cy.url().should('include', '/category/electronics');
  }

  verifyProductImagesAccuracy() {
    cy.get('.product-image').should('have.attr', 'src').and('include', 'image-path');
  }

  verifyAccessibility() {
    cy.injectAxe();
    cy.checkA11y();
  }

  verifyRealTimeDataUpdate() {
    cy.get('.real-time-update').should('be.visible');
  }
}