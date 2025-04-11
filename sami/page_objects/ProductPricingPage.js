class ProductPricingPage {
  visit() {
    cy.visit('/product-pricing');
  }

  selectProductWithPriceHistory() {
    cy.get('.product-list .product-item').contains('Known Price History').click();
  }

  selectProductWithPriceChanges() {
    cy.get('.product-list .product-item').contains('Price Changes').click();
  }

  selectProductWithoutPriceHistory() {
    cy.get('.product-list .product-item').contains('No Price History').click();
  }

  enableAccessibilityFeatures() {
    cy.get('.accessibility-settings').click();
  }

  viewProductDetails() {
    cy.get('.product-details-button').click();
  }

  viewPriceHistory() {
    cy.get('.price-history-button').click();
  }

  interactWithPriceHistory() {
    cy.get('.price-history-graph').trigger('mouseover');
  }

  accessPriceHistoryFeature() {
    cy.get('.price-history-access').click();
  }

  applyDateRangeFilter() {
    cy.get('.date-range-filter').select('Last 30 Days');
  }

  verifyPriceHistoryDisplayed() {
    cy.get('.price-history').should('be.visible');
  }

  verifyHistoricalPricesAndDates() {
    cy.get('.price-history .entry').should('have.length.greaterThan', 0);
  }

  verifyDiscountPeriods() {
    cy.get('.discount-periods').should('be.visible');
  }

  verifyNoPriceHistoryMessage() {
    cy.get('.no-price-history-message').should('contain', 'No price history available');
  }

  verifyChronologicalOrderDisplay() {
    cy.get('.price-history .entry').then(entries => {
      const dates = entries.map((index, entry) => Cypress.$(entry).data('date')).get();
      const isChronological = dates.every((date, index) => index === 0 || date >= dates[index - 1]);
      expect(isChronological).to.be.true;
    });
  }

  verifyDateAndPriceEntries() {
    cy.get('.price-history .entry').should('contain', 'Date').and('contain', 'Price');
  }

  verifyHoverDetails() {
    cy.get('.price-history-graph .point').trigger('mouseover').should('contain', 'Price').and('contain', 'Date');
  }

  verifyScreenReaderCompatibility() {
    cy.get('.screen-reader-compatible').should('exist');
  }

  verifyAccessibilityLabels() {
    cy.get('[aria-label]').should('have.length.greaterThan', 0);
  }

  verifyFilteredPriceHistory() {
    cy.get('.filtered-price-history').should('be.visible');
  }
}

module.exports = new ProductPricingPage();