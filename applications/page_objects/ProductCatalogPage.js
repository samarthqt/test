class ProductCatalogPage {
  enableDynamicPricing(productId) {
    cy.get(`[data-product-id="${productId}"]`).find('.dynamic-pricing-toggle').click();
  }

  setDemandChange(productId, percentage) {
    cy.get(`[data-product-id="${productId}"]`).find('.demand-change-input').type(percentage);
  }

  setStockLevel(productId, level) {
    cy.get(`[data-product-id="${productId}"]`).find('.stock-level-select').select(level);
  }

  setCompetitorPriceDrop(productId, amount) {
    cy.get(`[data-product-id="${productId}"]`).find('.competitor-price-drop-input').type(amount);
  }

  getProductPrice(productId) {
    return cy.get(`[data-product-id="${productId}"]`).find('.product-price').invoke('text').then(parseFloat);
  }

  measureResponseTime(action) {
    const start = Date.now();
    action();
    return cy.wrap(Date.now() - start);
  }

  applyExtremePricingAlgorithm(productId) {
    cy.get(`[data-product-id="${productId}"]`).find('.extreme-pricing-algorithm-btn').click();
  }
}

export default ProductCatalogPage;