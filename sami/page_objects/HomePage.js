class HomePage {
  visit() {
    cy.visit('/home');
  }

  verifyPersonalizedRecommendations() {
    cy.get('.recommendations').should('be.visible');
  }

  verifyRecommendationsBasedOnHistory() {
    cy.get('.recommendations').should('contain', 'Based on your history');
  }

  verifyNoRecommendations() {
    cy.get('.recommendations').should('not.exist');
  }

  verifyExploreProductsMessage() {
    cy.get('.explore-message').should('be.visible');
  }

  interactWithProduct() {
    cy.get('.product-item').first().click();
  }

  verifyUpdatedRecommendations() {
    cy.get('.recommendations').should('contain', 'Recently viewed');
  }

  viewPersonalizedRecommendations() {
    cy.get('.personalized-recommendations').click();
  }

  verifyRecommendationsFromSimilarUsers() {
    cy.get('.recommendations').should('contain', 'Popular among similar users');
  }

  verifyNoPersonalizedRecommendations() {
    cy.get('.personalized-recommendations').should('not.exist');
  }

  verifyOptInOption() {
    cy.get('.opt-in-option').should('be.visible');
  }
}

class ProductDetailPage {
  visit() {
    cy.visit('/product-detail');
  }

  scrollDown() {
    cy.scrollTo('bottom');
  }

  verifyAdditionalRecommendations() {
    cy.get('.additional-recommendations').should('be.visible');
  }

  verifyRelatedRecommendations() {
    cy.get('.related-recommendations').should('contain', 'Related to this product');
  }
}