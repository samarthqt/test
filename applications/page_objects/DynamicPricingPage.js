class DynamicPricingPage {
  simulateDemandDataFailure(productId) {
    cy.intercept('GET', `/api/demand/${productId}`, { statusCode: 500 }).as('demandData');
    cy.visit(`/product/${productId}`);
    cy.wait('@demandData');
  }

  simulateStockDataFailure(productId) {
    cy.intercept('GET', `/api/stock/${productId}`, { statusCode: 500 }).as('stockData');
    cy.visit(`/product/${productId}`);
    cy.wait('@stockData');
  }

  simulateCompetitorPricingDataFailure(productId) {
    cy.intercept('GET', `/api/competitor-pricing/${productId}`, { statusCode: 500 }).as('competitorData');
    cy.visit(`/product/${productId}`);
    cy.wait('@competitorData');
  }

  applyDynamicPricingWithMissingParams(productId) {
    cy.visit(`/product/${productId}`);
    cy.get('#apply-dynamic-pricing').click();
  }

  verifyPrice(productId, expectedPrice) {
    cy.get(`#product-price-${productId}`).should('contain', expectedPrice);
  }

  verifyErrorLog(expectedError) {
    cy.get('#system-logs').should('contain', expectedError);
  }

  verifyErrorMessage(expectedMessage) {
    cy.get('.error-message').should('contain', expectedMessage);
  }

  verifySystemLogsForErrors() {
    cy.get('#system-logs').should('exist');
  }
}