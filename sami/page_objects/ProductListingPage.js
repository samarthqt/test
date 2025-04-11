class ProductListingPage {
  visit() {
    cy.visit('/products');
  }

  selectSortOption(option) {
    cy.get('.sort-options').select(option);
  }

  selectSortOrder(order) {
    cy.get('.sort-order').select(order);
  }

  verifyProductsSorted(criteria, order) {
    // Implement logic to verify products are sorted correctly based on criteria and order
    // This could involve fetching product prices, popularity, or ratings and asserting the order
  }
}

export default ProductListingPage;