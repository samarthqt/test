class SearchPage {
  performSearch(productName) {
    cy.get('input[name="search"]').type(`${productName}{enter}`);
  }
}

class ResultsPage {
  applyRatingFilter(minRating) {
    cy.get('.rating-filter').select(`${minRating} stars`);
  }

  verifyProductIsListed(productName) {
    cy.contains('.product-list', productName).should('be.visible');
  }
}